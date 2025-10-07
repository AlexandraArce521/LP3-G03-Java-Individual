import java.util.ArrayList;

public class Carrito {
  
  protected ArrayList <Producto> carrito;
  
  public Carrito() {
    carrito = new ArrayList<>();

  }
  
  public ArrayList<Producto> getCarrito() {
    return carrito;
  }
  
  public void agregarProducto(Producto produc) {
    carrito.add(produc);
  }
  
  public void eliminarProducto(Producto produc) {
    
    if (carrito.contains(produc)) {
      carrito.remove(produc);
      System.out.println("Producto eliminado del carrito");
      
    } else {
      System.out.println("(!) El producto no está en el carrito");
    }
    
  }
  
  public void vaciarCarrito() {
    carrito.clear();
  }
  
  public double totalPrecio() {
    double total = 0;
    Producto p;
    
    for (int i = 0; i < carrito.size(); i++) {
       p = carrito.get(i);
       
       total += p.getPrecio();
    }
    return total;
  }
  
  @Override
  public String toString() {
    
    if (carrito.isEmpty()) {
      return "El carrito está vacío.";
    }
    
    String lista = "Productos en el carrito:\n__________________________\n";
    System.out.println("__________________________");
    for (int i = 0; i < carrito.size(); i++) {
       lista += (i + 1) + ". " + carrito.get(i).toString() + "\n";
    }
    
    return lista;
  }

}
