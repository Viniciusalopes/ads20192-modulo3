/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 28/09/2020 18:53:00 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Modelo de objeto para Foto.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.model;

/**
 *
 * @author vovostudio
 */
public class Foto {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int id = 0;
    private String caminho = "";
    private String descricao = "";
    private int miniatura_id = 0;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Foto() {

    }

    public Foto(int id, String caminho, String descricao, int miniatura_id) {
        this.id = id;
        this.caminho = caminho;
        this.descricao = descricao;
        this.miniatura_id = miniatura_id;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getId() {
        return id;
    }

    public String getCaminho() {
        return caminho;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getMiniatura_id() {
        return miniatura_id;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setId(int id) {
        this.id = id;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setMiniatura_id(int miniatura_id) {
        this.miniatura_id = miniatura_id;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
