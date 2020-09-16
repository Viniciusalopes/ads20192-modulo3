/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodecoratocarro;

/**
 *
 * @author eugenio
 */
public class Habilidade2 extends Candidato {
    private Vaga veiculo;
    public Habilidade2(Vaga veiculo){
        this.veiculo = veiculo;
    }
    public String getDescricao(){
        return veiculo.getDescricao() + ", Direcao Eletrica";
    }
    public double preco(){
        return 2500 + veiculo.preco();
    }
}
