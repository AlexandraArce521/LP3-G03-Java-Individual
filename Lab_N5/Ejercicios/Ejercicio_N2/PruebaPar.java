import java.util.*;

public class PruebaPar {
    public static void main(String[] args) {
      
      Par<Integer, String> par1 = new Par<>(2, "Hola!");
      Par<Integer, String> par2 = new Par<>(3, "Adios");
      
      System.out.println(par1);

      System.out.println(par1);
      
      System.out.println(par1.esIgual(par2));
        
  }
}
