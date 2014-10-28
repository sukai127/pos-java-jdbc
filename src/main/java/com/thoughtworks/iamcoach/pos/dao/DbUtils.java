package com.thoughtworks.iamcoach.pos.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
    private String user = "pos";
    private String password = "admin";
    private String url = "jdbc:mysql://localhost:3306/pos?useUnicode=true&&characterEncoding=utf-8";

    private Connection getConnection(){

        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
        }

        return connection;
    }
}
