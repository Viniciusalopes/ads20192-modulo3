/**
 * Licença MIT Copyright(c) 2020 Viniciusalopes Tecnologia
 *
 * A permissão é concedida, gratuitamente, a qualquer pessoa que obtenha uma cópia deste software e
 * dos arquivos de documentação associados (o "Software"), para negociar no Software sem restrições,
 * incluindo, sem limitação, os direitos de uso, cópia, modificação, fusão, publicar, distribuir,
 * sublicenciar e/ou vender cópias do Software e permitir que as pessoas a quem o Software é
 * fornecido o façam, sob as seguintes condições:
 *
 * O aviso de direitos autorais acima e este aviso de permissão devem ser incluídos em todas as
 * cópias ou partes substanciais do Software.
 *
 * O SOFTWARE É FORNECIDO "TAL COMO ESTÁ", SEM GARANTIA DE QUALQUER TIPO, EXPRESSA OU IMPLÍCITA,
 * INCLUINDO MAS NÃO SE LIMITANDO A GARANTIAS DE COMERCIALIZAÇÃO, ADEQUAÇÃO A UMA FINALIDADE
 * ESPECÍFICA E NÃO INFRAÇÃO. EM NENHUM CASO OS AUTORES OU TITULARES DE DIREITOS AUTORAIS SERÃO
 * RESPONSÁVEIS POR QUALQUER REIVINDICAÇÃO, DANOS OU OUTRA RESPONSABILIDADE, SEJA EM AÇÃO DE
 * CONTRATO, TORT OU OUTRA FORMA, PROVENIENTE, FORA OU EM CONEXÃO COM O SOFTWARE OU O USO, OU OUTROS
 * ACORDOS NOS PROGRAMAS.
 * -------------------------------------------------------------------------------------------------
 * Mensagens prontas tipo JOptionPane.
 * Criação : Vovolinux
 * Data    : 10/08/2020
 * Projeto : EXERCÍCIOS PRIMEIRA AULA DE ESTRUTURA DE DADOS – VETORES
 *   3. Faça um programa de consulta de telefones a partir de um nome informado como uma chave de
 *   dados. O programa deve:
 *   • Conter uma classe Pessoa com os atributos nome, telefone e e-mail;
 *   • Permitir a entrada de nomes de pessoas com seus respectivos telefones e e-mails, sendo a
 *   quantidade determinada pelo usuário, e armazená-los em um vetor de objetos pessoas;
 *   • Permitir ao usuário inserir qual o nome que ele deseja consultar o telefone. Após a consulta,
 *   exiba o telefone da pessoa procurada. Informe também se o nome é inexistente no vetor de
 *   pessoas.
 * -------------------------------------------------------------------------------------------------
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
