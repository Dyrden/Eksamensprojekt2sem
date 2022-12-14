package com.example.eksamensprojekt_2sem.model;

import java.util.List;

public class BilModel {

    private String vognNummer;
    private String stelNummer;
    private int maerkeID;
    private String maerke;
    private int modelID;
    private String model;

    private String energiType;

    private String gearboks;

    private String udstyr;
  private int statusID;
  private String status;
  private int farveID;
  private String farve;
  private double staalPris;
  private double registreringsAfgift;
  private double CO2Udledning;
  private int produktionsaar;
  private int distance;
  private double maanedsPris;

  private int bookingID;


  public BilModel(String vognNummer, String stelNummer, String maerke, String model, String energiType, String gearboks, String udstyr, String status, String farve, double staalPris, double registreringsAfgift, double CO2Udledning, int produktionsaar, int distance, double maanedsPris) {
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
    this.maanedsPris = maanedsPris;

  }

  public BilModel(String maerke, String model, String vognNummer, String stelNummer){
      this.maerke = maerke;
      this.model = model;
      this.vognNummer = vognNummer;
      this.stelNummer = stelNummer;
  }


    public BilModel(String vognNummer, String stelNummer, String maerke, String model, String energiType, String gearboks, String udstyr, String status, String farve, double staalPris, double registreringsAfgift, double CO2Udledning, int produktionsaar, int distance) {
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
    }

    public BilModel(String vognNummer, String stelNummer, int maerkeID, int modelID, int statusID, int farveID, double staalPris, double registreringsAfgift, double CO2Udledning, int produktionsaar, int distance) {
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
    }

    public BilModel(String vognNummer, String stelNummer, String maerke, String model, String status, String farve, double staalPris, double registreringsAfgift, double CO2Udledning, int produktionsaar, int distance) {
        this.vognNummer = vognNummer;
        this.stelNummer = stelNummer;
        this.maerke = maerke;
        this.model = model;
        this.status = status;
        this.farve = farve;
        this.staalPris = staalPris;
        this.registreringsAfgift = registreringsAfgift;
        this.CO2Udledning = CO2Udledning;
        this.produktionsaar = produktionsaar;
        this.distance = distance;
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

    public String getEnergiType() {
        return energiType;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
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


    public BilModel() {
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

    public double getMaanedsPris() {
        return maanedsPris;
    }

    public void setMaanedsPris(double maanedsPris) {
        this.maanedsPris = maanedsPris;
    }

    @Override
    public String toString() {
        return "BilModel{" +
                "vognNummer='" + vognNummer + '\'' +
                ", stelNummer='" + stelNummer + '\'' +
                ", maerkeID=" + maerkeID +
                ", maerke='" + maerke + '\'' +
                ", modelID=" + modelID +
                ", model='" + model + '\'' +
                ", energiType='" + energiType + '\'' +
                ", gearboks='" + gearboks + '\'' +
                ", udstyr='" + udstyr + '\'' +
                ", statusID=" + statusID +
                ", status='" + status + '\'' +
                ", farveID=" + farveID +
                ", farve='" + farve + '\'' +
                ", staalPris=" + staalPris +
                ", registreringsAfgift=" + registreringsAfgift +
                ", CO2Udledning=" + CO2Udledning +
                ", produktionsaar=" + produktionsaar +
                ", distance=" + distance +
                ", maanedsPris=" + maanedsPris +
                '}';
    }
}
