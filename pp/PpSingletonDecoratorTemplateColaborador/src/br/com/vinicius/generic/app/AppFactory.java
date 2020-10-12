/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 11/10/2020 12:08:06 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Propósito do arquivo.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.generic.app;

import static br.com.vinicius.generic.Factory.getDal;
import static br.com.vinicius.generic.app.AppDesktopMensagem.mensagemEscolher;
import javax.swing.JTable;

/**
 *
 * @author vovostudio
 */
public class AppFactory {

    //--- JDialog --------------------------------------------------------------------------------->
    //
    public static void getModal(Object object, String friendlyName, AppIModal modal) throws Exception {
        modal.setObject(object);
        modal.setFriendlyName(friendlyName);
        modal.setVisible(true);
    }

    //--- FIM JDialog -----------------------------------------------------------------------------|
    //
    //--- JTable ---------------------------------------------------------------------------------->
    //
    public static int getSelectedId(JTable jTable) throws Exception {
        return Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
    }

    public static void deleteRow(JTable jTable) throws Exception {
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
    //--- FIM JTable ------------------------------------------------------------------------------|
    //
}
