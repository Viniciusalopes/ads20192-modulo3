/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 29/09/2020 14:57:03 
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

import static br.com.vinicius.app.MensagemApp.*;
import static br.com.vinicius.bll.FactoryBll.*;

/**
 *
 * @author vovostudio
 */
public class CadastroSimplesApp extends javax.swing.JDialog implements IModal {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private Object object = null;
    private Class<?> classe = null;
    private String className = "";
    private String cadastro = "";
    private int id = 0;
    private String acao = "Incluir";
    private String metodo = "add";
    private String complemento = "";
    private String resultado = "incluido";
    private String mensagem = cadastro + " " + resultado + " com sucesso!";
    private String pergunta = cadastro + mensagem + "\nDeseja continuar?";
    private String[] opcoes = new String[]{"Não... melhor, deixa.", "Sim"};

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    @Override

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public void setVisible(boolean b) {
        try {
            classe = object.getClass();
            className = classe.getSimpleName();
            cadastro = className.replace("TipoMiniatura", "Tipo de Miniatura");
            id = getId(object);
            
            complemento = cadastro;

            if (id > 0) {
                acao = "Editar";
                metodo = "update";
                complemento += " [ ID: " + id + " ]";
                resultado = "editado";
                mensagem = cadastro + " " + resultado + " com sucesso!";
                jTextFieldNome.setText(classe.getMethod("get" + className + "_nome").invoke(object).toString());
            }
            this.setTitle(acao + " cadastro de " + complemento);

            super.setVisible(b);

        } catch (Exception e) {
            mensagemErro(e);
        }
    }

    //
    /**
     * Creates new form FotoApp
     */
    public CadastroSimplesApp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        jLabelNome.setText("Nome");

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNome)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOK)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOK))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        try {
            classe.getMethod("set" + className + "_nome", String.class).invoke(object, jTextFieldNome.getText());
            Object dal = getDal(className);
            dal.getClass().getMethod(metodo, classe).invoke(dal, object);

            pergunta = cadastro + mensagem + "\nDeseja continuar?";
            if (metodo.equals("add")) {
                if (mensagemEscolher(pergunta, opcoes) > 0) {
                    object = classe.getConstructor().newInstance();
                    jTextFieldNome.setText("");
                    jTextFieldNome.requestFocus();
                }
            } else {
                mensagem("Sucesso!", mensagem);
            }
            this.dispose();

        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonOKActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroSimplesApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroSimplesApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroSimplesApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroSimplesApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroSimplesApp dialog = new CadastroSimplesApp(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
