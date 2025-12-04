public class Cliente {

    public static void main(String[] args) {

        ControlRemoto control = new ControlRemoto();

        Luz luz = new Luz();
        Ventilador ventilador = new Ventilador();
        AireAcondicionado aire = new AireAcondicionado();

        Command encenderLuz = new EncenderLuzCommand(luz);
        Command apagarLuz = new ApagarLuzCommand(luz);

        Command encenderVentilador = new EncenderVentiladorCommand(ventilador);
        Command apagarVentilador = new ApagarVentiladorCommand(ventilador);

        Command encenderAire = new EncenderAireCommand(aire);
        Command apagarAire = new ApagarAireCommand(aire);

        control.presionarBoton(encenderLuz);
        control.presionarBoton(encenderVentilador);
        control.presionarBoton(encenderAire);

        System.out.println("Deshaciendo última acción...");
        control.deshacerUltimaAccion();

        System.out.println("Deshaciendo otra acción...");
        control.deshacerUltimaAccion();
    }
}
