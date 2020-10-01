/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vovostudio
 */
public class Pilha {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int tamanho;
    private int[] array;
    private int topo = -1;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Pilha() {
        this(10); // Chama o construtor com um parâmetro da própria classe
    }

    public Pilha(int tamanho) {
        if (tamanho <= 0) {
            throw new RuntimeException("Tamanho inválido!");
        }

        this.tamanho = tamanho;
        array = new int[tamanho];
    }

    public void inserir(int elemento) {
        if (estaCheia()) {
            throw new RuntimeException("Pilha cheia");
        }
        array[++topo] = elemento;

        // ou
        // array[topo + 1] = elemento;
        // topo++;
    }

    public void retirar() {
        if (estaVazia()) {
            throw new RuntimeException("A pilha está vazia");
        }
        topo--;
    }

    public boolean estaVazia() {
        return (topo == -1);
    }

    public boolean estaCheia() {
        return (topo == (tamanho - 1));
    }

    public int quantidadeElementos() {
        return topo + 1;
    }

    public int consultar() {
        return array[topo];
    }

    public void esvaziarPilha() {
        topo = -1;
    }
}
/**
 * 9[ ] 8[ ] 7[ ] 6[ ] 5[ ] 4[ ] 3[X] 2[X] 1[X] 0[X] -1
 *
 *
 *
 *
 *
 *
 *
 *
 */
