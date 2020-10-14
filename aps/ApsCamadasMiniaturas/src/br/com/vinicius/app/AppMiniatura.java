/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 30/09/2020 22:14:59 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.app;

import static br.com.vinicius.generic.AppFactory.*;
import br.com.vinicius.generic.AppIModal;
import br.com.vinicius.bll.*;
import static br.com.vinicius.generic.AppDesktopMensagem.mensagem;
import static br.com.vinicius.generic.AppDesktopMensagem.mensagemErro;
import br.com.vinicius.generic.AppSimpleForm;
import static br.com.vinicius.generic.BllGeneric.validarCampoTamanho;
import static br.com.vinicius.generic.BllGeneric.validarSomenteNumeros;
import br.com.vinicius.model.Fabricante;
import br.com.vinicius.model.Miniatura;
import br.com.vinicius.model.Tema;
import br.com.vinicius.model.TipoMiniatura;
import java.util.Calendar;

/**
 *
 * @author vovostudio
 */
public class AppMiniatura extends javax.swing.JDialog implements AppIModal {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private Object object = null;
    private Miniatura mini = null;
    private String friendlyName = "";
    private Class<?> oClass = null;
    private String className = "";
    private String action = "Incluir";
    private String method = "add";
    private String result = "incluído";
    private String again = "incluindo";
    private int id = 0;
    private String complement = "";
    private String messageTitle = "Sucesso!";
    private String message = friendlyName + " " + result + " com sucesso!";
    private String question = friendlyName + message + "\nDeseja continuar " + again + "?";
    private String[] options = new String[]{"Não... melhor, deixa.", "Sim"};

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    @Override
    public void setObject(Object object) {
        this.object = object;
        oClass = object.getClass();
        className = oClass.getSimpleName();
        mini = (Miniatura) object;
    }

    @Override
    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    @Override
    public void setVisible(boolean b) {

        try {
            id = mini.getId();
            if (id > 0) {
                action = "Editar";
                method = "update";
                result = "editado";
                again = "";
                complement += " [ ID: " + id + " ]";
            }

            message = friendlyName + " " + result + " com sucesso!";
            question = message + "\nDeseja continuar " + again + "?";

            fillComboBoxes(jPanelCombos);
            valoresIniciais();

            this.setTitle(action + " " + this.getTitle());
            super.setVisible(b);

        } catch (Exception e) {
            mensagemErro(e);
        }
    }

    private void valoresIniciais() throws Exception {
        if (action.equals("Editar")) {
            jTextFieldModelo.setText(mini.getModelo());

            // FONTE: https://www.guj.com.br/t/resolvido-como-obter-o-ano-atual/53778/2
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            jSpinnerAno.setModel(new javax.swing.SpinnerNumberModel(mini.getAno(), 1900, year, 1));

            jSpinnerEdicao.setValue(Integer.parseInt(mini.getEdicao()));

            String[] escala = mini.getEscala().split(":");
            jSpinnerEscalaUm.setValue(Integer.parseInt(escala[0]));
            jSpinnerEscalaPor.setValue(Integer.parseInt(escala[1]));

            jComboBoxFabricante.setSelectedItem(mini.getFabricante().getNome());
            jComboBoxTema.setSelectedItem(mini.getTema().getNome());
            jComboBoxTipoMiniatura.setSelectedItem(mini.getTipoMiniatura().getNome());
            jFormattedTextFieldValor.setValue(String.format("%.2f", mini.getValor()));
        }
    }

    private void validarPreenchimento() throws Exception {
        validarCampoTamanho(jTextFieldModelo.getText(), "Modelo");
        validateSelectionComboBoxes(jPanelCombos);
        validarSomenteNumeros(jFormattedTextFieldValor.getText(), "Valor");
    }

    private void preencherMini() throws Exception {
        mini.setModelo(jTextFieldModelo.getText());
        mini.setAno(Integer.parseInt(jSpinnerAno.getValue() + ""));
        mini.setEdicao(jSpinnerEdicao.getValue() + "");
        mini.setEscala(jSpinnerEscalaUm.getValue() + ":" + jSpinnerEscalaPor.getValue());

        String texto = jFormattedTextFieldValor.getText();
        texto = texto.replace(",", "").replace(".", "").substring(0, texto.length() - 4) + "." + texto.substring(texto.length() - 2);
        mini.setValor(Float.parseFloat(jFormattedTextFieldValor.getText()));
        mini.setFabricante((Fabricante) BllFabricante.get(jComboBoxFabricante.getSelectedItem() + ""));
        mini.setTipo((TipoMiniatura) BllTipoMiniatura.get(jComboBoxTipoMiniatura.getSelectedItem() + ""));
        mini.setTema((Tema) BllTema.get(jComboBoxTema.getSelectedItem() + ""));
        mini.setObservacoes(jTextAreaObservacoes.getText());

    }

    private void salvar() throws Exception {

        validarPreenchimento();
        preencherMini();
        if (mini.getId() == 0) {
            BllMiniatura.add(mini);
        } else {
            BllMiniatura.update(mini);
        }
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
        jButtonCadastroFabricante = new javax.swing.JButton();
        jButtonCadastroTema = new javax.swing.JButton();
        jButtonCadastroTipo = new javax.swing.JButton();
        jLabelValor = new javax.swing.JLabel();
        jFormattedTextFieldValor = new javax.swing.JFormattedTextField();
        jButtonAdicionarFoto = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jTableGaleria = new javax.swing.JTable();
        jLabelObservacoes = new javax.swing.JLabel();
        jScrollPaneObservacoes = new javax.swing.JScrollPane();
        jTextAreaObservacoes = new javax.swing.JTextArea();
        jScrollPaneGaleria = new javax.swing.JScrollPane();
        jTableGaleria1 = new javax.swing.JTable();

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

        jComboBoxFabricante.setActionCommand("Fabricante");

        jLabelTema.setText("Tema");

        jComboBoxTema.setActionCommand("Tema");

        jComboBoxTipoMiniatura.setActionCommand("TipoMiniatura");

        jLabelTipoMiniatura.setText("Tipo de Miniatura");

        jButtonCadastroFabricante.setText("+");
        jButtonCadastroFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroFabricanteActionPerformed(evt);
            }
        });

        jButtonCadastroTema.setText("+");
        jButtonCadastroTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroTemaActionPerformed(evt);
            }
        });

        jButtonCadastroTipo.setText("+");
        jButtonCadastroTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCombosLayout = new javax.swing.GroupLayout(jPanelCombos);
        jPanelCombos.setLayout(jPanelCombosLayout);
        jPanelCombosLayout.setHorizontalGroup(
            jPanelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCombosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCombosLayout.createSequentialGroup()
                        .addComponent(jComboBoxFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButtonCadastroFabricante))
                    .addComponent(jLabelFabricante))
                .addGap(18, 18, 18)
                .addGroup(jPanelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTema)
                    .addGroup(jPanelCombosLayout.createSequentialGroup()
                        .addComponent(jComboBoxTema, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButtonCadastroTema)))
                .addGroup(jPanelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCombosLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabelTipoMiniatura))
                    .addGroup(jPanelCombosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxTipoMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButtonCadastroTipo)))
                .addGap(0, 11, Short.MAX_VALUE))
        );
        jPanelCombosLayout.setVerticalGroup(
            jPanelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCombosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFabricante)
                    .addComponent(jLabelTema)
                    .addComponent(jLabelTipoMiniatura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastroFabricante)
                    .addComponent(jComboBoxTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastroTema)
                    .addComponent(jComboBoxTipoMiniatura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastroTipo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBoxFabricante.getAccessibleContext().setAccessibleName("Fabricante");
        jComboBoxTema.getAccessibleContext().setAccessibleName("Tema");
        jComboBoxTipoMiniatura.getAccessibleContext().setAccessibleName("Tipo de Miniatura");

        jLabelValor.setText("Valor");

        jFormattedTextFieldValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextFieldValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldValorActionPerformed(evt);
            }
        });

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

        jLabelObservacoes.setText("Observações");

        jTextAreaObservacoes.setColumns(20);
        jTextAreaObservacoes.setRows(5);
        jTextAreaObservacoes.setPreferredSize(new java.awt.Dimension(220, 80));
        jScrollPaneObservacoes.setViewportView(jTextAreaObservacoes);

        jTableGaleria1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTableGaleria1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPaneGaleria.setViewportView(jTableGaleria1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabelObservacoes)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdicionarFoto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPaneObservacoes)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelCombos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelValor)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelModelo)
                                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                                        .addComponent(jSpinnerEscalaPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonSalvar))))
                            .addComponent(jScrollPaneGaleria, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(20, 20, 20))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 252, Short.MAX_VALUE)
                    .addComponent(jTableGaleria, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 251, Short.MAX_VALUE)))
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
                            .addComponent(jSpinnerEscalaPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSalvar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelModelo))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanelCombos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jLabelObservacoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAdicionarFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneGaleria, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 277, Short.MAX_VALUE)
                    .addComponent(jTableGaleria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 277, Short.MAX_VALUE)))
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

    private void jFormattedTextFieldValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldValorActionPerformed

    private void jButtonCadastroFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroFabricanteActionPerformed
        try {
            getModal(new Fabricante(), "Fabricante", new AppSimpleForm(null, true));
            fillComboBox(jComboBoxFabricante, "Fabricante");
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonCadastroFabricanteActionPerformed

    private void jButtonCadastroTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroTemaActionPerformed
        try {
            getModal(new Tema(), "Tema", new AppSimpleForm(null, true));
            fillComboBox(jComboBoxTema, "Tema");
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonCadastroTemaActionPerformed

    private void jButtonCadastroTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroTipoActionPerformed
        try {
            getModal(new TipoMiniatura(), "Tipo de Miniatura", new AppSimpleForm(null, true));
            fillComboBox(jComboBoxTipoMiniatura, "TipoMiniatura");
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonCadastroTipoActionPerformed

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
    private javax.swing.JButton jButtonCadastroFabricante;
    private javax.swing.JButton jButtonCadastroTema;
    private javax.swing.JButton jButtonCadastroTipo;
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
    private javax.swing.JLabel jLabelObservacoes;
    private javax.swing.JLabel jLabelTema;
    private javax.swing.JLabel jLabelTipoMiniatura;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanelCombos;
    private javax.swing.JScrollPane jScrollPaneGaleria;
    private javax.swing.JScrollPane jScrollPaneObservacoes;
    private javax.swing.JSpinner jSpinnerAno;
    private javax.swing.JSpinner jSpinnerEdicao;
    private javax.swing.JSpinner jSpinnerEscalaPor;
    private javax.swing.JSpinner jSpinnerEscalaUm;
    private javax.swing.JTable jTableGaleria;
    private javax.swing.JTable jTableGaleria1;
    private javax.swing.JTextArea jTextAreaObservacoes;
    private javax.swing.JTextField jTextFieldModelo;
    // End of variables declaration//GEN-END:variables
}
