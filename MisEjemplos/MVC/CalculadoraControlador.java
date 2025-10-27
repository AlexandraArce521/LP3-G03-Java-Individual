
import java.util.*;

public class CalculadoraControlador {
    private Calculadora modelo;
    private CalculadoraVista vista;
    
    public CalculadoraControlador(Calculadora modelo, CalculadoraVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void actualizarCalculadora() {
      vista.mostrarOperandos(modelo.getA(), modelo.getB());
    }

    public void opcionCalculadora(int opcion) {
      
      double resultado = 0;
      
      switch (opcion) {
        case 1 : resultado = modelo.sumar(); break;
        case 2 : resultado = modelo.restar(); break;
        case 3 : resultado = modelo.multiplicar(); break;
        case 4 : resultado = modelo.dividir(); break;
        
      }
      
      vista.mostrarResultado(resultado);
      
    }
  
}
