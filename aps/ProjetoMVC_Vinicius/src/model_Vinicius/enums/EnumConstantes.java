/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 07/09/2020 02:00:31 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : Projeto MVC - Sistema Bancário Simples
 *  Exercício  : https://www.devmedia.com.br/java-se-aprendendo-o-padrao-mvc/29546
 *  ------------------------------------------------------------------------------------------------
 *  Enumerador de constantes do sistema.
 *  -----------------------------------------------------------------------------------------------| 
 */
package model_Vinicius.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vovostudio
 */
public enum EnumConstantes {
    SeparadorSplit(";"),
    SeparadorComboBox("-");

    private String constante;

    /**
     * Guarda as relacoes entre o tipo e o valor de um elemento da enum
     *
     * FONTE:
     * https://www.guj.com.br/t/enum-obter-o-valor-do-atributo-do-enum-atraves-do-metodos/109311/2
     */
    private static Map<String, EnumConstantes> relations;

    /**
     * Bloco estatico que popula o hashmap com as relacoes entre tipo e elementos da enum
     */
    static {
        relations = new HashMap<String, EnumConstantes>();
        for (EnumConstantes cons : values()) {
            relations.put(cons.getConstante(), cons);
        }
    }

    EnumConstantes(String constante) {
        this.constante = constante;
    }

    public String getConstante() {
        return constante;
    }

    public static EnumConstantes getConstante(String constante) {
        return relations.get(constante);
    }
}
