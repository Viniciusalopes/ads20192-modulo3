/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 09/10/2020 13:55:42 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Tela principal.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.app;

import br.com.vinicius.bll.BllColaborador;
import br.com.vinicius.bll.BllEmpresa;
import br.com.vinicius.bll.BllHabilidade;
import br.com.vinicius.bll.BllSetor;
import static br.com.vinicius.generic.app.AppDesktopMensagem.*;
import static br.com.vinicius.generic.app.AppFactory.getModal;
import static br.com.vinicius.generic.app.AppFactory.getSelectedId;
import br.com.vinicius.generic.app.AppIModal;
import br.com.vinicius.generic.app.AppSimpleForm;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import br.com.vinicius.model.Colaborador;
import br.com.vinicius.model.Empresa;
import br.com.vinicius.model.Habilidade;
import br.com.vinicius.model.Setor;
import br.com.vinicius.model.decorator.Contratado;
import br.com.vinicius.model.decorator.Decorativo;
import br.com.vinicius.model.decorator.DecorativoExcluir;
import br.com.vinicius.model.decorator.Stack;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import static br.com.vinicius.generic.app.AppFactory.deleteSelected;

/**
 *
 * @author vovostudio
 */
public class AppJFramePrincipal extends javax.swing.JFrame {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private Empresa empresa = null;
    private Setor setor = null;
    private Colaborador colaborador = null;
    private Contratado contratado = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public AppJFramePrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        valoresIniciais();
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    private void valoresIniciais() {
        try {
            empresa = BllEmpresa.getEmpresa();
            this.setTitle(empresa.getNome());

            jTextFieldEmpresa_id.setText(empresa.getId() + "");
            jTextFieldEmpresa_nome.setText(empresa.getNome());
            fillEmpresa();
            fillHabilidades();

        } catch (Exception e) {
            mensagemErro(e);
        }

    }

    private void fillEmpresa() throws Exception {

        // Setores
        ArrayList<Setor> setores = BllSetor.getSetores(empresa.getId());

        DefaultTableModel se = (DefaultTableModel) jTableSetoresEmpresa.getModel();
        DefaultTableModel st = (DefaultTableModel) jTableSetores.getModel();
        se.setRowCount(0);
        st.setRowCount(0);

        DefaultTableModel cl = (DefaultTableModel) jTableColaboradores.getModel();
        cl.setRowCount(0);

        for (int s = 0; s < setores.size(); s++) {
            setor = setores.get(s);

            Object[] linha = new Object[]{setor.getId(), setor.getNome()};
            se.addRow(linha);
            st.addRow(linha);

            // Colaboradores
            ArrayList<Colaborador> colabs = BllColaborador.getColaboradores(setor.getId());

            for (int c = 0; c < colabs.size(); c++) {
                Colaborador colab = colabs.get(c);
                cl.addRow(new Object[]{colab.getId(), colab.getNome(), setor.getNome()});

                // Habilidades
                ArrayList<Habilidade> habils = BllHabilidade.getHabilidades(colab.getId());
                colab.setHabilidades(habils);
                colabs.set(c, colab);
            }
            setor.setColaboradores(colabs);

        }
        empresa.setSetores(setores);
    }

    private void fillSetores() throws Exception {
        // Setores
        ArrayList<Setor> setores = BllSetor.getSetores(empresa.getId());

        DefaultTableModel se = (DefaultTableModel) jTableSetoresEmpresa.getModel();
        DefaultTableModel st = (DefaultTableModel) jTableSetores.getModel();
        se.setRowCount(0);
        st.setRowCount(0);

        for (int s = 0; s < setores.size(); s++) {
            setor = setores.get(s);

            Object[] linha = new Object[]{setor.getId(), setor.getNome()};
            se.addRow(linha);
            st.addRow(linha);
        }
        empresa.setSetores(setores);
    }

    private void fillColaboradores() throws Exception {
        // Setores
        ArrayList<Setor> setores = BllSetor.getSetores(empresa.getId());
        DefaultTableModel cl = (DefaultTableModel) jTableColaboradores.getModel();
        cl.setRowCount(0);
        for (int s = 0; s < setores.size(); s++) {
            setor = setores.get(s);

            // Colaboradores
            ArrayList<Colaborador> colabs = BllColaborador.getColaboradores(setor.getId());

            for (int c = 0; c < colabs.size(); c++) {
                Colaborador colab = colabs.get(c);
                cl.addRow(new Object[]{colab.getId(), colab.getNome(), setor.getNome()});

                // Habilidades
                ArrayList<Habilidade> habils = BllHabilidade.getHabilidades(colab.getId());
                colab.setHabilidades(habils);
                colabs.set(c, colab);
            }
            setor.setColaboradores(colabs);

        }
        empresa.setSetores(setores);
    }

    private void fillHabilidadesColaborador() throws Exception {
        DefaultTableModel hc = (DefaultTableModel) jTableHabilidadesColaborador.getModel();
        hc.setRowCount(0);
        if (colaborador != null) {
            for (Habilidade h : colaborador.getHabilidades()) {
                hc.addRow(new Object[]{h.getId(), h.getOrigem().getNome(), h.getDescricao()});
            }
        }
    }

    private void fillHabilidades() throws Exception {
        DefaultTableModel hb = (DefaultTableModel) jTableHabilidades.getModel();
        hb.setRowCount(0);

        for (Habilidade h : BllHabilidade.getHabilidades()) {
            hb.addRow(new Object[]{h.getId(), h.getOrigem().getNome(), h.getDescricao()});
        }
        fillStack();
    }

    private void fillStack() throws Exception {
        DefaultTableModel stacks = (DefaultTableModel) jTableStack.getModel();
        stacks.setRowCount(0);
        stacks.addRow(new Object[]{"Java"});
        stacks.addRow(new Object[]{"Microsoft"});
        stacks.addRow(new Object[]{"OpenSource"});
        stacks.addRow(new Object[]{"POG"});
        stacks.addRow(new Object[]{"Programador"});
        stacks.addRow(new Object[]{"Web"});
    }

    private void fillHabilidadesStack() throws Exception {
        DefaultTableModel hs = (DefaultTableModel) jTableHabilidadesStack.getModel();
        hs.setRowCount(0);
        for (Habilidade h : BllHabilidade.getHabilidadesStack(jTableStack.getSelectedRow() + 1)) {
            hs.addRow(new Object[]{h.getId(), h.getOrigem().getNome(), h.getDescricao()});
        }
    }

    private void fillHabilidadesDecoracao() throws Exception {
        DefaultTableModel hd = (DefaultTableModel) jTableDecoracao.getModel();
        hd.setRowCount(0);
        for (Habilidade h : contratado.getHabilidades()) {
            hd.addRow(new Object[]{h.getId(), h.getOrigem().getNome(), h.getDescricao()});
        }
        jLabelQuantidadeHabilidades.setText("Quantidade de Habilidades: " + contratado.getQuantidade());
    }

    //--- DECORATOR ------------------------------------------------------------------------------->
    /**
     * Cria o um novo decorado a partir do decorativo selecionado no JTable (DECORATOR E FACTORY).
     *
     * @param jTable
     * @throws Exception
     */
    private void incluirHabilidadeDecorativa(JTable jTable) throws Exception {

        String habilidade_descricao = jTable.getValueAt(jTable.getSelectedRow(), 2) + "";
        if (contratado == null) {
            throw new Exception("Selecione uma Stack para decorar!");
        }
        // Inclui a habilidade selecionada, criando um novo decorado a partir do decorativo
        
        contratado = new Decorativo(contratado, habilidade_descricao);
        
        fillHabilidadesDecoracao();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneEmpresa = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldEmpresa_id = new javax.swing.JTextField();
        jTextFieldEmpresa_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSetoresEmpresa = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButtonSalvarEmpresa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSetores = new javax.swing.JTable();
        jButtonIncluirSetor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableColaboradores = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableHabilidadesColaborador = new javax.swing.JTable();
        jButtonIncluirColaborador = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableStack = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableHabilidadesStack = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableHabilidades = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableDecoracao = new javax.swing.JTable();
        jButtonIncluirDecoracao = new javax.swing.JButton();
        jLabelQuantidadeHabilidades = new javax.swing.JLabel();
        jLabelColaboradorSelecionado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuEmpresaCadastro = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuEmpresaColaboradores = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(new java.awt.Dimension(1173, 681));

        jLabel1.setText("ID");

        jTextFieldEmpresa_id.setEditable(false);
        jTextFieldEmpresa_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldEmpresa_id.setFocusable(false);

        jTextFieldEmpresa_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldEmpresa_nomeKeyReleased(evt);
            }
        });

        jLabel2.setText("Nome da Empresa");

        jTableSetoresEmpresa.setAutoCreateRowSorter(true);
        jTableSetoresEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Setor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSetoresEmpresa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableSetoresEmpresa.getTableHeader().setReorderingAllowed(false);
        jTableSetoresEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableSetoresEmpresaMouseReleased(evt);
            }
        });
        jTableSetoresEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableSetoresEmpresaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSetoresEmpresa);
        if (jTableSetoresEmpresa.getColumnModel().getColumnCount() > 0) {
            jTableSetoresEmpresa.getColumnModel().getColumn(0).setMinWidth(80);
            jTableSetoresEmpresa.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableSetoresEmpresa.getColumnModel().getColumn(0).setMaxWidth(80);
        }
        jTableSetoresEmpresa.getAccessibleContext().setAccessibleName("Setor");

        jLabel3.setText("Setores");

        jButtonSalvarEmpresa.setText("Salvar");
        jButtonSalvarEmpresa.setEnabled(false);
        jButtonSalvarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldEmpresa_id, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldEmpresa_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonSalvarEmpresa))))
                            .addComponent(jLabel3))
                        .addGap(0, 731, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmpresa_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmpresa_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvarEmpresa))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneEmpresa.addTab("Empresa", jPanel1);

        jTableSetores.setAutoCreateRowSorter(true);
        jTableSetores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Setor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSetores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableSetores.getTableHeader().setReorderingAllowed(false);
        jTableSetores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableSetoresMouseReleased(evt);
            }
        });
        jTableSetores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableSetoresKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableSetores);
        if (jTableSetores.getColumnModel().getColumnCount() > 0) {
            jTableSetores.getColumnModel().getColumn(0).setMinWidth(80);
            jTableSetores.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableSetores.getColumnModel().getColumn(0).setMaxWidth(80);
        }
        jTableSetores.getAccessibleContext().setAccessibleName("Setor");

        jButtonIncluirSetor.setText("Incluir");
        jButtonIncluirSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirSetorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonIncluirSetor)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1249, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButtonIncluirSetor)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneEmpresa.addTab("Setores", jPanel2);

        jTableColaboradores.setAutoCreateRowSorter(true);
        jTableColaboradores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Colaborador", "Setor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableColaboradores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableColaboradores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableColaboradoresMouseReleased(evt);
            }
        });
        jTableColaboradores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableColaboradoresKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTableColaboradores);
        if (jTableColaboradores.getColumnModel().getColumnCount() > 0) {
            jTableColaboradores.getColumnModel().getColumn(0).setMinWidth(80);
            jTableColaboradores.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableColaboradores.getColumnModel().getColumn(0).setMaxWidth(80);
        }
        jTableColaboradores.getAccessibleContext().setAccessibleName("Colaborador");

        jLabel8.setText("Habilidades do colaborador");

        jTableHabilidadesColaborador.setAutoCreateRowSorter(true);
        jTableHabilidadesColaborador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Origem", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHabilidadesColaborador.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableHabilidadesColaborador.getTableHeader().setReorderingAllowed(false);
        jTableHabilidadesColaborador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableHabilidadesColaboradorKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTableHabilidadesColaborador);
        if (jTableHabilidadesColaborador.getColumnModel().getColumnCount() > 0) {
            jTableHabilidadesColaborador.getColumnModel().getColumn(0).setMinWidth(80);
            jTableHabilidadesColaborador.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableHabilidadesColaborador.getColumnModel().getColumn(0).setMaxWidth(80);
            jTableHabilidadesColaborador.getColumnModel().getColumn(1).setMinWidth(120);
            jTableHabilidadesColaborador.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTableHabilidadesColaborador.getColumnModel().getColumn(1).setMaxWidth(120);
        }
        jTableHabilidadesColaborador.getAccessibleContext().setAccessibleName("Habilidade");
        jTableHabilidadesColaborador.getAccessibleContext().setAccessibleDescription("");

        jButtonIncluirColaborador.setText("Incluir Colaborador");
        jButtonIncluirColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirColaboradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonIncluirColaborador)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 192, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(0, 197, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluirColaborador)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastro", jPanel6);

        jTableStack.setAutoCreateRowSorter(true);
        jTableStack.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome da Stack"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableStack.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableStack.getTableHeader().setReorderingAllowed(false);
        jTableStack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableStackMouseReleased(evt);
            }
        });
        jTableStack.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableStackKeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(jTableStack);

        jTableHabilidadesStack.setAutoCreateRowSorter(true);
        jTableHabilidadesStack.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Origem", "Descrição da Habilidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHabilidadesStack.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableHabilidadesStack.getTableHeader().setReorderingAllowed(false);
        jTableHabilidadesStack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableHabilidadesStackMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jTableHabilidadesStack);
        if (jTableHabilidadesStack.getColumnModel().getColumnCount() > 0) {
            jTableHabilidadesStack.getColumnModel().getColumn(0).setMinWidth(80);
            jTableHabilidadesStack.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableHabilidadesStack.getColumnModel().getColumn(0).setMaxWidth(80);
            jTableHabilidadesStack.getColumnModel().getColumn(1).setMinWidth(120);
            jTableHabilidadesStack.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTableHabilidadesStack.getColumnModel().getColumn(1).setMaxWidth(120);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Stacks", jPanel4);

        jTableHabilidades.setAutoCreateRowSorter(true);
        jTableHabilidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Origem", "Descrição da Habilidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableHabilidades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableHabilidades.getTableHeader().setReorderingAllowed(false);
        jTableHabilidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableHabilidadesMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTableHabilidades);
        if (jTableHabilidades.getColumnModel().getColumnCount() > 0) {
            jTableHabilidades.getColumnModel().getColumn(0).setMinWidth(80);
            jTableHabilidades.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableHabilidades.getColumnModel().getColumn(0).setMaxWidth(80);
            jTableHabilidades.getColumnModel().getColumn(1).setMinWidth(120);
            jTableHabilidades.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTableHabilidades.getColumnModel().getColumn(1).setMaxWidth(120);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Habilidades Conhecidas", jPanel5);

        jLabel9.setText("Decoração");

        jTableDecoracao.setAutoCreateRowSorter(true);
        jTableDecoracao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Origem", "Descrição da Habilidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDecoracao.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableDecoracao.getTableHeader().setReorderingAllowed(false);
        jTableDecoracao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableDecoracaoKeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(jTableDecoracao);
        if (jTableDecoracao.getColumnModel().getColumnCount() > 0) {
            jTableDecoracao.getColumnModel().getColumn(0).setMinWidth(80);
            jTableDecoracao.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTableDecoracao.getColumnModel().getColumn(0).setMaxWidth(80);
            jTableDecoracao.getColumnModel().getColumn(1).setMinWidth(120);
            jTableDecoracao.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTableDecoracao.getColumnModel().getColumn(1).setMaxWidth(120);
        }

        jButtonIncluirDecoracao.setText("Incluir decoração no Colaborador");
        jButtonIncluirDecoracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirDecoracaoActionPerformed(evt);
            }
        });

        jLabelQuantidadeHabilidades.setText("Quantidade de Habilidades: ");

        jLabelColaboradorSelecionado.setText("Nenhum colaborador selecionado.");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jButtonIncluirDecoracao)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelColaboradorSelecionado))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(98, 98, 98)
                                .addComponent(jLabelQuantidadeHabilidades)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluirDecoracao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelColaboradorSelecionado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabelQuantidadeHabilidades))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jTabbedPane2))
        );

        jTabbedPane1.addTab("Habilidades Decorator", jPanel7);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jTabbedPaneEmpresa.addTab("Colaboradores", jPanel3);

        jMenuEmpresaCadastro.setText("Empresa");

        jMenuItem1.setText("Cadastro");
        jMenuEmpresaCadastro.add(jMenuItem1);

        jMenuEmpresaColaboradores.setText("Setores");
        jMenuEmpresaCadastro.add(jMenuEmpresaColaboradores);

        jMenuItem3.setText("Colaboradores");
        jMenuEmpresaCadastro.add(jMenuItem3);

        jMenuBar1.add(jMenuEmpresaCadastro);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneEmpresa))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneEmpresa)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //--- ABA EMPRESA ---
    //
    private void jTextFieldEmpresa_nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmpresa_nomeKeyReleased
        try {
            jButtonSalvarEmpresa.setEnabled(!jTextFieldEmpresa_nome.getText().equalsIgnoreCase(empresa.getNome()));
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTextFieldEmpresa_nomeKeyReleased

    private void jButtonSalvarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarEmpresaActionPerformed
        try {
            String empresa_nome = jTextFieldEmpresa_nome.getText();
            BllEmpresa.update(empresa_nome);
            empresa.setNome(empresa_nome);
            this.setTitle(empresa_nome);
            jTextFieldEmpresa_nomeKeyReleased(null);
            mensagem("Sucesso!", "Empresa atualizada com sucesso!");
            jTextFieldEmpresa_nome.requestFocus();
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonSalvarEmpresaActionPerformed

    private void jButtonIncluirSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirSetorActionPerformed
        try {
            setor = new Setor(empresa.getId());
            getModal(setor, "Setor", new AppSimpleForm(this, true));
            fillSetores();
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonIncluirSetorActionPerformed

    //--- FIM ABA EMPRESA ---
    //
    //--- ABA SETORES ---
    //
    private void jTableSetoresEmpresaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSetoresEmpresaMouseReleased
        try {
            if ((evt.getClickCount() == 2)) {
                getModal(BllSetor.getSetor(getSelectedId(jTableSetoresEmpresa)), "Setor", new AppSimpleForm(this, true));
                fillSetores();
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableSetoresEmpresaMouseReleased

    private void jTableSetoresMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSetoresMouseReleased
        try {
            if ((evt.getClickCount() == 2)) {
                getModal(BllSetor.getSetor(getSelectedId(jTableSetores)), "Setor", new AppSimpleForm(this, true));
                fillSetores();
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableSetoresMouseReleased

    private void jTableSetoresEmpresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableSetoresEmpresaKeyReleased
        try {
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                deleteSelected(jTableSetoresEmpresa);
                fillSetores();
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableSetoresEmpresaKeyReleased

    private void jTableSetoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableSetoresKeyReleased
        try {
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                deleteSelected(jTableSetores);
                fillSetores();
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableSetoresKeyReleased

    //--- FIM ABA SETORES ---
    //
    //--- ABA COLABORADORES / CADASTRO ---
    //
    private void jButtonIncluirColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirColaboradorActionPerformed
        try {
            AppIModal modal = new AppJDialogColaborador(this, true);
            modal.setObject(new Colaborador());
            modal.setVisible(true);
            fillSetores();
            fillColaboradores();

        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonIncluirColaboradorActionPerformed

    private void jTableColaboradoresMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableColaboradoresMouseReleased
        try {
            colaborador = BllColaborador.getColaborador(getSelectedId(jTableColaboradores));
            if ((evt.getClickCount() == 2)) {
                AppIModal modal = new AppJDialogColaborador(this, true);
                modal.setObject(colaborador);
                modal.setVisible(true);
                fillSetores();
                fillColaboradores();
            }
            fillHabilidadesColaborador();
            jLabelColaboradorSelecionado.setText("Colaborador selecionado: " + colaborador.getId() + " - " + colaborador.getNome());
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableColaboradoresMouseReleased

    private void jTableColaboradoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableColaboradoresKeyReleased
        try {
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                deleteSelected(jTableColaboradores);
                colaborador = null;
                jLabelColaboradorSelecionado.setText("Nenhum colaborador selecionado.");
                fillColaboradores();
                fillHabilidadesColaborador();
            } else {
                colaborador = BllColaborador.getColaborador(getSelectedId(jTableColaboradores));
                jLabelColaboradorSelecionado.setText("Colaborador selecionado: " + colaborador.getId() + " - " + colaborador.getNome());
                fillHabilidadesColaborador();
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableColaboradoresKeyReleased

    private void jTableHabilidadesColaboradorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableHabilidadesColaboradorKeyReleased
        try {
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                // Exclui a habilidade do colaborador
                BllColaborador.deleteHabilidade(getSelectedId(jTableHabilidadesColaborador), colaborador.getId());
                colaborador = BllColaborador.getColaborador(getSelectedId(jTableColaboradores));
                fillHabilidadesColaborador();
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableHabilidadesColaboradorKeyReleased

    /**
     * Cria o um novo decorado a partir do decorativo selecionado com duplo clique.
     *
     * @param evt
     */
    private void jTableHabilidadesStackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHabilidadesStackMouseReleased
        try {
            if (evt.getClickCount() == 2) {
                incluirHabilidadeDecorativa(jTableHabilidadesStack);
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableHabilidadesStackMouseReleased

    //--- FIM ABA COLABORADORES / CADASTRO ---
    //
    //--- ABA COLABORADORES / HABILIDADES DECORADOR ---
    //

    private void jButtonIncluirDecoracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirDecoracaoActionPerformed
        try {
            if (jTableColaboradores.getSelectedRow() == -1) {
                throw new Exception("Selecione um colaborador na aba [Cadastro]!");
            }

            if (jTableDecoracao.getRowCount() == 0) {
                mensagem("Informação", "Selecione as habilidades que deseja incluir no cadastro do colaborador!");
                return;
            }
            ArrayList<Habilidade> habs = new ArrayList<>();
            for (int l = 0; l < jTableDecoracao.getRowCount(); l++) {
                habs.add(BllHabilidade.getHabilidade(jTableDecoracao.getValueAt(l, 2) + ""));
            }
            BllColaborador.insertHabilidadesColaborador(habs, colaborador.getId());
            ((DefaultTableModel) jTableDecoracao.getModel()).setRowCount(0);
            contratado = null;
            jLabelQuantidadeHabilidades.setText("Quantidade de Habilidades: ");
            jLabelColaboradorSelecionado.setText("Nenhum colaborador selecionado.");

            mensagem("Sucesso!", "As habilidades do colaborador foram atualizadas!");
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jButtonIncluirDecoracaoActionPerformed
    /**
     * Cria um objeto a ser decorado.<br>
     * Utilizo o padrão FACTORY para criar N acessórios a partir da descrição da STACK.
     *
     * @param evt
     */
    private void jTableStackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableStackMouseReleased
        try {
            if ((jTableHabilidadesStack.getRowCount() > 0) && (evt.getClickCount() == 2)) {
                // Cria o objeto a ser decorado
                
                contratado = new Stack(jTableStack.getSelectedRow() + 1);
                
                fillHabilidadesDecoracao();
                fillHabilidadesStack();
            }
            fillHabilidadesStack();
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableStackMouseReleased

    private void jTableStackKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableStackKeyReleased
        try {
            fillHabilidadesStack();
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableStackKeyReleased

    private void jTableDecoracaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableDecoracaoKeyReleased
        try {
            if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                // Cria o objeto a ser decorado sem a hablidade selecionada para exclusão
                String habilidade_descricao = jTableDecoracao.getValueAt(jTableDecoracao.getSelectedRow(), 2) + "";
                
                
                
                contratado = new DecorativoExcluir(contratado, habilidade_descricao);
                
                
                fillHabilidadesDecoracao();
                fillHabilidadesStack();
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableDecoracaoKeyReleased

    /**
     * Cria o um novo decorado a partir do decorativo selecionado com duplo clique.
     *
     * @param evt
     */
    private void jTableHabilidadesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHabilidadesMouseReleased
        try {
            if (evt.getClickCount() == 2) {
                incluirHabilidadeDecorativa(jTableHabilidades);
            }
        } catch (Exception e) {
            mensagemErro(e);
        }
    }//GEN-LAST:event_jTableHabilidadesMouseReleased

    //--- FIM ABA COLABORADORES / HABILIDADES DECORADOR ---
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
            java.util.logging.Logger.getLogger(AppJFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppJFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppJFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppJFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppJFramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIncluirColaborador;
    private javax.swing.JButton jButtonIncluirDecoracao;
    private javax.swing.JButton jButtonIncluirSetor;
    private javax.swing.JButton jButtonSalvarEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelColaboradorSelecionado;
    private javax.swing.JLabel jLabelQuantidadeHabilidades;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEmpresaCadastro;
    private javax.swing.JMenuItem jMenuEmpresaColaboradores;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPaneEmpresa;
    private javax.swing.JTable jTableColaboradores;
    private javax.swing.JTable jTableDecoracao;
    private javax.swing.JTable jTableHabilidades;
    private javax.swing.JTable jTableHabilidadesColaborador;
    private javax.swing.JTable jTableHabilidadesStack;
    private javax.swing.JTable jTableSetores;
    private javax.swing.JTable jTableSetoresEmpresa;
    private javax.swing.JTable jTableStack;
    private javax.swing.JTextField jTextFieldEmpresa_id;
    private javax.swing.JTextField jTextFieldEmpresa_nome;
    // End of variables declaration//GEN-END:variables
}
