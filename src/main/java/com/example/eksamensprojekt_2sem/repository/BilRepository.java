package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.BilModel;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BilRepository {

    @Value("${JDBCUrl}")
    private String dbUrl;

    @Value("${JDBCUsername}")
    private String uID;

    @Value("${JDBCPassword}")
    private String pass;
    public BilRepository(){}

    public List<BilModel> visAlleBiler(){
        List<BilModel> biler = new LinkedList<>();
        try {
       ResultSet resultSet = SQLManager.execute("CALL VisAlleBiler()",dbUrl,uID,pass);

            while (resultSet.next()) {
                int vognNummer = resultSet.getInt(1);
                int stelNummer = resultSet.getInt(2);
             int maerkeID = resultSet.getInt(3);
             int modelID = resultSet.getInt(4);
             int statusID = resultSet.getInt(5);
             int farveID = resultSet.getInt(6);
             double staalPris = resultSet.getInt(7);
             double registreringsAfgift = resultSet.getInt(8);
             double CO2Udledning = resultSet.getInt(9);
             int produktionsaar = resultSet.getInt(10);
             int distance = resultSet.getInt(11);

                biler.add(new BilModel(vognNummer, stelNummer,maerkeID, modelID, statusID, farveID,
                                            staalPris, registreringsAfgift, CO2Udledning, produktionsaar, distance));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return biler;

    }
    public Object visUdlejetBiler(String s){
        return SQLManager.makeStatement("CALL VisUdlejedeBiler()",dbUrl,uID,pass);

    }
    public Object LavBil(String s){
        return SQLManager.makeStatement("CALL LavBil()",dbUrl,uID,pass);

    }

    public int selectBilUdfraVognNummer(int vognNummer){
        vognNummer = 0;
        return vognNummer;
    }

    public Object visSpecifikBil(String s){
        return SQLManager.makeStatement("CALL VisSpecifikBil('vognnummer')",dbUrl,uID,pass);
    }

    public Object sUVisning(String s){
        BilModel bilModel = null;
        try {

            ResultSet resultSet =
                    SQLManager.execute("CALL VisSpecifikBil('vognnummer')",dbUrl,uID,pass);
            while (resultSet.next()){
                try {
                bilModel.setVognNummer(resultSet.getInt(1));
                bilModel.setStelNummer(resultSet.getInt(2));
                bilModel.setMaerkeID(resultSet.getInt(3));
                bilModel.setModelID(resultSet.getInt(4));
                }catch (NullPointerException e){
                    System.out.println("i got nothing");
                }

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return bilModel;
    }


}
