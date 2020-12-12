/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 13/10/2020 19:51:16 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Classe de acesso aos dados da tabela [fotos]
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import br.com.vinicius.generic.DalGeneric;
import br.com.vinicius.model.Foto;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public class DalFoto extends DalGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DalFoto() throws Exception {
        super("fotos");
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    //--- GET ------------------------------------------------------------------------------------->
    //
    @Override
    protected ArrayList<?> build(ResultSet rs) throws Exception {
        ArrayList<Foto> ret = new ArrayList<>();
        while (rs.next()) {
            Foto foto = new Foto();
            foto.setId(rs.getInt("foto_id"));
            foto.setCaminho(rs.getString("foto_caminho"));
            foto.setDescricao(rs.getString("foto_descricao"));
            foto.setMiniatura_id(rs.getInt("foto_miniatura_id"));
            ret.add(foto);
        }
        return ret;
    }

    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(Foto foto) throws Exception {
        sql = "INSERT INTO fotos (foto_caminho, foto_descricao, foto_miniatura_id) VALUES (?, ?, ?)";
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public boolean exists(Foto foto) throws Exception {
        sql = "SELECT * FROM fotos WHERE "
                + "foto_caminho = ? "
                + "AND foto_descricao = ? "
                + "AND foto_miniatura_id = ? "
                + "AND foto_id <> ? ";

        args = new Object[]{
            foto.getCaminho(),
            foto.getDescricao(),
            foto.getMiniatura_id(),
            foto.getId()
        };
        ResultSet rs = executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    public ArrayList<Foto> get() throws Exception {
        sql = "SELECT * FROM fotos";
        args = new Object[]{};
        return (ArrayList<Foto>) select();
    }

    public ArrayList<Foto> get(int miniatura_id) throws Exception {
        sql = "SELECT * FROM fotos WHERE foto_miniatura_id = ?";
        args = new Object[]{miniatura_id};
        return (ArrayList<Foto>) select();
    }

    public Foto get(int id, int miniatura_id) throws Exception {
        sql = "SELECT * FROM fotos WHERE foto_id = ? AND foto_miniatura_id = ?";
        args = new Object[]{id};
        return (Foto) select().get(0);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Foto foto) throws Exception {
        sql = "UPDATE fotos SET "
                + "foto_caminho = ?,"
                + "foto_descricao = ?,"
                + "foto_miniatura_id = ?"
                + "WHERE foto_id = ?";

        args = new Object[]{
            foto.getCaminho(),
            foto.getDescricao(),
            foto.getMiniatura_id(),
            foto.getId()
        };
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int id) throws Exception {
        sql = "DELETE FROM fotos WHERE foto_id = ?";
        args = new Object[]{id};
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
