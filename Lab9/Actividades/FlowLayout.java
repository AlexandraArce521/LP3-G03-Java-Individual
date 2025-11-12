
//Aplicacion de FlowLayout

import javax.swing.*; // Para usar JFrame
import java.awt.*; // Permite interactuar con los usuarios y soporte de interfaz gráfica

public class App {
    public static void main(String[] args) {
    	
    	JFrame marco = new JFrame();
    	
    	marco.setTitle("Pruba FlowLayout");
    	marco.setSize(400,500);
    	marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	//FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
    	//FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
    	FlowLayout flow = new FlowLayout(FlowLayout.LEFT);


    	marco.setLayout(flow);
    	
    	JTextField campoNombre = new JTextField(30);
    	marco.add(campoNombre);
    	
    	marco.setVisible(true);
    	
    }
}
