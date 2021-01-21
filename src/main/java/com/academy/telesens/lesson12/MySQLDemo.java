package com.academy.telesens.lesson12;

import java.sql.*;

public class MySQLDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/operator?user=root&password=root";
        String sqlInsert = "Insert into subscriber (first_name, last_name, gender, age) values ('demo', 'demo', 'm', 23 )";
        String sqlInsertTemplate = "Insert into subscriber (first_name, last_name, gender, age) values (?, ?, ?, ? )";
        try (Connection conn = DriverManager.getConnection(url)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement statement = conn.createStatement();
            statement.executeUpdate(sqlInsert);

            PreparedStatement preparedStatement = conn.prepareStatement(sqlInsertTemplate);
            preparedStatement.setString(1,"demo_firstname_2");
            preparedStatement.setString(2,"demo_lastname_2");
            preparedStatement.setString(3,"f");
            preparedStatement.setInt(4,26);
            preparedStatement.executeUpdate();

            // Полное чтение таблицы subscriber
            Statement readStatement = conn.createStatement();
            ResultSet resultSet = readStatement.executeQuery("Select * from subscriber");

            while (resultSet.next()) {
                int id = resultSet.getInt("subscriber_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");

                System.out.println(String.format("%d | %s | %s | %s | %d", id, firstName, lastName, gender, age));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
