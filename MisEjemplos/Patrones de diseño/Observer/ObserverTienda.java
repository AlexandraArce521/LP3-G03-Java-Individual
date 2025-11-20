public class ObserverTienda {
  public static void main(String[] args) {
		Tienda tienda = new Tienda("Iphone 8");
		SuscriptorConcreto juan = new SuscriptorConcreto("Juan");
		SuscriptorConcreto maria = new SuscriptorConcreto("María");
		SuscriptorConcreto carlos = new SuscriptorConcreto("Carlos");

		tienda.addSuscriptor(juan);
		tienda.addSuscriptor(maria);
		tienda.addSuscriptor(carlos);
		
		tienda.notificarSuscriptor();

	}
}
