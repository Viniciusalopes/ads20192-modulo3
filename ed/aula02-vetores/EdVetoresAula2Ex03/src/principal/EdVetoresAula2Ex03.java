/*
 * ------------------------------------------------------------------------------------------------>
 * Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 * Criado em  : 15/08/2020
 * Instituição: FACULDADE SENAI FATESG
 * Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 * Disciplina : Estrutura de Dados
 * Aluno      : Vinicius Araujo Lopes
 * Projeto    : EXERCÍCIOS DE ESTRUTURA DE DADOS – VETORES (AULA 2)
 * Exercício  : 3. Foi feita uma pesquisa de opinião sobre as novas instalações das Salas de Estudo 
 * e da Biblioteca, utilizando notas de 1 a 5 (sendo 1 ruim e 5 excelente). Fazer um programa que 
 * leia e armazene as notas de 20 alunos em um vetor notas. Em seguida, calcule e escreva:
 * • a quantidade de notas 1:
 * • a quantidade de notas 2:
 * • a quantidade de notas 3:
 * • a quantidade de notas 4:
 * • a quantidade de notas 5:
 * • a porcentagem de notas 4 e 5:
 * -------------------------------------------------------------------------------------------------
 * Programa principal.
 * ------------------------------------------------------------------------------------------------| 
 */
package principal;

import java.util.Random;

/**
 *
 * @author vovostudio
 */
public class EdVetoresAula2Ex03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] notas = new int[20];
        int[] qtd = new int[5];
        int soma = 0;

        String[] nomes = {"ruim     ", "meia-boca", "aceitavel", "bom      ", "excelente"};

        // Preenche vetor com as notas
        for (int i = 0; i < notas.length; i++) {
            notas[i] = new Random().nextInt(5) + 1; // Sorteia a nota
            qtd[notas[i] - 1]++; // Incrementa a soma da quantidade de notas
        }

        // Saída
        imprimeVetor("Avaliacões: ", notas);

        for (int i = 0; i < nomes.length; i++) {
            System.out.printf("Quantidade de notas %d - %s: %d\n", (i + 1), nomes[i], qtd[i]);
        }
        soma = qtd[qtd.length - 1] + qtd[qtd.length - 2];
        System.out.printf("\nQuantidade  de notas 4 e 5       : %d\n", soma);
        System.out.printf("Porcentagem de notas 4 e 5       : %.2f%%\n", (float) ((soma * 100) / notas.length));
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
