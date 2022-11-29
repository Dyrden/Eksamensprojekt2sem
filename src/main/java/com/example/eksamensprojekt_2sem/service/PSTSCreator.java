package com.example.eksamensprojekt_2sem.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PSTSCreator {
    public static void makeStatement(String s){
        //laver en skabelon for Prepared statements, fordi DRY
        try {
           PreparedStatement preparedStatement = ConnectionSingleton.connect().prepareStatement(s);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
