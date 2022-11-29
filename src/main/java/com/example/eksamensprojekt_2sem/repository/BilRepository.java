package com.example.eksamensprojekt_2sem.repository;

import com.example.eksamensprojekt_2sem.service.PSTSCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class BilRepository {
    public void visAlleBiler(String s){
        PSTSCreator.makeStatement("CALL VisAlleBiler()");

    }
    public void visUdlejetBiler(String s){
        PSTSCreator.makeStatement("CALL VisUdlejedeBiler()");

    }
    public void LavBil(String s){
        PSTSCreator.makeStatement("CALL LavBil()");

    }


}
