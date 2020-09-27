/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 14/09/2020 05:06:43 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
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
            new Field("habilidade_codigo", habilidade.getCodigo()),
            new Field("habilidade_descricao", habilidade.getDescricao())},
                null
        );
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public ArrayList<Habilidade> retrieveAll() throws Exception {
        return cast(select(null, null, new Habilidade()));
    }

    public Habilidade retrieveById(int idHabilidade) throws Exception {
        return (Habilidade) retrieveById(idHabilidade, "habilidade_id", new Habilidade());
    }

    public ArrayList<Habilidade> retrieveByField(String[] fieldsOnly, Where where) throws Exception {
        return cast(select(fieldsOnly, new Where[]{where}, new Habilidade()));
    }

    public ArrayList<Habilidade> retrieveByFields(String[] fieldsOnly, Where[] where) throws Exception {
        return cast(select(fieldsOnly, where, new Habilidade()));
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
                    new Field("habilidade_codigo", habilidade.getCodigo()),
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
