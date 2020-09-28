/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 28/09/2020 18:33:34 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Modelo de objeto para Fabricante.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.model;

/**
 *
 * @author vovostudio
 */
public class Fabricante {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int fabricante_id = 0;
    private String fabricante_nome = "";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Fabricante() {

    }

    public Fabricante(int fabricante_id, String fabricante_nome) {
        this.fabricante_id = fabricante_id;
        this.fabricante_nome = fabricante_nome;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getFabricante_id() {
        return fabricante_id;
    }

    public String getFabricante_nome() {
        return fabricante_nome;
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //

    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setFabricante_id(int fabricante_id) {
        this.fabricante_id = fabricante_id;
    }

    public void setFabricante_nome(String fabricante_nome) {
        this.fabricante_nome = fabricante_nome;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
