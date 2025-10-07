import java.util.ArrayList;

public class HistorialCompras {
  
  public void historialCompras(Carrito carrito) {
    ArrayList<Producto> lista = carrito.getCarrito();

    System.out.println("__________________________");
    System.out.println("Historial de compras:\n__________________________\n");

    for (int i = 0; i < lista.size(); i++) {
        System.out.println((i + 1) + ". " + lista.get(i).toString());
    }
    
  }

}
