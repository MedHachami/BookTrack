package Model;

import java.util.Date;

public class Livre extends Document {
    private  Long isbn;

    public Livre() {
        super("", "", new Date(), 0,"Livre"); 
        this.isbn = 0L;
    }
    public Livre(String titre, String auteur, Date datePublication, int nombresPages,String type ,Long isbn) {
        super(titre, auteur, datePublication, nombresPages,type);
        this.isbn = isbn;
    }


    public Long getIsbn(){
        return this.isbn;
    }

    public void setIsbn(Long isbn){
        this.isbn = isbn;
    }

    @Override
    public void emprunter() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'emprunter'");
        System.out.println(this);
    }

    @Override
    public void retourner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retourner'");
    }

    @Override
    public void afficherDetails() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'afficherDetails'");
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", datePublication=" + datePublication +
                ", nombresPages=" + nombresPages +
                ", isbn=" + isbn +
                '}';
    }
  

}
