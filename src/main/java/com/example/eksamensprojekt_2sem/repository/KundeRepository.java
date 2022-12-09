package com.example.eksamensprojekt_2sem.repository;

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

  public List<BrugerModel> visAlleBrugere() {
    //Ferhat og Kristian er ansvarlig for denne metode
    List<BrugerModel> brugere = new LinkedList<>();

      try {
        ResultSet resultSet = SQLManager.execute("CALL visAlleBrugere()");

        while (resultSet.next()) {
          int id = resultSet.getInt(1);
          String fornavn = resultSet.getString(2);
          String efternavn = resultSet.getString(3);
          String email = resultSet.getString(4);
          String tlf = resultSet.getString(5);
          String cpr = resultSet.getString(6);

          brugere.add(new BrugerModel(id, fornavn, efternavn, email, tlf, cpr));
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return brugere;
  }


  public void opretKunde(String fornavn, String efternavn, String email, String tlf, String cpr) { //Kristian
    // Format:
    // fornavn,efternavn,email,tlf,cpr
    SQLManager.update("CALL OpretBruger('" + fornavn + "','" + efternavn + "','" + email + "','" + tlf + "','" + cpr + "')");
  }

  public int getNyesteKundeID() { //Kristian. Metoden skal returnere det nyeste kunde ID, så websiden ved, hvilken kunde den skal forbinde den nye booking til.

    int nyesteKundeID = 0;

    try {
      ResultSet resultSet = SQLManager.execute("CALL KundeIDFindHoejst()");

      resultSet.next(); //Der er kun en enkel linje i denne query, så dette er nødvendigt.

      nyesteKundeID = resultSet.getInt(1);

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return nyesteKundeID;

  }

  public List<BrugerModel> skafBrugerFraCPR(String brugerCPR) {

    List<BrugerModel> brugere = new LinkedList<>();

    try {
      ResultSet resultSet = SQLManager.execute("CALL skafBrugerFraCPR('" + brugerCPR + "')");

      while (resultSet.next()) {
        int id = resultSet.getInt(1);
        String fornavn = resultSet.getString(2);
        String efternavn = resultSet.getString(3);
        String email = resultSet.getString(4);
        String tlf = resultSet.getString(5);
        String cpr = resultSet.getString(6);

        brugere.add(new BrugerModel(id, fornavn, efternavn, email, tlf, cpr));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return brugere;
  }
}
