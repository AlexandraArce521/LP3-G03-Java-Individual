import java.util.*;
import java.util.ArrayList;


public class Main {

    public static class TaskModel {
      
      public Fecha fechaInicio;
      public Fecha fechaFinal;
      public String evento;
      public static ArrayList <Object> calendario;
      
      public TaskModel(int minutoI, int horaI, int diaI, int anioI, int minutoF, int horaF, int diaF, int anioF, String evento) {
        
        Fecha inicio = new Fecha(minutoI, horaI, diaI, anioI);
        Fecha ffinal = new Fecha(minutoF, horaF, diaF, anioF);
        
        //this.fechaInicio = fechaInicio;
        //this.fechaFinal = fechaFinal;
        this.evento = evento;
        calendario = new ArrayList <>();
        
      }
      
      public static void addTask(TaskModel tarea) {
        
        calendario.add(tarea);
        
      }
      
      public void removeTask(int indice) {
        
        calendario.remove(indice);
      }
      
      public String toString() {
        return "Tarea agregada!\n" +
              "Evento: " + evento;
      }
      
    }
    public static void main(String[] args) {
        
        Fecha fechaI = new Fecha(20, 16, 14, 2018);
        Fecha fechaF = new Fecha(30, 16, 14, 2018);

        
        TaskModel tarea1 = new TaskModel(20, 16, 14, 2018, 30, 16, 14, 2018, "Realizar laboratorio");
        TaskModel.addTask(tarea1);
        System.out.println(tarea1);
        
        
  }
}
