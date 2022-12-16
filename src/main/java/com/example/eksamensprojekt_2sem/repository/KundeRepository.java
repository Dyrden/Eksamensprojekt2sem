package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.BrugerModel;
import com.example.eksamensprojekt_2sem.utility.SQLManager;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class KundeRepository {

    //Ferhat og Kristian er ansvarlig for denne metode
    public List<BrugerModel> visAlleBrugere() {
        List<BrugerModel> brugere = new LinkedList<>();

        try {
            ResultSet resultSet = SQLManager.execute("CALL skafAlleBrugere()");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fornavn = resultSet.getString(2);
                String efternavn = resultSet.getString(3);
                String email = resultSet.getString(4);
                String tlf = resultSet.getString(5);
                String cpr = resultSet.getString(6);

                brugere.add(new BrugerModel(id, fornavn, efternavn, email, tlf, cpr));
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen brugere fundet.");
            System.out.println(e.getMessage());
        }
        return brugere;
    }


    //Kristian er ansvarlig for denne metode
    public void opretKunde(String fornavn, String efternavn, String email, String tlf, String cpr) {
        // Format:
        // fornavn,efternavn,email,tlf,cpr
        SQLManager.update("CALL Bruger_Opret('" + fornavn + "','" + efternavn + "','" + email + "','" + tlf + "','" + cpr + "')");
    }

    //Kristian er ansvarlig for denne metode
    public int getNyesteKundeID() {// Metoden skal returnere det nyeste kunde ID, så websiden ved, hvilken kunde den skal forbinde den nye booking til.

        int nyesteKundeID = 0;

        try {
            ResultSet resultSet = SQLManager.execute("CALL skafHoejsteKundeID()");

            resultSet.next(); //Der er kun en enkel linje i denne query, så dette er nødvendigt.

            nyesteKundeID = resultSet.getInt(1);

        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen kunde fundet.");
            System.out.println(e.getMessage());
        }

        return nyesteKundeID;

    }


    //Kristian er ansvarlig for denne metode
    public List<BrugerModel> skafBrugerFraCPR(String brugerCPR) {

        List<BrugerModel> brugere = new LinkedList<>();

        try {
            ResultSet resultSet = SQLManager.execute("CALL skafBrugerFraCPR('" + brugerCPR + "')");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fornavn = resultSet.getString(2);
                String efternavn = resultSet.getString(3);
                String email = resultSet.getString(4);
                String tlf = resultSet.getString(5);
                String cpr = resultSet.getString(6);

                brugere.add(new BrugerModel(id, fornavn, efternavn, email, tlf, cpr));
            }
        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen bruger fundet.");
            System.out.println(e.getMessage());
        }
        return brugere;
    }
}
