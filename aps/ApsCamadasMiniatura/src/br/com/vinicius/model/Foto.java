/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 28/09/2020 18:53:00 
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
package br.com.vinicius.model;

/**
 *
 * @author vovostudio
 */
public class Foto {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int foto_id = 0;
    private String foto_caminho = "";
    private String foto_descricao = "";
    private Miniatura miniatura = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Foto() {

    }

    public Foto(int foto_id, String foto_caminho, String foto_descricao, Miniatura miniatura) {
        this.foto_id = foto_id;
        this.foto_caminho = foto_caminho;
        this.foto_descricao = foto_descricao;
        this.miniatura = miniatura;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getFoto_id() {
        return foto_id;
    }

    public String getFoto_caminho() {
        return foto_caminho;
    }

    public String getFoto_descricao() {
        return foto_descricao;
    }

    public Miniatura getMiniatura() {
        return miniatura;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    public void setFoto_id(int foto_id) {
        this.foto_id = foto_id;
    }

    public void setFoto_caminho(String foto_caminho) {
        this.foto_caminho = foto_caminho;
    }

    public void setFoto_descricao(String foto_descricao) {
        this.foto_descricao = foto_descricao;
    }

    public void setMiniatura(Miniatura miniatura) {
        this.miniatura = miniatura;
    }

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
}
