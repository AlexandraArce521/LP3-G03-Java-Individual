public class PilaEnlazada<T> implements Pila<T> {

    protected Nodo<T> cabeza;
    protected int tamanio;

    public PilaEnlazada() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    public void push(T x) {
        Nodo<T> nuevoNodo = new Nodo<>(x);
        nuevoNodo.next = cabeza;
        cabeza = nuevoNodo;
        tamanio++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        T dato = cabeza.valor;
        cabeza = cabeza.next;
        tamanio--;
        return dato;
    }

    public T top() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return cabeza.valor;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }
}
