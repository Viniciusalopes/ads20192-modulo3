/*
 * ------------------------------------------------------------------------------------------------>
 * Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 * Criado em  : 15/10/2019
 * Instituição: FACULDADE SENAI FATESG
 * Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 * Aluno      : Vinicius Araujo Lopes
 * Projeto    : EXERCÍCIOS DE ESTRUTURA DE DADOS – VETORES (AULA 2)
 * Exercício  : 1. Fazer um programa que leia e armazene as notas de 20 alunos em um vetor notas 
 * (notas no intervalo de 0 a 100). Em seguida, calcule e escreva a quantidade de notas em cada um 
 * dos intervalos:
 * 00 – 09 : __
 * 10 – 19 : __
 * :
 * .
 * 90 – 99 : __
 * 100 : __
 * -------------------------------------------------------------------------------------------------
 */
package principal;

import java.util.Random;

/**
 *
 * @author vovostudio
 */
public class EdVetoresAula2Ex01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] notas = new int[20];
        //int[] notas = {1, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] intervalos = new int[11];

        // Preenche o vetor de notas
        for (int i = 0; i < notas.length; i++) {
            notas[i] = new Random().nextInt(100) + 1; // Sorteia a nota
            intervalos[(notas[i] / 10)] += 1;
        }

        // Imprime vetor de notas
        imprimeVetor("Notas: ", notas);

        // Imprime quantidade de notas por faixa
        for (int i = 0; i < intervalos.length - 1; i++) {
            System.out.printf("Notas de %02d a %02d: %d\n", (i * 10), ((i * 10) + 9), intervalos[i]);
        }
        System.out.printf("Notas 100: %d\n", intervalos[intervalos.length - 1]);
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
