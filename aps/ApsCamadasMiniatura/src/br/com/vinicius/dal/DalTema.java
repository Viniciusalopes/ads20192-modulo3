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
 *  Camada de acesso a dados da tabela [Temas]
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import br.com.vinicius.generic.DalGeneric;
import br.com.vinicius.model.Tema;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author vovostudio
 */
public class DalTema extends DalGeneric {

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DalTema() throws Exception {
        super("\"Temas\"", "tema_id", "tema_nome");
        sql = "SELECT * FROM " + table + " ";
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(Tema tema) throws Exception {
        String sql = "INSERT INTO " + table + " (tema_nome) VALUES (?);";
        args = new Object[]{tema.getTema_nome()};
        execute(sql, args);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    @Override
    protected ArrayList<Tema> build(ResultSet rs) throws Exception {
        ArrayList<Tema> ret = new ArrayList<>();
        while (rs.next()) {
            ret.add(new Tema(rs.getInt("tema_id"), rs.getString("tema_nome")));
        }
        return ret;
    }

    public Tema getById(int id) throws Exception {
        return (Tema) getBy(fieldIdColumn, id).get(0);
    }

    public Tema getByNome(String nome) throws Exception {
        return (Tema) getBy("tema_nome", nome).get(0);
    }

    public boolean exists(int id) throws Exception {
        return exists(id, "tema_id");
    }

    public boolean isEmptyTable() throws Exception {
        return isEmptyTable(table);
    }
    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //

    public void update(Tema tema) throws Exception {
        String sql = "UPDATE " + table + " SET tema_nome = ? WHERE tema_id = ?;";
        args = new Object[]{tema.getTema_nome(), tema.getTema_id()};
        execute(sql, args);
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
}
