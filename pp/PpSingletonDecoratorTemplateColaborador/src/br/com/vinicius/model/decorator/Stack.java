/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/10/2020 07:19:18 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Stack-objeto a ser decorado. (Equivalente ao Corsa, Captiva e Celta do exemplo). 
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.model.decorator;

import br.com.vinicius.bll.BllDecorator;

/**
 *
 * @author vovostudio
 */
public class Stack extends Contratado {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Stack(int stack_id) throws Exception {
        habilidades = BllDecorator.getHabilidadesStack(stack_id);
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    @Override
    public int getQuantidade() throws Exception {
        return habilidades.size();
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //
}
