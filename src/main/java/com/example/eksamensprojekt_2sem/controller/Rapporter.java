package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.model.RapportModel;
import com.example.eksamensprojekt_2sem.repository.BilRepository;
import com.example.eksamensprojekt_2sem.repository.RapportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class Rapporter {
private BilRepository bilRepository = new BilRepository();
private RapportRepository rapportRepository = new RapportRepository();

  @GetMapping("/seRapporter")
  public String visForretningsUdviklere(Model model){
    model.addAttribute("biler", bilRepository.visAlleBiler());

    return "html/rapporter/rapporter";
  }
  @GetMapping("/seRapport/{vognNummer}")
  //Ferhat er ansvarlig for denne metode
  public String seRapport(@PathVariable("vognNummer") String vognNummer, Model model, HttpSession session){
    model.addAttribute("bil", bilRepository.visSpecifikBil(vognNummer));

    //Her henter vi den valgte bils rapport
    //Så kan vi efterfølgende bruge rapportens id til at modtage skaderne
    RapportModel rapport = rapportRepository.hentRapportFraVognNummer(vognNummer);
    model.addAttribute("rapport", rapportRepository.hentRapportFraVognNummer(vognNummer));


    //Opretter en session og sætter bil til den bil vi er inde på i skader
    session.setAttribute("bil", bilRepository.visSpecifikBil(vognNummer));

    return "html/rapporter/seRapport";
  }
}
