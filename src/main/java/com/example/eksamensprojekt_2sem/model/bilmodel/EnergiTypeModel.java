package com.example.eksamensprojekt_2sem.model.bilmodel;

public class EnergiTypeModel {

    private int energiTypeID;
    private String energiType;


    public EnergiTypeModel() {
    }

    public EnergiTypeModel(int energiTypeID, String energiType) {
        this.energiTypeID = energiTypeID;
        this.energiType = energiType;
    }

    public int getEnergiTypeID() {
        return energiTypeID;
    }

    public void setEnergiTypeID(int energiTypeID) {
        this.energiTypeID = energiTypeID;
    }

    public String getEnergiType() {
        return energiType;
    }

    public void setEnergiType(String energiType) {
        this.energiType = energiType;
    }

    @Override
    public String toString() {
        return getEnergiType();
    }
}
