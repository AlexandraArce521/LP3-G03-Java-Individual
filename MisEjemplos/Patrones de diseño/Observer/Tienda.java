import java.util.List;
import java.util.ArrayList;

//Sujeto: Tienda
class Tienda {
	private String producto;
	private List<Suscriptor> suscriptores = new ArrayList<>();
	
	public Tienda(String producto) {
	  this.producto=producto;
	}
	
	public void addSuscriptor(Suscriptor suscriptor) {
		suscriptores.add(suscriptor);
	}
	public void removeSuscriptor(Suscriptor suscriptor) {
		suscriptores.remove(suscriptor);
	}
	
	public void notificarSuscriptor() {
		for(Suscriptor s: suscriptores) {
			s.update(producto);
		}
	}
}
