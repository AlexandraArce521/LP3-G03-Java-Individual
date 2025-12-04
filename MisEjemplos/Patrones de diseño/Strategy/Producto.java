public class Producto {
  public String nombre;
  public double precio;

  public Producto(String nombre, double precio) {
    this.nombre = nombre;
    this.precio = precio;
  }
  
  public String getNombre() {
    return nombre;
  }
  
  public double getPrecio() {
    return precio;
  }
  
  public void setNombre(String n) {
    nombre = n;
  }
  
  public void setPrecio(double p) {
    precio = p;
  }

}
