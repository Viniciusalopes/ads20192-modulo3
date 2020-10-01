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

import br.com.vinicius.model.Fabricante;
import br.com.vinicius.model.Miniatura;
import br.com.vinicius.model.Tema;
import br.com.vinicius.model.TipoMiniatura;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author vovostudio
 */
public class DalMiniatura extends DalGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private String sqlSelect = "SELECT * FROM " + table
            + "JOIN \"Fabricantes\" f ON m.miniatura_fabricante_id = f.fabricante_id "
            + "JOIN \"Temas\" t ON m.miniatura_tema_id = t.tema_id "
            + "JOIN \"TiposMiniaturas\" tm ON m.miniatura_tipo_id = tm.tipo_id ";

    private String fields
            = " (miniatura_modelo, "
            + "miniatura_ano, "
            + "miniatura_observacoes, "
            + "miniatura_edicao, "
            + "miniatura_escala, "
            + "miniatura_valor, "
            + "miniatura_fabricante_id, "
            + "miniatura_tipo_id, "
            + "miniatura_tema_id"
            + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public DalMiniatura() throws Exception {
        super("\"Miniaturas\"", "miniatura_id", "miniatura_modelo");
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //

    private Object[] getArgValues(Miniatura miniatura) {
        return new Object[]{
            miniatura.getModelo(),
            miniatura.getAno(),
            miniatura.getObservacoes(),
            miniatura.getEdicao(),
            miniatura.getEscala(),
            miniatura.getValor(),
            miniatura.getFabricante().getFabricante_id(),
            miniatura.getTipoMiniatura().getTipoMiniatura_id(),
            miniatura.getTema().getTema_id()
        };
    }

    private Object[] getArgValuesToUpdate(Miniatura miniatura) {
        Object[] args = getArgValues(miniatura);
        Object[] ret = new Object[args.length + 1];

        for (int i = 0; i < args.length; i++) {
            ret[i] = args[i];
        }
        ret[ret.length - 1] = miniatura.getMiniatura_id();
        return ret;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void add(Miniatura miniatura) throws Exception {
        sql = "INSERT INTO " + table + fields + ";";
        args = getArgValues(miniatura);
        execute(sql, args);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    @Override
    protected ArrayList<Miniatura> build(ResultSet rs) throws Exception {
        ArrayList<Miniatura> ret = new ArrayList<>();
        while (rs.next()) {
            ret.add(new Miniatura(
                    rs.getInt("miniatura_id"),
                    rs.getString("miniatura_modelo"),
                    rs.getString("miniatura_ano"),
                    rs.getString("miniatura_observacoes"),
                    rs.getString("miniatura_edicao"),
                    rs.getString("miniatura_escala"),
                    rs.getFloat("miniatura_valor"),
                    new Fabricante(rs.getInt("fabricante_id"), rs.getString("fabricante_nome")),
                    new TipoMiniatura(rs.getInt("tipo_id"), rs.getString("tipo_nome")),
                    new Tema(rs.getInt("tema_id"), rs.getString("tema_nome"))
            ));
        }

        Fabricante fab = (Fabricante) new DalFabricante().getAll().get(0);

        return ret;
    }

    public ArrayList<?> getAll() throws Exception {
        return getAll(sqlSelect);
    }

    public Miniatura getById(int id) throws Exception {
        return (Miniatura) getBy(fieldIdColumn, id, sqlSelect).get(0);
    }

    public boolean exists(int id) throws Exception {
        return exists(id, "miniatura_id");
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Miniatura miniatura) throws Exception {
        sql = "UPDATE " + table + " SET " + fields + "WHERE miniatura_id = ?;";
        args = getArgValuesToUpdate(miniatura);
        execute(sql, args);
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
}
