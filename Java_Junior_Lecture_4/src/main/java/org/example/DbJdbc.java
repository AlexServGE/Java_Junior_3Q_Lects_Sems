package org.example;

import java.sql.*;

public class DbJdbc {
    /**
     * private static final String url = "jdbc:mysql://ip:port"
     * 1 протокол jdbc:
     * 2 драйвер через который будем подключаться к базе данных://
     * 3 сокет (ip:port), на котором расположена база данных
     */
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";


    public static void connectionCreateInsertSelect() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = con.createStatement();) {
            statement.execute("DROP SCHEMA IF EXISTS test");
            statement.execute("CREATE SCHEMA test");
            statement.execute("CREATE TABLE test.table (id INT NOT NULL, firstname VARCHAR(45) NULL, lastname VARCHAR(45) NULL, PRIMARY KEY (id))");
            statement.execute("INSERT INTO test.table (id, firstname, lastname) VALUES (1, 'Иван','Иванов')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test.table");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
