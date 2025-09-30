import java.util.Scanner;

class InvalidSubscriptException extends Exception {
    public InvalidSubscriptException() {
        super("(!) Indice de arreglo no valido");
    }
}
public class PruebaMetodoGenerico { 
  
  public static <E> void imprimirArreglo (E[] arregloEntrada) {

	  for (E elemento: arregloEntrada) {
		  System.out.printf("%s", elemento);
	      System.out.print(" ");

	  }
      System.out.println();

  }

  public static <E> void imprimirArreglo (E[] arregloEntrada, int subindiceInferior, int subindiceSuperior) throws InvalidSubscriptException {
	  
    if (subindiceInferior < 0 || subindiceSuperior >= arregloEntrada.length || subindiceInferior >= subindiceSuperior)  {
      throw new InvalidSubscriptException();
    }
    
    System.out.println("Límites válidos: " + subindiceInferior + " - " + subindiceSuperior);

    for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
        System.out.printf("%s ", arregloEntrada[i]);
      }
      System.out.println();
      
      int cantRango = subindiceSuperior - subindiceInferior + 1;
      System.out.println("Cantidad de elementos dentro del rango: " + cantRango);
      
  }

  public static void main (String args[]) {
    
    Scanner scanner = new Scanner(System.in);
    int subindiceInferior, subindiceSuperior;
    
    Integer[] arregloInteger = {1, 2, 3, 4};
    Character[] arregloCharacter = { 'H', 'O', 'L', 'A' };
    
    
    try {
    
    System.out.println( "\nIngrese el subindice inferior: " );
    subindiceInferior = scanner.nextInt();
    
    System.out.println( "\nIngrese el subindice superior: " );
    subindiceSuperior = scanner.nextInt();
    
    imprimirArreglo(arregloInteger, subindiceInferior, subindiceSuperior);
    imprimirArreglo(arregloCharacter);

  
    
    } catch (InvalidSubscriptException e) {
      
      System.out.println("Error: " + e.getMessage());
      
    } 
  } 
}
