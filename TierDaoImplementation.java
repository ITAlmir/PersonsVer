package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TierDaoImplementation implements TierDao {
    static Connection con
            = DatabaseConnection.getConnection();

    @Override
    public int addPet(Tier pet, int petId) throws SQLException {
        String query
                = "insert into tiere(tier_id, "
                + "race," + "pet_name," + "person_id) VALUES (?, ?, ?, ?)";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, pet.getTierId());
        ps.setString(2, pet.getRace());
        ps.setString(3, pet.getTierName());
        ps.setInt(4, pet.getPersonId());
        int n = ps.executeUpdate();
        return n;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query
                = "delete from tiere where tier_id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Tier getPet(int id) throws SQLException {
        String query
                = "select * from tiere where tier_id= ?";
        PreparedStatement ps
                = con.prepareStatement(query);

        ps.setInt(1, id);
        Tier tier = new Tier();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            tier.setTierId(rs.getInt("tier_id"));
            tier.setRace(rs.getString("race"));
            tier.setTierName(rs.getString("pet_name"));
            tier.setPersonId(rs.getInt("person_id"));
        }

        if (check == true) {
            System.out.println(tier.getTierId());
            System.out.println(tier.getRace());
            System.out.println(tier.getTierName());
            System.out.println(tier.getPersonId());
            return tier;
        } else
            return null;
    }

    @Override
    public List<Tier> getPets() throws SQLException {
        String query = "select * from tiere";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Tier> lsTiere = new ArrayList();

        while (rs.next()) {
            Tier pets = new Tier();
            pets.setTierId(rs.getInt("tier_id"));
            pets.setRace(rs.getString("race"));
            pets.setTierName(rs.getString("pet_name"));
            pets.setPersonId(rs.getInt("person_id"));
            lsTiere.add(pets);
        }
        return lsTiere;
    }

    @Override
    public void updatePet(Tier pet) throws SQLException {
        String query
                = "update tiere set race=?, "
                + " pet_name= ?,";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, pet.getRace());
        ps.setString(2, pet.getRace());
        ps.executeUpdate();
    }
}
