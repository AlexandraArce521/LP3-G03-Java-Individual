import java.util.*;

public class PruebaPar {
    
    public class ImprimirObjeto {
      
      public static <F, S> void imprimirPar(Par<F, S> objPar) {
        System.out.println("Imprimiendo Par: \n" + objPar);
      }
    }
    
    public static void main(String[] args) {
      
      Par<Integer, String> par1 = new Par<>(2, "Hola!");
      Par<Integer, String> par2 = new Par<>(3, "Adios");
      
      System.out.println(par1);
    
      System.out.println(par1);
        
      System.out.println(par1.esIgual(par2));
      
      ImprimirObjeto.imprimirPar(par2);
        
  }
}
