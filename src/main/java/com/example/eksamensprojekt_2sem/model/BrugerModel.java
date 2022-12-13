package com.example.eksamensprojekt_2sem.model;

public class BrugerModel {
    private int id;
    private final String fornavn;
    private final String efternavn;
    private final String email;
    private final String tlf;
    private final String cpr;

    public BrugerModel(int id, String fornavn, String efternavn, String email, String tlf, String cpr) {
        this.id = id;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.email = email;
        this.tlf = tlf;
        this.cpr = cpr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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