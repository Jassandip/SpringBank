package com.springbank.dao.impl;

import java.sql.*;
public class MySqlDao{

private static final String USERNAME = "root";
private static final String PASSWORD = "jassan69";
private static final String CONN_STRING = "jdbc:mysql://localhost:3306/Bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


public static Connection getConnection(){ 
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected");
            return conn;
        }catch (SQLException e){
        System.err.println(e);
        return conn;
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return conn;
            }
        
}}