package com.academy.telesens.lesson12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/operator?user=root&password=root";
        String sqlInsert = "Insert into subscriber values (5, 'demo', 'demo', 'm', 23 )";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();
            statement.executeUpdate(sqlInsert);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
