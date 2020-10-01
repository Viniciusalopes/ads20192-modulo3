/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/09/2020 08:28:38 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  
 *  ------------------------------------------------------------------------------------------------| 
 */
package model;

import java.util.ArrayList;
import util.EnumConstantes;
import util.EnumHabilidades;

/**
 *
 * @author vovostudio
 */
public abstract class Pessoa extends GenericObject {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    protected ArrayList<Habilidade> habilidades = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Pessoa() {

    }

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    @Override
    public String toString() {
        return id + EnumConstantes.SeparadorSplit.getConstante() + nome;
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //

    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
