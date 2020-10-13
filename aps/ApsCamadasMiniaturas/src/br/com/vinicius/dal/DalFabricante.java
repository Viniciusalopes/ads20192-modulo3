/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 13/10/2020 07:53:02 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Acesso a dados da tabela [fabricantes].
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import br.com.vinicius.generic.DalGeneric;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.vinicius.model.Fabricante;

/**
 *
 * @author vovostudio
 */
public class DalFabricante extends DalGeneric {

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DalFabricante() throws Exception {
        super("fabricantes");
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    @Override
    protected ArrayList<?> build(ResultSet rs) throws Exception {
        ArrayList<Fabricante> ret = new ArrayList<>();
        while (rs.next()) {
            Fabricante fabricante = new Fabricante();
            fabricante.setId(rs.getInt("fabricante_id"));
            fabricante.setNome(rs.getString("fabricante_nome"));
            ret.add(fabricante);
        }
        return ret;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(Fabricante fabricante) throws Exception {
        sql = "INSERT INTO fabricantes (fabricante_nome) VALUES (?)";
        args = new Object[]{fabricante.getNome()};
        execute();
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public boolean exists(Fabricante fabricante) throws Exception {
        return exists(new String[]{"fabricante_nome", "fabricante_id"}, new Object[]{fabricante.getNome(), fabricante.getId()});
    }

    public ArrayList<Fabricante> get() throws Exception {
        sql = "SELECT * FROM fabricantes";
        args = new Object[]{};
        return (ArrayList<Fabricante>) select();
    }

    public Fabricante get(int id) throws Exception {
        sql = "SELECT * FROM fabricantes WHERE fabricante_id = ? ";
        args = new Object[]{id};
        return (Fabricante) select().get(0);
    }

    public Fabricante get(String nome) throws Exception {
        sql = "SELECT * FROM fabricantes WHERE fabricante_nome = ?";
        args = new Object[]{nome};
        return (Fabricante) select().get(0);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Fabricante fabricante) throws Exception {
        sql = "UPDATE fabricantes SET fabricante_nome = ? WHERE fabricante_id = ?";
        args = new Object[]{fabricante.getNome(), fabricante.getId()};
        execute();
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int id) throws Exception {
        sql = "DELETE FROM fabricantes WHERE fabricante_id = ?";
        args = new Object[]{id};
        execute();
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
