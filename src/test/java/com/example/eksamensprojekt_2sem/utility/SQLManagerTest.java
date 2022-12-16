package com.example.eksamensprojekt_2sem.utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class SQLManagerTest {

    static Connection connection;

    @BeforeAll
    //Bjørn er ansvarlig for dette kode
    static void setup() throws SQLException { //Bjørn
        connection = DriverManager.getConnection(System.getenv("Url"),
            System.getenv("Username"), System.getenv("Password"));
    }

    @AfterEach
    void tearDown() {//Bjørn
        String s = null;
    }

    @Test
    //Bjørn er ansvarlig for denne test
    void makeStatement() {
        String s = "CALL visTilgængeligeBiler()";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertNotNull(preparedStatement, "Test Statement");
    }

    @Test
    //Bjørn er ansvarlig for denne test
    void execute() {
        String s = "CALL skafAlleBiler()";
        ResultSet resultSet = null;
        try {
            PreparedStatement psts = connection.prepareStatement(s);
            resultSet = psts.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertNotNull(resultSet, "Test Resultset Execute");
    }


    @Test
    //Bjørn er ansvarlig for denne test
    void update() {//Bjørn
        String s = "CALL Bil_Update()";
        int resultSet = 0;
        try {
            PreparedStatement psts = connection.prepareStatement(s);
            resultSet = psts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(resultSet, 0);
    }

    //Mark er ansvarlig for denne test
    @Test
    void NotAllowedToQueryAnythingButStoredProceduresTest() {
        //Arrange
        String SQL = "Select * from bil;";

        //act & assert
        assertThrows(SQLException.class, () -> {
            PreparedStatement psts = connection.prepareStatement(SQL);
            ResultSet resultSet = psts.executeQuery();
        });
    }
}