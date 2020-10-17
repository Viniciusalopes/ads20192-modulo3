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
 *  Factoru para JDialog e métodos genéricos.
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
