import java.util.*;

public class ColaArray<T> implements Cola<T> {

    private int inicio;
    private int fin;
    private ArrayList<T> array;
    private int tamanio;
    private int cantidad;

    public ColaArray(int tamanio) {
        this.tamanio = tamanio;
        this.inicio = 0;
        this.fin = -1;
        this.cantidad = 0;

        this.array = new ArrayList<>(tamanio);

        // Inicializar con null para poder usar set()
        for (int i = 0; i < tamanio; i++) {
            array.add(null);
        }
    }

    @Override
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("La cola está llena");
        }

        fin = (fin + 1) % tamanio;
        array.set(fin, x);
        cantidad++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }

        T dato = array.get(inicio);
        inicio = (inicio + 1) % tamanio;
        cantidad--;
        return dato;
    }

    @Override
    public T front() {
        if (isEmpty()) {
            throw new RuntimeException("La cola está vacía");
        }

        return array.get(inicio);
    }

    @Override
    public boolean isEmpty() {
        return cantidad == 0;
    }

    @Override
    public boolean isFull() {
        return cantidad == tamanio;
    }
}
