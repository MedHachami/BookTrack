package Utils;


import java.util.*;
import java.lang.reflect.Field;

public class Utils {
    private final Scanner scanner;

    public Utils(){
        this.scanner = new Scanner(System.in);
        
    }

    
    public static void clear() { 
        try { 
            if (System.getProperty("os.name").contains("Windows")) { 
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); 
            } else { 
                new ProcessBuilder("clear").inheritIO().start().waitFor(); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }

    public static void goodBye(){
        System.out.println("See You soon !");
        System.exit(0);
    }

   


}
