/*
 * ------------------------------------------------------------------------------------------------>
 * Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 * Criado em  : 10/08/2020
 * Instituição: FACULDADE SENAI FATESG
 * Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 * Disciplina : Estrutura de Dados
 * Aluno      : Vinicius Araujo Lopes
 * Projeto    : EXERCÍCIOS PRIMEIRA AULA DE ESTRUTURA DE DADOS – VETORES
 * Exercício  : 1. Fazer um programa que leia e armazene em um vetor 16 números inteiros distintos.
 * Em seguida,determine e imprima o maior e segundo maior número armazenado neste vetor.
 * Exemplo: dado o vetor vet = {1,3,6,-4,10,20,15,100,-15,-45,200,300,490,17,18,380}. Então o maior
 * é 490 e o segundo maior é 380.
 * -------------------------------------------------------------------------------------------------
 * Programa principal.
 * ------------------------------------------------------------------------------------------------| 
 */
package principal;

import java.util.Random;

/**
 *
 * @author Vinicius Araujo Lopes
 */
public class EdVetoresAula1Ex01 {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    private static int tamanhoVetor = 16;
    private static int maximo = 500;
    private static int numero = 0;
    private static int maior1 = 0;
    private static int maior2 = 0;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] vet = new int[tamanhoVetor];

        for (int i = 0; i < vet.length; i++) {

            // Sorteia um número sem repetir
            do {
                numero = new Random().nextInt(maximo);
            } while (jaExisteNoVetor(numero, vet));

            //Inclui o número no vetor
            vet[i] = numero;

            // Maior número
            if (i == 0) {
                maior1 = numero;
                maior2 = numero;
            } else {
                if (numero > maior1) {
                    maior2 = maior1;
                    maior1 = numero;
                } else if (numero > maior2) {
                    maior2 = numero;
                }
            }
        }

        // Saída
        String saida = "Dado o vetor vet = {";
        for (int num : vet) {
            saida += num + ", ";
        }
        saida = saida.substring(0, saida.length() - 2) + "}, então o maior é %d e o segundo maior é %d.\n";
        System.out.printf(saida, maior1, maior2);
    }

    /**
     * Verifica se um numero já existe no vetor.
     *
     * @param numero Número que será pesquisado no vetor.
     * @param vetor Vetor com números para procurar um número.
     * @return true: já existe, false: não existe.
     */
    private static boolean jaExisteNoVetor(int numero, int[] vetor) {
        for (int num : vetor) {
            if (num == numero) {
                return true;
            }
        }
        return false;
    }
}
