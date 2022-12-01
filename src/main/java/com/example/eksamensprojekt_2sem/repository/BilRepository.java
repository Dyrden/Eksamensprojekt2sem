package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.BilModel;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BilRepository {
    public Object visAlleBiler(String s){
        List<BilModel> bilModeler = new LinkedList<>();
        try {
       ResultSet resultSet = SQLManager.execute(("CALL VisAlleBiler()"));
        while (resultSet.next()){

        }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return bilModeler;

    }
    public Object visUdlejetBiler(String s){
        return SQLManager.makeStatement("CALL VisUdlejedeBiler()");

    }
    public Object LavBil(String s){
        return SQLManager.makeStatement("CALL LavBil()");

    }

    public int selectBilUdfraVognNummer(int vognNummer){
        vognNummer = 0;
        return vognNummer;
    }

    public Object visSpecifikBil(String s){
        return SQLManager.makeStatement("CALL VisSpecifikBil('vognnummer')");
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
