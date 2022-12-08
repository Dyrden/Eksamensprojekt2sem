package com.example.eksamensprojekt_2sem.model;

public class MaerkeModel {

    private int maerkeID;
    private String maerke;


    public MaerkeModel() {
    }

    public MaerkeModel(int maerkeID, String maerke) {
        this.maerkeID = maerkeID;
        this.maerke = maerke;
    }

    public int getMaerkeID() {
        return maerkeID;
    }

    public void setMaerkeID(int maerkeID) {
        this.maerkeID = maerkeID;
    }

    public String getMaerke() {
        return maerke;
    }

    public void setMaerke(String maerke) {
        this.maerke = maerke;
    }

    @Override
    public String toString() {
        return "EnergiTypeModel{" +
            "energiTypeID=" + maerkeID +
            ", energiType='" + maerke + '\'' +
            '}';
    }
}
