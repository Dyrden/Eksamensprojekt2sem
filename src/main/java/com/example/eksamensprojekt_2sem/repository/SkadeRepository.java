package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.SkadeModel;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.beans.factory.annotation.Value;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkadeRepository {
  @Value("${JDBCUrl}")
  private String dbUrl;

  @Value("${JDBCUsername}")
  private String uID;

  @Value("${JDBCPassword}")
  private String pass;

  public SkadeModel hentSkaderFraVognNummer(String vognNummer){
    SkadeModel skade = new SkadeModel();
    //lav metoden efter rapporten er lavet
    return skade;
  }
}
