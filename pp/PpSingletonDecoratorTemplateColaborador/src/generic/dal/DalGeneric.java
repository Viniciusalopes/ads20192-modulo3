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
package generic.dal;

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
    protected String sql = "";
    protected Object[] args = new Object[]{};
    protected String table = "";
    protected String fieldIdColumn = "";
    protected String orderBy = "";

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    protected DalGeneric(String table, String fieldIdColumn, String orderBy) throws Exception {
        bdConn = BDConn.getInstance();
        this.table = table;
        this.fieldIdColumn = fieldIdColumn;
        this.orderBy = (orderBy.equals("") ? "" : " ORDER BY " + orderBy);
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    private ResultSet executeQuery(String sql, Object[] args) throws Exception {
        return (ResultSet) execute(sql, args, true);
    }

    private Object execute(String sql, Object[] args) throws Exception {
        return execute(sql, args, false);
    }

    private Object execute(String sql, Object[] args, boolean isQuery) throws Exception {
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
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    protected Object insert(String[] fields, Object[] args) throws Exception {
        if (fields == null || fields.length == 0
                || args == null || args.length == 0
                || fields.length != args.length) {
            throw new Exception("Argumentos inválidos para o insert na tabela [" + table + "]!");
        }
        String sql = "INSERT INTO " + table + "(";
        String params = "(";
        for (String f : fields) {
            sql += f + ", ";
            params += "?, ";
        }
        sql = sql.substring(0, sql.length() - 2) + ") VALUES ";
        sql += params.substring(0, -2) + ")";

        return execute(sql, args);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    protected abstract ArrayList<?> build(ResultSet rs, String[] fields) throws Exception;

    protected Object select(String[] fields, String[][] joins, String[][] wheres, Object[] args, boolean resultSet) throws Exception {

        if (args == null || args.length != wheres.length) {
            throw new Exception("Argumentos inválidos para o select na tabela [" + table + "]!");
        }

        String sql = "SELECT ";

        if (fields == null || fields.length == 0) {
            sql += "* ";
        } else {
            for (String f : fields) {
                sql += table + "." + f + ", ";
            }
        }
        sql = sql.substring(0, sql.length() - 2) + " FROM " + table;

        if (joins != null && joins.length > 0) {
            for (int j = 0; j < joins.length; j++) {
                if (joins[j].length < 3) {
                    throw new Exception("Join na posição [" + j + "] é inválido para o select na tabela [" + table + "]!");
                } else {
                    sql += " JOIN " + joins[j][0] + " ON " + table + "." + fieldIdColumn + " = " + joins[j][1] + "." + joins[j][2];
                }
            }
        }

        if (wheres != null && wheres.length > 0) {
            sql += "WHERE ";
            for (int w = 0; w < wheres.length; w++) {
                if (wheres[w].length < 4) {
                    throw new Exception("Where na posição [" + w + "] é inválido para o select na tabela [" + table + "]!");
                } else {
                    sql += ((wheres[w][0].toString().length() == 0) ? "" : wheres[w][0] + " ")
                            + wheres[w][1] + " " + wheres[w][2] + " " + wheres[w][3];
                }
            }
        }

        return select(fields, sql, args, resultSet);
    }

    protected Object select(String[] fields, String sql, Object[] args, boolean resultSet) throws Exception {
        try {

            ResultSet rs = executeQuery(sql, args);
            return (resultSet) ? rs : build(rs, fields);
        } catch (Exception e) {
            throw new Exception("Erro no select na tabela [" + table + "]:\n" + e.getMessage());
        }
    }

    protected boolean exists(int id, String field) throws Exception {
        String sql = "SELECT COUNT(*) FROM " + table + " WHERE " + field + " = ? ";
        args = new Object[]{id};
        ResultSet rs = executeQuery(sql, args);
        if (rs.next()) {
            return rs.getInt("count") > 0;
        }
        return false;
    }

    protected boolean isEmptyTable(String table) throws Exception {
        String sql = "SELECT COUNT(*) FROM " + table;
        args = new Object[]{};
        ResultSet rs = executeQuery(sql, args);
        if (rs.next()) {
            return rs.getInt("count") == 0;
        }
        return true;
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    protected void update(String[] fields, Object wheres[][], String[] args) throws Exception {

        if (fields == null || args == null || wheres == null
                || fields.length == 0 || args.length == 0 || wheres.length == 0
                || args.length < (fields.length + wheres.length)) {
            throw new Exception("Argumentos inválidos para o update na tabela [" + table + "].");
        }

        String sql = "UPDATE " + table + " SET ";

        for (int f = 0; f < fields.length; f++) {
            sql += fields[f] + " = ?, ";
        }

        sql = sql.substring(0, sql.length() - 2);

        if (wheres != null && wheres.length > 0) {
            sql += "WHERE ";
            for (int w = 0; w < wheres.length; w++) {
                if (wheres[w].length < 4) {
                    throw new Exception("Where na posição [" + w + "] é inválido para o select na tabela [" + table + "]!");
                } else {
                    sql += ((wheres[w][0].toString().length() == 0) ? "" : wheres[w][0] + " ")
                            + wheres[w][1] + " " + wheres[w][2] + " " + wheres[w][3];
                }
            }
        }
        execute(sql, args);
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    protected void delete(int id) throws Exception {
        String sql = "DELETE FROM " + table + " WHERE " + fieldIdColumn + " = ?;";
        args = new Object[]{id};
        execute(sql, args);
    }

    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
