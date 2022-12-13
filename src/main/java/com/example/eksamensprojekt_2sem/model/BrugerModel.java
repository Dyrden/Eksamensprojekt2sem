package com.example.eksamensprojekt_2sem.model;

public class BrugerModel {
  private int id;
  private String fornavn;
  private String efternavn;
  private String email;
  private String tlf;
  private String cpr;

  public BrugerModel(String fornavn, String efternavn, String email, String tlf, String cpr) {
    this.fornavn = fornavn;
    this.efternavn = efternavn;
    this.email = email;
    this.tlf = tlf;
    this.cpr = cpr;
  }

  public BrugerModel(int id, String fornavn, String efternavn, String email, String tlf, String cpr) {
    this.id = id;
    this.fornavn = fornavn;
    this.efternavn = efternavn;
    this.email = email;
    this.tlf = tlf;
    this.cpr = cpr;
  }

  public BrugerModel() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFornavn() {
    return fornavn;
  }

  public void setFornavn(String fornavn) {
    this.fornavn = fornavn;
  }

  public String getEfternavn() {
    return efternavn;
  }

  public void setEfternavn(String efternavn) {
    this.efternavn = efternavn;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTlf() {
    return tlf;
  }

  public void setTlf(String tlf) {
    this.tlf = tlf;
  }

  public String getCpr() {
    return cpr;
  }

  public void setCpr(String cpr) {
    this.cpr = cpr;
  }

  @Override
  public String toString() {
    return "BrugerModel{" +
        "id='" + id + '\'' +
        ", fornavn='" + fornavn + '\'' +
        ", efternavn='" + efternavn + '\'' +
        ", email='" + email + '\'' +
        ", tlf='" + tlf + '\'' +
        ", cpr='" + cpr + '\'' +
        '}';
  }
}