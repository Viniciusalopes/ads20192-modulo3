/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 25/09/2020 21:36:41 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - DECORATOR
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  
 *  -----------------------------------------------------------------------------------------------| 
 */
package util;

/**
 *
 * @author vovostudio
 */
public class VectorUtil {

    /**
     * Redimensiona um vetor de objetos.
     *
     * @param vector Vetor com objetos que será redimensionado.
     * @param newLenght Novo tamanho do vetor.
     * @return
     */
    public static Object[] redimVector(Object[] vector, int newLenght) {
        int lenght = (vector.length > newLenght) ? (vector.length - newLenght) : newLenght;
        Object[] ret = new Object[lenght];
        for (int i = 0; i < vector.length; i++) {
            ret[i] = vector[i];
        }
        return ret;
    }
}
