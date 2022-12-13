package com.example.eksamensprojekt_2sem.model;

public class RapportModel {
  private int id;
  private String dato;
  private String vognNummer;
  private String overSkredetKM;



  private int overskredetKM;

  public RapportModel() {
  }

  public RapportModel(int id, String dato, String vognNummer, String overSkredetKM) {
    this.id = id;
    this.dato = dato;
    this.vognNummer = vognNummer;
    this.overSkredetKM = overSkredetKM;
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

  public String getOverSkredetKM() {
    return overSkredetKM;
  }

  public void setOverSkredetKM(String overSkredetKM) {
    this.overSkredetKM = overSkredetKM;
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
        ", overSkredetKM='" + overSkredetKM + '\'' +
        '}';
  }
}