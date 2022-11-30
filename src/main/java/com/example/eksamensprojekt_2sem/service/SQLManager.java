package com.example.eksamensprojekt_2sem.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLManager {
    public static PreparedStatement makeStatement(String s){
        //laver en skabelon for Prepared statements, fordi DRY
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConnectionSingleton.connect().prepareStatement(s);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static ResultSet execute(String s){
        ResultSet resultSet = null;
        try {


            PreparedStatement psts = makeStatement(s);
            resultSet = psts.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void update(String s){
        try {


            PreparedStatement psts = makeStatement(s);
            psts.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
