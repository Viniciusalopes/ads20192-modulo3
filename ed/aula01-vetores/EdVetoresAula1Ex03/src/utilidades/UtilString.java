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
 * Utilidades para Strings.
 * ------------------------------------------------------------------------------------------------| 
 */
package utilidades;

import enumeradores.EnumCaracteres;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author vovostudio
 */
public class UtilString {

    public static boolean digitouTexto(char caractere) {
        return (EnumCaracteres.Todos.getCaracteres().contains(caractere + ""));
    }

    public static boolean soTemLetras(String texto) {
        for (char c : texto.toCharArray()) {
            if (!EnumCaracteres.Letras.getCaracteres().contains(c + "")
                    && !(c + "").equals(" ")) {
                return false;
            }
        }
        return true;
    }

    public static String textoSoComNumeros(String texto) {
        String ret = "";
        for (char c : texto.toCharArray()) {
            if (EnumCaracteres.Numeros.getCaracteres().contains(c + "")) {
                ret += c + "";
            }
        }
        return ret;

    }

    public static boolean soTemNumeros(String texto) {
        for (char c : texto.toCharArray()) {
            if (!EnumCaracteres.Numeros.getCaracteres().contains(c + "")) {
                return false;
            }
        }
        return true;
    }

    public static boolean soTemNumerosEletras(String texto) {
        for (char c : texto.toCharArray()) {
            if (!EnumCaracteres.Numeros.getCaracteres().contains(c + "")
                    && !EnumCaracteres.Letras.getCaracteres().contains(c + "")
                    && !(c + "").equals(" ")) {
                return false;
            }
        }
        return true;
    }

    public static boolean telefoneValido(String texto) {
        for (char c : texto.toCharArray()) {
            if (!EnumCaracteres.Telefone.getCaracteres().contains(c + "")) {
                return false;
            }
        }
        // Tamanho mínimo do telefone somente com os números = 8
        if (textoSoComNumeros(texto).length() < 8) {
            return false;
        }

        return true;
    }

    public static boolean nomeValido(String texto) {
        for (char c : texto.toCharArray()) {
            if (!EnumCaracteres.Editora.getCaracteres().contains(c + "")) {
                return false;
            }
        }
        return true;
    }

    public static boolean tamanhoEntre(String texto, int minimo, int maximo) {
        return (texto.trim().length() >= minimo && texto.trim().length() <= maximo);
    }

    public static String mascaraTelefone(String numeros) throws Exception {
        try {
            numeros = textoSoComNumeros(numeros);
            switch (numeros.length()) {
                case 8:
                    return String.format("%s-%s", numeros.substring(0, 4), numeros.substring(4, 8));
                case 9:
                    return String.format("%s %s-%s", numeros.substring(0, 1), numeros.substring(1, 5), numeros.substring(5, 9));
                case 10:
                    return String.format("(%s) %s-%s", numeros.substring(0, 2), numeros.substring(2, 6), numeros.substring(6, 10));
                case 11:
                    if (numeros.substring(0, 4).equals("0800")) {
                        return numeros.substring(0, 4) + " " + numeros.substring(4, 7) + "-" + numeros.substring(7, 11);
                    } else {
                        return "(" + numeros.substring(0, 2) + ") " + numeros.substring(2, 3) + " " + numeros.substring(3, 8) + "-" + numeros.substring(7, 11);
                    }
                default:
                    break;
            }
            return numeros;

        } catch (Exception e) {
            throw e;
        }
    }

    // FONTE: https://www.guj.com.br/t/classe-pronta-mascara-do-jformattedtextfield-para-telefones/335186
    public static void mudaMascaraTelefone(JFormattedTextField campoTelefone) throws Exception {
        try {
            campoTelefone.setValue(null);
            String numeros = textoSoComNumeros(campoTelefone.getText().trim());
            final MaskFormatter mask = new MaskFormatter();
            switch (numeros.length()) {
                case 8:
                    mask.setMask("####-####");
                    campoTelefone.setFormatterFactory(new DefaultFormatterFactory(mask));
                    break;
                case 9:
                    mask.setMask("# ####-####");
                    campoTelefone.setFormatterFactory(new DefaultFormatterFactory(mask));
                    break;
                case 10:
                    mask.setMask("(##) ####-####");
                    campoTelefone.setFormatterFactory(new DefaultFormatterFactory(mask));
                    break;
                case 11:
                    String comDDD = "(" + numeros.substring(0, 2) + ") " + numeros.substring(2, 3) + " " + numeros.substring(3, 7) + "-" + numeros.substring(7, 11);
                    String com0800 = numeros.substring(0, 4) + " " + numeros.substring(4, 7) + "-" + numeros.substring(7, 11);

                    // Ababandona o evento se já estiver no formato esperado
                    if (campoTelefone.getText().trim().equals(comDDD) || campoTelefone.equals(com0800)) {
                        return;
                    }
                    if (new MensagensDialog().escolher("Selecione um formato para o número do telefone:", new String[]{comDDD, com0800}) == 0) {
                        mask.setMask("(##) # ####-####");
                        campoTelefone.setFormatterFactory(new DefaultFormatterFactory(mask));
                    } else {
                        mask.setMask("#### ###-####");
                        campoTelefone.setFormatterFactory(new DefaultFormatterFactory(mask));
                    }
                    break;
                default:
                    campoTelefone.setFormatterFactory(null);
                    break;
            }
            campoTelefone.setText(numeros);
        } catch (Exception e) {
            throw e;
        }
    }

    public static String barra() {
        return (System.getProperty("os.name").toLowerCase().contains("windows") ? "\\" : "/");
    }

    public static String truncar(String texto, int posicoes) {
        if (texto.length() > 40) {
            return texto.substring(0, 40) + "...";
        }
        return texto;
    }
}
