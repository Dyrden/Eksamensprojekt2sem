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

    public List<BookingModel> visAktiveBookings(){
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

    public void visAktiveBookinger(String s){
        //SQLManager.makeStatement("CALL VisAktiveBookninger()");

    }
    public void visBookingHistorik(String s){
        //SQLManager.makeStatement("CALL VisBookningHistorik()");

    }
    public void LavBooking(String s){
        //SQLManager.makeStatement("CALL LavBookning()");

    }


}
