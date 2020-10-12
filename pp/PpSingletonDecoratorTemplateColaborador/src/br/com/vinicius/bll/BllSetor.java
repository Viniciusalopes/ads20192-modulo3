/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 10/10/2020 19:28:09 
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

import br.com.vinicius.dal.DalSetor;
import br.com.vinicius.generic.bll.BllGeneric;
import java.util.ArrayList;
import br.com.vinicius.model.Setor;

/**
 *
 * @author vovostudio
 */
public class BllSetor extends BllGeneric {

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
    public static void validate(Setor setor) throws Exception{
        if(new DalSetor().exists(setor)){
            throw new Exception("Já existe um setor com este nome!");
        }
        validarCampoTamanho(setor.getNome(), "Nome do Setor");
    }
    
    public static void add(Setor setor) throws Exception{
        validate(setor);
        new DalSetor().add(setor);
    }
    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public static Setor getSetor(int id) throws Exception {
        return new DalSetor().getSetor(id);
    }
    public static Setor getSetor(String nome, int empresa_id) throws Exception{
        return new DalSetor().getSetor(nome, empresa_id);
    }
    public static ArrayList<Setor> getSetores(int empresa_id) throws Exception {
        return new DalSetor().getSetores(empresa_id);
    }
    //--- FIM READ --------------------------------------------------------------------------------|
    //

    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public static void update(Setor setor) throws Exception{
        new DalSetor().update(setor);
    }
    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public static void delete(int setor_id) throws Exception{
        new DalSetor().delete(setor_id);
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
