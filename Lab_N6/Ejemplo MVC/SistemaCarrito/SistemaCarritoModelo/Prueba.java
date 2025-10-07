import java.util.*;
import java.util.ArrayList;


public class Prueba {
    public static void main(String[] args) {
      
      Producto producto1 = new Producto("Pimienta",1 ,7.80, "Verduras", "13243242", "Verdura fresca, verde" );
      Producto producto2 = new Producto("Tomate",1 ,4.50, "Fruta", "13247642", "Fruta fresca, roja" );
      
      Carrito carro = new Carrito();
      
      carro.agregarProducto(producto1);
      carro.agregarProducto(producto2);
      
      //carro.eliminarProducto(producto2);
      
      CalculadoraEnvio calculadora = new CalculadoraEnvio();
      calculadora.calcularCosto(carro, "Av. Lima 123 - Arequipa");
      
      DescuentoVerano descuento = new DescuentoVerano();
      double totalConDescuento = descuento.descuentoFijo(carro);

      System.out.println("Costo sin descuento: S/ " + carro.totalPrecio());
      System.out.println("Total con descuento de verano: S/ " + totalConDescuento);
      
      HistorialCompras historial = new HistorialCompras();
      historial.historialCompras(carro);

  }
}
