/**
 * Licença MIT Copyright(c) 2020 Viniciusalopes Tecnologia
 *
 * A permissão é concedida, gratuitamente, a qualquer pessoa que obtenha uma cópia deste software e
 * dos arquivos de documentação associados (o "Software"), para negociar no Software sem restrições,
 * incluindo, sem limitação, os direitos de uso, cópia, modificação, fusão, publicar, distribuir,
 * sublicenciar e/ou vender cópias do Software e permitir que as pessoas a quem o Software é
 * fornecido o façam, sob as seguintes condições:
 *
 * O aviso de direitos autorais acima e este aviso de permissão devem ser incluídos em todas as
 * cópias ou partes substanciais do Software.
 *
 * O SOFTWARE É FORNECIDO "TAL COMO ESTÁ", SEM GARANTIA DE QUALQUER TIPO, EXPRESSA OU IMPLÍCITA,
 * INCLUINDO MAS NÃO SE LIMITANDO A GARANTIAS DE COMERCIALIZAÇÃO, ADEQUAÇÃO A UMA FINALIDADE
 * ESPECÍFICA E NÃO INFRAÇÃO. EM NENHUM CASO OS AUTORES OU TITULARES DE DIREITOS AUTORAIS SERÃO
 * RESPONSÁVEIS POR QUALQUER REIVINDICAÇÃO, DANOS OU OUTRA RESPONSABILIDADE, SEJA EM AÇÃO DE
 * CONTRATO, TORT OU OUTRA FORMA, PROVENIENTE, FORA OU EM CONEXÃO COM O SOFTWARE OU O USO, OU OUTROS
 * ACORDOS NOS PROGRAMAS.
 * -------------------------------------------------------------------------------------------------
 * Programa principal, condicional simples.
 * Criação : Vovolinux
 * Data    : 10/08/2020
 * Projeto : EXERCÍCIOS PRIMEIRA AULA DE ESTRUTURA DE DADOS – VETORES
 *   4. Fazer um programa que receba 3 números inteiros quaisquer e os ordene na forma crescente. Fazer
 * duas soluções. Uma solução utilizando apenas estruturas condicionais simples e outra utilizando
 * estruturas condicionais aninhadas. Obs.: não utilizar vetor, utilizar apenas variáveis simples.
 * (Não utilizar vetor na solução)
 * -------------------------------------------------------------------------------------------------
 */
package principal;

import java.util.Scanner;

/**
 *
 * @author vovostudio
 */
public class EdVetoresAula1Ex04CondicSimples {

    static Scanner sc = new Scanner(System.in);
    static String entrada = "";
    static int num1 = 0;
    static int num2 = 0;
    static int num3 = 0;
    static int naux = 0;
    static boolean invalido = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int i = 1; i < 4; i++) {
            do {
                System.out.printf("Digite o %dº número: ", i);
                entrada = sc.nextLine();
                try {
                    naux = Integer.parseInt(entrada);
                    invalido = false;
                } catch (Exception e) {
                    invalido = true;
                    System.out.println("Número inválido!\n" + e.getMessage());
                }
            } while (invalido);

            if (i == 1) {
                num1 = naux;
            }
            if (i == 2) {
                num2 = naux;
            }
            if (i == 3) {
                num3 = naux;
            }
        }
//        num1 = 4;// 2 - 1 - 1
//        num2 = 2;// 4 - 4 - 2 
//        num3 = 1;// 1 - 2 - 4
//        
        if (num2 < num1) {
            naux = num1;
            num1 = num2;
            num2 = naux;
        }
        if (num3 < num1) {
            naux = num1;
            num1 = num3;
            num3 = naux;
        }
        if (num3 < num2) {
            naux = num2;
            num2 = num3;
            num3 = naux;
        }

        System.out.printf("Números em ordem crescente: %d, %d, %d.\n", num1, num2, num3);
    }
}