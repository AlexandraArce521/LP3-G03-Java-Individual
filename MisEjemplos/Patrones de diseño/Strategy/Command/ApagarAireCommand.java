public class ApagarAireCommand implements Command {

    private AireAcondicionado aire;

    public ApagarAireCommand(AireAcondicionado aire) {
        this.aire = aire;
    }

    @Override
    public void ejecutar() {
        aire.apagar();
    }

    @Override
    public void deshacer() {
        aire.encender();
    }
}
