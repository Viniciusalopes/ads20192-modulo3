/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodecoratocarro;

/**
 *
 * @author eugeniojulio
 */
public class KitTurbo extends Acessorio{
    private Carro veiculo;
    public KitTurbo(Carro veiculo){
        this.veiculo = veiculo;
    }
    public String getDescricao(){
        return veiculo.getDescricao() + ", Kit Turbo 3000";
    }
    public double preco(){
        return 3500 + veiculo.preco();
    }
}
