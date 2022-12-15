package com.example.eksamensprojekt_2sem.utility;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class ConnectionSingleton {

    private static Connection connection = null;
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

    public static Connection connect() {
        if (connection == null) {
            try {
                //Skaber en forbindelse til DB
                //tak til Claus Bove @kea dat22v1 programmering
                String db_URL = System.getenv("JDBCUrl");
                String uid = System.getenv("JDBCUsername");
                String pass = System.getenv("JDBCPassword");
                connection = DriverManager.getConnection(db_URL, uid, pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


}
