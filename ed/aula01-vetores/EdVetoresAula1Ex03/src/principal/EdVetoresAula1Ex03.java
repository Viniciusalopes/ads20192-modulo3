/*
 * ------------------------------------------------------------------------------------------------>
 * Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 * Criado em  : 10/08/2020
 * Instituição: FACULDADE SENAI FATESG
 * Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 * Disciplina : Estrutura de Dados
 * Aluno      : Vinicius Araujo Lopes
 * Projeto    : EXERCÍCIOS PRIMEIRA AULA DE ESTRUTURA DE DADOS – VETORES
 * Exercício  : 3. Faça um programa de consulta de telefones a partir de um nome informado como uma 
 *   chave de dados. O programa deve:
 *   • Conter uma classe Pessoa com os atributos nome, telefone e e-mail;
 *   • Permitir a entrada de nomes de pessoas com seus respectivos telefones e e-mails, sendo a
 *   quantidade determinada pelo usuário, e armazená-los em um vetor de objetos pessoas;
 *   • Permitir ao usuário inserir qual o nome que ele deseja consultar o telefone. Após a consulta,
 *   exiba o telefone da pessoa procurada. Informe também se o nome é inexistente no vetor de
 *   pessoas.
 * -------------------------------------------------------------------------------------------------
 * Programa principal.
 * ------------------------------------------------------------------------------------------------| 
 */
package principal;

import enumeradores.EnumErros;
import telas.TelaConsole;
import telas.TelaQuantidade;
import utilidades.UtilConsole;

/**
 *
 * @author vovostudio
 */
public class EdVetoresAula1Ex03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int opcao = UtilConsole.menuDeOpcoes(
                "Selecionar Ambiente",
                new String[]{"[1] Console", "[2] JFrame", "[0] Sair"},
                "Digite número do ambiente para executar o programa: ",
                EnumErros.NaoEhUmaOpcao.getMensagem(), false);
        System.out.println("");
        if (opcao == 1) {
            TelaConsole tela = new TelaConsole();
            tela.main(args);
        } else if (opcao == 2) {
            TelaQuantidade tela = new TelaQuantidade();
            tela.setVisible(true);
        } else {
            System.exit(0);
        }

    }
}
