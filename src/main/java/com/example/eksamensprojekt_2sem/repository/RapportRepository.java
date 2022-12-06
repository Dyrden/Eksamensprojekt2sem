package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.RapportModel;
import com.example.eksamensprojekt_2sem.model.SkadeModel;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class RapportRepository {
  @Value("${JDBCUrl}")
  private String dbUrl;

  @Value("${JDBCUsername}")
  private String uID;

  @Value("${JDBCPassword}")
  private String pass;
public List<RapportModel> hentRapportFraVognNummer(String vognNummer){
  List<RapportModel> rapporter = new LinkedList<>();
  try{
    ResultSet resultSet = SQLManager.execute
        ("CALL skafRapporterFraVognNummer('"+vognNummer+"')");
    while (resultSet.next()){
      RapportModel rapport = new RapportModel();

      rapport.setId(resultSet.getInt(1));
      rapport.setDato(resultSet.getString(2));
      rapport.setVognNummer(resultSet.getString(3));
      rapport.setOverSkredetKM(resultSet.getString(4));
      rapporter.add(rapport);
      System.out.println(rapport);
    }
  } catch (SQLException e){
    e.printStackTrace();
  }

  return rapporter;
}


}
