package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.model.BilModel;
import com.example.eksamensprojekt_2sem.model.RapportModel;
import com.example.eksamensprojekt_2sem.repository.BilRepository;
import com.example.eksamensprojekt_2sem.repository.RapportRepository;
import com.example.eksamensprojekt_2sem.repository.SkadeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SkadeOgUdController {

    private BilRepository bilRepository = new BilRepository();
    private RapportRepository rapportRepository = new RapportRepository();
    private SkadeRepository skadeRepository = new SkadeRepository();

    @GetMapping("/skadeOgUdbedring")
    public String visSkadeOgUd(Model model){
        model.addAttribute("biler", bilRepository.visAlleBiler());
        return "html/skadeOgUdbedring/skadeOgUdbedring";
    }

    @PostMapping("/udbedring")
    public String reUdbedring(){
        return "redirect:/skadeOgUdbedring";
    }

    @GetMapping("visSpecifikBil/{stelNummer}")
    public String visSpecifikBilWeb(@PathVariable("stelNummer") String s, Model model){
        model.addAttribute("specifikBil", bilRepository.sUVisning(s));
        return "html/skadeOgUdbedring/skadeOgUdbedring";
    }

    @GetMapping("/seSkader/{vognNummer}")
    public String visSkader(@PathVariable("vognNummer") String vognNummer, Model model){
        model.addAttribute("bil", bilRepository.visSpecifikBil(vognNummer));

        //Her henter vi den valgte bils rapport
        //Så kan vi efterfølgende bruge rapportens id til at modtage skaderne
        RapportModel rapport = rapportRepository.hentRapportFraVognNummer(vognNummer);
        model.addAttribute("rapport", rapportRepository.hentRapportFraVognNummer(vognNummer));

        //Når vi nu har bilens rapport, så kan vi tilgå rapporten
        //vi henter alle skaderne fra rapportens id.
        //Rapportens id har vi fået fra tildigere kode gennem bilens vognNummer
        model.addAttribute("skader",skadeRepository.skafSkaderFraRapport(rapport.getId()));

        return "html/skadeOgUdbedring/seSkader";
    }

    @GetMapping("/tilfoejSkade/{vognNummer}")
    public String tilfoejSkade(@PathVariable("vognNummer") String vognNummer, Model model){
        RapportModel rapport = rapportRepository.hentRapportFraVognNummer(vognNummer);
        model.addAttribute("rapportID", rapport.getId());
        System.out.println(model.addAttribute("rapportID", rapport.getId()));

        return "html/skadeOgUdbedring/tilfoejSkade";
    }

    @PostMapping("/tilfoej")
    public String tilfoejSkadePost(Model model,
                                   @RequestParam("skade_placering") String skadePlacering,
                                   @RequestParam("skade_pris") double skadensPris,
                                   @RequestParam("skade_beskrivelse") String skadensBeskrivelse,
                                   @RequestParam("rapportID") int rapportID) {


        skadeRepository.tilfoejSkade(skadePlacering, skadensBeskrivelse, skadensPris, rapportID);

        //redirect tilbage til seSkader med vognnummer
        return "redirect:/seskader";
    }


}
