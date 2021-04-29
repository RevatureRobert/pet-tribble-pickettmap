package dev.farm.service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dev.farm.dao.LabDao;
import dev.farm.model.Lab;

import java.util.ArrayList;
import java.util.List;

public class LabService {
    private LabDao ld = new LabDao();
    private Gson gson = new Gson();

    public List<Lab> viewAllLabs() {
        ArrayList<Lab> labs = new ArrayList<>();

        return (ArrayList<Lab>) ld.getAll();
    }

    public Lab findLab(int id) {
        return ld.getById(id);
    }

    public void buildLab(Lab l) {
        ld.insert(l);
    }

    public void buildLab(String json) throws Exception {
        try {
            Lab l = gson.fromJson(json, Lab.class);
            ld.insert(l);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public void renovateLab(Lab l){
        ld.update(l);
    }

    public void renovateLab(String json) throws Exception {
        try {
            Lab l = gson.fromJson(json, Lab.class);
            ld.update(l);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public void defundLab(Lab l) {
        ld.delete(l);
    }

    public void defundLab(int id) {
        ld.delete(id);
    }


}
