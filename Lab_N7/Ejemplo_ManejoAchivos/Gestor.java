import java.io.*;
import java.util.*;

public class Gestor {
    private List<Personaje> personajes;
    private String archivo;

    public Gestor(String archivo) {
        this.archivo = archivo;
        this.personajes = new ArrayList<>();
        cargarDesdeArchivo();
    }

    // Leer los personajes desde el archivo
    private void cargarDesdeArchivo() {
        personajes.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    String nombre = datos[0];
                    int vida = Integer.parseInt(datos[1]);
                    int ataque = Integer.parseInt(datos[2]);
                    int defensa = Integer.parseInt(datos[3]);
                    int alcance = Integer.parseInt(datos[4]);
                    personajes.add(new Personaje(nombre, vida, ataque, defensa, alcance));
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo, se creará uno nuevo.");
        }
    }

    // Guardar los personajes en el archivo
    private void guardarEnArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Personaje p : personajes) {
                pw.println(p.toString());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los personajes.");
        }
    }

    public void mostrarPersonajes() {
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }

    public void agregarPersonaje(Personaje nuevo) {
        for (Personaje p : personajes) {
            if (p.getNombre().equals(nuevo.getNombre())) {  //IgnoreCase
                System.out.println("El personaje ya existe, no se creará.");
                return;
            }
        }
        personajes.add(nuevo);
        guardarEnArchivo();
        System.out.println("Personaje agregado correctamente.");
    }

    public void modificarPersonaje(String nombre, int nuevaVida, int nuevoAtaque, int nuevaDefensa, int nuevoAlcance) {
        for (Personaje p : personajes) {
            if (p.getNombre().equals(nombre)) {
                p.setVida(nuevaVida);
                p.setAtaque(nuevoAtaque);
                p.setDefensa(nuevaDefensa);
                p.setAlcance(nuevoAlcance);
                guardarEnArchivo();
                System.out.println("Personaje modificado.");
                return;
            }
        }
        System.out.println("No se encontró el personaje.");
    }

    public void eliminarPersonaje(String nombre) {
        Iterator<Personaje> it = personajes.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                it.remove();
                guardarEnArchivo();
                System.out.println("Personaje eliminado.");
                return;
            }
        }
        System.out.println("No se encontró el personaje.");
    }
}
