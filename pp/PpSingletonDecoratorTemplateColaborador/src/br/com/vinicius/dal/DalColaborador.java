/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 10/10/2020 19:29:11 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Acesso a dados da tabela [colaboradores].
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import br.com.vinicius.bll.BllHabilidade;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.vinicius.model.Colaborador;
import br.com.vinicius.model.Habilidade;

/**
 *
 * @author vovostudio
 */
public class DalColaborador extends br.com.vinicius.generic.dal.DalGeneric {

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DalColaborador() throws Exception {
        super("colaboradores");
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    @Override
    protected ArrayList<?> build(ResultSet rs) throws Exception {
        ArrayList<Colaborador> ret = new ArrayList<>();
        while (rs.next()) {
            Colaborador colaborador = new Colaborador();
            colaborador.setId(rs.getInt("colaborador_id"));
            colaborador.setNome(rs.getString("colaborador_nome"));
            colaborador.setSetor_id(rs.getInt("colaborador_setor_id"));
            ret.add(colaborador);
        }
        return ret;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(Colaborador colaborador) throws Exception {
        sql = "INSERT INTO colaboradores (colaborador_nome, colaborador_setor_id) VALUES (?,?)";
        args = new Object[]{colaborador.getNome(), colaborador.getSetor_id()};
        execute();
        colaborador.setId(getColaborador(colaborador.getNome(), colaborador.getSetor_id()).getId());
        insertHabilidades(colaborador.getHabilidades(), colaborador.getId());
    }

    public void insertHabilidades(ArrayList<Habilidade> habilidades, int colaborador_id) throws Exception {
        sql = "INSERT INTO habilidades_colaborador (habilidade_id, colaborador_id) VALUES (?,?) "
                + "ON CONFLICT (habilidade_id, colaborador_id) DO NOTHING";

        for (Habilidade h : habilidades) {
            args = new Object[]{h.getId(), colaborador_id};
            execute();
        }
    }

    

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public Colaborador getColaborador(int colaborador_id) throws Exception {
        sql = "SELECT * FROM colaboradores WHERE colaborador_id = ?";
        args = new Object[]{colaborador_id};
        Colaborador colaborador = (Colaborador) select().get(0);
        colaborador.setHabilidades(BllHabilidade.getHabilidades(colaborador.getId()));
        return colaborador;
    }

    public Colaborador getColaborador(String nome, int setor_id) throws Exception {
        sql = "SELECT * FROM colaboradores WHERE colaborador_nome = ? AND colaborador_setor_id = ?";
        args = new Object[]{nome, setor_id};
        Colaborador colaborador = (Colaborador) select().get(0);
        colaborador.setHabilidades(BllHabilidade.getHabilidades(colaborador.getId()));
        return colaborador;
    }

    public ArrayList<Colaborador> getColaboradores(int setor_id) throws Exception {
        sql = "SELECT * FROM colaboradores WHERE colaborador_setor_id = ? ORDER BY colaborador_nome";
        args = new Object[]{setor_id};
        ArrayList<Colaborador> colaboradores = (ArrayList<Colaborador>) select();
        for (Colaborador colaborador : colaboradores) {
            colaborador.setHabilidades(BllHabilidade.getHabilidades(colaborador.getId()));
        }
        return colaboradores;
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Colaborador colaborador) throws Exception {
        sql = "UPDATE colaboradores SET colaborador_nome = ?, colaborador_setor_id = ? "
                + "WHERE colaborador_id = ?";
        args = new Object[]{colaborador.getNome(), colaborador.getSetor_id(), colaborador.getId()};
        execute();

        deleteHabilidades(colaborador.getId());
        insertHabilidades(colaborador.getHabilidades(), colaborador.getId());
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int colaborador_id) throws Exception {
        deleteHabilidades(colaborador_id);
        sql = "DELETE FROM colaboradores WHERE colaborador_id = ?";
        args = new Object[]{colaborador_id};
        execute();
        
    }

    public void deleteHabilidade(int habilidade_id, int colaborador_id) throws Exception{
        sql = "DELETE FROM habilidades_colaborador WHERE habilidade_id = ? AND colaborador_id = ?";
        args = new Object[]{habilidade_id, colaborador_id};
        execute();
    }
    
    public void deleteHabilidades(int colaborador_id) throws Exception {
        sql = "DELETE FROM habilidades_colaborador WHERE colaborador_id = ?";
        args = new Object[]{colaborador_id};
        execute();
    }
    
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
