package DAO;

import Model.Magazine;

import java.sql.SQLException;

public interface MagazineDao {
    boolean addMagazine(Magazine magazine) throws SQLException;
    // Magazine getMagazineById(Long id) throws SQLException;


}
