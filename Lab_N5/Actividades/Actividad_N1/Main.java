import java.util.*;

public class Main {
    public static void main(String[] args) {
      
    ArregloGenerico arregloGenerico = new ArregloGenerico();
      
    ArrayList<Integer> listaEnteros = new ArrayList<>();
    
        listaEnteros.add(10);
        listaEnteros.add(25);
        listaEnteros.add(5);
        listaEnteros.add(42);
  
    arregloGenerico.imprimirArreglo(listaEnteros);

    ArrayList<String> listaString = new ArrayList<>();
    
        listaString.add("Hola");
        listaString.add("Mundo ");
        listaString.add("Estamos en ");
        listaString.add("Java");
        
    arregloGenerico.imprimirArreglo(listaString);

  }
}
