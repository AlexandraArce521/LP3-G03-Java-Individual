public interface Cola <G> {
    public void enqueue(G x);
    public G dequeue();
    public boolean isEmpty();
    public boolean isFull();
}
