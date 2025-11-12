
//Diferencias entre BorderLayout y FlowLayout

import javax.swing.*; // Para usar JFrame
import java.awt.*; // Permite interactuar con los usuarios y soporte de interfaz gráfica

public class App {
    public static void main(String[] args) {

        JFrame marco;
        marco = new JFrame();    

        // Creación de botones
        JButton btn1 = new JButton("1");    
        JButton btn2 = new JButton("2");    
        JButton btn3 = new JButton("3");    
        JButton btn4 = new JButton("4");    
        JButton btn5 = new JButton("5");    
        JButton btn6 = new JButton("6");    
        JButton btn7 = new JButton("7");    
        JButton btn8 = new JButton("8");    
        JButton btn9 = new JButton("9");    

        // Añadir botones al frame
        marco.add(btn1); marco.add(btn2); marco.add(btn3);  
        marco.add(btn4); marco.add(btn5); marco.add(btn6);  
        marco.add(btn7); marco.add(btn8); marco.add(btn9);    

        // Estableciendo el GridLayout con 3 filas y 3 columnas
        marco.setLayout(new GridLayout(3, 3));    

        // Configuración del frame
        marco.setSize(300, 300);    
        marco.setVisible(true);    
        
    }
}
