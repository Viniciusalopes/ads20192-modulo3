/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 09/10/2020 19:35:40 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Modelo de objeto Colaborador.
 *  -----------------------------------------------------------------------------------------------| 
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public class Colaborador {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int id = 0;
    private String nome = "";
    private int setor_id = 0;
    private ArrayList<Habilidade> habilidades = new ArrayList<>();

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Colaborador() {
    }

    public Colaborador(int id, String nome, int setor_id, ArrayList<Habilidade> habilidades) {
        this.id = id;
        this.nome = nome;
        this.setor_id = setor_id;
        this.habilidades = habilidades;
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

    public int getSetor_id() {
        return setor_id;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
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

    public void setSetor_id(int setor_id) {
        this.setor_id = setor_id;
    }

    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
