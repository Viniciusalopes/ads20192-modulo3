/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 14/09/2020 01:24:56 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Classe de objeto Field, base para composição de objetos para DAOGeneric.
 *  ------------------------------------------------------------------------------------------------| 
 */
package dao.generic;

/**
 *
 * @author vovostudio
 */
public class Field {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    protected String column_name = "";
    protected Object value;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Field() {

    }

    public Field(String column_name, Object value) {
        this.column_name = column_name;
        this.value = value;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public String getColumnName() {
        return column_name;
    }

    public Object getValue() {
        return value;
    }

    public static Object getValue(String column_name, Object object){
        return ((TableField)object).getValue();
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setColumnName(String columnName) {
        this.column_name = columnName;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
