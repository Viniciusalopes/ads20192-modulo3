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
 *  Acesso a dados da tabela [temas].
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import br.com.vinicius.generic.DalGeneric;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.vinicius.model.Tema;

/**
 *
 * @author vovostudio
 */
public class DalTema extends DalGeneric {

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DalTema() throws Exception {
        super("temas");
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    @Override
    protected ArrayList<?> build(ResultSet rs) throws Exception {
        ArrayList<Tema> ret = new ArrayList<>();
        while (rs.next()) {
            Tema tema = new Tema();
            tema.setId(rs.getInt("tema_id"));
            tema.setNome(rs.getString("tema_nome"));
            ret.add(tema);
        }
        return ret;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(Tema tema) throws Exception {
        sql = "INSERT INTO temas (tema_nome) VALUES (?)";
        args = new Object[]{tema.getNome()};
        execute();
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public boolean exists(Tema tema) throws Exception {
        return exists(new String[]{"tema_nome", "tema_id"}, new Object[]{tema.getNome(), tema.getId()});
    }

    public ArrayList<Tema> get() throws Exception {
        sql = "SELECT * FROM temas";
        args = new Object[]{};
        return (ArrayList<Tema>) select();
    }

    public Tema get(int id) throws Exception {
        sql = "SELECT * FROM temas WHERE tema_id = ? ";
        args = new Object[]{id};
        return (Tema) select().get(0);
    }

    public Tema get(String nome) throws Exception {
        sql = "SELECT * FROM temas WHERE tema_nome = ?";
        args = new Object[]{nome};
        return (Tema) select().get(0);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Tema tema) throws Exception {
        sql = "UPDATE temas SET tema_nome = ? WHERE tema_id = ?";
        args = new Object[]{tema.getNome(), tema.getId()};
        execute();
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int id) throws Exception {
        sql = "DELETE FROM temas WHERE tema_id = ?";
        args = new Object[]{id};
        execute();
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
