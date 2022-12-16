package com.example.eksamensprojekt_2sem.utility;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLManager {

    //Bjørn er ansvarlig for denne metode
    private static PreparedStatement makeStatement(String s){
        //laver en skabelon for Prepared statements, fordi DRY
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConnectionSingleton.connect().prepareStatement(s);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    //Bjørn er ansvarlig for denne metode
    public static ResultSet execute(String s){
        //metode der modtager info fra DB
        ResultSet resultSet = null;
        try {
            PreparedStatement psts = makeStatement(s);
            resultSet = psts.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    //Bjørn er ansvarlig for denne metode
    public static void update(String s){
        //metode der sender info til DB
        try {
            PreparedStatement psts = makeStatement(s);
            psts.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
