import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CompraPasajeApp extends JFrame {
    // Componentes de la GUI
    private JTextField txtNombres, txtDocumento, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JRadioButton rbPrimerPiso, rbSegundoPiso;
    private JComboBox<String> cbOrigen, cbDestino;
    private JList<String> listaCalidad;
    private JButton btnComprar, btnReiniciar;
    
    // Datos para los combobox y listas
    private String[] ciudades = {"Lima", "Arequipa", "Trujillo", "Cusco", "Piura", "Chiclayo"};
    private String[] calidades = {"Económico", "Standard", "VIP"};
    
    public CompraPasajeApp() {
        super("Sistema de Compra de Pasajes - Transportes XYZ");
        setLayout(new BorderLayout(10, 10));
        
        // Crear componentes
        crearComponentes();
        organizarGUI();
        registrarEventos();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
    }
    
    private void crearComponentes() {
        // Campos de texto
        txtNombres = new JTextField(20);
        txtDocumento = new JTextField(15);
        txtFecha = new JTextField(10);
        
        // Casillas de verificación
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        
        // Botones de opción
        rbPrimerPiso = new JRadioButton("1er Piso", true);
        rbSegundoPiso = new JRadioButton("2do Piso");
        ButtonGroup grupoPiso = new ButtonGroup();
        grupoPiso.add(rbPrimerPiso);
        grupoPiso.add(rbSegundoPiso);
        
        // Cuadros combinados
        cbOrigen = new JComboBox<>(ciudades);
        cbDestino = new JComboBox<>(ciudades);
        
        // Lista de calidades
        listaCalidad = new JList<>(calidades);
        listaCalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaCalidad.setSelectedIndex(1); // Standard por defecto
        
        // Botones
        btnComprar = new JButton("Comprar Pasaje");
        btnReiniciar = new JButton("Reiniciar");
    }
    
    private void organizarGUI() {
        // Panel principal con padding
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(7, 1, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Panel 1: Información personal
        JPanel panelPersonal = new JPanel(new GridLayout(3, 2, 5, 5));
        panelPersonal.setBorder(BorderFactory.createTitledBorder("Información Personal"));
        panelPersonal.add(new JLabel("Nombres completos:"));
        panelPersonal.add(txtNombres);
        panelPersonal.add(new JLabel("Documento de identidad:"));
        panelPersonal.add(txtDocumento);
        panelPersonal.add(new JLabel("Fecha de viaje (dd/mm/aaaa):"));
        panelPersonal.add(txtFecha);
        
        // Panel 2: Origen y destino
        JPanel panelRuta = new JPanel(new GridLayout(2, 2, 5, 5));
        panelRuta.setBorder(BorderFactory.createTitledBorder("Ruta de Viaje"));
        panelRuta.add(new JLabel("Ciudad de Origen:"));
        panelRuta.add(cbOrigen);
        panelRuta.add(new JLabel("Ciudad de Destino:"));
        panelRuta.add(cbDestino);
        
        // Panel 3: Calidad de servicio
        JPanel panelCalidad = new JPanel(new BorderLayout());
        panelCalidad.setBorder(BorderFactory.createTitledBorder("Calidad de Servicio"));
        panelCalidad.add(new JScrollPane(listaCalidad), BorderLayout.CENTER);
        
        // Panel 4: Piso del bus
        JPanel panelPiso = new JPanel(new FlowLayout());
        panelPiso.setBorder(BorderFactory.createTitledBorder("Piso del Bus"));
        panelPiso.add(rbPrimerPiso);
        panelPiso.add(rbSegundoPiso);
        
        // Panel 5: Servicios opcionales
        JPanel panelServicios = new JPanel(new FlowLayout());
        panelServicios.setBorder(BorderFactory.createTitledBorder("Servicios Opcionales"));
        panelServicios.add(chkAudifonos);
        panelServicios.add(chkManta);
        panelServicios.add(chkRevistas);
        
        // Panel 6: Botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnComprar);
        panelBotones.add(btnReiniciar);
        
        // Agregar todos los paneles al panel principal
        panelPrincipal.add(panelPersonal);
        panelPrincipal.add(panelRuta);
        panelPrincipal.add(panelCalidad);
        panelPrincipal.add(panelPiso);
        panelPrincipal.add(panelServicios);
        panelPrincipal.add(panelBotones);
        
        add(panelPrincipal, BorderLayout.CENTER);
    }
    
    private void registrarEventos() {
        // Evento para el botón Comprar
        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarResumen();
            }
        });
        
        // Evento para el botón Reiniciar
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarFormulario();
            }
        });
    }
    
    private void mostrarResumen() {
        // Validar campos obligatorios
        if (txtNombres.getText().trim().isEmpty() || 
            txtDocumento.getText().trim().isEmpty() || 
            txtFecha.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, complete todos los campos obligatorios.", 
                "Campos Incompletos", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Construir resumen
        StringBuilder resumen = new StringBuilder();
        resumen.append("=== RESUMEN DE COMPRA ===\n\n");
        resumen.append("DATOS PERSONALES:\n");
        resumen.append("Nombres: ").append(txtNombres.getText()).append("\n");
        resumen.append("Documento: ").append(txtDocumento.getText()).append("\n");
        resumen.append("Fecha de viaje: ").append(txtFecha.getText()).append("\n\n");
        
        resumen.append("INFORMACIÓN DEL VIAJE:\n");
        resumen.append("Origen: ").append(cbOrigen.getSelectedItem()).append("\n");
        resumen.append("Destino: ").append(cbDestino.getSelectedItem()).append("\n");
        resumen.append("Calidad: ").append(listaCalidad.getSelectedValue()).append("\n");
        resumen.append("Piso: ").append(rbPrimerPiso.isSelected() ? "1er Piso" : "2do Piso").append("\n\n");
        
        resumen.append("SERVICIOS ADICIONALES:\n");
        ArrayList<String> servicios = new ArrayList<>();
        if (chkAudifonos.isSelected()) servicios.add("Audífonos");
        if (chkManta.isSelected()) servicios.add("Manta");
        if (chkRevistas.isSelected()) servicios.add("Revistas");
        
        if (servicios.isEmpty()) {
            resumen.append("Ningún servicio adicional seleccionado\n");
        } else {
            for (String servicio : servicios) {
                resumen.append("• ").append(servicio).append("\n");
            }
        }
        
        resumen.append("\n¡Gracias por su compra!");
        
        // Mostrar diálogo con el resumen
        JOptionPane.showMessageDialog(this, 
            resumen.toString(), 
            "Confirmación de Compra", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void reiniciarFormulario() {
        // Limpiar campos de texto
        txtNombres.setText("");
        txtDocumento.setText("");
        txtFecha.setText("");
        
        // Reiniciar casillas de verificación
        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);
        
        // Reiniciar botones de opción
        rbPrimerPiso.setSelected(true);
        
        // Reiniciar combobox
        cbOrigen.setSelectedIndex(0);
        cbDestino.setSelectedIndex(0);
        
        // Reiniciar lista
        listaCalidad.setSelectedIndex(1); // Standard
        
        JOptionPane.showMessageDialog(this, 
            "Formulario reiniciado correctamente.", 
            "Reinicio Completado", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        // Establecer look and feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Crear y mostrar la aplicación
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CompraPasajeApp().setVisible(true);
            }
        });
    }
}
