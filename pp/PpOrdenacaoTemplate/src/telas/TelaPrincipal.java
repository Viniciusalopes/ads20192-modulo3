/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 02/10/2020 18:49:34 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - TEMPLATE METHOD
 *  Exercício  : Métodos de ordenação
 *  ------------------------------------------------------------------------------------------------
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */
package telas;

import templates.SituacaoCursoNome;
import templates.CursoNome;
import templates.Nome;
import templates.Sobrenome;
import templates.SituacaoNome;
import templates.CursoEnfaseNome;
import templates.EnfaseNome;
import templates.EnfaseCursoNome;
import javax.swing.JOptionPane;
import classes.Aluno;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import persistencia.BdAlunos;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGrid = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton_Sobrenome_ = new javax.swing.JButton();
        jButton_Nome_ = new javax.swing.JButton();
        jButton_Enfase_Nome_ = new javax.swing.JButton();
        jButton_Curso_Nome_ = new javax.swing.JButton();
        jButton_Situacao_Nome_ = new javax.swing.JButton();
        jButton_Situacao_Curso_Nome_ = new javax.swing.JButton();
        jButton_Enfase_Curso_Nome_ = new javax.swing.JButton();
        jButton_Curso_Enfase_Nome_ = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LISTA DE ALUNOS");

        jTableGrid.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTableGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "CURSO", "SITUAÇÃO", "ENFASE"
            }
        ));
        jTableGrid.setRowHeight(30);
        jScrollPane1.setViewportView(jTableGrid);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Listar por:");

        jButton_Sobrenome_.setText("SOBRENOME");
        jButton_Sobrenome_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Sobrenome_ActionPerformed(evt);
            }
        });

        jButton_Nome_.setText("NOME");
        jButton_Nome_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Nome_ActionPerformed(evt);
            }
        });

        jButton_Enfase_Nome_.setText("ENFASE | NOME");
        jButton_Enfase_Nome_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Enfase_Nome_ActionPerformed(evt);
            }
        });

        jButton_Curso_Nome_.setText("CURSO | NOME");
        jButton_Curso_Nome_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Curso_Nome_ActionPerformed(evt);
            }
        });

        jButton_Situacao_Nome_.setText("SITUAÇÃO | NOME");
        jButton_Situacao_Nome_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Situacao_Nome_ActionPerformed(evt);
            }
        });

        jButton_Situacao_Curso_Nome_.setText("SITUAÇÃO | CURSO | NOME");
        jButton_Situacao_Curso_Nome_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Situacao_Curso_Nome_ActionPerformed(evt);
            }
        });

        jButton_Enfase_Curso_Nome_.setText("ENFASE | CURSO | NOME");
        jButton_Enfase_Curso_Nome_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Enfase_Curso_Nome_ActionPerformed(evt);
            }
        });

        jButton_Curso_Enfase_Nome_.setText("CURSO | ENFASE | NOME");
        jButton_Curso_Enfase_Nome_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Curso_Enfase_Nome_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton_Sobrenome_, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton_Situacao_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(jButton_Situacao_Curso_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Enfase_Curso_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Enfase_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Curso_Enfase_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Curso_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_Sobrenome_, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(jButton_Enfase_Nome_, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(jButton_Curso_Nome_, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                    .addComponent(jButton_Nome_, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Situacao_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Situacao_Curso_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Enfase_Curso_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Curso_Enfase_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fillGrid(ArrayList<Aluno> lista) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableGrid.getModel();
            model.setNumRows(0);

            for (Aluno a : lista) {
                model.addRow(new String[]{
                    a.getNome(),
                    a.getCurso(),
                    a.getSituacao(),
                    a.getEnfase()
                });
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void jButton_Sobrenome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Sobrenome_ActionPerformed
        try {
            Sobrenome objeto = new Sobrenome(BdAlunos.getCaminhoArquivo());
            fillGrid(objeto.listagemDeAlunos());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton_Sobrenome_ActionPerformed

    private void jButton_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Nome_ActionPerformed
        try {
            Nome objeto = new Nome(BdAlunos.getCaminhoArquivo());
            fillGrid(objeto.listagemDeAlunos());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton_Nome_ActionPerformed

    private void jButton_Enfase_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Enfase_Nome_ActionPerformed
        try {
            EnfaseNome objeto = new EnfaseNome(BdAlunos.getCaminhoArquivo());
            fillGrid(objeto.listagemDeAlunos());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton_Enfase_Nome_ActionPerformed

    private void jButton_Curso_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Curso_Nome_ActionPerformed
        try {
            CursoNome objeto = new CursoNome(BdAlunos.getCaminhoArquivo());
            fillGrid(objeto.listagemDeAlunos());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton_Curso_Nome_ActionPerformed

    private void jButton_Situacao_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Situacao_Nome_ActionPerformed
        try {
            SituacaoNome objeto = new SituacaoNome(BdAlunos.getCaminhoArquivo());
            fillGrid(objeto.listagemDeAlunos());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton_Situacao_Nome_ActionPerformed

    private void jButton_Situacao_Curso_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Situacao_Curso_Nome_ActionPerformed
        try {
            SituacaoCursoNome objeto = new SituacaoCursoNome(BdAlunos.getCaminhoArquivo());
            fillGrid(objeto.listagemDeAlunos());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton_Situacao_Curso_Nome_ActionPerformed

    private void jButton_Enfase_Curso_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Enfase_Curso_Nome_ActionPerformed
        try {
            EnfaseCursoNome objeto = new EnfaseCursoNome(BdAlunos.getCaminhoArquivo());
            fillGrid(objeto.listagemDeAlunos());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton_Enfase_Curso_Nome_ActionPerformed

    private void jButton_Curso_Enfase_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Curso_Enfase_Nome_ActionPerformed
        try {
            CursoEnfaseNome objeto = new CursoEnfaseNome(BdAlunos.getCaminhoArquivo());
            fillGrid(objeto.listagemDeAlunos());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton_Curso_Enfase_Nome_ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Curso_Enfase_Nome_;
    private javax.swing.JButton jButton_Curso_Nome_;
    private javax.swing.JButton jButton_Enfase_Curso_Nome_;
    private javax.swing.JButton jButton_Enfase_Nome_;
    private javax.swing.JButton jButton_Nome_;
    private javax.swing.JButton jButton_Situacao_Curso_Nome_;
    private javax.swing.JButton jButton_Situacao_Nome_;
    private javax.swing.JButton jButton_Sobrenome_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGrid;
    // End of variables declaration//GEN-END:variables
}
