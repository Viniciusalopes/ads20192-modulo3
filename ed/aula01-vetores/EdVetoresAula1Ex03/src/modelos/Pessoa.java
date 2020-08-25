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
 * Objeto Pessoa.
 * ------------------------------------------------------------------------------------------------| 
 */
package modelos;

import enumeradores.EnumErros;
import utilidades.ValidaEmail;
import utilidades.ValidaNome;
import utilidades.ValidaTelefone;

/**
 *
 * @author vovostudio
 */
public class Pessoa {

    //--- ATRIBUTOS ----------------------------------------------------------->
    private String nome = "";
    private String telefone = "";
    private String email = "";
    //--- FIM ATRIBUTOS -------------------------------------------------------|

    //--- CONSTRUTORES -------------------------------------------------------->
    public Pessoa() {

    }

    public Pessoa(Pessoa pessoa) throws Exception {
        setNome(pessoa.getNome());
        setTelefone(pessoa.getTelefone());
        setEmail(pessoa.getEmail());
    }

    public Pessoa(String nome, String telefone, String email) throws Exception {
        setNome(nome);
        setTelefone(telefone);
        setEmail(email.toLowerCase());
    }

    //--- FIM CONSTRUTORES ----------------------------------------------------|
    //
    //--- GET ----------------------------------------------------------------->
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s", nome, telefone, email);
    }

    //--- FIM GET -------------------------------------------------------------|
    //
    //--- SET ----------------------------------------------------------------->
    public void setNome(String nome) throws Exception {
        if (ValidaNome.nomeValidoPessoa(nome)) {
            this.nome = nome;
        }
    }

    public void setTelefone(String telefone) throws Exception {
        if (!ValidaTelefone.telefoneValido(telefone)) {
            throw new Exception(EnumErros.TelefoneInvalido.getMensagem());
        }
        this.telefone = telefone;
    }

    public void setEmail(String email) throws Exception {
        if (!ValidaEmail.isValidEmailAddressRegex(email)) {
            throw new Exception(EnumErros.EmailInvalido.getMensagem());
        }
        this.email = email;
    }
    //--- FIM SET -------------------------------------------------------------|
}
