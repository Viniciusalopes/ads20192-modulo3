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

import br.com.vinicius.dal.DalTipoMiniatura;
import br.com.vinicius.model.TipoMiniatura;
import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public class BllTipoMiniatura {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static DalTipoMiniatura dal = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    private static void initDal() throws Exception {
        if (dal == null) {
            dal = new DalTipoMiniatura();
        }
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public static void add(TipoMiniatura tipo) throws Exception {
        if (exists(tipo)) {
            throw new Exception("Já existe um Tipo de Miniatura com este nome!");
        }
        dal.add(tipo);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public static boolean exists(TipoMiniatura tipo) throws Exception {
        initDal();
        return dal.exists(tipo);
    }

    public static ArrayList<TipoMiniatura> get() throws Exception {
        initDal();
        return dal.get();
    }

    public static TipoMiniatura get(int id) throws Exception {
        initDal();
        return dal.get(id);
    }

    public static TipoMiniatura get(String nome) throws Exception {
        initDal();
        return dal.get(nome);
    }
    //--- FIM READ --------------------------------------------------------------------------------|
    //

    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public static void update(TipoMiniatura tipo) throws Exception {
        if (exists(tipo)) {
            throw new Exception("Já existe um Tipo de Miniatura com este nome!");
        }
        dal.update(tipo);
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
