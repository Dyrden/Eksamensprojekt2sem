package com.example.eksamensprojekt_2sem.model;

import java.util.List;

public class BilModel {

    private int vognNummer;
    private int stelNummer;
    private int maerkeID;
    private int modelID;
    private int statusID;
    private int farveID;
    private double staalPris;
    private double registreringsAfgift;
    private double CO2Udledning;
    private int produktionsaar;
    private int distance;
    private List<AftaleModel> aftaler;

    public BilModel(int vognNummer, int stelNummer, int maerkeID, int modelID, int statusID, int farveID, double staalPris, double registreringsAfgift, double CO2Udledning, int produktionsaar, int distance, List<AftaleModel> aftaler) {
        this.vognNummer = vognNummer;
        this.stelNummer = stelNummer;
        this.maerkeID = maerkeID;
        this.modelID = modelID;
        this.statusID = statusID;
        this.farveID = farveID;
        this.staalPris = staalPris;
        this.registreringsAfgift = registreringsAfgift;
        this.CO2Udledning = CO2Udledning;
        this.produktionsaar = produktionsaar;
        this.distance = distance;
        this.aftaler = aftaler;
    }

    public BilModel() {
    }

    public int getVognNummer() {
        return vognNummer;
    }

    public void setVognNummer(int vognNummer) {
        this.vognNummer = vognNummer;
    }

    public int getStelNummer() {
        return stelNummer;
    }

    public void setStelNummer(int stelNummer) {
        this.stelNummer = stelNummer;
    }

    public int getMaerkeID() {
        return maerkeID;
    }

    public void setMaerkeID(int maerkeID) {
        this.maerkeID = maerkeID;
    }

    public int getModelID() {
        return modelID;
    }

    public void setModelID(int modelID) {
        this.modelID = modelID;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public int getFarveID() {
        return farveID;
    }

    public void setFarveID(int farveID) {
        this.farveID = farveID;
    }

    public double getStaalPris() {
        return staalPris;
    }

    public void setStaalPris(double staalPris) {
        this.staalPris = staalPris;
    }

    public double getRegistreringsAfgift() {
        return registreringsAfgift;
    }

    public void setRegistreringsAfgift(double registreringsAfgift) {
        this.registreringsAfgift = registreringsAfgift;
    }

    public double getCO2Udledning() {
        return CO2Udledning;
    }

    public void setCO2Udledning(double CO2Udledning) {
        this.CO2Udledning = CO2Udledning;
    }

    public int getProduktionsaar() {
        return produktionsaar;
    }

    public void setProduktionsaar(int produktionsaar) {
        this.produktionsaar = produktionsaar;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return
            "vognNummer=" + vognNummer +
            "stelNummer=" + stelNummer +
            "maerkeID=" + maerkeID +
            "modelID=" + modelID +
            "statusID=" + statusID +
            "farveID=" + farveID +
            "staalPris=" + staalPris +
            "registreringsAfgift=" + registreringsAfgift +
            "CO2Udledning=" + CO2Udledning +
            "produktionsaar=" + produktionsaar +
            "disctance=" + distance;
    }
}