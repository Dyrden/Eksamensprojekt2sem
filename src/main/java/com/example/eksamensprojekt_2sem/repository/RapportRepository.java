package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.RapportModel;
import com.example.eksamensprojekt_2sem.utility.SQLManager;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class RapportRepository {

    //Ferhat er ansvarlig for denne metode
    public List<RapportModel> hentRapporterFraVognNummer(String vognNummer) {
        List<RapportModel> rapporter = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute
                ("CALL skafRapportHvorVognNummerSpecifik('" + vognNummer + "')");
            while (resultSet.next()) {
                RapportModel rapport = new RapportModel();

                rapport.setId(resultSet.getInt(1));
                rapport.setDato(resultSet.getString(2));
                rapport.setVognNummer(resultSet.getString(3));
                rapport.setOverSkredetKM(resultSet.getString(4));
                rapporter.add(rapport);
                System.out.println(rapport);
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen rapporter fra vognnummer fundet.");
            System.out.println(e.getMessage());
        }

        return rapporter;
    }



/*    public RapportModel hentRapportFraRapportID(String rapportID) {
        RapportModel rapport = new RapportModel();
        try {
            ResultSet resultSet = SQLManager.execute
                ("CALL skafRapportFraVognNummer('" + rapportID + "')");
            while (resultSet.next()) {
                rapport.setId(resultSet.getInt(1));
                rapport.setDato(resultSet.getString(2));
                rapport.setVognNummer(resultSet.getString(3));
                rapport.setOverSkredetKM(resultSet.getString(4));
            }
        } catch (SQLException e) {
            System.err.println("Ingen rapport fundet.");
            System.out.println(e.getMessage());
            return null;
        }

        return rapport;
    }*/


    //Mark er ansvarlig for denne metode
    public void tilf??jNuv??rrendeKMTilRapport(String rapportID, int km) {
        SQLManager.update("CALL RapportKMNuSet(" + rapportID + ", " + km + ")");
    }


    //Mark er ansvarlig for denne metode
    public int findRapportIDFraBookingID(int bookingID) {
        int fundetID = 0;
        ResultSet resultSet = SQLManager.execute("CALL skafRapportFraBookingID(\"" + bookingID + "\")");
        try {
            resultSet.next();
            fundetID = resultSet.getInt(1);
        } catch (SQLException e ) {
            System.out.println("ingen rapport fundet");
        }
        return fundetID;
    }

    //Mark er ansvarlig for denne metode
    public void opretRapportFraBookingID(int bookingID) {
        SQLManager.update("CALL Rapport_OpretFraBookingID(\"" + bookingID + "\")");
    }

    //Mark er ansvarlig for denne metode
    public int findSlutKMFraRapportID(int rapportID) {
        int slutkm = 0;
        ResultSet resultSet = SQLManager.execute(" CALL skafSlutKilometerFraRapportID(\"" + rapportID + "\")");
        try {
            resultSet.next();
            slutkm = resultSet.getInt(1);
        } catch (SQLException e ) {
            System.out.println("ingen slutkm fundet");
        }
        return slutkm;

    }

    //Mark er ansvarlig for denne metode
    public void redigereSlutKMTilRapport(int rapportID, RapportModel rapportModel) {
        SQLManager.update(
            "CALL Rapport_RedigerSlutKilometerFraRapportID(" + rapportID + ", " + rapportModel.getOverskredetKM() + ")");
    }

    //Mark er ansvarlig for denne metode
    public int skafUdregnetKMK??rt(int bookingID) {
        int kmk??rt = 0;
        ResultSet resultSet = SQLManager.execute(
            "call skafKilometerKoert(" + bookingID + ")");
        try {
            resultSet.next();
            kmk??rt = resultSet.getInt(1);

        } catch (SQLException e) {
            System.out.println("fejl under udregning af kilometer k??rt");
        }

        return kmk??rt;
    }

    //Ferhat er ansvarlig for denne metode
    public double skafPrisPaaOverskredetKM(int bookingID){
        int antalM??nederBooket = 0;

        ResultSet resultSet = SQLManager.execute(
            "call skafAntalMaanederFraBookingID(" + bookingID + ")");
        try {
            resultSet.next();
            antalM??nederBooket = resultSet.getInt(1);

        } catch (SQLException e) {
            System.out.println("fejl under udregning af kilometer k??rt");
        }
        if (antalM??nederBooket == 0){
            antalM??nederBooket = 1;
        }
        double pris = 0;
        int kmK??rt = skafUdregnetKMK??rt(bookingID);

        int maksimaltKMTilladt = antalM??nederBooket*2000;

        if ((kmK??rt>maksimaltKMTilladt)){
            int kmOvertr??dt = kmK??rt-maksimaltKMTilladt;
            pris = kmOvertr??dt*0.75;
        }

        return pris;
    }

    //Ferhat er ansvarlig for denne metode
    public int skafAntalMaanederBooket(int bookingID){
        int antalM??nederBooket = 0;

        ResultSet resultSet = SQLManager.execute(
            "call skafAntalMaanederFraBookingID(" + bookingID + ")");
        try {
            resultSet.next();
            antalM??nederBooket = resultSet.getInt(1);

        } catch (SQLException e) {
            System.out.println("fejl under udregning af kilometer k??rt");
        }

        if (antalM??nederBooket == 0){
            antalM??nederBooket = 1;
        }

        return antalM??nederBooket;
    }

    // Ferhat er ansvarlig for metoden
    public int skafMaksimumKMTilladt(int bookingID){

        int antalM??nederBooket = 0;

        ResultSet resultSet = SQLManager.execute(
            "call skafAntalMaanederFraBookingID(" + bookingID + ")");
        try {
            resultSet.next();
            antalM??nederBooket = resultSet.getInt(1);

        } catch (SQLException e) {
            System.out.println("fejl under udregning af kilometer k??rt");
        }

        if (antalM??nederBooket == 0){
            antalM??nederBooket = 1;
        }
        int maksimaltKMTilladt = antalM??nederBooket*2000;


        return maksimaltKMTilladt;
    }

    //Ferhat er ansvarlig for denne metode
    public int skafKMOverskredet(int bookingID) {
        int antalM??nederBooket = 0;
        int kmOvertr??dt = 0;


        ResultSet resultSet = SQLManager.execute(
            "call skafAntalMaanederFraBookingID(" + bookingID + ")");
        try {
            resultSet.next();
            antalM??nederBooket = resultSet.getInt(1);

        } catch (SQLException e) {
            System.out.println("fejl under udregning af kilometer k??rt");
        }
        if (antalM??nederBooket == 0){
            antalM??nederBooket = 1;
        }
        int kmK??rt = skafUdregnetKMK??rt(bookingID);

        int maksimaltKMTilladt = antalM??nederBooket * 2000;

        if ((kmK??rt > maksimaltKMTilladt)) {
            kmOvertr??dt = kmK??rt - maksimaltKMTilladt;
        } else {
            return 0;
        }

        return kmOvertr??dt;
    }

    //Mark er ansvarlig for denne metode
    public void udregnKilometerK??rt(int bookingID,int slutkm) {
        SQLManager.execute(
            "call skafUdregnetKilometerKoertOgOpdaterBilOgRapport(" + bookingID + ", " + slutkm + ")");
    }

}
