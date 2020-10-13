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

import br.com.vinicius.dal.DalMiniatura;
import br.com.vinicius.model.Miniatura;
import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public class BllMiniatura {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static DalMiniatura dal = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    private static void initDal() throws Exception {
        if (dal == null) {
            dal = new DalMiniatura();
        }
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public static void add(Miniatura miniatura) throws Exception {
        if (exists(miniatura)) {
            throw new Exception("Já existe uma Miniatura com as mesmas características!");
        }
        dal.add(miniatura);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public static boolean exists(Miniatura miniatura) throws Exception {
        initDal();
        return dal.exists(miniatura);
    }

    public static ArrayList<Miniatura> get() throws Exception {
        initDal();
        return dal.get();
    }

    public static Miniatura get(int id) throws Exception {
        initDal();
        return dal.get(id);
    }

    public static Miniatura get(String nome) throws Exception {
        initDal();
        return dal.get(nome);
    }
    //--- FIM READ --------------------------------------------------------------------------------|
    //

    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public static void update(Miniatura miniatura) throws Exception {
        if (exists(miniatura)) {
            throw new Exception("Já existe um Miniatura com as mesmas características!");
        }
        dal.update(miniatura);
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
