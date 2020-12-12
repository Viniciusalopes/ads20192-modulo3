/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 02/10/2020 18:49:34 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - TEMPLATE METHOD
 *  Exercício  : Métodos de ordenação
 *  ------------------------------------------------------------------------------------------------
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */
package templates;

import classes.Aluno;

public class Nome extends Template {

    public Nome(String str) {
        super(str);
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getNome().compareToIgnoreCase(aluno2.getNome()) <= 0;
    }
}
