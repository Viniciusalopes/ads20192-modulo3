/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodecoratocarro;

/**
 *
 * @author eugenio
 */
public abstract class Vaga {

    String descricao = "Carro";

    public String getDescricao() {
        return descricao;
    }

    public abstract double preco();
}
