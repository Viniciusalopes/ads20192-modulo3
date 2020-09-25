/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 25/09/2020 12:15:34 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  
 *  ------------------------------------------------------------------------------------------------| 
 */
package view;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vovostudio
 */
public class Tela extends javax.swing.JFrame {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getSelectedId(JTabbedPane tabs) throws Exception {
        String accessibleName = tabs.getSelectedComponent().getAccessibleContext().getAccessibleName();
        JPanel panel = getSelectedPanel(tabs, accessibleName);
        JTable table = getJTable(panel, accessibleName);
        int line = table.getSelectedRow();
        int column = getIndexIdColumn(table);

        return (line == -1) ? 0 : Integer.parseInt(table.getValueAt(table.getSelectedRow(), column).toString());
    }

    private int getIndexIdColumn(JTable table) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = 0; i < model.getColumnCount(); i++) {
            if (model.getColumnName(i).equals("ID")) {
                return i;
            }
        }
        return 0;
    }

    private JPanel getSelectedPanel(JTabbedPane oJTabbedPane, String accessibleName) {
        for (Component component : oJTabbedPane.getComponents()) {
            if (component instanceof JPanel) {
                if (component.getAccessibleContext().getAccessibleName().equals(accessibleName)) {
                    return (JPanel) component;
                }
            }
        }
        return null;
    }

    private JTable getJTable(JPanel panel, String accessibleName) {
        for (Component component : panel.getComponents()) {
            if (component instanceof JScrollPane) {
                for (Component object : ((JScrollPane) component).getViewport().getComponents()) {
                    if (object instanceof JTable) {
                        if (object.getAccessibleContext().getAccessibleName().equals(accessibleName)) {
                            return (JTable) object;
                        }
                    }
                }
            }
        }
        return null;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void refreshGrid(DefaultTableModel oModel, Object[] lines) {
        oModel.setRowCount(0);
        for (Object line : lines) {
            Object[] values = (Object[]) line;
            oModel.addRow(values);
        }
    }
    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
