public class EncenderAireCommand implements Command {

    private AireAcondicionado aire;

    public EncenderAireCommand(AireAcondicionado aire) {
        this.aire = aire;
    }

    @Override
    public void ejecutar() {
        aire.encender();
    }

    @Override
    public void deshacer() {
        aire.apagar();
    }
}
