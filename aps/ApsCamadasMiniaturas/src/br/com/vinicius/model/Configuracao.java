/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 13/10/2020 07:53:02 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Modelo de objeto para Configuracao.
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
    private int id = 0;
    private String nome = "";
    private String valor = "";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Configuracao() {

    }

    public Configuracao(int id, String nome, String valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getValor() {
        return valor;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
