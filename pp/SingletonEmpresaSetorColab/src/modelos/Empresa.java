/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author vovostudio
 */
public class Empresa {

    private Empresa empresa = null;
    private String nome = null;
    private ArrayList<Setor> setores = null;
    
    private Empresa(int quantidadeDeSetores) throws Exception {
        nome = "Couves e CIA";
        this.quantidadeDeSetores = quantidadeDeSetores;
        setores = new ArrayList<>();
    }

    public void addSetor(Setor setor) throws Exception {
        if(setores.size() == quantidadeDeSetores){
            throw new Exception("Chega de setor aqui");
        }
        if (setor == null) {
            throw new Exception("Sua mula!");
        }
        
        setores.add(setor);
    }

    public String getNome() {
        return nome;
    }

    public static Empresa getInstanciaEmpresa() throws Exception{
        if(empresa == null){
            
        }
        return empresa;
    }
}
