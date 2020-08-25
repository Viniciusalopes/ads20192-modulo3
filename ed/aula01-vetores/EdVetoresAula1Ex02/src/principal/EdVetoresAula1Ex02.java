/*
 * ------------------------------------------------------------------------------------------------>
 * Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 * Criado em  : 10/08/2020
 * Instituição: FACULDADE SENAI FATESG
 * Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 * Disciplina : Estrutura de Dados
 * Aluno      : Vinicius Araujo Lopes
 * Projeto    : EXERCÍCIOS PRIMEIRA AULA DE ESTRUTURA DE DADOS – VETORES
 * Exercício  : 2. A Mega-Sena é uma loteria realizada pela Caixa Econômica Federal, que paga milhões
 * para o acertador dos 6 números sorteados. Os sorteios normalmente ocorrem às quartas e sábados.
 * Faça um programa em Java que gere seis números aleatórios e distintos entre 01 e 60, inclusive, 
 * para serem “jogados” na Mega-Sena.
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
public class EdVetoresAula1Ex02 {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    private static int tamanhoVetor = 6;
    private static int maximo = 60;
    private static int numero = 0;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] vet = new int[tamanhoVetor];

        for (int i = 0; i < vet.length; i++) {
            // Sorteia um número sem repetir
            numero = new Random().nextInt(maximo) + 1;
            int j;

            for (j = 0; j < i && vet[j] != numero; j++) {
            }
            if (j == i) {
                // Não existe, Inclui o número no vetor
                vet[i] = numero;
            } else {
                // Já existe
                i--;
            }
        }

        // Saída
        String saida = "Números para jogar na Mega-Sena: ";
        for (int num : vet) {
            saida += String.format("%02d", num) + ", ";
        }
        saida = saida.substring(0, saida.length() - 2) + ".";
        System.out.println(saida);
    }
}
