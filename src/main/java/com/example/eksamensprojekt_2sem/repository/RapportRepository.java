package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.RapportModel;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class RapportRepository {

    public List<RapportModel> hentRapporterFraVognNummer(String vognNummer) { //Ferhat
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


    public void tilføjNuværrendeKMTilRapport(String rapportID, int km) { //Mark
        SQLManager.update("CALL RapportKMNuSet(" + rapportID + ", " + km + ")");
    }


    public int findRapportIDFraBookingID(int bookingID) { //Mark
        int fundetID = 0;
        ResultSet resultSet = SQLManager.execute("CALL skafRapportFraBookingID(\"" + bookingID + "\")");
        try {
            resultSet.next();
            fundetID = resultSet.getInt(1);
        } catch (SQLException e) {
            System.out.println("ingen rapport fundet");
        }
        return fundetID;
    }

    public void opretRapportFraBookingID(int bookingID) { //Mark
        SQLManager.update("CALL Rapport_OpretFraBookingID(\"" + bookingID + "\")");
    }

    public int findSlutKMFraRapportID(int rapportID) { //Mark
        int slutkm = 0;
        ResultSet resultSet = SQLManager.execute(" CALL skafSlutKilometerFraRapportID(\"" + rapportID + "\")");
        try {
            resultSet.next();
            slutkm = resultSet.getInt(1);
        } catch (SQLException e) {
            System.out.println("ingen slutkm fundet");
        }
        return slutkm;

    }

    public void redigereSlutKMTilRapport(int rapportID, RapportModel rapportModel) {//Mark
        SQLManager.update(
            "CALL Rapport_RedigerSlutKilometerFraRapportID(" + rapportID + ", " + rapportModel.getOverskredetKM() + ")");
    }

    public int skafUdregnetKMKørt(int bookingID) {//Mark
        int kmkørt = 0;
        ResultSet resultSet = SQLManager.execute(
            "call skafKilometerKoert(" + bookingID + ")");
        try {
            resultSet.next();
            kmkørt = resultSet.getInt(1);

        } catch (SQLException e) {
            System.out.println("fejl under udregning af kilometer kørt");
        }

        return kmkørt;
    }

    public double skafPrisPaaOverskredetKM(int bookingID) { //Ferhat
        int antalMånederBooket = 0;

        ResultSet resultSet = SQLManager.execute(
            "call skafAntalMaanederFraBookingID(" + bookingID + ")");
        try {
            resultSet.next();
            antalMånederBooket = resultSet.getInt(1);

        } catch (SQLException e) {
            System.out.println("fejl under udregning af kilometer kørt");
        }
        if (antalMånederBooket == 0) {
            antalMånederBooket = 1;
        }
        double pris = 0;
        int kmKørt = skafUdregnetKMKørt(bookingID);

        int maksimaltKMTilladt = antalMånederBooket * 2000;

        if ((kmKørt > maksimaltKMTilladt)) {
            int kmOvertrådt = kmKørt - maksimaltKMTilladt;
            pris = kmOvertrådt * 0.75;
        }

        return pris;
    }

    public int skafAntalMaanederBooket(int bookingID) { //Ferhat
        int antalMånederBooket = 0;

        ResultSet resultSet = SQLManager.execute(
            "call skafAntalMaanederFraBookingID(" + bookingID + ")");
        try {
            resultSet.next();
            antalMånederBooket = resultSet.getInt(1);

        } catch (SQLException e) {
            System.out.println("fejl under udregning af kilometer kørt");
        }

        if (antalMånederBooket == 0) {
            antalMånederBooket = 1;
        }

        return antalMånederBooket;
    }

    public int skafMaksimumKMTilladt(int bookingID) { // Ferhat er ansvarlig for metoden

        int antalMånederBooket = 0;

        ResultSet resultSet = SQLManager.execute(
            "call skafAntalMaanederFraBookingID(" + bookingID + ")");
        try {
            resultSet.next();
            antalMånederBooket = resultSet.getInt(1);

        } catch (SQLException e) {
            System.out.println("fejl under udregning af kilometer kørt");
        }

        if (antalMånederBooket == 0) {
            antalMånederBooket = 1;
        }

        int maksimalKMKørtPerMåned = 2000;

        return antalMånederBooket * maksimalKMKørtPerMåned;
    }

    public int skafKMOverskredet(int bookingID) { //Ferhat
        int antalMånederBooket = 0;
        int kmOvertrådt = 0;


        ResultSet resultSet = SQLManager.execute(
            "call skafAntalMaanederFraBookingID(" + bookingID + ")");
        try {
            resultSet.next();
            antalMånederBooket = resultSet.getInt(1);

        } catch (SQLException e) {
            System.out.println("fejl under udregning af kilometer kørt");
        }
        if (antalMånederBooket == 0) {
            antalMånederBooket = 1;
        }
        int kmKørt = skafUdregnetKMKørt(bookingID);

        int maksimaltKMTilladt = antalMånederBooket * 2000;

        if ((kmKørt > maksimaltKMTilladt)) {
            kmOvertrådt = kmKørt - maksimaltKMTilladt;
        }

        return kmOvertrådt;
    }

    public void udregnKilometerKørt(int bookingID, int slutkm) { //Mark
        SQLManager.execute(
            "call skafUdregnetKilometerKoertOgOpdaterBilOgRapport(" + bookingID + ", " + slutkm + ")");
    }

}
