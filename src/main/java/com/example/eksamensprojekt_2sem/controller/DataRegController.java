package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.model.BilModel;
import com.example.eksamensprojekt_2sem.repository.BilRepository;
import com.example.eksamensprojekt_2sem.repository.BookingRepository;
import com.example.eksamensprojekt_2sem.repository.KundeRepository;
import org.apache.coyote.http11.HttpOutputBuffer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class DataRegController {
    private BilRepository bilRepository;
    private KundeRepository kundeRepository = new KundeRepository();

    private BookingRepository bookingRepository = new BookingRepository();

    public DataRegController(BilRepository bilRepository) {
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


    @GetMapping("/dataRegistrering")
    public String visRegisteringer() {

        return "html/dataRegistrering/dataRegistrering";
    }


    @GetMapping("/bilRegistrering")
    public String visBilRegistrering() {

        return "html/dataRegistrering/dataRegistrering";
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
        HttpSession sessionKundeID, HttpSession sessionBil)
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

        return "html/dataRegistrering/successite";
    }
}