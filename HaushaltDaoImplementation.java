package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.Haushalt;
import org.example.DatabaseConnection;

public class HaushaltDaoImplementation implements HaushaltDao{
    static Connection con
            = DatabaseConnection.getConnection();
    @Override
    public int add(Haushalt hshl) throws SQLException {
        {

            String query
                    = "insert into haushalt(haushalt_id, "
                    + "houseNum,"+ "city,"+ "address,"+ "zip) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps
                    = con.prepareStatement(query);
            ps.setInt(1, hshl.getHouseId());
            ps.setInt(2, hshl.getHouseNum());
            ps.setString(3,hshl.getCity());
            ps.setString(4,hshl.getAddress());
            ps.setInt(5,hshl.getZip());
            int n = ps.executeUpdate();
            return n;
        }
    }
    @Override
    public void delete(int id) throws SQLException {
        String query
                = "delete from haushalt where haushalt_id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Haushalt getHaushalt(int id) throws SQLException {
        String query
                = "select * from haushalt where haushalt_id= ?";
        PreparedStatement ps
                = con.prepareStatement(query);

        ps.setInt(1, id);
        Haushalt hshl = new Haushalt();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            hshl.setHouseId(rs.getInt("haushalt_id"));
            hshl.setHouseNum(rs.getInt("houseNum"));
            hshl.setCity(rs.getString("city"));
            hshl.setAddress(rs.getString("address"));
            hshl.setZip(rs.getInt("zip"));
        }

        if (check == true) {

            return hshl;
        }
        else
            return null;
    }

    @Override
    public List<Haushalt> getHaushalt() throws SQLException {
        String query = "select * from haushalt";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Haushalt> ls = new ArrayList();

        while (rs.next()) {
            Haushalt hshl = new Haushalt();
            hshl.setHouseId(rs.getInt("haushalt_id"));
            hshl.setHouseNum(rs.getInt("houseNum"));
            hshl.setCity(rs.getString("city"));
            hshl.setAddress(rs.getString("address"));
            hshl.setZip(rs.getInt("zip"));
            ls.add(hshl);
        }
        return ls;
    }

    @Override
    public void update(Haushalt hshl) throws SQLException {
        String query
                = "update haushalt set houseNum=?, "
                + " city= ?,"+"address=?, "+"zip=? where emp_id = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, hshl.getHouseNum());
        ps.setString(2, hshl.getCity());
        ps.setString(3, hshl.getAddress());
        ps.setInt(4, hshl.getZip());

        ps.executeUpdate();
    }
}
