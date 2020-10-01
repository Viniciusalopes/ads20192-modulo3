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

import br.com.vinicius.dal.DalMiniatura;
import static br.com.vinicius.bll.BllFactory.*;
import static br.com.vinicius.bll.BllGeneric.*;
import br.com.vinicius.model.Miniatura;
import java.lang.reflect.Method;
import javax.swing.JTable;

/**
 *
 * @author vovostudio
 */
public class BllMiniatura {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private DalMiniatura dal;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public BllMiniatura() throws Exception {
        this.dal = new DalMiniatura();
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
    public void validar(Miniatura miniatura) throws Exception {

        validarCampo(miniatura.getModelo(), "modelo");

        if (miniatura.getAno().trim().length() != 4) {
            throw new Exception("O ano deve ter 4 dígitos!");
        }

        String[] escala = miniatura.getEscala().split(":");
        int escalaUm = Integer.parseInt(escala[0]);
        int escalaPor = Integer.parseInt(escala[1]);
        if (escalaUm >= escalaPor) {
            throw new Exception("O primeiro valor da escala deve ser menor que o segundo!");
        }

        String[] fks = new String[]{"Fabricante", "Tema", "TipoMiniatura"};

        boolean bb = new BllFabricante().exists(miniatura.getFabricante().getFabricante_id());
        if(!bb)
        {
            throw new Exception("Fabricante inválido!");
        }

        if(!new BllTipoMiniatura().exists(miniatura.getTipoMiniatura().getTipoMiniatura_id()))
        {
            throw new Exception("Tipo de miniatura inválido inválido!");
        }
        
        validarCampo(miniatura.getFabricante().getFabricante_nome(), "nome do fabricante");
        validarCampo(miniatura.getTema().getTema_nome(), "nome do tema");
        validarCampo(miniatura.getTipoMiniatura().getTipoMiniatura_nome(), "nome do tipo de miniatura");
    }

    public void incluir(Miniatura miniatura) throws Exception {
        dal.add(miniatura);
    }
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
