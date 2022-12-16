package com.example.eksamensprojekt_2sem.utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionSingletonTest {
    static Connection connection;

    @BeforeAll
    static void setUp(){ connection = null;}//Bjørn

    @AfterEach
    void tearDown() {if (connection != null){connection = null;}}//Bjørn

    @Test
    void getConnected() throws SQLException{//Bjørn
       connection = DriverManager.getConnection(System.getenv("Url"),
                System.getenv("Username"), System.getenv("Password"));
       assertNotNull(connection, "Test DB conn");
    }


}