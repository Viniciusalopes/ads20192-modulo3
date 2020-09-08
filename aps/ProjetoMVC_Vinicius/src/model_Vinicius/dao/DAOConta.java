/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 07/09/2020 05:07:35 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : Projeto MVC - Sistema Bancário Simples
 *  Exercício  : https://www.devmedia.com.br/java-se-aprendendo-o-padrao-mvc/29546
 *  ------------------------------------------------------------------------------------------------
 *  Objeto de acesso a dados da Conta.
 *  -----------------------------------------------------------------------------------------------| 
 */
package model_Vinicius.dao;

import java.util.ArrayList;
import model_Vinicius.enums.EnumConstantes;
import model_Vinicius.classes.Conta;
import model_Vinicius.classes.ContaComum;
import model_Vinicius.classes.ContaEspecial;
import model_Vinicius.enums.EnumComparador;
import model_Vinicius.enums.EnumStatusConta;
import model_Vinicius.enums.EnumTipoDeConta;

/**
 *
 * @author vovostudio
 */
public class DAOConta extends DAOGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static DAOConta instance;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    private DAOConta() throws Exception {
        super("Conta");
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    //--- GET ------------------------------------------------------------------------------------->
    //
    public static DAOConta getInstance() throws Exception {
        if (instance == null) {
            instance = new DAOConta();
        }
        return instance;
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //

    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void create(int idCliente) throws Exception {
        this.create(EnumTipoDeConta.Comum.ordinal(), idCliente, 0);
    }

    public void create(int idCliente, double limite) throws Exception {
        this.create(EnumTipoDeConta.Especial.ordinal(), idCliente, limite);
    }

    private void create(int tipo, int idCliente, double limite) throws Exception {
        String sep = EnumConstantes.SeparadorSplit.getConstante();
        super.create(
                (getLastID(0) + 1)
                + sep + tipo
                + sep + idCliente
                + sep + "0.00"
                + sep + limite
                + sep + EnumStatusConta.Ativa.ordinal()
        );
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    @Override
    protected Object buildObject(String objetoToString) {
        Conta obj = null;

        String partes[] = objetoToString.split(EnumConstantes.SeparadorSplit.getConstante());
        int id = Integer.parseInt(partes[0]);
        int tipo = Integer.parseInt(partes[1]);
        int idCliente = Integer.parseInt(partes[2]);
        double saldo = Double.parseDouble(partes[3]);
        EnumStatusConta status = EnumStatusConta.values()[Integer.parseInt(partes[5])];

        switch (tipo) {
            case 0:
                obj = new ContaComum(id, idCliente, status);
                break;

            case 1:
                obj = new ContaEspecial(id, idCliente, Double.parseDouble(partes[4]), status);
        }

        if (obj != null) {
            obj.deposito(saldo);
        }
        return obj;
    }

    @Override
    protected boolean exists(Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Object> retrieveAll() throws Exception {
        return retrieveListOfObjects();
    }

    public ArrayList<Object> retrieveAllOthers(int id) throws Exception {
        return retrieveByField(id + "", 0, EnumComparador.Diferente);
    }

    public ArrayList<Object> retrieveByIdCliente(int idCliente) throws Exception {
        return retrieveByField(idCliente + "", 2, EnumComparador.Igual);
    }

    public Conta retrieveById(int id) throws Exception {
        return (Conta) retrieveById(id, 0);
    }

    public Conta retrieveLastId() throws Exception {
        return (Conta) retrieveLastId(0);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Conta conta) throws Exception {
        super.update(conta.getId(), 0, conta.toString());
    }

    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    public void delete(int id) throws Exception {
        super.delete(id, 0);
    }
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //

}
