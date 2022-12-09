package com.example.eksamensprojekt_2sem.model;

public class BilModelModel {
    private int ID;
    private String model;


    public BilModelModel() {
    }

    public BilModelModel(int ID, String model) {
        this.ID = ID;
        this.model = model;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "BilModelModel{" +
            "ID=" + ID +
            ", model='" + model + '\'' +
            '}';
    }
}
