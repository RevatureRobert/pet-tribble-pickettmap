package dev.farm.service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dev.farm.dao.TribbleDao;
import dev.farm.model.Tribble;

import java.util.List;

public class TribbleService {
    private TribbleDao td = new TribbleDao();
    private Gson gson = new Gson();

    public List<Tribble> getAllTribbles() {

        return td.getAll();

    }

    public List<Tribble> getTribblesByLab(int id) {

        return td.getByLabId(id);

    }

    public Tribble findTribble(int id) {
        return td.getById(id);
    }

    public void createTribble(Tribble t) {
        td.insert(t);
    }

    public void createTribble(String json) throws Exception {
        try {
            Tribble t = gson.fromJson(json, Tribble.class);
            td.insert(t);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }

    public void udpateTribble(Tribble t){
        td.update(t);
    }

    public void updateTribble(String json) throws Exception {
        try {
            Tribble t = gson.fromJson(json, Tribble.class);
            td.update(t);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
    }


    public void destroyTribble(Tribble t) {
        td.delete(t);
    }

    public void destroyTribble(int id) {
        td.delete(id);
    }
}
