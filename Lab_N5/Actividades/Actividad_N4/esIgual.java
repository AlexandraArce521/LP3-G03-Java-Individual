public <E> boolean esIgual(Pila<E> otraPila) {
    if (this.elementos.size() != otraPila.elementos.size()) {
        return false;
    }

    for (int i = 0; i < this.elementos.size(); i++) {
        Object elem1 = this.elementos.get(i);
        Object elem2 = otraPila.elementos.get(i);

        if (!elem1.equals(elem2)) {
            return false; 
        }
    }

    return true;
}
