import java.util.ArrayList;

public class Coleccion <F, S> {

  public ArrayList <Par<F, S>> coleccion;
  
  public Coleccion() {
    coleccion = new ArrayList<>();
    
  }

  public void agregarPar(Par<F, S> objPar) {
    coleccion.add(objPar);
  }
  
  public Par<F, S> obtenerPar(int indice) {
    if (indice >= 0 && indice < coleccion.size()) {
        return coleccion.get(indice);
    } else {
        System.out.println("(!)No existe elemento en el indice indicado");
        return null; 
    }
  }
  
  public ArrayList<Par<F, S>> obtenerTodosLosPares() {
    ArrayList <Par<F, S>> coleccionMuestra = new ArrayList<>();
    
    
    for (int i = 0; i < coleccion.size(); i++) {
      coleccionMuestra.add(coleccion.get(i));
    }
    
    return coleccionMuestra;
      
  }
  public void mostrarPares() {
    
    System.out.println("\nElementos de Coleccion: ");
    for (int i = 0; i < coleccion.size(); i++) {
      System.out.println(coleccion.get(i));
    }    
  }

}
