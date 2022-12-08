package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.model.BilModel;
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
    private KundeRepository kundeRepository = new KundeRepository();

    private BookingRepository bookingRepository = new BookingRepository();

    public DataRegController(BilRepository bilRepository) {
        this.bilRepository = bilRepository;
    }

    @GetMapping("/bookingRegistrering")
    //Ferhat er ansvarlig for denne metode
    public String visBookingRegistrering(Model model){
        model.addAttribute("biler", bilRepository.visTilgaengeligeBiler());

        return "html/dataRegistrering/bookingRegistrering";
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
        model.addAttribute("energiTyper",null);
        model.addAttribute("farver",null);
        model.addAttribute("gearbokse",null);
        model.addAttribute("maerker",null);
        model.addAttribute("udstyrsniveau",null);

        // MULTIPLE SQL CALL s


        return "html/dataRegistrering/bilRegistrering";
    }

    @PostMapping("/indsendBilTilRegistrering")
    public String indsendBilTilRegistrering() {
        //meget request param
        //sql call til INSERT

        return "";
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

            //int brugerCPR = (int)sessionBrugerCPR.getAttribute("brugerCPR");

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


    @GetMapping("/udstyrValg/{brugerID}") // Skal lige kigge på denne her. (Kristian)
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
          /*
        RedirectAttributes attributes,
        */
        @RequestParam("udlejningsStartDato") String udlejningsStartDato,
        @RequestParam("udeljningsSlutDato") String udeljningsSlutDato,
        @RequestParam("abonnementsType") int abonnementsType,
        @RequestParam("udleveringsSted") int udleveringsSted,
        HttpSession sessionKundeID, HttpSession sessionBil
        //@RequestParam("fornavn") String forNavn,
        //@RequestParam("efternavn") String efterNavn,
        //@RequestParam("email") String email,
        //@RequestParam("tlf") String tlf,
        //@RequestParam("CPR") String cpr,
        //@RequestParam("vognNummer") String vognNummer
        ) {
        /*
        attributes.addAttribute("udstyr", udstyr);
        attributes.addAttribute("udlejningsStartDato", udlejningsStartDato);
        attributes.addAttribute("udeljningsSlutDato", udeljningsSlutDato);
        attributes.addAttribute("udleveringsStedID", udleveringsStedID);
        attributes.addAttribute("fornavn", forNavn);
        attributes.addAttribute("efternavn", efterNavn);
        attributes.addAttribute("email", email);
        attributes.addAttribute("tlf", tlf);
        attributes.addAttribute("email", cpr);
        attributes.addAttribute("vognNummer", vognNummer);
        */


        //System.out.println(forNavn + " " + efterNavn + " " + cpr);

        //System.out.println(udlejningsStartDato + "\n" + udeljningsSlutDato);

        BilModel bil = bilRepository.visSpecifikBil((String)sessionBil.getAttribute("vognNummer")); // Caster en session til en stringværdi som kan bruges i metoden, som derefter kan definere BilModel objektet.
        // vognnummer,BrugerID,abonnementstype,sted,udlejningsStartDato,udlejningsSlutDato,kilometerStart

        //Opretter en Booking inde på bookingRepository, som bliver send til Databasen.
        bookingRepository.lavBooking(
                bil.getVognNummer(),
                (int)sessionKundeID.getAttribute("brugerID"),
                abonnementsType,
                udleveringsSted,
                udlejningsStartDato,
                udeljningsSlutDato,
                bil.getDistance()); // Bilens "kilometerStart" er den mængde kilometer som bilen har kørt.

        return "html/dataRegistrering/successite";
        // return "redirect:/" + vognNummer;
    }

    /*
    @GetMapping("/nyBooking/{vognNummer}")
    public String nyBookingGet(
            Model model,
            @PathVariable("vognNummer") String vognNummer,
            @RequestParam("udstyr") String udstyr,
            @RequestParam("udlejningsStartDato") String udlejningsStartDato,
            @RequestParam("udeljningsSlutDato") String udeljningsSlutDato,
            @RequestParam("udleveringsStedID") String udleveringsStedID
            //RequestParam("fornavn") String forNavn,
            //@RequestParam("efternavn") String efterNavn,
            //@RequestParam("email") String email,
            //@RequestParam("tlf") String tlf,
            //@RequestParam("CPR") String cpr,
            )
            {
        model.addAttribute("udstyr", udstyr);
        model.addAttribute("udlejningsStartDato", udlejningsStartDato);
        model.addAttribute("udeljningsSlutDato", udeljningsSlutDato);
        model.addAttribute("udleveringsStedID", udleveringsStedID);
        //model.addAttribute("fornavn", forNavn);
        //model.addAttribute("efternavn", efterNavn);
        //model.addAttribute("email", email);
        //model.addAttribute("tlf", tlf);
        //model.addAttribute("email", cpr);

        // har skrevet for at teste om den funere, 1 skal være ID
        //BrugerModel kunde = new BrugerModel(forNavn, efterNavn, email, tlf, cpr );

        //System.out.println(forNavn + " " + efterNavn + " " + cpr);

        //Når booking er gået igennem, skal der komme en bekræftelses side
        //Siden skal vise informationerne man har valgt
        return "html/successite";



    }
*/
}
