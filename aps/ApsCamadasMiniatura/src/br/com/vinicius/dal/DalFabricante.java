/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 29/09/2020 08:25:59 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Camada de acesso a dados da tabela [Fabricantes]
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import br.com.vinicius.generic.DalGeneric;
import br.com.vinicius.model.Fabricante;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author vovostudio
 */
public class DalFabricante extends DalGeneric {

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DalFabricante() throws Exception {
        super("\"Fabricantes\"", "fabricante_id", "fabricante_nome");
        sql = "SELECT * FROM " + table + " ";
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(Fabricante fabricante) throws Exception {
        String sql = "INSERT INTO " + table + " (fabricante_nome) VALUES (?);";
        args = new Object[]{fabricante.getFabricante_nome()};
        execute(sql, args);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    @Override
    protected ArrayList<Fabricante> build(ResultSet rs) throws Exception {
        ArrayList<Fabricante> ret = new ArrayList<>();
        while (rs.next()) {
            ret.add(new Fabricante(rs.getInt("fabricante_id"), rs.getString("fabricante_nome")));
        }
        return ret;
    }

    public Fabricante getById(int id) throws Exception {
        return (Fabricante) getBy(fieldIdColumn, id).get(0);
    }

    public Fabricante getByNome(String nome) throws Exception {
        return (Fabricante) getBy("fabricante_nome", nome).get(0);
    }

    public boolean exists(int id) throws Exception {
        return exists(id, "fabricante_id");
    }

    public boolean isEmptyTable() throws Exception {
        return isEmptyTable(table);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Fabricante fabricante) throws Exception {
        String sql = "UPDATE " + table + " SET fabricante_nome = ? WHERE fabricante_id = ?;";
        args = new Object[]{fabricante.getFabricante_nome(), fabricante.getFabricante_id()};
        execute(sql, args);
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
}
