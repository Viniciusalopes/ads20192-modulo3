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

import static br.com.vinicius.generic.AppFactory.getSelectedId;
import br.com.vinicius.dal.DalMiniatura;
import static br.com.vinicius.generic.Factory.*;
import static br.com.vinicius.generic.BllGeneric.*;
import br.com.vinicius.model.Miniatura;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author vovostudio
 */
public abstract class BllMiniatura {

    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public static void validar(Miniatura miniatura) throws Exception {

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

        for (String fk : fks) {
            Object bll = getBll(fk);
            int id = (int) miniatura.getClass().getMethod("get" + fk).invoke(miniatura);

            // verifica se o cadastro da fk existe
            if (!(boolean) bll.getClass().getMethod("exists", int.class).invoke(bll, id)) {
                throw new Exception(fk.replace("TipoMiniatura", "Tipo de Miniatura") + " inválido!");
            }
        }

        validarCampo(miniatura.getFabricante().getFabricante_nome(), "nome do fabricante");
        validarCampo(miniatura.getTema().getTema_nome(), "nome do tema");
        validarCampo(miniatura.getTipoMiniatura().getTipoMiniatura_nome(), "nome do tipo de miniatura");
    }

    public static void incluir(Miniatura miniatura) throws Exception {
        new DalMiniatura().add(miniatura);
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    public static Miniatura getMiniaturaSelecionada(JTable jTable) throws Exception {
        return (Miniatura) getObjectByid(getSelectedId(jTable), "Miniatura");
    }

    public static ArrayList<Miniatura> getMiniaturas() throws Exception {
        return (ArrayList<Miniatura>) new DalMiniatura().getAll();
    }

    public static boolean existeRelacionamento() throws Exception {
        return new DalMiniatura().isEmptyTable();
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
