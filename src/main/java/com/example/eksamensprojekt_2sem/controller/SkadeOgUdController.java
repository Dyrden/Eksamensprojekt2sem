package com.example.eksamensprojekt_2sem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SkadeOgUdController {

    @GetMapping("/skadeOgUdbedring")
    public String visSkadeOgUd(){
        return "html/skadeOgUdbedring/skadeOgUdbedring";
    }

    @PostMapping("/udbedring")
    public String reUdbedring(){
        return "redirect:/skadeOgUdbedring";
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
