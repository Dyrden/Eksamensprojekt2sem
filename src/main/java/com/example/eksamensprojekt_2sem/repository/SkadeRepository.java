package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.SkadeModel;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.beans.factory.annotation.Value;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SkadeRepository {
  @Value("${JDBCUrl}")
  private String dbUrl;

  @Value("${JDBCUsername}")
  private String uID;

  @Value("${JDBCPassword}")
  private String pass;

  public List<SkadeModel> skafSkaderFraRapport(int id){
    List<SkadeModel> skader = new LinkedList<>();
    SkadeModel skade = new SkadeModel();
    try{
      ResultSet resultSet = SQLManager.execute
          ("CALL skafSkaderFraRapport('"+id+"')",dbUrl,uID,pass);
      while (resultSet.next()){
        skade.setId(resultSet.getInt(1));
        skade.setSkadensPlacering(resultSet.getString(2));
        skade.setSkadensBeskrivelse(resultSet.getString(3));
        skade.setSkadensPris(resultSet.getDouble(4));
        skade.setRapportID(resultSet.getInt(5));

        skader.add(skade);
      }
      System.out.println(skade);
    } catch (SQLException e){
      e.printStackTrace();
    }

    return skader;
  }
}
