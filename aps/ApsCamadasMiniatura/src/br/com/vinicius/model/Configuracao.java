/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 08/10/2020 12:08:25 
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
public class Configuracao {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int config_id = 0;
    private String config_nome = "";
    private String config_valor = "";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Configuracao() {

    }

    public Configuracao(int config_id, String config_nome, String config_valor) {
        this.config_id = config_id;
        this.config_nome = config_nome;
        this.config_valor = config_valor;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getConfig_id() {
        return config_id;
    }

    public String getConfig_nome() {
        return config_nome;
    }

    public String getConfig_valor() {
        return config_valor;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setConfig_id(int config_id) {
        this.config_id = config_id;
    }

    public void setConfig_nome(String config_nome) {
        this.config_nome = config_nome;
    }

    public void setConfig_valor(String config_valor) {
        this.config_valor = config_valor;
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
