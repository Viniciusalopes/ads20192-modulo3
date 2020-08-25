/*
 * ------------------------------------------------------------------------------------------------>
 * Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 * Criado em  : 15/08/2020
 * Instituição: FACULDADE SENAI FATESG
 * Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 * Disciplina : Estrutura de Dados
 * Aluno      : Vinicius Araujo Lopes
 * Projeto    : EXERCÍCIOS DE ESTRUTURA DE DADOS – VETORES (AULA 2)
 * Exercício  : 4. Fazer um programa, utilizando laço de repetição, que mostre:
 * (a)         (b)                (c)         (d)
 * *           **********  **********           *  
 * **          *********    *********          **  
 * ***         ********      ********         ***  
 * ****        *******        *******        ****  
 * *****       ******          ******       *****  
 * ******      *****            *****      ******  
 * *******     ****              ****     *******  
 * ********    ***                ***    ********  
 * *********   **                  **   *********  
 * **********  *                    *  **********
 * 
 * -------------------------------------------------------------------------------------------------
 * Programa principal.
 * ------------------------------------------------------------------------------------------------| 
 */
package principal;

/**
 *
 * @author vovostudio
 */
public class EdVetoresAula2Ex04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int colunas = 10;

        System.out.println("(a)         (b)                (c)         (d)");

        for (int lin = 0; lin < colunas; lin++) {
            System.out.println(
                    repetir('*', (lin + 1)) + repetir(' ', colunas - (lin + 1)) + "  " // (a)
                    + repetir('*', colunas - lin) + repetir(' ', lin) + "  " // (b)
                    + repetir(' ', lin) + repetir('*', colunas - lin) + "  " // (c)
                    + repetir(' ', colunas - (lin + 1)) + repetir('*', lin + 1) // (d)
            );
        }
    }

    private static String repetir(char caractere, int quantidade) {
        String ret = "";
        for (int i = 0; i < quantidade; i++) {
            ret += caractere + "";
        }
        return ret;
    }
}
