/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 06/09/2020 22:48:37 
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
public class ContaEspecial extends Conta {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private double limite;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public ContaEspecial(int id, int idCliente, double limite, EnumStatusConta status) {
        super(id, idCliente, status);
        this.limite = limite;
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    //--- GET ------------------------------------------------------------------------------------->
    //
    public double getLimite() {
        return limite;
    }

    @Override
    public String toString() {
        String sep = EnumConstantes.SeparadorSplit.getConstante();
        return getId()
                + sep + EnumTipoDeConta.Especial.ordinal()
                + sep + getIdCliente()
                + sep + getSaldo()
                + sep + getLimite()
                + sep + getStatus().ordinal();
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setLimite(double limite) {
        this.limite = limite;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- OPERAÇÕES ------------------------------------------------------------------------------->
    //
    public boolean saque(double valor) {
        return ((valor > super.getSaldo() + limite)
                ? false
                : super.saque(valor));
    }
    //--- FIM OPERAÇÕES ---------------------------------------------------------------------------|
    //
}
