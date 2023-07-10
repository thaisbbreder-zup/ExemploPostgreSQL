package org.example;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "thais123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Estabelece a conexão com o banco de dados PostgreSQL
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("---------> Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("---------X Falha na conexão com o banco de dados: " + e.getMessage());
        }
        return connection;
    }
}
