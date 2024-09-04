package Controllers;

import Model.Magazine;
import Utils.Utils;
import View.MagazineView;
import service.MagazineDaoImpl;
import java.sql.SQLException;


public class MagazineController {
     final MagazineView magazineView;
    final MagazineDaoImpl magazineDao;
    

    public MagazineController(){
        this.magazineDao = new MagazineDaoImpl();
        this.magazineView = new MagazineView();

        
    }

    public void run(){
        boolean running = true; 
        Utils.clear();

        while (running) {
            magazineView.showMenu();
            int choice = magazineView.getInput("Enter your choice: ");

            switch (choice) {
                case 1:
                     addMagazine();
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


    private void addMagazine() {
        Magazine magazine = new MagazineView().getInputMagazine();

         try {
            boolean addMagazine = magazineDao.addMagazine(magazine);
            if (addMagazine) {
                System.out.println("Magazine à été ajouté");
            } else {
                System.out.println("Essayer encore fois");
            }

            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


   
}
