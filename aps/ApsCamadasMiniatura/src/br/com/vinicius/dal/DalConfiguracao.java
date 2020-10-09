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
 *  Camada de acesso a dados da tabela [Configuracoes]
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import br.com.vinicius.generic.DalGeneric;
import br.com.vinicius.model.Configuracao;
import br.com.vinicius.model.Tema;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author vovostudio
 */
public class DalConfiguracao extends DalGeneric {
    
     //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private String fields
            = " (config_nome, "
            + "config_valor, "
            + ") VALUES (?, ?) ";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DalConfiguracao() throws Exception {
        super("\"Configuracoes\"", "config_id", "config_nome");
        sql = "SELECT * FROM " + table + " ";
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //

    private Object[] getArgValues(Configuracao configuracao) {
        return new Object[]{
            configuracao.getConfig_nome(),
            configuracao.getConfig_valor()
        };
    }

    private Object[] getArgValuesToUpdate(Configuracao configuracao) {
        Object[] args = getArgValues(configuracao);
        Object[] ret = new Object[args.length + 1];

        for (int i = 0; i < args.length; i++) {
            ret[i] = args[i];
        }
        ret[ret.length - 1] = configuracao.getConfig_id();
        return ret;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(Configuracao configuracao) throws Exception {
        String sql = "INSERT INTO " + table + fields + ";";
        args = getArgValues(configuracao);
        execute(sql, args);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    @Override
    protected ArrayList<Configuracao> build(ResultSet rs) throws Exception {
        ArrayList<Configuracao> ret = new ArrayList<>();
        while (rs.next()) {
            ret.add(new Configuracao(
                    rs.getInt("tema_id"),
                    rs.getString("tema_nome"),
                    rs.getString("tema_valor"))
            );
        }
        return ret;
    }

    public Tema getById(int id) throws Exception {
        return (Tema) getBy(fieldIdColumn, id).get(0);
    }

    public Tema getByName(String nome) throws Exception {
        return (Tema) getBy("config_nome", nome).get(0);
    }

    public boolean exists(int id) throws Exception {
        return exists(id, "config_id");
    }

    public boolean isEmptyTable() throws Exception {
        return isEmptyTable(table);
    }
    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //

    public void update(Configuracao configuracao) throws Exception {
        String sql = "UPDATE " + table + " SET config_nome = ? WHERE tema_id = ?;";
        args = getArgValuesToUpdate(configuracao);
        execute(sql, args);
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
}
