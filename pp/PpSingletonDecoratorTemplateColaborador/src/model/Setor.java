/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 09/10/2020 19:29:40 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Modelo de objeto Setor.
 *  -----------------------------------------------------------------------------------------------| 
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public class Setor {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int id = 0;
    private String nome = "";
    private int empresa_id = 0;
    private ArrayList<Colaborador> colaboradores = new ArrayList<>();

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Setor() {
    }

    public Setor(int id, String nome, int empresa_id, ArrayList<Colaborador> colaboradores) {
        this.id = id;
        this.nome = nome;
        this.empresa_id = empresa_id;
        this.colaboradores = colaboradores;
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

    public int getEmpresa_id() {
        return empresa_id;
    }

    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
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

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
