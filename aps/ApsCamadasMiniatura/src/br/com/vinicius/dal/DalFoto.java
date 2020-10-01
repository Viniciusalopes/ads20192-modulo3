/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 29/09/2020 08:25:59 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Camada de acesso a dados da tabela [Temas]
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.dal;

import br.com.vinicius.model.Foto;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author vovostudio
 */
public class DalFoto extends DalGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private String fields
            = " (foto_caminho, "
            + "foto_descricao, "
            + "foto_miniatura_id"
            + ") VALUES (?, ?, ?, ?) ";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DalFoto() throws Exception {
        super("\"Fotos\"", "foto_id", "foto_id DESC");
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //

    private Object[] getArgValues(Foto foto) {
        return new Object[]{
            foto.getFoto_caminho(),
            foto.getFoto_descricao(),
            foto.getMiniatura().getMiniatura_id()
        };
    }

    private Object[] getArgValuesToUpdate(Foto foto) {
        Object[] args = getArgValues(foto);
        Object[] ret = new Object[args.length + 1];

        for (int i = 0; i < args.length; i++) {
            ret[i] = args[i];
        }
        ret[ret.length - 1] = foto.getFoto_id();
        return ret;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(Foto foto) throws Exception {
        sql = "INSERT INTO " + table + fields + ";";
        args = getArgValues(foto);
        execute(sql, args);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    @Override
    protected ArrayList<Foto> build(ResultSet rs) throws Exception {
        ArrayList<Foto> ret = new ArrayList<>();
        while (rs.next()) {
            ret.add(new Foto(
                    rs.getInt("foto_id"),
                    rs.getString("foto_caminho"),
                    rs.getString("foto_descricao"),
                    new DalMiniatura().getById(rs.getInt("foto_miniatura_id")
                    ))
            );

        }
        return ret;
    }

    public Foto getById(int id) throws Exception {
        return (Foto) getBy(fieldIdColumn, id).get(0);
    }

    public boolean exists(int id) throws Exception {
        return exists(id, "foto_id");
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Foto foto) throws Exception {
        sql = "UPDATE " + table + " SET " + fields + "WHERE miniatura_id = ?;";
        args = getArgValuesToUpdate(foto);
        execute(sql, args);
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
}
