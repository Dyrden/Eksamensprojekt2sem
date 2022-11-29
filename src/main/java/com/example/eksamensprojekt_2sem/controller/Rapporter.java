package com.example.eksamensprojekt_2sem.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Rapporter {

  @GetMapping("/seRapporter")
  public String visForretningsUdviklere(){
    return "html/rapporter";
  }
}
