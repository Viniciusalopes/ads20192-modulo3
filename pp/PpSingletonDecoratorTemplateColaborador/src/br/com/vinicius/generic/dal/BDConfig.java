/*
 *  ----------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 09/10/2020 19:13:03 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de Sistemas - Módulo 3 - 2020/2
 *  Disciplina : PP - Padrões de Projeto
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : SINGLETON / DECORATOR / TEMPLATE / FACTORY
 *  Exercício  : Colaboradores de uma empresa
 *  ------------------------------------------------------------------------------------------------
 *  Configurações para conexão com banco de dados PostgreSQL (SINGLETON).
 *  -----------------------------------------------------------------------------------------------| 
 */
package br.com.vinicius.generic.dal;

/**
 *
 * @author vovostudio
 */
public class BDConfig {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static BDConfig config = null;
    private final String server = "//srv-ubuntu-p13";
    private final String port = "5433";
    private final String database = "PpEmpresa";
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
