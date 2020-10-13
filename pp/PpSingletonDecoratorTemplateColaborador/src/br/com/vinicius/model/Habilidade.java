/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 09/10/2020 19:37:33 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Modelo de objeto Habilidade.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.model;

/**
 *
 * @author vovostudio
 */
public class Habilidade {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int id = 0;
    private String descricao = "";
    private HabilidadeOrigem origem = new HabilidadeOrigem();

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Habilidade() {
    }

    public Habilidade(int id, String descricao, HabilidadeOrigem origem) {
        this.id = id;
        this.descricao = descricao;
        this.origem = origem;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public HabilidadeOrigem getOrigem() {
        return origem;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setOrigem(HabilidadeOrigem origem) {
        this.origem = origem;
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
