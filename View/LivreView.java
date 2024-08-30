package View;
import java.util.Scanner;

import Model.Livre;

public class LivreView {

    private final Scanner scanner;

    public LivreView() {
        scanner = new Scanner(System.in);
    }

    public void showMenu(){
        System.out.println("==== ManageLivre ====");
        System.out.println("1. Add Livre");
        System.out.println("2. Update Livre");
        System.out.println("3. Back Home");
        System.out.println("0. Exit");
    }

    public int getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public Livre getInputLivre() {
        System.out.println("Enter Livre Details:");

        

        System.out.print("Titre: ");
        String titre = scanner.nextLine();
    
        System.out.print("auteur: ");
        String auteur = scanner.nextLine();
    
        System.out.print("Date de publication (yyyy-MM-dd) : ");
        String datePublication = scanner.nextLine();

        System.out.print("Nombres de pages : ");
        int nombresPages = scanner.nextInt();


        System.out.print("ISBN : ");
        Long isbn = scanner.nextLong();
    
    
    
        Livre livre = new Livre();
        livre.setTitre(titre);
        livre.setAuteur(auteur);
        livre.setDatePublication(java.sql.Date.valueOf(datePublication));

        livre.setNombresPages(nombresPages);
        livre.setIsbn(isbn);
    
        return livre;
      }



}
