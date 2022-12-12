package com.example.eksamensprojekt_2sem.model.bookingmodel;

public class AbonnementsTypeModel {

    private int id;
    private String type;

    public AbonnementsTypeModel() {
    }

    public AbonnementsTypeModel(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AbonnementsTypeModel{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
