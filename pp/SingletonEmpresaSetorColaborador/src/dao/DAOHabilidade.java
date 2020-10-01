/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 14/09/2020 05:06:43 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Acesso a dados da tabela [habilidades].
 *  ------------------------------------------------------------------------------------------------| 
 */
package dao;

import dao.generic.util.Comparer;
import dao.generic.DAOGeneric;
import dao.generic.model.Field;
import dao.generic.model.Where;
import java.util.ArrayList;
import model.Habilidade;

/**
 *
 * @author vovostudio
 */
public class DAOHabilidade extends DAOGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private String joinSql = "SELECT * FROM habilidades h"
            + "JOIN habilidades_origem o "
            + "ON h.habilidade_origem_id = o.origem_id";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DAOHabilidade() throws Exception {
        super("habilidades");
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(Habilidade habilidade) throws Exception {
        insert(new Field[]{
            new Field("habilidade_id", habilidade.getId()),
            new Field("habilidade_origem_id", habilidade.getHabilidadeOrigem().getId()),
            new Field("habilidade_descricao", habilidade.getDescricao())},
                null
        );
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public ArrayList<Habilidade> retrieveAll() throws Exception {
        sql = joinSql;
        params = new Object[]{};
        return cast(executeQuery(sql, params, new Habilidade()));
    }

    public Habilidade retrieveById(int idHabilidade) throws Exception {
        sql = joinSql + " WHERE habilidade_id = ?";
        params = new Object[]{idHabilidade};
        return cast(executeQuery(sql, params, new Habilidade())).get(0);
    }

    public ArrayList<Habilidade> retrieveByField(String[] fieldsOnly, Where where) throws Exception {
        sql = joinSql;
        this.fieldsOnly = fieldsOnly;
        includeWhere(new Where[]{where}, 0);
        return cast(executeQuery(sql, params, new Habilidade()));
    }

    public ArrayList<Habilidade> retrieveByFields(String[] fieldsOnly, Where[] where) throws Exception {
        this.fieldsOnly = fieldsOnly;
        sql = joinSql;
        includeWhere(where, 0);
        return cast(executeQuery(sql, params, new Habilidade()));
    }

    private ArrayList<Habilidade> cast(ArrayList<Object> listObjects) {
        ArrayList<Habilidade> ret = new ArrayList<>();
        for (Object obj : listObjects) {
            ret.add((Habilidade) obj);
        }
        return ret;
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Habilidade habilidade) throws Exception {
        update(
                new Field[]{
                    new Field("habilidade_origem_id", habilidade.getHabilidadeOrigem().getId()),
                    new Field("habilidade_descricao", habilidade.getDescricao())
                },
                new Where[]{new Where("", "habilidade_id", Comparer.EQUAL, habilidade.getId())}
        );
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int id) throws Exception {
        delete(new Where[]{new Where("", "habilidade_id", Comparer.EQUAL, id)});
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //

}
