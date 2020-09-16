/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodecoratocarro;
import projetodecoratocarro.Candidato;
/**
 *
 * @author eugeniojulio
 */
public class Habilidade3 extends Candidato{
    private Vaga veiculo;
    public Habilidade3(Vaga veiculo){
        this.veiculo = veiculo;
    }
    public String getDescricao(){
        return veiculo.getDescricao() + ", Kit Multimídia";
    }
    public double preco(){
        return 4500 + veiculo.preco();
    }
}
