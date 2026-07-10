public boolean isCyclic() {
    ArrayList<T> visitados = new ArrayList<>();

    for (AdjList<T> lista : listVertex) {
        if (!visitados.contains(lista.getVertex().getData())) {
            if (dfsCycle(lista.getVertex(), null, visitados)) {
                return true;
            }
        }
    }

    return false;
}


private boolean dfsCycle(Vertex<T> actual, Vertex<T> padre, ArrayList<T> visitados) {

    visitados.add(actual.getData());

    AdjList<T> lista = findVertex(actual.getData());

    for (Edge<T> e : lista.getEdges()) {

        Vertex<T> vecino = e.getDestination();

        // Si no está visitado, seguimos explorando
        if (!visitados.contains(vecino.getData())) {

            if (dfsCycle(vecino, actual, visitados)) {
                return true;
            }

        }
        // Si está visitado y no es el padre, existe ciclo
        else if (!vecino.equals(padre)) {
            return true;
        }
    }

    return false;
}
