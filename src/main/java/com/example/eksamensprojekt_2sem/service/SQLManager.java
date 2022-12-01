package com.example.eksamensprojekt_2sem.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLManager {
    public static PreparedStatement makeStatement(String s, String db_URL, String uid, String pass){
        //laver en skabelon for Prepared statements, fordi DRY
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConnectionSingleton.connect(db_URL,uid,pass).prepareStatement(s);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static ResultSet execute(String s, String db_URL, String uid, String pass){
        ResultSet resultSet = null;
        try {


            PreparedStatement psts = makeStatement(s,db_URL,uid,pass);
            resultSet = psts.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void update(String s,String db_URL, String uid, String pass){
        try {


            PreparedStatement psts = makeStatement(s,db_URL,uid,pass);
            psts.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
