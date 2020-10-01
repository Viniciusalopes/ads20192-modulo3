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
 *  Acesso a dados da tabela [colaboradores].
 *  ------------------------------------------------------------------------------------------------| 
 */
package dao;

import dao.generic.util.Comparer;
import dao.generic.DAOGeneric;
import dao.generic.model.Field;
import dao.generic.model.Where;
import java.util.ArrayList;
import model.Colaborador;
import model.Habilidade;

/**
 *
 * @author vovostudio
 */
public class DAOColaborador extends DAOGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private String joinSql = "SELECT * FROM colaboradores c "
            + "JOIN habilidades_colaborador hc ON c.colaborador_id = hc.colaborador_id "
            + "JOIN habilidades h ON hc.habilidade_id = h.habilidade_id "
            + "JOIN setores s ON c.colaborador_setor_id = s.setor_id ";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DAOColaborador() throws Exception {
        super("colaboradores");
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
    public void add(Colaborador colaborador) throws Exception {
        insert(new Field[]{
            new Field("colaborador_nome", colaborador.getNome()),
            new Field("colaborador_setor_id", colaborador.getSetor().getId())},
                null
        );
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public ArrayList<Colaborador> retrieveAll() throws Exception {
        sql = joinSql;
        params = new Object[]{};
        return cast(executeQuery(sql, params, new Habilidade()));
    }

    public Colaborador retrieveById(int idColaborador) throws Exception {
         sql = joinSql + " WHERE colaborador_id = ?";
        params = new Object[]{idColaborador};
        return cast(executeQuery(sql, params, new Colaborador())).get(0);
    }

    public ArrayList<Colaborador> retrieveByField(String[] fieldsOnly, Where where) throws Exception {
        sql = joinSql;
        this.fieldsOnly = fieldsOnly;
        includeWhere(new Where[]{where}, 0);
        return cast(executeQuery(sql, params, new Colaborador()));
    }

    public ArrayList<Colaborador> retrieveByFields(String[] fieldsOnly, Where[] where) throws Exception {
        this.fieldsOnly = fieldsOnly;
        sql = joinSql;
        includeWhere(where, 0);
        return cast(executeQuery(sql, params, new Colaborador()));
    }

    private ArrayList<Colaborador> cast(ArrayList<Object> listObjects) {
        ArrayList<Colaborador> ret = new ArrayList<>();
        for (Object obj : listObjects) {
            ret.add((Colaborador) obj);
        }
        return ret;
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Colaborador colaborador) throws Exception {
        update(
                new Field[]{
                    new Field("colaborador_nome", colaborador.getNome()),
                    new Field("colaborador_setor_id", colaborador.getSetor().getId())
                },
                new Where[]{new Where("", "colaborador_id", Comparer.EQUAL, colaborador.getId())}
        );
    }

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
