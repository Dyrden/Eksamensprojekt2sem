package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.repository.KundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class KundeController {

    @Autowired
    private KundeRepository kundeRepository;

    @Autowired
    public KundeController(KundeRepository kundeRepository){
        this.kundeRepository = kundeRepository;
    }
}
