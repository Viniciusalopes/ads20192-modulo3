/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 06/10/2020 21:14:14 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Fábrica para camada de aplicação em Swing.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.generic;

import static br.com.vinicius.generic.AppMensagem.mensagemEscolher;
import static br.com.vinicius.generic.Factory.getClassFromPackage;
import static br.com.vinicius.generic.Factory.getDal;
import static br.com.vinicius.generic.Factory.getNewInstance;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vovostudio perguntas:<br>
 */
public class AppFactory extends Factory {

    //--- JComboBox ------------------------------------------------------------------------------->
    //
    public static void fillComboBoxes(JPanel jPanel) throws Exception {
        for (Component comp : jPanel.getComponents()) {
            if (comp instanceof JComboBox) {
                JComboBox cb = (JComboBox) comp;
                fillComboBox(cb, cb.getActionCommand());
            }
        }
    }

    public static void fillComboBox(JComboBox jComboBox, String className) throws Exception {
        Object dal = getDal(className);
        ArrayList<?> itens = (ArrayList<?>) dal.getClass().getMethod("get").invoke(dal);

        jComboBox.removeAllItems();

        for (Object obj : itens) {
            jComboBox.addItem(obj.getClass().getMethod("getNome").invoke(obj) + "");
        }
        jComboBox.setSelectedIndex(-1);
    }

    public static void validateSelectionComboBoxes(JPanel jPanel) throws Exception {
        for (Component component : jPanel.getComponents()) {
            if (component instanceof JComboBox) {
                validateSelectionComboBox((JComboBox) component);
            }
        }
    }

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
    public static int getSelectedId(JTable jTable) throws Exception {
        return Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
    }

    public static void fillGrid(JTable jTable) throws Exception {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        Object dal = getDal(jTable.getAccessibleContext().getAccessibleName());
        ResultSet rs = (ResultSet) dal.getClass().getMethod("getAllFields").invoke(dal);
        int columnCount = rs.getMetaData().getColumnCount();

        // FONTE: https://stackoverflow.com/questions/10620448/most-simple-code-to-populate-jtable-from-resultset
        while (rs.next()) {
            Object[] linha = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                linha[i] = rs.getObject(i + 1);
            }
            model.addRow(linha);
        }
    }

    public static void deleteRow(JTable jTable) throws Exception {
        if (jTable.getSelectedRow() > -1) {
            int id = getSelectedId(jTable);
            String[] opcoes = new String[]{"Não... vai que, né!", "Sim"};
            if (mensagemEscolher("Confirma a exclusão do cadastro [" + id + "] ? ", opcoes) > 0) {
                Object obj = getDal(jTable.getAccessibleContext().getAccessibleName());
                obj.getClass().getMethod("delete", int.class).invoke(obj, id);
                fillGrid(jTable);
            }
        }
    }

    //--- FIM JTable ------------------------------------------------------------------------------|
    //
    //--- JDialog --------------------------------------------------------------------------------->
    //
    public static void getModal(String className, String friendlyName, String action, JTable jTable, AppIModal modal) throws Exception {

        Object dal = getDal(className);
        Object obj = getNewInstance(getClassFromPackage("model", className));

        if (jTable != null) {
            if (action.equals("update")) {
                int id = getSelectedId(jTable);
                obj = dal.getClass().getMethod("getById", int.class).invoke(dal, id);
            }
        }
        modal.setObject(obj);
        modal.setFriendlyName(friendlyName);
        modal.setVisible(true);
    }

    //--- FIM JDialog -----------------------------------------------------------------------------|
    //
}
