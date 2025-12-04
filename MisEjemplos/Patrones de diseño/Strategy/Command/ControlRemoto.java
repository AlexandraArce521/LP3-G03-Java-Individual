import java.util.ArrayList;
import java.util.List;

public class ControlRemoto {

    private List<Command> historial;

    public ControlRemoto() {
        historial = new ArrayList<>();
    }

    public void presionarBoton(Command comando) {
        comando.ejecutar();
        historial.add(comando);
    }

    public void deshacerUltimaAccion() {
        if (!historial.isEmpty()) {
            int ultimaPosicion = historial.size() - 1;
            Command ultimo = historial.remove(ultimaPosicion);
            ultimo.deshacer();
        } else {
            System.out.println("No hay acciones para deshacer");
        }
    }
}
