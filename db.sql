CREATE TABLE Document (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    auteur VARCHAR(255) NOT NULL,
    datePublication DATE NOT NULL,
    nombreDePages INT NOT NULL,
    type VARCHAR(20) NOT NULL, 
    UNIQUE KEY unique_document (titre, auteur, datePublication) 
);


CREATE TABLE Livre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    document_id INT,
    isbn VARCHAR(13) NOT NULL, 
    FOREIGN KEY (document_id) REFERENCES Document(id) ON DELETE CASCADE,
    UNIQUE KEY unique_livre_isbn (isbn)
);



CREATE TABLE Magazine (
    id INT AUTO_INCREMENT PRIMARY KEY,
    document_id INT, 
    numero INT NOT NULL,
    FOREIGN KEY (document_id) REFERENCES Document(id) ON DELETE CASCADE,
    UNIQUE KEY unique_magazine_numero (numero, document_id)
);