/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 06/09/2020 23:38:50 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : Projeto MVC - Sistema Bancário Simples
 *  Exercício  : https://www.devmedia.com.br/java-se-aprendendo-o-padrao-mvc/29546
 *  ------------------------------------------------------------------------------------------------
 *  Modelo de persistência em arquivo.
 *  -----------------------------------------------------------------------------------------------| 
 */
package model_Vinicius.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import model_Vinicius.enums.EnumConstantes;

/**
 *
 * @author vovostudio
 */
public class ArquivoCONN {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private final String so = System.getProperty("os.name").toLowerCase();
    private final String barra = so.contains("windows") ? "\\" : "/";
    private final String dirHome = System.getProperty("user.home");
    private final String dirBd = "DbSbs"; // Nome do diretório para os arquivos de dados
    private final String DAOName = dirHome + barra + dirBd;
    private final String extensao = ".txt";
    private File file = null;
    private String className = "";

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    public ArquivoCONN(String className) throws Exception {

        if (className.trim().length() == 0) {
            throw new Exception("O nome da classe é inválido!");
        }

        this.className = className;

        File dir = new File(DAOName);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        garantirArquivo(className);

    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    private void garantirArquivo(String className) throws Exception {
        file = new File(DAOName + barra + className + extensao);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    protected ArrayList<String> getResults() throws Exception {
        try {
            ArrayList<String> linhas = new ArrayList<String>();
            FileReader fr = new FileReader(file.getCanonicalPath());
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                if (linha.trim().length() > 0) {
                    linhas.add(linha.trim());
                }
            }

            br.close();

            return linhas;

        } catch (Exception e) {
            throw new Exception("Erro ao ler o arquivo [" + file.getCanonicalPath() + "]!\n" + e.getMessage());
        }
    }

    protected int lastID(int indexPrimaryKey) throws Exception {
        int id = 0;
        int idArquivo = 0;

        if (file == null) {
            garantirArquivo(className);
        }

        for (String linha : getResults()) {
            idArquivo = Integer.parseInt(linha.split(EnumConstantes.SeparadorSplit.getConstante())[indexPrimaryKey]);
            id = (idArquivo > id) ? idArquivo : id;
        }
        return id;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
    //--- SET ------------------------------------------------------------------------------------->
    //
    protected void executeUpdate(ArrayList<String> linhasArquivo) throws Exception {

        try {
            garantirArquivo(className);
            FileWriter fw = new FileWriter(file.getCanonicalPath());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String linha : linhasArquivo) {
                bw.write(linha + "\n");
            }
            bw.close();
        } catch (Exception e) {
            throw new Exception("Erro ao escrever no arquivo [" + file.getCanonicalPath() + "]!\n" + e.getMessage());
        }
    }
    
    
    //--- FIM SET ---------------------------------------------------------------------------------|
    //
}
