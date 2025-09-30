//Se agrega este metodo a la Pila

public boolean contains(T elemBuscado) {
	  
	    for(int i = elementos.size() - 1; i >= 0; i--) {
	    	
	    	if(this.elementos.get(i).equals(elemBuscado)) {
	    		return true;
	    	}
	    	
	      }
	    return false;
  }
