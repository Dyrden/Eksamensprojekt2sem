package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.model.BilModel;
import com.example.eksamensprojekt_2sem.model.RapportModel;
import com.example.eksamensprojekt_2sem.model.SkadeModel;
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
import java.util.List;

@Controller
public class SkadeOgUdController {

    private final BilRepository bilRepository;
    private final RapportRepository rapportRepository;
    private final SkadeRepository skadeRepository;

    public SkadeOgUdController(BilRepository bilRepository, RapportRepository rapportRepository, SkadeRepository skadeRepository) {
        this.bilRepository = bilRepository;
        this.rapportRepository = rapportRepository;
        this.skadeRepository = skadeRepository;
    }

    @GetMapping("/skadeOgUdbedring")
    //Ferhat er ansvarlig for denne metode
    public String visSkadeOgUd(Model model) {
        model.addAttribute("biler", bilRepository.visInleveretBiler());

        return "html/skadeOgUdbedring/skadeOgUdbedring";
    }

    @GetMapping("/opretRapportTest")
    public String rapportSkadeTest(){
        return "html/skadeOgUdbedring/opretRapport";
    }

    //Ferhat er ansvarlig for denne metode
    @GetMapping("/vaelgRapport/{vognNummer}")
    public String vaelgRapport(@PathVariable("vognNummer") String vognNummer, Model model, HttpSession session) {
        model.addAttribute("bil", bilRepository.visSpecifikBil(vognNummer));

        //Her henter vi den valgte bils rapport
        //Så kan vi efterfølgende bruge rapportens id til at modtage skaderne
        List<RapportModel> rapporter = rapportRepository.hentRapporterFraVognNummer(vognNummer);
        model.addAttribute("rapporter", rapportRepository.hentRapporterFraVognNummer(vognNummer));


        //Opretter en session og sætter bil til den bil vi er inde på i skader
        session.setAttribute("bil", bilRepository.visSpecifikBil(vognNummer));

        return "html/skadeOgUdbedring/vaelgRapport";
    }


    @PostMapping("/indtastkm")
    public String indtastKm(
        @RequestParam("km") int overskredetKM,
        @RequestParam("rapportID") String rapportID) {
        rapportRepository.tilføjNuværrendeKMTilRapport(rapportID, overskredetKM);
        return "redirect:/seSkader/" + rapportID;
    }



    @GetMapping("/seSkader/{rapportID}")
    //Ferhat er ansvarlig for denne metode
    public String visSkader(@PathVariable("rapportID") int rapportID, @RequestParam("BilvognNummer") String bil,
                            Model model) {

        //Når vi nu har bilens rapport, så kan vi tilgå rapporten
        //vi henter alle skaderne fra rapportens id.
        //Rapportens id har vi fået fra tildigere kode gennem bilens vognNummer
        model.addAttribute("skader", skadeRepository.skafSkaderFraRapport(rapportID));
        model.addAttribute("rapportID", rapportID);
        //if statement nødvendigt som exception for at loade denne side direkte
        model.addAttribute("bil", bilRepository.visSpecifikBil(bil));
        return "html/skadeOgUdbedring/seSkader";
    }



    @GetMapping("/tilfoejSkade/{rapportID}")
    //Ferhat er ansvarlig for denne metode
    public String tilfoejSkade(@PathVariable("rapportID") String rapportID, Model model) {
        model.addAttribute("rapportID", rapportID);
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

        session.setAttribute("rapportID", rapportID);
        //redirect tilbage til seSkader med vognnummer måske man kunne buge session
        return "redirect:/seSkader/" + rapportID;
    }

    @PostMapping("/sletSkade/{skadeId}")
    //Ferhat er ansvarlig for denne metode
    public String deleteWishList(@PathVariable("skadeId") int skadeId, @RequestParam("bookingID") int bookingID) {
        skadeRepository.sletSkade(skadeId);
        return "redirect:/opretRapport/" + bookingID;
    }

    @PostMapping("/udbedring")
    public String reUdbedring() {
        return "redirect:/skadeOgUdbedring";
    }

    @GetMapping("visSpecifikBil/{stelNummer}")
    public String visSpecifikBilWeb(@PathVariable("stelNummer") String s, Model model) {
        model.addAttribute("specifikBil", bilRepository.sUVisning(s));
        return "html/skadeOgUdbedring/skadeOgUdbedring";
    }


    @GetMapping("/opretRapport/{bookingID}")
    public String opretRapport(
        @PathVariable("bookingID") int bookingID,
        @RequestParam("vognnummer") String vognnummer,
        Model model
    ) {

        int rapportID = 0;
        rapportID = rapportRepository.findRapportIDFraBookingID(bookingID);

        if (rapportID == 0) {
            rapportRepository.opretRapportFraBookingID(bookingID);
            rapportID = rapportRepository.findRapportIDFraBookingID(bookingID);
        } else  {
            model.addAttribute("skader",skadeRepository.skafSkaderFraRapport(rapportID));
            model.addAttribute("slutkm", rapportRepository.findSlutKMFraRapportID(rapportID));
        }

        System.out.println("rapportID : " + rapportID);

        model.addAttribute("bil",bilRepository.skafBilFraVognnummer(vognnummer));
        model.addAttribute("rapportID", rapportID);
        model.addAttribute("bookingID", bookingID);

        return "html/skadeOgUdbedring/opretRapport";
    }


    @PostMapping("/opretSkade")
    public String opretSkade(
        @RequestParam("bookingID") int bookingID,
        @RequestParam("rapportID") int rapportID,
        @RequestParam("skade_placering") String skadePlacering,
        @RequestParam("skade_pris") double skadensPris,
        @RequestParam("skade_beskrivelse") String skadensBeskrivelse
    ) {
        SkadeModel skadeModel = new SkadeModel();
        skadeModel.setSkadensPris(skadensPris);
        skadeModel.setSkadensBeskrivelse(skadensBeskrivelse);
        skadeModel.setSkadensPlacering(skadePlacering);


        skadeRepository.opretSkadePåRapport(rapportID, skadeModel);

        return "redirect:/opretRapport/" + bookingID;
    }

    @PostMapping("/opretKM")
    public String opretKM(
        @RequestParam("bookingID") int bookingID,
        @RequestParam("rapportID") int rapportID,
        @RequestParam("slutkm") int slutkm,
        Model model
    ) {
        RapportModel rapportModel = new RapportModel();
        rapportModel.setId(rapportID);
        rapportModel.setOverskredetKM(slutkm);
        rapportRepository.redigereSlutKMTilRapport(rapportID, rapportModel);

        model.addAttribute("bookingID", bookingID);
        return "redirect:/opretRapport/" + bookingID;
    }
}
