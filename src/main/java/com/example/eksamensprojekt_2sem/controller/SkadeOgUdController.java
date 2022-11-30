package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.repository.BilRepository;
import com.example.eksamensprojekt_2sem.repository.RapportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SkadeOgUdController {

    private BilRepository bil;

    public SkadeOgUdController(BilRepository bilrep){
        bil = bilrep;
    }

    @GetMapping("/skadeOgUdbedring")
    public String visSkadeOgUd(){
        return "html/skadeOgUdbedring/skadeOgUdbedring";
    }

    @PostMapping("/udbedring")
    public String reUdbedring(){
        return "redirect:/skadeOgUdbedring";
    }

    @GetMapping("visSpecifikBil/{stelNummer}")
    public String visSpecifikBil(@PathVariable("stelNummer") String s, Model model){
        model.addAttribute("specifikBil", bil.sUVisning(s));
        return "html/skadeOgUdbedring/skadeOgUdbedring";
    }

    @GetMapping("/seSkader")
    public String visSkader(){
        return "html/skadeOgUdbedring/seSkader";
    }

    @GetMapping("/tilfoejSkade")
    public String tilfoejSkade(){
        return "html/skadeOgUdbedring/tilfoejSkade";
    }


}
