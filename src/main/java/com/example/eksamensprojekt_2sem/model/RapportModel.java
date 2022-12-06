package com.example.eksamensprojekt_2sem.model;

public class RapportModel {
  private int id;
  private String dato;
  private String vognNummer;
  private String stelNummer;
  private int maerkeID;
  private String maerke;
  private int modelID;
  private String model;
  private int statusID;
  private String status;
  private int farveID;
  private String farve;
  private String staalPris;
  private String registreringsAfgift;
  private String CO2Udledning;
  private String produktionsaar;
  private String distance;

  private int overskredetKM;

  public RapportModel() {
  }

  public RapportModel(int id, String dato, String vognNummer, String stelNummer, int maerkeID, int modelID, int statusID, int farveID, String staalPris, String registreringsAfgift, String CO2Udledning, String produktionsaar, String distance) {
    this.id = id;
    this.dato = dato;
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

  public RapportModel(int id, String dato, String vognNummer, String stelNummer, int maerkeID, String maerke, int modelID, String model, int statusID, String status, int farveID, String farve, String staalPris, String registreringsAfgift, String CO2Udledning, String produktionsaar, String distance) {
    this.id = id;
    this.dato = dato;
    this.vognNummer = vognNummer;
    this.stelNummer = stelNummer;
    this.maerkeID = maerkeID;
    this.maerke = maerke;
    this.modelID = modelID;
    this.model = model;
    this.statusID = statusID;
    this.status = status;
    this.farveID = farveID;
    this.farve = farve;
    this.staalPris = staalPris;
    this.registreringsAfgift = registreringsAfgift;
    this.CO2Udledning = CO2Udledning;
    this.produktionsaar = produktionsaar;
    this.distance = distance;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDato() {
    return dato;
  }

  public void setDato(String dato) {
    this.dato = dato;
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

  public int getStatusID() {
    return statusID;
  }

  public void setStatusID(int statusID) {
    this.statusID = statusID;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public String getStaalPris() {
    return staalPris;
  }

  public void setStaalPris(String staalPris) {
    this.staalPris = staalPris;
  }

  public String getRegistreringsAfgift() {
    return registreringsAfgift;
  }

  public void setRegistreringsAfgift(String registreringsAfgift) {
    this.registreringsAfgift = registreringsAfgift;
  }

  public String getCO2Udledning() {
    return CO2Udledning;
  }

  public void setCO2Udledning(String CO2Udledning) {
    this.CO2Udledning = CO2Udledning;
  }

  public String getProduktionsaar() {
    return produktionsaar;
  }

  public void setProduktionsaar(String produktionsaar) {
    this.produktionsaar = produktionsaar;
  }

  public String getDistance() {
    return distance;
  }

  public void setDistance(String distance) {
    this.distance = distance;
  }

  public int getOverskredetKM() {
    return overskredetKM;
  }

  public void setOverskredetKM(int overskredetKM) {
    this.overskredetKM = overskredetKM;
  }

  @Override
  public String toString() {
    return "RapportModel{" +
        "id=" + id +
        ", dato='" + dato + '\'' +
        ", vognNummer='" + vognNummer + '\'' +
        ", stelNummer='" + stelNummer + '\'' +
        ", maerkeID=" + maerkeID +
        ", maerke='" + maerke + '\'' +
        ", modelID=" + modelID +
        ", model='" + model + '\'' +
        ", statusID=" + statusID +
        ", status='" + status + '\'' +
        ", farveID=" + farveID +
        ", farve='" + farve + '\'' +
        ", staalPris='" + staalPris + '\'' +
        ", registreringsAfgift='" + registreringsAfgift + '\'' +
        ", CO2Udledning='" + CO2Udledning + '\'' +
        ", produktionsaar='" + produktionsaar + '\'' +
        ", distance='" + distance + '\'' +
        '}';
  }
}

