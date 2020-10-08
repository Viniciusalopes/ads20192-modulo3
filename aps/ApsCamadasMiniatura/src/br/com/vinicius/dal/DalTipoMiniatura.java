/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 29/09/2020 08:25:59 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Camada de acesso a dados da tabela [TiposMiniaturas]
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import br.com.vinicius.generic.DalGeneric;
import br.com.vinicius.model.TipoMiniatura;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author vovostudio
 */
public class DalTipoMiniatura extends DalGeneric {

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DalTipoMiniatura() throws Exception {
        super("\"TiposMiniaturas\"", "tipo_id", "tipo_nome");
        sql = "SELECT * FROM " + table + " ";
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(TipoMiniatura tipoMiniatura) throws Exception {
        String sql = "INSERT INTO " + table + " (tipo_nome) VALUES (?);";
        args = new Object[]{tipoMiniatura.getTipoMiniatura_nome()};
        execute(sql, args);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    @Override
    protected ArrayList<TipoMiniatura> build(ResultSet rs) throws Exception {
        ArrayList<TipoMiniatura> ret = new ArrayList<>();
        while (rs.next()) {
            ret.add(new TipoMiniatura(rs.getInt("tipo_id"), rs.getString("tipo_nome")));
        }
        return ret;
    }

    public TipoMiniatura getById(int id) throws Exception {
        return (TipoMiniatura) getBy(fieldIdColumn, id).get(0);
    }

    public TipoMiniatura getByName(String nome) throws Exception {
        return (TipoMiniatura) getBy("tipo_nome", nome).get(0);
    }

    public boolean exists(int id) throws Exception {
        return exists(id, "tipo_id");
    }

    public boolean isEmptyTable() throws Exception {
        return isEmptyTable(table);
    }    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //

    public void update(TipoMiniatura tipoMiniatura) throws Exception {
        String sql = "UPDATE " + table + " SET tipo_nome = ? WHERE tipo_id = ?;";
        args = new Object[]{tipoMiniatura.getTipoMiniatura_nome(), tipoMiniatura.getTipoMiniatura_id()};
        execute(sql, args);
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
}
