/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/09/2020 05:50:48 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Setor de uma Empresa.
 *  ------------------------------------------------------------------------------------------------| 
 */
package model;

import dao.generic.Field;
import java.util.ArrayList;
import util.EnumConstantes;

/**
 *
 * @author vovostudio
 */
public class Setor extends GenericObject {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static int idEmpresa;
    private ArrayList<Colaborador> colaboradores;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Setor() {
        this.colaboradores =  new ArrayList<>();
    }

    public Setor(int id, String nome, ArrayList<Colaborador> colaboradores, int idEmpresa) {
        this.id = id;
        this.nome = nome;
        Setor.idEmpresa = idEmpresa;
        this.colaboradores = (colaboradores == null) ? new ArrayList<>() : colaboradores;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    @Override
    public String toString() {
        return super.toString() + EnumConstantes.SeparadorSplit.getConstante() + idEmpresa;
    }

    public static Setor build(Object object) throws Exception {
        Object[] obj = (Object[]) object;
        Setor setor = new Setor();
        setor.setId(Integer.parseInt(Field.getValue("set_id", obj[0]).toString()));
        setor.setNome(Field.getValue("set_nome", obj[1]).toString());
        setor.setIdEmpresa(Integer.parseInt(Field.getValue("emp_id", obj[2]).toString()));
        return setor;
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //

    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setIdEmpresa(int idEmpresa) {
        Setor.idEmpresa = idEmpresa;
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
