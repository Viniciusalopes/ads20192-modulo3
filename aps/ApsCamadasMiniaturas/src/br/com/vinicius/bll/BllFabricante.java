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

import br.com.vinicius.dal.DalFabricante;
import br.com.vinicius.model.Fabricante;
import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public class BllFabricante {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static DalFabricante dal = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    private static void initDal() throws Exception {
        if (dal == null) {
            dal = new DalFabricante();
        }
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public static void add(Fabricante fabricante) throws Exception {
        if (exists(fabricante)) {
            throw new Exception("Já existe um Fabricante com este nome!");
        }
        dal.add(fabricante);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public static boolean exists(Fabricante fabricante) throws Exception {
        initDal();
        return dal.exists(fabricante);
    }

    public static ArrayList<Fabricante> get() throws Exception {
        initDal();
        return dal.get();
    }

    public static Fabricante get(int id) throws Exception {
        initDal();
        return dal.get(id);
    }

    public static Fabricante get(String nome) throws Exception {
        initDal();
        return dal.get(nome);
    }
    //--- FIM READ --------------------------------------------------------------------------------|
    //

    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public static void update(Fabricante fabricante) throws Exception {
        if (exists(fabricante)) {
            throw new Exception("Já existe um Fabricante com este nome!");
        }
        dal.update(fabricante);
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
