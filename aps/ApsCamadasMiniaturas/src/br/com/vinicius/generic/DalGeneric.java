/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 28/09/2020 18:17:52 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Classe Dal genérica.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.generic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public abstract class DalGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private BDConn bdConn = null;               // Objeto para conexão com o banco de dados.
    private Connection conn = null;             // Conexão.
    protected String table = "";                // Nome da tabela filha.
    protected String sql = "";                  // Instrução SQL.
    protected Object[] args = new Object[]{};   // Argumentos (parâmetros) para a instrução SQL.

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    /**
     * Construtor para herança.
     *
     * @param table Nome da tabela filha.
     * @throws Exception
     */
    protected DalGeneric(String table) throws Exception {
        bdConn = BDConn.getInstance();
        this.table = table;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    /**
     * Executa uma consulta e converte os objetos do resultado para objetos da classe filha.
     *
     * @return
     * @throws Exception
     */
    protected ArrayList<?> select() throws Exception {
        return build(executeQuery());
    }

    /**
     * Executa uma consulta em uma tabela.
     *
     * @return
     * @throws Exception
     */
    protected ResultSet executeQuery() throws Exception {
        return (ResultSet) execute(true);
    }

    /**
     * Executa uma instrução SQL em um tabela.
     *
     * @return
     * @throws Exception
     */
    protected Object execute() throws Exception {
        return execute(false);
    }

    /**
     * Obtém uma conexão, executa uma instrução SQL ou uma consulta, e retorna o resultado.
     *
     * @param isQuery TRUE: retorna o ResultSet com o resultado da query.<br>
     * FALSE: Retorna um objeto com o resultado da execução da instrução SQL.
     * @return
     * @throws Exception
     */
    private Object execute(boolean isQuery) throws Exception {
        try {
            conn = bdConn.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                pstm.setObject((i + 1), args[i]);
            }

            return (isQuery) ? pstm.executeQuery() : pstm.execute();

        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    protected abstract ArrayList<?> build(ResultSet rs) throws Exception;

    /**
     * Verifica se existe uma tupla em uma tabela a partir de um nome de coluna e um valor;
     *
     * @param field Nome da coluna do valor procurado.
     * @param value Valor procurado.
     * @return
     * @throws Exception
     */
    protected boolean exists(String field, Object value) throws Exception {
        sql = "SELECT COUNT(*) FROM " + table + " WHERE " + field + " = ? ";
        args = new Object[]{value};
        ResultSet rs = executeQuery();
        if (rs.next()) {
            return rs.getInt("count") > 0;
        }
        return false;
    }

    /**
     * Verifica se uma tabela está vazia.
     *
     * @param table Tabela a ser verificada.
     * @return True = Vazia.
     * @throws Exception
     */
    protected boolean isEmptyTable(String table) throws Exception {
        sql = "SELECT COUNT(*) FROM " + table;
        args = new Object[]{};
        ResultSet rs = executeQuery();
        if (rs.next()) {
            return rs.getInt("count") == 0;
        }
        return true;
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
}
