/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 26/09/2020 12:12:33 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - DECORATOR
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  ********************* Não está genérico ainda ***********************
 *  *************** So serve para cadastro de colaborador ***************
 *  ********************* Não está genérico ainda ***********************
 *  -----------------------------------------------------------------------------------------------| 
 */
package view;

import control.ControlDecorator;
import control.ControlEmpresa;
import dao.DAOHabilidade;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Colaborador;
import model.Habilidade;
import model.Setor;
import util.EnumHabilidades;
import util.EnumSkills;
import view.interfaces.IModal;
import static view.util.Mensagem.*;
import static view.util.ViewUtil.*;

/**
 *
 * @author vovostudio
 */
public class JDialogNomeFkCombobox extends javax.swing.JDialog implements IModal {

    private String acao = "";
    private String cadastro = "";
    private Object object = null;
    private ArrayList<Setor> collection = null;
    private DefaultTableModel modelHabilidadesColaborador = null;
    private DefaultTableModel modelSkils = null;
    private DefaultTableModel modelHabilidadesPessoa = null;
    private DefaultTableModel modelHabilidadesProfissional = null;
    private DefaultTableModel modelHabilidadesAluno = null;
    private ControlDecorator controlDecorator = null;

    private DAOHabilidade daoHabilidade = null;
    private ArrayList<Habilidade> habilidadesColaborador = null;
    private ArrayList<Habilidade> habilidadesPessoa = null;
    private ArrayList<Habilidade> habilidadesProfissional = null;
    private ArrayList<Habilidade> habilidadesAluno = null;

    @Override
    public void setAcao(String acao) {
        this.acao = acao;
    }

    @Override
    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }

    @Override
    public void setObject(Object object) throws Exception {
        this.object = object;
    }

    @Override
    public void setVisible(boolean b) {
        try {
            this.setTitle(acao + " " + cadastro);

            this.collection = ControlEmpresa.getInstance().getEmpresa().getSetores();

            modelHabilidadesColaborador = (DefaultTableModel) jTableHabilidadesColaborador.getModel();
            modelSkils = (DefaultTableModel) jTableSkils.getModel();
            modelHabilidadesPessoa = (DefaultTableModel) jTableHabilidadesPessoa.getModel();
            modelHabilidadesProfissional = (DefaultTableModel) jTableHabilidadesProfissional.getModel();
            modelHabilidadesAluno = (DefaultTableModel) jTableHabilidadesAluno.getModel();
            controlDecorator = new ControlDecorator();

            jComboBoxFk.removeAllItems();
            for (Setor setor : collection) {
                jComboBoxFk.addItem(setor.getNome());
            }
            jLabelFk.setText("Setor");

            if (acao.equals("Incluir")) {
                jComboBoxFk.setSelectedIndex(-1);
                carregarHabilidades();
                carregarSkils();
            }

            if (acao.equals("Editar")) {
                Setor setor = (Setor) (object.getClass().getMethod("getSetor").invoke(object));
                jTextFieldNome.setText((object.getClass().getMethod("getNome").invoke(object)).toString());
                jComboBoxFk.setSelectedItem(setor.getNome());
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
        super.setVisible(b);
    }

    private void carregarSkils() {
        modelSkils.setRowCount(0);
        for (EnumSkills skil : EnumSkills.values()) {
            modelSkils.addRow(new Object[]{skil.getNome()});
        }
    }

    private void carregarHabilidades() {

        habilidadesColaborador = daoHabilidade.retrieveByField(null, new Where)
        );

        modelHabilidadesColaborador.setRowCount(0);
        for (EnumHabilidades habilidade : habilidadesDecorado) {
            modelHabilidadesColaborador.addRow(new Object[]{habilidade.getNome()});
        }

        EnumHabilidades habilidade = null;
        int i = 0;

        modelHabilidadesPessoa.setRowCount(0);
        for (; i < 9; i++) {
            habilidade = EnumHabilidades.values()[i];
            if (!habilidadesDecorado.contains(habilidade)) {
                modelHabilidadesPessoa.addRow(new Object[]{habilidade.getNome()});
            }
        }

        modelHabilidadesProfissional.setRowCount(0);
        for (; i < 33; i++) {
            habilidade = EnumHabilidades.values()[i];
            if (!habilidadesDecorado.contains(habilidade)) {
                modelHabilidadesProfissional.addRow(new Object[]{habilidade.getNome()});
            }
        }

        modelHabilidadesAluno.setRowCount(0);
        for (; i < EnumHabilidades.values().length; i++) {
            habilidade = EnumHabilidades.values()[i];
            if (!habilidadesDecorado.contains(habilidade)) {
                modelHabilidadesAluno.addRow(new Object[]{habilidade.getNome()});
            }
        }
    }

    private void desmarcarOutrosGrids(String accessibleName) {
        for (Component component : jPanelHabilidades.getComponents()) {
            if (component instanceof JScrollPane) {
                for (Component object : ((JScrollPane) component).getViewport().getComponents()) {
                    if (object instanceof JTable) {
                        if (!object.getAccessibleContext().getAccessibleName().equals(accessibleName)) {
                            ((JTable) object).clearSelection();
                        }
                    }
                }
            }
        }
    }

    private void selecionar(String accessibleName, MouseEvent evt) {
        try {
            // Clique duplo, mostra detalhes do cadastro
            desmarcarOutrosGrids(accessibleName);
            if (evt != null) { // Quando acionado pelo keyReleased, evt = null
                if (evt.getClickCount() == 2) {
                    if (accessibleName.equals(jTableSkils.getAccessibleContext().getAccessibleName())) {
                        controlDecorator.addSkill(EnumSkills.valueOf(jTableSkils.getValueAt(jTableSkils.getSelectedRow(), 1).toString()));
                    } else {
                        JTable table = getJTable(jPanelHabilidades, accessibleName);
                        int linha = table.getSelectedRow();
                        EnumHabilidades habilidade = EnumHabilidades.getNome(table.getValueAt(linha, 0).toString());
                        controlDecorator.addHabilidade(habilidade);
                    }
                }
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }

    /**
     * Creates new form JDialogNomeFkCombobox
     */
    public JDialogNomeFkCombobox(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * Me sinto mal.
     */
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jComboBoxFk = new javax.swing.JComboBox<>();
        jLabelFk = new javax.swing.JLabel();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jPanelHabilidades = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHabilidadesPessoa = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableSkils = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableHabilidadesAluno = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableHabilidadesProfissional = new javax.swing.JTable();
        jPanelHabilidadesColaborador = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableHabilidadesColaborador = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelNome.setText("Nome");

        jLabelFk.setText("jLabelFk");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableHabilidadesPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Habilidades de Pessoas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHabilidadesPessoa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableHabilidadesPessoa.getTableHeader().setReorderingAllowed(false);
        jTableHabilidadesPessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableHabilidadesPessoaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHabilidadesPessoa);
        jTableHabilidadesPessoa.getAccessibleContext().setAccessibleName("HabilidadesDePessoas");

        jTableSkils.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Skills"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSkils.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableSkils.getTableHeader().setReorderingAllowed(false);
        jTableSkils.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableSkilsMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTableSkils);
        jTableSkils.getAccessibleContext().setAccessibleName("Skills");

        jTableHabilidadesAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Habilidades de Alunos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHabilidadesAluno.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableHabilidadesAluno.getTableHeader().setReorderingAllowed(false);
        jTableHabilidadesAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableHabilidadesAlunoMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTableHabilidadesAluno);
        jTableHabilidadesAluno.getAccessibleContext().setAccessibleName("HabilidadesDeAlunos");

        jTableHabilidadesProfissional.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Habilidades de Profissionais"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHabilidadesProfissional.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableHabilidadesProfissional.getTableHeader().setReorderingAllowed(false);
        jTableHabilidadesProfissional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableHabilidadesProfissionalMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTableHabilidadesProfissional);
        jTableHabilidadesProfissional.getAccessibleContext().setAccessibleName("HabilidadesDeProfissionais");

        javax.swing.GroupLayout jPanelHabilidadesLayout = new javax.swing.GroupLayout(jPanelHabilidades);
        jPanelHabilidades.setLayout(jPanelHabilidadesLayout);
        jPanelHabilidadesLayout.setHorizontalGroup(
            jPanelHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHabilidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanelHabilidadesLayout.createSequentialGroup()
                        .addGroup(jPanelHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHabilidadesLayout.setVerticalGroup(
            jPanelHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHabilidadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHabilidadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHabilidadesLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableHabilidadesColaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Habilidades do Colaborador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHabilidadesColaborador.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableHabilidadesColaborador.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableHabilidadesColaborador);
        jTableHabilidadesColaborador.getAccessibleContext().setAccessibleName("HabilidadesDoColaborador");

        javax.swing.GroupLayout jPanelHabilidadesColaboradorLayout = new javax.swing.GroupLayout(jPanelHabilidadesColaborador);
        jPanelHabilidadesColaborador.setLayout(jPanelHabilidadesColaboradorLayout);
        jPanelHabilidadesColaboradorLayout.setHorizontalGroup(
            jPanelHabilidadesColaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHabilidadesColaboradorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelHabilidadesColaboradorLayout.setVerticalGroup(
            jPanelHabilidadesColaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHabilidadesColaboradorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelNome)
                        .addComponent(jLabelFk)
                        .addComponent(jComboBoxFk, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanelHabilidadesColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanelHabilidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelFk))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jComboBoxFk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelHabilidadesColaborador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelHabilidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            String strAcao = "incluído";
            Setor setor = ControlEmpresa.getInstance().getSetor(jComboBoxFk.getSelectedItem().toString());

            switch (acao) {
                case "Incluir":

                    ControlEmpresa.getInstance().getClass().getMethod(acao + cadastro, String.class, Setor.class)
                            .invoke(ControlEmpresa.getInstance(), jTextFieldNome.getText(), setor);
                    break;

                case "Editar":
                    strAcao = "editado";
                    int id = ((Colaborador) object).getId();
                    ControlEmpresa.getInstance().getClass().getMethod(acao + cadastro, int.class, String.class, Setor.class)
                            .invoke(ControlEmpresa.getInstance(), id, jTextFieldNome.getText(), setor);
                    break;
            }
            mensagem("Sucesso!", cadastro + " " + strAcao + " com sucesso!");
            this.dispose();
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jTableSkilsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSkilsMouseReleased
        try {
            selecionar(jTableSkils.getAccessibleContext().getAccessibleName(), evt);
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableSkilsMouseReleased

    private void jTableHabilidadesProfissionalMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHabilidadesProfissionalMouseReleased
        try {
            selecionar(jTableHabilidadesProfissional.getAccessibleContext().getAccessibleName(), evt);
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableHabilidadesProfissionalMouseReleased

    private void jTableHabilidadesPessoaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHabilidadesPessoaMouseReleased
        try {
            selecionar(jTableHabilidadesPessoa.getAccessibleContext().getAccessibleName(), evt);
        } catch (Exception e) {
            mensagemErro(e);
        }

    }//GEN-LAST:event_jTableHabilidadesPessoaMouseReleased

    private void jTableHabilidadesAlunoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHabilidadesAlunoMouseReleased
        try {
            selecionar(jTableHabilidadesAluno.getAccessibleContext().getAccessibleName(), evt);
        } catch (Exception e) {
            mensagemErro(e);
        }

    }//GEN-LAST:event_jTableHabilidadesAlunoMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDialogNomeFkCombobox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogNomeFkCombobox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogNomeFkCombobox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogNomeFkCombobox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogNomeFkCombobox dialog = new JDialogNomeFkCombobox(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxFk;
    private javax.swing.JLabel jLabelFk;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelHabilidades;
    private javax.swing.JPanel jPanelHabilidadesColaborador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableHabilidadesAluno;
    private javax.swing.JTable jTableHabilidadesColaborador;
    private javax.swing.JTable jTableHabilidadesPessoa;
    private javax.swing.JTable jTableHabilidadesProfissional;
    private javax.swing.JTable jTableSkils;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
