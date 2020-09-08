/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 06/09/2020 22:27:38 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : Projeto MVC - Sistema Bancário Simples
 *  Exercício  : https://www.devmedia.com.br/java-se-aprendendo-o-padrao-mvc/29546
 *  ------------------------------------------------------------------------------------------------
 *  Modelo de Cliente.
 *  -----------------------------------------------------------------------------------------------| 
 */
package model_Vinicius.classes;

import model_Vinicius.enums.EnumConstantes;

/**
 *
 * @author vovostudio
 */
public class Cliente {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int id;
    private String nome;
    private String email;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
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

    public String getEmail() {
        return email;
    }

    public String toString() {
        String sep = EnumConstantes.SeparadorSplit.getConstante();
        return id + sep + nome + sep + email;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setNome(String nome) {
        this.nome = nome;
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //

}
