/*
 * 2- A mediana de um conjunto com um número ímpar de elementos é o valor central que se obtém após
 * ordenar o conjunto.
 * A Mediana de um conjunto com um número par de elementos é a média aritmética dos dois valores 
 * centrais que se obtém após ordenar o conjunto.
 * Por exemplo, para obter a mediana do conjunto de valores {1, 3, 4, 5, 4, 2, 6, 7}, considera-se o
 * conjunto ordenado {1, 2, 3, 4, 4, 5, 6, 7}; os dois valores centrais são 4 e 4, pelo que a 
 * mediana é 4.
 * Escreva um programa para achar e imprimir a mediana de um conjunto de valores inteiros
 * introduzidos pelo utilizador até um máximo de valores, possivelmente com valores repetidos,
 * a) usando o método de ordenação por shellSort;
 * b) modificando o método de ordenação bolha.
 */
package telas;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author vovostudio
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada;
        int indice = 0;
        int meio = 0;
        int[] vetor = new int[0];
        float mediana = 0;
        String opcoes = "rs";

        do {
            System.out.println("Vetor: " + Arrays.toString(vetor) + "\nTamanho: " + vetor.length);
            System.out.print("Digite [S] para sair, [R] para ordenar ou digite um número para incluir no vetor: ");

            entrada = sc.nextLine();
            if (!entrada.equalsIgnoreCase("s") && !entrada.equalsIgnoreCase("r")) {
                try {
                    vetor = incluirNumeroNoVetor(Integer.parseInt(entrada), vetor);

                } catch (Exception e) {
                    System.out.println("Erro: Número inválido ou opção inválida!\n" + e.getMessage() + "\n");
                    entrada = "";
                }
            }
        } while (!entrada.equalsIgnoreCase("r") && !entrada.equalsIgnoreCase("s"));

        if (entrada.equalsIgnoreCase("r")) {

            if (vetor.length == 0) {
                System.out.println("Nada para ordenar. O vetor está vazio!");
            } else {
                opcoes = "123";
                do {
                    System.out.println("\nOPÇÕES");
                    System.out.println("1 - Ordenação ShellSort"
                            + "\n2 - Ordenação Bolha"
                            + "\n3 - Sair"
                            + "\n\nDigite uma opção: ");
                    entrada = sc.nextLine();

                    if (entrada.equalsIgnoreCase("1")) {
                        ordena_shellSort(vetor);
                    } else if (entrada.equalsIgnoreCase("2")) {
                        bolhaMelhor(vetor);
                    } else if (!entrada.equalsIgnoreCase("3")) {
                        System.out.println("Erro: Essa não é uma opção.\n");
                        entrada = "";
                    }
                } while (!opcoes.contains(entrada.toLowerCase()));
            }
        }
        if (entrada.equalsIgnoreCase("s") || entrada.equalsIgnoreCase("3")) {
            System.out.println("Então tá.");
        } else {
            if (vetor.length > 0) {
                
                // CALCULA MEDIANA filha da dona VERIDIANA
                meio = vetor.length / 2;

                if ((vetor.length % 2) == 1) { // Se é impar
                    indice = meio;
                    mediana = vetor[indice];
                } else {
                    mediana = (float) ((vetor[meio] + vetor[meio - 1]) / 2f);
                }

                System.out.println("Vetor Ordenado: " + Arrays.toString(vetor));
                System.out.println("Mediana ......: " + mediana);

            }
        }
    }

    private static int[] incluirNumeroNoVetor(int numero, int[] vetor) {
        int[] ret = aumentaVetor(vetor);
        ret[ret.length - 1] = numero;
        return ret;
    }

    private static int[] aumentaVetor(int[] vetor) {
        int[] ret = new int[vetor.length + 1];
        for (int i = 0; i < vetor.length; i++) {
            ret[i] = vetor[i];
        }
        return ret;
    }

    private static void ordena_shellSort(int[] a) {
        int tmp;
        int qde = a.length;

        int j;
        for (int gap = qde / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < qde; i++) {
                tmp = a[i];
                // tmp.getNome().compareToIgnoreCase(a[j - gap].getNome())< 0); j -= gap) 
                // tmp                             < a[j - gap])              ; j -= gap) {
                for (j = i; j >= gap && (tmp < a[j - gap]); j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
    }

    public static void bolhaMelhor(int vet[]) {
        int i, j, aux;
        boolean troca = false;
        for (i = vet.length - 1; i > 0; i--) {
            // o maior valor entre vet[0] e vet[i] vai para a posição vet[i]
            troca = false;
            for (j = 0; j < i; j++) {
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                    troca = true;
                }
            }
            if (!troca) {
                return;
            }
        }
    }
}
