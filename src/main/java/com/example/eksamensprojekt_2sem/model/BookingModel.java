package com.example.eksamensprojekt_2sem.model;

public class BookingModel {
  private int id;
  private int brugerID;
  private int abonnementstypeID;
  private String abonnementsType;
  private int udleveringsStedID;
  private String udleveringsSted;
  private String startDato;
  private String slutDato;
  private double maanedspris;

  public BookingModel() {
  }

  public BookingModel(int id, int brugerID, String abonnementsType, String udleveringsSted, String startDato, String slutDato, double maanedspris) {
    this.id = id;
    this.brugerID = brugerID;
    this.abonnementsType = abonnementsType;
    this.udleveringsSted = udleveringsSted;
    this.startDato = startDato;
    this.slutDato = slutDato;
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

  public double getMaanedspris() {
    return maanedspris;
  }

  public void setMaanedspris(double maanedspris) {
    this.maanedspris = maanedspris;
  }

  @Override
  public String toString() {
    return "BookingModel{" +
        "id=" + id +
        ", brugerID=" + brugerID +
        ", abonnementstypeID=" + abonnementstypeID +
        ", abonnementstype='" + abonnementsType + '\'' +
        ", udleveringsStedID=" + udleveringsStedID +
        ", udleveringsSted='" + udleveringsSted + '\'' +
        ", startDato='" + startDato + '\'' +
        ", slutDato='" + slutDato + '\'' +
        ", maanedspris=" + maanedspris +
        '}';
  }
}
