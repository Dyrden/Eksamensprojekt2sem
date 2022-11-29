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

    @PostMapping("/tilfoej")
    public String tilfoejSkade(){
        return "html/skadeOgUdbedring/tilfoejSkade";
    }


}
