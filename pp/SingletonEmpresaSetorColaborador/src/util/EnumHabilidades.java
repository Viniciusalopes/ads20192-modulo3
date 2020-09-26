/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 13/09/2020 11:07:45 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Enumerador para habilidades de pessoas.
 *  ------------------------------------------------------------------------------------------------| 
 */
package util;

import java.util.HashMap;
import java.util.Map;
import static util.EnumHabilidades.values;

/**
 *
 * @author vovostudio
 */
public enum EnumHabilidades {
    Analisar("Analisar"),
    BeberCafe("Beber café"),
    Cochilar("Cochilar"),
    Comer("Comer"),
    Estudar("Estudar"),
    Desenhar("Desenhar"),
    Dormir("Dormir"),
    Lecionar("Lecionar"),
    Pesquisar("Pesquisar"), // 9
    Angular("Angular"),
    ArquiteturaDeSoftware("Arquitetura de Software"),
    CriarBugs("Criar bugs"),
    CSharp("C#"),
    CSS("CSS 3"),
    GestaoDePessoas("Gestão de Pessoas"),
    GestaoDeProjetos("Gestão de Projetos"),
    HTML("HTML 5"),
    IdentificarBugs("Identificar bugs"),
    Java("Java"),
    JavaScript("JavaScript"),
    MySql("MySql"),
    Oracle("Oracle DataBases"),
    Php("Php"),
    Planejamento("Planejamento"),
    POO("POO"),
    PostgreSQL("PostgreSQL"),
    PowerBI("Power BI"),
    PP("Padrões de Projetos"),
    Programar("Programar"),
    Python("Python"),
    ReactJs("ReactJs"),
    ShellScript("ShellScript"),
    SpringBoot("Spring Boot"), // 24
    TabelaoExcel("Tabelão de Excel"),
    ColorirDeRoxo("Colorir de Roxo"),
    DormirNaAula("Dormir na aula e continuar conectado"),
    FalarComMicMutado("Falar com o microfone mutado"),
    FalarLongeDoMic("Falar longe do microfone"),
    InsistirNoDebian("Insistir em usar Debian"),
    InventarModa("Inventar moda e complicar o que é fácil"),
    InterromperAula("Interromper a aula"),
    PerguntarDaChamada("Perguntar se já fez chamada"),
    SairMaisCedo("Sair mais cedo"),
    SemearDiscordia("Semear a discórdia"),
    UsarFoneOuvidoLonge("Usar fones de ouvido longe da orelha");

    private String nome;

    /**
     * Guarda as relacoes entre o tipo e o valor de um elemento da enum
     *
     * FONTE:
     * https://www.guj.com.br/t/enum-obter-o-valor-do-atributo-do-enum-atraves-do-metodos/109311/2
     */
    private static Map<String, EnumHabilidades> relations;

    /**
     * Bloco estatico que popula o hashmap com as relacoes entre tipo e elementos da enum
     */
    static {
        relations = new HashMap<String, EnumHabilidades>();
        for (EnumHabilidades nome : values()) {
            relations.put(nome.getNome(), nome);
        }
    }

    EnumHabilidades(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static EnumHabilidades getNome(String nome) {
        return relations.get(nome);
    }

}
