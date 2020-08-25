/*
 * ------------------------------------------------------------------------------------------------>
 * Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 * Criado em  : 10/08/2020
 * Instituição: FACULDADE SENAI FATESG
 * Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 * Disciplina : Estrutura de Dados
 * Aluno      : Vinicius Araujo Lopes
 * Projeto    : EXERCÍCIOS PRIMEIRA AULA DE ESTRUTURA DE DADOS – VETORES
 * Exercício  : 3. Faça um programa de consulta de telefones a partir de um nome informado como uma 
 *   chave de dados. O programa deve:
 *   • Conter uma classe Pessoa com os atributos nome, telefone e e-mail;
 *   • Permitir a entrada de nomes de pessoas com seus respectivos telefones e e-mails, sendo a
 *   quantidade determinada pelo usuário, e armazená-los em um vetor de objetos pessoas;
 *   • Permitir ao usuário inserir qual o nome que ele deseja consultar o telefone. Após a consulta,
 *   exiba o telefone da pessoa procurada. Informe também se o nome é inexistente no vetor de
 *   pessoas.
 * -------------------------------------------------------------------------------------------------
 * Controle de Pessoas para persisistência em memória.
 * ------------------------------------------------------------------------------------------------| 
 */
package controladores;

import enumeradores.EnumErros;
import interfaces.IPessoa;
import modelos.Pessoa;

/**
 *
 * @author vovostudio
 */
public class ControlePessoa implements IPessoa {

    //--- ATRIBUTOS ----------------------------------------------------------->
    private Pessoa[] pessoas = null;
    private int utilizados = 0;

    //--- FIM ATRIBUTOS -------------------------------------------------------|
    //
    //--- CONSTRUTORES -------------------------------------------------------->
    public ControlePessoa() {

    }

    public ControlePessoa(int quantidadeDePessoas) throws Exception {
        if (quantidadeDePessoas <= 0) {
            throw new Exception(EnumErros.InformeUmNumeroInteiroPositivo.getMensagem());
        }
        pessoas = new Pessoa[quantidadeDePessoas];
    }

    //--- FIM CONSTRUTORES ----------------------------------------------------|
    //
    //--- CREATE -------------------------------------------------------------->
    @Override
    public void incluirPessoa(Pessoa pessoa) throws Exception {

        if (utilizados + 1 > pessoas.length) {
            throw new Exception(EnumErros.CapacidadeMaximaAlcancada.getMensagem());
        }

        if (pessoaJaExiste(pessoa.getNome())) {
            throw new Exception(EnumErros.JaExisteUmaPessoaComEsseNome.getMensagem());
        }

        pessoas[utilizados] = pessoa;
        utilizados++;
    }

    //--- END CREATE ----------------------------------------------------------|
    //
    //--- READ ---------------------------------------------------------------->
    @Override
    public Pessoa[] consultar() throws Exception {
        return pessoas;
    }

    @Override
    public Pessoa buscarPessoa(String nome) throws Exception {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                if (pessoa.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    return pessoa;
                }
            }
        }
        throw new Exception(EnumErros.NenhumaPessoaComEsseNome.getMensagem());
    }

    public boolean pessoaJaExiste(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                if (pessoa.getNome().equalsIgnoreCase(nome)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getCapacidade() {
        return pessoas.length;
    }

    public int getUtilizados() {
        return utilizados;
    }

    public int getDisponiveis() {
        return pessoas.length - utilizados;
    }
    //--- END READ-------------------------------------------------------------|

}
