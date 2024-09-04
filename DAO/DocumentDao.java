package DAO;

import Model.Document;
import java.sql.SQLException;
import java.util.List;


public interface DocumentDao {
    List<Document> getDocumentByName(String name) throws SQLException;
    boolean emprunterDocuemnt(Long id) throws SQLException;
    List<Document> allDocuments() throws SQLException;

    
}
