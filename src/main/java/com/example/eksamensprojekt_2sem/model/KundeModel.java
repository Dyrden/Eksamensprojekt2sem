package com.example.eksamensprojekt_2sem.model;

import java.util.List;

public class KundeModel {
    private int id;
    private String navn;
    private List<BilModel> biler;

    public KundeModel(int id, String navn, List<BilModel> biler){
        this.id = id;
        this.navn = navn;
        this.biler = biler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public List<BilModel> getBiler() {
        return biler;
    }

    public void setBiler(List<BilModel> biler) {
        this.biler = biler;
    }
    public String toString(){
        return "CPR-NR: "+id+ "\n" +
                "Navn: "+navn+ "\n"+
                "Biler: "+biler;

    }
}
