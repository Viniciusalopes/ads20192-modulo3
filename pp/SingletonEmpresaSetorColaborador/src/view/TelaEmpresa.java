/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/09/2020 14:58:12 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - TEMPLATE METHOD
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Tela de cadastros relacionados à Empresa.
 *  ------------------------------------------------------------------------------------------------| 
 */
package view;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static view.util.Mensagem.*;
import view.util.ViewUtil;
import static view.util.ViewUtil.getJTable;

/**
 *
 * @author vovostudio
 */
public class TelaEmpresa extends TelaTemplate {

    @Override
    public String getRegister() {
        return jTabbedPaneTabs.getSelectedComponent().getAccessibleContext().getAccessibleName();
    }

    @Override
    public void select() throws Exception {
        getRegister();
        setSelectedObject(getSelectedId(jTabbedPaneTabs, "ID"));
    }

    @Override
    public void action(String actionCommand) throws Exception {
        getRegister();
        getActionModal(actionCommand);
        refreshGridSetor();
        refreshGridColaborador();
        select();
    }

    @Override
    public int getIndexIdColumn(JTable table, String idColumnName) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < model.getColumnCount(); i++) {
            if (model.getColumnName(i).equals(idColumnName)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public JPanel getSelectedPanel() {
        for (Component component : jTabbedPaneTabs.getComponents()) {
            if (component instanceof JPanel) {
                if (component.getAccessibleContext().getAccessibleName().equals(getRegister())) {
                    return (JPanel) component;
                }
            }
        }
        return null;
    }

    @Override
    public JTable getJTable(JPanel panel) throws Exception {
        return ViewUtil.getJTable(panel, getRegister());
    }

    private void refreshGridSetor() throws Exception {
        refreshGrid((DefaultTableModel) jTableSetor.getModel(), control.getLinhasSetores());
    }

    private void refreshGridColaborador() throws Exception {
        refreshGrid((DefaultTableModel) jTableColaborador.getModel(), control.getLinhasColaboradores());
    }

    /**
     * Creates new form TelaEmpresa
     */
    public TelaEmpresa() throws Exception {
        // Chama o construtor do TEMPLATE para inicializar o control SINGLETON
        super();
        initComponents();
        this.setLocationRelativeTo(null);
        refreshGridSetor();
        refreshGridColaborador();
        select();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBotoesAcao = new javax.swing.JPanel();
        jButtonIncluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jTabbedPaneTabs = new javax.swing.JTabbedPane();
        jPanelSetor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSetor = new javax.swing.JTable();
        jPanelColaborador = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableColaborador = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonIncluir.setText("Incluir");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotoesAcaoLayout = new javax.swing.GroupLayout(jPanelBotoesAcao);
        jPanelBotoesAcao.setLayout(jPanelBotoesAcaoLayout);
        jPanelBotoesAcaoLayout.setHorizontalGroup(
            jPanelBotoesAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesAcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBotoesAcaoLayout.setVerticalGroup(
            jPanelBotoesAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesAcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotoesAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluir)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableSetor.setAutoCreateRowSorter(true);
        jTableSetor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Setor", "Colaboradores"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSetor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableSetor.getTableHeader().setReorderingAllowed(false);
        jTableSetor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableSetorMouseReleased(evt);
            }
        });
        jTableSetor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableSetorKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSetor);
        if (jTableSetor.getColumnModel().getColumnCount() > 0) {
            jTableSetor.getColumnModel().getColumn(0).setMinWidth(100);
            jTableSetor.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableSetor.getColumnModel().getColumn(0).setMaxWidth(100);
            jTableSetor.getColumnModel().getColumn(2).setMinWidth(150);
            jTableSetor.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTableSetor.getColumnModel().getColumn(2).setMaxWidth(150);
        }
        jTableSetor.getAccessibleContext().setAccessibleName("Setor");

        javax.swing.GroupLayout jPanelSetorLayout = new javax.swing.GroupLayout(jPanelSetor);
        jPanelSetor.setLayout(jPanelSetorLayout);
        jPanelSetorLayout.setHorizontalGroup(
            jPanelSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSetorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelSetorLayout.setVerticalGroup(
            jPanelSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSetorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneTabs.addTab("Setores", jPanelSetor);
        jPanelSetor.getAccessibleContext().setAccessibleName("Setor");

        jTableColaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Colaborador", "Setor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableColaborador.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableColaborador.getTableHeader().setReorderingAllowed(false);
        jTableColaborador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableColaboradorMouseReleased(evt);
            }
        });
        jTableColaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableColaboradorKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableColaborador);
        if (jTableColaborador.getColumnModel().getColumnCount() > 0) {
            jTableColaborador.getColumnModel().getColumn(0).setMinWidth(100);
            jTableColaborador.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableColaborador.getColumnModel().getColumn(0).setMaxWidth(100);
        }
        jTableColaborador.getAccessibleContext().setAccessibleName("Colaborador");

        javax.swing.GroupLayout jPanelColaboradorLayout = new javax.swing.GroupLayout(jPanelColaborador);
        jPanelColaborador.setLayout(jPanelColaboradorLayout);
        jPanelColaboradorLayout.setHorizontalGroup(
            jPanelColaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelColaboradorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelColaboradorLayout.setVerticalGroup(
            jPanelColaboradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelColaboradorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneTabs.addTab("Colaboradores", jPanelColaborador);
        jPanelColaborador.getAccessibleContext().setAccessibleName("Colaborador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelBotoesAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneTabs)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBotoesAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneTabs)
                .addContainerGap())
        );

        jTabbedPaneTabs.getAccessibleContext().setAccessibleName("Tabs");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        try {
            action(evt.getActionCommand());
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jTableSetorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableSetorKeyReleased
        try {
            select();
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableSetorKeyReleased

    private void jTableSetorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSetorMouseReleased
        try {
            select();
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableSetorMouseReleased

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        try {
            action(evt.getActionCommand());
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {
            action(evt.getActionCommand());
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTableColaboradorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableColaboradorKeyReleased
        try {
            select();
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableColaboradorKeyReleased

    private void jTableColaboradorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableColaboradorMouseReleased
        try {
            select();
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableColaboradorMouseReleased

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
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaEmpresa().setVisible(true);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JPanel jPanelBotoesAcao;
    private javax.swing.JPanel jPanelColaborador;
    private javax.swing.JPanel jPanelSetor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPaneTabs;
    private javax.swing.JTable jTableColaborador;
    private javax.swing.JTable jTableSetor;
    // End of variables declaration//GEN-END:variables
}
