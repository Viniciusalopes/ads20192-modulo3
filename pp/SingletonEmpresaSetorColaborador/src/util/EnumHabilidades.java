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
    Estudar("Estudar"),
    Comer("Comer"),
    BeberCafe("Beber café"),
    Cochilar("Cochilar"),
    Dormir("Dormir"),
    Desenhar("Desenhar"),
    Lecionar("Lecionar"),
    GestaoDeProjetos("Gestão de Projetos"),
    GestaoDePessoas("Gestão de Pessoas"),
    Planejamento("Planejamento"),
    Pesquisar("Pesquisar"),
    Analisar("Analisar"),
    Programar("Programar"),
    CriarBugs("Criar bugs"),
    IdentificarBugs("Identificar bugs"),
    Java("Java"),
    SpringBoot("Spring Boot"),
    Angular("Angular"),
    CSharp("C#"),
    Php("Php"),
    Python("Python"),
    ShellScript("ShellScript"),
    HTML("HTML 5"),
    CSS("CSS 3"),
    JavaScript("JavaScript"),
    ReactJs("ReactJs"),
    MySql("MySql"),
    PostgreSQL("PostgreSQL"),
    Oracle("Oracle DataBases"),
    PowerBI("Power BI"),
    POO("POO"),
    PP("Padrões de Projetos"),
    ArquiteturaDeSoftware("Arquitetura de Software"),
    TabelaoExcel("Tabelão de Excel"),
    FalarComMicMutado("Falar com o microfone mutado"),
    FalarLongeDoMic("Falar longe do microfone"),
    UsarFoneOuvidoLonge("Usar fones de ouvido longe da orelha"),
    ColorirDeRoxo("Colorir de Roxo"),
    InterromperAula("Interromper a aula"),
    SemearDiscordia("Semear a discórdia"),
    SairMaisCedo("Sair mais cedo"),
    PerguntarDaChamada("Perguntar se já fez chamada"),
    InsistirNoGnome("Insistir em usar Gnome");

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
