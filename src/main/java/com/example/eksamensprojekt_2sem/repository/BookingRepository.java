package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.model.*;
import com.example.eksamensprojekt_2sem.model.bookingmodel.AbonnementsTypeModel;
import com.example.eksamensprojekt_2sem.model.bookingmodel.UdleveringsstedModel;
import com.example.eksamensprojekt_2sem.utility.SQLManager;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookingRepository {

   /* public List<BookingModel> visAlleBookinger(){ //Ferhat
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

                bookinger.add(new BookingModel(id, brugerID, type, sted, startDate, slutDato));
            }

        } catch (SQLException e){
            System.err.println("Ingen bookinger fundet.");
            System.out.println(e.getMessage());
            return new LinkedList<BookingModel>();
        }

        return bookinger;

    }*/

    //Kristian er ansvarlig for denne metode
    public List<BookingModel> skafBookingerFraVognNum(String vognNummer){

        List<BookingModel> bookinger = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL skafBookingerFraVognNum('" + vognNummer + "')");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int brugerID = resultSet.getInt(2);
                String type = resultSet.getString(3);
                String sted = resultSet.getString(4);
                String startDate = resultSet.getString(5);
                String slutDato = resultSet.getString(6);
                int kilometerstart = resultSet.getInt(7);
                String bil_vognNummer = resultSet.getString(8);

                bookinger.add(new BookingModel(id, brugerID, type, sted, startDate, slutDato, kilometerstart, bil_vognNummer));
            }

        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen bookinger for vognnummer fundet.");
            System.out.println(e.getMessage());
        }
        return bookinger;
    }

    //Kristian er ansvarlig for denne metode
    public List<BookingModel> skafBookingFraID(int bookingID){

        List<BookingModel> bookinger = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL skafBookingFraID('" + bookingID + "')");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int brugerID = resultSet.getInt(2);
                String type = resultSet.getString(3);
                String sted = resultSet.getString(4);
                String startDate = resultSet.getString(5);
                String slutDato = resultSet.getString(6);
                int kilometerstart = resultSet.getInt(7);
                String bil_vognNummer = resultSet.getString(8);

                bookinger.add(new BookingModel(id, brugerID, type, sted, startDate, slutDato, kilometerstart, bil_vognNummer));
            }

        } catch (SQLException | NullPointerException e){
            System.err.println("Ingen bookinger for rapportID fundet.");
            System.out.println(e.getMessage());
        }

        return bookinger;
    }

    //Ferhat og Mark er ansvarlig for denne metode
    public double visSamletIndtaegt(){

        //Den viser lige nu samlede indtægt for bookede biler denne måned

        double indtaegt = 0;
        try {
            ResultSet resultSet = SQLManager.execute("CALL skafIndtaegt()");

            while (resultSet.next()) {

                double maanedsPris = resultSet.getDouble(1);
                double maanederUdlejet = resultSet.getInt(2);

                indtaegt += maanedsPris*maanederUdlejet;
            }

        } catch (SQLException | NullPointerException e){
            System.err.println("Ingen indtægt fundet.");
            System.out.println(e.getMessage());
        }
        return indtaegt;
    }


    //Ferhat og Mark er ansvarlig for denne metode
    public double visSamletIndtaegtForDenneMåned(){

        //Den viser lige nu samlede indtægt for bookede biler denne måned

        double indtaegt = 0;
        try {
            ResultSet resultSet = SQLManager.execute("CALL skafIndtaegtForDenneMaaned()");

            while (resultSet.next()) {

                double maanedsPris = resultSet.getDouble(1);

                indtaegt += maanedsPris;
            }

        } catch (SQLException | NullPointerException e){
            System.err.println("Ingen indtægt fundet.");
            System.out.println(e.getMessage());
        }
        return indtaegt;
    }


    //Ferhat er ansvarlig for denne metode
    public List<BilOgBookingModel> visAktiveBookinger(){

        List<BilOgBookingModel> biler = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL skafAktiveBookingOgBilData()");

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

        } catch (SQLException | NullPointerException e){
            System.err.println("Ingen aktive bookinger fundet.");
            System.out.println(e.getMessage());
        }

        return biler;

    }

/*    public void visBookingHistorik(String s){
        //SQLManager.makeStatement("CALL VisBookningHistorik()");
    }*/

    // Kristian er ansvarlig for denne metode
    public void lavBooking(String vognNummer, int BrugerID,int abonnementsType,int sted,String udlejningsStartDato, String udlejningsSlutDato, int kilometerStart){
        // Format:
        // vognnummer,BrugerID,abonnementstype,sted,udlejningsStartDato,udlejningsSlutDato,kilometerStart
        SQLManager.update("CALL Booking_Opret('"+ vognNummer +"','"+ BrugerID +"','"+ abonnementsType +"','"+ sted +"','"+ udlejningsStartDato +"','"+ udlejningsSlutDato +"','"+ kilometerStart +"')");
    }

    //Kristian er ansvarlig for denne metode
    public List<UdleveringsstedModel> visAlleUdleveringsSteder() {
        List<UdleveringsstedModel> udleveringssteder = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL skafUdleveringssteder()");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String sted = resultSet.getString(2);
                udleveringssteder.add(new UdleveringsstedModel(id, sted));
            }

        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen udleveringssteder fundet.");
            System.out.println(e.getMessage());
        }
        return udleveringssteder;
    }

    //Kristian er ansvarlig for denne metode
    public List<AbonnementsTypeModel> visAlleAbonnementsTyper() {
        List<AbonnementsTypeModel> abonnementsTyper = new LinkedList<>();
        try {
            ResultSet resultSet = SQLManager.execute("CALL skafAbonnementsTyper()");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String type = resultSet.getString(2);
                abonnementsTyper.add(new AbonnementsTypeModel(id, type));
            }

        } catch (SQLException | NullPointerException e) {
            System.err.println("Ingen abonnementsTyper fundet.");
            System.out.println(e.getMessage());
        }

        return abonnementsTyper;

    }

    //Kristian er ansvarlig for denne metode
    private void sætBookingOvervåget(int bookingID) {
        SQLManager.update("CALL saetBookingOvervaaget('" + bookingID +"')");
    }


    //Kristian er ansvarlig for denne metode
    public void sætBilTotalskadet(int bookingID) {
        sætBookingOvervåget(bookingID);
        SQLManager.update("CALL Bil_RedigerStatusTilTotalskadetBookingID('" + bookingID +"')");
    }
    //Kristian er ansvarlig for denne metode
    public void sætBilSolgt(int bookingID) {
        sætBookingOvervåget(bookingID);
        SQLManager.update("CALL Bil_RedigerStatusTilSolgtBookingID('" + bookingID +"')");
    }
    //Kristian er ansvarlig for denne metode
    public void sætBilIkkeUdlejet(int bookingID) {
        sætBookingOvervåget(bookingID);
        SQLManager.update("CALL Bil_RedigerStatusTilIkkeUdlejetBookingID('" + bookingID +"')");
    }
}
