/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 11/10/2020 09:53:30 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Regras de negócio para Habilidade. (Padrão SINGLETON e método estáticos)
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
    private static DalHabilidade dal = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    private static void initDal() throws Exception {
        if (dal == null) {
            dal = new DalHabilidade();
        }
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //

    public static Habilidade getHabilidade(int habilidade_id) throws Exception {
        initDal();
        return dal.getHabilidade(habilidade_id);
    }

    public static Habilidade getHabilidade(String habilidade_descricao) throws Exception {
        initDal();
        return dal.getHabilidade(habilidade_descricao);
    }

    public static ArrayList<Habilidade> getHabilidades() throws Exception {
        initDal();
        return dal.getHabilidades();
    }

    public static ArrayList<Habilidade> getHabilidadesStack(int stack_id) throws Exception {
        initDal();
        return dal.getHabilidadesStack(stack_id);
    }

    public static ArrayList<Habilidade> getHabilidadesOrigem(int origem_id) throws Exception {
        initDal();
        return dal.getHabilidadesOrigem(origem_id);
    }

    public static ArrayList<Habilidade> getHabilidades(int colaborador_id) throws Exception {
        initDal();
        return dal.getHabilidades(colaborador_id);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
}
