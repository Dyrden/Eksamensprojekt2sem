package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.repository.BilRepository;
import com.example.eksamensprojekt_2sem.repository.BookingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForretningsUdviklerController {

    private BilRepository bilRepository = new BilRepository();
    private BookingRepository bookingRepository = new BookingRepository();

    @GetMapping("/forretningsUdviklere")
    public String visForretningsUdviklere(Model model){
        model.addAttribute("bookedeBiler", bookingRepository.visAktiveBookinger());
        model.addAttribute("samledeIndtaegt", bookingRepository.visSamletIndtaegt());
        return "html/forretningsUdviklere";
    }
}
