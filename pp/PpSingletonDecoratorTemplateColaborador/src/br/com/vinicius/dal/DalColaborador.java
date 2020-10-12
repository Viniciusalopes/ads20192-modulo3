/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 10/10/2020 19:29:11 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Propósito do arquivo.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.vinicius.model.Colaborador;

/**
 *
 * @author vovostudio
 */
public class DalColaborador extends br.com.vinicius.generic.dal.DalGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
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
    //--- SET ------------------------------------------------------------------------------------->
    //
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(Colaborador colaborador) throws Exception {
        sql = "INSERT INTO colaboradores (colaborador_nome, colaborador_setor_id) VALUES (?,?)";
        args = new Object[]{colaborador.getNome(), colaborador.getSetor_id()};
        execute();
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public Colaborador getColaborador(int colaborador_id) throws Exception {
        sql = "SELECT * FROM colaboradores WHERE colaborador_id = ?";
        args = new Object[]{colaborador_id};
        return (Colaborador) select().get(0);
    }

    public ArrayList<Colaborador> getColaboradores(int setor_id) throws Exception {
        sql = "SELECT * FROM colaboradores WHERE colaborador_setor_id = ? ORDER BY colaborador_nome";
        args = new Object[]{setor_id};
        return (ArrayList<Colaborador>) select();
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
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int colaborador_id) throws Exception {
        sql = "DELETE FROM colaboradores WHERE colaborador_id = ?";
        args = new Object[]{colaborador_id};
        execute();
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
