package com.example.eksamensprojekt_2sem.model;

import java.time.LocalDateTime;

public class AftaleModel {
    private LocalDateTime startDato;
    private String slutDato;
    private double maanedsPris;
    private double sumPris;
    private int id;

    public AftaleModel(LocalDateTime startDato, String slutDato, double maanedsPris, double sumPris,
    int id){
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.maanedsPris = maanedsPris;
        this.sumPris = sumPris;
        this.id = id;

    }
    public void setStartDato(LocalDateTime startDato){
        this.startDato = startDato;

    }
    public void setSlutDato(String slutDato){
        this.slutDato = slutDato;

    }
    public void setMaanedsPris(double maanedsPris){
        this.maanedsPris = maanedsPris;

    }
    public void setSumPris(double sumPris){
        this.sumPris = sumPris;

    }
    public void setId(int id){
        this.id = id;

    }
    public LocalDateTime getStartDato(){
        return this.startDato;
    }
    public String getSlutDato(){
        return this.slutDato;
    }
    public double getMaanedsPris(){
        return this.maanedsPris;
    }
    public double getSumPris(){
        return this.sumPris;
    }
    public int getId(){
        return this.id;
    }

    public String toString(){
        return "Startdato: "+startDato+ "\n" +
                "Slutdato: "+slutDato+ "\n"+
                "Månedspris: "+maanedsPris+ "\n"+
                "Sumpris: "+sumPris+ "\n"+
                "ID: "+id;

    }


}
