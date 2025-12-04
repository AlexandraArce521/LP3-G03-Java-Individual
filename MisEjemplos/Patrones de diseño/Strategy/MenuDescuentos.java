import java.util.ArrayList;
import java.util.Scanner;

public class MenuDescuentos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Producto> productos = new ArrayList<>();

        System.out.print("Ingrese cantidad de productos: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Nombre del producto: ");
            sc.nextLine();
            String nombre = sc.nextLine();

            System.out.print("Precio: ");
            double precio = sc.nextDouble();

            productos.add(new Producto(nombre, precio));
        }

        double total = 0;
        double[] precios = new double[productos.size()];

        for (int i = 0; i < productos.size(); i++) {
            total += productos.get(i).getPrecio();
            precios[i] = productos.get(i).getPrecio();
        }

        System.out.println("\n--- MENÚ DE DESCUENTOS ---");
        System.out.println("1. Sin descuento");
        System.out.println("2. 10% de descuento");
        System.out.println("3. Descuento por productos iguales (30%)");
        System.out.println("4. Descuento acumulado (50% al menor desde 3 productos)");
        System.out.print("Seleccione una opción: ");

        int opcion = sc.nextInt();

        DescuentoEstrategia estrategia = null;

        switch (opcion) {

            case 1:
                estrategia = new NoDescuento();
                break;

            case 2:
                estrategia = new DiezPorciento();
                break;

            case 3:
                System.out.print("Ingrese código producto 1: ");
                int c1 = sc.nextInt();
                System.out.print("Ingrese código producto 2: ");
                int c2 = sc.nextInt();
                estrategia = new DescuentoPorcentual(c1, c2);
                break;

            case 4:
                estrategia = new DescuentoPorcentualAcumulado(precios);
                break;

            default:
                System.out.println("Opción inválida");
                return;
        }

        CalculadoraDePrecios calculadora = new CalculadoraDePrecios();
        calculadora.setDescuentoPrecio(estrategia);

        double totalFinal = calculadora.calcularPrecio(total);

        System.out.println("\nTotal sin descuento: S/ " + total);
        System.out.println("Total con descuento: S/ " + totalFinal);
    }
}
