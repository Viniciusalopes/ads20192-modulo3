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

import br.com.vinicius.model.Fabricante;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author vovostudio
 */
public class FabricanteDal extends GenericDal {

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public FabricanteDal() throws Exception {
        super("\"Fabricantes\"", "fabricante_id");
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(Fabricante fabricante) throws Exception {
        sql = "INSERT INTO " + table + " (fabricante_nome) VALUES (?);";
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

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Fabricante fabricante) throws Exception {
        sql = "UPDATE " + table + " SET fabricante_nome = ? WHERE fabricante_id = ?;";
        args = new Object[]{fabricante.getFabricante_nome(), fabricante.getFabricante_id()};
        execute(sql, args);
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
}
