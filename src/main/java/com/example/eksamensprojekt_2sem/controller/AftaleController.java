package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.repository.AftaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AftaleController {

    @Autowired
    private AftaleRepository aftaleRepository;

    @Autowired
    public AftaleController(AftaleRepository aftaleRepository){
        this.aftaleRepository = aftaleRepository;
    }

    @GetMapping("/")
    public String showIndex(){
        return "html/index";
    }

    @GetMapping("/data")
    public String showData(){
        return "html/dataRegistrering";

    }
}
