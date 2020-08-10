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
 * Objeto Pessoa.
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
package modelos;

import enumeradores.EnumErros;
import utilidades.ValidaEmail;
import utilidades.ValidaNome;
import utilidades.ValidaTelefone;

/**
 *
 * @author vovostudio
 */
public class Pessoa {

    //--- ATRIBUTOS ----------------------------------------------------------->
    private String nome = "";
    private String telefone = "";
    private String email = "";
    //--- FIM ATRIBUTOS -------------------------------------------------------|

    //--- CONSTRUTORES -------------------------------------------------------->
    public Pessoa() {

    }

    public Pessoa(Pessoa pessoa) throws Exception {
        setNome(pessoa.getNome());
        setTelefone(pessoa.getTelefone());
        setEmail(pessoa.getEmail());
    }

    public Pessoa(String nome, String telefone, String email) throws Exception {
        setNome(nome);
        setTelefone(telefone);
        setEmail(email.toLowerCase());
    }

    //--- FIM CONSTRUTORES ----------------------------------------------------|
    //
    //--- GET ----------------------------------------------------------------->
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s", nome, telefone, email);
    }

    //--- FIM GET -------------------------------------------------------------|
    //
    //--- SET ----------------------------------------------------------------->
    public void setNome(String nome) throws Exception {
        if (ValidaNome.nomeValidoPessoa(nome)) {
            this.nome = nome;
        }
    }

    public void setTelefone(String telefone) throws Exception {
        if (!ValidaTelefone.telefoneValido(telefone)) {
            throw new Exception(EnumErros.TelefoneInvalido.getMensagem());
        }
        this.telefone = telefone;
    }

    public void setEmail(String email) throws Exception {
        if (!ValidaEmail.isValidEmailAddressRegex(email)) {
            throw new Exception(EnumErros.EmailInvalido.getMensagem());
        }
        this.email = email;
    }
    //--- FIM SET -------------------------------------------------------------|
}
