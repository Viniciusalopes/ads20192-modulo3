/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 06/09/2020 22:34:06 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : Projeto MVC - Sistema Bancário Simples
 *  Exercício  : https://www.devmedia.com.br/java-se-aprendendo-o-padrao-mvc/29546
 *  ------------------------------------------------------------------------------------------------
 *  Modelo classe Conta
 *  -----------------------------------------------------------------------------------------------| 
 */
package model_Vinicius.classes;

import model_Vinicius.enums.EnumStatusConta;

/**
 *
 * @author vovostudio
 */
public abstract class Conta {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int id;
    private int idCliente;
    private double saldo;
    private EnumStatusConta status;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Conta(int id, int idCliente, EnumStatusConta status) {
        this.id = id;
        this.idCliente = idCliente;
        saldo = 0;
        this.status = status;
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public EnumStatusConta getStatus() {
        return status;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    public void setStatus(EnumStatusConta status) {
        this.status = status;
    }

    //--- SET ------------------------------------------------------------------------------------->
    //
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- OPERAÇÕES ------------------------------------------------------------------------------->
    //
    public void deposito(double valor) {
        saldo += valor;
    }

    public boolean saque(double valor) {
        saldo -= valor;
        return true;
    }
    //--- FIM OPERAÇÕES ---------------------------------------------------------------------------|
    //
}
