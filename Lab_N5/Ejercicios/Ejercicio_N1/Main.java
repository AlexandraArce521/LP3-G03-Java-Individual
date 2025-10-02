import java.util.*;

public class Main {
    public static void main(String[] args) {
      
      Par<Integer, String> par1 = new Par<>(2, "Hola!");
      
      System.out.println(par1);
      
      par1.setPrimero(3);
      
      System.out.println(par1);
              
  }
}
