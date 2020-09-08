/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import static utilidades.Util.nomeValido;

/**
 *
 * @author vovostudio
 */
public class Setor {

    private String nome = "";

    public Setor(String nome) throws Exception {
        if (nomeValido(nome)) {
            this.nome = nome;
        }
    }

    public String getNome() throws Exception {
        return nome;
    }
}
