import java.util.ArrayList;

public class ArregloGenerico <T> {
  
  public ArrayList <T> listaGenerica;
  
  public ArregloGenerico() {
    listaGenerica = new ArrayList<>();
  }
  
  public void imprimirArreglo(T listaGenerica) {
    
      System.out.println(listaGenerica);
    }
    
}
