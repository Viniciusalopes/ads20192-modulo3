/*
 * ------------------------------------------------------------------------------------------------>
 * Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 * Criado em  : 2/08/2020
 * Instituição: FACULDADE SENAI FATESG
 * Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 * Disciplina : Arquitetura e Projeto de Software
 * Aluno      : Vinicius Araujo Lopes
 * Projeto    : Projeto Monolítico
 * Exercício  : Criar um Projeto em arquitetura monolítica na linguagem Java, contendo:
 *              - Uma interface gráfica em Swing (JFrame)
 *              - 3 campos: nome, telefone e e-mail
 *              - Uma tabela (JTable) para listar as informações dos campos acima.
 *              - Um botão "Salvar" para inserir as informações  na tabela.
 *              OBS.: Apresentar o software funcionando e a estrutura na próxima aula (01/09/2020)
 * -------------------------------------------------------------------------------------------------
 * Programa principal.
 * ------------------------------------------------------------------------------------------------| 
 */
package Funcionalidade_Vinicius;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author vovostudio
 */
public class Tela extends javax.swing.JFrame {

    // --- ATRIBUTOS ------------------------------------------------------------------------------>
    private DefaultTableModel tabela = null;    // Referência à JTableDados
    private String charsVogaisAcentuadas = "àâãáéêíòôõóúÀÂÂÁÉÊÍÒÔÕÓÚ";
    private String charsLetras
            = "qwertyuiopasdfghjklçzxcvbnmQWERTYUIOPASDFGHJKLÇZXCVBNM " + charsVogaisAcentuadas;
    private String charsNumeros = "0123456789";
    private String charsTelefone = "()- " + charsNumeros;

    // --- FIM ATRIBUTOS --------------------------------------------------------------------------|
    //
    // --- VALIDAÇÕES ----------------------------------------------------------------------------->
    /**
     * Valida o preenchimento do campo Nome.
     *
     * @param nome Texto com nome válido, com pelo menos duas letras.
     * @throws Exception
     */
    private void validarNome(String nome) throws Exception {
        nome = nome.trim();
        if (nome.length() == 0) {
            throw new Exception("Informe o nome!");
        }

        if (nome.length() < 2) {
            throw new Exception("O nome deve ter pelo menos duas letras!");
        }

        for (char c : nome.toCharArray()) {
            if (!charsLetras.contains(c + "")) {
                throw new Exception("O nome deve ter apenas letras e espaços!");
            }
        }
    }

    /**
     * Valida o preenchimento do campo Telefone.
     *
     * @param telefone Texto nos formatos:
     * <p>
     * 99998888, 9999-8888,
     * <p>
     * 98888777, 9 8888-7777,
     * <p>
     * 9988887777, (99) 8888-7777,
     * <p>
     * 99877776666, (99) 8 7777-6666,
     * <p>
     * ou 08007776666m 0800 777-6666.
     * @throws Exception
     */
    private void validarTelefone(String telefone) throws Exception {
        telefone = telefone.trim();
        String validos
                = "Formato válidos:\n"
                + "9999-8888\n"
                + "9 8888-7777\n"
                + "(99) 8888-7777\n"
                + "(99) 8 7777-6666";

        for (char c : telefone.toCharArray()) {
            if (!charsTelefone.contains(c + "")) {
                throw new Exception("O número de telefone tem caracteres inválidos!\n\n" + validos);
            }
        }

        // Tamanhos válidos para telefone: mínimo 8 números, máximo 11 números
        String numeros = textoSoComNumeros(telefone);

        if (numeros.length() < 8) {
            throw new Exception("O número do telefone informado é muito curto!\n\n" + validos);
        }

        if (numeros.length() > 11) {
            throw new Exception("O número do telefone informado é muito longo!\n\n" + validos);
        }
    }

    /**
     * Valida o preenchimento do campo E-Mail.
     *
     * @param email Endereço de e-mail válido.
     * @throws Exception
     */
    private void validarEmail(String email) throws Exception {
        // FONTE: https://receitasdecodigo.com.br/java/validar-email-em-java
        boolean emailValido = false;

        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                emailValido = true;
            }
        }

        if (!emailValido) {
            throw new Exception("E-mail inválido!");
        }
    }

    /**
     * Valida o preenchimento dos campos Nome, Telefone e E-mail.
     *
     * @throws Exception
     */
    private void validarPreenchimento() throws Exception {
        validarNome(jTextFieldNome.getText());
        validarTelefone(jFormattedTextFieldTelefone.getText());
        validarEmail(jTextFieldEmail.getText());
    }

    /**
     * Valida a inclusão de um novo registro, verificando se há duplicidade.
     *
     * @throws Exception
     */
    private void validarInclusao() throws Exception {
        String cadastroTabela = "";
        String cadastroNovo = "";

        for (int i = 0; i < tabela.getRowCount(); i++) {
            cadastroTabela
                    = tabela.getValueAt(i, 0).toString()
                    + textoSoComNumeros(tabela.getValueAt(i, 1).toString())
                    + tabela.getValueAt(i, 2).toString();

            cadastroNovo
                    = jTextFieldNome.getText().trim()
                    + textoSoComNumeros(jFormattedTextFieldTelefone.getText().trim())
                    + jTextFieldEmail.getText().trim();

            if (cadastroNovo.equalsIgnoreCase(cadastroTabela)) {
                throw new Exception("Esse cadastro já existe!");
            }
        }
    }

    // --- FIM VALIDAÇÕES -------------------------------------------------------------------------|
    //
    // --- PERSISTÊNCIA --------------------------------------------------------------------------->
    //
    /**
     * Inclui um novo registro na tabela que referencia a jTableDados.
     *
     * @throws Exception
     */
    private void incluirNaTabela() throws Exception {
        tabela.addRow(new Object[]{
            jTextFieldNome.getText().trim(),
            mascaraTelefone(jFormattedTextFieldTelefone.getText().trim()),
            jTextFieldEmail.getText().trim()
        });
    }

    // --- FIM PERSISTÊNCIA -----------------------------------------------------------------------|
    // 
    // --- UTILIDADES ----------------------------------------------------------------------------->
    //
    /**
     * Limpa o conteúdo dos campos do formulário.
     */
    private void limparCampos() {
        jTextFieldNome.setText("");
        jFormattedTextFieldTelefone.setText("");
        jFormattedTextFieldTelefoneFocusLost(null);
        jTextFieldEmail.setText("");
        jTextFieldNome.requestFocus();

    }

    /**
     * Retira caracteres que não são números {0123456789}.
     *
     * @param texto String a ser tratada.
     * @return Texto somente com números.
     */
    private String textoSoComNumeros(String texto) {
        String ret = "";
        for (char c : texto.toCharArray()) {
            if (charsNumeros.contains(c + "")) {
                ret += c + "";
            }
        }
        return ret;
    }

    /**
     * Formata um número de telefone nos formatos:
     * <p>
     * 9999-8888, 9 8888-7777, (99) 8888-7777, (99) 8 7777-6666 ou 0800 777-6666.
     * <p>
     * @param numeros Texto com um número de telefone.
     * @return Número de telefone no formato correspondente à quantidade de dígitos.
     * @throws Exception
     */
    private String mascaraTelefone(String numeros) throws Exception {
        try {
            numeros = textoSoComNumeros(numeros);
            switch (numeros.length()) {
                case 8:
                    return String.format("%s-%s", numeros.substring(0, 4), numeros.substring(4, 8));
                case 9:
                    return String.format("%s %s-%s", numeros.substring(0, 1), numeros.substring(1, 5), numeros.substring(5, 9));
                case 10:
                    return String.format("(%s) %s-%s", numeros.substring(0, 2), numeros.substring(2, 6), numeros.substring(6, 10));
                case 11:
                    if (numeros.substring(0, 4).equals("0800")) {
                        return numeros.substring(0, 4) + " " + numeros.substring(4, 7) + "-" + numeros.substring(7, 11);
                    } else {
                        return "(" + numeros.substring(0, 2) + ") " + numeros.substring(2, 3) + " " + numeros.substring(3, 7) + "-" + numeros.substring(7, 11);
                    }
                default:
                    break;
            }
            return numeros;

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Formata um número de telefone em um componente JFormattedTextField de acordo com a quantidade
     * de dígitos nos formatos:
     * <p>
     * 9999-8888, 9 8888-7777, (99) 8888-7777, (99) 8 7777-6666 ou 0800 777-6666.
     * <p>
     * Caso o número tenha 11 dígitos, exibe opção de escolha entre os formatos disponíveis.
     * <p>
     * FONTE:
     * https://www.guj.com.br/t/classe-pronta-mascara-do-jformattedtextfield-para-telefones/335186
     *
     * @param campoTelefone Componente com um número de telefone.
     * @throws Exception
     */
    private void mudaMascaraTelefone(JFormattedTextField campoTelefone) throws Exception {
        try {
            campoTelefone.setValue(null);
            String numeros = textoSoComNumeros(campoTelefone.getText().trim());
            final MaskFormatter mask = new MaskFormatter();
            switch (numeros.length()) {
                case 8:
                    mask.setMask("####-####");
                    campoTelefone.setFormatterFactory(new DefaultFormatterFactory(mask));
                    break;
                case 9:
                    mask.setMask("# ####-####");
                    campoTelefone.setFormatterFactory(new DefaultFormatterFactory(mask));
                    break;
                case 10:
                    mask.setMask("(##) ####-####");
                    campoTelefone.setFormatterFactory(new DefaultFormatterFactory(mask));
                    break;
                case 11:
                    if (numeros.substring(0, 4).equals("0800")) {
                        mask.setMask("#### ###-####");
                    } else {
                        String comDDD = "(" + numeros.substring(0, 2) + ") " + numeros.substring(2, 3) + " " + numeros.substring(3, 7) + "-" + numeros.substring(7, 11);
                        String com0800 = numeros.substring(0, 4) + " " + numeros.substring(4, 7) + "-" + numeros.substring(7, 11);

                        // Ababandona o evento se já estiver no formato esperado
                        if (campoTelefone.getText().trim().equals(comDDD) || campoTelefone.equals(com0800)) {
                            return;
                        }
                        if (mensagemEscolher("Selecione um formato para o número do telefone:", new String[]{comDDD, com0800}) == 0) {
                            mask.setMask("(##) # ####-####");
                            campoTelefone.setFormatterFactory(new DefaultFormatterFactory(mask));
                        } else {
                            mask.setMask("#### ###-####");
                            campoTelefone.setFormatterFactory(new DefaultFormatterFactory(mask));
                        }
                    }
                    break;
                default:
                    campoTelefone.setFormatterFactory(null);
                    break;
            }
            campoTelefone.setText(numeros);
        } catch (Exception e) {
            throw e;
        }
    }

    // --- FIM UTILIDADES -------------------------------------------------------------------------|
    //
    // --- MENSAGENS ------------------------------------------------------------------------------>
    //
    /**
     * Exibe uma mensagem informativa na tela.
     *
     * @param titulo Título da mensagem.
     * @param mensagem Texto da mensagem.
     */
    private void mensagem(String titulo, String mensagem) {
        JOptionPane.showMessageDialog(rootPane, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Exibe uma mensagem de erro na tela.
     *
     * @param e Exception para obter o texto da mensagem.
     */
    private void mensagemErro(Exception e) {
        JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Opa!", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Exibe pergunta e retorna a resposta do usuário.
     * <p>
     * Exemplo:
     * <p>
     * String[] opcoes = {"Sim", "Não", "Talvez"};
     * <p>
     * 0 = Sim
     * <p>
     * 1 = Não
     * <p>
     * 2 = Talvez
     *
     * @param mensagem Texto com a pergunta.
     * @param opcoes Lista com os labels dos botões de opção.
     * @return Inteiro com o índice da opção escolhida pelo usuário.
     *
     */
    private int mensagemEscolher(String mensagem, String[] opcoes) {
        return JOptionPane.showOptionDialog(rootPane, mensagem, "Escolha uma opção:",
                JOptionPane.CLOSED_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, 0);
    }

    // --- FIM MENSAGENS --------------------------------------------------------------------------|
    //
    /**
     * Creates new form Tela
     */
    public Tela() {
        initComponents();
        this.setLocationRelativeTo(null);
        // Referencia o JTable para manipulação
        tabela = (DefaultTableModel) jTableDados.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDados = new javax.swing.JTable();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Funcionalidade Vinicius - Arquitetura Monolítica");

        jTextFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldEmailKeyReleased(evt);
            }
        });

        jLabelNome.setText("Nome");

        jLabelTelefone.setText("Telefone");

        jLabelEmail.setText("E-mail");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jTableDados.setAutoCreateRowSorter(true);
        jTableDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Telefone", "E-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDados);
        if (jTableDados.getColumnModel().getColumnCount() > 0) {
            jTableDados.getColumnModel().getColumn(0).setMinWidth(250);
            jTableDados.getColumnModel().getColumn(0).setPreferredWidth(250);
            jTableDados.getColumnModel().getColumn(0).setMaxWidth(250);
            jTableDados.getColumnModel().getColumn(1).setMinWidth(160);
            jTableDados.getColumnModel().getColumn(1).setPreferredWidth(160);
            jTableDados.getColumnModel().getColumn(1).setMaxWidth(160);
        }

        jFormattedTextFieldTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldTelefoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldTelefoneFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTelefone)
                            .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelEmail))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelTelefone)
                    .addComponent(jLabelEmail))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            validarPreenchimento();
            validarInclusao();
            incluirNaTabela();
            limparCampos();
            mensagem("SUCESSO!", "Registro incluído com sucesso!");
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jFormattedTextFieldTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTelefoneFocusLost
        try {
            mudaMascaraTelefone(jFormattedTextFieldTelefone);
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jFormattedTextFieldTelefoneFocusLost

    private void jFormattedTextFieldTelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTelefoneFocusGained
        jFormattedTextFieldTelefone.setFormatterFactory(null);
    }//GEN-LAST:event_jFormattedTextFieldTelefoneFocusGained

    private void jTextFieldEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyReleased
        jTextFieldEmail.setText(jTextFieldEmail.getText().toLowerCase());
    }//GEN-LAST:event_jTextFieldEmailKeyReleased

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
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDados;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}
