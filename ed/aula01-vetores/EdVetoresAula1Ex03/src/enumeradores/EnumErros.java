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
 * Enumerador para mensagens de erro.
 * ------------------------------------------------------------------------------------------------| 
 */
package enumeradores;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vovostudio
 */
public enum EnumErros {

    //--- ATRIBUTOS ----------------------------------------------------------->
    Todos("Todos"),
    InformeUmNumeroMaiorOuIgualA0("Informe um número maior ou igual a 0!"),
    JaExisteUmaPessoaComEsseNome("Já existe uma pessoa cadastrada com este nome!"),
    InformeUmNumeroInteiroPositivo("Informe um número inteiro positivo!"),
    CapacidadeMaximaAlcancada("Não existe espaço disponível na memória!"),
    NenhumaPessoaComEsseNome("Nenhuma pessoa cadastrada com este nome!"),
    TelefoneInvalido("Informe um número de telefone válido!\n\n"
            + "Formato válidos:\n"
            + "9999-8888\n"
            + "9 8888-7777\n"
            + "(99) 8888-7777\n"
            + "(99) 8 7777-6666"),
    EmailInvalido("E-mail inválido!"),
    InformeONome("Informe o nome!"),
    NomeDeveTer2Letras("O nome deve ter pelo menos duas letras!"),
    NomeDeveTerLetrasEspacos("O nome deve ter apenas letras e espaços!"),
    NaoEhUmaOpcao("Essa não é uma opção...");

    private String mensagem;

    /**
     * Guarda as relacoes entre o tipo e o valor de um elemento da enum
     *
     * FONTE:
     * https://www.guj.com.br/t/enum-obter-o-valor-do-atributo-do-enum-atraves-do-metodos/109311/2
     */
    private static Map<String, EnumErros> mensagens;

    //--- FIM ATRIBUTOOS ------------------------------------------------------|
    //
    //--- CONSTRUTOR ---------------------------------------------------------->
    EnumErros(String mensagem) {
        this.mensagem = mensagem;
    }
    //--- FIM CONSTRUTOR ------------------------------------------------------|

    //--- GET ----------------------------------------------------------------->
    public String getMensagem() {
        return mensagem;
    }

    public static EnumErros getMensagem(String mensagem) {
        return mensagens.get(mensagem);
    }

    /**
     * Bloco estatico que popula o hashmap com as relacoes entre tipo e
     * elementos da enum
     */
    static {
        mensagens = new HashMap<String, EnumErros>();
        for (EnumErros value : values()) {
            mensagens.put(value.getMensagem(), value);
        }
    }

    //--- FIM GET -------------------------------------------------------------|
    //
}
