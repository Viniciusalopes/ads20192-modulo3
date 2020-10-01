/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 28/09/2020 05:19:04 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - DECORATOR
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Origem das habilidades
 *  -----------------------------------------------------------------------------------------------| 
 */
package model;

import dao.generic.model.Field;

/**
 *
 * @author vovostudio
 */
public class HabilidadeOrigem extends GenericObject {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public HabilidadeOrigem() {

    }

    public HabilidadeOrigem(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public static HabilidadeOrigem build(Object object) throws Exception {
        Object[] obj = (Object[]) object;
        HabilidadeOrigem habilidadeOrigem = new HabilidadeOrigem();
        habilidadeOrigem.setId(Integer.parseInt(Field.getValue("origem_id", obj[0]).toString()));
        habilidadeOrigem.setNome(Field.getValue("origem_nome", obj[1]).toString());
        return habilidadeOrigem;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
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
