package interfacegrafica;

import javax.swing.JOptionPane;
import classededados.Aluno;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import persistencia.*;

public class Janela extends javax.swing.JFrame {

    public Janela() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGridAlunos = new javax.swing.JTable();
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

        jTableGridAlunos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jTableGridAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOME", "CURSO", "SITUAÇÃO", "ENFASE"
            }
        ));
        jTableGridAlunos.setRowHeight(30);
        jScrollPane1.setViewportView(jTableGridAlunos);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton_Enfase_Curso_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton_Enfase_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton_Curso_Enfase_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton_Curso_Nome_, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void imprimirNaGrid(ArrayList<Aluno> dados) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableGridAlunos.getModel();
            model.setNumRows(0);
            int pos = 1;
            while (pos < dados.size()) {
                String[] linha = new String[4];
                Aluno obj = dados.get(pos);
                linha[0] = obj.getNome();
                linha[1] = obj.getCurso();
                linha[2] = obj.getSituacao();
                linha[3] = obj.getEnfase();
                model.addRow(linha);
                pos++;
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }

    private void imprimirNaGridTratandoNome(ArrayList<Aluno> dados) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableGridAlunos.getModel();
            model.setNumRows(0);
            int pos = 1;
            while (pos < dados.size()) {
                String[] linha = new String[4];
                Aluno obj = dados.get(pos);

                String[] nome = obj.getNome().split(" ");
                String sobrenome = nome[nome.length - 1];

                if (sobrenome.equalsIgnoreCase("junior") || sobrenome.equalsIgnoreCase("neto") || sobrenome.equalsIgnoreCase("filho")) {
                    sobrenome = nome[nome.length - 2];
                }

                linha[0] = sobrenome.toUpperCase() + ", " + nome[0];
                linha[1] = obj.getCurso();
                linha[2] = obj.getSituacao();
                linha[3] = obj.getEnfase();
                model.addRow(linha);
                pos++;
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }

    private void jButton_Sobrenome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Sobrenome_ActionPerformed
        try {
            String nome = "./src/dados/RelatorioDasEnfases.csv";
            Por_Sobrenome objeto = new Por_Sobrenome(nome);
            imprimirNaGridTratandoNome(objeto.listagemDeAlunos());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jButton_Sobrenome_ActionPerformed

    private void jButton_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Nome_ActionPerformed
        try {
            String nome = "./src/dados/RelatorioDasEnfases.csv";
            Por_Nome objeto = new Por_Nome(nome);
            imprimirNaGrid(objeto.listagemDeAlunos());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jButton_Nome_ActionPerformed

    private void jButton_Enfase_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Enfase_Nome_ActionPerformed
        try {
            String arquivo = "./src/dados/RelatorioDasEnfases.csv";
            Por_Enfase objeto = new Por_Enfase(arquivo);
            ArrayList<Aluno> array = objeto.listagemDeAlunos();
            Por_Enfase_Nome segundaOrdenacao = new Por_Enfase_Nome();
            imprimirNaGrid(segundaOrdenacao.listagemDeAlunos(array));
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jButton_Enfase_Nome_ActionPerformed

    private void jButton_Curso_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Curso_Nome_ActionPerformed
        try {
            String arquivo = "./src/dados/RelatorioDasEnfases.csv";
            Por_Curso objeto = new Por_Curso(arquivo);
            ArrayList<Aluno> array = objeto.listagemDeAlunos();
            Por_Curso_Nome segundaOrdenacao = new Por_Curso_Nome();
            imprimirNaGrid(segundaOrdenacao.listagemDeAlunos(array));
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jButton_Curso_Nome_ActionPerformed

    private void jButton_Situacao_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Situacao_Nome_ActionPerformed
        try {
            String arquivo = "./src/dados/RelatorioDasEnfases.csv";
            Por_Situacao objeto = new Por_Situacao(arquivo);
            ArrayList<Aluno> array = objeto.listagemDeAlunos();
            Por_Situacao_Nome segundaOrdenacao = new Por_Situacao_Nome();
            imprimirNaGrid(segundaOrdenacao.listagemDeAlunos(array));
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jButton_Situacao_Nome_ActionPerformed

    private void jButton_Situacao_Curso_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Situacao_Curso_Nome_ActionPerformed
        try {
            String arquivo = "./src/dados/RelatorioDasEnfases.csv";
            Por_Situacao_ objeto = new Por_Situacao_(arquivo);
            ArrayList<Aluno> array = objeto.listagemDeAlunos();
            Por_Situacao_Curso segundaOrdenacao = new Por_Situacao_Curso();
            array = segundaOrdenacao.listagemDeAlunos(array);
            Por_Situacao_Curso_Nome terceiraOrdenacao = new Por_Situacao_Curso_Nome();
            imprimirNaGrid(terceiraOrdenacao.listagemDeAlunos(array));
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jButton_Situacao_Curso_Nome_ActionPerformed

    private void jButton_Enfase_Curso_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Enfase_Curso_Nome_ActionPerformed
        try {
            String arquivo = "./src/dados/RelatorioDasEnfases.csv";
            Por_Enfase_ objeto = new Por_Enfase_(arquivo);
            ArrayList<Aluno> array = objeto.listagemDeAlunos();
            Por_Enfase_Curso segundaOrdenacao = new Por_Enfase_Curso();
            array = segundaOrdenacao.listagemDeAlunos(array);
            Por_Enfase_Curso_Nome terceiraOrdenacao = new Por_Enfase_Curso_Nome();
            imprimirNaGrid(terceiraOrdenacao.listagemDeAlunos(array));
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
        }
    }//GEN-LAST:event_jButton_Enfase_Curso_Nome_ActionPerformed

    private void jButton_Curso_Enfase_Nome_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Curso_Enfase_Nome_ActionPerformed
        try {
            String arquivo = "./src/dados/RelatorioDasEnfases.csv";
            Por_Curso_ objeto = new Por_Curso_(arquivo);
            ArrayList<Aluno> array = objeto.listagemDeAlunos();
            Por_Curso_Enfase segundaOrdenacao = new Por_Curso_Enfase();
            array = segundaOrdenacao.listagemDeAlunos(array);
            Por_Curso_Enfase_Nome terceiraOrdenacao = new Por_Curso_Enfase_Nome();
            imprimirNaGrid(terceiraOrdenacao.listagemDeAlunos(array));
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro);
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
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela().setVisible(true);
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
    private javax.swing.JTable jTableGridAlunos;
    // End of variables declaration//GEN-END:variables
}
