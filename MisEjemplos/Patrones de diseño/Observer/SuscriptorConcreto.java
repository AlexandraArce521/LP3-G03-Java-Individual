class SuscriptorConcreto implements Suscriptor {
	public String nombre;
	
	public SuscriptorConcreto (String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void update(String producto) {
		System.out.println(nombre+" |(!)Notificacion|Producto de Interes en Tienda: "+producto);
	}
}
