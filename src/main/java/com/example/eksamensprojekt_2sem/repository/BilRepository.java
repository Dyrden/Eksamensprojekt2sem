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
    public Object visAlleBiler(String s){
        List<BilModel> bilModeler = new LinkedList<>();
        try {
       ResultSet resultSet = SQLManager.execute("CALL VisAlleBiler()",dbUrl,uID,pass);
        while (resultSet.next()){

        }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return bilModeler;

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
