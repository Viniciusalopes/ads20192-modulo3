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
 * Enumerador para títulos de telas.
 * ------------------------------------------------------------------------------------------------| 
 */
package enumeradores;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vovostudio
 */
public enum EnumTitulos {
    //--- ATRIBUTOS ----------------------------------------------------------->
    Todos("Todos"),
    TituloPrograma("CONSULTA DE TELEFONES"),
    TituloCadastroPessoas("Cadastro de Pessoas"),
    TituloIncluirPessoa("Incluir cadastro de Pessoa");

    private String titulo;

    private static Map<String, EnumTitulos> titulos;

    //--- FIM ATRIBUTOS -------------------------------------------------------|
    //
    //--- CONSTRUTOR ----------------------------------------------------------->
    EnumTitulos(String titulo) {
        this.titulo = titulo;
    }

    //--- FIM CONSTRUTOR -------------------------------------------------------|
    //
    //--- GET ----------------------------------------------------------->
    public String getTitulo() {
        return titulo;
    }

    public static EnumTitulos getTitulo(String titulo) {
        return titulos.get(titulo);
    }

    static {
        titulos = new HashMap<String, EnumTitulos>();
        for (EnumTitulos value : values()) {
            titulos.put(value.getTitulo(), value);
        }
    }
    //--- FIM GET -------------------------------------------------------|
}
