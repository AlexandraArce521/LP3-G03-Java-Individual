import java.util.ArrayList;

public class ArregloGenerico <T> {
  
  ArrayList<T> listaGenerica;
  
  public ArregloGenerico() {
    listaGenerica = new ArrayList<>();
  }
  
  public void imprimirArreglo() {
    for (int i = 0; listaGenerica.size(); i++) {
      System.out.print(listaGenerica.get(i));
    }
  }

}
