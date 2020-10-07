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
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.generic;

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
    /**
     * Valida nome.
     *
     * @param nome Texto com nome válido, com pelo menos duas letras.
     * @throws Exception
     */
    public static void validarNome(String nome) throws Exception {
        nome = nome.trim();
        if (nome.length() == 0) {
            throw new Exception("Informe o nome!");
        }

        if (nome.length() < 2) {
            throw new Exception("O nome deve ter pelo menos duas letras!");
        }

        for (char c : nome.toCharArray()) {
            if (!charsLetras.contains(c + "")) {
                throw new Exception("O nome deve ter apenas letras e espaços!");
            }
        }
    }

    public static void validarCampo(String texto, String nomeDoCampoTexto) throws Exception {
        try {
            validarNome(texto);
        } catch (Exception e) {
            throw new Exception(e.getMessage().replace("nome", nomeDoCampoTexto));
        }
    }
}