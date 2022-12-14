package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.SkadeModel;
import com.example.eksamensprojekt_2sem.utility.SQLManager;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class SkadeRepository {

    //Ferhat og Kristian er ansvarlig for denne metode
    public List<SkadeModel> skafSkaderFraBookingID(int id) {

        List<SkadeModel> skader = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute
                ("CALL skafSkaderFraBookingID('" + id + "')");
            while (resultSet.next()) {
                int skadeid = (resultSet.getInt(1));
                String skadensPlacering = (resultSet.getString(2));
                String skadensBeskrivelse = (resultSet.getString(3));
                double skadensPris = (resultSet.getDouble(4));
                int rapportID = (resultSet.getInt(5));

                skader.add(new SkadeModel(skadeid, skadensPlacering, skadensBeskrivelse, skadensPris, rapportID));
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen rapporter/skader fundet.");
            System.out.println(e.getMessage());
        }

        return skader;
    }

/*    public void tilfoejSkade(String placering, String beskrivelse, double pris, int rapportID) {
        //Ferhat er ansvarlig for denne metode
        ResultSet resultSet = SQLManager.execute
            ("CALL TilfoejSkade('" + beskrivelse + "','" + placering + "'," + pris + "," + rapportID + ")");

        System.out.println(placering + beskrivelse + pris + rapportID);
    }*/

    //Ferhat er ansvarlig for denne metode
    public void sletSkade(int skadeID) {
        ResultSet resultSet = SQLManager.execute
            ("CALL Skade_Slet(\"" + skadeID + "\")");
    }

/*    public void beregnAntalKM() { //Ferhat
        int bilensKMTal = 3400; // distance
        int kilometerStart = 1000; // kilometerStart
        double betaling = 0; // ekstra betaling

        //Hvor meget bilen har k??rt
        int antalKMK??rt = bilensKMTal - kilometerStart; //2400 km k??rt

        if (antalKMK??rt > 2000) {
            // Hvor bilen er k??rt over 2000km
            int overskredetKM = antalKMK??rt - 2000; //400 km over gr??nsen

            //Hvor meget der skal betales
            betaling = antalKMK??rt * 0.75; //300 kr.
        }

    }*/

/*    public double skafTotalPrisFraRapportID(int id) {
        //Ferhat og Kristian er ansvarlig for denne metode

        int totalPris = 0;
        List<SkadeModel> skader = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute
                ("CALL skafSkaderFraRapportID('" + id + "')");
            while (resultSet.next()) {
                int skadeid = (resultSet.getInt(1));
                String skadensPlacering = (resultSet.getString(2));
                String skadensBeskrivelse = (resultSet.getString(3));
                double skadensPris = (resultSet.getDouble(4));
                int rapportID = (resultSet.getInt(5));

                totalPris += skadensPris;
            }
        } catch (SQLException e) {
            System.err.println("Ingen skader/skadepris fundet.");
            System.out.println(e.getMessage());
            return 0;
        }

        return totalPris;
    }*/

    //Mark er ansvarlig for denne metode
    public void opretSkadeP??Rapport(int rapportID, SkadeModel skadeModel) {
        SQLManager.update(
            "CALL Skade_Opret(\""
                + rapportID + "\",\""
                + skadeModel.getSkadensPlacering() + "\",\""
                + skadeModel.getSkadensBeskrivelse() + "\",\""
                + skadeModel.getSkadensPris()+ "\")");

    }

    //Kristian er ansvarlig for denne metode
    public double skafTotalPrisFraSkadeListe(List<SkadeModel> skadeListe) {

        double total = 0;

        for(SkadeModel skade : skadeListe){
            total += skade.getSkadensPris();
        }

        return total;
    }
}
