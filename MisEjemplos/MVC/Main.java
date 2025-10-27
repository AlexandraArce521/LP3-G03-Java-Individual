import java.util.*;

public class Main {
    public static void main(String[] args) {
    	
    	
      Scanner sc = new Scanner(System.in);
      
      System.out.println("1. Sumar\n2. Restar\n3. Multiplicar\n4. Dividir");
      System.out.println("Ingrese una opción: ");
      int respuesta = sc.nextInt();      
      
      System.out.println("Ingrese a: ");
      double a = sc.nextDouble();
      System.out.println("Ingrese b: ");
      double b = sc.nextDouble();
      
      Calculadora cal = new Calculadora(a, b);
      CalculadoraVista calV = new CalculadoraVista();
      CalculadoraControlador calC = new CalculadoraControlador(cal, calV); 
      
      calC.actualizarCalculadora();
      calC.opcionCalculadora(respuesta);
    }
}
