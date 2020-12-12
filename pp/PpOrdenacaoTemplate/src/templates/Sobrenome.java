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

public class Sobrenome extends Template {

    public Sobrenome(String str) {
        super(str);
    }

   
    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        String nome1 = "";
        String nome2 = "";
        String[] partes = aluno1.getNome().replace("junior", "").replace("filho", "").replace("neto", "").split(" ");
        nome1 = partes[partes.length -1] + ", " + partes[0];
        partes = aluno2.getNome().replace("junior", "").replace("filho", "").replace("neto", "").split(" ");
        nome2 = partes[partes.length -1] + ", " + partes[0];
        
        return nome1.compareToIgnoreCase(nome2) <= 0;
    }
}
devo pro eugenio

temp or
temp
fact
adap
iterator


