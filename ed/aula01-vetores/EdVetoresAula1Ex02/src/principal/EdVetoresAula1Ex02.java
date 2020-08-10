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
 *   2. A Mega-Sena é uma loteria realizada pela Caixa Econômica Federal, que paga milhões para o
 * acertador dos 6 números sorteados. Os sorteios normalmente ocorrem às quartas e sábados. Faça um
 * programa em Java que gere seis números aleatórios e distintos entre 01 e 60, inclusive, para serem
 * “jogados” na Mega-Sena.
 * -------------------------------------------------------------------------------------------------
 */
package principal;

import java.util.Random;

/**
 *
 * @author Vinicius Araujo Lopes
 */
public class EdVetoresAula1Ex02 {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    private static int tamanhoVetor = 60;
    private static int maximo = 60;
    private static int numero = 0;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] vet = new int[tamanhoVetor];

        for (int i = 0; i < vet.length; i++) {
            // Sorteia um número sem repetir
            numero = new Random().nextInt(maximo) + 1;
            int j;

            for (j = 0; j < i && vet[j] != numero; j++) {
            }
            if (j == i) {
                // Não existe, Inclui o número no vetor
                vet[i] = numero;
            } else {
                // Já existe
                i--;
            }
        }

        // Saída
        String saida = "Números para jogar na Mega-Sena: ";
        for (int num : vet) {
            saida += String.format("%02d", num) + ", ";
        }
        saida = saida.substring(0, saida.length() - 2) + ".";
        System.out.println(saida);
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
