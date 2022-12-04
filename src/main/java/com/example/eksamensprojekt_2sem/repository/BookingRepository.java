package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.BilModel;
import com.example.eksamensprojekt_2sem.model.BookingModel;
import com.example.eksamensprojekt_2sem.service.SQLManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookingRepository {
    @Value("${JDBCUrl}")
    private String dbUrl;

    @Value("${JDBCUsername}")
    private String uID;

    @Value("${JDBCPassword}")
    private String pass;

    public List<BookingModel> visAlleBookinger(){
        //Ferhat er ansvarlig for denne metode
        List<BookingModel> bookinger = new LinkedList<>();
        BookingModel booking = new BookingModel();
        try {
            ResultSet resultSet = SQLManager.execute("CALL visAlleBookings()",dbUrl,uID,pass);

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
        //Den viser ligenu samledeindtægt for alle biler

        List<BookingModel> bookinger = new LinkedList<>();
        BookingModel booking = new BookingModel();
        double indtaegt = 0;
        try {
            ResultSet resultSet = SQLManager.execute("CALL visAlleBookings()",dbUrl,uID,pass);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int brugerID = resultSet.getInt(2);
                String type = resultSet.getString(3);
                String sted = resultSet.getString(4);
                String startDate = resultSet.getString(5);
                String slutDato = resultSet.getString(6);
                double maanedsPris = resultSet.getDouble(7);

                indtaegt += maanedsPris;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return indtaegt;

    }
    public List<BilModel> visAktiveBookinger(){
        //Ferhat er ansvarlig for denne metode
        List<BilModel> biler = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL VisAktiveBookingBiler()",dbUrl,uID,pass);

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
                double maanedspris = resultSet.getDouble(15);

                biler.add(new BilModel(vognNummer, stelNummer,maerke, model,energiType,gearboks,udstyr, status, farve,
                    staalPris, registreringsAfgift, CO2Udledning, produktionsaar, distance, maanedspris));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return biler;

    }

    public void visBookingHistorik(String s){
        //SQLManager.makeStatement("CALL VisBookningHistorik()");

    }
    public void LavBooking(String s){
        //SQLManager.makeStatement("CALL LavBookning()");

    }


}
