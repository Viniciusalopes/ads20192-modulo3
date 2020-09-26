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

/**
 *
 * @author vovostudio
 */
public class DAOColaborador extends DAOGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
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
        return cast(select(null, null, new Colaborador()));
    }

    public Colaborador retrieveById(int idColaborador) throws Exception {
        return (Colaborador) retrieveById(idColaborador, "colaborador_id", new Colaborador());
    }

    public ArrayList<Colaborador> retrieveByField(String[] fieldsOnly, Where where) throws Exception {
        return cast(select(fieldsOnly, new Where[]{where}, new Colaborador()));
    }

    public ArrayList<Colaborador> retrieveByFields(String[] fieldsOnly, Where[] where) throws Exception {
        return cast(select(fieldsOnly, where, new Colaborador()));
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
                new Field[]{new Field("setor_nome", colaborador.getNome())},
                new Where[]{new Where("", "setor_id", Comparer.EQUAL, colaborador.getId())}
        );
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int id) throws Exception {
        delete(new Where[]{new Where("", "setor_id", Comparer.EQUAL, id)});
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //

}
