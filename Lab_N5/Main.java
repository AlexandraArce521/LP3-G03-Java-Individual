import java.util.*;

public class Main {
    public static void main(String[] args) {

      Pila pila = new Pila(100);
      
      try {
        
          int numero1 = 3;
          String elemento2 = "Perro";
          double elemento3 = 34.7;
          String nombre = "Juan";
          String ciudad = "Arequipa";
          String lenguaje = "Java";
          byte numeroByte = 10;
          short numeroShort = 200;
          int numeroInt = 3000;
          long numeroLong = 400000L;
          float numeroFloat = 5.75f;
          double numeroDouble = 123.456;
          char letra = 'A';
          
          pila.push(numero1);
          pila.push(elemento2);
          pila.push(elemento3);
          pila.push(nombre);
          pila.push(ciudad);
          pila.push(numeroLong);

         

          
          pila.mostrarPila();
          

          pila.pop();

          pila.mostrarPila();
          

          pila.peek(); 
          
          pila.isEmpty();
          
          System.out.println("Pila Invertida:");

          pila.invertir();



          pila.limpiarPila();
          
          pila.mostrarPila();
          
          
      } catch(ExceptionPilaLLena e) {
        
        System.out.println("(!) " + e.getMessage());
        
      } catch(ExceptionPilaVacia e) {
        System.out.println("(!) " + e.getMessage());
      }
      
      
  }
}
