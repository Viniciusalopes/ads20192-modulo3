/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 14/09/2020 06:47:24 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Comparadores para instruções SQL.
 *  ------------------------------------------------------------------------------------------------| 
 */
package dao.generic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vovostudio
 */
public enum Comparer {
    NOT("NOT"),
    ISNULL("IS NULL"),
    ISNOTNUL("IS NOT NUL"),
    EQUAL("="),
    DIFFERENT("<>"),
    BIGGER(">"),
    BIGGERANDEQUAL(">="),
    SMALLER("<"),
    LESSOREQUAL("<=");

    private String comparator;

    /**
     * Guarda as relacoes entre o tipo e o valor de um elemento da enum
     *
     * FONTE:
     * https://www.guj.com.br/t/enum-obter-o-valor-do-atributo-do-enum-atraves-do-metodos/109311/2
     */
    private static Map<String, Comparer> relations;

    /**
     * Bloco estatico que popula o hashmap com as relacoes entre tipo e elementos da enum
     */
    static {
        relations = new HashMap<String, Comparer>();
        for (Comparer comparator : values()) {
            relations.put(comparator.getComparator(), comparator);
        }
    }

    Comparer(String comparator) {
        this.comparator = comparator;
    }

    public String getComparator() {
        return comparator;
    }

    public static Comparer getComparator(String comparator) {
        return relations.get(comparator);
    }

}
