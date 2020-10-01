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
 *  Acesso a dados da tabela [setores].
 *  ------------------------------------------------------------------------------------------------| 
 */
package dao;

import dao.generic.Comparer;
import dao.generic.DAOGeneric;
import dao.generic.Field;
import dao.generic.Where;
import java.util.ArrayList;
import model.Setor;

/**
 *
 * @author vovostudio
 */
public class DAOSetor extends DAOGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DAOSetor() throws Exception {
        super("setores");
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
    public void add(Setor setor) throws Exception {
        insert(new Field[]{
            new Field("setor_nome", setor.getNome()),
            new Field("setor_empresa_id", setor.getIdEmpresa())},
                null
        );
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public ArrayList<Setor> retrieveAll() throws Exception {
        return cast(select(null, null, new Setor()));
    }

    public Setor retrieveById(int idSetor) throws Exception {
        return (Setor) retrieveById(idSetor, "setor_id", new Setor());
    }

    public ArrayList<Setor> retrieveByField(String[] fieldsOnly, Where where) throws Exception {
        return cast(select(fieldsOnly, new Where[]{where}, new Setor()));
    }

    public ArrayList<Setor> retrieveByFields(String[] fieldsOnly, Where[] where) throws Exception {
        return cast(select(fieldsOnly, where, new Setor()));
    }

    private ArrayList<Setor> cast(ArrayList<Object> listObjects) {
        ArrayList<Setor> ret = new ArrayList<>();
        for (Object obj : listObjects) {
            ret.add((Setor) obj);
        }
        return ret;
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Setor setor) throws Exception {
        update(
                new Field[]{new Field("setor_nome", setor.getNome())},
                new Where[]{new Where("", "setor_id", Comparer.EQUAL, setor.getId())}
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
