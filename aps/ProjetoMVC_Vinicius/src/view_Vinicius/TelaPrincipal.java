/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 07/09/2020 10:29:51 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : Projeto MVC - Sistema Bancário Simples
 *  Exercício  : https://www.devmedia.com.br/java-se-aprendendo-o-padrao-mvc/29546
 *  -------------------------------------------------------------------------------------------------
 *  Tela principal
 *  ------------------------------------------------------------------------------------------------| 
 */
package view_Vinicius;

import controller_Vinicius.ControlCliente;
import controller_Vinicius.ControlConta;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;
import model_Vinicius.classes.Cliente;
import model_Vinicius.classes.Conta;
import model_Vinicius.enums.EnumConstantes;
import model_Vinicius.enums.EnumStatusConta;
import model_Vinicius.enums.EnumTipoDeConta;
import static view_Vinicius.Mensagem.*;

/**
 *
 * @author vovostudio
 */
public class TelaPrincipal extends javax.swing.JFrame {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private DefaultTableModel tabClientes = null;
    private ArrayList<Object> clientes = null;
    private DefaultTableModel tabContas = null;
    private ArrayList<Object> contas = null;
    private int linhaCliente = -1;
    private int linhaConta = -1;
    private int idCliente = -1;
    private int idConta = -1;
    private boolean clienteSelecionado = false;
    private boolean contaSelecionada = false;
    private boolean contaAtiva = false;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CLIENTES ------------------------------------------------------------------------------->
    //
    private void selecionarCliente() {
        linhaCliente = (jTableClientes.getRowCount() == 1) ? 0 : jTableClientes.getSelectedRow();
        if (linhaCliente == -1) {
            idCliente = -1;
            clienteSelecionado = false;
        } else {
            idCliente = Integer.parseInt(jTableClientes.getValueAt(linhaCliente, 0).toString());
            clienteSelecionado = true;
        }
        selecionarConta();
    }

    private void valoresIniciaisClientes() {
        selecionarCliente();
        jButtonSalvar.setVisible(false);
        jButtonCancelarEditarCliente.setVisible(false);
        jTextFieldNome.setText(null);
        jTextFieldEmail.setText(null);
    }

    private void addCliente() throws Exception {
        ControlCliente.addCliente(jTextFieldNome.getText(), jTextFieldEmail.getText());
        refreshClientes();
        refreshContasCliente();
    }

    private void editarCliente() throws Exception {
        jTextFieldNome.setText(jTableClientes.getValueAt(linhaCliente, 1).toString());
        jTextFieldEmail.setText(jTableClientes.getValueAt(linhaCliente, 2).toString());
        jTextFieldNome.requestFocus();

        jButtonSalvar.setVisible(true);
        jButtonAddCliente.setVisible(false);
        jButtonCancelarEditarCliente.setVisible(true);
    }

    private void cancelarEditarCliente() {
        jTextFieldNome.setText("");
        jTextFieldEmail.setText("");

        jButtonSalvar.setVisible(false);
        jButtonAddCliente.setVisible(true);
        jButtonCancelarEditarCliente.setVisible(false);
    }

    private void refreshClientes() throws Exception {

        tabClientes.setRowCount(0);

        if (jTextFieldPesquisaNomeCliente.getText().equals("")) {
            clientes = ControlCliente.getAllClientes();
        }

        for (Object obj : clientes) {
            Cliente cli = (Cliente) obj;
            tabClientes.addRow(
                    new Object[]{
                        String.format("%06d", cli.getId()), cli.getNome(), cli.getEmail()
                    });
        }
        selecionarCliente();
        selecionarConta();
        valoresIniciaisClientes();
        refreshContasCliente();
    }

    //--- FIM CLIENTES ----------------------------------------------------------------------------|
    //    
    //--- CONTAS ---------------------------------------------------------------------------------->
    //
    private void selecionarConta() {
        linhaConta = (jTableContas.getRowCount() == 1) ? 0 : jTableContas.getSelectedRow();
        if (linhaConta == -1) {
            idConta = -1;
            contaSelecionada = false;
            contaAtiva = false;
        } else {
            idConta = Integer.parseInt(jTableContas.getValueAt(linhaConta, 0).toString());
            contaSelecionada = true;
            contaAtiva = jTableContas.getValueAt(linhaConta, 5).toString().equals(EnumStatusConta.Ativa.toString());
        }
    }

    private void valoresIniciaisContas() throws Exception {
        selecionarConta();
        jButtonAddConta.setEnabled(clienteSelecionado);
        jRadioButtonComum.setEnabled(clienteSelecionado);
        jRadioButtonEspecial.setEnabled(clienteSelecionado);
        jFormattedTextFieldLimite.setText(null);
        exibirjFormattedTextFieldLimite();

        for (Component comp : jPanelOperacoes.getComponents()) {
            if (comp.getClass().getName().contains("JButton")) {
                comp.setEnabled(contaSelecionada && contaAtiva);
            }
        }
        jLabelValor.setEnabled(contaSelecionada && contaAtiva);
        jFormattedTextFieldValor.setEnabled(contaSelecionada && contaAtiva);
        jFormattedTextFieldValor.setText(null);
        jPanelTransferir.setVisible(false);

        cancelarEditarCliente();

        if (contaSelecionada) {
            exibirBotoesEncerrarReabrir();
            exibirBotoesLimite();
            popularjComboBoxOutrasContas();
        }
    }

    private void addConta(String actionCommand) throws Exception {
        ControlConta.addConta(
                idCliente,
                jFormattedToDouble(jFormattedTextFieldLimite),
                getTipoDeContaSelecionado(actionCommand)
        );
        refreshContasCliente();
    }

    private void updateConta(String acao) throws Exception {

        ControlConta.validarContaSelecionada(linhaConta);

        switch (acao) {
            case "depositar":
                ControlConta.depositar(idConta, jFormattedToDouble(jFormattedTextFieldValor));
                break;

            case "sacar":
                ControlConta.sacar(idConta, jFormattedToDouble(jFormattedTextFieldValor));
                break;

            case "encerrar":
                ControlConta.encerrar(idConta);
                break;

            case "reativar":
                ControlConta.reativar(idConta);
                break;

            case "transferir":
                ControlConta.validarValorZero(jFormattedToDouble(jFormattedTextFieldValor));
                int idDestino = Integer.parseInt(jComboBoxOutrasContas.getSelectedItem().toString()
                        .split(EnumConstantes.SeparadorComboBox.getConstante())[0].trim());
                ControlConta.transferir(idConta, idDestino, jFormattedToDouble(jFormattedTextFieldValor));
                break;

            case "addLimite":
                ControlConta.validarValorZero(jFormattedToDouble(jFormattedTextFieldValor));
                ControlConta.addLimite(idConta, jFormattedToDouble(jFormattedTextFieldValor));
                break;

            case "removeLimite":
                ControlConta.validarValorZero(jFormattedToDouble(jFormattedTextFieldValor));
                ControlConta.removeLimite(idConta, jFormattedToDouble(jFormattedTextFieldValor));
                break;
        }
        refreshContasCliente();
    }

    private void refreshContasCliente() throws Exception {

        tabContas.setRowCount(0);

        if (clientes.size() == 0) {
            jPanelOperacoes.setEnabled(false);
        } else {
            if (clienteSelecionado) {
                contas = ControlConta.getAllContasByCliente(idCliente);
                for (Object obj : contas) {
                    String[] parte = obj.toString().split(EnumConstantes.SeparadorSplit.getConstante());
                    double saldo = Double.parseDouble(parte[3]);
                    double limite = Double.parseDouble(parte[4]);

                    tabContas.addRow(new Object[]{
                        String.format("%06d", Integer.parseInt(parte[0])),
                        EnumTipoDeConta.values()[Integer.parseInt(parte[1])],
                        String.format("%.2f", saldo),
                        String.format("%.2f", limite),
                        String.format("%.2f", saldo + limite),
                        EnumStatusConta.values()[Integer.parseInt(parte[5])]
                    });
                }
            }
        }
        valoresIniciaisContas();
        jButtonAddConta.setEnabled(clienteSelecionado);
        cancelarEditarCliente();
    }

    private void popularjComboBoxOutrasContas() throws Exception {

        ArrayList<Object> outrasContas
                = ControlConta.getAllOther(idConta);
        jComboBoxOutrasContas.removeAllItems();

        for (Object obj : outrasContas) {
            Conta conta = (Conta) obj;
            if (conta.getStatus().equals(EnumStatusConta.Ativa)) {
                Cliente cliente = ControlCliente.getClienteById(conta.getIdCliente());
                String parte[] = conta.toString().split(EnumConstantes.SeparadorSplit.getConstante());

                jComboBoxOutrasContas.addItem(
                        String.format("%06d", conta.getId())
                        + " - Conta " + EnumTipoDeConta.values()[Integer.parseInt(parte[1])]
                        + " - " + cliente.getNome()
                );
            }
        }
        jComboBoxOutrasContas.setSelectedIndex(-1);
    }

    private void exibirjFormattedTextFieldLimite() {
        boolean visible
                = (buttonGroupTipoConta.getSelection() == null)
                ? false
                : buttonGroupTipoConta.getSelection().getActionCommand().equals("ContaEspecial");

        jLabelLimite.setVisible(visible);
        jFormattedTextFieldLimite.setVisible(visible);
    }

    private void exibirBotoesEncerrarReabrir() throws Exception {
        jButtonEncerrar.setEnabled(contaAtiva);
        jButtonReativar.setEnabled(!jButtonEncerrar.isEnabled());
    }

    private void exibirBotoesLimite() throws Exception {
        jButtonAddLimite.setEnabled(
                contaAtiva
                && (getTipoDeContaSelecionado("jTableContasMouseClicked").equals(EnumTipoDeConta.Especial))
        );

        jButtonRemoveLimite.setEnabled(jButtonAddLimite.isEnabled());
    }

    private double jFormattedToDouble(JFormattedTextField campo) throws Exception {
        try {
            return Double.parseDouble(
                    (campo.getText().trim().length() == 0)
                    ? "0"
                    : campo.getText()
            );
        } catch (Exception e) {
            throw new Exception("O valor informado é inválido!\n" + e.getMessage());
        }
    }

    private EnumTipoDeConta getTipoDeContaSelecionado(String actionCommand) {
        if (actionCommand.equals("+ Conta")) {
            return (buttonGroupTipoConta.getSelection() == null)
                    ? null
                    : EnumTipoDeConta.valueOf(buttonGroupTipoConta.getSelection().getActionCommand().replace("Conta", ""));
        } else {
            return EnumTipoDeConta.valueOf(jTableContas.getValueAt(linhaConta, 1).toString());
        }
    }

    //--- FIM CONTAS ------------------------------------------------------------------------------|
    //
    //    
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public TelaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        tabClientes = (DefaultTableModel) jTableClientes.getModel();
        tabContas = (DefaultTableModel) jTableContas.getModel();
        valoresIniciaisClientes();

        try {
            valoresIniciaisContas();
            refreshClientes();
        } catch (Exception ex) {
            mensagemErro(ex);
        }
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- EVENTOS --------------------------------------------------------------------------------->
    //
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTipoConta = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPesquisaNomeCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonAddCliente = new javax.swing.JButton();
        jButtonCancelarEditarCliente = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableContas = new javax.swing.JTable();
        jButtonAddConta = new javax.swing.JButton();
        jFormattedTextFieldLimite = new javax.swing.JFormattedTextField();
        jLabelLimite = new javax.swing.JLabel();
        jRadioButtonEspecial = new javax.swing.JRadioButton();
        jRadioButtonComum = new javax.swing.JRadioButton();
        jPanelOperacoes = new javax.swing.JPanel();
        jButtonDepositar = new javax.swing.JButton();
        jButtonSacar = new javax.swing.JButton();
        jButtonTransferir = new javax.swing.JButton();
        jButtonEncerrar = new javax.swing.JButton();
        jButtonReativar = new javax.swing.JButton();
        jLabelValor = new javax.swing.JLabel();
        jFormattedTextFieldValor = new javax.swing.JFormattedTextField();
        jPanelTransferir = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxOutrasContas = new javax.swing.JComboBox<>();
        jButtonCancelar = new javax.swing.JButton();
        jButtonOK = new javax.swing.JButton();
        jButtonAddLimite = new javax.swing.JButton();
        jButtonRemoveLimite = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Bancário Simples - Vovolinux 2020");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        jLabel1.setText("Nome:");

        jTextFieldPesquisaNomeCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaNomeClienteKeyReleased(evt);
            }
        });

        jTableClientes.setAutoCreateRowSorter(true);
        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);
        if (jTableClientes.getColumnModel().getColumnCount() > 0) {
            jTableClientes.getColumnModel().getColumn(0).setMinWidth(70);
            jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTableClientes.getColumnModel().getColumn(0).setMaxWidth(70);
        }

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonAddCliente.setText("+ Cliente");
        jButtonAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddClienteActionPerformed(evt);
            }
        });

        jButtonCancelarEditarCliente.setText("Cancelar");
        jButtonCancelarEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarEditarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonAddCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCancelarEditarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButtonSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelarEditarCliente)
                .addGap(0, 0, 0))
        );

        jLabel2.setText("Nome:");

        jLabel3.setText("eMail:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNome)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesquisaNomeCliente)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisaNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contas"));

        jTableContas.setAutoCreateRowSorter(true);
        jTableContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Tipo", "Saldo", "Limite", "Disponível", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContas.getTableHeader().setReorderingAllowed(false);
        jTableContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableContas);

        jButtonAddConta.setText("+ Conta");
        jButtonAddConta.setAlignmentY(0.0F);
        jButtonAddConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddContaActionPerformed(evt);
            }
        });

        jLabelLimite.setText("Limite:");

        buttonGroupTipoConta.add(jRadioButtonEspecial);
        jRadioButtonEspecial.setText("Especial");
        jRadioButtonEspecial.setActionCommand("ContaEspecial");
        jRadioButtonEspecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEspecialActionPerformed(evt);
            }
        });

        buttonGroupTipoConta.add(jRadioButtonComum);
        jRadioButtonComum.setText("Comum");
        jRadioButtonComum.setActionCommand("ContaComum");
        jRadioButtonComum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonComumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonAddConta)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonComum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonEspecial)
                        .addGap(50, 50, 50)
                        .addComponent(jLabelLimite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddConta)
                    .addComponent(jRadioButtonComum)
                    .addComponent(jRadioButtonEspecial)
                    .addComponent(jLabelLimite)
                    .addComponent(jFormattedTextFieldLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelOperacoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Operações"));

        jButtonDepositar.setText("Depositar");
        jButtonDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDepositarActionPerformed(evt);
            }
        });

        jButtonSacar.setText("Sacar");
        jButtonSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSacarActionPerformed(evt);
            }
        });

        jButtonTransferir.setText("Transferir");
        jButtonTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransferirActionPerformed(evt);
            }
        });

        jButtonEncerrar.setText("Encerrar");
        jButtonEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncerrarActionPerformed(evt);
            }
        });

        jButtonReativar.setText("Reativar");
        jButtonReativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReativarActionPerformed(evt);
            }
        });

        jLabelValor.setText("Valor:");

        jPanelTransferir.setBorder(javax.swing.BorderFactory.createTitledBorder("Transferir para"));

        jLabel6.setText("Conta Destino:");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTransferirLayout = new javax.swing.GroupLayout(jPanelTransferir);
        jPanelTransferir.setLayout(jPanelTransferirLayout);
        jPanelTransferirLayout.setHorizontalGroup(
            jPanelTransferirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTransferirLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTransferirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelTransferirLayout.createSequentialGroup()
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxOutrasContas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTransferirLayout.setVerticalGroup(
            jPanelTransferirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTransferirLayout.createSequentialGroup()
                .addGroup(jPanelTransferirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxOutrasContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTransferirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonOK)))
        );

        jButtonAddLimite.setText("+ Limite");
        jButtonAddLimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddLimiteActionPerformed(evt);
            }
        });

        jButtonRemoveLimite.setText("- Limite");
        jButtonRemoveLimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveLimiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOperacoesLayout = new javax.swing.GroupLayout(jPanelOperacoes);
        jPanelOperacoes.setLayout(jPanelOperacoesLayout);
        jPanelOperacoesLayout.setHorizontalGroup(
            jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelOperacoesLayout.createSequentialGroup()
                        .addGroup(jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelOperacoesLayout.createSequentialGroup()
                                .addComponent(jButtonTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAddLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoveLimite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelOperacoesLayout.createSequentialGroup()
                                .addComponent(jButtonDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonReativar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOperacoesLayout.setVerticalGroup(
            jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOperacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelValor)
                    .addComponent(jFormattedTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDepositar)
                    .addComponent(jButtonSacar)
                    .addComponent(jButtonEncerrar)
                    .addComponent(jButtonReativar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOperacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTransferir)
                    .addComponent(jButtonAddLimite)
                    .addComponent(jButtonRemoveLimite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelOperacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelOperacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddClienteActionPerformed
        try {
            addCliente();
        } catch (Exception e) {
            jTextFieldNome.requestFocus();
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonAddClienteActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            Cliente cliente = ControlCliente.toObject(
                    idCliente,
                    jTextFieldNome.getText(),
                    jTextFieldEmail.getText()
            );
            ControlCliente.updateCliente(cliente);
            refreshClientes();
        } catch (Exception e) {
            jTextFieldNome.requestFocus();
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        try {
            selecionarCliente();
            // Clique duplo, mostra detalhes do cadastro
            if (evt != null) { // Quando acionado pelo keyReleased, evt = null
                switch (evt.getClickCount()) {
                    case 1:
                        refreshContasCliente();
                        break;
                    case 2:
                        editarCliente();
                        break;
                }
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableClientesMouseClicked

    private void jButtonCancelarEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarEditarClienteActionPerformed
        try {
            cancelarEditarCliente();
        } catch (Exception e) {
            jTextFieldPesquisaNomeCliente.requestFocus();
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonCancelarEditarClienteActionPerformed

    private void jButtonAddContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddContaActionPerformed
        try {
            jPanelTransferir.setVisible(false);
            addConta(evt.getActionCommand());
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonAddContaActionPerformed

    private void jButtonDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDepositarActionPerformed
        try {
            jPanelTransferir.setVisible(false);
            updateConta("depositar");
        } catch (Exception e) {
            jFormattedTextFieldValor.requestFocus();
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonDepositarActionPerformed

    private void jTableContasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContasMouseClicked
        try {
            jPanelTransferir.setVisible(false);
            valoresIniciaisContas();
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableContasMouseClicked

    private void jButtonTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransferirActionPerformed
        try {
            jPanelTransferir.setVisible(true);
        } catch (Exception e) {
            jFormattedTextFieldValor.requestFocus();
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonTransferirActionPerformed

    private void jButtonSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSacarActionPerformed
        try {
            updateConta("sacar");
            jPanelTransferir.setVisible(false);
        } catch (Exception e) {
            jFormattedTextFieldValor.requestFocus();
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonSacarActionPerformed

    private void jButtonEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncerrarActionPerformed
        try {
            jPanelTransferir.setVisible(false);
            updateConta("encerrar");
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonEncerrarActionPerformed

    private void jButtonReativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReativarActionPerformed
        try {
            jPanelTransferir.setVisible(false);
            updateConta("reativar");
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonReativarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        try {
            jPanelTransferir.setVisible(false);
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jRadioButtonComumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonComumActionPerformed
        try {
            jPanelTransferir.setVisible(false);
            exibirjFormattedTextFieldLimite();
            jFormattedTextFieldLimite.setVisible(buttonGroupTipoConta.getSelection().getActionCommand().equals("ContaEspecial"));
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jRadioButtonComumActionPerformed

    private void jRadioButtonEspecialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEspecialActionPerformed
        try {
            jPanelTransferir.setVisible(false);
            exibirjFormattedTextFieldLimite();
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jRadioButtonEspecialActionPerformed

    private void jButtonAddLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddLimiteActionPerformed
        try {
            jPanelTransferir.setVisible(false);
            updateConta("addLimite");
        } catch (Exception e) {
            jFormattedTextFieldValor.requestFocus();
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonAddLimiteActionPerformed

    private void jButtonRemoveLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveLimiteActionPerformed
        try {
            jPanelTransferir.setVisible(false);
            updateConta("removeLimite");
        } catch (Exception e) {
            jFormattedTextFieldValor.requestFocus();
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonRemoveLimiteActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        try {
            updateConta("transferir");
            jPanelTransferir.setVisible(false);
        } catch (Exception e) {
            jFormattedTextFieldValor.requestFocus();
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jTextFieldPesquisaNomeClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaNomeClienteKeyReleased
        try {
            jPanelTransferir.setVisible(false);
            clientes = ControlCliente.getAllClientesLike(jTextFieldPesquisaNomeCliente.getText());
            refreshClientes();
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTextFieldPesquisaNomeClienteKeyReleased

    //--- FIM EVENTOS -----------------------------------------------------------------------------|
    //    
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTipoConta;
    private javax.swing.JButton jButtonAddCliente;
    private javax.swing.JButton jButtonAddConta;
    private javax.swing.JButton jButtonAddLimite;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarEditarCliente;
    private javax.swing.JButton jButtonDepositar;
    private javax.swing.JButton jButtonEncerrar;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JButton jButtonReativar;
    private javax.swing.JButton jButtonRemoveLimite;
    private javax.swing.JButton jButtonSacar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonTransferir;
    private javax.swing.JComboBox<String> jComboBoxOutrasContas;
    private javax.swing.JFormattedTextField jFormattedTextFieldLimite;
    private javax.swing.JFormattedTextField jFormattedTextFieldValor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelLimite;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelOperacoes;
    private javax.swing.JPanel jPanelTransferir;
    private javax.swing.JRadioButton jRadioButtonComum;
    private javax.swing.JRadioButton jRadioButtonEspecial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTable jTableContas;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPesquisaNomeCliente;
    // End of variables declaration//GEN-END:variables
}
