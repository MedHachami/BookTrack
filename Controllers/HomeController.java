package Controllers;

import View.HomeView;
import View.LivreView;
import service.BibiloDaoImpl;
import Model.Document;
import Utils.Utils;
import java.util.*;
import java.sql.*;


public class HomeController {
    final HomeView homeView;
    final BibiloDaoImpl biblioDao;
    private final Scanner scanner;


    

    public HomeController(){
        this.homeView = new HomeView();
        this.biblioDao = new BibiloDaoImpl();
        scanner = new Scanner(System.in);
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
                    runMagazineController();
                    break;
                case 3:
                    Emprunter();
                    break;
                case 4:
                    Return();
                    break;
                case 5:
                    displayDocuements();
                    break;
                case 6:
                    Search();
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

    static void runMagazineController(){
        MagazineController magazineController = new MagazineController();
        magazineController.run();
    }


    private void Emprunter() {
        String keyword = getInput("Enter the document name");
        System.out.println(keyword);
            try {
                List<Document> documents =  biblioDao.getDocumentByName(keyword);
                if(documents!=null && documents.size()>0){
                    homeView.showDocuemnt(documents);  
                    System.out.println("Enter the document id");
                    Long documentId = scanner.nextLong();

                    boolean empereintDoc = biblioDao.emprunterDocuemnt(documentId);
                    if(empereintDoc){
                        System.out.println("Operation went successfully !");

                    }else{
                    System.out.println("Operation went wrong !");
                    }



                    

                }else{
                System.out.println("No documents available to display.");
                }



            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    private void Return() {
        
        long documentId = getInputInt("Enter the document id");
        try {

            Document document = biblioDao.getDocumentById(documentId);
            if(document == null){
                System.out.println("No document found!");
             

            }else{
                System.out.println("found");
                List<Document> documents = new ArrayList<>();
                documents.add(document);
                homeView.showDocuemnt(documents);  
                System.out.println("Enter the document id");
                boolean empereintDoc = biblioDao.emprunterDocuemnt(documentId);
                if(empereintDoc){
                    System.out.println("Operation went successfully !");

                }else{
                System.out.println("Operation went wrong !");
                }

            }
           

                
              


        



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }   


    private void Search() {
        String keyword = getInput("Enter the document name");
        System.out.println(keyword);
            try {
                List<Document> documents =  biblioDao.getDocumentByName(keyword);
                if(documents!=null && documents.size()>0){
                    homeView.showDocuemnt(documents);  

                }else{
                System.out.println("No documents available to display.");
                }



            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    private void displayDocuements(){
        try {
            List<Document> documents =  biblioDao.allDocuments();
            if( documents.size()>0){
                homeView.showDocuemnt(documents);  

            }else{
            System.out.println("No documents available to display.");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public  String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public  long getInputInt(String prompt) {
        System.out.print(prompt);
        return scanner.nextLong();
    }


 




}
