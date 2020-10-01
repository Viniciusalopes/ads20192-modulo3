/*
 2- Crie uma Classe Aluno com os seguintes atributos: a) int Matricula; e b) float Nota;
Faça um método que, dado um valor inteiro N positivo, aloque um vetor de Aluno,
leia do teclado os N pares de valores (Matricula, Nota) e retorne o vetor alocado.
Imprima, ao final do programa, duas listas: (1) alunos ordenados por nota final e (2)
alunos ordenados por número de matrícula. Utilize algoritmos de ordenação vistos em
aula.
 */
package classes;

/**
 *
 * @author vovostudio
 */
public class Aluno {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private int matricula;
    private float nota;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public Aluno() {

    }

    public Aluno(int matricula, float nota) {
        this.matricula = matricula;
        this.nota = nota;
    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //

    //--- GET ------------------------------------------------------------------------------------->
    //
    public int getMatricula() {
        return matricula;
    }

    public float getNota() {
        return nota;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
