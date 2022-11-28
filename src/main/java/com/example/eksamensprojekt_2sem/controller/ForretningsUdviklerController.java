package com.example.eksamensprojekt_2sem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForretningsUdviklerController {

    @GetMapping("/forretningsUdviklere")
    public String visForretningsUdviklere(){
        return "html/forretningsUdviklere";
    }
}
