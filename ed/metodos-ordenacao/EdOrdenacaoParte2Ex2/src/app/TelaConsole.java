/*
 2- Crie uma Classe Aluno com os seguintes atributos: a) int Matricula; e b) float Nota;
Faça um método que, dado um valor inteiro N positivo, aloque um vetor de Aluno,
leia do teclado os N pares de valores (Matricula, Nota) e retorne o vetor alocado.
Imprima, ao final do programa, duas listas: (1) alunos ordenados por nota final e (2)
alunos ordenados por número de matrícula. Utilize algoritmos de ordenação vistos em
aula.
 */
package app;

import classes.Aluno;
import java.util.Scanner;

/**
 *
 * @author vovostudio
 */
public class TelaConsole {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static Aluno[] alunos;
    private static Scanner sc;
    private static String entrada;
    private static int quantidade;
    private static boolean invalido;
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //

    public static void main(String[] args) {
        invalido = true;
        
        sc = new Scanner(System.in);

        System.out.println("Digite a quantidade de alunos ou 'X' para encerrar");
        entrada = sc.nextLine();

        while (!entrada.equalsIgnoreCase("x") ) {
            System.out.println("Digite a quantidade de alunos ou 'X' para encerrar");
            entrada = sc.nextLine();
            
            try {
                quantidade = Integer.parseInt(entrada);
            } catch (Exception e) {
                System.out.println("Quantidade inválida!\n" + e.getMessage() + "\n");
            }
            invalido = false;
            alunos = new Aluno[quantidade];
            
            
        }
    }

    private static shellSort(Aluno[] alunos, String ordem){
         // Ordenação ShellSort
        Aluno tmp;
        int qde = alunos.length;
        
        if(ordem.equalsIgnoreCase("matricula")){
            
        }
        int j;
        for (int gap = qde / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < qde; i++) {
                tmp = alunos[i];
                if(ordem.equalsIgnoreCase("matricula")){
                    for (j = i; j >= gap && (tmp.getMatricula() < alunos[j - gap].getMatricula()); j -= gap){
                        alunos[j] = alunos[j - gap];
                    }
                }else{
                    for(j = i; j >=gap &&() < 0; j -= gap){
                        
                    }
                }
                tmp.getMatricula().compareToIgnoreCase(alunos[j - gap].getMatricula())< 0); j -= gap) 
                // tmp                             < a[j - gap])              ; j -= gap) {
                for (j = i; j >= gap && (tmp < alunos[j - gap]); j -= gap) {
                    
                }
                alunos[j] = tmp;
            }
        }
    }
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
    //--- CREATE ---------------------------------------------------------------------------------->
    //
    //--- FIM CREATE ------------------------------------------------------------------------------|
    //
    //--- READ ------------------------------------------------------------------------------------>
    //
    //--- FIM READ --------------------------------------------------------------------------------|
    //
    //--- UPDATE ---------------------------------------------------------------------------------->
    //
    //--- FIM UPDATE ------------------------------------------------------------------------------|
    //
    //--- DELETE ---------------------------------------------------------------------------------->
    //
    //--- FIM DELETE ------------------------------------------------------------------------------|
    //
}
