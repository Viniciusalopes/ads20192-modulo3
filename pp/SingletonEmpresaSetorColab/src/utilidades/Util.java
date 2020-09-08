/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

/**
 *
 * @author vovostudio
 */
public class Util {

    private static String charsVogaisAcentuadas = "àâãáéêíòôõóúÀÂÂÁÉÊÍÒÔÕÓÚ";
    private static String charsLetras = "qwertyuiopasdfghjklçzxcvbnmQWERTYUIOPASDFGHJKLÇZXCVBNM " + charsVogaisAcentuadas;
    private static String charsNumeros = "0123456789";
    private static String charsTelefone = "()- " + charsNumeros;

    public static boolean nomeValido(String nome) throws Exception{
        nome = nome.trim();
        if (nome.length() == 0) {
            throw new Exception("Informe o nome!");
        }

        if (nome.length() < 2) {
            throw new Exception("O nome deve ter pelo menos duas letras!");
        }

        for (char c : nome.toCharArray()) {
            if (!charsLetras.contains(c + "")) {
                throw new Exception("O nome deve ter apenas letras e espaços!");
            }
        }
        return true;
    }
}
