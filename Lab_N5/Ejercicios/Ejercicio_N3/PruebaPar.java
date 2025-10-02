import java.util.*;

public class PruebaPar {
    
    public class ImprimirObjeto {
      
      public static <F, S> void imprimirPar(Par<F, S> objPar) {
        System.out.println("Imprimiendo Par: \n" + objPar);
      }
    }
    
    public static void main(String[] args) {
      
      Persona persona1 = new Persona(16, "Jorge");

      Par<Integer, String> par0 = new Par<>(2, "Hola!");
      Par<Integer, String> par1 = new Par<>(2, "Hola!");
      Par<String, Integer> par2 = new Par<>("Java", 6);
      Par<Double, Boolean> par3 = new Par<>(12.5, true);
      Par<Persona, Integer> par4 = new Par<>(persona1, 3);

      
      System.out.println(par1);
      System.out.println(par2);
      System.out.println(par3);
      System.out.println(par4);
      
      
      System.out.println(par1.esIgual(par2));
      System.out.println(par0.esIgual(par1));
      System.out.println(par3.esIgual(par4));

      
      ImprimirObjeto.imprimirPar(par1);
      ImprimirObjeto.imprimirPar(par2);
      ImprimirObjeto.imprimirPar(par3);
      ImprimirObjeto.imprimirPar(par4);
      
        
  }
}
