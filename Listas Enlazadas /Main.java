public class Main
{
	public static void main(String[] args) {
		Nodo n1 = new Nodo(12);
		Nodo n2 = new Nodo(45);
		Nodo n3 = new Nodo(100);

        ListaEnlazada<Nodo> lista = new ListaEnlazada();
        lista.insertar(n1);
        lista.insertar(n2);
        lista.insertar(n3);
        
        lista.mostrar();
        
        System.out.println("Esta vacia la lista?: "+ lista.isEmptyList());
        
        System.out.println("Esta lista tiene: "+ lista.contar() + " elementos");
        
	}
}
