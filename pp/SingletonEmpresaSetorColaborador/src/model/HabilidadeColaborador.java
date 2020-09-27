/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/09/2020 05:48:22 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
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
public class HabilidadeColaborador {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int habilidade_id = 0;
    private int colaborador_id = 0;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public HabilidadeColaborador() {
    }

    public HabilidadeColaborador(int idHabilidade, int idColaborador) {
        habilidade_id = idHabilidade;
        colaborador_id = idColaborador;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getHabilidadeId() {
        return habilidade_id;
    }
    public int getColaboradorId(){
        return colaborador_id;
    }

    @Override
    public String toString() {
        return habilidade_id + EnumConstantes.SeparadorSplit.getConstante() + colaborador_id;
    }

    public static HabilidadeColaborador build(Object object) throws Exception {
        Object[] obj = (Object[]) object;
        HabilidadeColaborador relation = new HabilidadeColaborador();
        relation.setHabilidadeId(Integer.parseInt(Field.getValue("habilidade_id", obj[0]).toString()));
        relation.setHabilidadeId(Integer.parseInt(Field.getValue("colaborador_id", obj[1]).toString()));
        return relation;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setHabilidadeId(int id){
        habilidade_id = id;
    }
    
    public void setColaboradorId(int id){
        colaborador_id = id;
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
