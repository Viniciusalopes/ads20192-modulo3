/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 11/10/2020 12:08:06 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Factory para camada App em desktop.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.generic;

import static br.com.vinicius.generic.AppDesktopMensagem.mensagemEscolher;
import static br.com.vinicius.generic.Factory.getDal;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author vovostudio
 */
public class AppFactory {

    //--- JDialog --------------------------------------------------------------------------------->
    //
    /**
     * Exibe um modal para inclusão ou edição de cadastro simples.
     *
     * @param object Objeto do cadastro.
     * @param friendlyName Nome amigável da entidade.
     * @param modal JDialog que implemente a interface AppIModal.
     * @throws Exception
     */
    public static void getModal(Object object, String friendlyName, AppIModal modal) throws Exception {
        modal.setObject(object);
        modal.setFriendlyName(friendlyName);
        modal.setVisible(true);
    }

    //--- FIM JDialog -----------------------------------------------------------------------------|
    //
    //--- JComboBox ------------------------------------------------------------------------------->
    //
    /**
     * Atualiza todos os ComboBoxes de um JPanel.
     *
     * @param jPanel JPanel agrupador dos ComboBoxes.
     * @throws Exception
     */
    public static void fillComboBoxes(JPanel jPanel) throws Exception {
        for (Component comp : jPanel.getComponents()) {
            if (comp instanceof JComboBox) {
                JComboBox cb = (JComboBox) comp;
                fillComboBox(cb, cb.getActionCommand());
            }
        }
    }

    /**
     * Atualiza os itens de um ComboBox de acordo com a classe do objeto a ser listado.
     *
     * @param jComboBox Combobox a ser atualizado.
     * @param className Classe do objeto a ser listado.
     * @throws Exception
     */
    public static void fillComboBox(JComboBox jComboBox, String className) throws Exception {
        Object dal = getDal(className);
        ArrayList<?> itens = (ArrayList<?>) dal.getClass().getMethod("get").invoke(dal);

        jComboBox.removeAllItems();

        for (Object obj : itens) {
            jComboBox.addItem(obj.getClass().getMethod("getNome").invoke(obj) + "");
        }
        jComboBox.setSelectedIndex(-1);
    }

    /**
     * Verifica se todos os ComboBoxes de um JPanel foram selecionados (index != -1)
     *
     * @param jPanel JPanel agrupador dos ComboBoxes.
     * @throws Exception
     */
    public static void validateSelectionComboBoxes(JPanel jPanel) throws Exception {
        for (Component component : jPanel.getComponents()) {
            if (component instanceof JComboBox) {
                validateSelectionComboBox((JComboBox) component);
            }
        }
    }

    /**
     * Verifica se um ComboBox foi selecionado (index != -1)
     *
     * @param jComboBox Combobox a ser verificado.
     * @throws Exception
     */
    public static void validateSelectionComboBox(JComboBox jComboBox) throws Exception {
        if (jComboBox.getSelectedIndex() == -1) {
            throw new Exception("Selecione o " + jComboBox.getAccessibleContext()
                    .getAccessibleName() + "!");
        }
    }

    //--- FIM JComboBox ---------------------------------------------------------------------------|
    //
    //--- JTable ---------------------------------------------------------------------------------->
    //
    /**
     * Obtém o ID de um cadastro a partir a linha selecionada de um JTable, quando a coluna que
     * contém o ID do objeto é 0 (zero).
     *
     * @param jTable JTable que se deseja obter o ID selecionado.
     * @return
     * @throws Exception
     */
    public static int getSelectedId(JTable jTable) throws Exception {
        return getSelectedId(jTable, 0);
    }

    /**
     * Obtém o ID de um cadastro a partir a linha selecionada de um JTable.
     *
     * @param jTable JTable que se deseja obter o ID selecionado.
     * @param indexColumnId Índice da coluna que tem a informação do ID do objeto.
     * @return
     * @throws Exception
     */
    public static int getSelectedId(JTable jTable, int indexColumnId) throws Exception {
        return Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), indexColumnId).toString());
    }

    /**
     * Executa o método delete da camada DAL de um objeto listado no JTable, a partir da linha
     * selecionada.<br>
     * Exibe uma mensagem de confirmação antes da deleção.
     *
     * @param jTable JTable que está exibindo a coleção de dados.
     * @throws Exception
     */
    public static void deleteSelected(JTable jTable) throws Exception {
        if (jTable.getSelectedRow() > -1) {
            int id = getSelectedId(jTable);
            String[] opcoes = new String[]{"Não... vai que, né!", "Sim"};
            if (mensagemEscolher("Confirma a exclusão do cadastro [" + id + "] ? ", opcoes) > 0) {
                Object obj = getDal(jTable.getAccessibleContext().getAccessibleName());
                obj.getClass().getMethod("delete", int.class).invoke(obj, id);
            }
        }
    }

    //--- FIM JTable ------------------------------------------------------------------------------|
    //
}
