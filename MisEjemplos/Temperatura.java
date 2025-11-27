import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGraficoBarras extends JPanel {
    
    // Constantes para configuración
    private static final String[] DIAS = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    private static int[] TEMPERATURAS = {5, 10, 20, 25, 30, 35, 40};
    private static final Color COLOR_BARRAS = new Color(160, 255, 250);
    private static final int ANCHO_BARRA = 50;
    private static final int ESPACIO_BARRA = 20;
    private static final int MARGEN_IZQUIERDO = 50;
    private static final int MARGEN_INFERIOR = 50;
    private static final int ALTURA_MAXIMA = 200;
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Configuración de Graphics2D y antialiasing
        Graphics2D g2d = (Graphics2D) g;
        configurarGraficos(g2d);
        
        // Encontrar el valor máximo de temperatura para escalar las barras
        int maxTemperatura = calcularMaximaTemperatura();
        
        // Dibujar componentes del gráfico
        dibujarBarras(g2d, maxTemperatura);
        dibujarEjeY(g2d);
        dibujarEjeX(g2d);
    }
    
    private void configurarGraficos(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
    
    private int calcularMaximaTemperatura() {
        int maxTemperatura = 0;
        for (int temperatura : TEMPERATURAS) {
            if (temperatura > maxTemperatura) {
                maxTemperatura = temperatura;
            }
        }
        return maxTemperatura;
    }
    
    private void dibujarBarras(Graphics2D g2d, int maxTemperatura) {
        for (int i = 0; i < DIAS.length; i++) {
            int alturaBarra = calcularAlturaBarra(TEMPERATURAS[i], maxTemperatura);
            int x = calcularPosicionX(i);
            int y = calcularPosicionY(alturaBarra);
            
            dibujarBarra(g2d, x, y, alturaBarra);
            dibujarEtiquetaTemperatura(g2d, TEMPERATURAS[i], x, y);
            dibujarEtiquetaDia(g2d, DIAS[i], x);
        }
    }
    
    private int calcularAlturaBarra(int temperatura, int maxTemperatura) {
        return (int) ((double) temperatura / maxTemperatura * ALTURA_MAXIMA);
    }
    
    private int calcularPosicionX(int indice) {
        return MARGEN_IZQUIERDO + indice * (ANCHO_BARRA + ESPACIO_BARRA);
    }
    
    private int calcularPosicionY(int alturaBarra) {
        return getHeight() - MARGEN_INFERIOR - alturaBarra;
    }
    
    private void dibujarBarra(Graphics2D g2d, int x, int y, int alturaBarra) {
        g2d.setColor(COLOR_BARRAS);
        g2d.fillRect(x, y, ANCHO_BARRA, alturaBarra);
        
        // Borde de la barra
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, ANCHO_BARRA, alturaBarra);
    }
    
    private void dibujarEtiquetaTemperatura(Graphics2D g2d, int temperatura, int x, int y) {
        g2d.setColor(Color.BLACK);
        String texto = temperatura + "°C";
        FontMetrics fm = g2d.getFontMetrics();
        int textoAncho = fm.stringWidth(texto);
        g2d.drawString(texto, x + (ANCHO_BARRA - textoAncho) / 2, y - 5);
    }
    
    private void dibujarEtiquetaDia(Graphics2D g2d, String dia, int x) {
        g2d.setColor(Color.BLACK);
        FontMetrics fm = g2d.getFontMetrics();
        int textoAncho = fm.stringWidth(dia);
        g2d.drawString(dia, x + (ANCHO_BARRA - textoAncho) / 2, getHeight() - MARGEN_INFERIOR + 20);
    }
    
    private void dibujarEjeY(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.drawLine(MARGEN_IZQUIERDO, 
                    getHeight() - MARGEN_INFERIOR, 
                    MARGEN_IZQUIERDO, 
                    getHeight() - MARGEN_INFERIOR - ALTURA_MAXIMA);
        g2d.drawString("Temperatura (°C)", 
                      MARGEN_IZQUIERDO - 45, 
                      getHeight() - MARGEN_INFERIOR - ALTURA_MAXIMA - 10);
    }
    
    private void dibujarEjeX(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.drawLine(MARGEN_IZQUIERDO,
                    getHeight() - MARGEN_INFERIOR,
                    MARGEN_IZQUIERDO + DIAS.length * (ANCHO_BARRA + ESPACIO_BARRA),
                    getHeight() - MARGEN_INFERIOR);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 400);
    }
    
    // Método para actualizar las temperaturas
    public static void actualizarTemperaturas(int[] nuevasTemperaturas) {
        TEMPERATURAS = nuevasTemperaturas.clone();
    }
    
    // Clase interna para la interfaz de entrada de temperaturas
    public static class PanelTemperatura extends JPanel {
        private JTextField[] camposTemperatura;
        
        public PanelTemperatura() {
            organizar();
        }
        
        private void organizar() {
            setLayout(new GridLayout(8, 2, 5, 5));
            
            camposTemperatura = new JTextField[DIAS.length];
            
            for (int i = 0; i < DIAS.length; i++) {
                add(new JLabel("Temperatura para " + DIAS[i] + ":"));
                camposTemperatura[i] = new JTextField(String.valueOf(TEMPERATURAS[i]), 5);
                add(camposTemperatura[i]);
            }
        }
        
        public int[] obtenerTemperaturas() throws NumberFormatException {
            int[] temperaturas = new int[DIAS.length];
            for (int i = 0; i < DIAS.length; i++) {
                temperaturas[i] = Integer.parseInt(camposTemperatura[i].getText());
            }
            return temperaturas;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear frame principal con pestañas
            JFrame frame = new JFrame("Visualización de Temperatura - Gráfico de Barras");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Crear pestañas
            JTabbedPane tabbedPane = new JTabbedPane();
            
            // Panel del gráfico
            AppGraficoBarras grafico = new AppGraficoBarras();
            tabbedPane.addTab("Gráfico", grafico);
            
            // Panel de entrada de datos
            PanelTemperatura panelTemperatura = new PanelTemperatura();
            JPanel panelEntrada = new JPanel(new BorderLayout());
            panelEntrada.add(panelTemperatura, BorderLayout.CENTER);
            
            // Botón para actualizar gráfico
            JButton btnActualizar = new JButton("Actualizar Gráfico");
            btnActualizar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        int[] nuevasTemperaturas = panelTemperatura.obtenerTemperaturas();
                        actualizarTemperaturas(nuevasTemperaturas);
                        grafico.repaint(); 
                        tabbedPane.setSelectedIndex(0);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, 
                            "Por favor, ingrese valores numéricos válidos para todas las temperaturas.",
                            "Error de entrada", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            
            JPanel panelBoton = new JPanel();
            panelBoton.add(btnActualizar);
            panelEntrada.add(panelBoton, BorderLayout.SOUTH);
            
            tabbedPane.addTab("Ingresar Datos", panelEntrada);
            
            frame.add(tabbedPane);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
