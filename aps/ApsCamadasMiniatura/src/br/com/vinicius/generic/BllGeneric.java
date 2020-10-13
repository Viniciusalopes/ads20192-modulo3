/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 01/10/2020 01:26:18 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Camada Bll genérica para cadastros simples.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.generic;

import static br.com.vinicius.generic.Factory.*;

/**
 *
 * @author vovostudio
 */
public abstract class BllGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    protected static String charsVogaisAcentuadas = "àâãáéêíòôõóúÀÂÂÁÉÊÍÒÔÕÓÚ";
    protected static String charsLetras
            = "qwertyuiopasdfghjklçzxcvbnmQWERTYUIOPASDFGHJKLÇZXCVBNM " + charsVogaisAcentuadas;
    protected static String charsNumeros = "0123456789";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public static void validate(Object object) throws Exception {
        String className = object.getClass().getSimpleName();
        validarCampo(invoke(object, "get" + className + "_nome").toString(), "Nome do " + className);
    }

    public static void add(Object object) throws Exception {
        validate(object);
        invoke(getDal(object.getClass().getSimpleName()), "add", object.getClass(), object.getClass().cast(object));
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public static Object getByName(String name, String className) throws Exception {
        Object dal = getDal(className);
        return (Object) dal.getClass().getMethod("getByName", String.class).invoke(dal, name);
    }

    public static boolean exists(int id, String className) throws Exception {
        Object dal = getDal(className);
        return (boolean) dal.getClass().getMethod("exists", int.class).invoke(dal, id);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public static void update(Object object) throws Exception {
        validate(object);
        Object dal = getDal(object.getClass().getSimpleName());
        invoke(dal, "update", object.getClass(), object);
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public static void delete(int id, String className) throws Exception {
        Object dal = getDal(className);
        dal.getClass().getMethod("delete", int.class).invoke(dal, id);
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //

    public static void validarTextoTamanho(String texto) throws Exception {
        texto = texto.trim();
        if (texto.length() == 0) {
            throw new Exception("Informe o nome!");
        }

        if (texto.length() < 2) {
            throw new Exception("O nome deve ter pelo menos duas letras!");
        }

    }

    public static void validarCampoTamanho(String texto, String nomeDoCampoTexto) throws Exception {
        try {
            validarNome(texto);
        } catch (Exception e) {
            throw new Exception(e.getMessage().replace("nome", nomeDoCampoTexto));
        }
    }

    public static void validarCampo(String texto, String nomeDoCampoTexto) throws Exception {
        try {
            validarNome(texto);
        } catch (Exception e) {
            throw new Exception(e.getMessage().replace("nome", nomeDoCampoTexto));
        }
    }

    /**
     * Valida nome.
     *
     * @param nome Texto com nome válido, com pelo menos duas letras.
     * @throws Exception
     */
    public static void validarNome(String nome) throws Exception {
        validarTextoTamanho(nome);

        for (char c : nome.toCharArray()) {
            if (!charsLetras.contains(c + "")) {
                throw new Exception("O nome deve ter apenas letras e espaços!");
            }
        }
    }
}
