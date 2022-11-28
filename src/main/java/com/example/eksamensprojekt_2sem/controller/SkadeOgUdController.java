package com.example.eksamensprojekt_2sem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SkadeOgUdController {

    @GetMapping("/skadeOgUdbedring")
    public String visSkadeOgUd(){
        return "html/skadeOgUdbedring";
    }


}
