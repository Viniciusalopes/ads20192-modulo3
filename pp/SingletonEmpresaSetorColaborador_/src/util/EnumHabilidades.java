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
    Beber("Beber"),
    Cochilar("Cochilar"),
    Dormir("Dormir"),
    Java("Java"),
    CSharp("C#"),
    Php("Php"),
    Python("Python"),
    JavaScript("JavaScript"),
    HTML("HTML 5"),
    CSS("CSS 3"),
    SpringBoot("Spring Boot"),
    Angular("Angular"),
    ReactJs("ReactJs"),
    MySql("MySql"),
    PowerBI("Power BI"),
    TabelaoExcel("Tabelão de Excel"),
    PostgreSQL("PostgreSQL"),
    Oracle("Oracle DataBases"),
    FalarComMicMutado("Falar com o microfone mutado"),
    FalarLongeDoMic("Falar longe do microfone"),
    UsarFoneOuvidoFora("Usar fones de ouvido"),
    ColorirDeRoxo("Colorir de Roxo"),
    Planejamento("Planejamento"),
    GestaoDeProjetos("Gestão de Projetos"),
    GestaoDePessoas("Gestão de Pessoas"),
    Desenhar("Desenhar"),
    Lecionar("Lecionar"),
    POO("POO"),
    InterromperAula("Interromper a aula"),
    SemearDiscordia("Semear a discórdia"),
    PP("Padrões de Projetos"),
    ArquiteturaDeSoftware("Arquitetura de Software"),
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
