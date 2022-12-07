package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.model.RapportModel;
import com.example.eksamensprojekt_2sem.repository.BilRepository;
import com.example.eksamensprojekt_2sem.repository.RapportRepository;
import com.example.eksamensprojekt_2sem.repository.SkadeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Rapporter {
private BilRepository bilRepository = new BilRepository();
private RapportRepository rapportRepository = new RapportRepository();
private SkadeRepository skadeRepository = new SkadeRepository();

  @GetMapping("/seRapporter")
  public String visForretningsUdviklere(Model model){
    model.addAttribute("biler", bilRepository.visAlleBiler());

    return "html/rapporter/rapporter";
  }
  @GetMapping("/seRapport/{vognNummer}")
  //Ferhat er ansvarlig for denne metode
  public String seRapport(@PathVariable("vognNummer") String vognNummer, Model model){
    model.addAttribute("bil", bilRepository.visSpecifikBil(vognNummer));
    return "html/rapporter/seRapport";
  }
  @GetMapping("/vaelgRapportRapporter/{vognNummer}")
  //Ferhat er ansvarlig for denne metode
  public String vaelgRapport(@PathVariable("vognNummer") String vognNummer, Model model, HttpSession session){
    model.addAttribute("bil", bilRepository.visSpecifikBil(vognNummer));

    //Her henter vi den valgte bils rapport
    //Så kan vi efterfølgende bruge rapportens id til at modtage skaderne
    List<RapportModel> rapporter = rapportRepository.hentRapporterFraVognNummer(vognNummer);
    model.addAttribute("rapporter", rapportRepository.hentRapporterFraVognNummer(vognNummer));


    //Opretter en session og sætter bil til den bil vi er inde på i skader
    session.setAttribute("bil", bilRepository.visSpecifikBil(vognNummer));

    return "html/rapporter/vaelgRapport";
  }

  @GetMapping("/seSkadesRapport/{rapportID}")
  //Ferhat er ansvarlig for denne metode
  public String visSkader(@PathVariable("rapportID") String rapportID, Model model, HttpSession session){
    //Når vi nu har bilens rapport, så kan vi tilgå rapporten
    //vi henter alle skaderne fra rapportens id.
    //Rapportens id har vi fået fra tildigere kode gennem bilens vognNummer
    model.addAttribute("skader",skadeRepository.skafSkaderFraRapport(rapportID));

    model.addAttribute("bil", session.getAttribute("bil"));
    return "html/rapporter/seSkadesRapport";
  }


}
