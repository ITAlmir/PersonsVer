package org.example;

import java.sql.SQLException;
import java.util.List;

public interface TierDao {
    public int addPet(Tier pet,int petId)
            throws java.sql.SQLException;
    public void delete(int id)
            throws java.sql.SQLException;
    public Tier getPet(int id)
            throws java.sql.SQLException;
    public List<Tier> getPets()
            throws java.sql.SQLException;
    public void updatePet(Tier pet)
            throws SQLException;
    public void showAllPets()
            throws SQLException;
}
