package com.example.eksamensprojekt_2sem.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class SQLManagerTest {

   static Connection connection;

    @BeforeAll
    static void setup() throws SQLException {
        connection = DriverManager.getConnection(System.getenv("Url"),
                System.getenv("Username"), System.getenv("Password"));
    }

    @AfterEach
    void tearDown(){
     String s = null;
    }

    @Test
    void makeStatement() {
     String s = "CALL visTilgængeligeBiler()";
     PreparedStatement preparedStatement = null;
     try {
      preparedStatement = connection.prepareStatement(s);
     } catch (SQLException e){
      e.printStackTrace();
     }
     assertNotNull(preparedStatement, "Test Statement");
    }

    @Test
    void execute() {
     String s = "CALL visTilgængeligeBiler()";
     ResultSet resultSet = null;
     try {
      PreparedStatement psts = connection.prepareStatement(s);
      resultSet = psts.executeQuery();
     }catch (SQLException e){
      e.printStackTrace();
     }
     assertNotNull(resultSet, "Test Resultset Execute");
    }


    @Test
    void update() {
     String s = "CALL lavBooking()";
     int resultSet = 0;
     try {
      PreparedStatement psts = connection.prepareStatement(s);
      resultSet = psts.executeUpdate();
     }catch (SQLException e){
      e.printStackTrace();
     }
     assertEquals(resultSet>0, 0);
    }
    }