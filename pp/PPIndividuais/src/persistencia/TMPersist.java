/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author vovomint
 */
import model.Aluno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class TMPersist {

    //Atributos
    private String filename;

    //Metodos    
    public TMPersist() {
    }

    public TMPersist(String arquivo) {
        filename = arquivo;
    }

    //Metodo abstrato que ira compor o algoritmo de ordenacao da listagem
    public abstract boolean ePrimeiro(Aluno aluno1, Aluno aluno2);

    public Iterable<Aluno> listagemDeAlunos() throws Exception {
        try {
            ArrayList<Aluno> lista = new ArrayList<>();
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            int pos = 0;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().equalsIgnoreCase("﻿Nome;Curso;Situação;Enfase")) {
                    Aluno aux = new Aluno(linha);
                    lista.add(aux);
                    pos++;
                }
            }
            br.close();
            // bubble sort
            for (int i = 0; i < lista.size(); i++) {
                for (int j = i; j < lista.size(); j++) {
                    if (!ePrimeiro(lista.get(i), lista.get(j))) {
                        Aluno temp = lista.get(j);
                        lista.set(j, lista.get(i));
                        lista.set(i, temp);
                    }
                }
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }
}
