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
 * Validação de nomes.
 * ------------------------------------------------------------------------------------------------| 
 */
package utilidades;

import enumeradores.EnumErros;
import static utilidades.UtilString.soTemLetras;

/**
 *
 * @author vovostudio
 */
public class ValidaNome {

    public static boolean nomeValidoPessoa(String nome) throws Exception {
        nome = nome.trim();
        if (nome.length() == 0) {
            throw new Exception(EnumErros.InformeONome.getMensagem());
        }

        if (nome.length() < 2) {
            throw new Exception(EnumErros.NomeDeveTer2Letras.getMensagem());
        }

        if (!soTemLetras(nome)) {
            throw new Exception(EnumErros.NomeDeveTerLetrasEspacos.getMensagem());
        }
        return true;
    }
}
