package com.example.eksamensprojekt_2sem.service;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

    private static Connection connection = null;
    //kald til gemte værdier, der tilgår DB
    @Value("${JDBCUrl}")
    private static String db_URL;

    @Value("${JDBCUsername}")
    private static String uid;

    @Value("${JDBCPassword}")
    private static String pass;
static {

    try {
        //Skaber en forbindelse til DB
        Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection(db_URL, uid, pass);

    } catch (ClassNotFoundException | SQLException e) {
        System.out.println("u dun goofed");
        e.printStackTrace();
    }
}
public static Connection connect(){
    return connection;
}
}
