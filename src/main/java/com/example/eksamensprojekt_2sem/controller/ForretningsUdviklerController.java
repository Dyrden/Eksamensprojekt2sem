package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.repository.BilRepository;
import com.example.eksamensprojekt_2sem.repository.BookingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForretningsUdviklerController {

    private final BookingRepository bookingRepository;
    private final BilRepository bilRepository;

    public ForretningsUdviklerController(BookingRepository bookingRepository, BilRepository bilRepository) {
        this.bookingRepository = bookingRepository;
        this.bilRepository = bilRepository;
    }


    @GetMapping("/forretningsUdviklere") //Ferhat og Bjørn
    public String visForretningsUdviklere(Model model){
        model.addAttribute("bookedeBiler", bookingRepository.visAktiveBookinger());
        model.addAttribute("samledeIndtaegt", bookingRepository.visSamletIndtaegt());
        model.addAttribute("samledeIndtaegtMaaned", bookingRepository.visSamletIndtaegtForDenneMåned());
        model.addAttribute("udlejetBiler", bilRepository.visUdlejetBiler());
        model.addAttribute("ikkeUdlejetBiler", bilRepository.visTilgaengeligeBiler());
        return "html/forretningsUdviklere";
    }
}
