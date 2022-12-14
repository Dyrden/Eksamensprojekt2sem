package com.example.eksamensprojekt_2sem.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RapportRepositoryTest {
private RapportRepository rapportRepository = new RapportRepository(); //Ferhat

  @Test //Ferhat
  void skafPrisPaaOverskredetKM() {

    //act
    double result =  rapportRepository.skafPrisPaaOverskredetKM(121);

    //assert
    assertEquals(750,result);

  }

  @Test //Ferhat
  void skafAntalMaanederBooket() {
    //act
    double result =  rapportRepository.skafAntalMaanederBooket(121);

    //assert
    assertEquals(35,result);
  }

  @Test //Ferhat
  void skafKMOverskredet(){
    //act
    double result =  rapportRepository.skafKMOverskredet(121);

    //assert
    assertEquals(1000,result);
  }
}