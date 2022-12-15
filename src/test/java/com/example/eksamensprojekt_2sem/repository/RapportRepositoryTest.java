package com.example.eksamensprojekt_2sem.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RapportRepositoryTest {
    private RapportRepository rapportRepository = new RapportRepository(); //Ferhat

    //Ferhat
    @Test
    void skafPrisPaaOverskredetKM() {

        //act
        double result = rapportRepository.skafPrisPaaOverskredetKM(121);

        //assert
        assertEquals(750, result);

    }

    //Ferhat
    @Test
    void skafAntalMaanederBooket() {
        //act
        double result = rapportRepository.skafAntalMaanederBooket(121);

        //assert
        assertEquals(35, result);
    }

    //Ferhat
    @Test
    void skafKMOverskredet() {
        //act
        double result = rapportRepository.skafKMOverskredet(121);

        //assert
        assertEquals(1000, result);
    }
}