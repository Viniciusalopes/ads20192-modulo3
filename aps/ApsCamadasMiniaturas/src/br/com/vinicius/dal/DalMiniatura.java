/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 13/10/2020 07:53:02 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Acesso a dados da tabela [miniaturas].
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import br.com.vinicius.bll.BllFabricante;
import br.com.vinicius.bll.BllTema;
import br.com.vinicius.bll.BllTipoMiniatura;
import br.com.vinicius.generic.DalGeneric;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.vinicius.model.Miniatura;

/**
 *
 * @author vovostudio
 */
public class DalMiniatura extends DalGeneric {

    public DalMiniatura() throws Exception {
        super("miniaturas");
    }

    //--- GET ------------------------------------------------------------------------------------->
    //
    @Override
    protected ArrayList<?> build(ResultSet rs) throws Exception {
        ArrayList<Miniatura> ret = new ArrayList<>();
        while (rs.next()) {
            Miniatura miniatura = new Miniatura();
            miniatura.setId(rs.getInt("miniatura_id"));
            miniatura.setModelo(rs.getString("miniatura_modelo"));
            miniatura.setAno(rs.getInt("miniatura_ano"));
            miniatura.setObservacoes(rs.getString("miniatura_observacoes"));
            miniatura.setEdicao(rs.getString("miniatura_edicao"));
            miniatura.setEscala(rs.getString("miniatura_escala"));
            miniatura.setValor(rs.getFloat("miniatura_valor"));

            miniatura.setFabricante(BllFabricante.get(rs.getInt("miniatura_fabricante_id")));
            miniatura.setTipo(BllTipoMiniatura.get(rs.getInt("miniatura_tipo_id")));
            miniatura.setTema(BllTema.get(rs.getInt("miniatura_tema_id")));

            ret.add(miniatura);
        }
        return ret;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(Miniatura miniatura) throws Exception {
        sql = "INSERT INTO miniaturas ("
                + "miniatura_modelo, "
                + "miniatura_ano, "
                + "miniatura_observacoes, "
                + "miniatura_edicao, "
                + "miniatura_escala, "
                + "miniatura_valor, "
                + "miniatura_fabricante_id, "
                + "miniatura_tipo_id, "
                + "miniatura_tema_id "
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        args = new Object[]{
            miniatura.getModelo(),
            miniatura.getAno(),
            miniatura.getObservacoes(),
            miniatura.getEdicao(),
            miniatura.getEscala(),
            miniatura.getValor(),
            miniatura.getFabricante().getId(),
            miniatura.getTipoMiniatura().getId(),
            miniatura.getTema().getId()
        };
        execute();
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    public boolean exists(Miniatura miniatura) throws Exception {
        sql = "SELECT * FROM miniaturas WHERE "
                + "miniatura_id = ? "
                + "AND miniatura_modelo = ? "
                + "AND miniatura_ano = ? "
                + "AND miniatura_observacoes = ? "
                + "AND miniatura_edicao = ? "
                + "AND miniatura_escala = ? "
                + "AND miniatura_valor = ? "
                + "AND miniatura_fabricante_id = ? "
                + "AND miniatura_tipo_id = ? "
                + "AND miniatura_tema_id = ? ";

        args = new Object[]{miniatura.getId(),
            miniatura.getModelo(),
            miniatura.getAno(),
            miniatura.getObservacoes(),
            miniatura.getEdicao(),
            miniatura.getEscala(),
            miniatura.getValor(),
            miniatura.getFabricante().getId(),
            miniatura.getTipoMiniatura().getId(),
            miniatura.getTema().getId()
        };

        ResultSet rs = executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    //--- READ ------------------------------------------------------------------------------------>
    //
    public ArrayList<Miniatura> get() throws Exception {
        sql = "SELECT * FROM miniaturas";
        args = new Object[]{};
        return (ArrayList<Miniatura>) select();
    }

    public Miniatura get(int id) throws Exception {
        sql = "SELECT * FROM miniaturas WHERE miniatura_id = ? ";
        args = new Object[]{id};
        return (Miniatura) select().get(0);
    }

    public Miniatura get(String nome) throws Exception {
        sql = "SELECT * FROM miniaturas WHERE miniatura_nome = ?";
        args = new Object[]{nome};
        return (Miniatura) select().get(0);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Miniatura miniatura) throws Exception {
        sql = "UPDATE miniaturas SET "
                + "miniatura_modelo = ?, "
                + "miniatura_ano = ?, "
                + "miniatura_observacoes = ?, "
                + "miniatura_edicao = ?, "
                + "miniatura_escala = ?, "
                + "miniatura_valor = ?, "
                + "miniatura_fabricante_id = ?, "
                + "miniatura_tipo_id = ?, "
                + "miniatura_tema_id = ? "
                + " WHERE miniatura_id = ?";

        args = new Object[]{
            miniatura.getModelo(),
            miniatura.getAno(),
            miniatura.getObservacoes(),
            miniatura.getEdicao(),
            miniatura.getEscala(),
            miniatura.getValor(),
            miniatura.getFabricante().getId(),
            miniatura.getTipoMiniatura().getId(),
            miniatura.getId()
        };
        execute();
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int id) throws Exception {
        sql = "DELETE FROM miniaturas WHERE miniatura_id = ?";
        args = new Object[]{id};
        execute();
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
