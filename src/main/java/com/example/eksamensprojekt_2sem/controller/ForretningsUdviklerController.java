package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.repository.BookingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForretningsUdviklerController {

    private final BookingRepository bookingRepository;

    public ForretningsUdviklerController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/forretningsUdviklere") //Ferhat og Bjørn
    public String visForretningsUdviklere(Model model) {
        model.addAttribute("bookedeBiler", bookingRepository.visAktiveBookinger());
        model.addAttribute("samledeIndtaegt", bookingRepository.visSamletIndtaegt());
        model.addAttribute("samledeIndtaegtMaaned", bookingRepository.visSamletIndtaegtForDenneMåned());
        return "html/forretningsUdviklere";
    }
}
