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
 * Utilidades para Vetores
 * Criação : Vovolinux
 * Data    : 10/08/2020
 * Projeto : EXERCÍCIOS PRIMEIRA AULA DE ESTRUTURA DE DADOS – VETORES
 *   3. Faça um programa de consulta de telefones a partir de um nome informado como uma chave de
 *   dados. O programa deve:
 *   • Conter uma classe Pessoa com os atributos nome, telefone e e-mail;
 *   • Permitir a entrada de nomes de pessoas com seus respectivos telefones e e-mails, sendo a
 *   quantidade determinada pelo usuário, e armazená-los em um vetor de objetos pessoas;
 *   • Permitir ao usuário inserir qual o nome que ele deseja consultar o telefone. Após a consulta,
 *   exiba o telefone da pessoa procurada. Informe também se o nome é inexistente no vetor de
 *   pessoas.
 * -------------------------------------------------------------------------------------------------
 */
package utilidades;

/**
 *
 * @author vovostudio
 */
public class UtilVetor {

    public static String[] redimensionarVetor(String[] vetor, int novoTamanho) {

        if (novoTamanho <= 0) {
            return new String[0];
        }

        if (vetor == null) {
            return new String[novoTamanho];
        } else {
            String[] retorno = new String[novoTamanho];
            for (int i = 0; i < vetor.length; i++) {
                if (vetor[i] != null) {
                    retorno[i] = vetor[i];
                }
            }
            return retorno;
        }
    }
   
   public static String[] unirVetores(String[] vetor1, String[] vetor2) {
        String[] retorno = new String[vetor1.length];
        retorno = redimensionarVetor(vetor1, (vetor1.length + vetor2.length));
        for (int i = 0; i < vetor2.length; i++) {
            if (vetor2[i] != null) {
                retorno[i + vetor1.length] = vetor2[i];
            }
        }
        return retorno;
    }

    public static String[] excluirLinhaVetor(String[] vetor, int posicao) {
        String[] retorno = new String[vetor.length - 1];
        int pos = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (i != posicao) {
                if (vetor[i] != null) {
                    retorno[pos] = vetor[i];
                }
                pos++;
            }
        }
        return retorno;
    }

    public static String[] splitLinhasDoVetor(String[] vetor) {
        String[] retorno = new String[0];

        for (int lin = 0; lin < vetor.length; lin++) {
            retorno = unirVetores(retorno,
                    ((vetor[lin].contains("\n"))
                    ? vetor[lin].split("\n")
                    : new String[]{vetor[lin]})
            );
        }
        
        return retorno;
    }
}
