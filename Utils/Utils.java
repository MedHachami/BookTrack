package Utils;

public class Utils {
    
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
