import java.util.*;
import java.io.*;


public class Main {
  public static void main(String [] args) {
    Scanner lectura;
    String line;
    String file = "miTexto.txt";
    
    try{
      
      lectura = new Scanner (new FileReader(file));
      
      while(lectura.hasNextLine()) {
        line = lectura.nextLine();
        System.out.println(line);
      }
      
    } catch(FileNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
