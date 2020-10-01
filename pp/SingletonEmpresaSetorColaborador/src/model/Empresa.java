/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/09/2020 05:48:22 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Empresa (SINGLETON).
 *  ------------------------------------------------------------------------------------------------| 
 */
package model;

import dao.generic.model.Field;
import java.util.ArrayList;
import util.EnumConstantes;

/**
 *
 * @author vovostudio
 */
public class Empresa extends GenericObject {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private ArrayList<Setor> setores = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Empresa() {

    }

    public Empresa(int id, String nome, ArrayList<Setor> setores) {
        this.id = id;
        this.nome = nome;
        this.setores = (setores == null) ? new ArrayList<>() : setores;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public ArrayList<Setor> getSetores() {
        return setores;
    }

    @Override
    public String toString() {
        return id + EnumConstantes.SeparadorSplit.getConstante() + nome;
    }

    public static Empresa build(Object object) throws Exception {
        Object[] obj = (Object[]) object;
        Empresa empresa = new Empresa();
        empresa.setId(Integer.parseInt(Field.getValue("empresa_id", obj[0]).toString()));
        empresa.setNome(Field.getValue("empresa_nome", obj[1]).toString());
        return empresa;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setSetores(ArrayList<Setor> setores) {
        this.setores = setores;
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
