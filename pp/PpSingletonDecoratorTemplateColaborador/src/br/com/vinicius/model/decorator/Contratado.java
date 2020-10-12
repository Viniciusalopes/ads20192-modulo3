/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/10/2020 06:58:56 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Contratado-base do Decorator (Equivalente ao Carro do exemplo)
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.model.decorator;

import br.com.vinicius.model.Habilidade;
import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public abstract class Contratado {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    ArrayList<Habilidade> habilidades = new ArrayList<>();

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public ArrayList<Habilidade> getHabilidades() throws Exception {
        return habilidades;
    }

    public abstract int getQuantidade() throws Exception;
    //--- FIM GET ---------------------------------------------------------------------------------|
    //
}
