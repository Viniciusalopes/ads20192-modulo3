/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 06/10/2020 21:14:14 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.generic;

import static br.com.vinicius.generic.BllFactory.getDal;
import static br.com.vinicius.generic.BllFactory.validateSelectionComboBox;
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
 * - AppFactory, e BllFactory, e NNNFactory, dependendo da camada envolvida?? <br>
 * <br>
 * - Todos os métodos da BLL podem ser estáticos? Singleton? ou a gosto do freguês. <br>
 * <br>
 * - App pode acessar diretamente a BllFactory ou precisa passar pela BllObjeto do AppObjeto?<br>
 * <br>
 * - App pode acessar qualquer Bll
 * <br>
 * - Bll pode acessar outras Dal, ou só Blls?
 * <br>
 *
 */
public class AppFactory {

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
    public static int getSelectedId(JTable jTable) throws Exception {
        return Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
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

    public static void fillComboBoxes(JPanel jPanel) throws Exception {
        for (Component comp : jPanel.getComponents()) {
            if (comp instanceof JComboBox) {
                JComboBox cb = (JComboBox) comp;
                fillComboBox(cb, cb.getAccessibleContext().getAccessibleName());
            }
        }
    }

    public static void fillComboBox(JComboBox jComboBox, String className) throws Exception {
        Object dal = getDal(className);
        ArrayList<?> itens = (ArrayList<?>) dal.getClass().getMethod("getAll").invoke(dal);

        jComboBox.removeAllItems();

        for (Object obj : itens) {
            jComboBox.addItem(obj.getClass().getMethod("get" + className + "_nome").invoke(obj) + "");
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
    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
