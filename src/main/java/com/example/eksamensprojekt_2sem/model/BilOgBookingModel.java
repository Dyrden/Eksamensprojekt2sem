package com.example.eksamensprojekt_2sem.model;

public class BilOgBookingModel {
    private String vognNummer;
    private String stelNummer;
    private int maerkeID;
    private String maerke;
    private int modelID;
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
    private int kilometerStart;
    private int id;
    private int brugerID;
    private int abonnementstypeID;
    private String abonnementsType;
    private int udleveringsStedID;
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

    public BilOgBookingModel(String vognNummer, String stelNummer, String maerke, String model, String energiType, String gearboks, String udstyr, String status, String farve, double staalPris, double registreringsAfgift, double CO2Udledning, int produktionsaar, int distance, double maanedspris, int kilometerStart, int id, int brugerID, String abonnementsType, String udleveringsSted, String startDato, String slutDato) {
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
        this.kilometerStart = kilometerStart;
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

    public int getModelID() {
        return modelID;
    }

    public void setModelID(int modelID) {
        this.modelID = modelID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEnergiType() {
        return energiType;
    }

    public void setEnergiType(String energiType) {
        this.energiType = energiType;
    }

    public String getGearboks() {
        return gearboks;
    }

    public void setGearboks(String gearboks) {
        this.gearboks = gearboks;
    }

    public String getUdstyr() {
        return udstyr;
    }

    public void setUdstyr(String udstyr) {
        this.udstyr = udstyr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
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

    public double getMaanedspris() {
        return maanedspris;
    }

    public void setMaanedspris(double maanedspris) {
        this.maanedspris = maanedspris;
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

    public void setBrugerID(int brugerID) {
        this.brugerID = brugerID;
    }

    public int getAbonnementstypeID() {
        return abonnementstypeID;
    }

    public void setAbonnementstypeID(int abonnementstypeID) {
        this.abonnementstypeID = abonnementstypeID;
    }

    public String getAbonnementsType() {
        return abonnementsType;
    }

    public void setAbonnementsType(String abonnementsType) {
        this.abonnementsType = abonnementsType;
    }

    public int getUdleveringsStedID() {
        return udleveringsStedID;
    }

    public void setUdleveringsStedID(int udleveringsStedID) {
        this.udleveringsStedID = udleveringsStedID;
    }

    public String getUdleveringsSted() {
        return udleveringsSted;
    }

    public void setUdleveringsSted(String udleveringsSted) {
        this.udleveringsSted = udleveringsSted;
    }

    public String getStartDato() {
        return startDato;
    }

    public void setStartDato(String startDato) {
        this.startDato = startDato;
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
            ", maerkeID=" + maerkeID +
            ", maerke='" + maerke + '\'' +
            ", modelID=" + modelID +
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
            ", abonnementstypeID=" + abonnementstypeID +
            ", abonnementsType='" + abonnementsType + '\'' +
            ", udleveringsStedID=" + udleveringsStedID +
            ", udleveringsSted='" + udleveringsSted + '\'' +
            ", startDato='" + startDato + '\'' +
            ", slutDato='" + slutDato + '\'' +
            '}';
    }
}

