package model;

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
    private Pessoa[] pessoas;
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
        pessoas = new Pessoa[tamanho];
    }

    public void inserir(Pessoa elemento) {
        if (estaCheia()) {
            throw new RuntimeException("Pilha cheia");
        }
        pessoas[++topo] = elemento;

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

    public Pessoa consultar() {
        return pessoas[topo];
    }

    public void esvaziarPilha() {
        topo = -1;
    }
}
