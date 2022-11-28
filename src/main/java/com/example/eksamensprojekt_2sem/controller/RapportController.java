package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.repository.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RapportController {

    @Autowired
    private RapportRepository rapportRepository;

    @Autowired
    public RapportController(RapportRepository rapportRepository){
        this.rapportRepository = rapportRepository;
    }
}
