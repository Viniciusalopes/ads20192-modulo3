/*
 * ------------------------------------------------------------------------------------------------>
 * Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 * Criado em  : 15/08/2020
 * Instituição: FACULDADE SENAI FATESG
 * Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 * Disciplina : Estrutura de Dados
 * Aluno      : Vinicius Araujo Lopes
 * Projeto    : EXERCÍCIOS DE ESTRUTURA DE DADOS – VETORES (AULA 2)
 * Exercício  : 2. Elabore um programa para armazenar em um vetor V1 todos os valores inteiros 
 * positivos desde 1 até 50. Em seguida transporte todos os elementos primos do vetor V1 para um 
 * vetor V2. Imprima no final os dois vetores.
 * -------------------------------------------------------------------------------------------------
 * Programa principal.
 * ------------------------------------------------------------------------------------------------| 
 */

package principal;

/**
 *
 * @author vovostudio
 */
public class EdVetoresAula2Ex02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] v1 = new int[50];
        int[] vAux = new int[v1.length];
        int[] v2;
        int quantidadePrimos = 0;   // Quantidade de números primos até o tamanho do v1

        for (int i = 1; i <= v1.length; i++) {
            v1[i - 1] = i;              // Preenche v1[] com números de 1 a n, onde n é o tamanho de v1[]
            if (numeroPrimo(i)) {
                vAux[quantidadePrimos] = i;
                quantidadePrimos++;
            }
        }

        v2 = new int[quantidadePrimos];

        for (int i = 0; i < v2.length; i++) {
            v2[i] = vAux[i];
        }

        imprimeVetor("Vetor v1[] com números de 1 a " + v1.length + ": ", v1);
        imprimeVetor("Vetor v2[] com números primos em v1[]: ", v2);
    }

    private static boolean numeroPrimo(int numero) {
        boolean primo = true;
        int i = 2;
        double limite = Math.sqrt(numero);

        while (primo && i <= limite) {
            if (numero % i == 0) {
                primo = false;
            }
            i++;
        }
        return primo;
    }

    private static void imprimeVetor(String titulo, int[] vetor) {
        //Imprime vetor
        String retorno = titulo + "{";
        for (int v : vetor) {
            retorno += String.format("%d, ", v);
        }
        System.out.println(retorno.substring(0, retorno.length() - 2) + "}");
    }
}
