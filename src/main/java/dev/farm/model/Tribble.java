package dev.farm.model;

import java.util.Objects;

public class Tribble {
    private int id;
    private int labID;
    private String color;

    public Tribble() {
    }

    public Tribble(int labID, String color) {
        this.labID = labID;
        this.color = color;
    }

    public Tribble(int id, int labID, String color) {
        this.id = id;
        this.labID = labID;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLabID() {
        return labID;
    }

    public void setLabID(int labID) {
        this.labID = labID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Tribble{" +
                "id=" + id +
                ", labID=" + labID +
                ", color='" + color + '\'' +
                '}';
    }
}
