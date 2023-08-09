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
                + " pet_name= ?,"+"person_id=? where tier_id = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, pet.getRace());
        ps.setString(2, pet.getTierName());
        ps.setInt(3, pet.getPersonId());
        ps.setInt(4, pet.getTier_id());


        ps.executeUpdate();
    }
    public void showAllPets() throws SQLException{
        String query
                = "select * from tiere";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        char ch = '-';
        String repeatedChars = String.valueOf(ch).repeat(73);
        System.out.printf(repeatedChars);
        System.out.println();

        System.out.printf("%-4s | %-15s | %-15s |  %-10s%n", "id", "Race", "Pet's Name", "Owner");
        System.out.printf(repeatedChars);
        System.out.println();
        while (resultSet.next()) {
            // Retrieve column values for the current row
            int id = resultSet.getInt("tier_id");
            String race = resultSet.getString("race");
            String petName = resultSet.getString("pet_name");
            int personId = resultSet.getInt("person_id");


            // Retrieve other columns as needed

            // Print column values for the current row
            System.out.printf("%-4s | %-15s | %-15s | %-10s%n", id, race, petName, personId);

            // Print other columns as needed
            //------------------------------------------------------------

        }
        System.out.println();
        System.out.printf(repeatedChars);
        System.out.println();
        resultSet.close();
        preparedStatement.close();
    }
}
