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
 * Mensagens prontas tipo JOptionPane.
 * ------------------------------------------------------------------------------------------------| 
 */

package utilidades;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vovostudio
 */
public class MensagensDialog extends JFrame {

    // Exibe mensagem de erro
    public void erro(Exception e) {
        JOptionPane.showMessageDialog(rootPane,
                ((e.getMessage() == null) ? e : e.getMessage()), "Opa!",
                JOptionPane.ERROR_MESSAGE);
    }

    // Exibe mensagem de informação
    public void informacao(String mensagem) {
        JOptionPane.showMessageDialog(rootPane, mensagem, "Informação!",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Exibe mensagem de alerta
    public void alerta(String mensagem) {
        JOptionPane.showMessageDialog(rootPane, mensagem, "Eita!",
                JOptionPane.WARNING_MESSAGE);
    }

    // Exibe uma mensagem de sucesso
    public void sucesso(String mensagem) {
        JOptionPane.showMessageDialog(rootPane, mensagem, "Sucesso!",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Exibe pergunta e retorna a resposta do usuário
    public int pergunta(String textoPergunta) {
        return JOptionPane.showConfirmDialog(rootPane, textoPergunta, "Confirmação:",
                JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public int escolher(String mensagem, String[] opcoes) {
        return JOptionPane.showOptionDialog(rootPane, mensagem, "Escolha uma opção:",
                JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, 0);
    }
}
