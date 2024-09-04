package View;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

import Model.Magazine;



public class MagazineView {
    private final Scanner scanner;

    public MagazineView() {
        scanner = new Scanner(System.in);
    }

    public void showMenu(){
        System.out.println("==== Manage Magazine ====");
        System.out.println("1. Add Magazine");
        System.out.println("2. Update Magazine");
        System.out.println("3. Back Home");
        System.out.println("0. Exit");
    }

    public int getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public Magazine getInputMagazine() {
    Scanner scanner = new Scanner(System.in); 
    System.out.println("Enter Magazine Details:");

    String titre = "";
    String auteur = "";
    String datePublication = "";
    long nombresPages = 0;
    long numero = 0L;
    boolean validInput = false; 

    System.out.print("Titre: ");
    titre = scanner.nextLine();

    System.out.print("Auteur: ");
    auteur = scanner.nextLine();



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
            nombresPages = scanner.nextLong();
            validInput = true; 
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer for the number of pages.");
            scanner.nextLine();  // Clear the invalid input
        }
    }

     numero = System.currentTimeMillis();

    

    Magazine magzine = new Magazine();
    magzine.setTitre(titre);
    magzine.setAuteur(auteur);
    magzine.setDatePublication(parsedDate);
    magzine.setNombresPages(nombresPages);

    magzine.setNumero(numero);

    return magzine;
    }

}
