/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/09/2020 05:50:48 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
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
    private String codigo = "";
    private String descricao = "";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Habilidade() {

    }

    public Habilidade(int id, String codigo, String descricao) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        String sep = EnumConstantes.SeparadorSplit.getConstante();
        return id + sep + codigo + sep + descricao;
    }

    public static Habilidade build(Object object) throws Exception {
        Object[] obj = (Object[]) object;
        Habilidade habilidade = new Habilidade();
        habilidade.setId(Integer.parseInt(Field.getValue("habilidade_id", obj[0]).toString()));
        habilidade.setCodigo(Field.getValue("habilidade_codigo", obj[1]).toString());
        habilidade.setDescricao(Field.getValue("habilidade_descricao", obj[2]).toString());
        return habilidade;
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //

    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
