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

import br.com.vinicius.app.IModal;
import static br.com.vinicius.app.MensagemApp.*;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vovostudio
 */
public class FactoryBll {

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
        return getNewInstance(getClassFromPackage("dal", className + "Dal"));
    }

    public static Object getBll(String className) throws Exception {
        return getNewInstance(getClassFromPackage("bll", className + "Bll"));
    }

    public static Object getNewInstance(Class classe) throws Exception {
        return classe.getConstructor().newInstance();
    }

    public static String getClassName(JTable jTable) throws Exception {
        return jTable.getAccessibleContext().getAccessibleName();
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

    public static Object getObjectByid(int idObject, String className) throws Exception {
        return invoke(getDal(className), "getById");
    }

    public static void fillGrid(JTable jTable) throws Exception {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        Object dal = getDal(getClassName(jTable));
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
                Object obj = getDal(getClassName(jTable));
                obj.getClass().getMethod("delete", int.class).invoke(obj, id);
            }
        }
        fillGrid(jTable);
    }

    public static void modalCadastroSimples(
            String className, String action, JTable jTable, IModal modal) throws Exception {

        Object dal = getDal(className);
        Object obj = getNewInstance(getClassFromPackage("model", className));

        int row = jTable.getSelectedRow();
        if (action.equals("update")) {
            int id = getSelectedId(jTable);
            obj = dal.getClass().getMethod("getById", int.class).invoke(dal, id);
        }

        modal.setObject(obj);
        modal.setVisible(true);
        fillGrid(jTable);
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //

}
