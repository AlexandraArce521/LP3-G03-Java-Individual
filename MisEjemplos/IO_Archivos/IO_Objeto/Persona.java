import java.util.*;
import java.io.*;


public class Persona implements Serializable {
  public String nombre;
  public String apellido;
  public int fono;
  
  public Persona(String nombre, String apellido, int fono) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.fono = fono;
  }
  
  @Override
  public String toString() {
    return "\nNombre: " + nombre +
           "\nApellido: " + apellido +
           "\nTelefono: " + fono;
  }

}
