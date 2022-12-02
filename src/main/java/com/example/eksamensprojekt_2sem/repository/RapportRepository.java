package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.RapportModel;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RapportRepository {
  @Value("${JDBCUrl}")
  private String dbUrl;

  @Value("${JDBCUsername}")
  private String uID;

  @Value("${JDBCPassword}")
  private String pass;
public RapportModel hentRapportFraVognNummer(String vognNummer){
  RapportModel rapport = new RapportModel();
  try{
    ResultSet resultSet = SQLManager.execute
        ("CALL skafRapporterFraVognNummer('"+vognNummer+"')",dbUrl,uID,pass);
    while (resultSet.next()){
      rapport.setId(resultSet.getInt(1));
      rapport.setDato(resultSet.getString(2));
      rapport.setVognNummer(resultSet.getString(4));
      rapport.setMaerkeID(resultSet.getInt(5));
      rapport.setModelID(resultSet.getInt(6));
      rapport.setStatusID(resultSet.getInt(7));
      rapport.setFarveID(resultSet.getInt(8));
      rapport.setStaalPris(resultSet.getString(9));
      rapport.setRegistreringsAfgift(resultSet.getString(10));
      rapport.setCO2Udledning(resultSet.getString(11));
      rapport.setProduktionsaar(resultSet.getString(12));
      rapport.setDistance(resultSet.getString(13));

    }
    System.out.println(rapport);
  } catch (SQLException e){
    e.printStackTrace();
  }

  return rapport;
}
}
