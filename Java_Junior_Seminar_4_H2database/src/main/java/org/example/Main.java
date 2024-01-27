package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:database.db");
        prepareTables(connection);
        insertData(connection);
        selectData(connection);
        deleteData(connection);
        selectData(connection);
        selectDateFromPreparedStatement(connection);
        connection.close();
    }

    private static void selectDateFromPreparedStatement(Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("select id,name from users where name = ? and id = ?")) {
            preparedStatement.setString(1, "Igor");
            preparedStatement.setInt(2, 1);
            ResultSet resultSet = preparedStatement.executeQuery(); //принимает пустой Query, так как он уже был сформирован в PreparedStatement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + resultSet.getString(2));
            }
        }
    }

    private static void deleteData(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            int deletedRows = statement.executeUpdate("delete from users where id = 4");
            System.out.println(deletedRows);
        }
    }

    private static void selectData(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + resultSet.getString(2));
            }
        }
    }

    private static void insertData(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            int updatedRows = statement.executeUpdate("""
                    insert into users(id, name)values(1, 'Igor'),(2, 'User #2'),(3,'User #3'),(4, 'User #4');
                    """);
            System.out.println(updatedRows);

//            statement.execute("insert into users(id, name)values(1, 'Igor')");
//            statement.execute("insert into users(id, name)values(2, 'User #2')");
//            statement.execute("insert into users(id, name)values(3,'User #3') ");
//            statement.execute("insert into users(id, name)values(4, 'User #4')");
        }
    }

    private static void prepareTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement();) {
            statement.execute("""
                    create table users (
                        id bigint,
                        name varchar(255)
                    )
                    """);
        }
    }
}