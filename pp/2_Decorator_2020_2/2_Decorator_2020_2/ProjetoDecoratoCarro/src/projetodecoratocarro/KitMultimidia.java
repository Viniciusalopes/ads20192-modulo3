/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodecoratocarro;
import projetodecoratocarro.Acessorio;
/**
 *
 * @author eugeniojulio
 */
public class KitMultimidia extends Acessorio{
    private Pessoa veiculo;
    public KitMultimidia(Pessoa veiculo){
        this.veiculo = veiculo;
    }
    public String getDescricao(){
        return veiculo.getDescricao() + ", Kit Multimídia";
    }
    public double preco(){
        return 4500 + veiculo.preco();
    }
}
