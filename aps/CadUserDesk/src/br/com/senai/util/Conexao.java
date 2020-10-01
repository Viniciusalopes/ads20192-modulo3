/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Elisabete
 */
public class Conexao {

    private static Connection connection = null;
    private static Conexao conexao = null;

    private Conexao() throws Exception {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://192.168.1.52:5432/bdcaduserdesc";
        String user = "postgres";
        String password = "vin";

        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
    }

    public static Connection getConnection() throws Exception {
        try {
            if (conexao == null) {
                conexao = new Conexao();
            }
            return connection;

        } catch (Exception e) {
            throw e;
        }
    }
}
