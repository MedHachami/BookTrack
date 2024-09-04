package service;

import DAO.DocumentDao;
import Model.Document;
import Model.Livre;
import Model.Magazine;
import Utils.DatabaseConnection;
import java.sql.*;
import java.util.*;




public class BibiloDaoImpl implements DocumentDao {

    private static Connection con = DatabaseConnection.getConnection();


    @Override
    public List<Document>  getDocumentByName(String name)  throws SQLException  {
        List<Document> documents = new ArrayList<>();
        if (con == null) {
            throw new SQLException("Database connection is not initialized.");
        }


        String query1 = "SELECT * FROM Document WHERE titre LIKE ? AND available = 1 ";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(query1);
            ps.setString(1, "%"+name+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String type = rs.getString("type");
               if( type.equals("Livre")){
                    Livre livre = new Livre();
                    livre.setId(rs.getLong("id"));
                    livre.setTitre(rs.getString("titre"));
                    livre.setAuteur(rs.getString("auteur"));
                    livre.setDatePublication(rs.getDate("datePublication"));
                    livre.setNombresPages(rs.getInt("nombreDePages"));
                    livre.setType("Livre");

                    documents.add(livre);

               }else if(type == "Magazine"){
                    Magazine magazine = new Magazine();
                    magazine.setId(rs.getLong("id"));
                    magazine.setTitre(rs.getString("titre"));
                    magazine.setAuteur(rs.getString("auteur"));
                    magazine.setDatePublication(rs.getDate("datePublication"));
                    magazine.setNombresPages(rs.getInt("nombreDePages"));
                    magazine.setType("Magazine");

                    documents.add(magazine);
                    

               }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return documents; 
    }


    @Override
    public boolean emprunterDocuemnt(Long id) throws SQLException {

        if (con == null) {
            throw new SQLException("Database connection is not initialized.");
        }

        String query1 = "UPDATE Document SET available = ? WHERE id = ?";
        PreparedStatement ps = null;

        try {
        
            ps = con.prepareStatement(query1);
            ps.setInt(1, 0);
            ps.setLong(2, id);

            int n = ps.executeUpdate();
            return n==1;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    @Override
    public List<Document> allDocuments() throws SQLException {
        List<Document> documents = new ArrayList<>();
        if (con == null) {
            throw new SQLException("Database connection is not initialized.");
        }


        String query1 = "SELECT * FROM Document  ";
        Statement stmt;
        ResultSet rs;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query1);

            while (rs.next()) {
                String type = rs.getString("type");
               if( type.equals("Magazine")){
                System.out.println(rs.getString("titre")+" "+type);
                // Magazine magazine = new Magazine(rs.getString("titre"),rs.getString("auteur"), rs.getDate("datePublication"), rs.getInt("nombreDePages"), "Magazine", 0L);
                Magazine magazine = new Magazine();
                magazine.setId(rs.getLong("id"));
                magazine.setTitre(rs.getString("titre"));
                magazine.setAuteur(rs.getString("auteur"));
                magazine.setDatePublication(rs.getDate("datePublication"));
                magazine.setNombresPages(rs.getInt("nombreDePages"));
                magazine.setType("Magazine");
                    documents.add(magazine);

               }else {
                System.out.println(rs.getString("titre")+" "+type);
                Livre livre = new Livre();
                livre.setId(rs.getLong("id"));
                livre.setTitre(rs.getString("titre"));
                livre.setAuteur(rs.getString("auteur"));
                livre.setDatePublication(rs.getDate("datePublication"));
                livre.setNombresPages(rs.getInt("nombreDePages"));
                livre.setType("Livre");

                // Livre livre = new Livre(rs.getString("titre"),rs.getString("auteur"), rs.getDate("datePublication"), rs.getInt("nombreDePages"), "Magazine", 0L);

                   


                    documents.add(livre);
                    

            }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return documents;    
    }
    

    public Document getDocumentById(Long id) throws SQLException {
        if (con == null) {
            throw new SQLException("Database connection is not initialized.");
        }
    
        String query = "SELECT * FROM Document WHERE id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
    
        try {
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
    
            if (rs.next()) {  
                String type = rs.getString("type");
    
                if (type.equals("Livre")) {
                    Livre livre = new Livre();
                    livre.setId(rs.getLong("id"));
                    livre.setTitre(rs.getString("titre"));
                    livre.setAuteur(rs.getString("auteur"));
                    livre.setDatePublication(rs.getDate("datePublication"));
                    livre.setNombresPages(rs.getInt("nombreDePages"));
                    livre.setType("Livre");
                    return livre;  
    
                } else if (type.equals("Magazine")) {
                    Magazine magazine = new Magazine();
                    magazine.setId(rs.getLong("id"));
                    magazine.setTitre(rs.getString("titre"));
                    magazine.setAuteur(rs.getString("auteur"));
                    magazine.setDatePublication(rs.getDate("datePublication"));
                    magazine.setNombresPages(rs.getInt("nombreDePages"));
                    magazine.setType("Magazine");
                    return magazine;  
                }
            }
    
            return null; 
    
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public boolean returnDocuement(Long id) throws SQLException {

        if (con == null) {
            throw new SQLException("Database connection is not initialized.");
        }

        String query1 = "UPDATE Document SET available = ? WHERE id = ?";
        PreparedStatement ps = null;

        try {
        
            ps = con.prepareStatement(query1);
            ps.setInt(1, 0);
            ps.setLong(2, id);

            int n = ps.executeUpdate();
            return n==1;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
