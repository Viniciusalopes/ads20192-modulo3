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
 * Programa principal.
 * Criação : Vovolinux
 * Data    : 10/08/2020
 * Projeto : EXERCÍCIOS PRIMEIRA AULA DE ESTRUTURA DE DADOS – VETORES
 *   1. Fazer um programa que leia e armazene em um vetor 16 números inteiros distintos. Em seguida,
 * determine e imprima o maior e segundo maior número armazenado neste vetor. Exemplo: dado o
 * vetor vet = {1,3,6,-4,10,20,15,100,-15,-45,200,300,490,17,18,380}. Então o maior é 490 e o segundo
 * maior é 380.
 * -------------------------------------------------------------------------------------------------
 */
package principal;

import java.util.Random;

/**
 *
 * @author Vinicius Araujo Lopes
 */
public class EdVetoresAula1Ex01 {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    private static int tamanhoVetor = 16;
    private static int maximo = 500;
    private static int numero = 0;
    private static int maior1 = 0;
    private static int maior2 = 0;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] vet = new int[tamanhoVetor];

        for (int i = 0; i < vet.length; i++) {

            // Sorteia um número sem repetir
            do {
                numero = new Random().nextInt(maximo);
            } while (jaExisteNoVetor(numero, vet));

            //Inclui o número no vetor
            vet[i] = numero;

            // Maior número
            maior1 = (numero > maior1) ? numero : maior1;
        }

        // Segundo maior número
        for (int num : vet) {
            maior2 = (num > maior2 && num < maior1) ? num : maior2;
        }

        // Saída
        String saida = "Dado o vetor vet = {";
        for (int num : vet) {
            saida += num + ", ";
        }
        saida = saida.substring(0, saida.length() - 2) + "}, então o maior é %d e o segundo maior é %d.\n";
        System.out.printf(saida, maior1, maior2);
    }

    /**
     * Verifica se um numero já existe no vetor.
     *
     * @param numero Número que será pesquisado no vetor.
     * @param vetor Vetor com números para procurar um número.
     * @return true: já existe, false: não existe.
     */
    private static boolean jaExisteNoVetor(int numero, int[] vetor) {
        for (int num : vetor) {
            if (num == numero) {
                return true;
            }
        }
        return false;
    }
}
