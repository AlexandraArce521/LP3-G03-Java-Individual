public class Par <F, S> {
  
  F primero;
  S segundo;
  
  public Par(F primero, S segundo) {
    this.primero = primero;
    this.segundo = segundo;
  }
  
  public F getPrimero() {
    return primero;
  }
  
  public S getSegundo() {
    return segundo;
  }

  public void setPrimero(F primero) {
    this.primero = primero;
  }
  
  public void setSegundo(S segundo) {
    this.segundo = segundo;
  }
  
  public boolean esIgual(Object obj) {
    
    if(this == obj) {
      return true;
    }
    return false;
    
  }
  
  public String toString() {
    
    return "Primero: " + primero +
          ", Segundo: " + segundo;
    
  }

}
