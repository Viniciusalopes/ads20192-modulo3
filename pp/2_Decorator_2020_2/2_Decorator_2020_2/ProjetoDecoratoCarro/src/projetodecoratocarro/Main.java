/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projetodecoratocarro;

/**
 *
 * @author eugenio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vaga veiculo1 = new Programador();
        System.out.println("-------------------------------------------------");
        System.out.println("Carro:   "+ veiculo1.getDescricao());
        System.out.println("Preco:  " + veiculo1.preco());
        System.out.println("-------------------------------------------------");
        veiculo1 = new Habilidade3(veiculo1);
        System.out.println("Carro:   "+ veiculo1.getDescricao());
        System.out.println("Preco:  " + veiculo1.preco());
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
        veiculo1 = new Habilidade4(veiculo1);
        System.out.println("Carro:   "+ veiculo1.getDescricao());
        System.out.println("Preco:  " + veiculo1.preco());
        System.out.println("-------------------------------------------------");
        System.out.println();
        
        Vaga veiculo2 = new Analista();
        System.out.println("-------------------------------------------------");
        System.out.println("Carro:   "+ veiculo2.getDescricao());
        System.out.println("Preco:  " + veiculo2.preco());
        veiculo2 = new Habilidade1(veiculo2);
         System.out.println("-------------------------------------------------");
        System.out.println("Carro:   "+ veiculo2.getDescricao());
        System.out.println("Preco:  " + veiculo2.preco());
        veiculo2 = new Habilidade5(veiculo2);
         System.out.println("-------------------------------------------------");
        System.out.println("Carro:   "+ veiculo2.getDescricao());
        System.out.println("Preco:  " + veiculo2.preco());
        veiculo2 = new Habilidade2(veiculo2);
         System.out.println("-------------------------------------------------");
        System.out.println("Carro:   "+ veiculo2.getDescricao());
        System.out.println("Preco:  " + veiculo2.preco());
    }

}
