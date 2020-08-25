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
 * Enumerador de caracteres.
 * ------------------------------------------------------------------------------------------------| 
 */
package enumeradores;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vovostudio
 *
 * FONTE:
 * https://www.guj.com.br/t/enum-obter-o-valor-do-atributo-do-enum-atraves-do-metodos/109311/2
 */
public enum EnumCaracteres {
    VogaisAcentuadas("àâãáéêíòôõóúÀÂÂÁÉÊÍÒÔÕÓÚ"),
    Letras("qwertyuiopasdfghjklçzxcvbnmQWERTYUIOPASDFGHJKLÇZXCVBNM" + VogaisAcentuadas.caracteres),
    Numeros("0123456789"),
    Email("@_-." + Numeros.caracteres + Letras.caracteres),
    Telefone("()- " + Numeros.caracteres),
    Editora(Letras.caracteres + Numeros.caracteres + Email.caracteres + "- "),
    EspeciaisLcase("'-=´[~]\\,.;/"),
    EspeciaisLcaseAltGr("¬¹²³£¢¬{[]}\\§/?°®ŧ←↓→øþ´ªæßðđŋħĸł´~º«»©“”µ─·̣̣°°"),
    EspeciaisUcase("\"!@#$%¨&*()_+`{^}|<>:?"),
    EspeciaisUcaseAltGr("¬¡½¾¼⅜¨⅞™±°¿˛/?°®Ŧ¥↑ıØÞ`¯Æ§ÐªŊĦ̛&Ł˝^º˘<>©‘’µ×÷¿"),
    Especiais(EspeciaisLcase.caracteres + EspeciaisLcaseAltGr.caracteres
            + EspeciaisUcase.caracteres + EspeciaisUcaseAltGr.caracteres),
    Todos(VogaisAcentuadas.caracteres
            + Letras.caracteres
            + Numeros.caracteres
            + Email.caracteres
            + Telefone.caracteres
            + Editora.caracteres
            + Especiais.caracteres
    );

    private String caracteres;

    //Guarda as relacoes entre o tipo e o valor de um elemento da enum
    private static Map<String, EnumCaracteres> relations;

    EnumCaracteres(String caracteres) {
        this.caracteres = caracteres;
    }

    public String getCaracteres() {
        return caracteres;
    }

    public static EnumCaracteres getCaracteres(String caracteres) {
        return relations.get(caracteres);
    }

    /**
     * Bloco estatico que popula o hashmap com as relacoes entre tipo e elementos da enum
     */
    static {
        relations = new HashMap<String, EnumCaracteres>();
        for (EnumCaracteres cadeia : values()) {
            relations.put(cadeia.getCaracteres(), cadeia);
        }
    }
}
