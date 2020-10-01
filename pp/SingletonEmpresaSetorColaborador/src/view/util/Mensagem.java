/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 07/09/2020 13:10:33 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : Projeto MVC - Sistema Bancário Simples
 *  Exercício  : https://www.devmedia.com.br/java-se-aprendendo-o-padrao-mvc/29546
 *  -------------------------------------------------------------------------------------------------
 *  Mensagems para exibição em ambiente desktop.
 *  ------------------------------------------------------------------------------------------------| 
 */
package view.util;

import javax.swing.JOptionPane;

/**
 *
 * @author vovostudio
 */
public class Mensagem {

    // --- MENSAGENS ------------------------------------------------------------------------------>
    //
    /**
     * Exibe uma mensagem informativa na tela.
     *
     * @param titulo Título da mensagem.
     * @param mensagem Texto da mensagem.
     */
    public static void mensagem(String titulo, String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Exibe uma mensagem de erro na tela.
     *
     * @param e Exception para obter o texto da mensagem.
     */
    public static void mensagemErro(Exception e) {
        String mensagem = ((e.getMessage() == null)
                ? ((e.getCause() == null)
                ? e.getStackTrace().toString()
                : e.getCause().getMessage())
                : e.getMessage());

        JOptionPane.showMessageDialog(null, mensagem, "Opa!", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Exibe pergunta e retorna a resposta do usuário.
     * <p>
     * Exemplo:
     * <p>
     * String[] opcoes = {"Sim", "Não", "Talvez"};
     * <p>
     * 0 = Sim
     * <p>
     * 1 = Não
     * <p>
     * 2 = Talvez
     *
     * @param mensagem Texto com a pergunta.
     * @param opcoes Lista com os labels dos botões de opção.
     * @return Inteiro com o índice da opção escolhida pelo usuário.
     *
     */
    public static int mensagemEscolher(String mensagem, String[] opcoes) {
        return JOptionPane.showOptionDialog(null, mensagem, "Escolha uma opção:",
                JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, 0);
    }

    // --- FIM MENSAGENS --------------------------------------------------------------------------|
}
