/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 10/10/2020 19:28:09 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Regras de negócio para Empresa. (Padrão SINGLETON e método estáticos)
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.bll;

import br.com.vinicius.dal.DalEmpresa;
import br.com.vinicius.model.Empresa;

/**
 *
 * @author vovostudio
 */
public class BllEmpresa {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static DalEmpresa dal = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    private static void initDal() throws Exception {
        if (dal == null) {
            dal = new DalEmpresa();
        }
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public static Empresa getEmpresa() throws Exception {
        initDal();
        return dal.getEmpresa();
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public static void update(String empresa_nome) throws Exception {
        initDal();
        dal.update(empresa_nome);
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
}
