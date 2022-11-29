package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.service.PSTSCreator;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository {
    public void visAktiveBookinger(String s){
        PSTSCreator.makeStatement("CALL VisAktiveBookninger()");

    }
    public void visBookingHistorik(String s){
        PSTSCreator.makeStatement("CALL VisBookningHistorik()");

    }
    public void LavBooking(String s){
        PSTSCreator.makeStatement("CALL LavBookning()");

    }


}
