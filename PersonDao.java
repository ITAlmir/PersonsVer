package org.example;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {
    public int addPerson(Person pers,int houseId)
            throws java.sql.SQLException;
    public void delete(int id)
            throws java.sql.SQLException;
    public Person getPerson(int id)
            throws java.sql.SQLException;
    public List<Person> getPerson()
            throws java.sql.SQLException;
    public void updatePerson(Person pers)
            throws SQLException;
    public void getAllPersons()
                 throws SQLException;
}
