/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 02/10/2020 18:49:34 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - TEMPLATE METHOD
 *  Exercício  : Métodos de ordenação
 *  ------------------------------------------------------------------------------------------------
 *  Template para ordenação
 *  -----------------------------------------------------------------------------------------------| 
 */
package templates;

import classes.Aluno;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class Template {

    //Atributos
    private String nomeDoArquivo;

    //Metodos    
    public Template() {
    }

    public Template(String arquivo) {
        nomeDoArquivo = arquivo;
    }

    
    public abstract boolean ePrimeiro(Aluno aluno1, Aluno aluno2);

    public ArrayList<Aluno> listagemDeAlunos() throws Exception {
        try {
            ArrayList<Aluno> array = new ArrayList<>();
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            int pos = 0;
            while ((linha = br.readLine()) != null) {
                Aluno aux = new Aluno(linha);
                array.add(aux);
                pos++;
            }
            br.close();
            //algoritmo de Ordenação
            for (int i = 1; i < array.size(); i++) {
                for (int j = i; j < array.size(); j++) {

                    if (!ePrimeiro(array.get(i), array.get(j))) {
                        Aluno temp = array.get(j);
                        array.set(j, array.get(i));
                        array.set(i, temp);
                    }
                }
            }
            return array;
        } catch (Exception e) {
            throw e;
        }
    }
}
