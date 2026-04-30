public class PilaEnlazada <T> implements Pila {
    
    protected Nodo<T> cabeza;
    protected int tamanio;
    
    public PilaEnlazada(Nodo cabeza, int tamanio) {
        this.cabeza = null;
        this.tamanio = 0;
    }
    
    public void push(T x) {
        Nodo<T> nuevoNodo = new Nodo<>(x);
        nuevoNodo.next = cabeza;
        cabeza = nuevoNodo;
        tamanio++;
    }
    
    public <T> T pop() {
        T dato = cabeza.valor;
        cabeza = cabeza.next;
        return dato;
        
    }
    
    public <T> T top() {
        T dato = cabeza.valor;
        return dato;
    }
    
    public boolean isEmpty() {
        if (cabeza == null) {
            return false;
        }
        
        return true;
    }
}
