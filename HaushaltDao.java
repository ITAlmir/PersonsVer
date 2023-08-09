package org.example;
import java.sql.SQLException;
import java.util.List;

public interface HaushaltDao {
    public int add(Haushalt hshl)
            throws SQLException;
    public void delete(int id)
            throws SQLException;
    public Haushalt getHaushalt(int id)
            throws SQLException;
    public List<Haushalt> getHaushalt()
            throws SQLException;
    public void update(Haushalt hshl)
            throws SQLException;
    void getAllHaushalt()
            throws SQLException;
}
