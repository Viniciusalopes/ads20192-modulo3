/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 07/09/2020 10:25:18 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : Projeto MVC - Sistema Bancário Simples
 *  Exercício  : https://www.devmedia.com.br/java-se-aprendendo-o-padrao-mvc/29546
 *  -------------------------------------------------------------------------------------------------
 *  
 *  ------------------------------------------------------------------------------------------------| 
 */
package controller_Vinicius;

import java.util.ArrayList;
import model_Vinicius.classes.Conta;
import model_Vinicius.classes.ContaComum;
import model_Vinicius.classes.ContaEspecial;
import model_Vinicius.dao.DAOConta;
import model_Vinicius.enums.EnumStatusConta;
import model_Vinicius.enums.EnumTipoDeConta;

/**
 *
 * @author vovostudio
 */
public class ControlConta {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    // --- VALIDAÇÕES ----------------------------------------------------------------------------->
    //
    public static void validarContaSelecionada(int indice) throws Exception {
        if (indice < 0) {
            throw new Exception("Selecione uma conta!");
        }
    }

    public static void validarTipoDeConta(EnumTipoDeConta tipo) throws Exception {
        if (tipo == null) {
            throw new Exception("Selecione o tipo da conta (Comum / Especial)");
        }
    }

    public static void validarValorZero(double valor) throws Exception {
        if (valor <= 0) {
            throw new Exception("O valor deve ser maior que '0,00'!");
        }
    }

    public static void validarLimite(double limite) throws Exception {
        if (limite <= 0) {
            throw new Exception("O limite deve ser maior que '0,00'!");
        }
    }

    public static void validarDeposito(Conta conta, double valor) throws Exception {
        validarValorZero(valor);
        if (conta.getStatus().equals(EnumStatusConta.Encerrada)) {
            throw new Exception("Não é possível realizar depósitos em conta encerrada.");
        }
    }

    public static void validarSaque(Conta conta, double valor) throws Exception {
        validarValorZero(valor);
        if (conta.getStatus().equals(EnumStatusConta.Encerrada)) {
            throw new Exception("Não é possível realizar saques em conta encerrada.");
        }

    }

    public static void validarEncerrar(Conta conta) throws Exception {

        double saldo = conta.getSaldo();

        if (saldo > 0) {
            throw new Exception("Não é possível encerrar contas com saldo disponível!");
        }
        if (saldo < 0) {
            throw new Exception("Não é possível encerrar contas com saldo negativo!");
        }
    }

    public static void validarTransferencia(Conta origem, Conta destino, double valor) throws Exception {

    }

    public static void validarAddLimite(Conta conta, double valor) throws Exception {
        validarValorZero(valor);
    }

    public static void validarRemoveLimite(Conta conta, double valor) throws Exception {
        validarValorZero(valor);
        ContaEspecial ce = (ContaEspecial) conta;
        double saldo = ce.getSaldo();
        double limite = ce.getLimite();
        double maximo = (saldo < 0) ? (saldo * -1) : 0;

        if ((limite - valor) < maximo) {
            throw new Exception(
                    "Valor máximo para diminuir o limite: '"
                    + String.format("%.2f", (maximo == 0) ? maximo : (limite - maximo))
                    + "'!"
            );
        }
    }

    // --- FIM VALIDAÇÕES -------------------------------------------------------------------------| 
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public static ArrayList<Object> getAllContasByCliente(int idCliente) throws Exception {
        return DAOConta.getInstance().retrieveByIdCliente(idCliente);
    }

    public static ArrayList<Object> getAllOther(int idCliente) throws Exception {
        return DAOConta.getInstance().retrieveAllOthers(idCliente);
    }

    public static Object getContaById(int id) throws Exception {
        return DAOConta.getInstance().retrieveById(id);
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public static void addConta(int idCliente, double limite, EnumTipoDeConta tipo) throws Exception {

        validarTipoDeConta(tipo);
        if (tipo.equals(EnumTipoDeConta.Comum)) {
            addContaComum(idCliente);
        } else if (tipo.equals(EnumTipoDeConta.Especial)) {
            try {
                validarValorZero(limite);
            } catch (Exception e) {
                throw new Exception("O valor do limite deve ser maior que '0,00'!");
            }
            addContaEspecial(idCliente, limite);
        }
    }

    public static void addContaComum(int idCliente) throws Exception {
        DAOConta.getInstance().create(idCliente);
    }

    public static void addContaEspecial(int idCliente, double limite) throws Exception {
        DAOConta.getInstance().create(idCliente, limite);
    }

    public static void updateConta(Conta conta) throws Exception {
        DAOConta.getInstance().update(conta);
    }

    public static void depositar(int idConta, double valor) throws Exception {
        Conta conta = DAOConta.getInstance().retrieveById(idConta);
        validarDeposito(conta, valor);
        conta.deposito(valor);
        updateConta(conta);
    }

    public static void sacar(int idConta, double valor) throws Exception {
        Conta conta = DAOConta.getInstance().retrieveById(idConta);
        if (conta instanceof ContaComum) {
            conta = (ContaComum) DAOConta.getInstance().retrieveById(idConta);
        } else if (conta instanceof ContaEspecial) {
            conta = (ContaEspecial) DAOConta.getInstance().retrieveById(idConta);
        }
        validarSaque(conta, valor);

        if (conta.saque(valor)) {
            updateConta(conta);
        } else {
            throw new Exception("Saldo insuficiente!");
        }

    }

    public static void encerrar(int idConta) throws Exception {
        Conta conta = DAOConta.getInstance().retrieveById(idConta);
        validarEncerrar(conta);
        conta.setStatus(EnumStatusConta.Encerrada);
        updateConta(conta);
    }

    public static void reativar(int idConta) throws Exception {
        Conta conta = DAOConta.getInstance().retrieveById(idConta);
        conta.setStatus(EnumStatusConta.Ativa);
        updateConta(conta);
    }

    public static void transferir(int idConta, int idDestino, double valor) throws Exception {
        Conta origem = DAOConta.getInstance().retrieveById(idConta);
        Conta destino = DAOConta.getInstance().retrieveById(idDestino);

        if (origem.getStatus().equals(EnumStatusConta.Encerrada)) {
            throw new Exception("Não é possível realizar transferências a partir de uma conta encerrada.");
        }
        if (destino.getStatus().equals(EnumStatusConta.Encerrada)) {
            throw new Exception("Não é possível realizar transferências para uma conta encerrada.");
        }

        validarSaque(origem, valor);

        boolean saqueOK = origem.saque(valor);
        boolean depositoOK = false;

        try {
            if (saqueOK) {
                updateConta(origem);
                destino.deposito(valor);
                if (true) {
                    throw new Exception("Teste de erro na conta destino");
                }
                updateConta(destino);
                depositoOK = true;
            } else {
                throw new Exception("Ocorreu um erro ao realizar a transferência!\n"
                        + "Saldo insuficiente!");
            }
        } catch (Exception e) {
            if (saqueOK && !depositoOK) {
                origem.deposito(valor);
                updateConta(origem);
                throw new Exception("Ocorreu um erro ao realizar a transferência!\n" + e.getMessage());
            } else {
                throw e;
            }
        }
    }

    public static void addLimite(int idConta, double valor) throws Exception {
        ContaEspecial conta = (ContaEspecial) DAOConta.getInstance().retrieveById(idConta);
        validarAddLimite(conta, valor);
        conta.setLimite(conta.getLimite() + valor);
        updateConta(conta);
    }

    public static void removeLimite(int idConta, double valor) throws Exception {
        ContaEspecial conta = (ContaEspecial) DAOConta.getInstance().retrieveById(idConta);
        validarRemoveLimite(conta, valor);
        conta.setLimite(conta.getLimite() - valor);
        updateConta(conta);
    }
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
