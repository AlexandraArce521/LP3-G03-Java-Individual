public class Persona {

  public int edad;
  public String nombre;
  
  public Persona(int edad, String nombre) {
    this.edad = edad;
    this.nombre = nombre;
  }
  
  public String toString() {
    return "(" + nombre +
            "|"
            + edad +
            ")";
  }
}
