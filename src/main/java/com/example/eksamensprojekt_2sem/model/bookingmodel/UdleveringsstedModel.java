package com.example.eksamensprojekt_2sem.model.bookingmodel;

public class UdleveringsstedModel {

    private int id;
    private String sted;

    public UdleveringsstedModel() {
    }

    public UdleveringsstedModel(int id, String sted) {
        this.id = id;
        this.sted = sted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    @Override
    public String toString() {
        return "UdleveringsstedModel{" +
            "id=" + id +
            ", sted='" + sted + '\'' +
            '}';
    }
}
