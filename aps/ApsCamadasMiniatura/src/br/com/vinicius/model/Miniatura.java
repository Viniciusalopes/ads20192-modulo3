/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 29/09/2020 08:04:19 
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
public class Miniatura {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int miniatura_id = 0;
    private String modelo = "";
    private String ano = "";
    private String observacoes = "";
    private String edicao = "";
    private String escala = "";
    private float valor = 0;
    private Fabricante fabricante = null;
    private TipoMiniatura tipo = null;
    private Tema tema = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    public Miniatura() {

    }

    public Miniatura(
            int miniatura_id, String modelo, String ano, String observacoes, String edicao,
            String escala, float valor, Fabricante fabricante, TipoMiniatura tipo, Tema tema
    ) {
        this.miniatura_id = miniatura_id;
        this.modelo = modelo;
        this.ano = ano;
        this.observacoes = observacoes;
        this.edicao = edicao;
        this.escala = escala;
        this.valor = valor;
        this.fabricante = fabricante;
        this.tipo = tipo;
        this.tema = tema;
    }
    //--- GET ------------------------------------------------------------------------------------->
    //

    public int getMiniatura_id() {
        return miniatura_id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAno() {
        return ano;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public String getEdicao() {
        return edicao;
    }

    public String getEscala() {
        return escala;
    }

    public float getValor() {
        return valor;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public TipoMiniatura getTipoMiniatura() {
        return tipo;
    }

    public Tema getTema() {
        return tema;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setMiniatura_id(int miniatura_id) {
        this.miniatura_id = miniatura_id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public void setTipo(TipoMiniatura tipo) {
        this.tipo = tipo;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
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
