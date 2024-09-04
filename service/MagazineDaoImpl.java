package service;

import java.sql.SQLException;

import DAO.MagazineDao;
import Model.Livre;
import Model.Magazine;
import Utils.DatabaseConnection;
import Utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MagazineDaoImpl implements MagazineDao  {

    private static Connection con = DatabaseConnection.getConnection();

    @Override
    public boolean addMagazine(Magazine magazine) throws SQLException {
        if (con == null) {
            throw new SQLException("Database connection is not initialized.");
        }

        String type = "Magazine";

        String query1 = "INSERT  INTO Document (titre, auteur, datePublication, nombreDePages, type) VALUES (?, ?, ?, ?, ?) ";
        String query2 = "INSERT INTO Magazine (document_id, numero) VALUES (LAST_INSERT_ID(), ?) ";

        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;


        try {
                con.setAutoCommit(false);
                ps1 = con.prepareStatement(query1);
                ps1.setString(1, magazine.getTitre());
                ps1.setString(2, magazine.getAuteur());
                ps1.setDate(3, new java.sql.Date(magazine.getDatePublication().getTime()));
                ps1.setInt(4, magazine.getNombresPages());
                ps1.setString(5, type);
                int n1 = ps1.executeUpdate();
                if(n1==1){
                    ps2 = con.prepareStatement(query2);
                    ps2.setLong(1, magazine.getNumero());

                    int n2 = ps2.executeUpdate();
                    if(n2==1){
                        con.commit();
                        return n2==1;
                    }
                    else {
                        con.rollback();
                        return false;
                    }

                }else {
                    con.rollback();
                    return false;
                }

            
        } catch (SQLException e) {
            e.printStackTrace();
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();
                }
            }
            return false;
        }
        finally {
            try {
                if (con != null) {
                    con.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    
            if (ps1 != null) {
                try {
                    ps1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    
            if (ps2 != null) {
                try {
                    ps2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }




   
    
}
