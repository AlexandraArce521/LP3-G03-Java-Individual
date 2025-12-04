public class ApagarVentiladorCommand implements Command {

    private Ventilador ventilador;

    public ApagarVentiladorCommand(Ventilador ventilador) {
        this.ventilador = ventilador;
    }

    @Override
    public void ejecutar() {
        ventilador.apagar();
    }

    @Override
    public void deshacer() {
        ventilador.encender();
    }
}
