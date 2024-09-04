package View;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
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
    Scanner scanner = new Scanner(System.in); 
    System.out.println("Enter Livre Details:");

    String titre = "";
    String auteur = "";
    String datePublication = "";
    int nombresPages = 0;
    long isbn = 0L;
    boolean validInput = false; 

    System.out.print("Titre: ");
    titre = scanner.nextLine();

    System.out.print("Auteur: ");
    auteur = scanner.nextLine();

    // System.out.print("Date de publication (yyyy-MM-dd) : ");
    // datePublication = scanner.nextLine();


     Date parsedDate = null;

    while (parsedDate == null) {
        System.out.print("Date de publication (yyyy-MM-dd) : ");
        datePublication = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); 

        try {
            parsedDate = dateFormat.parse(datePublication);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter a date in the format yyyy-MM-dd.");
        }
    }

    while (!validInput) {
        try {
            System.out.print("Nombres de pages: ");
            nombresPages = scanner.nextInt();
            validInput = true; 
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer for the number of pages.");
            scanner.nextLine();  // Clear the invalid input
        }
    }

     isbn = System.currentTimeMillis();

    

    Livre livre = new Livre();
    livre.setTitre(titre);
    livre.setAuteur(auteur);
    livre.setDatePublication(parsedDate);
    livre.setNombresPages(nombresPages);

    livre.setIsbn(isbn);

    return livre;
    }



}
