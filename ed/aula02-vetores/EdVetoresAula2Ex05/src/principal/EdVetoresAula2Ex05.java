/*
 * ------------------------------------------------------------------------------------------------>
 * Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 * Criado em  : 15/08/2020
 * Instituição: FACULDADE SENAI FATESG
 * Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 * Disciplina : Estrutura de Dados
 * Aluno      : Vinicius Araujo Lopes
 * Projeto    : EXERCÍCIOS DE ESTRUTURA DE DADOS – VETORES (AULA 2)
 * Exercício  : 5. Utilize um vetor. Escreva um programa que insere cinco números, cada um entre 10 
 * e 100, inclusive. A medida que cada número for lido, só o insira no vetor se ele não for uma 
 * duplicata de um número já lido, ou seja, se ele não estiver no vetor. Mostre o vetor completo de
 * valores únicos inseridos. 
 * -------------------------------------------------------------------------------------------------
 * Programa principal.
 * ------------------------------------------------------------------------------------------------| 
 */

package principal;

import java.util.Scanner;

/**
 *
 * @author vovostudio
 */
public class EdVetoresAula2Ex05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tamanho = 5;
        int[] numeros = new int[tamanho];
        int numero = 0;
        boolean repetido;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < tamanho; i++) {

            do {
                repetido = true;
                System.out.printf("Digite o %dº número de 10 a 100: ", (i + 1));

                try {
                    numero = Integer.parseInt(sc.nextLine());
                    if (numero < 10 || numero > 100) {
                        throw new Exception("Número fora do intervalo válido!");
                    }

                    repetido = jaExiste(numeros, numero);

                    if (repetido) {
                        String digitados = "Números já digitados: ";
                        for (int j = 0; j < i; j++) {
                            digitados += numeros[j] + "  ";
                        }
                        throw new Exception(String.format("O número %d já foi digitado!\n%s", numero, digitados));
                    }

                    numeros[i] = numero;

                } catch (Exception e) {
                    System.out.println("Número inválido!\n" + e.getMessage() + "\n");
                }
            } while (repetido);
        }

        imprimeVetor("\nValores únicos inteiros inseridos: ", numeros);

    }

    private static boolean jaExiste(int[] vetor, int numero) {
        for (int i = 0; i < vetor.length; i++) {
            if (numero == vetor[i]) {
                return true;
            }
        }
        return false;
    }

    private static void imprimeVetor(String titulo, int[] vetor) {
        //Imprime vetor
        String ret = titulo + "{";
        for (int item : vetor) {
            ret += String.format("%d, ", item);
        }
        System.out.println(ret.substring(0, ret.length() - 2) + "}");
    }
}
