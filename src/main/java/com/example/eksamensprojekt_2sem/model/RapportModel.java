package com.example.eksamensprojekt_2sem.model;

import java.time.LocalDateTime;
import java.util.List;

public class RapportModel {
    private LocalDateTime dato;
    private List<SkadeModel> skader;

    public RapportModel(LocalDateTime dato, List<SkadeModel> skader){
        this.dato = dato;
        this.skader = skader;
    }

    public LocalDateTime getDato() {
        return dato;
    }

    public void setDato(LocalDateTime dato) {
        this.dato = dato;
    }

    public List<SkadeModel> getSkader() {
        return skader;
    }

    public void setSkader(List<SkadeModel> skader) {
        this.skader = skader;
    }

    public String toString(){
        return "Dato: "+dato+ "\n" +
                "Skader: "+skader;

    }
}
