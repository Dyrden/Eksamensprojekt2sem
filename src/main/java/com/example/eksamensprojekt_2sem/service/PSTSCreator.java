package com.example.eksamensprojekt_2sem.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PSTSCreator {
    public static PreparedStatement makeStatement(String s){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ConnectionSingleton.connect().prepareStatement(s);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }
}
