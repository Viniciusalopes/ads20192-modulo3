/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 13/10/2020 08:11:13 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Foto em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Regras de negócio e consultas à dal.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.bll;

import br.com.vinicius.dal.DalFoto;
import br.com.vinicius.model.Foto;
import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public class BllFoto {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static DalFoto dal = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    private static void initDal() throws Exception {
        if (dal == null) {
            dal = new DalFoto();
        }
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public static void add(Foto foto) throws Exception {
        if (exists(foto)) {
            throw new Exception("Já existe uma Foto com as mesmas características!");
        }
        dal.add(foto);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public static boolean exists(Foto foto) throws Exception {
        initDal();
        return dal.exists(foto);
    }

    public static ArrayList<Foto> get() throws Exception {
        initDal();
        return dal.get();
    }

    public ArrayList<Foto> get(int miniatura_id) throws Exception {
        initDal();
        return dal.get(miniatura_id);
    }

    public Foto get(int id, int miniatura_id) throws Exception {
        initDal();
        return dal.get(id, miniatura_id);
    }
    //--- FIM READ --------------------------------------------------------------------------------|
    //

    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public static void update(Foto foto) throws Exception {
        if (exists(foto)) {
            throw new Exception("Já existe um Foto com as mesmas características!");
        }
        dal.update(foto);
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
