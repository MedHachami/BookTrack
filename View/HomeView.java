package View;
import java.util.Scanner;

import Utils.Utils;


public class HomeView {
    private final Scanner scanner;

    public HomeView() {
      scanner = new Scanner(System.in);
    }

    public void showMenu(){
        Utils.clear();
        System.out.println("Home page");
        System.out.println("1. Manage  Livre");
        System.out.println("2. Manage Magazine");
        System.out.println("0.Exit");
    }

    public int getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

}
