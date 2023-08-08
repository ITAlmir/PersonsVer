package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImplementation implements PersonDao {
    static Connection con
            = DatabaseConnection.getConnection();

    @Override
    public int addPerson(Person pers, int houseId) throws SQLException {
        {

            String query
                    = "insert into person(person_id, "
                    + "first_name," + "last_name," + "birth_date," + "houseId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps
                    = con.prepareStatement(query);
            ps.setInt(1, pers.getPersonId());
            ps.setString(2, pers.getFirstName());
            ps.setString(3, pers.getLastName());
            ps.setString(4, pers.getBirthDate());
            ps.setInt(5, pers.getHouseId());
            int n = ps.executeUpdate();
            return n;
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String query
                = "delete from person where person_id =?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Person getPerson(int id) throws SQLException {
        String query
                = "select * from person where person_id= ?";
        PreparedStatement ps
                = con.prepareStatement(query);

        ps.setInt(1, id);
        Person pers = new Person();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            pers.setHouseId(rs.getInt("person_id"));
            pers.setFirstName(rs.getString("first_name"));
            pers.setLastName(rs.getString("last_name"));
            pers.setBirthDate(rs.getString("birth_date"));
            pers.setHouseId(rs.getInt("houseId"));
        }

        if (check == true) {
            System.out.println(pers.getPersonId());
            System.out.println(pers.getFirstName());
            System.out.println(pers.getLastName());
            System.out.println(pers.getBirthDate());
            System.out.println(pers.getHouseId());
            return pers;
        }
        else
            return null;
    }

    @Override
    public List<Person> getPerson() throws SQLException {
        String query = "select * from person";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Person> lsPersons = new ArrayList();

        while (rs.next()) {
            Person pers = new Person();
            pers.setHouseId(rs.getInt("haushalt_id"));
            pers.setFirstName(rs.getString("first_name"));
            pers.setLastName(rs.getString("last_name"));
            pers.setBirthDate(rs.getString("birth_date"));
            pers.setHouseId(rs.getInt("houseId"));
            lsPersons.add(pers);
        }
        return lsPersons;
    }

    @Override
    public void updatePerson(Person pers) throws SQLException {
        String query
                = "update person set first_name=?, "
                + " last_name= ?,"+"birth_date=?,"+"person_id where emp_id = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, pers.getFirstName());
        ps.setString(2, pers.getLastName());
        ps.setString(3, pers.getBirthDate());
        ps.setInt(4, pers.getPersonId());

        ps.executeUpdate();
    }
}
