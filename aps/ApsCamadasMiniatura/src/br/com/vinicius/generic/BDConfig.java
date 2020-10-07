/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 28/09/2020 17:52:55 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : ARQUITETURA EM CAMADAS
 *  Exercício  : Cadastro de Miniatura em camadas
 *  ------------------------------------------------------------------------------------------------
 *  Configurações para conexão com banco de dados PostgreSQL (SINGLETON).
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.generic;

/**
 *
 * @author vovostudio
 */
public class BDConfig {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static BDConfig config = null;
    private final String server = "//srv-ubuntu";
    private final String port = "5433";
    private final String database = "apsminiatura";
    private final String user = "postgres";
    private final String password = "vin";
    private final String driver = "org.postgresql.Driver";
    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //

    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    private BDConfig() {

    }
    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->

    public static BDConfig getInstance() {
        if (config == null) {
            config = new BDConfig();
        }
        return config;
    }

    public String getServer() {
        return server;
    }

    public String getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDriver() {
        return driver;
    }
    //--- FIM GET ---------------------------------------------------------------------------------|
    //
}
