package Controllers;

import View.HomeView;
import View.LivreView;
import Utils.Utils;

public class HomeController {
     final HomeView homeView;
    

    public HomeController(){
        this.homeView = new HomeView();
    }



    public void run(){
        boolean running = true; 


        while (running) {
            homeView.showMenu();
            int choice = homeView.getInput("Enter your choice: ");

            switch (choice) {
                case 1:
                runLivreController();
                    break;
                case 2:
                magazineController();
                    break;
                case 0:
                    Utils.goodBye();
                break;
             
                default:
                System.out.println("Invalid choice. Exiting...");
                    break;
            }


        }

    }


    static void runLivreController(){
        LivreController LivreController = new LivreController();
        LivreController.run();
    }



     static void magazineController(){
        System.out.print("Managing magazine");
    }

}
