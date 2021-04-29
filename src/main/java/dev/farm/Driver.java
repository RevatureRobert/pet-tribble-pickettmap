package dev.farm;

import dev.farm.model.Tribble;
import dev.farm.service.TribbleService;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        TribbleService ts = new TribbleService();

        Tribble t = new Tribble(1, "yellow");

//        ts.createTribble(t);

        ArrayList<Tribble> tlist = (ArrayList<Tribble>) ts.getAllTribbles();
        for(Tribble t1 : tlist) {
            System.out.println(t1);
        }
    }
}
