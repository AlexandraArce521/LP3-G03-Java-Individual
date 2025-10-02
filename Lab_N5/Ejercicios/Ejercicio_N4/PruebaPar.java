import java.util.*;

public class PruebaPar {
    
    public static void main(String[] args) {
      
      Par<Integer, String> par0 = new Par<>(2, "Hola!");
      Par<Integer, String> par1 = new Par<>(2, "Hola!");
      Par<String, Integer> par2 = new Par<>("Java", 6);
      Par<Double, Boolean> par3 = new Par<>(12.5, true);

      System.out.println(par1);
      System.out.println(par2);
      System.out.println(par3);

    
      Coleccion coleccion = new Coleccion();
      
      coleccion.agregarPar(new Par<>("Uno", 1));
      coleccion.agregarPar(new Par<>("Dos", 2));
      coleccion.agregarPar(new Par<>("Tres", 3));  
      
      System.out.println(coleccion.obtenerPar(0));
      System.out.println(coleccion.obtenerPar(1));
      System.out.println(coleccion.obtenerPar(2));
      System.out.println(coleccion.obtenerPar(3));
      
      coleccion.mostrarPares();
      
      System.out.println(coleccion.obtenerTodosLosPares());

  }
}
