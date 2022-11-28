package com.example.eksamensprojekt_2sem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showIndex(){
        return "html/Index";
    }

    @GetMapping("/data")
    public String showData(){
        return "html/dataRegistrering";

    }
}
