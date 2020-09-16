/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 14/09/2020 02:52:54 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Configurações para conexão com banco de dados PostgreSQL (SINGLETON).
 *  ------------------------------------------------------------------------------------------------| 
 */
package dao.generic;

/**
 *
 * @author vovostudio
 */
public class BDConfig {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static BDConfig config = null;
    private final String server = "//srv-ubuntu";
    private final String port = "5432";
    private final String database = "ppsingleton";
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
    //
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
