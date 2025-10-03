
public class Main {
    public static void main(String[] args) {
      
      String mascota = "Spike";
      Double pi = 3.14;

      IgualGenerico comparar = new IgualGenerico(mascota, pi);
      
     IgualGenerico<String> obj2 = new IgualGenerico<>("Hola", "Mundo");
    
    System.out.println(obj2.esIgualA("Hola", "Hola")); // true
    System.out.println(obj2.esIgualA("Hola", "Mundo")); // false
     
      System.out.println("¿Es igual?: " + mascota +" y "+pi);
      System.out.println(comparar.esIgualA(mascota, pi));

    
  }
}
