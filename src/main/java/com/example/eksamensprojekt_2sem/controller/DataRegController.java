package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.model.BrugerModel;
import com.example.eksamensprojekt_2sem.repository.BilRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class DataRegController {
    private BilRepository bilRepository;

    public DataRegController(BilRepository bilRepository) {
        this.bilRepository = bilRepository;
    }


    @GetMapping("/dataRegistrering")
    public String visDataReg(Model model){
        model.addAttribute("biler", bilRepository.visAlleBiler());

        return "html/dataRegistrering/dataRegistrering";
    }

    @GetMapping("/bookBil/{vognNummer}")
    public String bookBil(@PathVariable("vognNummer") String vognNummer, Model model) {
       // model.addAttribute("bil", bilRepository.selectBilUdfraVognNummer(vognNummer));
        return "html/dataRegistrering/kundeBooking";
    }

    //Bliver ikke brugt længere. Kun til CSS
    @GetMapping("/kundeBooking")
    public String kundeBooking(){
        return "html/dataRegistrering/kundebooking";
    }

    @PostMapping("/nyBooking")
    public String nyBooking(
        RedirectAttributes attributes,
        @RequestParam("udstyr") String udstyr,
        @RequestParam("udlejningsStartDato") String udlejningsStartDato,
        @RequestParam("udeljningsSlutDato") String udeljningsSlutDato,
        @RequestParam("udleveringsStedID") String udleveringsStedID,
        @RequestParam("fornavn") String forNavn,
        @RequestParam("efternavn") String efterNavn,
        @RequestParam("email") String email,
        @RequestParam("tlf") String tlf,
        @RequestParam("CPR") String cpr,
        @RequestParam("vognNummer") String vognNummer) {
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

        System.out.println(forNavn + " " + efterNavn + " " + cpr);

        return "redirect:" + vognNummer;
    }

    @GetMapping("/nyBooking+{vognNummer}")
    public String nyBookingGet(
        Model model,
        @PathVariable("vognNummer") String vognNummer,
        @RequestParam("udstyr") String udstyr,
        @RequestParam("udlejningsStartDato") String udlejningsStartDato,
        @RequestParam("udeljningsSlutDato") String udeljningsSlutDato,
        @RequestParam("udleveringsStedID") String udleveringsStedID,
        @RequestParam("fornavn") String forNavn,
        @RequestParam("efternavn") String efterNavn,
        @RequestParam("email") String email,
        @RequestParam("tlf") String tlf,
        @RequestParam("CPR") String cpr) {
        model.addAttribute("udstyr", udstyr);
        model.addAttribute("udlejningsStartDato", udlejningsStartDato);
        model.addAttribute("udeljningsSlutDato", udeljningsSlutDato);
        model.addAttribute("udleveringsStedID", udleveringsStedID);
        model.addAttribute("fornavn", forNavn);
        model.addAttribute("efternavn", efterNavn);
        model.addAttribute("email", email);
        model.addAttribute("tlf", tlf);
        model.addAttribute("email", cpr);

        // har skrevet for at teste om den funere, 1 skal være ID
        BrugerModel kunde = new BrugerModel(vognNummer,forNavn, efterNavn, email, tlf, cpr );

        System.out.println(forNavn + " " + efterNavn + " " + cpr);

        //Når booking er gået igennem, skal der komme en bekræftelses side
        //Siden skal vise informationerne man har valgt
        return "html/successite";

    }

}
