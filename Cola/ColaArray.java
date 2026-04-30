import java.util.*;

public interface ColaArray <T> implements Cola {
    public int inicio;
    public int fin;
    public ArrayList<T> array;
    public int tamanio = 0;
    public int cantidad = 0;
    
    public ColaArray(ArrayList array, int tamanio) {
        this.inicio = 0;
        this.fin = 0;
        ArrayList<T> array = new ArrayList<>(tamanio);
    }
    
    @Override
    public void enqueue(T x) {
        if(isFull) {
            throw new RuntimeException ("Esta lleno la cola");
        }
        else {
            fin = (fin+1)%tamanio;
            array[final] = x;
            cantidad++;
        }
    }
    
    @Override
    public boolean isFull() {
        if(cantidad == tamanio) {
            return true;
        }
        return false;
    }
}
