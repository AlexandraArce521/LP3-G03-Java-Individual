package Grafos;

public class Edge<T> {
	public Vertex destino;
	public int w;
    public Edge(Vertex destino, int w) {
        this.destino = destino;
        this.w = w;
    }

    // Getters y Setters
    public Vertex getDestino() {
        return destino;
    }

    public void setDestino(Vertex destino) {
        this.destino = destino;
    }

    public double getPeso() {
        return w;
    }

    public void setPeso(double peso) {
        this.w = w;
    }

    @Override
    public String toString() {
        return " -> " + destino + " (peso: " + w + ")";
    }
}
