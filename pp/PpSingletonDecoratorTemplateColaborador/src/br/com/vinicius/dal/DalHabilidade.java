/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 10/10/2020 19:29:11 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Propósito do arquivo.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.vinicius.model.Habilidade;
import br.com.vinicius.model.HabilidadeOrigem;

/**
 *
 * @author vovostudio
 */
public class DalHabilidade extends br.com.vinicius.generic.dal.DalGeneric {

    public DalHabilidade() throws Exception {
        super("habilidades");
    }

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
    @Override
    protected ArrayList<?> build(ResultSet rs) throws Exception {
        ArrayList<Habilidade> ret = new ArrayList<>();
        while (rs.next()) {
            Habilidade hab = new Habilidade();
            hab.setId(rs.getInt("habilidade_id"));
            hab.setDescricao(rs.getString("habilidade_descricao"));
            hab.setOrigem(new HabilidadeOrigem(rs.getInt("origem_id"), rs.getString("origem_nome")));
            ret.add(hab);
        }
        return ret;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public ArrayList<Habilidade> getHabilidades() throws Exception {
        sql = "SELECT * FROM habilidades h "
                + "JOIN habilidades_origem ho ON h.habilidade_origem_id = ho.origem_id "
                + "ORDER BY origem_nome, habilidade_descricao ";
        args = new Object[]{};
        return (ArrayList<Habilidade>) select();
    }

    public ArrayList<Habilidade> getHabilidades(int colaborador_id) throws Exception {
        sql = "SELECT hc.habilidade_id, h.habilidade_descricao, ho.* FROM habilidades_colaborador hc "
                + "JOIN habilidades h ON hc.habilidade_id = h.habilidade_id "
                + "JOIN habilidades_origem ho ON h.habilidade_origem_id = ho.origem_id "
                + "WHERE hc.colaborador_id = ? "
                + "ORDER BY habilidade_descricao";
        args = new Object[]{colaborador_id};

        return ((ArrayList<Habilidade>) select());
    }
    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
