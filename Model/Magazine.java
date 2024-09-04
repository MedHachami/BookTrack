package Model;

import java.util.Date;

public class Magazine  extends Document  {


    private Long numero;


    public Magazine() {
        super("", "", new Date(), 0,"Magazine"); 
        this.numero = 0L;
    }
    public Magazine(String titre, String auteur, Date datePublication, long nombresPages,String type,Long numero) {
        super(titre, auteur, datePublication, nombresPages,type);
        this.type = type;
    }

    public Long getNumero(){
        return this.numero;
    }

    public void setNumero(Long numero){
        this.numero = numero;
    }

    @Override
    public void emprunter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'emprunter'");
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
    
}
