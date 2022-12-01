package com.example.eksamensprojekt_2sem.model;

import java.util.List;

public class BilModel {

    private int vognNummer;
    private int stelNummer;
    private String maerke;
    private String model;
    private String farve;
    private boolean udlejningsStatus;
    private double antalKilometer;
    private List<AftaleModel> aftaler;

    public BilModel(int vognNummer, int stelNummer, String maerke, String model, String farve, boolean udlejningsStatus,
                    double antalKilometer, List<AftaleModel> aftaler){
        this.vognNummer = vognNummer;
        this.stelNummer = stelNummer;
        this.maerke = maerke;
        this.model = model;
        this.farve = farve;
        this.udlejningsStatus = udlejningsStatus;
        this.antalKilometer = antalKilometer;
        this.aftaler = aftaler;
    }
    public BilModel(int vognNummer, int stelNummer, String maerke){
        this.vognNummer = vognNummer;
        this.stelNummer = stelNummer;
        this.maerke = maerke;
    }
    public String getMaerke() {
        return maerke;
    }

    public void setMaerke(String maerke) {
        this.maerke = maerke;
    }

    public void setVognNummer(int vognNummer){
        this.vognNummer = vognNummer;
    }
    public void setStelNummer(int stelNummer){
        this.stelNummer = stelNummer;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setFarve(String farve){
        this.farve = farve;
    }
    public void setUdlejningsStatus(boolean udlejningsStatus){
        this.udlejningsStatus = udlejningsStatus;
    }
    public void setAntalKilometer(double antalKilometer){
        this.antalKilometer = antalKilometer;
    }
    public void setAftaler(List<AftaleModel> aftaler){
        this.aftaler = aftaler;
    }
    public int getVognNummer(){
        return vognNummer;
    }
    public int getStelNummer(){
        return stelNummer;
    }
    public String getModel(){
        return model;
    }
    public String getFarve(){
        return farve;
    }
    public boolean getUdlejningsStatus(){
        return udlejningsStatus;
    }
    public double getAntalKilometer(){
        return antalKilometer;
    }
    public List<AftaleModel> getAftaler(){
        return aftaler;
    }

    public String toString(){
        return "BilID: "+ vognNummer + "\n" +
                "StelID: "+ stelNummer + "\n" +
                "Model: "+model+ "\n" +
                "Farve: "+farve+ "\n" +
                "Udlejningsstatus: "+udlejningsStatus+ "\n" +
                "Antal Kilometer: "+antalKilometer+ "\n" +
                "Aftaler: "+aftaler;

    }

}
