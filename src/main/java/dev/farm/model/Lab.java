package dev.farm.model;


import java.util.ArrayList;

public class Lab {
    private int id;
    private String name;
    private ArrayList<Tribble> tribbles = new ArrayList<>();

    public Lab() {
    }

    public Lab(String name) {
        this.name = name;
    }

    public Lab(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
