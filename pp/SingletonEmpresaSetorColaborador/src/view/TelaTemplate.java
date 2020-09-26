/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 25/09/2020 12:15:34 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON / TEMPLATE METHOD
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  TEMPLATE para manipulação de componentes da tela com a camada de persistência SINGLETON.
 *  -----------------------------------------------------------------------------------------------| 
 */
package view;

import control.ControlEmpresa;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.interfaces.IModal;
import static view.util.Mensagem.*;

/**
 *
 * @author vovostudio
 */
public abstract class TelaTemplate extends javax.swing.JFrame {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    protected ControlEmpresa control = null;
    protected Object selectedObject = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public TelaTemplate() throws Exception {
        super();
        control = ControlEmpresa.getInstance();
        this.setTitle(control.getEmpresa().getNome());
        control.updateSetores();
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- ABSTRATOS ------------------------------------------------------------------------------->
    //
    public abstract String getRegister();

    public abstract void select() throws Exception;

    public abstract void action(String actionCommand) throws Exception;

    public abstract int getIndexIdColumn(JTable table, String idColumnName);

    public abstract JPanel getSelectedPanel();

    public abstract JTable getJTable(JPanel panel);

    //--- FIM ABSTRATOS ---------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getSelectedId(JTabbedPane tabs, String idColumnName) throws Exception {
        JPanel panel = getSelectedPanel();
        JTable table = getJTable(panel);
        int line = table.getSelectedRow();
        int column = getIndexIdColumn(table, idColumnName);
        return (line == -1) ? 0 : Integer.parseInt(table.getValueAt(table.getSelectedRow(), column).toString());
    }

    public void getActionModal(String actionCommand) throws Exception {
        IModal modal = new JDialogIncluir(this, true);
        modal.setAcao(actionCommand);
        modal.setCadastro(getRegister());

        if (!actionCommand.equals("Incluir")) {
            if (selectedObject == null) {
                throw new Exception("Selecione um " + getRegister() + "!");
            }
        }

        if (actionCommand.equals("Excluir")) {
            if (mensagemEscolher("Confirma a exclusão do cadastro de " + getRegister() + "?",
                    new String[]{"Sim", "Não... melhor deixa."}) == 0) {
                control.ExcluirSetor(Integer.parseInt(
                        selectedObject.getClass().getMethod("getId").invoke(selectedObject).toString()
                ));
                mensagem("Sucesso!", getRegister() + " excluído com sucesso!");
            }
        } else {
            if (actionCommand.equals("Editar")) {
                modal.setObject(selectedObject);
            }
            modal.setVisible(true);
        }
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setSelectedObject(int id) throws Exception {
        if (id > 0) {
            selectedObject = control.getClass().getMethod("get" + getRegister(), int.class).invoke(control, id);
        } else {
            selectedObject = null;
        }
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
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
}
