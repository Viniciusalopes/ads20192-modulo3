/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodecoratocarro;

/**
 *
 * @author eugenio
 */
public class Habilidade1 extends Candidato {

    private Vaga veiculo;
    public Habilidade1(Vaga veiculo){
        this.veiculo = veiculo;
    }
    public String getDescricao(){
        return veiculo.getDescricao() + ", Ar Condicionado";
    }
    public double preco(){
        return 2000 + veiculo.preco();
    }
}
