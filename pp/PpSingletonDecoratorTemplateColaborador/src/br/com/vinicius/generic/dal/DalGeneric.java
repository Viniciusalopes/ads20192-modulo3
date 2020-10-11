/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 09/10/2020 19:22:35 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 * Classe Dal genérica.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.generic.dal;

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
    private BDConn bdConn = null;
    private Connection conn = null;
    protected String table = "";
    protected String sql = "";
    protected Object[] args = new Object[]{};

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    protected DalGeneric(String table) throws Exception {
        bdConn = BDConn.getInstance();
        this.table = table;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    protected ArrayList<?> select() throws Exception {
        return build(executeQuery());
    }

    protected ResultSet executeQuery() throws Exception {
        return (ResultSet) execute(true);
    }

    protected Object execute() throws Exception {
        return execute(false);
    }

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

    protected boolean exists(String field, Object value) throws Exception {
        sql = "SELECT COUNT(*) FROM " + table + " WHERE " + field + " = ? ";
        args = new Object[]{value};
        ResultSet rs = executeQuery();
        if (rs.next()) {
            return rs.getInt("count") > 0;
        }
        return false;
    }

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
