package com.example.eksamensprojekt_2sem.model;

public class BookingModel {
    private int id;
    private final int brugerID;
    private final String abonnementsType;
    private final String udleveringsSted;
    private final String startDato;
    private final String slutDato;
    private final int kilometerStart;
    private final String bil_vognNummer;


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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BookingModel{" +
            "id=" + id +
            ", brugerID=" + brugerID +
            ", abonnementsType='" + abonnementsType + '\'' +
            ", udleveringsSted='" + udleveringsSted + '\'' +
            ", startDato='" + startDato + '\'' +
            ", slutDato='" + slutDato + '\'' +
            ", kilometerStart=" + kilometerStart +
            ", bil_vognNummer='" + bil_vognNummer + '\'' +
            '}';
    }
}
