import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AppTemperatura {
    public static void main(String[] args) {
    	JFrame ventana = new JFrame("Temperatura");
    	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	ventana.setSize(400, 500);
    	
    	//MODELO DE DATOS
    	Temperatura temp = new Temperatura("14", "24", "12", "22", "27", "32", "33");
    	JTextField Lunes = new JTextField(temp.getgLunes(), 10);
    	JTextField Martes = new JTextField(temp.getgMartes(), 10);
    	JTextField Miercorles = new JTextField(temp.getgMartes(), 10);
    	JTextField Jueves = new JTextField(temp.getgMartes(), 10);
    	JTextField Viernes = new JTextField(temp.getgMartes(), 10);
    	JTextField Sadabo = new JTextField(temp.getgMartes(), 10);
    	JTextField Domingo = new JTextField(temp.getgMartes(), 10);
    	
    	
    	ventana.setVisible(true);
    }
}



/*
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de Binding de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);

        // Modelo de datos
        Persona persona = new Persona("John Doe", 30, "M");

        // Componentes de interfaz para cada atributo
        JTextField nombreField = new JTextField(persona.getNombre(), 15);
        JTextField edadField = new JTextField(String.valueOf(persona.getEdad()), 15);
        JTextField sexoField = new JTextField(persona.getSexo(), 5);
        JButton button = new JButton("Actualizar Modelo");

        // Listener para actualizar el modelo cuando el botón es presionado
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                persona.setNombre(nombreField.getText());
                try {
                    int edad = Integer.parseInt(edadField.getText());
                    persona.setEdad(edad);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un número válido para la edad.");
                }
                persona.setSexo(sexoField.getText());

                // Mostrar los valores actualizados en consola
                System.out.println("Modelo actualizado:");
                System.out.println("Nombre: " + persona.getNombre());
                System.out.println("Edad: " + persona.getEdad());
                System.out.println("Sexo: " + persona.getSexo());
            }
        });

        frame.setLayout(new java.awt.FlowLayout());
        frame.add(new JLabel("Nombre:"));
        frame.add(nombreField);
        frame.add(new JLabel("Edad:"));
        frame.add(edadField);
        frame.add(new JLabel("Sexo:"));
        frame.add(sexoField);
        frame.add(button);
        frame.setVisible(true);
    }
}

 */
