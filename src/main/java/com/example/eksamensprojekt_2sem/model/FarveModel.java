package com.example.eksamensprojekt_2sem.model;

public class FarveModel {

    private int farveID;
    private String farve;


    public FarveModel() {
    }

    public FarveModel(int farveID, String farve) {
        this.farveID = farveID;
        this.farve = farve;
    }

    public int getFarveID() {
        return farveID;
    }

    public void setFarveID(int farveID) {
        this.farveID = farveID;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }

    @Override
    public String toString() {
        return getFarve();
    }
}
