package View;
import Model.Document;
import Utils.Utils;
import java.util.*;


public class HomeView {
    private final Scanner scanner;

    public HomeView() {
      scanner = new Scanner(System.in);
    }

    public void showMenu(){
        // Utils.clear();
        System.out.println("Home page");
        System.out.println("1. Manage  Livre");
        System.out.println("2. Manage Magazine"); 
        System.out.println("3. Emprunter Document");
        System.out.println("4. Retourner Document");
        System.out.println("5. Afficher tous les documents");
        System.out.println("6. Rechercher un document");
    

        System.out.println("0.Exit");

    }

    public int getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public void showDocuemnt(List<Document> documents){
        // Utils.clear();

    
            documents.stream().forEach(document->{
                System.out.println("------------------------");
                System.out.println("Type: "+document.getType());
                System.out.println("ID: " + document.getId());
                System.out.println("Titre: " + document.getTitre());
                System.out.println("Auteur: " + document.getAuteur());
                System.out.println("Date de publication: " + document.getDatePublication());
                System.out.println("Nombre de pages: " + document.getNombresPages());


            });

        // }
        
    }

}
