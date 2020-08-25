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
 * Enumerador para rótulos e labels de campos.
 * ------------------------------------------------------------------------------------------------| 
 */
package enumeradores;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vovostudio
 */
public enum EnumRotulos {
    //--- ATRIBUTOS ----------------------------------------------------------->
    Todos("Todos"),
    InformeQuantidadeCadastros("Informe a quantidade de cadastros: "),
    CampoNome("Nome"),
    CampoTelefone("Telefone"),
    CampoEmail("E-Mail");

    private String rotulo;

    private static Map<String, EnumRotulos> rotulos;

    //--- FIM ATRIBUTOS -------------------------------------------------------|
    //
    //--- CONSTRUTOR ----------------------------------------------------------->
    EnumRotulos(String rotulo) {
        this.rotulo = rotulo;
    }

    //--- FIM CONSTRUTOR -------------------------------------------------------|
    //
    //--- GET ----------------------------------------------------------->
    public String getRotulo() {
        return rotulo;
    }

    public static EnumRotulos getRotulo(String rotulo) {
        return rotulos.get(rotulo);
    }

    static {
        rotulos = new HashMap<String, EnumRotulos>();
        for (EnumRotulos value : values()) {
            rotulos.put(value.getRotulo(), value);
        }
    }
    //--- FIM GET -------------------------------------------------------|

}
