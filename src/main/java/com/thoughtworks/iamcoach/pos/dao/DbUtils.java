package com.thoughtworks.iamcoach.pos.dao;

import java.sql.*;

public class DbUtils {

    private Connection connection;
    private String user = "pos";
    private String password = "admin";
    private String url = "jdbc:mysql://localhost:3306/pos?useUnicode=true&&characterEncoding=utf-8";

    public Connection getConnection(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
        }

        return connection;
    }

    public void close(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
        }
    }

}
