/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 28/09/2020 19:10:13 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.model;

/**
 *
 * @author vovostudio
 */
public class Tema {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int tema_id = 0;
    private String tema_nome = "";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Tema() {

    }

    public Tema(int tema_id, String tema_nome) {
        this.tema_id = tema_id;
        this.tema_nome = tema_nome;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getTema_id() {
        return tema_id;
    }

    public String getTema_nome() {
        return tema_nome;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setTema_id(int tema_id) {
        this.tema_id = tema_id;
    }

    public void setTema_nome(String tema_nome) {
        this.tema_nome = tema_nome;
    }

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
}
