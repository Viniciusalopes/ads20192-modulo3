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
 *  Acesso a dados da tabela [habilidades_colaborador].
 *  ------------------------------------------------------------------------------------------------| 
 */
package dao;

import dao.generic.util.Comparer;
import dao.generic.DAOGeneric;
import dao.generic.model.Field;
import dao.generic.model.Where;
import java.util.ArrayList;
import model.Habilidade;
import model.HabilidadeColaborador;

/**
 *
 * @author vovostudio
 */
public class DAOHabilidadeColaborador extends DAOGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    String joinSql = "SELECT * FROM habilidades h"
            + "JOIN habilidades_colaborador hc ON h.habilidade_id = hc.habilidade_id ";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DAOHabilidadeColaborador() throws Exception {
        super("habilidades_colaborador");
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
    public void add(HabilidadeColaborador habilidadeColaborador) throws Exception {
        insert(new Field[]{
            new Field("habilidade_id", habilidadeColaborador.getHabilidadeId()),
            new Field("colaborador_id", habilidadeColaborador.getColaboradorId())
        },
                null
        );
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public ArrayList<HabilidadeColaborador> retrieveAll() throws Exception {
        sql = joinSql;
        params = new Object[]{};
        return cast(executeQuery(sql, params, new HabilidadeColaborador()));
    }

    // Ver como fazer quando é PK Composta
    //    public HabilidadeColaborador retrieveById(int idHabilidadeColaborador) throws Exception {
    //        return (HabilidadeColaborador) retrieveById(idHabilidadeColaborador, "habilidade_id", new HabilidadeColaborador());
    //    }
    public ArrayList<HabilidadeColaborador> retrieveByField(String[] fieldsOnly, Where where) throws Exception {
        return cast(select(fieldsOnly, new Where[]{where}, new HabilidadeColaborador()));
    }

    public ArrayList<HabilidadeColaborador> retrieveByFields(String[] fieldsOnly, Where[] where) throws Exception {
        return cast(select(fieldsOnly, where, new HabilidadeColaborador()));
    }

    private ArrayList<HabilidadeColaborador> cast(ArrayList<Object> listObjects) {
        ArrayList<HabilidadeColaborador> ret = new ArrayList<>();
        for (Object obj : listObjects) {
            ret.add((HabilidadeColaborador) obj);
        }
        return ret;
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int id) throws Exception {
        delete(new Where[]{new Where("", "colaborador_id", Comparer.EQUAL, id)});
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //

}
