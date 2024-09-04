package View;
import java.util.*;


import Model.Document;
import Utils.Utils;

public class EmpruntView {
      private final Scanner scanner;

      

    public EmpruntView() {
      scanner = new Scanner(System.in);
    }

    public void showMenu(){
        Utils.clear();
        System.out.println("Emprunt page");
        String keyword = getInpuString("Enter the document name");
        System.out.println(keyword);

    }

    public int getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }


    public  String getInpuString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    

    public void showDocuemnt(List<Document> documents){
            documents.stream().forEach(document->{
                System.out.println("------------------------");
                System.out.println("Type: "+document.getType());
                System.out.println("ID: " + document.getId());
                System.out.println("Titre: " + document.getTitre());
                System.out.println("Auteur: " + document.getAuteur());
                System.out.println("Date de publication: " + document.getDatePublication());
                System.out.println("Nombre de pages: " + document.getNombresPages());

            });
        
    }
}
