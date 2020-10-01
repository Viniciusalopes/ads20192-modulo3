/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 30/09/2020 21:56:31 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.bll;

import br.com.vinicius.dal.MiniaturaDal;
import static br.com.vinicius.bll.FactoryBll.getObjectByid;
import static br.com.vinicius.bll.FactoryBll.getSelectedId;
import javax.swing.JTable;

/**
 *
 * @author vovostudio
 */
public class MiniaturaBll {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private MiniaturaDal dal;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public MiniaturaBll() throws Exception {
        this.dal = new MiniaturaDal();
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    //--- GET ------------------------------------------------------------------------------------->
    //
    public Object getMiniaturaSelecionada(JTable jTable) throws Exception {
        return getObjectByid(getSelectedId(jTable), "Miniatura");
    }

    public String getDescricaoMiniatura(int miniatura_id) throws Exception {
        return "";
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
