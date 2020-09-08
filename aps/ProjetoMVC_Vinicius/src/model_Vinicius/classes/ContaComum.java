/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 06/09/2020 22:43:29 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : Projeto MVC - Sistema Bancário Simples
 *  Exercício  : https://www.devmedia.com.br/java-se-aprendendo-o-padrao-mvc/29546
 *  ------------------------------------------------------------------------------------------------
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */
package model_Vinicius.classes;

import model_Vinicius.enums.EnumConstantes;
import model_Vinicius.enums.EnumStatusConta;
import model_Vinicius.enums.EnumTipoDeConta;

/**
 *
 * @author vovostudio
 */
public class ContaComum extends Conta {
    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public ContaComum(int id, int idCliente, EnumStatusConta status) {
        super(id, idCliente, status);
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    //--- GET ------------------------------------------------------------------------------------->
    //
    @Override
    public String toString() {
        String sep = EnumConstantes.SeparadorSplit.getConstante();
        return getId()
                + sep + EnumTipoDeConta.Comum.ordinal()
                + sep + getIdCliente()
                + sep + getSaldo()
                + sep + "0.00"
                + sep + getStatus().ordinal();
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- OPERAÇÕES ------------------------------------------------------------------------------->
    //
    @Override
    public boolean saque(double valor) {
        return ((valor > super.getSaldo())
                ? false
                : super.saque(valor));
    }
    //--- FIM OPERAÇÕES ---------------------------------------------------------------------------|
    //

}
