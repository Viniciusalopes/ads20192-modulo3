/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/09/2020 16:04:47 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Regras de negócio para Pessoa.
 *  ------------------------------------------------------------------------------------------------| 
 */
package bll;

/**
 *
 * @author vovostudio
 */
public class BllPessoa extends BllGeneric {

    public static void validarNomePessoa(String nome) throws Exception {
        validarNome(nome);
        if (nome.split(" ").length < 2) {
            throw new Exception("Infome o nome e um sobrenome!");
        }
    }
}
