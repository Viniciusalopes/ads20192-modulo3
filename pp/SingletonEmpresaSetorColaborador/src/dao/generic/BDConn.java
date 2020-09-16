/*
 *  ------------------------------------------------------------------------------------------------>
 *  Licença    : MIT - Copyright 2019 Viniciusalopes (Vovolinux) <suporte@vovolinux.com.br>
 *  Criado em  : 14/09/2020 02:58:40 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : Arquitetura e Projeto de Software
 *  Aluno      : Vinicius Araujo Lopes
 *  Projeto    : PADRÃO DE PROJETOS - SINGLETON
 *  Exercício  : Colaboradores dos setores de uma empresa
 *  -------------------------------------------------------------------------------------------------
 *  Conexão com o banco de dados (SINGLETON).
 *  ------------------------------------------------------------------------------------------------| 
 */
package dao.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import util.EnumStatus;

/**
 *
 * @author vovostudio
 */
public class BDConn {

    //--- ATRIBUTOS ------------------------------------------------------------------------------->
    //
    private static BDConn bdConn = null;
    private static BDConfig config = null;
    private static String url = "";
    private static Properties props = null;
    private Connection connection = null;

    //--- FIM ATRIBUTOS ---------------------------------------------------------------------------|
    //
    //--- CONSTRUTORES ---------------------------------------------------------------------------->
    //
    private BDConn() {
        config = BDConfig.getInstance();
    }

    //--- FIM CONSTRUTORES ------------------------------------------------------------------------|
    //
    //--- GET ------------------------------------------------------------------------------------->
    //
    public static BDConn getInstance() throws Exception {
        try {
            if (bdConn == null) {
                bdConn = new BDConn();
                config = BDConfig.getInstance();
            }
            url = "jdbc:postgresql:" + config.getServer() + ":" + config.getPort() + "/" + config.getDatabase();
            props = new Properties();
            props.setProperty("user", config.getUser());
            props.setProperty("password", config.getPassword());

            return bdConn;
        } catch (Exception e) {
            throw new Exception("Não foi possível localizar o banco de dados!\n" + e.getLocalizedMessage());
        }
    }

    public Connection getConnection() throws Exception {
        try {
            Class.forName(config.getDriver());
            connection = DriverManager.getConnection(url, props);
            return connection;
        } catch (Exception e) {
            throw new Exception("Não foi possível obter a conexão com o banco de dados!\n" + e.getLocalizedMessage());
        }
    }

    public EnumStatus getStatus() {
        if (connection == null) {
            return EnumStatus.INATIVA;
        }
        return EnumStatus.ATIVA;
    }

    //--- FIM GET ---------------------------------------------------------------------------------|
    //
}
