package com.example.eksamensprojekt_2sem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String visHome(){
        return "html/startSideTest";
    }

    @GetMapping("/start")
    public String start(){

        return "html/home";
    }

}
