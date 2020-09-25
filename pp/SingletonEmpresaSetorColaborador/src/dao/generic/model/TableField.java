/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 14/09/2020 05:13:31 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Classe de objeto com os dados das colunas de uma tabela no banco PostgreSQL.
 *  ------------------------------------------------------------------------------------------------| 
 */
package dao.generic.model;

/**
 *
 * @author vovostudio
 */
public class TableField extends Field {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int ordinal_position = 0;
    private String data_type = "";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public TableField() {

    }

    public TableField(int ordinal_position, String column_name, String data_type, Object value) {
        this.ordinal_position = ordinal_position;
        this.column_name = column_name;
        this.data_type = data_type;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getOrdinalPosition() {
        return ordinal_position;
    }

    public String getDataType() {
        return data_type;
    }

    public static TableField build(Object object) throws Exception {
        Object[] obj = (Object[]) object;
        
        return new TableField(
                Integer.parseInt(obj[0].toString()), // ordinal_position
                obj[1].toString(), // column_name
                obj[2].toString(), // data_type
                (Object) obj[3]
        );
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
}
