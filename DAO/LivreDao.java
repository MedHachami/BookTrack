package DAO;

import Model.Livre;

import java.sql.SQLException;


public interface LivreDao {
    void addLivre(Livre livreDto) throws SQLException;;
    // void updateLivre(Livre)
}
