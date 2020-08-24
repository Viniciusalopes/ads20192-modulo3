/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.awt.Color;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author vovostudio
 */
public class JFrameOrdenacao extends javax.swing.JFrame {

    int[] valores = new int[5];
    int posicao1 = 0;
    int posicao2 = 1;
    Color cor;

    /**
     * Creates new form JFrameOrdenacao
     */
    public JFrameOrdenacao() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    private void vetorOrdenado() {
        valores = new int[]{1, 2, 3, 4, 5};
    }

    private void sorteiaValores() {

        for (int i = 0; i < valores.length; i++) {
            int valor = new Random().nextInt(valores.length) + 1;
            int j;
            for (j = 0; j < i && valores[j] != valor; j++) {
            }
            if (j == i) {
                valores[i] = valor;
            } else {
                i--;
            }
        }
    }

    private void preencheLabels() {
        jLabel1.setText(valores[0] + "");
        jLabel2.setText(valores[1] + "");
        jLabel3.setText(valores[2] + "");
        jLabel4.setText(valores[3] + "");
        jLabel5.setText(valores[4] + "");
    }

    private void ajustaTamanhos() {
        jPanel1.setPreferredSize(new java.awt.Dimension(75, (valores[0] * 50)));
        jPanel2.setPreferredSize(new java.awt.Dimension(75, (valores[1] * 50)));
        jPanel3.setPreferredSize(new java.awt.Dimension(75, (valores[2] * 50)));
        jPanel4.setPreferredSize(new java.awt.Dimension(75, (valores[3] * 50)));
        jPanel5.setPreferredSize(new java.awt.Dimension(75, (valores[4] * 50)));
    }

    private void colorir(Color cor) {
        jPanel1.setBackground(cor);
        jPanel2.setBackground(cor);
        jPanel3.setBackground(cor);
        jPanel4.setBackground(cor);
        jPanel5.setBackground(cor);
    }

    private void colorir2() {
        jPanel1.setBackground((posicao1 != 0 && posicao2 != 0) ? Color.YELLOW : Color.CYAN);
        jPanel2.setBackground((posicao1 != 1 && posicao2 != 1) ? Color.YELLOW : Color.CYAN);
        jPanel3.setBackground((posicao1 != 2 && posicao2 != 2) ? Color.YELLOW : Color.CYAN);
        jPanel4.setBackground((posicao1 != 3 && posicao2 != 3) ? Color.YELLOW : Color.CYAN);
        jPanel5.setBackground((posicao1 != 4 && posicao2 != 4) ? Color.YELLOW : Color.CYAN);
    }

    private void colorirOrdenados() {
        jPanel1.setBackground((posicao1 != 0 && posicao2 != 0) ? Color.YELLOW : Color.GREEN);
        jPanel2.setBackground((posicao1 != 1 && posicao2 != 1) ? Color.YELLOW : Color.GREEN);
        jPanel3.setBackground((posicao1 != 2 && posicao2 != 2) ? Color.YELLOW : Color.GREEN);
        jPanel4.setBackground((posicao1 != 3 && posicao2 != 3) ? Color.YELLOW : Color.GREEN);
        jPanel5.setBackground((posicao1 != 4 && posicao2 != 4) ? Color.YELLOW : Color.GREEN);
    }

    private void ordenar() {
        // FONTE: https://www.devmedia.com.br/algoritmos-de-ordenacao-em-java/32693
        boolean troca = false;
        int i, j, aux;
        try {
            for (i = valores.length - 1; i > 0; i--) {
                troca = false;
                for (j = 0; j < i; j++) {
                    posicao1 = j;
                    posicao2 = j + 1;
                    preencheLabels();
                    ajustaTamanhos();
                    colorir2();

                    if (valores[posicao1] > valores[posicao2]) {
                        JOptionPane.showOptionDialog(rootPane, valores[posicao1] + " > " + valores[posicao2] + ": alternar posiçoes.",
                                "Fora de ordem!", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Alternar"}, 0);

                        aux = valores[posicao1];
                        valores[posicao1] = valores[posicao2];
                        valores[posicao2] = aux;
                        troca = true;
                        preencheLabels();
                        ajustaTamanhos();
                        colorirOrdenados();
                        JOptionPane.showOptionDialog(rootPane, valores[posicao1] + " e " + valores[posicao2] + " ordenados.",
                                "Ordenados!", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Ir para o próximo"}, 0);
                    } else {
                        JOptionPane.showOptionDialog(rootPane, valores[posicao1] + " < " + valores[posicao2] + ": manter posições.",
                                "Nada a fazer!", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Ir para o próximo"}, 0);
                    }
                }
                if (!troca) {
                    break;
                }

            }
            colorir(Color.green);
            jButtonSorteia.setEnabled(true);
            jButtonVetOrdenado.setEnabled(true);
            jButtonOrdenar.setEnabled(false);
            JOptionPane.showMessageDialog(rootPane, "Ordenação concluída!", "Fim", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButtonSorteia = new javax.swing.JButton();
        jButtonOrdenar = new javax.swing.JButton();
        jButtonVetOrdenado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BubbleSort - Método de ordenação");

        jPanel1.setBackground(new java.awt.Color(102, 255, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(75, 50));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("1");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(75, 100));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("2");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 255, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(75, 150));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("3");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 255, 102));
        jPanel4.setPreferredSize(new java.awt.Dimension(75, 200));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("4");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(102, 255, 102));
        jPanel5.setPreferredSize(new java.awt.Dimension(75, 250));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("5");
        jLabel5.setFocusable(false);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setPreferredSize(new java.awt.Dimension(8, 15));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButtonSorteia.setText("Sortear");
        jButtonSorteia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSorteiaActionPerformed(evt);
            }
        });

        jButtonOrdenar.setText("Ordenar");
        jButtonOrdenar.setEnabled(false);
        jButtonOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdenarActionPerformed(evt);
            }
        });

        jButtonVetOrdenado.setText("Ordenado");
        jButtonVetOrdenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVetOrdenadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSorteia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVetOrdenado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOrdenar))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSorteia)
                    .addComponent(jButtonOrdenar)
                    .addComponent(jButtonVetOrdenado))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSorteiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSorteiaActionPerformed
        sorteiaValores();
        preencheLabels();
        ajustaTamanhos();
        colorir(Color.YELLOW);
        jButtonSorteia.setEnabled(false);
        jButtonVetOrdenado.setEnabled(false);
        jButtonOrdenar.setEnabled(true);
    }//GEN-LAST:event_jButtonSorteiaActionPerformed

    private void jButtonOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenarActionPerformed
        ordenar();
    }//GEN-LAST:event_jButtonOrdenarActionPerformed

    private void jButtonVetOrdenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVetOrdenadoActionPerformed
        vetorOrdenado();
        preencheLabels();
        ajustaTamanhos();
        colorir(Color.YELLOW);
        jButtonSorteia.setEnabled(false);
        jButtonVetOrdenado.setEnabled(false);
        jButtonOrdenar.setEnabled(true);
    }//GEN-LAST:event_jButtonVetOrdenadoActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameOrdenacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameOrdenacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameOrdenacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameOrdenacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameOrdenacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOrdenar;
    private javax.swing.JButton jButtonSorteia;
    private javax.swing.JButton jButtonVetOrdenado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
