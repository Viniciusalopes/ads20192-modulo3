/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 28/09/2020 18:33:34 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Modelo de objeto para Tema.
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
    private int id = 0;
    private String nome = "";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Tema() {

    }

    public Tema(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    //--- FIM GET ---------------------------------------------------------------------------------|
    //

    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setId(int tipo_id) {
        this.id = tipo_id;
    }

    public void setNome(String tipo_nome) {
        this.nome = tipo_nome;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
