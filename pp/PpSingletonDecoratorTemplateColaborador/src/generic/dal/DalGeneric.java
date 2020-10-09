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
    protected Object[] args = null;
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
    //SELECT ordinal_position, column_name, data_type FROM information_schema.columns WHERE table_name = ?
    protected ResultSet executeQuery(String sql, Object[] args) throws Exception {
        return (ResultSet) execute(sql, args, true);
    }

    protected Object execute(String sql, Object[] args) throws Exception {
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
    //--- READ ------------------------------------------------------------------------------------>
    //
    protected abstract ArrayList<?> build(ResultSet rs) throws Exception;

    public ResultSet getAllFields() throws Exception {
        args = new Object[]{};
        ResultSet r = executeQuery(sql, args);
        return r;
    }

    public ArrayList<?> getAll() throws Exception {
        return build(getAllFields());
    }

    public ResultSet getAllFields(String sql) throws Exception {
        args = new Object[]{};
        return executeQuery(sql, args);
    }

    public ArrayList<?> getAll(String sql) throws Exception {
        return build(getAllFields(sql));
    }

    protected ArrayList<?> getBy(String field, Object value) throws Exception {
        String sql = this.sql + " WHERE " + field + " = ?" + orderBy + ";";
        args = new Object[]{value};
        return build(executeQuery(sql, args));
    }

    protected ArrayList<?> getBy(String field, Object value, String sql) throws Exception {
        args = new Object[]{value};
        return build(executeQuery(sql, args));
    }

    protected ArrayList<?> getDifferent(String field, Object value) throws Exception {
        String sql = this.sql + " WHERE " + field + " <> '" + value + "'" + orderBy;
        args = new Object[]{};
        return build(executeQuery(sql, args));
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

    public boolean isEmptyTable(String table) throws Exception {
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
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM " + table + " WHERE " + fieldIdColumn + " = ?;";
        args = new Object[]{id};
        execute(sql, args);
    }

    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
