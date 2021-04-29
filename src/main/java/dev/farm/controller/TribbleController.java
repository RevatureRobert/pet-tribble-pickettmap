package dev.farm.controller;

import dev.farm.service.TribbleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

public class TribbleController extends AbstractController{
    TribbleService ts = new TribbleService();

    @Override
    public void get(HttpServletRequest req, HttpServletResponse res) {
        Enumeration<String> params = req.getParameterNames();
        res.setContentType("application/json");

        try{
            if(params.hasMoreElements()) {
                String id = req.getParameter("lab-id");
                res.getWriter().println(gson.toJson(ts.getTribblesByLab(Integer.parseInt(id))));
            }
            else {
                res.getWriter().println(gson.toJson(ts.getAllTribbles()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void post(HttpServletRequest req, HttpServletResponse res) {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = req.getReader()) {
            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }

            ts.createTribble(sb.toString());

            res.setStatus(200);
            res.getWriter().println("Tribble successfully added");
        } catch (Exception e) {
            res.setStatus(400);
            try {
                res.getWriter().println("Could not create Tribble");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }

    @Override
    public void put(HttpServletRequest req, HttpServletResponse res) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = req.getReader()){
            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }

            ts.updateTribble(sb.toString());
            res.setStatus(200);
            res.getWriter().println("Tribble successfully updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");

        try {
            if(id == null) {
                res.setStatus(400);
                res.getWriter().println("Could not delete Tribble, check id");
            } else {
                ts.destroyTribble(Integer.parseInt(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
