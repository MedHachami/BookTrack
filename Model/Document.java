package Model;

import java.util.Date;

public abstract class Document {
    protected Long id;
    protected String titre;
    protected String auteur;
    protected Date datePublication;
    protected int nombresPages;
    protected String type;



    public Document(){
        
    }

    public Document(String titre, String auteur, Date datePublication, int nombresPages ,String type) {
        this.titre = titre;
        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nombresPages = nombresPages;
        this.type = type;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public int getNombresPages() {
        return nombresPages;
    }

    public void setNombresPages(int nombresPages) {
        this.nombresPages = nombresPages;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Abstract methods
    public abstract void emprunter();
    public abstract void retourner();
    public abstract void afficherDetails();
}
