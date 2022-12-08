package com.example.eksamensprojekt_2sem.model;

public class GearboksModel {

    private int gearboksID;
    private String gearboks;


    public GearboksModel() {
    }

    public GearboksModel(int gearboksID, String gearboks) {
        this.gearboksID = gearboksID;
        this.gearboks = gearboks;
    }

    public int getGearboksID() {
        return gearboksID;
    }

    public void setGearboksID(int gearboksID) {
        this.gearboksID = gearboksID;
    }

    public String getGearboks() {
        return gearboks;
    }

    public void setGearboks(String gearboks) {
        this.gearboks = gearboks;
    }

}
