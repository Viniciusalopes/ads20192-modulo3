/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodecoratocarro;

/**
 *
 * @author eugenio
 */
public class DirecaoEletrica extends Acessorio {
    private Carro veiculo;
    public DirecaoEletrica(Carro veiculo){
        this.veiculo = veiculo;
    }
    public String getDescricao(){
        return veiculo.getDescricao() + ", Direcao Eletrica";
    }
    public double preco(){
        return 2500 + veiculo.preco();
    }
}
