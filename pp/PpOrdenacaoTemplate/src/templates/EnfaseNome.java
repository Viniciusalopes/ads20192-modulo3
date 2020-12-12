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

public class EnfaseNome extends Template {

    public EnfaseNome(String str) {
        super(str);
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        if (aluno1.getEnfase().equalsIgnoreCase(aluno2.getEnfase())) {
            return aluno1.getNome().compareToIgnoreCase(aluno2.getNome()) <= 0;
        } else {
            return aluno1.getEnfase().compareToIgnoreCase(aluno2.getEnfase()) <= 0;
        }
    }
}
