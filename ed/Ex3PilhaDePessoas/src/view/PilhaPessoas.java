package view;

import java.util.Scanner;
import model.Pessoa;
import model.Pilha;

/*
 3. Desenvolva um programa que represente um Pilha de Pessoas. O programa deve permitir (MENU):
 1 - Empilhar um objeto Pessoa
 2 - Desempilhar um objeto Pessoa
 3 - Imprimir toda a pilha
 4 - Consultar/mostrar o objeto Pessoa do topo da pilha (sem remover)
 5 – Sair
Obs: Os atributos da classe Pessoa são: nome, endereço e telefone
 */
/**
 *
 * @author vovostudio
 */
public class PilhaPessoas {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static Scanner sc = new Scanner(System.in);
    private static Pessoa pessoa;
    private static int opcao = 0;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public static void main(String[] args) {

        Pilha pilha1 = new Pilha();
        pilha1.inserir(new Pessoa("A - José", "Avenida Qualquer coisa", "111111"));
        pilha1.inserir(new Pessoa("B - Maria", "Avenida Qualquer coisa", "11122221"));
        pilha1.inserir(new Pessoa("C - A frânio", "Avenida Qualquer coisa", "11444"));
        pilha1.inserir(new Pessoa("D - Epaminondas", "Avenida Qualquer coisa", "122233311111"));
        pilha1.inserir(new Pessoa("E - João", "Avenida Qualquer coisa", "2222222"));

        while (opcao != 5) {

            pessoa = new Pessoa();
            System.out.print("\n MENU\n"
                    + "------\n"
                    + " 1 - Empilhar um objeto Pessoa\n"
                    + " 2 - Desempilhar um objeto Pessoa\n"
                    + " 3 - Imprimir toda a pilha\n"
                    + " 4 - Consultar/mostrar o objeto Pessoa do topo da pilha (sem remover)\n"
                    + " 5 – Sair\n"
                    + "\n"
                    + "Digite uma opção do MENU: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    empilhar(pilha1);
                    break;

                case 2:
                    pilha1.retirar();
                    break;

                case 3:
                    imprimir(pilha1);
                    break;

                case 4:
                    System.out.println(pilha1.consultar());
                    break;

                case 6:
                    System.out.println("Pressione F6.");
                    break;

                default:
                    System.out.println("Essa não é uma opção...\n");
                    break;
            }
        }
    }

    private static void empilhar(Pilha pilha1) {

        System.out.print("Nome da pessoa: ");
        String nome = sc.nextLine();
        
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        pilha1.inserir(new Pessoa(nome, endereco, telefone));
        System.out.println("Pessoa inserida");
    }

    private static void imprimir(Pilha pilha1) {
        System.out.println("");
        
        Pilha outraPilha = new Pilha(pilha1.quantidadeElementos());

        while (!pilha1.estaVazia()) {
            Pessoa pessoa = pilha1.consultar();
            outraPilha.inserir(pessoa);
            System.out.println(pessoa);
            pilha1.retirar();
        }
        
        // recoloca de volta na pilha
        while (!outraPilha.estaVazia()) {
            pilha1.inserir(outraPilha.consultar());
            outraPilha.retirar();
        }
    }

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
