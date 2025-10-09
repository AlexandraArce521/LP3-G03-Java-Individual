//App.java
public class App {
    public static void main(String[] args) {
        // Crear instancias
        VistaConsola vista = new VistaConsola();
        Carrito carrito = new Carrito();
        ControladorConsola controlador = new ControladorConsola(vista, carrito);
        
        // Ejecutar aplicación
        controlador.ejecutar();
    }
}
