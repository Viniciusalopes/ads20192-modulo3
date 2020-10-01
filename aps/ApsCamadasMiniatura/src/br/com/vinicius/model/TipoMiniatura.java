/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 28/09/2020 18:33:34 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Modelo de objeto para TipoMiniatura.
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.model;

/**
 *
 * @author vovostudio
 */
public class TipoMiniatura {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int tipo_id = 0;
    private String tipo_nome = "";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public TipoMiniatura() {

    }

    public TipoMiniatura(int tipo_id, String tipo_nome) {
        this.tipo_id = tipo_id;
        this.tipo_nome = tipo_nome;
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getTipoMiniatura_id() {
        return tipo_id;
    }

    public String getTipoMiniatura_nome() {
        return tipo_nome;
    }

    public static Object[] toArray(TipoMiniatura tipoMiniatura) {
        return new Object[]{
            tipoMiniatura.tipo_id,
            tipoMiniatura.tipo_nome
        };
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //

    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setTipoMiniatura_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }

    public void setTipoMiniatura_nome(String tipo_nome) {
        this.tipo_nome = tipo_nome;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
