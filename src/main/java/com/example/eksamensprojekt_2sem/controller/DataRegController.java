package com.example.eksamensprojekt_2sem.controller;

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
    private BilRepository bilRepository = new BilRepository();

    @GetMapping("/dataRegistrering")
    public String visDataReg(){
        return "html/dataRegistrering/dataRegistrering";
    }

    @GetMapping("/kundeBooking")
    public String kundeBooking(){
        return "html/dataRegistrering/kundebooking";
    }
    @GetMapping("/bookBil/{id}")
    public String bookBil(@PathVariable("vognNummer") int vognNummer, Model model) {
        model.addAttribute("vognNummerID", vognNummer);
        return "html/dataRegistrering/kundeBooking";
    }

    @PostMapping("/nyBooking")
    public String nyBooking(
        RedirectAttributes attributes,

        @RequestParam("fornavn") String forNavn,
        @RequestParam("efternavn") String efterNavn,
        @RequestParam("email") String email,
        @RequestParam("tlf") String tlf,
        @RequestParam("CPR") String cpr,
        @RequestParam("vognNummer") String vognNummer) {

        attributes.addAttribute("fornavn", forNavn);
        attributes.addAttribute("efternavn", efterNavn);
        attributes.addAttribute("email", email);
        attributes.addAttribute("tlf", tlf);
        attributes.addAttribute("email", cpr);
        attributes.addAttribute("vognNummer", vognNummer);

        System.out.println(forNavn + " " + efterNavn + " " + cpr);

        return "redirect:" + vognNummer;

    }

    @PostMapping("/nyBooking+{vognNummer}")
    public String nyBookingGet(
        RedirectAttributes attributes,

        @RequestParam("fornavn") String forNavn,
        @RequestParam("efternavn") String efterNavn,
        @RequestParam("email") String email,
        @RequestParam("tlf") String tlf,
        @RequestParam("CPR") String cpr,
        @RequestParam("vognNummer") String vognNummer) {

        attributes.addAttribute("fornavn", forNavn);
        attributes.addAttribute("efternavn", efterNavn);
        attributes.addAttribute("email", email);
        attributes.addAttribute("tlf", tlf);
        attributes.addAttribute("email", cpr);
        attributes.addAttribute("vognNummer", vognNummer);


        System.out.println(forNavn + " " + efterNavn + " " + cpr);

        //Når booking er gået igennem, skal der komme en bekræftelses side
        //Siden skal vise informationerne man har valgt
        return "html/successite";

    }

}
