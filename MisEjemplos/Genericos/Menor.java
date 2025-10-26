import java.util.*;

public class Main {
  
    public static <T extends Comparable <T> > T menor(T [] vec) {
      T elemMin = vec[0];
        for(int i = 1; i < vec.length; i++) {
          if(vec[i] != null && elemMin.compareTo(vec[i]) > 0) {
            elemMin = vec[i];
          }
        }
        return elemMin;
    }
    
    public static void main(String[] args) {
      
      Integer [] vector = {13,50,-23,4};
      System.out.println(menor(vector));
  }
}
