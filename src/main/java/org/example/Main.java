package org.example;

import java.sql.*;

public class Main {
    public static void createTable() {
        System.out.println("\n------------- PESQUISA BANCO DE DADOS: EXEMPLO COM POSTGRESQL -------------\n");

        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "CREATE TABLE IF NOT EXISTS tabela_exemplo (id INT PRIMARY KEY, nome VARCHAR(100))";
                statement.executeUpdate(query);
                System.out.println("---------> Tabela tabela_exemplo criada com sucesso!");
                statement.close();
            } catch (SQLException e) {
                System.out.println("Erro ao criar a tabela: " + e.getMessage());
            }
        }
    }

    public static void insertData() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            try {
                String query = "INSERT INTO tabela_exemplo (id, nome) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);

                // Obter o próximo valor exclusivo para a chave primária id
                String idQuery = "SELECT MAX(id) FROM tabela_exemplo";
                Statement idStatement = connection.createStatement();
                ResultSet idResult = idStatement.executeQuery(idQuery);
                int nextId = 1;
                if (idResult.next()) {
                    nextId = idResult.getInt(1) + 1;
                }
                idResult.close();
                idStatement.close();

                // Inserir o registro com o próximo valor exclusivo para id
                statement.setInt(1, nextId);
                statement.setString(2, "Novo Exemplo");
                statement.executeUpdate();

                System.out.println("---------> Dados inseridos com sucesso!");

                statement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("---------X Erro ao inserir dados: " + e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        createTable();

        insertData();

        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            try {
                String countQuery = "SELECT COUNT(*) FROM tabela_exemplo";
                PreparedStatement countStatement = connection.prepareStatement(countQuery);
                ResultSet countResult = countStatement.executeQuery();

                // Obter o resultado do COUNT(*)
                if (countResult.next()) {
                    int rowCount = countResult.getInt(1);
                    System.out.println("---------> Número de registros na tabela: \n" + rowCount);
                }

                countResult.close();
                countStatement.close();

                // Consulta para recuperar os dados da tabela
                String query = "SELECT * FROM tabela_exemplo";
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");

                    System.out.println("ID: " + id + ", Nome: " + nome);
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("---------X Erro ao executar a consulta: " + e.getMessage());
            }
        }
    }
}
