/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import classes.Lista;
import classes.Produto;
import java.util.Scanner;

/**
 *
 * @author vovolinux
 */
public class BllLista {

    public static void inserirProduto(Lista lista) {

        Scanner sc = new Scanner(System.in);
        Produto prod = new Produto();

        System.out.print("\nInforme o código do produto: ");
        prod.setCodigo(sc.nextInt());

        System.out.print("\nInforme a descrição do produto: ");
        prod.setDescricao(sc.next());

        System.out.print("\nInforme o preço do produto: ");
        prod.setPreco(sc.nextFloat());

        lista.insereInicio(prod);
    }

    public static void alterarProduto(Lista lista) {
        Scanner sc = new Scanner(System.in);
        int cod;
        int posicao = -1;
        int i = 0;

        System.out.print("\nInforme o código do produto que deseja alterar: ");
        cod = sc.nextInt();

        while (i < lista.listaTamanho() - 1 || posicao == -1) {
            if (lista.getPosicao(i) == cod) {
                posicao = i;
            }
            i++;
        }

        if (posicao == -1) {
            System.out.println("Código não encontrato");
        } else {
            Produto prod = new Produto();
            prod.setCodigo(cod);
            System.out.print("\nInforme a descrição do produto: \n");
            prod.setDescricao(sc.next());
            System.out.print("\nInforme o preço do produto: \n");
            prod.setPreco(sc.nextFloat());
            lista.removePosicao(posicao);
            lista.inserePosicao(posicao, prod);
        }
    }

    public static void retirarProduto(Lista lista) {
        Scanner sc = new Scanner(System.in);
        int cod;
        int posicao = -1;
        int i = 0;

        System.out.print("\nInforme o código do produto que deseja excluir: \n");
        cod = sc.nextInt();

        while (i < lista.listaTamanho() - 1 || posicao == -1) {
            if (lista.getPosicao(i).getCod() == cod) {
                posicao = i;
            }
            i++;
        }

        if (posicao == -1) {
            System.out.println("C�digo n�o encontrato");
        } else {
            lista.removePosicao(posicao);
        }
    }

    public static void mostrarProduto(Lista lista) {
        Scanner sc = new Scanner(System.in);
        int cod;
        int posicao = -1;
        int i = 0;

        System.out.print("\nInforme o código do produto que deseja visualizar: \n");
        cod = sc.nextInt();

        while (i < lista.listaTamanho() - 1 || posicao == -1) {
            Produto aux = (Produto) lista.getPosicao(i);
            if (aux.getCodigo() == cod) {
                posicao = i;
            }
            i++;
        }

        if (posicao == -1) {
            System.out.println("Código não encontrado");
        } else {
            System.out.println(lista.getPosicao(posicao));
        }
    }
}
