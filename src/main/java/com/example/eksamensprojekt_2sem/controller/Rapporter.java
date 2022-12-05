package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.repository.BilRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Rapporter {
private BilRepository bilRepository = new BilRepository();
  @GetMapping("/seRapporter")
  public String visForretningsUdviklere(Model model){
    model.addAttribute("bil", bilRepository.visAlleBiler());

    return "html/rapporter";
  }
}
