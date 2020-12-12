/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Aluno;
import javax.swing.table.DefaultTableModel;
import persistencia.*;

/**
 *
 * @author vovomint
 */
public class Tela extends javax.swing.JFrame {

    private String fileName = "./src/dados/RelatorioDasEnfases.csv";
    boolean trataNome = false;
    private Listas fonteListas = new Listas();

    private void fillComboBox() {
        jComboBoxOrdenar.removeAllItems();

        for (Object item : fonteListas.getItensOrdenacao()) {
            jComboBoxOrdenar.addItem((String) item);
        }
    }

    private void ordenar() throws Exception {
        String ordenador = "T" + jComboBoxOrdenar.getSelectedItem();
        trataNome = ordenador.equals("TSobrenome");
        TMPersist objTemplate = factory.Factory.getOrdenador(ordenador, fileName);
        imprimirNaGrid(objTemplate.listagemDeAlunos());
        trataNome = !ordenador.equals("TSobrenome");
    }

    public Tela() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        try {
            fillComboBox();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGrid = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxOrdenar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LISTA DE ALUNOS");

        jTableGrid.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTableGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "CURSO", "SITUAÇÃO", "ENFASE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableGrid.setRowHeight(30);
        jTableGrid.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableGrid.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableGrid.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableGrid);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Ordenar por:");

        jComboBoxOrdenar.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jComboBoxOrdenar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxOrdenarItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imprimirNaGrid(Iterable<Aluno> lista) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableGrid.getModel();
            model.setNumRows(0);
            for (Aluno aluno : lista) {
                model.addRow(new Object[]{
                    (trataNome) ? nomeTratado(aluno.getNome()) : aluno.getNome(),
                    aluno.getCurso(),
                    aluno.getSituacao(),
                    aluno.getEnfase()
                });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }

    private String nomeTratado(String nome) {
        String[] partes = nome.split(" ");
        String sobrenome = partes[partes.length - 1];

        if (sobrenome.equalsIgnoreCase("junior")
                || sobrenome.equalsIgnoreCase("neto")
                || sobrenome.equalsIgnoreCase("filho")) {
            sobrenome = partes[partes.length - 2];
        }
        return sobrenome.toUpperCase() + ", " + partes[0];
    }

    private void jComboBoxOrdenarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxOrdenarItemStateChanged
        try {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                ordenar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_jComboBoxOrdenarItemStateChanged

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGrid;
    // End of variables declaration//GEN-END:variables
}
