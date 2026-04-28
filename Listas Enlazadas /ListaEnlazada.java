public class ListaEnlazada<T> {
    private Nodo<T> cabeza; //cabeza
    
    public ListaEnlazada() {
        cabeza = null;
    }
    
    public void insertar(T x) {
        Nodo nuevoNodo = new Nodo(x);
        
        if(cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo nodoTemporal = cabeza; //Nodo temporal
            
            while(nodoTemporal.next != null) {
                nodoTemporal = nodoTemporal.next;
            }
            
            nodoTemporal.next = nuevoNodo;
        }
        
    }
    
    public boolean isEmptyList() {
        if(cabeza == null) {
            return true;
        }
        return false;
    }
    
    public int contar() {
        Nodo nodoTemporal = cabeza;
        int contador = 0;
        
        while(nodoTemporal != null) {
            nodoTemporal = nodoTemporal.next;
            contador++;
        }
        
        return contador;
    }
    
    public boolean removerNodo(T x) {
        //Si la lista esta vacia
        if(isEmptyList()) {
            return false;
        }
        
        //Caso 1: El elemento es la cabeza de los nodos
        if(cabeza.valor.equals(x)) {
            cabeza = cabeza.next;
            return true;
        }
        
        //Caso 2: Buscar el nodo a eliminar
        Nodo<T> actual = cabeza;
        Nodo<T> anterior = null;
        
        while (actual != null && !actual.valor.equals(x)) {
            anterior = actual;
            actual = actual.next;
        }
        
        // Caso 3: No se encontró el nodo
        if (actual == null) {
            System.out.println("Elemento no encontrado");
            return;
        }

        // Eliminar nodo (reconectar)
        anterior.next = actual.next;
        
    }
    
    public void mostrar() {
        Nodo nodoTemporal = cabeza;
        
        while(nodoTemporal != null) {
            System.out.println(nodoTemporal.valor);
            nodoTemporal = nodoTemporal.next;
        }
    }
}
