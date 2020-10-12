/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 11/10/2020 09:33:34 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Propósito do arquivo.
 *  -----------------------------------------------------------------------------------------------| 
 */

package br.com.vinicius.bll;

import br.com.vinicius.dal.DalColaborador;
import static br.com.vinicius.generic.bll.BllGeneric.validarNome;
import java.util.ArrayList;
import br.com.vinicius.model.Colaborador;

/**
 *
 * @author vovostudio
 */
public class BllColaborador {

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
    public static void validate(Colaborador colaborador) throws Exception{
        validarNome(colaborador.getNome());
        if(colaborador.getSetor_id() <= 0){
            throw new Exception("Selecione o setor do colaborador!");
        }
    }
    public static void add(Colaborador colaborador) throws Exception{
        validate(colaborador);
        new DalColaborador().add(colaborador);
    }
    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    
    //--- READ ------------------------------------------------------------------------------------>
    //
    public static Colaborador getColaborador(int colaborador_id) throws Exception{
        return new DalColaborador().getColaborador(colaborador_id);
    }
    public static ArrayList<Colaborador> getColaboradores(int setor_id) throws Exception{
        return new DalColaborador().getColaboradores(setor_id);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public static void update(Colaborador colaborador) throws Exception{
        validate(colaborador);
        new DalColaborador().update(colaborador);
    }
    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    
    //--- DELETE ---------------------------------------------------------------------------------->
    //

    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
