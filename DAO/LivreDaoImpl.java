package DAO;

import java.sql.SQLException;

import DTO.LivreDto;
import Model.Livre;
import Utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LivreDaoImpl implements LivreDao {

    private Connection con;

    public LivreDaoImpl(){
        this.con = DatabaseConnection.getConnection();
    }


    @Override
    public void addLivre(Livre livre) throws SQLException {
        System.out.println(livre);

        if (this.con == null) {
            throw new SQLException("Database connection is not initialized.");
        }
        String query = "INSERT INTO Livre (titre, auteur, datePublication, nombresPages, isbn) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = this.con.prepareStatement(query);
    
        ps.setString(1, livre.getTitre());  
        ps.setString(2, livre.getAuteur()); 
        ps.setDate(3, new java.sql.Date(livre.getDatePublication().getTime()));
        ps.setInt(4, livre.getNombresPages());   
        ps.setLong(5, livre.getIsbn());     
        int n = ps.executeUpdate(); 
        ps.close(); 
    }
    
}
