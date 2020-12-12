package listas.ex01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Lista lista = new Lista(5);
        int opcao = 0;

        do {

            menu();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    inserirProduto(lista);
                    bolha(lista);
                    break;
                case 2:
                    mostrarProduto(lista);
                    break;
                case 3:
                    retirarProduto(lista);
                    bolha(lista);
                    break;
                case 4:
                    alterarProduto(lista);
                    break;
                case 5:
                    lista.mostraLista();
                    break;
            }

        } while (opcao != 6);
    }

    public static void menu() {
        System.out.println("\n"
                + "[1] - Inserir produto\n"
                + "[2] - Buscar produto\n"
                + "[3] - Retirar produto\n"
                + "[4] - Alterar produto\n"
                + "[5] - Mostrar lista produtos\n"
                + "[6] - Encerrar\n");
    }

    public static void bolha(Lista lista) {
        int i, j;

        boolean troca = false;
        for (i = lista.listaTamanho() - 1; i > 0; i--) {
            troca = false;
            for (j = 0; j < i; j++) {
                if (lista.getPosicao(j).getCod() > lista.getPosicao(j + 1).getCod()) {
                    Produtos aux1 = lista.getPosicao(j);
                    Produtos aux2 = lista.getPosicao(j + 1);

                    lista.removePosicao(j);
                    lista.inserePosicao(j, aux2);

                    lista.removePosicao(j + 1);
                    lista.inserePosicao(j + 1, aux1);

                    troca = true;
                }
            }
            if (!troca) {
                return;
            }
        }
    }

    public static void inserirProduto(Lista lista) {

        Scanner sc = new Scanner(System.in);
        Produtos prod = new Produtos();

        System.out.print("\nInforme o código do produto: \n");
        prod.setCod(sc.nextInt());

        System.out.print("\nInforme a descrição do produto: \n");
        prod.setDesc(sc.next());

        System.out.print("\nInforme o preço do produto: \n");
        prod.setPreco(sc.nextFloat());

        lista.insereInicio(prod);
    }

    public static void alterarProduto(Lista lista) {
        Scanner sc = new Scanner(System.in);
        int cod;
        int posicao = -1;
        int i = 0;

        System.out.print("\nInforme o código do produto que deseja alterar: \n");
        cod = sc.nextInt();

        while (i < lista.listaTamanho() - 1 || posicao == -1) {
            if (lista.getPosicao(i).getCod() == cod) {
                posicao = i;
            }
            i++;
        }

        if (posicao == -1) {
            System.out.println("Código não encontrato");
        } else {
            Produtos prod = new Produtos();
            prod.setCod(cod);
            System.out.print("\nInforme a descrição do produto: \n");
            prod.setDesc(sc.next());
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
            System.out.println("Código não encontrato");
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
            if (lista.getPosicao(i).getCod() == cod) {
                posicao = i;
            }
            i++;
        }

        if (posicao == -1) {
            System.out.println("Código não encontrato");
        } else {
            System.out.println(lista.getPosicao(posicao));
        }
    }

}
