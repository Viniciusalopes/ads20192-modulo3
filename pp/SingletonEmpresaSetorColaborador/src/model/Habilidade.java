/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/09/2020 05:50:48 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Habiliades de um colaborador de uma Empresa.
 *  ------------------------------------------------------------------------------------------------| 
 */
package model;

import dao.generic.model.Field;
import util.EnumConstantes;

/**
 *
 * @author vovostudio
 */
public class Habilidade {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int id = 0;
    private String descricao = "";
    private HabilidadeOrigem origem;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Habilidade() {

    }

    public Habilidade(int id, String codigo, String descricao, HabilidadeOrigem origem) {
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

    public HabilidadeOrigem getHabilidadeOrigem() {
        return origem;
    }

    public static Habilidade build(Object object) throws Exception {
        Object[] obj = (Object[]) object;
        Habilidade habilidade = new Habilidade();
        habilidade.setId(Integer.parseInt(Field.getValue("habilidade_id", obj[0]).toString()));
        habilidade.setDescricao(Field.getValue("habilidade_descricao", obj[1]).toString());
        habilidade.setHabilidadeOrigem(
                new HabilidadeOrigem(
                        Integer.parseInt(Field.getValue("origem_id", obj[3]).toString()),
                        Field.getValue("origem_nome", obj[0]).toString()
                )
        );
        return habilidade;
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

    public void setHabilidadeOrigem(HabilidadeOrigem habilidadeOrigem) {
        this.origem = habilidadeOrigem;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
