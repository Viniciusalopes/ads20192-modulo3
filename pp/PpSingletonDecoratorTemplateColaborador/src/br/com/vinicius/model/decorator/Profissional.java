/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/10/2020 07:29:29 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Objeto Decorator (Equivalente ao Acessorio do exemplo).
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.model.decorator;

import br.com.vinicius.model.Habilidade;
import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public abstract class Profissional extends Contratado {

    //--- GET ------------------------------------------------------------------------------------->
    //
    public abstract ArrayList<Habilidade> getHabilidades() throws Exception;
    
    //--- FIM GET ---------------------------------------------------------------------------------|
    //
}
