/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 07/09/2020 03:36:25 
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
package model_Vinicius.dao;

import java.util.ArrayList;
import model_Vinicius.classes.Cliente;
import model_Vinicius.enums.EnumComparador;
import model_Vinicius.enums.EnumConstantes;

/**
 *
 * @author vovostudio
 */
public class DAOCliente extends DAOGeneric {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static DAOCliente instance = null;
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    private DAOCliente() throws Exception {
        super("Cliente");
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    //--- GET ------------------------------------------------------------------------------------->
    //
    public static DAOCliente getInstance() throws Exception {
        if (instance == null) {
            instance = new DAOCliente();
        }
        return instance;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    public void create(String nome, String email) throws Exception {
        super.create(new Cliente((getLastID(0) + 1), nome, email).toString());
    }

    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    @Override
    public Object buildObject(String objetoToString) {
        Cliente obj = null;
        String partes[] = objetoToString.split(EnumConstantes.SeparadorSplit.getConstante());
        obj = new Cliente(Integer.parseInt(partes[0]), partes[1], partes[2]);
        return obj;
    }

    @Override
    public boolean exists(Object object) throws Exception {
        Cliente cliente = (Cliente) object;
        Cliente oCliente = null;
        ArrayList<Object> clientes = retrieveAll();
        for (Object obj : clientes) {
            oCliente = (Cliente) obj;
            if (oCliente.getNome().equalsIgnoreCase(cliente.getNome())
                    && oCliente.getEmail().equalsIgnoreCase(cliente.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Object> retrieveAll() throws Exception {
        return retrieveListOfObjects();
    }

    public ArrayList<Object> retrieveByField(String search, int indexField, EnumComparador comparacao) throws Exception {
        return super.retrieveByField(search, indexField, comparacao);
    }

    public ArrayList<Object> retrieveLikeNome(String nome) throws Exception {
        return retrieveByField(nome, 1, EnumComparador.Contem);
    }

    public Cliente retrieveById(int id) throws Exception {
        return (Cliente) retrieveById(id, 0);
    }

    public Cliente retrieveLastId() throws Exception {
        return (Cliente) retrieveLastId(0);
    }

    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    public void update(Cliente cliente) throws Exception {
        super.update(cliente.getId(), 0, cliente.toString());
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
