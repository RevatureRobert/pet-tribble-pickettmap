package dev.farm.controller;

import dev.farm.service.LabService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

public class LabController extends AbstractController {
    LabService ls = new LabService();

    @Override
    public void get(HttpServletRequest req, HttpServletResponse res) {
        Enumeration<String> params = req.getParameterNames();
        res.setContentType("application/json");

        try{
            if(params.hasMoreElements()) {
                String id = req.getParameter("id");
                res.getWriter().println(gson.toJson(ls.findLab(Integer.parseInt(id))));
            }
            else {
                res.getWriter().println(gson.toJson(ls.viewAllLabs()));
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

            ls.buildLab(sb.toString());

            res.setStatus(200);
            res.getWriter().println("Lab successfully added");
        } catch (Exception e) {
            res.setStatus(400);
            try {
                res.getWriter().println("Could not create Lab");
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

            ls.renovateLab(sb.toString());
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
                res.getWriter().println("Could not delete Lab, check id");
            } else {
                ls.defundLab(Integer.parseInt(id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
