/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 28/09/2020 18:17:52 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Classe Dal genérica.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import br.com.vinicius.model.Tema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public abstract class AbstractDal {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private BDConn bdConn = null;
    private Connection conn = null;
    protected String sql = "";
    protected Object[] args = null;
    protected String table = "";
    protected String fieldIdColumn = "";

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public AbstractDal(String table, String fieldIdColumn) throws Exception {
        bdConn = BDConn.getInstance();
        this.table = table;
        this.fieldIdColumn = fieldIdColumn;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public ResultSet executeQuery(String sql, Object[] args) throws Exception {
        return (ResultSet) execute(sql, args, true);
    }

    public Object execute(String sql, Object[] args) throws Exception {
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

    public ArrayList<?> getAll() throws Exception {
        sql = "SELECT * FROM " + table + ";";
        args = new Object[]{};
        return build(executeQuery(sql, args));
    }

    public ArrayList<?> getBy(String field, Object value) throws Exception {
        sql = "SELECT * FROM " + table + " WHERE " + field + " = ?;";
        args = new Object[]{value};
        return build(executeQuery(sql, args));
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int id) throws Exception {
        sql = "DELETE FROM " + table + " WHERE " + fieldIdColumn + " = ?;";
        args = new Object[]{id};
        execute(sql, args);
    }

    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
