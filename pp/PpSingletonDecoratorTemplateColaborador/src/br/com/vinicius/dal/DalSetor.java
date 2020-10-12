/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 10/10/2020 19:29:11 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Propósito do arquivo.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.vinicius.model.Setor;

/**
 *
 * @author vovostudio
 */
public class DalSetor extends br.com.vinicius.generic.dal.DalGeneric {

    public DalSetor() throws Exception {
        super("setores");
    }

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    @Override
    protected ArrayList<?> build(ResultSet rs) throws Exception {
        ArrayList<Setor> ret = new ArrayList<>();
        while (rs.next()) {
            Setor setor = new Setor();
            setor.setId(rs.getInt("setor_id"));
            setor.setNome(rs.getString("setor_nome"));
            setor.setEmpresa_id(rs.getInt("setor_empresa_id"));
            ret.add(setor);
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
    public void add(Setor setor) throws Exception {
        sql = "INSERT INTO setores (setor_nome, setor_empresa_id) VALUES (?, ?)";
        args = new Object[]{setor.getNome(), setor.getEmpresa_id()};
        execute();
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    public boolean exists(Setor setor) throws Exception {
        return exists("setor_nome", setor.getNome());
    }

    //--- READ ------------------------------------------------------------------------------------>
    //
    public Setor getSetor(int id) throws Exception {
        sql = "SELECT * FROM setores WHERE setor_id = ? ";
        args = new Object[]{id};
        return (Setor) select().get(0);
    }

    public Setor getSetor(String nome, int empresa_id) throws Exception {
        sql = "SELECT * FROM setores WHERE setor_nome = ? AND setor_empresa_id = ?";
        args = new Object[]{nome, empresa_id};
        return (Setor) select().get(0);
    }

    public ArrayList<Setor> getSetores(int empresa_id) throws Exception {
        sql = "SELECT * FROM setores WHERE setor_empresa_id = ? ORDER BY setor_nome";
        args = new Object[]{empresa_id};
        return (ArrayList<Setor>) select();
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Setor setor) throws Exception {
        sql = "UPDATE setores SET setor_nome = ?, setor_empresa_id = ? "
                + "WHERE setor_id = ?";
        args = new Object[]{setor.getNome(), setor.getEmpresa_id(), setor.getId()};
        execute();
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int setor_id) throws Exception {
        sql = "DELETE FROM setores WHERE setor_id = ?";
        args = new Object[]{setor_id};
        execute();
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
