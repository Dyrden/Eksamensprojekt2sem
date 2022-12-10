package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.model.BilModel;
import com.example.eksamensprojekt_2sem.model.BilModelModel;
import com.example.eksamensprojekt_2sem.repository.BilRepository;
import com.example.eksamensprojekt_2sem.repository.BookingRepository;
import com.example.eksamensprojekt_2sem.repository.KundeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class DataRegController {
    private BilRepository bilRepository;
    private KundeRepository kundeRepository;
    private BookingRepository bookingRepository;

    //Ansvarlig: Mark Dyrby Denner
    // konstruktør til
    public DataRegController(
        BilRepository bilRepository,
        KundeRepository kundeRepository,
        BookingRepository bookingRepository)
    {
        this.kundeRepository = kundeRepository;
        this.bookingRepository = bookingRepository;
        this.bilRepository = bilRepository;
    }

    @GetMapping("/bookingRegistrering")
    //Ferhat er ansvarlig for denne metode
    public String visBookingRegistrering(Model model, HttpSession sessionSoeg){

        System.out.println(sessionSoeg.getAttribute("soegeFelt"));

        if(sessionSoeg.getAttribute("soegeFelt") == null){
            model.addAttribute("biler", bilRepository.visTilgaengeligeBiler());
        } else {
            model.addAttribute("biler", bilRepository.chooseCallFromParameter((String)sessionSoeg.getAttribute("soegeFelt")));
            sessionSoeg.setAttribute("soegeFelt",null);
        }


        return "html/dataRegistrering/bookingRegistrering";
    }

    @PostMapping("/soegBiler") //Middleway Getmapping. // Kristian
    public String soegBiler(
            @RequestParam String soegeFelt,
            HttpSession sessionSoeg) {

        if(soegeFelt.equals("")) {
            soegeFelt = null;
        }
        sessionSoeg.setAttribute("soegeFelt", soegeFelt);

        return "redirect:/bookingRegistrering";
    }



    // Ansvarlig : Mark Dyrby Denner
    // Denne URL går hen til dataRegistrering.html og viser 2 muligheder; at gå til bilregistrering eller
    // bookingRegistrering
    @GetMapping("/dataRegistrering")
    public String visRegistreringer() {
        return "html/dataRegistrering/dataRegistrering";
    }


    // Ansvarlig : Mark Dyrby Denner
    // Action / URL der går til bilRegistrering.html hvor vi lægger informationer med fra databasen
    // som vi så giver brugeren som en "choose-one" mulighed således taste fejl ikke skal håndteres for disse
    // konstant værdier
    @GetMapping("/bilRegistrering")
    public String visBilRegistrering(Model model) {
        model.addAttribute("energiTyper", bilRepository.skafEnergiTyper());
        model.addAttribute("farver", bilRepository.skafFarver());
        model.addAttribute("gearbokse", bilRepository.skafGearboks());
        model.addAttribute("maerker", bilRepository.skafMaerker());
        model.addAttribute("udstyrsniveau", bilRepository.skafUdstyrsNiveau());
        return "html/dataRegistrering/bilRegistrering";

    }

    @PostMapping("/indsendBilTilRegistrering")
    public String indsendBilTilRegistrering(
        @RequestParam("vognnummer") String vognnummer,
        @RequestParam("stelnummer") String stelnummer,
        @RequestParam("model") String model,
        @RequestParam("farve") String farve,
        @RequestParam("gearboks") String gearboks,
        @RequestParam("maerke") String maerke,
        @RequestParam("udstyrsniveau") String udstyrsniveau,
        @RequestParam("energitype") String energitype,
        @RequestParam("staalpris") double staalpris,
        @RequestParam("registreringsafgift") double registreringsafgift,
        @RequestParam("CO2udledning") double co2udledning,
        @RequestParam("produktionsaar") int produktionsaar,
        @RequestParam("kilometertal") int kilometertal,
        @RequestParam("maanedspris") double maanedspris
    ) {

        BilModel bil = new BilModel();
        bil.setModel(model);
        bil.setVognNummer(vognnummer);
        bil.setStelNummer(stelnummer);
        bil.setFarve(farve);
        bil.setGearboks(gearboks);
        bil.setMaerke(maerke);
        bil.setUdstyr(udstyrsniveau);
        bil.setEnergiType(energitype);
        bil.setStaalPris(staalpris);
        bil.setRegistreringsAfgift(registreringsafgift);
        bil.setCO2Udledning(co2udledning);
        bil.setProduktionsaar(produktionsaar);
        bil.setDistance(kilometertal);
        bil.setMaanedsPris(maanedspris);


        BilModelModel bilModel = new BilModelModel(model,energitype,gearboks,udstyrsniveau,maerke,farve);

        // check om model findes
        int modelID = bilRepository.findModel(bilModel);

        if (modelID == 0) {
            bilRepository.lavModel(bilModel);
            modelID = bilRepository.findModel(bilModel);
        }
        bil.setModelID(modelID);

        bilRepository.lavBil(bil);
        return "redirect:/";
    }

    @GetMapping("/kunde")
    //Ferhat er ansvarlig for denne metode
    //Gammel kundebooking side. Hvis man hellere vil tage den.
    public String kunde(Model model){
        model.addAttribute("biler", bilRepository.visTilgaengeligeBiler());
        return "html/dataRegistrering/kundeBookingGammel";
    }


    @GetMapping("/bookBil/{vognNummer}")
    //Ferhat er ansvarlig for denne metode
    public String bookBil(@PathVariable("vognNummer") String vognNummer,
                          Model model,
                          HttpSession sessionBrugerCPR,
                          HttpSession sessionBil) {
            System.out.println(vognNummer);

            if(sessionBrugerCPR.getAttribute("brugerCPR") == null){
                model.addAttribute("brugere", kundeRepository.visAlleBrugere());
            } else {
                model.addAttribute("brugere", kundeRepository.skafBrugerFraCPR((String)sessionBrugerCPR.getAttribute("brugerCPR")));
                sessionBrugerCPR.setAttribute("brugerCPR",null);
            }

            model.addAttribute("bil", bilRepository.visSpecifikBil(vognNummer));
            sessionBil.setAttribute("vognNummer",vognNummer);

            System.out.println((String)sessionBrugerCPR.getAttribute("brugerCPR"));

            return "html/dataRegistrering/kundeRegistrering";
    }

    @PostMapping("/soegKundeMedCPR") //Middleway Getmapping.
    //Ferhat er ansvarlig for denne metode
    public String soegKundeMedCPR(
                          @RequestParam String brugerCPR,
                          HttpSession sessionBil,
                          HttpSession sessionBrugerCPR) {

        String vognNummer = (String)sessionBil.getAttribute("vognNummer");

        if(brugerCPR.equals("")) {
            brugerCPR = null;
        }
            sessionBrugerCPR.setAttribute("brugerCPR", brugerCPR);

        //sessionBrugerID.setAttribute("BrugerID",kundeRepository.skafBrugerIDFraCPR(kundeCPR));

        return "redirect:/bookBil/" + vognNummer;
    }


    @GetMapping("/udstyrValg/{brugerID}") //Kristian
    public String udstyrValg(@PathVariable("brugerID") int brugerID,Model model, HttpSession sessionBrugerID, HttpSession sessionBil) {

            sessionBrugerID.setAttribute("brugerID",brugerID);
            model.addAttribute("bil",bilRepository.visSpecifikBil((String)sessionBil.getAttribute("vognNummer")));
            model.addAttribute("udleveringssteder",bookingRepository.visAlleUdleveringsSteder());
            model.addAttribute("abonnementsTyper",bookingRepository.visAlleAbonnementsTyper());



        System.out.println("brugerID: " + brugerID);

        return "html/dataRegistrering/udstyrBooking";
    }

    @PostMapping("/nyBruger") // Kristian
    public String skabNyBruger(@RequestParam("fornavn") String fornavn,
                               @RequestParam("efternavn") String efternavn,
                               @RequestParam("email") String email,
                               @RequestParam("tlf") String tlf,
                               @RequestParam("CPR") String CPR,
                               HttpSession sessionBrugerID) {

        kundeRepository.opretKunde(fornavn,efternavn,email,tlf,CPR);

        sessionBrugerID.setAttribute("brugerID",kundeRepository.getNyesteKundeID());

        System.out.println("En bruger blev oprettet!");



        return "redirect:/udstyrValg/" + (int)sessionBrugerID.getAttribute("brugerID");
    }

    @PostMapping("/nyBooking") // Kristian
    public String nyBooking(
        @RequestParam("udlejningsStartDato") String udlejningsStartDato,
        @RequestParam("udeljningsSlutDato") String udeljningsSlutDato,
        @RequestParam("abonnementsType") int abonnementsType,
        @RequestParam("udleveringsSted") int udleveringsSted,
        HttpSession sessionKundeID, HttpSession sessionBil, Model model)
    {
        BilModel bil = bilRepository.visSpecifikBil((String)sessionBil.getAttribute("vognNummer")); // Caster en session til en stringværdi som kan bruges i metoden, som derefter kan definere BilModel objektet.
        // vognnummer,BrugerID,abonnementstype,sted,udlejningsStartDato,udlejningsSlutDato,kilometerStart

        //Opretter en Booking inde på bookingRepository, som bliver sendt til Databasen.
        bookingRepository.lavBooking(
                bil.getVognNummer(),
                (int)sessionKundeID.getAttribute("brugerID"),
                abonnementsType,
                udleveringsSted,
                udlejningsStartDato,
                udeljningsSlutDato,
                bil.getDistance()); // Bilens "kilometerStart" er den mængde kilometer som bilen har kørt.

       model.addAttribute("bil", bil);
       model.addAttribute("bruger", sessionKundeID.getAttribute("brugerID"));
       model.addAttribute("udlejningsStartDato", udlejningsStartDato);
       model.addAttribute("udeljningsSlutDato", udeljningsSlutDato);
       model.addAttribute("abonnementsType", abonnementsType);
       model.addAttribute("udleveringsSted", udleveringsSted);

        return "html/dataRegistrering/successite";
    }
}
