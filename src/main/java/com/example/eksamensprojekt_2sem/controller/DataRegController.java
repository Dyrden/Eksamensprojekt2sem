package com.example.eksamensprojekt_2sem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataRegController {

    @GetMapping("/dataRegistrering")
    public String visDataReg(){
        return "html/dataRegistrering/dataRegistrering";
    }
}
