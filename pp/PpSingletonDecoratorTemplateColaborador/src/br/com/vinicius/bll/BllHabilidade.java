/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 11/10/2020 09:53:30 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Propósito do arquivo.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.bll;

import br.com.vinicius.dal.DalHabilidade;
import java.util.ArrayList;
import br.com.vinicius.model.Habilidade;

/**
 *
 * @author vovostudio
 */
public class BllHabilidade {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
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

    public static Habilidade getHabilidade(int habilidade_id) throws Exception {
        return new DalHabilidade().getHabilidade(habilidade_id);
    }

    public static Habilidade getHabilidade(String habilidade_descricao) throws Exception {
        return new DalHabilidade().getHabilidade(habilidade_descricao);
    }

    public static ArrayList<Habilidade> getHabilidades() throws Exception {
        return new DalHabilidade().getHabilidades();
    }

    public static ArrayList<Habilidade> getHabilidadesStack(int stack_id) throws Exception {
        return new DalHabilidade().getHabilidadesStack(stack_id);
    }

    public static ArrayList<Habilidade> getHabilidadesOrigem(int origem_id) throws Exception {
        return new DalHabilidade().getHabilidadesOrigem(origem_id);
    }

    public static ArrayList<Habilidade> getHabilidades(int colaborador_id) throws Exception {
        return new DalHabilidade().getHabilidades(colaborador_id);
    }

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
