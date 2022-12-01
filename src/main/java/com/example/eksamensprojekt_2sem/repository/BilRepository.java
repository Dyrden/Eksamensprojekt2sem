package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.BilModel;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BilRepository {
    public void visAlleBiler(String s){
        SQLManager.makeStatement("CALL VisAlleBiler()");
    }
    public void visUdlejetBiler(String s){
        SQLManager.makeStatement("CALL VisUdlejedeBiler()");

    }
    public void LavBil(String s){
        SQLManager.makeStatement("CALL LavBil()");

    }

    public int selectBilUdfraVognNummer(int vognNummer){
        vognNummer = 0;
        return vognNummer;
    }
    public List<BilModel> getAllCars() {


        List<BilModel> wishlists = new LinkedList<>();
        try {
            Connection conn = DriverManager.getConnection(db_url, uid, pas);
            PreparedStatement psts = conn.prepareStatement(pstsGetAll);
            ResultSet resultSet = psts.executeQuery();
            while (resultSet.next()) {
                int vognNummer = resultSet.getInt(1);
                int stelNummer = resultSet.getInt(2);
                String maerke= resultSet.getString(3);
                wishlists.add(new BilModel(vognNummer,stelNummer, maerke));
            }

        } catch (SQLException e) {
            System.out.println("Couldn't connect to db");
            e.printStackTrace();
        }
        System.out.println(wishlists);
        return wishlists;
    }

    public void visSpecifikBil(String s){
        SQLManager.makeStatement("CALL VisSpecifikBil('vognnummer')");
    }

    public Object sUVisning(String s){
        BilModel bilModel = null;
        try {

            ResultSet resultSet =
                    SQLManager.execute("CALL VisSpecifikBil('vognnummer')");
            while (resultSet.next()){
                try {
                bilModel.setVognNummer(resultSet.getInt(1));
                bilModel.setStelNummer(resultSet.getInt(2));
                bilModel.setMaerke(resultSet.getString(3));
                bilModel.setModel(resultSet.getString(4));
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
