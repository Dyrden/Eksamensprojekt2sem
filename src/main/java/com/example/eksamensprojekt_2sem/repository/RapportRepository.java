package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.RapportModel;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class RapportRepository {

    public List<RapportModel> hentRapporterFraVognNummer(String vognNummer) {
        List<RapportModel> rapporter = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute
                ("CALL skafRapporterFraVognNummer('" + vognNummer + "')");
            while (resultSet.next()) {
                RapportModel rapport = new RapportModel();

                rapport.setId(resultSet.getInt(1));
                rapport.setDato(resultSet.getString(2));
                rapport.setVognNummer(resultSet.getString(3));
                rapport.setOverSkredetKM(resultSet.getString(4));
                rapporter.add(rapport);
                System.out.println(rapport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rapporter;
    }



    public RapportModel hentRapportFraRapportID(String rapportID) {
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
            e.printStackTrace();
        }

        return rapport;
    }


    public void tilføjNuværrendeKMTilRapport(String rapportID, int km) {
        SQLManager.update("CALL RapportKMNuSet(" + rapportID + ", " + km + ")");
    }


}
