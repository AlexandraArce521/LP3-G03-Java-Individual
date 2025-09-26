
public class Main {
    public static void main(String[] args) {
      
      String mascota = "Spike";
      Double pi = 3.14;

      IgualGenerico comparar = new IgualGenerico(mascota, pi);
      
      
      System.out.println("¿Es igual?: " + mascota +" y "+pi);
      System.out.println(comparar.esIgualA(mascota, pi));

    
  }
}
