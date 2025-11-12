
//Diferencias entre BorderLayout y FlowLayout

import javax.swing.*; // Para usar JFrame
import java.awt.*; // Permite interactuar con los usuarios y soporte de interfaz gráfica

public class App {
    public static void main(String[] args) {
    	
    	JFrame marco = new JFrame();
    	marco.setTitle("Pruba BorderLayout");
    	marco.setSize(400,150);
    	
    	JPanel Norte = new JPanel();
    	JPanel Oeste = new JPanel();
    	JPanel Centro = new JPanel();
    	JPanel Este = new JPanel();
    	JPanel Sur = new JPanel();

    	JLabel eqN = new JLabel("Norte");
    	Norte.add(eqN);
    	
    	JLabel eqS = new JLabel("Sur");
    	Sur.add(eqS);

    	JLabel eqW = new JLabel("Oeste");
    	Oeste.add(eqW);
    	
    	JLabel eqE = new JLabel("Este");
    	Este.add(eqE);
    	
    	
    	marco.add(Norte, BorderLayout.NORTH);
        marco.add(Oeste, BorderLayout.WEST);
        marco.add(Centro, BorderLayout.CENTER);
        marco.add(Este, BorderLayout.EAST);
        marco.add(Sur, BorderLayout.SOUTH);
    	

    	marco.setVisible(true);
  
    }
}
