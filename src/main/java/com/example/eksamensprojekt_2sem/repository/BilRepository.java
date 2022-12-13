package com.example.eksamensprojekt_2sem.repository;


import com.example.eksamensprojekt_2sem.model.*;
import com.example.eksamensprojekt_2sem.model.bilmodel.*;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BilRepository {

    public BilRepository() {
    }

    //Ansvarlig : Mark Dyrby Denner, Ferhat Baran, Bjørn Uffe Haastrup
    // Denne metode søger databasen ved hjælp af et procedure til at finde biler
    // der har statusen "ikke udlejet" og retunerer en liste af dem.
    public List<BilModel> visTilgaengeligeBiler() {
        //Mark er ansvarlig for denne metode
        List<BilModel> biler = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL skafTilgængeligeBiler");

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
                double maanedsPris = resultSet.getDouble(15);

                biler.add(new BilModel(vognNummer, stelNummer, maerke, model, energiType, gearboks, udstyr, status, farve,
                    staalPris, registreringsAfgift, CO2Udledning, produktionsaar, distance, maanedsPris));
            }

        } catch (SQLException e) {
            System.err.println("Ingen tilgængelige biler fundet.");
            System.out.println(e.getMessage());
        }

        return biler;

    }

    public List<BilModel> visAlleBiler() { //Ferhat

        List<BilModel> biler = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL skafAlleBiler()");

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

                biler.add(new BilModel(vognNummer, stelNummer, maerke, model, energiType, gearboks, udstyr, status, farve,
                    staalPris, registreringsAfgift, CO2Udledning, produktionsaar, distance));
            }

        } catch (SQLException e) {
            System.err.println("Ingen biler fundet.");
            System.out.println(e.getMessage());
        }

        return biler;

    }

    //Ansvarlig : Mark Dyrby Denner
    // Denne metode søger databasen for 'farver' og retunerer en liste af dem
    public LinkedList<FarveModel> skafFarver() {
        LinkedList<FarveModel> farveModels = new LinkedList<>();

        ResultSet rs = SQLManager.execute("CALL skaffarver()");

        try {
            while (rs.next()) {
                FarveModel farveModel = new FarveModel();
                farveModel.setFarveID(rs.getInt(1));
                farveModel.setFarve(rs.getString(2));
                farveModels.add(farveModel);
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen farver fundet.");
            System.out.println(e.getMessage());
        }
        return farveModels;
    }


    //Ansvarlig : Mark Dyrby Denner
    // Denne metode søger databasen for 'mærker' og retunerer en liste af dem
    public LinkedList<MaerkeModel> skafMaerker() {
        LinkedList<MaerkeModel> maerkeModels = new LinkedList<>();

        ResultSet rs = SQLManager.execute("CALL skafmaerker()");

        try {
            while (rs.next()) {
                MaerkeModel maerkeModel = new MaerkeModel();
                maerkeModel.setMaerkeID(rs.getInt(1));
                maerkeModel.setMaerke(rs.getString(2));
                maerkeModels.add(maerkeModel);
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen bilmærker fundet.");
            System.out.println(e.getMessage());
        }
        return maerkeModels;
    }


    //Ansvarlig : Mark Dyrby Denner
    // Denne metode søger databasen for 'energityper' og retunerer en liste af dem
    public LinkedList<EnergiTypeModel> skafEnergiTyper() {
        LinkedList<EnergiTypeModel> energiTypeModels = new LinkedList<>();

        ResultSet rs = SQLManager.execute("CALL skafenergityper()");

        try {
            while (rs.next()) {
                EnergiTypeModel energiTypeModel = new EnergiTypeModel();
                energiTypeModel.setEnergiTypeID(rs.getInt(1));
                energiTypeModel.setEnergiType(rs.getString(2));
                energiTypeModels.add(energiTypeModel);
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen energityper fundet.");
            System.out.println(e.getMessage());
        }
        return energiTypeModels;
    }

    //Ansvarlig : Mark Dyrby Denner
    // Denne metode søger databasen for 'udstyrniveau'r og retunerer en liste af dem
    public LinkedList<UdstyrsniveauModel> skafUdstyrsNiveau() {
        LinkedList<UdstyrsniveauModel> udstyrsniveauModels = new LinkedList<>();

        ResultSet rs = SQLManager.execute("CALL skafudstyrsniveau()");

        try {
            while (rs.next()) {
                UdstyrsniveauModel udstyrsniveauModel = new UdstyrsniveauModel();
                udstyrsniveauModel.setUdstyrsniveauID(rs.getInt(1));
                udstyrsniveauModel.setUdstyrsniveau(rs.getString(2));
                udstyrsniveauModels.add(udstyrsniveauModel);
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen udstyrsniveauer fundet.");
            System.out.println(e.getMessage());
        }
        return udstyrsniveauModels;
    }

    //Ansvarlig : Mark Dyrby Denner
    // Denne metode søger databasen for 'gearboks's og retunerer en liste af dem
    public LinkedList<GearboksModel> skafGearboks() {
        LinkedList<GearboksModel> gearboksModels = new LinkedList<>();

        ResultSet rs = SQLManager.execute("CALL skafgearboks()");

        try {
            while (rs.next()) {
                GearboksModel gearboksModel = new GearboksModel();
                gearboksModel.setGearboksID(rs.getInt(1));
                gearboksModel.setGearboks(rs.getString(2));
                gearboksModels.add(gearboksModel);
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen gearbokse fundet.");
            System.out.println(e.getMessage());
        }
        return gearboksModels;
    }


    public LinkedList<BilOgBookingModel> visInleveretBiler() { //Mark, Bjørn og Ferhat
        LinkedList<BilOgBookingModel> biler = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL skafBilerManglerOvervaagning()");
            while (resultSet.next()) {
                BilOgBookingModel bilModel = new BilOgBookingModel();
                bilModel.setVognNummer(resultSet.getString(1));
                bilModel.setStelNummer(resultSet.getString(2));
                bilModel.setMaerke(resultSet.getString(3));
                bilModel.setModel(resultSet.getString(4));
                bilModel.setId(resultSet.getInt(17));
                bilModel.setSlutDato(resultSet.getString(22));
                biler.add(bilModel);
            }

        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen indleveret biler fundet.");
            System.out.println(e.getMessage());
        }
        return biler;

    }


    //Ansvarlig : Mark Dyrby Denner
    // Denne metode tager imod en bilmodel og laver en insert call til databasen
    public void opretBil(String vognnummer,
                         String stelnummer,
                         int modelID,
                         double staalpris,
                         double registreringsafgift,
                         double co2udledning,
                         int produktionsaar,
                         int kilometertal,
                         double maanedspris) {
        SQLManager.update(
            "CALL Bil_Opret(\""
                + vognnummer + "\", \""
                + stelnummer + "\", \""
                + staalpris + "\", \""
                + registreringsafgift + "\", \""
                + co2udledning + "\", \""
                + produktionsaar + "\", \""
                + kilometertal + "\", \""
                + maanedspris + "\", \""
                + modelID + "\")");
        System.out.println("lavede bil");
    }


    public BilModel visSpecifikBil(String vognNummer) {//Ferhat og Kristian er ansvarlig for denne metode

        BilModel bil = new BilModel();
        try {
            ResultSet resultSet = SQLManager.execute
                ("CALL skafSpecifikBilFraVognNum('" + vognNummer + "')");
            while (resultSet.next()) {
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
        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen bil blev fundet.");
            System.out.println(e.getMessage());
        }

        return bil;


    }

/*    public Object sUVisning(String s) { //Bjørn
        BilModel bilModel = null;
        try {

            ResultSet resultSet =
                SQLManager.execute("CALL VisSpecifikBil('" + s + "')");
            while (resultSet.next()) {
                try {
                    bilModel.setVognNummer(resultSet.getString(1));
                    bilModel.setStelNummer(resultSet.getString(2));
                    bilModel.setMaerkeID(resultSet.getInt(3));
                    bilModel.setModelID(resultSet.getInt(4));
                } catch (NullPointerException e) {
                    System.out.println("i got nothing");
                }

            }
        } catch (SQLException e) {
            System.err.println("Ingen bil blev fundet.");
            System.out.println(e.getMessage());
            return new LinkedList<SkadeModel>();
        }
        return bilModel;
    }*/


    public List<BilModel> vaelgKaldFraParametre(String parameterTekst) { //Kristian og Mark

        List<BilModel> biler;

        String[] parametre = parameterTekst.split(","); //parameterText bliver delt op i dens kommaer, op til 5 gange for at være acceptabelt.

        String defineretProcedure = switch (parametre.length) { //En bedre måde på at gøre tingene i en enkel metode i stedet for 5.
            case 1 -> "CALL skafbileraf1parameter('" + parametre[0] + "')";
            case 2 -> "CALL skafbileraf2parametre('" + parametre[0] + "','" + parametre[1] + "')";
            case 3 ->
                "CALL skafbileraf3parametre('" + parametre[0] + "','" + parametre[1] + "','" + parametre[2] + "')";
            case 4 ->
                "CALL skafbileraf4parametre('" + parametre[0] + "','" + parametre[1] + "','" + parametre[2] + "','" + parametre[3] + "')";
            case 5 ->
                "CALL skafbileraf5parametre('" + parametre[0] + "','" + parametre[1] + "','" + parametre[2] + "','" + parametre[3] + "','" + parametre[4] + "')";

            default -> throw new IllegalStateException("Unexpected value: " + parametre.length);
        };

        biler = returnerListeBilerAfSpecifikCall(defineretProcedure);

        return biler;
    }

    private List<BilModel> returnerListeBilerAfSpecifikCall(String definéretProcedure) { //Kristian
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
                double maanedsPris = resultSet.getDouble(15);

                biler.add(new BilModel(vognNummer, stelNummer, maerke, model, energiType, gearboks, udstyr, status, farve,
                    staalPris, registreringsAfgift, CO2Udledning, produktionsaar, distance, maanedsPris));
            }

        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen biler fundet med søgeparametre.");
            System.out.println(e.getMessage());
        }
        return biler;
    }

/*    public List<String> skafAlleFarver() { //Ferhat
        List<String> farver = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL visAlleFarver()");

            while (resultSet.next()) {
                String farve = resultSet.getString(1);
                farver.add(farve);
            }

        } catch (SQLException e) {
            System.err.println("Ingen farver/ikke alle farver blev fundet.");
            System.out.println(e.getMessage());
            return new LinkedList<String>();
        }

        return farver;

    }*/

/*    public List<String> skafAlleMaerker() {
        List<String> maerker = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL MaerkerFind()");

            while (resultSet.next()) {
                String maerke = resultSet.getString(2);
                maerker.add(maerke);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maerker;

    }*/

/*    public List<String> skafGearbokse() {
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

    }*/

/*    public List<String> skafenergiTyper() {
        List<String> liste = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL EnergityperFind()");

            while (resultSet.next()) {
                String item = resultSet.getString(2);
                liste.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return liste;

    }*/


    //Ansvarlig : Mark Dyrby Denner
    // Denne metode bruger en procedure der står for at finde alle 'model's som har præcis
    // de samme værdier i databasen og returnerer ID'et på denne. Hvis den ikke findes
    // returneres 0.
    public int findModel(String model, String energitype, String gearboks, String udstyrsniveau, String maerke, String farve) {
        BilModelModel bilModel = new BilModelModel(model, energitype, gearboks, udstyrsniveau, maerke, farve);
        int modelID = 0;
        try {
            ResultSet rs = SQLManager.execute(
                "CALL skafModelMedPraeciseParametre(\""
                    + bilModel.getModel() + "\", \""
                    + bilModel.getEnergiType() + "\", \""
                    + bilModel.getGearboks() + "\", \""
                    + bilModel.getUdstyrsNiveau() + "\", \""
                    + bilModel.getMaerke() + "\", \""
                    + bilModel.getFarve() + "\")");
            rs.next();
            modelID = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("No model found by parameters");
        }

        return modelID;
    }


    //Ansvarlig : Mark Dyrby Denner
    //Denne metode tager imod en bil's 'model' og, ved brug af en procedure, indsætter den
    // i databasen
    public void opretModel(String model, String energiType, String gearboks, String udstyrsniveau, String maerke, String farve) {
        SQLManager.update(
            "CALL Model_Opret(\""
                + model + "\", \""
                + energiType + "\", \""
                + gearboks + "\", \""
                + udstyrsniveau + "\", \""
                + maerke + "\", \""
                + farve + "\")");

        System.out.println("lavede model");
    }

    public BilModel skafBilFraBookingID(int bookingID) { //Mark

        BilModel bilModel = new BilModel();
        ResultSet resultSet = SQLManager.execute("CALL skafBilFraBookingID(\"" + bookingID + "\")");

        try {
            resultSet.next();
            bilModel.setVognNummer(resultSet.getString(1));
            bilModel.setStelNummer(resultSet.getString(2));
            bilModel.setMaerke(resultSet.getString(3));
            bilModel.setModel(resultSet.getString(4));

        } catch (SQLException e) {
            System.out.println("ingen bil fundet");
        }
        return bilModel;
    }

    /*
    public BilModel skafBilFraVognnummer(String vognnummer) {
        BilModel bilModel = new BilModel();
        ResultSet resultSet = SQLManager.execute("CALL skafBilFraVognNummer(\"" + vognnummer + "\")");

        try {
            resultSet.next();
            bilModel.setVognNummer(resultSet.getString(1));
            bilModel.setStelNummer(resultSet.getString(2));
            bilModel.setMaerke(resultSet.getString(3));
            bilModel.setModel(resultSet.getString(4));

        } catch (SQLException e ) {
            System.out.println("ingen bil fundet");
        }
        return bilModel;

    }
    * */

  /*
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
  * */
}
