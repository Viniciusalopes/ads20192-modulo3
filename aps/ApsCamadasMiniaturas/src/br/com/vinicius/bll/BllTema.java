/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 13/10/2020 08:11:13 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Regras de negócio e consultas à dal.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.bll;

import br.com.vinicius.dal.DalTema;
import br.com.vinicius.model.Tema;
import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public class BllTema {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static DalTema dal = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    private static void initDal() throws Exception {
        if (dal == null) {
            dal = new DalTema();
        }
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public static void add(Tema tema) throws Exception {
        if (exists(tema)) {
            throw new Exception("Já existe um Tema com este nome!");
        }
        dal.add(tema);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public static boolean exists(Tema tema) throws Exception {
        initDal();
        return dal.exists(tema);
    }

    public static ArrayList<Tema> get() throws Exception {
        initDal();
        return dal.get();
    }

    public static Tema get(int id) throws Exception {
        initDal();
        return dal.get(id);
    }

    public static Tema get(String nome) throws Exception {
        initDal();
        return dal.get(nome);
    }
    //--- FIM READ --------------------------------------------------------------------------------|
    //

    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public static void update(Tema tema) throws Exception {
        if (exists(tema)) {
            throw new Exception("Já existe um Tema com este nome!");
        }
        dal.update(tema);
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public static void delete(int id) throws Exception {
        initDal();
        dal.delete(id);
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //

}
