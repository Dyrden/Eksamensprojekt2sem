package com.example.eksamensprojekt_2sem.model;

public class SkadeModel {
    private int id;
    private String skadensPlacering;
    private String skadensBeskrivelse;
    private double skadensPris;
    private int rapportID;

    public SkadeModel(int id, String skadensPlacering, String skadensBeskrivelse, double skadensPris, int rapportID) {
        this.id = id;
        this.skadensPlacering = skadensPlacering;
        this.skadensBeskrivelse = skadensBeskrivelse;
        this.skadensPris = skadensPris;
        this.rapportID = rapportID;
    }

    public SkadeModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkadensPlacering() {
        return skadensPlacering;
    }

    public void setSkadensPlacering(String skadensPlacering) {
        this.skadensPlacering = skadensPlacering;
    }

    public String getSkadensBeskrivelse() {
        return skadensBeskrivelse;
    }

    public void setSkadensBeskrivelse(String skadensBeskrivelse) {
        this.skadensBeskrivelse = skadensBeskrivelse;
    }

    public double getSkadensPris() {
        return skadensPris;
    }

    public void setSkadensPris(double skadensPris) {
        this.skadensPris = skadensPris;
    }

    public int getRapportID() {
        return rapportID;
    }

    public void setRapportID(int rapportID) {
        this.rapportID = rapportID;
    }

    @Override
    public String toString() {
        return "SkadeModel{" +
            "id=" + id +
            "skadensPlacering='" + skadensPlacering + '\'' +
            "skadensBeskrivelse='" + skadensBeskrivelse + '\'' +
            "skadensPris=" + skadensPris +
            "rapportID=" + rapportID;
    }
}
