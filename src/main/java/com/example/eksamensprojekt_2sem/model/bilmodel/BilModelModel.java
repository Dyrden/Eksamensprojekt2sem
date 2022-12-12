package com.example.eksamensprojekt_2sem.model.bilmodel;

public class BilModelModel {
    private int ID;
    private String model;
    private String energiType;
    private String gearboks;
    private String udstyrsNiveau;
    private String maerke;
    private String farve;


    public BilModelModel() {
    }

    public BilModelModel(int ID, String model) {
        this.ID = ID;
        this.model = model;
    }


    public BilModelModel(String model, String energiType, String gearboks, String udstyrsNiveau, String maerke, String farve) {
        this.model = model;
        this.energiType = energiType;
        this.gearboks = gearboks;
        this.udstyrsNiveau = udstyrsNiveau;
        this.maerke = maerke;
        this.farve = farve;
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

    public String getEnergiType() {
        return energiType;
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

    public String getUdstyrsNiveau() {
        return udstyrsNiveau;
    }

    public void setUdstyrsNiveau(String udstyrsNiveau) {
        this.udstyrsNiveau = udstyrsNiveau;
    }

    public String getMaerke() {
        return maerke;
    }

    public void setMaerke(String maerke) {
        this.maerke = maerke;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }

    @Override
    public String toString() {
        return "BilModelModel{" +
            "ID=" + ID +
            ", model='" + model + '\'' +
            '}';
    }
}
