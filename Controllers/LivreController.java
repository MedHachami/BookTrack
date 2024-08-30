package Controllers;

import Utils.Utils;
import View.LivreView;
import Utils.Utils;


public class LivreController {

    final LivreView livreView;
    

    public LivreController(){
        this.livreView = new LivreView();

        
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

    public void addLivre(){
        System.out.println("Add livre");
    }


    public void updateLivre(){
        System.out.println("Update livre");
    }
}
