/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 10/10/2020 19:29:11 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Acesso a dados da tabela [habilidades].
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
    //--- READ ------------------------------------------------------------------------------------>
    //
    public Habilidade getHabilidade(int habilidade_id) throws Exception {
        sql = "SELECT * FROM habilidades h "
                + "JOIN habilidades_origem ho ON h.habilidade_origem_id = ho.origem_id "
                + "WHERE habilidade_id = ? "
                + "ORDER BY origem_nome, habilidade_descricao ";

        args = new Object[]{habilidade_id};
        return (Habilidade) select().get(0);
    }

    public Habilidade getHabilidade(String habilidade_descricao) throws Exception {
        sql = "SELECT * FROM habilidades h "
                + "JOIN habilidades_origem ho ON h.habilidade_origem_id = ho.origem_id "
                + "WHERE habilidade_descricao = ? "
                + "ORDER BY origem_nome, habilidade_descricao ";

        args = new Object[]{habilidade_descricao};
        return (Habilidade) select().get(0);
    }

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

        return (ArrayList<Habilidade>) select();
    }

    public ArrayList<Habilidade> getHabilidadesStack(int stack_id) throws Exception {
        if (stack_id == 0) {
            return new ArrayList<Habilidade>();
        }
        sql = "SELECT h.habilidade_id, o.origem_id, o.origem_nome, h.habilidade_descricao "
                + "FROM habilidades h "
                + "JOIN habilidades_origem o ON h.habilidade_origem_id = o.origem_id "
                + "JOIN habilidades_stack hs ON h.habilidade_id = hs.habilidade_id "
                + "JOIN stacks s ON hs.stack_id = s.stack_id "
                + "WHERE s.stack_id = ? "
                + "ORDER BY h.habilidade_descricao";
        args = new Object[]{stack_id};
        return (ArrayList<Habilidade>) select();
    }

    public ArrayList<Habilidade> getHabilidadesOrigem(int origem_id) throws Exception {
        sql = "SELECT * FROM habilidades h "
                + "JOIN habilidades_origem ho ON h.habilidade_origem_id = ho.origem_id "
                + "WHERE ho.origem_id = ? "
                + "ORDER BY ho.origem_nome, h.habilidade_descricao ";

        args = new Object[]{origem_id};
        return (ArrayList<Habilidade>) select();
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
}
