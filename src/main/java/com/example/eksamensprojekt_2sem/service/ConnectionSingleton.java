package com.example.eksamensprojekt_2sem.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class ConnectionSingleton {

    //private static Connection connection = null;
    //kald til gemte værdier, der tilgår DB

    /*
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

     */
public static Connection connect(){
    Connection connection = null;

    try {
        //Skaber en forbindelse til DB
        String db_URL = System.getenv("JDBCUrl");
        String uid = System.getenv("JDBCUsername");
        String pass = System.getenv("JDBCPassword");
        connection = DriverManager.getConnection(db_URL, uid, pass);


    } catch (SQLException e) {
        System.out.println("u dun goofed");
        e.printStackTrace();
    }

    return connection;
}


}
