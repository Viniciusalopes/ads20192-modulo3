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
 * Utilidades para programas em modo console.
 * ------------------------------------------------------------------------------------------------| 
 */

package utilidades;

import java.util.Scanner;
import static utilidades.UtilVetor.splitLinhasDoVetor;

/**
 *
 * @author vovostudio
 */
public class UtilConsole {

    private static String montarMensagem(String tituloMensagem, String[] linhasMensagem, char borda, int espacamento, boolean sublinhado) {
        int largura = 0;
        String bordaHorizontal = "";
        String bordaVertical = (sublinhado) ? "" : (borda + "");
        String titulo = (tituloMensagem.trim().length() == 0) ? "" : "[ " + tituloMensagem + " ]";
        String[] linhas = new String[linhasMensagem.length];

        linhas = splitLinhasDoVetor(linhasMensagem);

        for (String linha : linhas) {
            largura = (linha.length() > largura) ? linha.length() : largura;
        }

        bordaHorizontal = (borda + "").repeat(largura + (espacamento * 2) + (bordaVertical.length() * 2));

        String retorno = "";
        if (!sublinhado) {
            String parte = bordaHorizontal.substring(0, (bordaHorizontal.length() - titulo.length()) / 2);
            retorno += parte + titulo + parte;
            // Acrescenta o caracter da borda na quantidade do resto de titulos com quantidade de char impar 
            int resto = bordaHorizontal.length() - (parte.length() * 2) - titulo.length();
            retorno += (borda + "").repeat(resto) + "\n";
        }

        for (String linha : linhas) {
            retorno += bordaVertical + " ".repeat(espacamento)
                    + linha + " ".repeat(largura - linha.length())
                    + " ".repeat(espacamento)
                    + bordaVertical + "\n";
        }
        retorno += bordaHorizontal;
        return retorno;

    }

    public static String mensagemComBorda(String tituloMensagem, String[] linhasMensagem, char borda, int espacamento) {
        return montarMensagem(tituloMensagem, linhasMensagem, borda, espacamento, false);
    }

    public static String mensagemTitulo(String[] linhasMensagem, char sublinhado, int espacamento) {
        return montarMensagem("", linhasMensagem, sublinhado, espacamento, true);
    }

    public static int menuDeOpcoes(String titulo, String[] opcoes, String pergunta, String mensagemErro, boolean horizontal) {

        Scanner sc = new Scanner(System.in);
        int selecionado = 0;
        String entrada = "";
        boolean entradaValida = false;

        do {
            System.out.println(mensagemTitulo(new String[]{titulo}, '-', 1));
            for (String opc : opcoes) {
                if (opc != null) {
                    System.out.print(((horizontal) ? "" : " ") + opc + ((horizontal) ? "  " : "\n"));
                }
            }

            System.out.print(((horizontal) ? "\n" : "") + pergunta);

            entrada = sc.nextLine();
            entradaValida = (entrada.trim().length() > 0) && UtilString.soTemNumeros(entrada);

            if (entradaValida) {
                selecionado = Integer.parseInt(entrada);
                if (selecionado == 0) {
                    entradaValida = true;
                } else {
                    entradaValida = ((selecionado > 0) && selecionado < opcoes.length) || opcoes.length == 1;
                }
            }

            if (!entradaValida) {
                System.out.println("\n" + mensagemComBorda("Eita!", new String[]{mensagemErro}, '*', 1));
            }
        } while (!entradaValida);

        return selecionado;
    }
}
