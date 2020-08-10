/**
 * Licença MIT Copyright(c) 2020 Viniciusalopes Tecnologia
 *
 * A permissão é concedida, gratuitamente, a qualquer pessoa que obtenha uma cópia deste software e
 * dos arquivos de documentação associados (o "Software"), para negociar no Software sem restrições,
 * incluindo, sem limitação, os direitos de uso, cópia, modificação, fusão, publicar, distribuir,
 * sublicenciar e/ou vender cópias do Software e permitir que as pessoas a quem o Software é
 * fornecido o façam, sob as seguintes condições:
 *
 * O aviso de direitos autorais acima e este aviso de permissão devem ser incluídos em todas as
 * cópias ou partes substanciais do Software.
 *
 * O SOFTWARE É FORNECIDO "TAL COMO ESTÁ", SEM GARANTIA DE QUALQUER TIPO, EXPRESSA OU IMPLÍCITA,
 * INCLUINDO MAS NÃO SE LIMITANDO A GARANTIAS DE COMERCIALIZAÇÃO, ADEQUAÇÃO A UMA FINALIDADE
 * ESPECÍFICA E NÃO INFRAÇÃO. EM NENHUM CASO OS AUTORES OU TITULARES DE DIREITOS AUTORAIS SERÃO
 * RESPONSÁVEIS POR QUALQUER REIVINDICAÇÃO, DANOS OU OUTRA RESPONSABILIDADE, SEJA EM AÇÃO DE
 * CONTRATO, TORT OU OUTRA FORMA, PROVENIENTE, FORA OU EM CONEXÃO COM O SOFTWARE OU O USO, OU OUTROS
 * ACORDOS NOS PROGRAMAS.
 * -------------------------------------------------------------------------------------------------
 * Tela de cadastros de Pessoas.
 * Criação : Vovolinux
 * Data    : 10/08/2020
 * Projeto : EXERCÍCIOS PRIMEIRA AULA DE ESTRUTURA DE DADOS – VETORES
 *   3. Faça um programa de consulta de telefones a partir de um nome informado como uma chave de
 *   dados. O programa deve:
 *   • Conter uma classe Pessoa com os atributos nome, telefone e e-mail;
 *   • Permitir a entrada de nomes de pessoas com seus respectivos telefones e e-mails, sendo a
 *   quantidade determinada pelo usuário, e armazená-los em um vetor de objetos pessoas;
 *   • Permitir ao usuário inserir qual o nome que ele deseja consultar o telefone. Após a consulta,
 *   exiba o telefone da pessoa procurada. Informe também se o nome é inexistente no vetor de
 *   pessoas.
 * -------------------------------------------------------------------------------------------------
 */
package telas;

import controladores.ControlePessoa;
import enumeradores.EnumErros;
import utilidades.MensagensDialog;
import enumeradores.EnumTitulos;
import enumeradores.EnumRotulos;
import modelos.Pessoa;
import static utilidades.UtilString.mascaraTelefone;

/**
 *
 * @author vovostudio
 */
public class TelaCadastros extends javax.swing.JFrame {

    private ControlePessoa controle;

    /**
     * Creates new form TelaCadastros
     */
    public TelaCadastros() {
        initComponents();
    }

    public TelaCadastros(int quantidade) {
        initComponents();
        this.setLocationRelativeTo(rootPane);
        try {
            controle = new ControlePessoa(quantidade);
            atualizarJTablePessoas();
            mostraUtilizacao();
        } catch (Exception e) {
            new MensagensDialog().erro(e);
        }
    }

    private void atualizarJTablePessoas() throws Exception {
        int utilizados = controle.getUtilizados();

        Object[][] linhas = new Object[utilizados][3];
        if (utilizados > 0) {
            Pessoa[] pessoas = controle.consultar();
            for (int i = 0; i < utilizados; i++) {
                linhas[i][0] = pessoas[i].getNome();
                linhas[i][1] = mascaraTelefone(pessoas[i].getTelefone());
                linhas[i][2] = pessoas[i].getEmail();
            }
        }
        String[] colunas = {EnumRotulos.CampoNome.getRotulo(), EnumRotulos.CampoTelefone.getRotulo(), EnumRotulos.CampoEmail.getRotulo()};
        jTablePessoas.setModel(new javax.swing.table.DefaultTableModel(linhas, colunas) {
            boolean[] canEdit = new boolean[]{false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTablePessoas);
        if (jTablePessoas.getColumnModel().getColumnCount() > 0) {
            jTablePessoas.getColumnModel().getColumn(0).setMinWidth(200);
            jTablePessoas.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTablePessoas.getColumnModel().getColumn(0).setMaxWidth(200);
            jTablePessoas.getColumnModel().getColumn(0).setHeaderValue(EnumRotulos.CampoNome.getRotulo());
            jTablePessoas.getColumnModel().getColumn(1).setMinWidth(180);
            jTablePessoas.getColumnModel().getColumn(1).setPreferredWidth(180);
            jTablePessoas.getColumnModel().getColumn(1).setMaxWidth(180);
            jTablePessoas.getColumnModel().getColumn(1).setHeaderValue(EnumRotulos.CampoTelefone.getRotulo());
            jTablePessoas.getColumnModel().getColumn(2).setMinWidth(300);
            jTablePessoas.getColumnModel().getColumn(2).setPreferredWidth(300);
            jTablePessoas.getColumnModel().getColumn(2).setMaxWidth(300);
            jTablePessoas.getColumnModel().getColumn(2).setHeaderValue(EnumRotulos.CampoEmail.getRotulo());
        }
        mostraUtilizacao();
    }

    private void mostraUtilizacao() {
        jLabelUtilizacao.setText(String.format("USO DA MEMÓRIA: Capacidade: %d | Utilizados: %d | Disponíveis: %d",
                controle.getCapacidade(), controle.getUtilizados(), controle.getDisponiveis()));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonIncluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePessoas = new javax.swing.JTable();
        jButtonSair = new javax.swing.JButton();
        jLabelUtilizacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(EnumTitulos.TituloCadastroPessoas.getTitulo());
        setResizable(false);

        jButtonIncluir.setText("Incluir");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jTablePessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTablePessoas);

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabelUtilizacao.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelUtilizacao.setText("jLabelUtilizacao");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUtilizacao)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonIncluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSair)))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluir)
                    .addComponent(jButtonSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUtilizacao)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        try {
            if (controle.getDisponiveis() == 0) {
                throw new Exception(EnumErros.CapacidadeMaximaAlcancada.getMensagem());
            }
            JDialogIncluirPessoa dialog = new JDialogIncluirPessoa(this, true);
            dialog.setControle(controle);
            dialog.setVisible(true);
            this.controle = dialog.getControle();
            atualizarJTablePessoas();
        } catch (Exception e) {
            new MensagensDialog().erro(e);
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelUtilizacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePessoas;
    // End of variables declaration//GEN-END:variables
}
