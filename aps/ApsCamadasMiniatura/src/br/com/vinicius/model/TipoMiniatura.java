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
 *  Modelo de objeto para TipoMiniatura.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.model;

/**
 *
 * @author vovostudio
 */
public class TipoMiniatura {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int tipo_id = 0;
    private String tipo_nome = "";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public TipoMiniatura() {

    }

    public TipoMiniatura(int tipo_id, String tipo_nome) {
        this.tipo_id = tipo_id;
        this.tipo_nome = tipo_nome;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getTipo_id() {
        return tipo_id;
    }

    public String getTipo_nome() {
        return tipo_nome;
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //

    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setTipo_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }

    public void setTipo_nome(String tipo_nome) {
        this.tipo_nome = tipo_nome;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
