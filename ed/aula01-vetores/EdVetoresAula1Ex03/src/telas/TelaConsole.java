/*
 * ------------------------------------------------------------------------------------------------>
 * Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 * Criado em  : 10/08/2020
 * Instituição: FACULDADE SENAI FATESG
 * Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 * Disciplina : Estrutura de Dados
 * Aluno      : Vinicius Araujo Lopes
 * Projeto    : EXERCÍCIOS PRIMEIRA AULA DE ESTRUTURA DE DADOS – VETORES
 * Exercício  : 3. Faça um programa de consulta de telefones a partir de um nome informado como uma 
 *   chave de dados. O programa deve:
 *   • Conter uma classe Pessoa com os atributos nome, telefone e e-mail;
 *   • Permitir a entrada de nomes de pessoas com seus respectivos telefones e e-mails, sendo a
 *   quantidade determinada pelo usuário, e armazená-los em um vetor de objetos pessoas;
 *   • Permitir ao usuário inserir qual o nome que ele deseja consultar o telefone. Após a consulta,
 *   exiba o telefone da pessoa procurada. Informe também se o nome é inexistente no vetor de
 *   pessoas.
 * -------------------------------------------------------------------------------------------------
 * Tela para execução em modo console.
 * ------------------------------------------------------------------------------------------------| 
 */
package telas;

import controladores.ControlePessoa;
import enumeradores.EnumErros;
import enumeradores.EnumRotulos;
import enumeradores.EnumTitulos;
import java.util.Scanner;
import modelos.Pessoa;
import utilidades.UtilConsole;
import static utilidades.UtilConsole.menuDeOpcoes;
import static utilidades.UtilString.mascaraTelefone;

/**
 *
 * @author vovostudio
 */
public class TelaConsole {

    private static ControlePessoa controle;
    private static Scanner sc = new Scanner(System.in);

    public void main(String[] args) {
        try {
            int quantidade = 0;
            do {
                quantidade = menuQuantidade();
            } while (quantidade < 0);

            if (quantidade == 0) {
                System.exit(0);
            }
            controle = new ControlePessoa(quantidade);

            System.out.println("");
            String titulo = "MENU DE OPÇÕES";
            String[] opcoes = {"[1] Incluir ", "[2] Buscar", "[3] Listar", "[4] Uso da memória", "[0] Sair"};
            String pergunta = "Digite o número da opção: ";
            String mensagemErro = EnumErros.NaoEhUmaOpcao.getMensagem();
            int opcao = 0;

            do {
                opcao = menuDeOpcoes(titulo, opcoes, pergunta, mensagemErro, true);
                switch (opcao) {
                    case 1:
                        incluir();
                        break;

                    case 2:
                        buscar();
                        break;

                    case 3:
                        listar();
                        break;

                    case 4:
                        mostraUtilizacao();
                        break;
                }
                System.out.println("");
            } while (opcao != 0);

            System.exit(0);

        } catch (Exception e) {
            System.out.println(UtilConsole.mensagemComBorda("Epa!", new String[]{e.getMessage()}, '*', 1));
        }
    }

    private static int menuQuantidade() throws Exception {

        String titulo = EnumTitulos.TituloPrograma.getTitulo();
        return menuDeOpcoes(titulo, new String[1], "0 - Sair\n" + EnumRotulos.InformeQuantidadeCadastros.getRotulo(),
                EnumErros.InformeUmNumeroMaiorOuIgualA0.getMensagem(), false);
    }

    private static void incluir() throws Exception {
        boolean invalido = true;

        if (controle.getDisponiveis() == 0) {
            System.out.println(UtilConsole.mensagemComBorda("Vish!", new String[]{EnumErros.CapacidadeMaximaAlcancada.getMensagem()}, '*', 1));
            mostraUtilizacao();
            invalido = false;
            return;
        }

        Pessoa pessoa = new Pessoa();

        do {
            System.out.print("Digite o nome da pessoa: ");
            try {
                pessoa.setNome(sc.nextLine());
                if (controle.pessoaJaExiste(pessoa.getNome())) {
                    throw new Exception(EnumErros.JaExisteUmaPessoaComEsseNome.getMensagem());
                }

                invalido = false;

            } catch (Exception e) {
                System.out.println("\n" + UtilConsole.mensagemComBorda("Ops!", new String[]{e.getMessage()}, '*', 1));
                invalido = true;
            }
        } while (invalido);

        do {
            System.out.print("Digite o número do telefone: ");
            try {
                pessoa.setTelefone(sc.nextLine());
                invalido = false;
            } catch (Exception e) {
                System.out.println("\n" + UtilConsole.mensagemComBorda("Ops!", new String[]{e.getMessage()}, '*', 1));
                invalido = true;
            }

        } while (invalido);

        do {
            System.out.print("Digite o endereço de e-mail: ");

            try {
                pessoa.setEmail(sc.nextLine());
                invalido = false;
            } catch (Exception e) {
                System.out.println("\n" + UtilConsole.mensagemComBorda("Ops!", new String[]{e.getMessage()}, '*', 1));
                invalido = true;
            }
        } while (invalido);

        controle.incluirPessoa(pessoa);
    }

    private static void buscar() throws Exception {

        try {
            if (controle.getUtilizados() == 0) {
                System.out.println("\nNenhuma pessoa cadastrada!");
                mostraUtilizacao();
            } else {
                System.out.print("Digite o nome da pessoa: ");
                Pessoa pessoa = controle.buscarPessoa(sc.nextLine());
                
                System.out.println(UtilConsole.mensagemComBorda("Dados da pessoa",
                        new String[]{cadastroPessoa(pessoa)},
                        '.', 1)
                );
            }
        } catch (Exception e) {
            System.out.println(UtilConsole.mensagemComBorda("Wow!", new String[]{e.getMessage()}, '*', 1));
        }
    }

    private static void listar() throws Exception {
        try {
            int utilizados = controle.getUtilizados();
            if (utilizados == 0) {
                System.out.println("\nNenhuma pessoa cadastrada!");
            } else {
                Pessoa[] pessoas = controle.consultar();
                System.out.println("");

                String[] listaPessoas = new String[utilizados];
                for (int i = 0; i < utilizados; i++) {
                    if (pessoas[i] != null) {
                        listaPessoas[i] = cadastroPessoa(pessoas[i]);
                    }
                }
                System.out.println(UtilConsole.mensagemComBorda("Cadastros", listaPessoas, '.', 1));
            }
            mostraUtilizacao();
        } catch (Exception e) {
            System.out.println(UtilConsole.mensagemComBorda("Aff!", new String[]{e.getMessage()}, '*', 1));
        }
    }

    private static void mostraUtilizacao() {
        String[] utilizacao = new String[]{String.format("Capacidade: %d | Utilizados: %d | Disponíveis: %d",
            controle.getCapacidade(), controle.getUtilizados(), controle.getDisponiveis())};

        System.out.println("\n" + UtilConsole.mensagemComBorda("Uso da memória", utilizacao, '-', 1));
    }

    private static String cadastroPessoa(Pessoa pessoa) throws Exception {
        return String.format("Nome . . : %s\nTelefone : %s\nE-mail . : %s\n-\n",
                pessoa.getNome(),
                mascaraTelefone(pessoa.getTelefone()),
                pessoa.getEmail());
    }
}
