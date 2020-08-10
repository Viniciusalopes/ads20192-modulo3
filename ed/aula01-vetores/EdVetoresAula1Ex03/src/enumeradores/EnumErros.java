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
 * Enumerador para mensagens de erro.
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
package enumeradores;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vovostudio
 */
public enum EnumErros {

    //--- ATRIBUTOS ----------------------------------------------------------->
    Todos("Todos"),
    InformeUmNumeroMaiorOuIgualA0("Informe um número maior ou igual a 0!"),
    JaExisteUmaPessoaComEsseNome("Já existe uma pessoa cadastrada com este nome!"),
    InformeUmNumeroInteiroPositivo("Informe um número inteiro positivo!"),
    CapacidadeMaximaAlcancada("Não existe espaço disponível na memória!"),
    NenhumaPessoaComEsseNome("Nenhuma pessoa cadastrada com este nome!"),
    TelefoneInvalido("Informe um número de telefone válido!\n\n"
            + "Formato válidos:\n"
            + "9999-8888\n"
            + "9 8888-7777\n"
            + "(99) 8888-7777\n"
            + "(99) 8 7777-6666"),
    EmailInvalido("E-mail inválido!"),
    InformeONome("Informe o nome!"),
    NomeDeveTer2Letras("O nome deve ter pelo menos duas letras!"),
    NomeDeveTerLetrasEspacos("O nome deve ter apenas letras e espaços!"),
    NaoEhUmaOpcao("Essa não é uma opção...");

    private String mensagem;

    /**
     * Guarda as relacoes entre o tipo e o valor de um elemento da enum
     *
     * FONTE:
     * https://www.guj.com.br/t/enum-obter-o-valor-do-atributo-do-enum-atraves-do-metodos/109311/2
     */
    private static Map<String, EnumErros> mensagens;

    //--- FIM ATRIBUTOOS ------------------------------------------------------|
    //
    //--- CONSTRUTOR ---------------------------------------------------------->
    EnumErros(String mensagem) {
        this.mensagem = mensagem;
    }
    //--- FIM CONSTRUTOR ------------------------------------------------------|

    //--- GET ----------------------------------------------------------------->
    public String getMensagem() {
        return mensagem;
    }

    public static EnumErros getMensagem(String mensagem) {
        return mensagens.get(mensagem);
    }

    /**
     * Bloco estatico que popula o hashmap com as relacoes entre tipo e
     * elementos da enum
     */
    static {
        mensagens = new HashMap<String, EnumErros>();
        for (EnumErros value : values()) {
            mensagens.put(value.getMensagem(), value);
        }
    }

    //--- FIM GET -------------------------------------------------------------|
    //
}
