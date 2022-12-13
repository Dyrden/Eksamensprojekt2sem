package com.example.eksamensprojekt_2sem.model;

public class BilOgBookingModel {
    private String vognNummer;
    private String stelNummer;
    private String maerke;
    private String model;
    private String energiType;
    private String gearboks;
    private String udstyr;
    private String status;
    private String farve;
    private double staalPris;
    private double registreringsAfgift;
    private double CO2Udledning;
    private int produktionsaar;
    private int distance;
    private double maanedspris;
    private int id;
    private int brugerID;
    private String abonnementsType;
    private String udleveringsSted;
    private String startDato;
    private String slutDato;

    public BilOgBookingModel(String vognNummer, String stelNummer, String maerke, String model, String energiType, String gearboks, String udstyr, String status, String farve, double staalPris, double registreringsAfgift, double CO2Udledning, int produktionsaar, int distance, double maanedspris, int id, int brugerID, String abonnementsType, String udleveringsSted, String startDato, String slutDato) {
        this.vognNummer = vognNummer;
        this.stelNummer = stelNummer;
        this.maerke = maerke;
        this.model = model;
        this.energiType = energiType;
        this.gearboks = gearboks;
        this.udstyr = udstyr;
        this.status = status;
        this.farve = farve;
        this.staalPris = staalPris;
        this.registreringsAfgift = registreringsAfgift;
        this.CO2Udledning = CO2Udledning;
        this.produktionsaar = produktionsaar;
        this.distance = distance;
        this.maanedspris = maanedspris;
        this.id = id;
        this.brugerID = brugerID;
        this.abonnementsType = abonnementsType;
        this.udleveringsSted = udleveringsSted;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public BilOgBookingModel() {
    }

    public String getVognNummer() {
        return vognNummer;
    }

    public void setVognNummer(String vognNummer) {
        this.vognNummer = vognNummer;
    }

    public String getStelNummer() {
        return stelNummer;
    }

    public void setStelNummer(String stelNummer) {
        this.stelNummer = stelNummer;
    }

    public String getMaerke() {
        return maerke;
    }

    public void setMaerke(String maerke) {
        this.maerke = maerke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGearboks() {
        return gearboks;
    }

    public void setGearboks(String gearboks) {
        this.gearboks = gearboks;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }

    public double getMaanedspris() {
        return maanedspris;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrugerID() {
        return brugerID;
    }

    public String getAbonnementsType() {
        return abonnementsType;
    }

    public String getStartDato() {
        return startDato;
    }

    public String getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(String slutDato) {
        this.slutDato = slutDato;
    }

    @Override
    public String toString() {
        return "BilOgBookingModel{" +
            "vognNummer='" + vognNummer + '\'' +
            ", stelNummer='" + stelNummer + '\'' +
            ", maerke='" + maerke + '\'' +
            ", model='" + model + '\'' +
            ", energiType='" + energiType + '\'' +
            ", gearboks='" + gearboks + '\'' +
            ", udstyr='" + udstyr + '\'' +
            ", status='" + status + '\'' +
            ", farve='" + farve + '\'' +
            ", staalPris=" + staalPris +
            ", registreringsAfgift=" + registreringsAfgift +
            ", CO2Udledning=" + CO2Udledning +
            ", produktionsaar=" + produktionsaar +
            ", distance=" + distance +
            ", maanedspris=" + maanedspris +
            ", id=" + id +
            ", brugerID=" + brugerID +
            ", abonnementsType='" + abonnementsType + '\'' +
            ", udleveringsSted='" + udleveringsSted + '\'' +
            ", startDato='" + startDato + '\'' +
            ", slutDato='" + slutDato + '\'' +
            '}';
    }
}

