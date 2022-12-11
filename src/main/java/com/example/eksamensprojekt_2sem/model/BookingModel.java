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
  private int kilometerStart;
  private String bil_vognNummer;

  public BookingModel() {
  }

  public BookingModel(int id, int brugerID, String abonnementsType, String udleveringsSted, String startDato, String slutDato) {
    this.id = id;
    this.brugerID = brugerID;
    this.abonnementsType = abonnementsType;
    this.udleveringsSted = udleveringsSted;
    this.startDato = startDato;
    this.slutDato = slutDato;

  }

  public BookingModel(int id, int brugerID, String abonnementsType, String udleveringsSted, String startDato, String slutDato, int kilometerStart, String bil_vognNummer) {
    this.id = id;
    this.brugerID = brugerID;
    this.abonnementsType = abonnementsType;
    this.udleveringsSted = udleveringsSted;
    this.startDato = startDato;
    this.slutDato = slutDato;
    this.kilometerStart = kilometerStart;
    this.bil_vognNummer = bil_vognNummer;
  }

  public int getKilometerStart() {
    return kilometerStart;
  }

  public void setKilometerStart(int kilometerStart) {
    this.kilometerStart = kilometerStart;
  }

  public BookingModel(int id, int brugerID, int abonnementstypeID, String abonnementsType, int udleveringsStedID, String udleveringsSted, String startDato, String slutDato, int kilometerStart) {
    this.id = id;
    this.brugerID = brugerID;
    this.abonnementstypeID = abonnementstypeID;
    this.abonnementsType = abonnementsType;
    this.udleveringsStedID = udleveringsStedID;
    this.udleveringsSted = udleveringsSted;
    this.startDato = startDato;
    this.slutDato = slutDato;
    this.kilometerStart = kilometerStart;
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

  public String getBil_vognNummer() {
    return bil_vognNummer;
  }

  public void setBil_vognNummer(String bil_vognNummer) {
    this.bil_vognNummer = bil_vognNummer;
  }

  @Override
  public String toString() {
    return "BookingModel{" +
            "id=" + id +
            ", brugerID=" + brugerID +
            ", abonnementstypeID=" + abonnementstypeID +
            ", abonnementsType='" + abonnementsType + '\'' +
            ", udleveringsStedID=" + udleveringsStedID +
            ", udleveringsSted='" + udleveringsSted + '\'' +
            ", startDato='" + startDato + '\'' +
            ", slutDato='" + slutDato + '\'' +
            ", kilometerStart=" + kilometerStart +
            ", bil_vognNummer='" + bil_vognNummer + '\'' +
            '}';
  }
}
