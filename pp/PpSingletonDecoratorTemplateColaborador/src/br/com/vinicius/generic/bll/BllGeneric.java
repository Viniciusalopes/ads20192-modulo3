/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 11/10/2020 12:25:41 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Propósito do arquivo.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.generic.bll;

import static br.com.vinicius.generic.Factory.*;

/**
 *
 * @author vovostudio
 */
public class BllGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    protected static String charsVogaisAcentuadas = "àâãáéêíòôõóúÀÂÂÁÉÊÍÒÔÕÓÚ";
    protected static String charsLetras
            = "qwertyuiopasdfghjklçzxcvbnmQWERTYUIOPASDFGHJKLÇZXCVBNM " + charsVogaisAcentuadas;
    protected static String charsNumeros = "0123456789";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
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
