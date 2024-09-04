package DAO;

import Model.Livre;

import java.sql.SQLException;


public interface LivreDao {
    boolean addLivre(Livre livreDto) throws SQLException;
    // Livre getLivreById(Long id) throws SQLException;
    
    // void updateLivre(Livre)
}
