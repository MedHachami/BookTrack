package Controllers;

import Model.Livre;
import Utils.Utils;
import View.LivreView;
import Utils.Utils;
import java.sql.SQLException;

import DAO.LivreDaoImpl;


public class LivreController {

    final LivreView livreView;
    final LivreDaoImpl livreDao;
    

    public LivreController(){
        this.livreView = new LivreView();
        this.livreDao = new LivreDaoImpl();

        
    }

    public void run(){
        boolean running = true; 
        Utils.clear();
        System.out.println("Livre page");

        while (running) {
            livreView.showMenu();
            int choice = livreView.getInput("Enter your choice: ");

            switch (choice) {
                case 1:
                     addLivre();
                    break;
                case 2:
                    updateLivre();
                    break;
                case 3:
                    running=false;
                    break;
                case 0:
                    Utils.goodBye();
                default:
                System.out.println("Invalid choice. Exiting...");
                break;
            }


        }

    }

    private void addLivre() {
        Livre livre = new LivreView().getInputLivre();

        try {
            livreDao.addLivre(livre);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void updateLivre(){
        System.out.println("Update livre");
    }
}
