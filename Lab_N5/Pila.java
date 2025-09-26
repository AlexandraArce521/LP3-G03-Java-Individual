import java.util.ArrayList;

public class Pila <T> {
  public int puntero;
  public int tamanio;
  public ArrayList <T> elementos;
  
  public Pila() {
    this.puntero = -1;
    this.tamanio = tamanio;
    ArrayList <T> elementos = new ArrayList<>();
  }
  
  public void push(T elemento) throws ExceptionPilaLLena {
    if(puntero == tamanio-1) {
      System.out.println("Error. Pila llena");
      throw new ExceptionPilaLLena("No se puede ingresar más elementos");
    }
    
    elementos.add(elemento);
    ++puntero;
  }
  
  public void pop(T elemento) throws ExceptionPilaVacia {
    if(puntero == -1) {
      System.out.println("Error. Pila vacía");
      throw new ExceptionPilaVacia("No se puede eliminar elemento inexistente");
    }
    
    elemento.remove(elemento);
    --puntero;
    
  }
  
  public boolean isEmpty() {
    if(puntero == -1) {
      return true;
    }
    
    return false;
    
  }
  
  public T peek() throws ExceptionPilaVacia {
    if(puntero == -1) {
      System.out.println("Error. Pila vacía");
      throw new ExceptionPilaVacia("No se puede mostrar el ultimo elemento en pila vacia");
    }
    
    return elementos[tamanio-1];
    
  }
  
}
