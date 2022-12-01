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
    @Value("${JDBCUrl}")
    private String db_URL;
    //private static String db_URL = "jdbc:mysql://team-baever.mysql.database.azure.com:3306/bilabonnement";

    @Value("${JDBCUsername}")
    private String uid;
    //private static String uid = "Control";

    @Value("${JDBCPassword}")
    private static String pass;
    //private static String pass = "BeaverDen523#";

    private static Connection connection = null;

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
    public static Connection connect(String db_URL, String uid, String pass) {
        if (connection == null) {
            try {
                //Skaber en forbindelse til DB
                connection = DriverManager.getConnection(db_URL, uid, pass);
            } catch (SQLException e) {
                System.out.println("u dun goofed");
                e.printStackTrace();
            }
            return connection;
        } else {
            return connection;
        }
    }


}
