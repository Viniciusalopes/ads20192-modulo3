/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 30/09/2020 22:14:59 
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
import static br.com.vinicius.generic.AppFactory.fillComboBox;
import static br.com.vinicius.generic.AppFactory.fillComboBoxes;
import static br.com.vinicius.generic.AppFactory.validateSelectionComboBoxes;
import br.com.vinicius.bll.*;
import br.com.vinicius.model.Miniatura;
import static br.com.vinicius.app.AppMensagem.*;
import static br.com.vinicius.generic.BllFactory.*;
import br.com.vinicius.dal.DalFabricante;
import java.util.Calendar;
import javax.swing.JComboBox;

/**
 *
 * @author vovostudio
 */
public class AppMiniatura extends javax.swing.JDialog implements AppIModal {

    private String action = "Incluir ";
    private Miniatura mini;
    private BllMiniatura bll = null;

    @Override
    public void setObject(Object object) throws Exception {
        mini = (Miniatura) object;
    }

    @Override
    public void setVisible(boolean b) {
        try {
            bll = new BllMiniatura();
            if (mini.getMiniatura_id() > 0) {
                action = "Editar ";
            }
            this.setTitle(action + this.getTitle());

            if(new DalFabricante().isEmptyTable())
            fillComboBoxes(jPanelCombos);

//            // Verifico se tem pelo menos um cadastro dos relacionamentos necessários
//            if (existemRelacionamentos(
//                    new String[]{"Fabricante", "TipoMiniatura", "Tema"},
//                    new String[]{"Fabricante", "Tipo de Miniatura", "Tema"},
//                    new JComboBox[]{jComboBoxFabricante, jComboBoxTipoMiniatura, jComboBoxTema})) {
                valoresIniciais();
                super.setVisible(b);
//            } else {
//                this.dispose();
//            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }

    public boolean existemRelacionamentos__(String[] relacionamentos, String[] nomesAmigaveis, JComboBox[] jComboBoxes) throws Exception {

        JComboBox jComboBox = new JComboBox();
        String pergunta = "";

        for (int i = 0; i < relacionamentos.length; i++) {
            String rel = relacionamentos[i];
            String amigavel = nomesAmigaveis[i];
            jComboBox = jComboBoxes[i];

            pergunta = "Para cadastrar uma miniatura você precisa cadastrar um " + amigavel + ".\n"
                    + "O que deseja fazer?";

            if (jComboBox.getItemCount() == 0) {
                if (mensagemEscolher(pergunta, new String[]{"Sair do sistema", "Incluir um " + amigavel}) > 0) {
                    getModal(rel, "Incluir", null, new AppSimpleForm(null, true));
                    fillComboBox(jComboBox, rel);
                }
            }

            if (jComboBox.getItemCount() == 0) {
                throw new Exception("Não é possível incluir miniaturas.\n"
                        + "Você não incluiu nenhum " + amigavel + ".");
            }
        }

        return true;
    }

    private void valoresIniciais() throws Exception {
        if (action.equals("Editar ")) {
            jTextFieldModelo.setText(mini.getModelo());

            // FONTE: https://www.guj.com.br/t/resolvido-como-obter-o-ano-atual/53778/2
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            jSpinnerAno.setModel(new javax.swing.SpinnerNumberModel(
                    Integer.parseInt(mini.getAno()), 1900, year, 1));

            if (true) {
                throw new Exception("Alterar para Int, o tipo de dado da edição no banco de dados e no modelo!");
            }
            jSpinnerEdicao.setValue(mini.getEdicao());

            String[] escala = mini.getEscala().split(":");
            jSpinnerEscalaUm.setValue(Integer.parseInt(escala[0]));
            jSpinnerEscalaPor.setValue(Integer.parseInt(escala[1]));

            jComboBoxFabricante.setSelectedItem(mini.getFabricante().getFabricante_nome());
            jComboBoxTema.setSelectedItem(mini.getTema().getTema_nome());
            jComboBoxTipoMiniatura.setSelectedItem(mini.getTipoMiniatura().getTipoMiniatura_nome());
            jFormattedTextFieldValor.setValue(String.format("%.2f", mini.getValor()));
        }
    }

    private void salvar() throws Exception {
        mini.setModelo(jTextFieldModelo.getText());
        mini.setAno(jSpinnerAno.getValue() + "");
        mini.setEdicao(jSpinnerEdicao.getValue() + "");
        mini.setEscala(jSpinnerEscalaUm.getValue() + ":" + jSpinnerEscalaPor.getValue());

        validateSelectionComboBoxes(jPanelCombos);

        mini.setFabricante(new BllFabricante().getByNome(jComboBoxFabricante.getSelectedItem() + ""));
        mini.setTipo(new BllTipoMiniatura().getByNome(jComboBoxTipoMiniatura.getSelectedItem() + ""));
        mini.setTema(new BllTema().getByNome(jComboBoxTema.getSelectedItem() + ""));

        bll.validar(mini);
        bll.incluir(mini);
        mensagem("Sucesso", "Miniatura " + (action.equals("Incluir") ? "incluída" : "editada") + " com sucesso!");
        this.dispose();
    }

    /**
     * Creates new form MiniaturaApp
     */
    public AppMiniatura(java.awt.Frame parent, boolean modal) {
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

        jLabelModelo = new javax.swing.JLabel();
        jTextFieldModelo = new javax.swing.JTextField();
        jLabelAno = new javax.swing.JLabel();
        jSpinnerAno = new javax.swing.JSpinner();
        jLabelEdicao = new javax.swing.JLabel();
        jSpinnerEdicao = new javax.swing.JSpinner();
        jLabelEscala = new javax.swing.JLabel();
        jSpinnerEscalaUm = new javax.swing.JSpinner();
        jLabelDoisPontosEscala = new javax.swing.JLabel();
        jSpinnerEscalaPor = new javax.swing.JSpinner();
        jPanelCombos = new javax.swing.JPanel();
        jLabelFabricante = new javax.swing.JLabel();
        jComboBoxFabricante = new javax.swing.JComboBox<>();
        jLabelTema = new javax.swing.JLabel();
        jComboBoxTema = new javax.swing.JComboBox<>();
        jComboBoxTipoMiniatura = new javax.swing.JComboBox<>();
        jLabelTipoMiniatura = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        jFormattedTextFieldValor = new javax.swing.JFormattedTextField();
        jButtonAdicionarFoto = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jScrollPaneGaleria = new javax.swing.JScrollPane();
        jTableGaleria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("cadastro de Miniatura");
        setModal(true);
        setResizable(false);

        jLabelModelo.setText("Modelo");

        jLabelAno.setText("Ano");

        jSpinnerAno.setModel(new javax.swing.SpinnerNumberModel(2020, 1900, 2020, 1));

        jLabelEdicao.setText("Edição");

        jSpinnerEdicao.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabelEscala.setText("Escala em centímetros");

        jSpinnerEscalaUm.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        jLabelDoisPontosEscala.setText(":");

        jSpinnerEscalaPor.setModel(new javax.swing.SpinnerNumberModel(2, 2, 10000, 1));

        jLabelFabricante.setText("Fabricante");

        jLabelTema.setText("Tema");

        jLabelTipoMiniatura.setText("Tipo de Miniatura");

        javax.swing.GroupLayout jPanelCombosLayout = new javax.swing.GroupLayout(jPanelCombos);
        jPanelCombos.setLayout(jPanelCombosLayout);
        jPanelCombosLayout.setHorizontalGroup(
            jPanelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCombosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFabricante))
                .addGap(18, 18, 18)
                .addGroup(jPanelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxTema, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTema))
                .addGap(18, 18, 18)
                .addGroup(jPanelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxTipoMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTipoMiniatura))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCombosLayout.setVerticalGroup(
            jPanelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCombosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCombosLayout.createSequentialGroup()
                        .addComponent(jLabelTipoMiniatura)
                        .addGap(0, 0, 0)
                        .addComponent(jComboBoxTipoMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCombosLayout.createSequentialGroup()
                        .addComponent(jLabelTema)
                        .addGap(0, 0, 0)
                        .addComponent(jComboBoxTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCombosLayout.createSequentialGroup()
                        .addComponent(jLabelFabricante)
                        .addGap(0, 0, 0)
                        .addComponent(jComboBoxFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBoxFabricante.getAccessibleContext().setAccessibleName("Fabricante");
        jComboBoxTema.getAccessibleContext().setAccessibleName("Tema");
        jComboBoxTipoMiniatura.getAccessibleContext().setAccessibleName("TipoMiniatura");

        jLabelValor.setText("Valor");

        jFormattedTextFieldValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jButtonAdicionarFoto.setText("Adicionar Foto");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jTableGaleria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableGaleria.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelModelo))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinnerAno, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAno))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEdicao)
                            .addComponent(jSpinnerEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEscala)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSpinnerEscalaUm, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDoisPontosEscala)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerEscalaPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdicionarFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalvar))
                    .addComponent(jScrollPaneGaleria)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelCombos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldValor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelValor))))
                .addGap(20, 20, 20))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 42, Short.MAX_VALUE)
                    .addComponent(jTableGaleria, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 43, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEscala)
                            .addComponent(jLabelEdicao))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerEscalaUm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDoisPontosEscala)
                            .addComponent(jSpinnerEscalaPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelModelo))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabelValor)
                        .addGap(0, 0, 0)
                        .addComponent(jFormattedTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanelCombos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdicionarFoto)
                    .addComponent(jButtonSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneGaleria, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 180, Short.MAX_VALUE)
                    .addComponent(jTableGaleria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 181, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            salvar();
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(AppMiniatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppMiniatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppMiniatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppMiniatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AppMiniatura dialog = new AppMiniatura(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonAdicionarFoto;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxFabricante;
    private javax.swing.JComboBox<String> jComboBoxTema;
    private javax.swing.JComboBox<String> jComboBoxTipoMiniatura;
    private javax.swing.JFormattedTextField jFormattedTextFieldValor;
    private javax.swing.JLabel jLabelAno;
    private javax.swing.JLabel jLabelDoisPontosEscala;
    private javax.swing.JLabel jLabelEdicao;
    private javax.swing.JLabel jLabelEscala;
    private javax.swing.JLabel jLabelFabricante;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelTema;
    private javax.swing.JLabel jLabelTipoMiniatura;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanelCombos;
    private javax.swing.JScrollPane jScrollPaneGaleria;
    private javax.swing.JSpinner jSpinnerAno;
    private javax.swing.JSpinner jSpinnerEdicao;
    private javax.swing.JSpinner jSpinnerEscalaPor;
    private javax.swing.JSpinner jSpinnerEscalaUm;
    private javax.swing.JTable jTableGaleria;
    private javax.swing.JTextField jTextFieldModelo;
    // End of variables declaration//GEN-END:variables
}
