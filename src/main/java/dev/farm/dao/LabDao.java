package dev.farm.dao;

import dev.farm.model.Lab;
import dev.farm.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LabDao implements GenericDao<Lab> {
    @Override
    public ArrayList<Lab> getAll() {
        ArrayList<Lab> labs = new ArrayList<>();


        try (Connection c = ConnectionUtil.getConnection()) {
            String sql = "select * from labs";
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Lab l = new Lab(
                        rs.getInt("id"),
                        rs.getString("lab_name")
                );

                labs.add(l);
            }
            return labs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public Lab getById(int id) {
        try (Connection c = ConnectionUtil.getConnection()) {
            String sql = "select * from labs where id=?";
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return new Lab(
                        rs.getInt("id"),
                        rs.getString("lab_name")
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

//    public void getByIdWithTribbles(int id) {
//
//    }

    @Override
    public void insert(Lab lab) {
        try (Connection c = ConnectionUtil.getConnection()) {
            String sql = "insert into labs (lab_name) values (?)";
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1,lab.getName());

            ps.executeUpdate();
            ps.closeOnCompletion();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
//
//    public void insertWithTribbles(Lab lab) {
//        try(Connection c = ConnectionUtil.getConnection())
//    }

    @Override
    public void update(Lab lab) {
        try (Connection c = ConnectionUtil.getConnection()) {
            String sql = "update labs set lab_name = ? where id=?";
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1,lab.getName());
            ps.setInt(2,lab.getId());

            ps.executeUpdate();
            ps.closeOnCompletion();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void delete(Lab lab) {
        try (Connection c = ConnectionUtil.getConnection()) {
            String sql = "delete from labs where id =?";
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1,lab.getId());

            ps.executeUpdate();
            ps.closeOnCompletion();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void delete(int id) {
        try (Connection c = ConnectionUtil.getConnection()) {
            String sql = "delete from labs where id =?";
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1,id);

            ps.executeUpdate();
            ps.closeOnCompletion();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
