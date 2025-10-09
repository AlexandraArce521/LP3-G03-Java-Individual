// ControladorConsola.java
import java.util.List;

public class ControladorConsola {
    private VistaConsola vista;
    private Carrito carrito;
    private CalculadoraEnvio calculadoraEnvio;
    private DescuentoVerano descuentoVerano;
    private HistorialCompras historial;
    
    public ControladorConsola(VistaConsola vista, Carrito carrito) {
        this.vista = vista;
        this.carrito = carrito;
        this.calculadoraEnvio = new CalculadoraEnvio();
        this.descuentoVerano = new DescuentoVerano();
        this.historial = new HistorialCompras();
    }
    
    public void ejecutar() {
        int opcion;
        do {
            vista.limpiarPantalla();
            vista.mostrarMenu();
            opcion = vista.leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 8);
        
        vista.mostrarMensaje("¡Gracias por usar el sistema!");
    }
    
    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarProducto();
                break;
            case 2:
                eliminarProducto();
                break;
            case 3:
                vaciarCarrito();
                break;
            case 4:
                mostrarCarrito();
                break;
            case 5:
                calcularEnvio();
                break;
            case 6:
                aplicarDescuento();
                break;
            case 7:
                verHistorial();
                break;
            case 8:
                // Salir
                break;
            default:
                vista.mostrarMensaje("Opción inválida. Intente nuevamente.");
        }
        
        if (opcion != 8) {
            vista.esperarEnter();
        }
    }
    
    private void agregarProducto() {
        try {
            Producto nuevoProducto = vista.leerProducto();
            carrito.agregarProducto(nuevoProducto);
            vista.mostrarMensaje("Producto agregado correctamente.");
        } catch (Exception e) {
            vista.mostrarMensaje("Error al agregar producto. Verifique los datos.");
        }
    }
    
    private void eliminarProducto() {
        List<Producto> productos = carrito.getCarrito();
        if (productos.isEmpty()) {
            vista.mostrarMensaje("El carrito está vacío.");
            return;
        }
        
        vista.mostrarProductos(productos);
        int indice = vista.leerIndiceProducto();
        
        if (indice >= 0 && indice < productos.size()) {
            Producto producto = productos.get(indice);
            carrito.eliminarProducto(producto);
            vista.mostrarMensaje("Producto eliminado correctamente.");
        } else {
            vista.mostrarMensaje("Índice inválido.");
        }
    }
    
    private void vaciarCarrito() {
        if (carrito.getCarrito().isEmpty()) {
            vista.mostrarMensaje("El carrito ya está vacío.");
            return;
        }
        
        carrito.vaciarCarrito();
        vista.mostrarMensaje("Carrito vaciado correctamente.");
    }
    
    private void mostrarCarrito() {
        vista.mostrarProductos(carrito.getCarrito());
    }
    
    private void calcularEnvio() {
        if (carrito.getCarrito().isEmpty()) {
            vista.mostrarMensaje("El carrito está vacío. Agregue productos primero.");
            return;
        }
        
        String direccion = vista.leerDireccion();
        if (direccion.trim().isEmpty()) {
            vista.mostrarMensaje("La dirección no puede estar vacía.");
            return;
        }
        
        // Calcular peso total
        double pesoTotal = 0;
        for (Producto p : carrito.getCarrito()) {
            pesoTotal += p.getPeso();
        }
        
        // Calcular costo de envío
        double costoEnvio = calculadoraEnvio.calcularCosto(carrito, direccion);
        vista.mostrarInformacionEnvio(direccion, pesoTotal, costoEnvio);
        
        // Mostrar total con envío
        double totalConEnvio = carrito.totalPrecio() + costoEnvio;
        vista.mostrarMensaje("Total con envío: S/ " + totalConEnvio);
    }
    
    private void aplicarDescuento() {
        if (carrito.getCarrito().isEmpty()) {
            vista.mostrarMensaje("El carrito está vacío. Agregue productos primero.");
            return;
        }
        
        double totalSinDescuento = carrito.totalPrecio();
        double totalConDescuento = descuentoVerano.descuentoFijo(carrito);
        
        vista.mostrarDescuento(totalSinDescuento, totalConDescuento);
    }
    
    private void verHistorial() {
        if (carrito.getCarrito().isEmpty()) {
            vista.mostrarMensaje("El carrito está vacío.");
            return;
        }
        
        vista.mostrarHistorial(carrito.getCarrito());
    }
}
