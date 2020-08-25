/*
 * ------------------------------------------------------------------------------------------------>
 * Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 * Criado em  : 10/08/2020
 * Instituição: FACULDADE SENAI FATESG
 * Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 * Disciplina : Estrutura de Dados
 * Aluno      : Vinicius Araujo Lopes
 * Projeto    : EXERCÍCIOS PRIMEIRA AULA DE ESTRUTURA DE DADOS – VETORES
 * Exercício  : 4. Fazer um programa que receba 3 números inteiros quaisquer e os ordene na forma crescente. Fazer
 * duas soluções. Uma solução utilizando apenas estruturas condicionais simples e outra utilizando
 * estruturas condicionais aninhadas. Obs.: não utilizar vetor, utilizar apenas variáveis simples.
 * (Não utilizar vetor na solução)
 * -------------------------------------------------------------------------------------------------
 * Programa principal, condicional simples.
 * ------------------------------------------------------------------------------------------------| 
 */

package principal;

import java.util.Scanner;

/**
 *
 * @author vovostudio
 */
public class EdVetoresAula1Ex04CondicSimples {

    static Scanner sc = new Scanner(System.in);
    static String entrada = "";
    static int num1 = 0;
    static int num2 = 0;
    static int num3 = 0;
    static int naux = 0;
    static boolean invalido = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int i = 1; i < 4; i++) {
            do {
                System.out.printf("Digite o %dº número: ", i);
                entrada = sc.nextLine();
                try {
                    naux = Integer.parseInt(entrada);
                    invalido = false;
                } catch (Exception e) {
                    invalido = true;
                    System.out.println("Número inválido!\n" + e.getMessage());
                }
            } while (invalido);

            if (i == 1) {
                num1 = naux;
            }
            if (i == 2) {
                num2 = naux;
            }
            if (i == 3) {
                num3 = naux;
            }
        }
//        num1 = 4;// 2 - 1 - 1
//        num2 = 2;// 4 - 4 - 2 
//        num3 = 1;// 1 - 2 - 4
//        
        if (num2 < num1) {
            naux = num1;
            num1 = num2;
            num2 = naux;
        }
        if (num3 < num1) {
            naux = num1;
            num1 = num3;
            num3 = naux;
        }
        if (num3 < num2) {
            naux = num2;
            num2 = num3;
            num3 = naux;
        }

        System.out.printf("Números em ordem crescente: %d, %d, %d.\n", num1, num2, num3);
    }
}
