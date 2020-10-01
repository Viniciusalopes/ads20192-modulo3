/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 12/09/2020 06:32:41 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Colaborador de um setor de uma empresa.
 *  ------------------------------------------------------------------------------------------------| 
 */
package model;

import control.ControlEmpresa;
import dao.generic.model.Field;
import util.EnumConstantes;

/**
 *
 * @author vovostudio
 */
public class Colaborador extends Pessoa {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private Setor setor = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Colaborador() {

    }

    public Colaborador(int id, String nome, Setor setor) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
    }

    public Colaborador(Pessoa pessoa, Setor setor) {
        id = pessoa.getId();
        nome = pessoa.getNome();
        this.setor = setor;
    }

    public Colaborador(Colaborador colaborador) {
        id = colaborador.getId();
        nome = colaborador.getNome();
        setor = colaborador.setor;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public Setor getSetor() {
        return setor;
    }

    @Override
    public String toString() {
        return super.toString() + EnumConstantes.SeparadorSplit.getConstante() + setor.getId();
    }

    public static Colaborador build(Object object) throws Exception {
        Object[] obj = (Object[]) object;
        Colaborador colaborador = new Colaborador();
        colaborador.setId(Integer.parseInt(Field.getValue("colaborador_id", obj[0]).toString()));
        colaborador.setNome(Field.getValue("colaborador_nome", obj[1]).toString());
        
        int idSetor = Integer.parseInt(Field.getValue("_colaborador_setor_id", obj[2]).toString());
        Setor setor = ControlEmpresa.getInstance().getSetor(idSetor);
        colaborador.setSetor(setor);
        
        return colaborador;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
}
