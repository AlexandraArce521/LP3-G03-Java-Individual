import java.util.*;
import java.io.*;


public class Main {
  public static void main(String [] args) {
    
    String file = "miObjeto.txt";
    Persona p1 = new Persona ("Carlos", "Hermoza", 98723123);
    Persona p2 = new Persona ("Maria", "Kimberly", 98965329);
    
    //ESCRITURA
    ObjectOutputStream w;
    
    try {
      
      w = new ObjectOutputStream(new FileOutputStream(file));
      w.writeObject(p1);
      w.writeObject(p2);
      w.close();
      System.out.println("Objeto Guardado exitosamente");
      
    } catch(IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
    
    //LECTURA
    
    ObjectInputStream r;
    Persona objetoLectura;
    
    try {
    	r = new ObjectInputStream(new FileInputStream(file));
    	
    	objetoLectura = (Persona) r.readObject();
    	System.out.println(objetoLectura + " ");
    	
    	objetoLectura = (Persona) r.readObject();
    	System.out.println(objetoLectura + " ");
    	r.close();
    	
    } catch(IOException e) {
    	System.out.println("Error: " + e.getMessage());
    } catch(ClassNotFoundException e) {
    	System.out.println("Error: " + e.getMessage());
    }
    
  }
}
