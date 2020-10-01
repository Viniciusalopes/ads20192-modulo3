/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 14/09/2020 03:26:08 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Acesso genérico a dados (Classe base para DAOEspecialista's).
 *  ------------------------------------------------------------------------------------------------| 
 */
package dao.generic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public class DAOGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static BDConn bdConn = null;
    private Connection conn = null;
    protected String sql;
    protected Object[] params;
    protected ResultSet rs;
    protected String table = "";
    protected ArrayList<TableField> fieldsList = null;
    protected ArrayList<Object> fieldsListOnly = null;
    protected String[] fieldsOnly = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    /**
     * Construtor.
     *
     * @param tabela Tabela que será manipulada.
     * @throws Exception
     */
    protected DAOGeneric(String tabela) throws Exception {
        bdConn = BDConn.getInstance();
        this.table = tabela;
        fieldsList = getFieldsList();
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    //--- GET ------------------------------------------------------------------------------------->
    //
    /**
     * Lista de colunas da tabela em uso pela DAO.
     *
     * @return
     * @throws Exception
     */
    private ArrayList<TableField> getFieldsList() throws Exception {
        String tableFields = table.toString();
        String tableSchema = "information_schema.columns";
        table = tableSchema.toString();

        fieldsList = new ArrayList<>();
        fieldsListOnly = new ArrayList<>();

        table = tableFields.toString();

        sql = "SELECT ordinal_position, column_name, data_type "
                + "FROM information_schema.columns "
                + "WHERE table_name = ?";
        params = new Object[]{table};
        rs = executeQuery(sql, params);
        while (rs.next()) {
            TableField tf = new TableField(
                    rs.getInt("ordinal_position"),
                    rs.getString("column_name"),
                    rs.getString("data_type"),
                    null
            );
            fieldsList.add(tf);
            fieldsListOnly.add(tf);
        }
        return fieldsList;
    }

    /**
     * Executa consulta no banco e retorna o resultado da consulta.
     *
     * @param sql Query Sql.
     * @param args Argumentos para o PrepareStatement (Parâmetros da query sql).
     * @return ResultSet com o resultado da consulta.
     * @throws Exception
     */
    private ResultSet executeQuery(String sql, Object[] args) throws Exception {
        return (ResultSet) execute(sql, args, true);
    }

    /**
     * Executa consulta no banco e retorna o resultado da execução (não o resultado da consulta).
     *
     * @param sql Query Sql.
     * @param args Argumentos para o PrepareStatement (Parâmetros da query sql).
     * @return Objeto com o resultado da execução.
     * @throws Exception
     */
    private Object execute(String sql, Object[] args) throws Exception {
        return execute(sql, args, false);
    }

    /**
     * Execução da query no banco de dados.
     *
     * @param sql Query Sql.
     * @param args Argumentos para o PrepareStatement (Parâmetros da query sql).
     * @param isQuery Determina a forma de execução e o objeto do retorno
     * @return isQuery == True: retorna resultados consulta;
     * <br>
     * isQuery == False : retorna resultado da execução.
     * @throws Exception
     */
    private Object execute(String sql, Object[] args, boolean isQuery) throws Exception {
        try {
            conn = bdConn.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                pstm.setObject(i + 1, args[i]);
            }

            Object toReturn = null;
            if (isQuery) {
                toReturn = pstm.executeQuery();
            } else {
                toReturn = pstm.execute();
            }
            return toReturn;

        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    /**
     * Converte os resultados no ResultSet para uma lista de objetos da classe, para casting na
     * DAOEspecialista.<br>
     * Utiliza o ResultSet em memória (rs) atribuído na execução das consultas.
     *
     * @param object Classe do objeto que será retornado para a DAOEspecialista.
     * @return Lista de objetos da classe, para casting na DAOEspecialista.
     * @throws Exception
     */
    private ArrayList<Object> results(Object object) throws Exception {
        this.fieldsListOnly = stringToTableField();
        ArrayList<Object> ret = new ArrayList<>();

        Object[] objectFields;
        int i;
        while (rs.next()) {
            objectFields = new Object[fieldsListOnly.size()];
            i = 0;

            for (Object obj : fieldsListOnly) {
                TableField tf = new TableField();
                tf = (TableField) obj;
                // Atribui o valor do campo pelo tipo do dado
                switch (tf.getDataType()) {
                    case "integer":
                        tf.setValue(rs.getInt(tf.getColumnName()));
                    case "character varying":
                        tf.setValue(rs.getString(tf.getColumnName()));
                }
                // Inclui o campo na lista de campos do registro para enviar para o build da classe
                objectFields[i] = tf;
                i++;
            }
            // Converte o vetor de Object em um objeto da classe desejada, passada por parâmetro, e incluir no retorno.
            ret.add((Object) object.getClass().getMethod("build", Object.class).invoke(object, (Object) objectFields));
        }
        return ret;
    }

    /**
     * Converte o vetor de strings com nomes de campos para objetos TableField.
     *
     * @param tableFields Vetor com nomes de campos da tabela.
     * @return Lista de campos da tabela em uso pela DAOEspecialista.
     */
    private ArrayList<Object> stringToTableField() {
        ArrayList<Object> ret = new ArrayList<>();
        if (this.fieldsOnly == null) {
            for (TableField tableField : fieldsList) {
                ret.add(tableField);
            }
        } else {
            for (String field : this.fieldsOnly) {
                for (TableField fieldList : fieldsList) {
                    if (field.equals(fieldList.getColumnName())) {
                        ret.add(fieldList);
                    }
                }
            }
        }
        return ret;
    }

    /**
     * Converte o vetor de strings com nomes de campos para objetos TableField.
     *
     * @param tableFields Vetor com nomes de campos da tabela.
     * @return Lista de campos da tabela em uso pela DAOEspecialista.
     */
    private TableField[] fieldToTableField(Field[] fields) throws Exception {
        TableField[] ret = new TableField[fields.length];
        for (int i = 0; i < fields.length; i++) {
            for (TableField fieldList : fieldsList) {
                if (fields[i].getColumnName().equals(fieldList.getColumnName())) {
                    ret[i] = fieldList;
                    ret[i].setValue(fields[i].getValue());
                }
            }
        }
        return ret;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    /**
     * Cria uma query de SELECT com os campos que serão incluídos no resultado e com as condições e
     * filtros do select.
     *
     * @param fieldsOnly Campos da tabela que serão incluídos no resultado.
     * @param where Cláusulas com condições e filtros para o SELECT.
     * @param object Classe do objeto que será retornado para a DAOEspecialista.
     * @return Lista de objetos da classe, para casting na DAOEspecialista.* @throws Exception
     */
    private void createSqlSelect(Where[] where) throws Exception {
        this.fieldsListOnly = stringToTableField();
        params = new Object[]{};
        sql = "SELECT ";
        if (fieldsOnly == null) {
            sql += "*";
        } else {
            for (Object field : fieldsListOnly) {
                TableField tf = (TableField) field;
                sql += tf.getColumnName() + ", ";
            }
            sql = sql.substring(0, sql.length() - 2);
        }

        sql += " FROM " + table;

        includeWhere(where, 0);
    }

    /**
     * Inclui as cláusulas WHERE na query (sql).
     *
     * @param where Cláusulas com condições e filtros.
     * @param pos Posicão inicial para inclusão de parâmetros, porque já podem ter parâmetros
     * anteriores ao WHERE.
     */
    private void includeWhere(Where[] where, int pos) {
        if (where != null) {
            params = redimVector(params, params.length + where.length);

            sql += " WHERE (";
            int i = pos;
            for (Where w : where) {
                sql += w.getAndOr() + " " + w.getColumnName() + " " + w.getComparer().getComparator() + " ?";
                params[i] = w.getValue();
                i++;
            }
            sql += ")";
        }
    }

    /**
     * Redimensiona um vetor de objetos.
     *
     * @param vector Vetor com objetos que será red
     * @param newLenght
     * @return
     */
    private Object[] redimVector(Object[] vector, int newLenght) {
        int lenght = (vector.length > newLenght) ? (vector.length - newLenght) : newLenght;
        Object[] ret = new Object[lenght];
        for (int i = 0; i < vector.length; i++) {
            ret[i] = vector[i];
        }
        return ret;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    /**
     * Converte Field para TableField e insere registros na tabela.
     *
     * @param field Objetos com o nome da coluna e o valor dos campos que serão inseridos.
     * @param where Cláusulas com condições e filtros para o INSERT.
     * @throws Exception
     */
    protected void insert(Field[] field, Where[] where) throws Exception {
        insert(fieldToTableField(field), where);
    }

    /**
     * Insere registros na tabela.
     *
     * @param tableFields Campos que serão inseridos.
     * @param where Cláusulas com condições e filtros para o INSERT.
     * @throws Exception
     */
    protected void insert(TableField[] tableFields, Where[] where) throws Exception {

        String strValues = "";
        sql = "INSERT INTO " + table + "(";
        params = new Object[tableFields.length];

        int i = 0;
        for (TableField value : tableFields) {
            sql += value.getColumnName() + ", ";
            strValues += "?, ";
            params[i] = value.getValue();
            i++;
        }
        sql = sql.substring(0, sql.length() - 2) + ") VALUES (" + strValues.substring(0, strValues.length() - 2) + ")";

        includeWhere(where, i);

        sql += ";";

        execute(sql, params);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    /**
     * Obtém o maior ID de uma tabela.
     *
     * @param fieldId Coluna com o ID da tabela que se deseja o maior.
     * @return Maior ID cadastrado na tabela.
     * @throws Exception
     */
    public int getMaxId(String fieldId) throws Exception {
        sql = "SELECT MAX(" + fieldId + ") FROM " + table;
        rs = executeQuery(sql, new Object[]{});
        if (rs.next()) {
            return rs.getInt("max");
        }
        return 0;
    }

    /**
     * Prepara e executa a consulta ao banco de dados com os parâmetros passados pela
     * DAOEspecialista.
     *
     * @param sql Query Sql final que será executada como foi recebida no parâmetro sem manipulação.
     * @param params Argumentos para o PrepareStatement (Parâmetros da query sql).
     * @param object Classe do objeto que será retornado para a DAOEspecialista.
     * @return Lista de objetos da classe, para casting na DAOEspecialista.
     * @throws Exception
     */
    protected ArrayList<Object> executeQuery(String sql, Object[] params, Object object) throws Exception {
        this.fieldsOnly = null;
        rs = executeQuery(sql, params);
        return results(object);
    }

    /**
     * Monta uma query de SELECT a partir dos campos desejados e das condições,<br>prepara e executa
     * a consulta ao banco de dados com os parâmetros passados pela DAOEspecialista.
     *
     * @param fieldsOnly Campos da tabela que serão incluídos no resultado.
     * @param where Cláusulas com condições e filtros para o SELECT.
     * @param object Classe do objeto que será retornado para a DAOEspecialista.
     * @return Lista de objetos da classe, para casting na DAOEspecialista.
     * @throws Exception
     */
    protected ArrayList<Object> select(String[] fieldsOnly, Where[] where, Object object) throws Exception {
        this.fieldsOnly = fieldsOnly;
        createSqlSelect(where);
        rs = executeQuery(sql, params);
        return results(object);
    }

    /**
     * Monta uma query de SELECT a partir dos campos desejados e das condições,<br>prepara e executa
     * a consulta ao banco de dados com os parâmetros passados pela DAOEspecialista.
     *
     * @param id ID do registro a ser pesquisado.
     * @param fieldId Nome da coluna do banco de dados correspondente ao ID do registro.
     * @param object Classe do objeto que será retornado para a DAOEspecialista.
     * @return Único objeto da classe, para casting na DAOEspecialista.
     * @throws Exception
     */
    protected Object retrieveById(int id, String fieldId, Object object) throws Exception {
        return (select(null, new Where[]{new Where("", fieldId, Comparer.EQUAL, id)}, object)).get(0);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    /**
     * Converte Field para TableField e atualiza registros na tabela.
     *
     * @param field Objetos com o nome da coluna e o valor dos campos que serão atualizados.
     * @param where Cláusulas com condições e filtros para o UPDATE.
     * @throws Exception
     */
    protected void update(Field[] field, Where[] where) throws Exception {
        update(fieldToTableField(field), where);
    }

    /**
     * Atualiza registros na tabela.
     *
     * @param tableFields Campos da tabela que serão atualizados.
     * @param where Cláusulas com condições e filtros para o UPDATE.
     * @throws Exception
     */
    protected void update(TableField[] tableFields, Where[] where) throws Exception {
        sql = "UPDATE " + table + " SET ";
        params = new Object[tableFields.length];

        int i = 0;
        for (TableField value : tableFields) {
            sql += value.getColumnName() + " = ?, ";
            params[i] = value.getValue();
            i++;
        }
        sql = sql.substring(0, sql.length() - 2);

        includeWhere(where, i);

        sql += ";";

        execute(sql, params);
    }
    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //

    //--- DELETE ---------------------------------------------------------------------------------->
    //
    /**
     * Exclui um registro da tabela.
     *
     * @param where Cláusulas com condições e filtros para o DELETE.<br>Não permite DELETE sem
     * WHERE.
     * @throws Exception
     */
    protected void delete(Where[] where) throws Exception {
        // e.e
        if (where == null) {
            throw new Exception("Faz isso não, parente... DELETE sem WHERE?!");
        }
        params = new Object[]{};
        sql = "DELETE FROM " + table + " ";
        includeWhere(where, 0);

        sql += ";";

        execute(sql, params);
    }

    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
