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
       ResultSet resultSet = SQLManager.execute("CALL visallebiler()",dbUrl,uID,pass);

            while (resultSet.next()) {
                String vognNummer = resultSet.getString(1);
                String stelNummer = resultSet.getString(2);
             String maerke = resultSet.getString(3);
             String model = resultSet.getString(4);
             String energiType = resultSet.getString(5);
             String gearboks = resultSet.getString(6);
             String udstyr = resultSet.getString(7);
             String status = resultSet.getString(8);
             String farve = resultSet.getString(9);
             double staalPris = resultSet.getInt(10);
             double registreringsAfgift = resultSet.getInt(11);
             double CO2Udledning = resultSet.getInt(12);
             int produktionsaar = resultSet.getInt(13);
             int distance = resultSet.getInt(14);

                biler.add(new BilModel(vognNummer, stelNummer,maerke, model,energiType,gearboks,udstyr, status, farve,
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
                bilModel.setVognNummer(resultSet.getString(1));
                bilModel.setStelNummer(resultSet.getString(2));
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
