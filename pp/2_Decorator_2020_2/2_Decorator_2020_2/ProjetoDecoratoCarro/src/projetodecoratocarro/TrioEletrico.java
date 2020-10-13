/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodecoratocarro;

/**
 *
 * @author eugenio
 */
public class TrioEletrico extends Acessorio {
    private Carro veiculo;
    public TrioEletrico(Carro veiculo){
        this.veiculo = veiculo;
    }
    public String getDescricao(){
        return veiculo.getDescricao() + ", Vidro e Trava Eletica";
    }
    public double preco(){
        return 1500 + veiculo.preco();
    }
}
