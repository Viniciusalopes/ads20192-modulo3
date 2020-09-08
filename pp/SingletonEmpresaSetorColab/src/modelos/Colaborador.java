/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author vovostudio
 */
public class Colaborador {

    private String nome = "";
    private Setor setor = null;

    public Colaborador(String nome, Empresa empresa, Setor setor) {
        for (Setor setores : Empresa.getSetores()) {
            
        }
        
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
