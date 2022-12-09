package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.BilModel;
import com.example.eksamensprojekt_2sem.model.UdleveringsstedModel;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

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

    public List<BilModel> visTilgaengeligeBiler(){
      //Mark er ansvarlig for denne metode
        List<BilModel> biler = new LinkedList<>();
        try {
       ResultSet resultSet = SQLManager.execute("CALL visTilgængeligeBiler()");

            while (resultSet.next()) {
                String vognNummer = resultSet.getString(1);
                String stelNummer = resultSet.getString(2);
             String maerke = resultSet.getString(3);
             String model = resultSet.getString(4);
             String energiType = resultSet.getString(5);
             String gearboks = resultSet.getString(6);
             String udstyr = resultSet.getString(7);
             String status = resultSet.getString(8);
             String farve = resultSet.getString(9);
             double staalPris = resultSet.getInt(10);
             double registreringsAfgift = resultSet.getInt(11);
             double CO2Udledning = resultSet.getInt(12);
             int produktionsaar = resultSet.getInt(13);
             int distance = resultSet.getInt(14);
             double maanedsPris = resultSet.getDouble(14);

                biler.add(new BilModel(vognNummer, stelNummer,maerke, model,energiType,gearboks,udstyr, status, farve,
                                            staalPris, registreringsAfgift, CO2Udledning, produktionsaar, distance, maanedsPris));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return biler;

    }
  public List<BilModel> visAlleBiler(){
    //Mark er ansvarlig for denne metode
    List<BilModel> biler = new LinkedList<>();
    try {
      ResultSet resultSet = SQLManager.execute("CALL visAlleBiler()");

      while (resultSet.next()) {
        String vognNummer = resultSet.getString(1);
        String stelNummer = resultSet.getString(2);
        String maerke = resultSet.getString(3);
        String model = resultSet.getString(4);
        String energiType = resultSet.getString(5);
        String gearboks = resultSet.getString(6);
        String udstyr = resultSet.getString(7);
        String status = resultSet.getString(8);
        String farve = resultSet.getString(9);
        double staalPris = resultSet.getInt(10);
        double registreringsAfgift = resultSet.getInt(11);
        double CO2Udledning = resultSet.getInt(12);
        int produktionsaar = resultSet.getInt(13);
        int distance = resultSet.getInt(14);

        biler.add(new BilModel(vognNummer, stelNummer,maerke, model,energiType,gearboks,udstyr, status, farve,
            staalPris, registreringsAfgift, CO2Udledning, produktionsaar, distance));
      }

    } catch (SQLException e){
      e.printStackTrace();
    }

    return biler;

  }

    public Object visInleveretBiler(){
        List<BilModel> biler = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL BilerSkaderMangler()");
            while (resultSet.next()){
                String maerke = resultSet.getString(1);
                String model = resultSet.getString(2);
                String vognNummer = resultSet.getString(3);
                String stelNummer = resultSet.getString(4);
                biler.add(new BilModel(maerke,model,vognNummer,stelNummer));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return biler;

    }
    public Object LavBil(String s){
        return SQLManager.makeStatement("CALL LavBil()");

    }


    public BilModel visSpecifikBil(String vognNummer){
      //Ferhat og Kristian er ansvarlig for denne metode

      BilModel bil = new BilModel();
      try{
          ResultSet resultSet = SQLManager.execute
                  ("CALL BilVognnummerFind('"+vognNummer+"')");
          while (resultSet.next()){
            bil.setVognNummer(resultSet.getString(1));
            bil.setStelNummer(resultSet.getString(2));
              bil.setMaerke(resultSet.getString(3));
              bil.setModel(resultSet.getString(4));
              bil.setEnergiType(resultSet.getString(5));
              bil.setGearboks(resultSet.getString(6));
              bil.setUdstyr(resultSet.getString(7));
              bil.setStatus(resultSet.getString(8));
              bil.setFarve(resultSet.getString(9));
              bil.setStaalPris(resultSet.getDouble(10));
              bil.setRegistreringsAfgift(resultSet.getDouble(11));
              bil.setCO2Udledning(resultSet.getDouble(12));
              bil.setProduktionsaar(resultSet.getInt(13));
              bil.setDistance(resultSet.getInt(14));
          }
        System.out.println(bil);
      } catch (SQLException e){
          e.printStackTrace();
      }

      return bil;


    }

    public Object sUVisning(String s){
        BilModel bilModel = null;
        try {

            ResultSet resultSet =
                    SQLManager.execute("CALL VisSpecifikBil('" + s + "')");
            while (resultSet.next()){
                try {
                bilModel.setVognNummer(resultSet.getString(1));
                bilModel.setStelNummer(resultSet.getString(2));
                bilModel.setMaerkeID(resultSet.getInt(3));
                bilModel.setModelID(resultSet.getInt(4));
                }catch (NullPointerException e){
                    System.out.println("i got nothing");
                }

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return bilModel;
    }


    public List<BilModel> chooseCallFromParameter(String parameterTekst){

        List<BilModel> biler = new LinkedList<>();

        String[] parametre = parameterTekst.split(","); //parameterText bliver delt op i dens kommaer, op til 5 gange for at være acceptabelt.

        String defineretProcedure = switch (parametre.length) { //En bedre måde på at gøre tingene i en enkel metode i stedet for 5.
            case 1 -> "CALL BilerFind1Param('" + parametre[0] + "')";
            case 2 -> "CALL BilerFind2Param('" + parametre[0] + "','" + parametre[1] + "')";
            case 3 -> "CALL BilerFind3Param('" + parametre[0] + "','" + parametre[1] + "','" + parametre[2] + "')";
            case 4 -> "CALL BilerFind4Param('" + parametre[0] + "','" + parametre[1] + "','" + parametre[2] + "','" + parametre[3] + "')";
            case 5 -> "CALL BilerFind5Param('" + parametre[0] + "','" + parametre[1] + "','" + parametre[2] + "','" + parametre[3] + "','" + parametre[4] + "')";

            default -> throw new IllegalStateException("Unexpected value: " + parametre.length);
        };

        biler = returnerListeBilerAfSpecifikCall(defineretProcedure);

        return biler;
    }

    private List<BilModel> returnerListeBilerAfSpecifikCall(String definéretProcedure) {
        List<BilModel> biler = new LinkedList<>();

        try {
            ResultSet resultSet = SQLManager.execute(definéretProcedure);

            while (resultSet.next()) {
                String vognNummer = resultSet.getString(1);
                String stelNummer = resultSet.getString(2);
                String maerke = resultSet.getString(3);
                String model = resultSet.getString(4);
                String energiType = resultSet.getString(5);
                String gearboks = resultSet.getString(6);
                String udstyr = resultSet.getString(7);
                String status = resultSet.getString(8);
                String farve = resultSet.getString(9);
                double staalPris = resultSet.getInt(10);
                double registreringsAfgift = resultSet.getInt(11);
                double CO2Udledning = resultSet.getInt(12);
                int produktionsaar = resultSet.getInt(13);
                int distance = resultSet.getInt(14);
                double maanedsPris = resultSet.getDouble(14);

                biler.add(new BilModel(vognNummer, stelNummer,maerke, model,energiType,gearboks,udstyr, status, farve,
                        staalPris, registreringsAfgift, CO2Udledning, produktionsaar, distance, maanedsPris));
            }

        } catch (SQLException e){
            System.err.println("Ingen biler fundet med søgeparametre.");
            System.out.println(e.getMessage());
            return new LinkedList<BilModel>();
        }
        return biler;
    }
  public List<String> skafAlleFarver() {
    List<String> farver = new LinkedList<>();
    try {
      ResultSet resultSet = SQLManager.execute("CALL visAlleFarver()");

      while (resultSet.next()) {
       String farve = resultSet.getString(1);
        farver.add(farve);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return farver;

  }
  public List<String> skafAlleMaerker() {
    List<String> maerker = new LinkedList<>();
    try {
      ResultSet resultSet = SQLManager.execute("CALL skafmaerker()");

      while (resultSet.next()) {
        String maerke = resultSet.getString(2);
        maerker.add(maerke);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return maerker;

  }
  public List<String> skafGearbokse() {
    List<String> liste = new LinkedList<>();
    try {
      ResultSet resultSet = SQLManager.execute("CALL skafgearboks()");

      while (resultSet.next()) {
        String item = resultSet.getString(2);
        liste.add(item);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return liste;

  }
  public List<String> skafenergiTyper() {
    List<String> liste = new LinkedList<>();
    try {
      ResultSet resultSet = SQLManager.execute("CALL skafenergityper()");

      while (resultSet.next()) {
        String item = resultSet.getString(2);
        liste.add(item);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return liste;

  }
  public List<String> skafUdstyrsNiveau() {
    List<String> liste = new LinkedList<>();
    try {
      ResultSet resultSet = SQLManager.execute("CALL skafudstyrsniveau()");

      while (resultSet.next()) {
        String item = resultSet.getString(2);
        liste.add(item);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return liste;

  }
}
