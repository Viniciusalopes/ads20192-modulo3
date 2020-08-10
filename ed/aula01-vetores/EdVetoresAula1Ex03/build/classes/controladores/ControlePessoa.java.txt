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
 * Controle de Pessoas para persisistência em memória.
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
package controladores;

import enumeradores.EnumErros;
import interfaces.IPessoa;
import modelos.Pessoa;

/**
 *
 * @author vovostudio
 */
public class ControlePessoa implements IPessoa {

    //--- ATRIBUTOS ----------------------------------------------------------->
    private Pessoa[] pessoas = null;
    private int utilizados = 0;

    //--- FIM ATRIBUTOS -------------------------------------------------------|
    //
    //--- CONSTRUTORES -------------------------------------------------------->
    public ControlePessoa() {

    }

    public ControlePessoa(int quantidadeDePessoas) throws Exception {
        if (quantidadeDePessoas <= 0) {
            throw new Exception(EnumErros.InformeUmNumeroInteiroPositivo.getMensagem());
        }
        pessoas = new Pessoa[quantidadeDePessoas];
    }

    //--- FIM CONSTRUTORES ----------------------------------------------------|
    //
    //--- CREATE -------------------------------------------------------------->
    @Override
    public void incluirPessoa(Pessoa pessoa) throws Exception {

        if (utilizados + 1 > pessoas.length) {
            throw new Exception(EnumErros.CapacidadeMaximaAlcancada.getMensagem());
        }

        if (pessoaJaExiste(pessoa.getNome())) {
            throw new Exception(EnumErros.JaExisteUmaPessoaComEsseNome.getMensagem());
        }

        pessoas[utilizados] = pessoa;
        utilizados++;
    }

    //--- END CREATE ----------------------------------------------------------|
    //
    //--- READ ---------------------------------------------------------------->
    @Override
    public Pessoa[] consultar() throws Exception {
        return pessoas;
    }

    @Override
    public Pessoa buscarPessoa(String nome) throws Exception {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                if (pessoa.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    return pessoa;
                }
            }
        }
        throw new Exception(EnumErros.NenhumaPessoaComEsseNome.getMensagem());
    }

    public boolean pessoaJaExiste(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                if (pessoa.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getCapacidade() {
        return pessoas.length;
    }

    public int getUtilizados() {
        return utilizados;
    }

    public int getDisponiveis() {
        return pessoas.length - utilizados;
    }
    //--- END READ-------------------------------------------------------------|

}
