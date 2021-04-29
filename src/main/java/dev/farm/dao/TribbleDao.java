package dev.farm.dao;

import dev.farm.model.Lab;
import dev.farm.model.Tribble;
import dev.farm.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TribbleDao implements GenericDao<Tribble> {

    @Override
    public ArrayList<Tribble> getAll() {
        ArrayList<Tribble> tribbles = new ArrayList<>();


        try (Connection c = ConnectionUtil.getConnection()) {
            String sql = "select * from tribbles";
            PreparedStatement ps = c.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Tribble t = new Tribble(
                        rs.getInt("id"),
                        rs.getInt("lab_id"),
                        rs.getString("color")
                );

                tribbles.add(t);
            }
            return tribbles;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("wheres the fucking connection");
        }

        return null;
    }

    @Override
    public Tribble getById(int id) {
        try (Connection c = ConnectionUtil.getConnection()) {
            String sql = "select * from tribbles where id=?";
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return new Tribble(
                        rs.getInt("id"),
                        rs.getInt("lab_id"),
                        rs.getString("color")
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public ArrayList<Tribble> getByLabId(int id) {
        ArrayList<Tribble> tribbles = new ArrayList<>();


        try (Connection c = ConnectionUtil.getConnection()) {
            String sql = "select * from tribbles where lab_id=?";
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Tribble t = new Tribble(
                        rs.getInt("id"),
                        rs.getInt("lab_id"),
                        rs.getString("color")
                );

                tribbles.add(t);
            }
            return tribbles;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void insert(Tribble tribble) {
        try (Connection c = ConnectionUtil.getConnection()) {
            String sql = "insert into tribbles (color, lab_id) values (?,?)";
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1,tribble.getColor());
            ps.setInt(2,tribble.getLabID());

            ps.executeUpdate();
            ps.closeOnCompletion();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Tribble tribble) {
        try (Connection c = ConnectionUtil.getConnection()) {
            String sql = "update tribbles set color = ? where id=?";
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1,tribble.getColor());
            ps.setInt(2,tribble.getId());

            ps.executeUpdate();
            ps.closeOnCompletion();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Tribble tribble) {
        try (Connection c = ConnectionUtil.getConnection()) {
            String sql = "delete from tribbles where id =?";
            PreparedStatement ps = c.prepareStatement(sql);

//            System.out.println(lab.getId());
            ps.setInt(1,tribble.getId());

            ps.executeUpdate();
            ps.closeOnCompletion();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection c = ConnectionUtil.getConnection()) {
            String sql = "delete from tribbles where id =?";
            PreparedStatement ps = c.prepareStatement(sql);

//            System.out.println(lab.getId());
            ps.setInt(1,id);

            ps.executeUpdate();
            ps.closeOnCompletion();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
