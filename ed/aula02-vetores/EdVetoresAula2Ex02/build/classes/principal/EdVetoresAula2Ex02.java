/*
 * ------------------------------------------------------------------------------------------------>
 * Licença   : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 * Criado em : 15/10/2019
 * Projeto   : EXERCÍCIOS DE ESTRUTURA DE DADOS – VETORES (AULA 2)
 * Finalidade: 2. Elabore um programa para armazenar em um vetor V1 todos os valores inteiros 
 * positivos desde 1 até 50. Em seguida transporte todos os elementos primos do vetor V1 para um 
 * vetor V2. Imprima no final os dois vetores.
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
        int pos = 0;
        int quantidadePrimos = 0;   // Quantidade de números primos até o tamanho do v1

        for (int i = 1; i < v1.length; i++) {
            if (numeroPrimo(i)) {
                quantidadePrimos++;
            }
        }

        int[] v2 = new int[quantidadePrimos];

        for (int i = 0; i < v1.length; i++) {   // Preenche v1[] com números de 1 a n, onde n é o tamanho de v1[]
            v1[i] = i + 1;
            if (numeroPrimo(v1[i])) {   // Preenche v2[] com primos
                v2[pos] = v1[i];
                pos++;
            }
        }

        imprimeVetor("Vetor v1[] com números de 1 a " + v1.length + ": ", v1);
        imprimeVetor("Vetor v2[] com números primos em v1[]: ", v2);
    }

    private static boolean numeroPrimo(int numero) {
        int divisores = 1;
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                divisores++;
            }
        }
        return divisores == 2;
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
