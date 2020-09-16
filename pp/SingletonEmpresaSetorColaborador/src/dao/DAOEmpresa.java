/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 14/09/2020 03:44:05 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Acesso a dados da table [empresas].
 *  ------------------------------------------------------------------------------------------------| 
 */
package dao;

import dao.generic.Comparer;
import dao.generic.DAOGeneric;
import dao.generic.Field;
import dao.generic.Where;
import java.util.ArrayList;
import model.Empresa;

/**
 *
 * @author vovostudio
 */
public class DAOEmpresa extends DAOGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DAOEmpresa() throws Exception {
        super("empresas");
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
    public void add(Empresa empresa) throws Exception {
        insert(new Field[]{new Field("emp_nome", empresa.getNome())}, null);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public ArrayList<Empresa> retrieveAll() throws Exception {
        return cast(select(null, null, new Empresa()));
    }

    public Empresa retrieveById(int id) throws Exception {
        return (Empresa) retrieveById(id, "emp_id", new Empresa());
    }

    public ArrayList<Empresa> retrieveByField(String[] fieldsOnly, Where where) throws Exception {
        return cast(select(fieldsOnly, new Where[]{where}, new Empresa()));
    }

    public ArrayList<Empresa> retrieveByFields(String[] fieldsOnly, Where[] where) throws Exception {
        return cast(select(fieldsOnly, where, new Empresa()));
    }

    private ArrayList<Empresa> cast(ArrayList<Object> listObjects) {
        ArrayList<Empresa> ret = new ArrayList<>();
        for (Object obj : listObjects) {
            ret.add((Empresa) obj);
        }
        return ret;
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Empresa empresa) throws Exception {
        update(
                new Field[]{new Field("set_nome", empresa.getNome())},
                new Where[]{new Where("", "set_id", Comparer.EQUAL, empresa.getId())}
        );
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int id) throws Exception {
        delete(new Where[]{new Where("", "emp_id", Comparer.EQUAL, id)});
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
