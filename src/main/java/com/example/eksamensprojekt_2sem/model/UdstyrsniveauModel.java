package com.example.eksamensprojekt_2sem.model;

public class UdstyrsniveauModel {

    private int udstyrsniveauID;
    private String udstyrsniveau;


    public UdstyrsniveauModel() {
    }

    public UdstyrsniveauModel(int udstyrsniveauID, String udstyrsniveau) {
        this.udstyrsniveauID = udstyrsniveauID;
        this.udstyrsniveau = udstyrsniveau;
    }

    public int getUdstyrsniveauID() {
        return udstyrsniveauID;
    }

    public void setUdstyrsniveauID(int udstyrsniveauID) {
        this.udstyrsniveauID = udstyrsniveauID;
    }

    public String getUdstyrsniveau() {
        return udstyrsniveau;
    }

    public void setUdstyrsniveau(String udstyrsniveau) {
        this.udstyrsniveau = udstyrsniveau;
    }

}
