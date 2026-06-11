package Grafos;
import java.util.*;

public class Vertex <T>{
	private T dato;
	private List<Vertex<T>>  adjList;
	
	public Vertex(T d) {
		this.dato = d;
		this.adjList = new ArrayList<>();
	}
	
	public void addEdge(Vertex<T> destino) {
		this.adjList.add(destino);
	}
    public T getDatos() {
        return dato;
    }

    public List<Vertex<T>> getAristas() {
        return adjList;
    }
	
}
