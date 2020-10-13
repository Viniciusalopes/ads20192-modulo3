/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 13/10/2020 07:53:02 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Acesso a dados da tabela [tiposminiatura].
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import br.com.vinicius.generic.DalGeneric;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.vinicius.model.TipoMiniatura;

/**
 *
 * @author vovostudio
 */
public class DalTipoMiniatura extends DalGeneric {

    public DalTipoMiniatura() throws Exception {
        super("tiposminiatura");
    }

    //--- GET ------------------------------------------------------------------------------------->
    //
    @Override
    protected ArrayList<?> build(ResultSet rs) throws Exception {
        ArrayList<TipoMiniatura> ret = new ArrayList<>();
        while (rs.next()) {
            TipoMiniatura tipo = new TipoMiniatura();
            tipo.setId(rs.getInt("tipo_id"));
            tipo.setNome(rs.getString("tipo_nome"));
            ret.add(tipo);
        }
        return ret;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(TipoMiniatura tipo) throws Exception {
        sql = "INSERT INTO tiposminiatura (tipo_nome) VALUES (?)";
        args = new Object[]{tipo.getNome()};
        execute();
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    public boolean exists(TipoMiniatura tipo) throws Exception {
        return exists(new String[]{"tipo_nome", "tipo_id"}, new Object[]{tipo.getNome(), tipo.getId()});
    }

    public ArrayList<TipoMiniatura> get() throws Exception {
        sql = "SELECT * FROM tiposminiatura";
        args = new Object[]{};
        return (ArrayList<TipoMiniatura>) select();
    }

    public TipoMiniatura get(int id) throws Exception {
        sql = "SELECT * FROM tiposminiatura WHERE tipo_id = ? ";
        args = new Object[]{id};
        return (TipoMiniatura) select().get(0);
    }

    public TipoMiniatura get(String nome) throws Exception {
        sql = "SELECT * FROM tiposminiatura WHERE tipo_nome = ?";
        args = new Object[]{nome};
        return (TipoMiniatura) select().get(0);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(TipoMiniatura tipo) throws Exception {
        sql = "UPDATE tiposminiatura SET tipo_nome = ? WHERE tipo_id = ?";
        args = new Object[]{tipo.getNome(), tipo.getId()};
        execute();
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int id) throws Exception {
        sql = "DELETE FROM tiposminiatura WHERE tipo_id = ?";
        args = new Object[]{id};
        execute();
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
