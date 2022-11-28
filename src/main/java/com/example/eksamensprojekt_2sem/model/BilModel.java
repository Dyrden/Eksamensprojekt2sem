package com.example.eksamensprojekt_2sem.model;

import java.util.List;

public class BilModel {

    private int bilID;
    private int stelID;
    private String model;
    private String farve;
    private boolean udlejningsStatus;
    private double antalKilometer;
    private List<AftaleModel> aftaler;

    public BilModel(int bilID, int stelID, String model, String farve, boolean udlejningsStatus,
                    double antalKilometer, List<AftaleModel> aftaler){
        this.bilID = bilID;
        this.stelID = stelID;
        this.model = model;
        this.farve = farve;
        this.udlejningsStatus = udlejningsStatus;
        this.antalKilometer = antalKilometer;
        this.aftaler = aftaler;
    }

    public void setBilID(int bilID){
        this.bilID = bilID;
    }
    public void setStelID(int stelID){
        this.stelID = stelID;
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
    public int getBilID(){
        return bilID;
    }
    public int getStelID(){
        return stelID;
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
        return "BilID: "+bilID+ "\n" +
                "StelID: "+stelID+ "\n" +
                "Model: "+model+ "\n" +
                "Farve: "+farve+ "\n" +
                "Udlejningsstatus: "+udlejningsStatus+ "\n" +
                "Antal Kilometer: "+antalKilometer+ "\n" +
                "Aftaler: "+aftaler;

    }

}
