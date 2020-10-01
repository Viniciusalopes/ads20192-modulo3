/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 13/09/2020 11:07:45 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
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
import static util.EnumSkills.values;

/**
 *
 * @author vovostudio
 */
public enum EnumSkills {
    CSharp("C#"),
    Java("Java"),
    Php("Php"),
    Web("Web"),
    BdAdmin("Bancos de dados");
    
    private String nome;

    /**
     * Guarda as relacoes entre o tipo e o valor de um elemento da enum
     *
     * FONTE:
     * https://www.guj.com.br/t/enum-obter-o-valor-do-atributo-do-enum-atraves-do-metodos/109311/2
     */
    private static Map<String, EnumSkills> relations;

    /**
     * Bloco estatico que popula o hashmap com as relacoes entre tipo e elementos da enum
     */
    static {
        relations = new HashMap<String, EnumSkills>();
        for (EnumSkills nome : values()) {
            relations.put(nome.getNome(), nome);
        }
    }

    EnumSkills(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static EnumSkills getNome(String nome) {
        return relations.get(nome);
    }

}
