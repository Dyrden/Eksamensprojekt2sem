package com.example.eksamensprojekt_2sem.controller;

import com.example.eksamensprojekt_2sem.repository.BilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BilController {

    @Autowired
    private BilRepository bilRepository;

    @Autowired
    public BilController(BilRepository bilRepository){
        this.bilRepository = bilRepository;
    }


}
