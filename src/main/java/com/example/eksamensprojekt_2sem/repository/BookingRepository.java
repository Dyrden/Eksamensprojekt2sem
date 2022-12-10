package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.*;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookingRepository {

    public List<BookingModel> visAlleBookinger(){
        //Ferhat er ansvarlig for denne metode
        List<BookingModel> bookinger = new LinkedList<>();
        BookingModel booking = new BookingModel();
        try {
            ResultSet resultSet = SQLManager.execute("CALL visAlleBookings()");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int brugerID = resultSet.getInt(2);
                String type = resultSet.getString(3);
                String sted = resultSet.getString(4);
                String startDate = resultSet.getString(5);
                String slutDato = resultSet.getString(6);
                double maanedsPris = resultSet.getDouble(7);

                bookinger.add(new BookingModel(id, brugerID, type, sted, startDate, slutDato, maanedsPris));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return bookinger;

    }

    public double visSamletIndtaegt(){
        //Ferhat er ansvarlig for denne metode
        //Den viser ligenu samledeindtægt for bookede biler denne måned

        double indtaegt = 0;
        try {
            ResultSet resultSet = SQLManager.execute("CALL visAktiveBookingOgBilData()");

            while (resultSet.next()) {

                double maanedsPris = resultSet.getDouble(15);

                indtaegt += maanedsPris;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }


        return indtaegt;

    }
    public List<BilOgBookingModel> visAktiveBookinger(){
        //Ferhat er ansvarlig for denne metode
        List<BilOgBookingModel> biler = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL visAktiveBookingOgBilData()");

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
                double staalPris = resultSet.getDouble(10);
                double registreringsAfgift = resultSet.getDouble(11);
                double CO2Udledning = resultSet.getDouble(12);
                int produktionsaar = resultSet.getInt(13);
                int distance = resultSet.getInt(14);
                double maanedspris = resultSet.getDouble(15);
                int kilometerStart = resultSet.getInt(16);
                int id = resultSet.getInt(17);
                int brugerID = resultSet.getInt(18);
                String type = resultSet.getString(19);
                String sted = resultSet.getString(20);
                String startDate = resultSet.getString(21);
                String slutDato = resultSet.getString(22);

                biler.add(new BilOgBookingModel(vognNummer, stelNummer,maerke, model,energiType,gearboks,udstyr, status, farve,
                    staalPris, registreringsAfgift, CO2Udledning, produktionsaar, distance, maanedspris, id, brugerID, type, sted, startDate, slutDato));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return biler;

    }

    public void visBookingHistorik(String s){
        //SQLManager.makeStatement("CALL VisBookningHistorik()");

    }
    public void lavBooking(String vognNummer, int BrugerID,int abonnementsType,int sted,String udlejningsStartDato, String udlejningsSlutDato, int kilometerStart){ // Kristian
        // Format:
        // vognnummer,BrugerID,abonnementstype,sted,udlejningsStartDato,udlejningsSlutDato,kilometerStart
        SQLManager.update("CALL BookingOpret('"+ vognNummer +"','"+ BrugerID +"','"+ abonnementsType +"','"+ sted +"','"+ udlejningsStartDato +"','"+ udlejningsSlutDato +"','"+ kilometerStart +"')");

    }

    public List<UdleveringsstedModel> visAlleUdleveringsSteder() { //Kristian
        List<UdleveringsstedModel> udleveringssteder = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL visAlleUdleveringsSteder()");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String sted = resultSet.getString(2);
                udleveringssteder.add(new UdleveringsstedModel(id, sted));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return udleveringssteder;

    }

    public List<AbonnementsTypeModel> visAlleAbonnementsTyper() { //Kristian
        List<AbonnementsTypeModel> abonnementsTyper = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL visAlleAbonnementsTyper()");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String type = resultSet.getString(2);
                abonnementsTyper.add(new AbonnementsTypeModel(id, type));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abonnementsTyper;

    }

}
