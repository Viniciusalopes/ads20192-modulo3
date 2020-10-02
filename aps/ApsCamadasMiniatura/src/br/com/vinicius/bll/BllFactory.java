/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 29/09/2020 20:51:52 
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
package br.com.vinicius.bll;

import static br.com.vinicius.app.AppMensagem.*;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.vinicius.app.AppIModal;

/**
 *
 * @author vovostudio
 */
public class BllFactory {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    public static String domain = "br.com.vinicius.";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public static Class getClassFromModel(String className) throws Exception {
        return Class.forName(domain + "model." + className);
    }

    public static Class getClassFromPackage(String packageName, String className) throws Exception {
        return Class.forName(domain + packageName + "." + className);
    }

    public static Object getDal(String className) throws Exception {
        return getNewInstance(getClassFromPackage("dal", "Dal" + className));
    }

    public static Object getBll(String className) throws Exception {
        return getNewInstance(getClassFromPackage("bll", "Bll" + className));
    }

    public static Object getNewInstance(Class classe) throws Exception {
        return classe.getConstructor().newInstance();
    }

    public static int getId(Object object) throws Exception {
        return (int) object.getClass()
                .getMethod("get" + object.getClass().getSimpleName() + "_id")
                .invoke(object);
    }

    public static int getSelectedId(JTable jTable) throws Exception {
        return Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
    }

    public static Object invoke(Object object, String methodName) throws Exception {
        return object.getClass().getMethod(methodName).invoke(object);
    }

    public static Object invoke(Object object, String methodName, Class classe, Object arg) throws Exception {
        return object.getClass().getMethod(methodName, classe).invoke(object, arg);
    }

    public static Object getObjectByid(int idObject, String className) throws Exception {
        return invoke(getDal(className), "getById", int.class, idObject);
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

    public static void validateSelectionComboBox(JComboBox jComboBox) throws Exception {
        if (jComboBox.getSelectedIndex() == -1) {
            throw new Exception("Selecione o " + jComboBox.getAccessibleContext()
                    .getAccessibleName().replace("JComboBox", "") + "!");
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

    public static void getModal(String className, String action, JTable jTable, AppIModal modal) throws Exception {

        Object dal = getDal(className);
        Object obj = getNewInstance(getClassFromPackage("model", className));

        if (jTable != null) {
            if (action.equals("update")) {
                int id = getSelectedId(jTable);
                obj = dal.getClass().getMethod("getById", int.class).invoke(dal, id);
            }
        }
        modal.setObject(obj);
        modal.setVisible(true);
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //

}
