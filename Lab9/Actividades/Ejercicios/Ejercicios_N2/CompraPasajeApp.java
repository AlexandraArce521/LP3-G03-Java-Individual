import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CompraPasajeApp extends JFrame {
    private JTextField txtNombres, txtDocumento, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JRadioButton rbPrimerPiso, rbSegundoPiso;
    private JComboBox<String> cbOrigen, cbDestino;
    private JList<String> listaCalidad;
    private JButton btnComprar, btnReiniciar;
    
    private String[] ciudades = {"Lima", "Arequipa", "Trujillo", "Cusco", "Piura", "Chiclayo"};
    private String[] calidades = {"Económico", "Standard", "VIP"};
    
    public CompraPasajeApp() {
        super("Sistema de Compra de Pasajes - Transportes XYZ");
        setLayout(new BorderLayout(10, 10));
        
        crearComponentes();
        organizarGUI();
        registrarEventos();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
    }
    
    private void crearComponentes() {
        txtNombres = new JTextField(20);
        txtDocumento = new JTextField(15);
        txtFecha = new JTextField(10);
        
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        
        rbPrimerPiso = new JRadioButton("1er Piso", true);
        rbSegundoPiso = new JRadioButton("2do Piso");
        ButtonGroup grupoPiso = new ButtonGroup();
        grupoPiso.add(rbPrimerPiso);
        grupoPiso.add(rbSegundoPiso);
        
        cbOrigen = new JComboBox<>(ciudades);
        cbDestino = new JComboBox<>(ciudades);
        
        listaCalidad = new JList<>(calidades);
        listaCalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaCalidad.setSelectedIndex(1); 
        
        btnComprar = new JButton("Comprar Pasaje");
        btnReiniciar = new JButton("Reiniciar");
    }
    
    private void organizarGUI() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(7, 1, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JPanel panelPersonal = new JPanel(new GridLayout(3, 2, 5, 5));
        panelPersonal.setBorder(BorderFactory.createTitledBorder("Información Personal"));
        panelPersonal.add(new JLabel("Nombres completos:"));
        panelPersonal.add(txtNombres);
        panelPersonal.add(new JLabel("Documento de identidad:"));
        panelPersonal.add(txtDocumento);
        panelPersonal.add(new JLabel("Fecha de viaje (dd/mm/aaaa):"));
        panelPersonal.add(txtFecha);
        
        JPanel panelRuta = new JPanel(new GridLayout(2, 2, 5, 5));
        panelRuta.setBorder(BorderFactory.createTitledBorder("Ruta de Viaje"));
        panelRuta.add(new JLabel("Ciudad de Origen:"));
        panelRuta.add(cbOrigen);
        panelRuta.add(new JLabel("Ciudad de Destino:"));
        panelRuta.add(cbDestino);
        
        JPanel panelCalidad = new JPanel(new BorderLayout());
        panelCalidad.setBorder(BorderFactory.createTitledBorder("Calidad de Servicio"));
        panelCalidad.add(new JScrollPane(listaCalidad), BorderLayout.CENTER);
        
        JPanel panelPiso = new JPanel(new FlowLayout());
        panelPiso.setBorder(BorderFactory.createTitledBorder("Piso del Bus"));
        panelPiso.add(rbPrimerPiso);
        panelPiso.add(rbSegundoPiso);
        
        JPanel panelServicios = new JPanel(new FlowLayout());
        panelServicios.setBorder(BorderFactory.createTitledBorder("Servicios Opcionales"));
        panelServicios.add(chkAudifonos);
        panelServicios.add(chkManta);
        panelServicios.add(chkRevistas);
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnComprar);
        panelBotones.add(btnReiniciar);
        
        panelPrincipal.add(panelPersonal);
        panelPrincipal.add(panelRuta);
        panelPrincipal.add(panelCalidad);
        panelPrincipal.add(panelPiso);
        panelPrincipal.add(panelServicios);
        panelPrincipal.add(panelBotones);
        
        add(panelPrincipal, BorderLayout.CENTER);
    }
    
    private void registrarEventos() {
        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarResumen();
            }
        });
        
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarFormulario();
            }
        });
    }
    
    private void mostrarResumen() {
        if (txtNombres.getText().trim().isEmpty() || 
            txtDocumento.getText().trim().isEmpty() || 
            txtFecha.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, complete todos los campos obligatorios.", 
                "Campos Incompletos", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
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
        
        JOptionPane.showMessageDialog(this, 
            resumen.toString(), 
            "Confirmación de Compra", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void reiniciarFormulario() {
        txtNombres.setText("");
        txtDocumento.setText("");
        txtFecha.setText("");
        
        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);
        
        rbPrimerPiso.setSelected(true);
        
        cbOrigen.setSelectedIndex(0);
        cbDestino.setSelectedIndex(0);
        
        listaCalidad.setSelectedIndex(1);
        
        JOptionPane.showMessageDialog(this, 
            "Formulario reiniciado correctamente.", 
            "Reinicio Completado", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CompraPasajeApp().setVisible(true);
            }
        });
    }
}
