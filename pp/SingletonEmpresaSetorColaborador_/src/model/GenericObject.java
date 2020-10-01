/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/09/2020 08:26:19 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  
 *  ------------------------------------------------------------------------------------------------| 
 */
package model;

import util.EnumConstantes;

/**
 *
 * @author vovostudio
 */
public class GenericObject {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    protected int id = 0;
    protected String nome = "";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public GenericObject() {

    }

    public GenericObject(int id, String nome) {
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

    @Override
    public String toString() {
        return id + EnumConstantes.SeparadorSplit.getConstante() + nome;
    }

    public static GenericObject build(Object object) throws Exception {
        return new GenericObject(
                Integer.parseInt(((Object[]) object)[0].toString()), // id
                ((Object[]) object)[1].toString() // nome
        );
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
    //--- FIM SET ---------------------------------------------------------------------------------|
}
