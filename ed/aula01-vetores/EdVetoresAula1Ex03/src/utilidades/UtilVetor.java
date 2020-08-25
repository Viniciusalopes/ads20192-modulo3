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
 * Utilidades para Vetores.
 * ------------------------------------------------------------------------------------------------| 
 */
package utilidades;

/**
 *
 * @author vovostudio
 */
public class UtilVetor {

    public static String[] redimensionarVetor(String[] vetor, int novoTamanho) {

        if (novoTamanho <= 0) {
            return new String[0];
        }

        if (vetor == null) {
            return new String[novoTamanho];
        } else {
            String[] retorno = new String[novoTamanho];
            for (int i = 0; i < vetor.length; i++) {
                if (vetor[i] != null) {
                    retorno[i] = vetor[i];
                }
            }
            return retorno;
        }
    }
   
   public static String[] unirVetores(String[] vetor1, String[] vetor2) {
        String[] retorno = new String[vetor1.length];
        retorno = redimensionarVetor(vetor1, (vetor1.length + vetor2.length));
        for (int i = 0; i < vetor2.length; i++) {
            if (vetor2[i] != null) {
                retorno[i + vetor1.length] = vetor2[i];
            }
        }
        return retorno;
    }

    public static String[] excluirLinhaVetor(String[] vetor, int posicao) {
        String[] retorno = new String[vetor.length - 1];
        int pos = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (i != posicao) {
                if (vetor[i] != null) {
                    retorno[pos] = vetor[i];
                }
                pos++;
            }
        }
        return retorno;
    }

    public static String[] splitLinhasDoVetor(String[] vetor) {
        String[] retorno = new String[0];

        for (int lin = 0; lin < vetor.length; lin++) {
            retorno = unirVetores(retorno,
                    ((vetor[lin].contains("\n"))
                    ? vetor[lin].split("\n")
                    : new String[]{vetor[lin]})
            );
        }
        
        return retorno;
    }
}
