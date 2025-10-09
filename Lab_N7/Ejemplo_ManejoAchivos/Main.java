import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor("personajes.txt");
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n=== MENÚ PERSONAJES ===");
            System.out.println("1. Mostrar personajes");
            System.out.println("2. Agregar personaje");
            System.out.println("3. Modificar personaje");
            System.out.println("4. Eliminar personaje");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    gestor.mostrarPersonajes();
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Vida: ");
                    int vida = sc.nextInt();
                    System.out.print("Ataque: ");
                    int ataque = sc.nextInt();
                    System.out.print("Defensa: ");
                    int defensa = sc.nextInt();
                    System.out.print("Alcance: ");
                    int alcance = sc.nextInt();
                    gestor.agregarPersonaje(new Personaje(nombre, vida, ataque, defensa, alcance));
                    break;
                case 3:
                    System.out.print("Nombre del personaje a modificar: ");
                    String n = sc.nextLine();
                    System.out.print("Nueva vida: ");
                    int v = sc.nextInt();
                    System.out.print("Nuevo ataque: ");
                    int a = sc.nextInt();
                    System.out.print("Nueva defensa: ");
                    int d = sc.nextInt();
                    System.out.print("Nuevo alcance: ");
                    int al = sc.nextInt();
                    gestor.modificarPersonaje(n, v, a, d, al);
                    break;
                case 4:
                    System.out.print("Nombre del personaje a eliminar: ");
                    String eliminar = sc.nextLine();
                    gestor.eliminarPersonaje(eliminar);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
