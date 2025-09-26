
public class IgualGenerico <T> {
  
  T a;
  T b;
  
  public IgualGenerico(T a, T b) {
    this.a = a;
    this.b = b;
  }
  
  public boolean esIgualA(T a, T b) {
    if(a.equals(b)) {
      return true;
    }
    
    return false;
  }

}
