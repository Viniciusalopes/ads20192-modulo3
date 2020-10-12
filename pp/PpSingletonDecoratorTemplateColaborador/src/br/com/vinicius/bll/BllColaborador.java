/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 11/10/2020 09:33:34 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Propósito do arquivo.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.bll;

import br.com.vinicius.dal.DalColaborador;
import static br.com.vinicius.generic.bll.BllGeneric.validarNome;
import java.util.ArrayList;
import br.com.vinicius.model.Colaborador;
import br.com.vinicius.model.Habilidade;

/**
 *
 * @author vovostudio
 */
public class BllColaborador {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
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
    public static void validate(Colaborador colaborador) throws Exception {
        validarNome(colaborador.getNome());
        if (colaborador.getSetor_id() <= 0) {
            throw new Exception("Selecione o setor do colaborador!");
        }
    }

    public static void add(Colaborador colaborador) throws Exception {
        validate(colaborador);
        new DalColaborador().add(colaborador);
    }

    public static void insertHabilidadesColaborador(ArrayList<Habilidade> habilidades, int colaborador_id) throws Exception {
        new DalColaborador().insertHabilidades(habilidades, colaborador_id);
    }
    //--- FIM CREATE ------------------------------------------------------------------------------|
    //

    //--- READ ------------------------------------------------------------------------------------>
    //
    public static Colaborador getColaborador(int colaborador_id) throws Exception {
        return new DalColaborador().getColaborador(colaborador_id);
    }

    public static ArrayList<Colaborador> getColaboradores(int setor_id) throws Exception {
        return new DalColaborador().getColaboradores(setor_id);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public static void update(Colaborador colaborador) throws Exception {
        validate(colaborador);
        new DalColaborador().update(colaborador);
    }

    public static void atualizaHabilidadesColaborador(
            int colaborador_id,
            ArrayList<Habilidade> listaHabilidades1,
            ArrayList<Habilidade> listaHabilidades2
    ) throws Exception {

        // Atualiza as habilidades do colaborador no banco
        deleteHabilidadesColaborador(colaborador_id);
        insertHabilidadesColaborador(listaHabilidades1, colaborador_id);
        insertHabilidadesColaborador(listaHabilidades2, colaborador_id);
    }
    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //

    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public static void deleteHabilidade(int habilidade_id, int colaborador_id) throws Exception{
        new DalColaborador().deleteHabilidade(habilidade_id, colaborador_id);
    }
    public static void deleteHabilidadesColaborador(int colaborador_id) throws Exception {
        new DalColaborador().deleteHabilidades(colaborador_id);
    }

    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
