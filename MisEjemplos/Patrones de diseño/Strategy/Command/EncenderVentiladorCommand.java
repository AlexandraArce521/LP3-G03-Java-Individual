public class EncenderVentiladorCommand implements Command {

    private Ventilador ventilador;

    public EncenderVentiladorCommand(Ventilador ventilador) {
        this.ventilador = ventilador;
    }

    @Override
    public void ejecutar() {
        ventilador.encender();
    }

    @Override
    public void deshacer() {
        ventilador.apagar();
    }
}
