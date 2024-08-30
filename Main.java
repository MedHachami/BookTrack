import View.*;
import Controllers.*;

import java.util.Scanner;


public class Main {

   



    public static void main(String[] args){

        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        runHome();

    }


    static void runHome(){
        HomeController homeController = new HomeController();
        homeController.run();
    }

}
