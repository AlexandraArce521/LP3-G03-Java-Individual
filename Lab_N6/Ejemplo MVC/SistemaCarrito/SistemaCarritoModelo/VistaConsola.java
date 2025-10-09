// VistaConsola.java
import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    private Scanner scanner;
    
    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }
    
    public void mostrarMenu() {
        System.out.println("\n_______________________________________");
        System.out.println("\n   SISTEMA DE CARRITO DE COMPRAS    ");
        System.out.println("\n_______________________________________");
        System.out.println("1. Agregar producto al carrito");
        System.out.println("2. Eliminar producto del carrito");
        System.out.println("3. Vaciar carrito");
        System.out.println("4. Mostrar productos en carrito");
        System.out.println("5. Calcular costo de envío");
        System.out.println("6. Aplicar descuento de verano");
        System.out.println("7. Ver historial de compras");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    public int leerOpcion() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar buffer
            return -1;
        }
    }
    
    public Producto leerProducto() {
        scanner.nextLine(); // Limpiar buffer
        
        System.out.println("\n--- AGREGAR PRODUCTO ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Peso (kg): ");
        double peso = scanner.nextDouble();
        
        System.out.print("Precio (S/): ");
        double precio = scanner.nextDouble();
        
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();
        
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        
        return new Producto(nombre, peso, precio, categoria, codigo, descripcion);
    }
    
    public String leerDireccion() {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese dirección de envío: ");
        return scanner.nextLine();
    }
    
    public int leerIndiceProducto() {
        System.out.print("Ingrese el número del producto a eliminar: ");
        try {
            return scanner.nextInt() - 1; // Convertir a índice base 0
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar buffer
            return -1;
        }
    }
    
    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("\nEl carrito está vacío.");
            return;
        }
        
        System.out.println("\n--- PRODUCTOS EN EL CARRITO ---");
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + 
                             " - S/ " + p.getPrecio() + 
                             " - " + p.getPeso() + " kg");
        }
        System.out.println("Total: S/ " + calcularTotal(productos));
    }
    
    private double calcularTotal(List<Producto> productos) {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n" + mensaje);
    }
    
    public void mostrarInformacionEnvio(String direccion, double pesoTotal, double costoEnvio) {
        System.out.println("\n--- INFORMACIÓN DE ENVÍO ---");
        System.out.println("Destino: " + direccion);
        System.out.println("Peso total: " + pesoTotal + " kg");
        System.out.println("Costo de envío: S/ " + costoEnvio);
    }
    
    public void mostrarDescuento(double totalSinDescuento, double totalConDescuento) {
        System.out.println("\n--- DESCUENTO DE VERANO ---");
        System.out.println("Total sin descuento: S/ " + totalSinDescuento);
        System.out.println("Total con descuento: S/ " + totalConDescuento);
        System.out.println("Ahorro: S/ " + (totalSinDescuento - totalConDescuento));
    }
    
    public void mostrarHistorial(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("\nNo hay productos en el historial.");
            return;
        }
        
        System.out.println("\n--- HISTORIAL DE COMPRAS ---");
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            System.out.println((i + 1) + ". " + p.toString());
            System.out.println("----------------------------------------");
        }
    }
    
    public void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    public void esperarEnter() {
        System.out.print("\nPresione ENTER para continuar...");
        scanner.nextLine();
        scanner.nextLine(); // Doble lectura para asegurar
    }
}
