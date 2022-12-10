package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.AbonnementsTypeModel;
import com.example.eksamensprojekt_2sem.model.BookingModel;
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
public class SkadeRepository {

  public List<SkadeModel> skafSkaderFraRapport(String id){
    //Ferhat og Kristian er ansvarlig for denne metode

    List<SkadeModel> skader = new LinkedList<>();
    try{
      ResultSet resultSet = SQLManager.execute
          ("CALL skafSkaderFraRapport('"+id+"')");
      while (resultSet.next()){
       int skadeid = (resultSet.getInt(1));
       String skadensPlacering = (resultSet.getString(2));
       String skadensBeskrivelse = (resultSet.getString(3));
       double skadensPris = (resultSet.getDouble(4));
       int rapportID= (resultSet.getInt(5));

        skader.add(new SkadeModel(skadeid, skadensPlacering, skadensBeskrivelse, skadensPris, rapportID));
      }
    } catch (SQLException e){
      System.err.println("Ingen rapporter/skader fundet.");
      System.out.println(e.getMessage());
      return new LinkedList<SkadeModel>();
    }

    return skader;
  }
  public void tilfoejSkade(String placering, String beskrivelse, double pris, int rapportID){
    //Ferhat er ansvarlig for denne metode
      ResultSet resultSet = SQLManager.execute
          ("CALL TilfoejSkade('"+beskrivelse+"','"+placering+"',"+pris+","+rapportID+")");

      System.out.println(placering+beskrivelse+pris+rapportID);
  }

  public void sletSkade(int skadeID){
    //Ferhat er ansvarlig for denne metode
    ResultSet resultSet = SQLManager.execute
        ("CALL SletSkade("+skadeID+")");
  }

  public void beregnAntalKM(){
    int bilensKMTal = 3400; // distance
    int kilometerStart = 1000; // kilometerStart
    double betaling = 0; // ekstra betaling

    //Hvor meget bilen har kørt
    int antalKMKørt = bilensKMTal-kilometerStart; //2400 km kørt

    if (antalKMKørt > 2000){
      // Hvor bilen er kørt over 2000km
      int overskredetKM = antalKMKørt-2000; //400 km over grænsen

      //Hvor meget der skal betales
     betaling = antalKMKørt*0.75; //300 kr.
    }

  }

  public double skafTotalPrisFraRapportID(String id) {
    //Ferhat og Kristian er ansvarlig for denne metode

    int totalPris = 0;
    List<SkadeModel> skader = new LinkedList<>();
    try{
      ResultSet resultSet = SQLManager.execute
          ("CALL skafSkaderFraRapport('"+id+"')");
      while (resultSet.next()){
        int skadeid = (resultSet.getInt(1));
        String skadensPlacering = (resultSet.getString(2));
        String skadensBeskrivelse = (resultSet.getString(3));
        double skadensPris = (resultSet.getDouble(4));
        int rapportID= (resultSet.getInt(5));

        totalPris += skadensPris;
      }
    } catch (SQLException e){
      System.err.println("Ingen skader/skadepris fundet.");
      System.out.println(e.getMessage());
      return 0;
    }

    return totalPris;
  }
}
