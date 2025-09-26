import java.util.ArrayList;

public class Pila <T> {
  public int puntero; //Ultimo elemento de la Pila
  public int tamanio; // Tamaño de la Pila
  public ArrayList <T> elementos;
  
  public Pila(int tamanio) {
    this.puntero = -1;
    this.tamanio = tamanio;
    elementos = new ArrayList<>(tamanio);
  }
  
  public T push(T elemento) throws ExceptionPilaLLena {
    if(puntero == tamanio-1) {
      System.out.println("Error. Pila llena");
      throw new ExceptionPilaLLena("No se puede ingresar más elementos");
    }
    
    elementos.add(elemento);
    
    T valor = elemento;
    
    puntero++;
    
    return elemento;
  }
  
  public T pop() throws ExceptionPilaVacia {
    if(puntero == -1) {
      System.out.println("Error. Pila vacía");
      throw new ExceptionPilaVacia("No se puede eliminar elemento inexistente");
    }
    
    T valor = elementos.remove(puntero);
    
    puntero--;
    
    return valor;
    
    
  }
  
  public boolean isEmpty() {
    if(puntero == -1) {
      System.out.println("¿La Pila esta vacía?: Verdadero");
      return true;
    }

    System.out.println("¿La Pila esta vacía?: Falso");
    return false;
    
  }
  
  public T peek() throws ExceptionPilaVacia {
    if(puntero == -1) {
      System.out.println("Error. Pila vacía");
      throw new ExceptionPilaVacia("No se puede mostrar el ultimo elemento en pila vacia");
    }
    
    System.out.println("Ultimo elemento de la Pila: " + elementos.get(puntero));
    
    T valor = elementos.get(puntero);
    
    return valor;
    
  }
  
  public void limpiarPila() {
    
    System.out.println("Pila vaciada exitosamente");
    
    puntero = -1;
    
    elementos.clear();
  }
  
  public void mostrarPila() throws ExceptionPilaVacia {
    
    if(elementos.size() == 0) {
      System.out.println("No hay elementos en la Pila");
      throw new ExceptionPilaVacia("No se puede mostrar los elementos si la Pila esta vacía");

    }
    
    System.out.print("\n");
    for(int i = elementos.size() - 1; i >= 0; i--) {
      System.out.print("| "+ elementos.get(i)+ " |\n");
    }
    
    System.out.print("_____");
    System.out.println("\nElementos en la Pila: "+ elementos.size());
    
  }
  
}
