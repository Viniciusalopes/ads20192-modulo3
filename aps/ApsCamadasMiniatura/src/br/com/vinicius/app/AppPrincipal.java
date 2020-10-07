/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 29/09/2020 13:48:54 
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
package br.com.vinicius.app;

import br.com.vinicius.generic.AppIModal;
import static br.com.vinicius.generic.AppFactory.fillGrid;
import static br.com.vinicius.app.AppMensagem.*;
import static br.com.vinicius.generic.BllFactory.*;
import br.com.vinicius.bll.BllMiniatura;
import br.com.vinicius.model.Miniatura;
import java.awt.event.KeyEvent;

/**
 *
 * @author vovostudio
 */
public class AppPrincipal extends javax.swing.JFrame {

    private BllMiniatura mbll;

    /**
     * Creates new form JFramePrincipal
     */
    public AppPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            fillGrid(jTableTema);
            fillGrid(jTableFabricante);
            fillGrid(jTableTipo);
            fillGrid(jTableMiniatura);
            mbll = new BllMiniatura();

        } catch (Exception e) {
            mensagemErro(e);
            System.exit(1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTabbedPanePrincipal = new javax.swing.JTabbedPane();
        jPanelMiniatura = new javax.swing.JPanel();
        jButtonIncluirMiniatura = new javax.swing.JButton();
        jScrollPaneMiniaturas = new javax.swing.JScrollPane();
        jTableMiniatura = new javax.swing.JTable();
        jLabelObservacoes = new javax.swing.JLabel();
        jScrollPaneObservacoes = new javax.swing.JScrollPane();
        jTextAreaObservacoes = new javax.swing.JTextArea();
        jScrollPaneGaleria = new javax.swing.JScrollPane();
        jTableGaleria = new javax.swing.JTable();
        jPanelFabricante = new javax.swing.JPanel();
        jButtonIncluirFabricante = new javax.swing.JButton();
        jScrollPaneFabricante = new javax.swing.JScrollPane();
        jTableFabricante = new javax.swing.JTable();
        jPanelTema = new javax.swing.JPanel();
        jScrollPaneMiniaturas2 = new javax.swing.JScrollPane();
        jTableTema = new javax.swing.JTable();
        jButtonIncluirTema = new javax.swing.JButton();
        jPanelTipo = new javax.swing.JPanel();
        jScrollPaneTipo = new javax.swing.JScrollPane();
        jTableTipo = new javax.swing.JTable();
        jButtonIncluirTipo = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonIncluirMiniatura.setText("Incluir");
        jButtonIncluirMiniatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirMiniaturaActionPerformed(evt);
            }
        });

        jTableMiniatura.setAutoCreateRowSorter(true);
        jTableMiniatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Modelo", "Ano", "Edição", "Escala", "Valor", "Fabricante", "Tipo", "Tema", "Fotos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMiniatura.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableMiniatura.getTableHeader().setReorderingAllowed(false);
        jTableMiniatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableMiniaturaMouseReleased(evt);
            }
        });
        jTableMiniatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableMiniaturaKeyReleased(evt);
            }
        });
        jScrollPaneMiniaturas.setViewportView(jTableMiniatura);
        if (jTableMiniatura.getColumnModel().getColumnCount() > 0) {
            jTableMiniatura.getColumnModel().getColumn(0).setMinWidth(100);
            jTableMiniatura.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableMiniatura.getColumnModel().getColumn(0).setMaxWidth(100);
        }
        jTableMiniatura.getAccessibleContext().setAccessibleName("Miniatura");

        jLabelObservacoes.setText("Observações");

        jTextAreaObservacoes.setColumns(20);
        jTextAreaObservacoes.setRows(5);
        jTextAreaObservacoes.setPreferredSize(new java.awt.Dimension(220, 80));
        jScrollPaneObservacoes.setViewportView(jTextAreaObservacoes);

        jTableGaleria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableGaleria.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneGaleria.setViewportView(jTableGaleria);
        jTableGaleria.getAccessibleContext().setAccessibleName("Galeria");

        javax.swing.GroupLayout jPanelMiniaturaLayout = new javax.swing.GroupLayout(jPanelMiniatura);
        jPanelMiniatura.setLayout(jPanelMiniaturaLayout);
        jPanelMiniaturaLayout.setHorizontalGroup(
            jPanelMiniaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMiniaturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMiniaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneObservacoes, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPaneMiniaturas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
                    .addComponent(jScrollPaneGaleria)
                    .addGroup(jPanelMiniaturaLayout.createSequentialGroup()
                        .addGroup(jPanelMiniaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelObservacoes)
                            .addComponent(jButtonIncluirMiniatura))
                        .addGap(0, 835, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelMiniaturaLayout.setVerticalGroup(
            jPanelMiniaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMiniaturaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonIncluirMiniatura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneMiniaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelObservacoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneGaleria, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonIncluirMiniatura.getAccessibleContext().setAccessibleName("Miniatura");

        jTabbedPanePrincipal.addTab("Miniaturas", jPanelMiniatura);

        jButtonIncluirFabricante.setText("Incluir");
        jButtonIncluirFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirFabricanteActionPerformed(evt);
            }
        });

        jTableFabricante.setAutoCreateRowSorter(true);
        jTableFabricante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Fabricante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFabricante.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableFabricante.getTableHeader().setReorderingAllowed(false);
        jTableFabricante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableFabricanteMouseReleased(evt);
            }
        });
        jTableFabricante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableFabricanteKeyReleased(evt);
            }
        });
        jScrollPaneFabricante.setViewportView(jTableFabricante);
        if (jTableFabricante.getColumnModel().getColumnCount() > 0) {
            jTableFabricante.getColumnModel().getColumn(0).setMinWidth(100);
            jTableFabricante.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableFabricante.getColumnModel().getColumn(0).setMaxWidth(100);
        }
        jTableFabricante.getAccessibleContext().setAccessibleName("Fabricante");

        javax.swing.GroupLayout jPanelFabricanteLayout = new javax.swing.GroupLayout(jPanelFabricante);
        jPanelFabricante.setLayout(jPanelFabricanteLayout);
        jPanelFabricanteLayout.setHorizontalGroup(
            jPanelFabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFabricanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneFabricante, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFabricanteLayout.createSequentialGroup()
                        .addComponent(jButtonIncluirFabricante)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelFabricanteLayout.setVerticalGroup(
            jPanelFabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFabricanteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonIncluirFabricante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneFabricante)
                .addContainerGap())
        );

        jButtonIncluirFabricante.getAccessibleContext().setAccessibleName("Fabricante");

        jTabbedPanePrincipal.addTab("Fabricantes", jPanelFabricante);

        jTableTema.setAutoCreateRowSorter(true);
        jTableTema.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Tema"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTema.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTema.getTableHeader().setReorderingAllowed(false);
        jTableTema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableTemaMouseReleased(evt);
            }
        });
        jTableTema.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableTemaKeyReleased(evt);
            }
        });
        jScrollPaneMiniaturas2.setViewportView(jTableTema);
        if (jTableTema.getColumnModel().getColumnCount() > 0) {
            jTableTema.getColumnModel().getColumn(0).setMinWidth(100);
            jTableTema.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableTema.getColumnModel().getColumn(0).setMaxWidth(100);
        }
        jTableTema.getAccessibleContext().setAccessibleName("Tema");
        jTableTema.getAccessibleContext().setAccessibleDescription("");

        jButtonIncluirTema.setText("Incluir");
        jButtonIncluirTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirTemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTemaLayout = new javax.swing.GroupLayout(jPanelTema);
        jPanelTema.setLayout(jPanelTemaLayout);
        jPanelTemaLayout.setHorizontalGroup(
            jPanelTemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTemaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneMiniaturas2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
                    .addGroup(jPanelTemaLayout.createSequentialGroup()
                        .addComponent(jButtonIncluirTema)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelTemaLayout.setVerticalGroup(
            jPanelTemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTemaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonIncluirTema)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneMiniaturas2, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonIncluirTema.getAccessibleContext().setAccessibleName("Tema");

        jTabbedPanePrincipal.addTab("Temas", jPanelTema);

        jTableTipo.setAutoCreateRowSorter(true);
        jTableTipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tipo de Miniatura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTipo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTipo.getTableHeader().setReorderingAllowed(false);
        jTableTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableTipoMouseReleased(evt);
            }
        });
        jTableTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableTipoKeyReleased(evt);
            }
        });
        jScrollPaneTipo.setViewportView(jTableTipo);
        if (jTableTipo.getColumnModel().getColumnCount() > 0) {
            jTableTipo.getColumnModel().getColumn(0).setMinWidth(100);
            jTableTipo.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTableTipo.getColumnModel().getColumn(0).setMaxWidth(100);
        }
        jTableTipo.getAccessibleContext().setAccessibleName("TipoMiniatura");

        jButtonIncluirTipo.setText("Incluir");
        jButtonIncluirTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTipoLayout = new javax.swing.GroupLayout(jPanelTipo);
        jPanelTipo.setLayout(jPanelTipoLayout);
        jPanelTipoLayout.setHorizontalGroup(
            jPanelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTipoLayout.createSequentialGroup()
                        .addComponent(jButtonIncluirTipo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPaneTipo))
                .addContainerGap())
        );
        jPanelTipoLayout.setVerticalGroup(
            jPanelTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonIncluirTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneTipo)
                .addContainerGap())
        );

        jButtonIncluirTipo.getAccessibleContext().setAccessibleName("TipoMiniatura");

        jTabbedPanePrincipal.addTab("Tipos de Miniaturas", jPanelTipo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPanePrincipal)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPanePrincipal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPanePrincipal.getAccessibleContext().setAccessibleName("TipoMiniatura");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirTemaActionPerformed
        try {
            getModal("Tema", "add", jTableTema, new AppSimpleForm(this, true));
            fillGrid(jTableTema);
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonIncluirTemaActionPerformed

    private void jButtonIncluirFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirFabricanteActionPerformed
        try {
            getModal("Fabricante", "add", jTableFabricante, new AppSimpleForm(this, true));
            fillGrid(jTableFabricante);
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonIncluirFabricanteActionPerformed

    private void jButtonIncluirTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirTipoActionPerformed
        try {
            getModal("TipoMiniatura", "add", jTableTipo, new AppSimpleForm(this, true));
            fillGrid(jTableTipo);
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonIncluirTipoActionPerformed

    private void jTableFabricanteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFabricanteMouseReleased
        try {
            if (evt.getClickCount() == 2) {
                getModal("Fabricante", "update", jTableFabricante, new AppSimpleForm(this, true));
                fillGrid(jTableFabricante);
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableFabricanteMouseReleased

    private void jTableTemaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTemaMouseReleased
        try {
            if (evt.getClickCount() == 2) {
                getModal("Tema", "update", jTableTema, new AppSimpleForm(this, true));
                fillGrid(jTableTema);
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableTemaMouseReleased

    private void jTableTipoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTipoMouseReleased
        try {
            if (evt.getClickCount() == 2) {
                getModal("TipoMiniatura", "update", jTableTipo, new AppSimpleForm(this, true));
                fillGrid(jTableTipo);
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableTipoMouseReleased

    private void jTableFabricanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableFabricanteKeyReleased
        try {
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                deleteRow(jTableFabricante);
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableFabricanteKeyReleased

    private void jTableTemaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableTemaKeyReleased
        try {
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                deleteRow(jTableTema);
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableTemaKeyReleased

    private void jTableTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableTipoKeyReleased
        try {
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                deleteRow(jTableTipo);
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableTipoKeyReleased

    private void jTableMiniaturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableMiniaturaKeyReleased
        try {
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                deleteRow(jTableMiniatura);
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableMiniaturaKeyReleased

    private void jTableMiniaturaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMiniaturaMouseReleased
        try {
            Miniatura miniatura = new Miniatura();
            if (jTableMiniatura.getSelectedRow() > -1) {
                miniatura = (Miniatura) mbll.getMiniaturaSelecionada(jTableMiniatura);
            }

            if ((evt.getClickCount() == 2)) {
                AppIModal modal = new AppMiniatura(this, true);
                modal.setObject(miniatura);
                modal.setVisible(true);
                fillGrid(jTableMiniatura);
            }

            jTextAreaObservacoes.setText(miniatura.getObservacoes());

        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableMiniaturaMouseReleased

    private void jButtonIncluirMiniaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirMiniaturaActionPerformed
        try {
            AppIModal modal = new AppMiniatura(this, true);
            modal.setObject(new Miniatura());
            modal.setVisible(true);
            fillGrid(jTableMiniatura);
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonIncluirMiniaturaActionPerformed

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
            java.util.logging.Logger.getLogger(AppPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIncluirFabricante;
    private javax.swing.JButton jButtonIncluirMiniatura;
    private javax.swing.JButton jButtonIncluirTema;
    private javax.swing.JButton jButtonIncluirTipo;
    private javax.swing.JLabel jLabelObservacoes;
    private javax.swing.JPanel jPanelFabricante;
    private javax.swing.JPanel jPanelMiniatura;
    private javax.swing.JPanel jPanelTema;
    private javax.swing.JPanel jPanelTipo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneFabricante;
    private javax.swing.JScrollPane jScrollPaneGaleria;
    private javax.swing.JScrollPane jScrollPaneMiniaturas;
    private javax.swing.JScrollPane jScrollPaneMiniaturas2;
    private javax.swing.JScrollPane jScrollPaneObservacoes;
    private javax.swing.JScrollPane jScrollPaneTipo;
    private javax.swing.JTabbedPane jTabbedPanePrincipal;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableFabricante;
    private javax.swing.JTable jTableGaleria;
    private javax.swing.JTable jTableMiniatura;
    private javax.swing.JTable jTableTema;
    private javax.swing.JTable jTableTipo;
    private javax.swing.JTextArea jTextAreaObservacoes;
    // End of variables declaration//GEN-END:variables
}