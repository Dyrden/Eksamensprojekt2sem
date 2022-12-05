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

import javax.servlet.http.HttpSession;

@Controller
public class SkadeOgUdController {

    private BilRepository bilRepository = new BilRepository();
    private RapportRepository rapportRepository = new RapportRepository();
    private SkadeRepository skadeRepository = new SkadeRepository();

    @GetMapping("/skadeOgUdbedring")
    //Ferhat er ansvarlig for denne metode
    public String visSkadeOgUd(Model model, HttpSession session){
        model.addAttribute("biler", bilRepository.visAlleBiler());
        session.invalidate();
        return "html/skadeOgUdbedring/skadeOgUdbedring";
    }

    @PostMapping("/udbedring")
    public String reUdbedring(){
        return "redirect:/skadeOgUdbedring";
    }

    @GetMapping("visSpecifikBil/{stelNummer}")
    //Ferhat er ansvarlig for denne metode
    public String visSpecifikBilWeb(@PathVariable("stelNummer") String s, Model model){
        model.addAttribute("specifikBil", bilRepository.sUVisning(s));
        return "html/skadeOgUdbedring/skadeOgUdbedring";
    }

    @GetMapping("/seSkader/{vognNummer}")
    //Ferhat er ansvarlig for denne metode
    public String visSkader(@PathVariable("vognNummer") String vognNummer, Model model, HttpSession session){
        model.addAttribute("bil", bilRepository.visSpecifikBil(vognNummer));

        //Her henter vi den valgte bils rapport
        //Så kan vi efterfølgende bruge rapportens id til at modtage skaderne
        RapportModel rapport = rapportRepository.hentRapportFraVognNummer(vognNummer);
        model.addAttribute("rapport", rapportRepository.hentRapportFraVognNummer(vognNummer));

        //Når vi nu har bilens rapport, så kan vi tilgå rapporten
        //vi henter alle skaderne fra rapportens id.
        //Rapportens id har vi fået fra tildigere kode gennem bilens vognNummer
        model.addAttribute("skader",skadeRepository.skafSkaderFraRapport(rapport.getId()));

        //Opretter en session og sætter bil til den bil vi er inde på i skader
        session.setAttribute("bil", bilRepository.visSpecifikBil(vognNummer));

        return "html/skadeOgUdbedring/seSkader";
    }

    @GetMapping("/tilfoejSkade/{vognNummer}")
    //Ferhat er ansvarlig for denne metode
    public String tilfoejSkade(@PathVariable("vognNummer") String vognNummer, Model model){
        RapportModel rapport = rapportRepository.hentRapportFraVognNummer(vognNummer);
        model.addAttribute("rapportID", rapport.getId());
        System.out.println(model.addAttribute("rapportID", rapport.getId()));

        return "html/skadeOgUdbedring/tilfoejSkade";
    }

    @PostMapping("/tilfoej")
    //Ferhat er ansvarlig for denne metode
    public String tilfoejSkadePost(Model model, HttpSession session,
                                   @RequestParam("skade_placering") String skadePlacering,
                                   @RequestParam("skade_pris") double skadensPris,
                                   @RequestParam("skade_beskrivelse") String skadensBeskrivelse,
                                   @RequestParam("rapportID") int rapportID) {


        skadeRepository.tilfoejSkade(skadePlacering, skadensBeskrivelse, skadensPris, rapportID);

        BilModel bil = (BilModel) session.getAttribute("bil");

        String vognNummer = bil.getVognNummer();
        //redirect tilbage til seSkader med vognnummer måske man kunne buge session
        return "redirect:/seSkader/"+vognNummer;
    }

    @GetMapping("/sletSkade/{skadeId}")
    //Ferhat er ansvarlig for denne metode
    public String deleteWishList(@PathVariable("skadeId") int skadeId, HttpSession session) {
        skadeRepository.sletSkade(skadeId);
        BilModel bil = (BilModel) session.getAttribute("bil");

        String vognNummer = bil.getVognNummer();

        return "redirect:/seSkader/"+ vognNummer;
    }

}
