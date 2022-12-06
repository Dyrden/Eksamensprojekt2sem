package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.BookingModel;
import com.example.eksamensprojekt_2sem.model.BrugerModel;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class KundeRepository {
  @Value("${JDBCUrl}")
  private String dbUrl;

  @Value("${JDBCUsername}")
  private String uID;

  @Value("${JDBCPassword}")
  private String pass;

  public List<BrugerModel> visAlleBrugere(){
    //Ferhat er ansvarlig for denne metode
    List<BrugerModel> brugere = new LinkedList<>();
    BrugerModel bruger = new BrugerModel();

    try {
      ResultSet resultSet = SQLManager.execute("CALL visAlleBrugere()",dbUrl,uID,pass);

      while (resultSet.next()) {
        int id = resultSet.getInt(1);
        String fornavn = resultSet.getString(2);
        String efternavn = resultSet.getString(3);
        String email = resultSet.getString(4);
        String tlf = resultSet.getString(5);
        String cpr = resultSet.getString(6);

        brugere.add(new BrugerModel(id, fornavn, efternavn, email, tlf, cpr));
      }

    } catch (SQLException e){
      e.printStackTrace();
    }

    return brugere;

  }

}
