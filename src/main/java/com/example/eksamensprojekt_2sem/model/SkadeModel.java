package com.example.eksamensprojekt_2sem.model;

public class SkadeModel {
    private String skadensPlacering;
    private String skadensBeskrivelse;
    private double skadensPris;

    public SkadeModel(String skadensPlacering, String skadensBeskrivelse, double skadensPris) {
        this.skadensPlacering = skadensPlacering;
        this.skadensBeskrivelse = skadensBeskrivelse;
        this.skadensPris = skadensPris;
    }
    public SkadeModel(){

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

    @Override
    public String toString() {
        return
            "skadensPlacering='" + skadensPlacering + '\'' +
            ", skadensBeskrivelse='" + skadensBeskrivelse + '\'' +
            ", skadensPris=" + skadensPris;
    }
}
