package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.AgenciaSeguro;
import services.AgenciaSeguroServices;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class AgenciaSeguroJFrame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIdAgencia;
    private JTextField txtNombreAgencia;
    private JTextField txtDireccionPostal;
    private JTextField txtTelefono;
    private JTextField txtCorreoElectronico;
    private JTextField txtIdTipoSeguro;
    private JTextField txtDirectorGeneral;
    private JTextField txtJefeDepartamentoSeguros;
    private JTextField txtJefeDepartamentoReclamaciones;

    private JButton btnAgregar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnLimpiar;

    private JTable tablaAgenciaSeguro;
    private DefaultTableModel modeloTabla;

    private AgenciaSeguroServices agenciaSeguroServices;

    public static void main (String args[]){
    	AgenciaSeguroJFrame f = new AgenciaSeguroJFrame();
    	f.setVisible(true);
    }
    
    public AgenciaSeguroJFrame() {
        super("Gestión de Agencias de Seguro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crea los componentes de la interfaz
        JPanel panelCampos = new JPanel(new GridLayout(9, 2, 10, 10));
        panelCampos.setBorder(BorderFactory.createTitledBorder("Datos de la Agencia"));

        JLabel lblIdAgencia = new JLabel("ID Agencia:");
        txtIdAgencia = new JTextField();
        txtIdAgencia.setEditable(false); // ID no editable
        panelCampos.add(lblIdAgencia);
        panelCampos.add(txtIdAgencia);

        JLabel lblNombreAgencia = new JLabel("Nombre de la Agencia:");
        txtNombreAgencia = new JTextField();
        panelCampos.add(lblNombreAgencia);
        panelCampos.add(txtNombreAgencia);

        JLabel lblDireccionPostal = new JLabel("Dirección Postal:");
        txtDireccionPostal = new JTextField();
        panelCampos.add(lblDireccionPostal);
        panelCampos.add(txtDireccionPostal);

        JLabel lblTelefono = new JLabel("Teléfono:");
        txtTelefono = new JTextField();
        panelCampos.add(lblTelefono);
        panelCampos.add(txtTelefono);

        JLabel lblCorreoElectronico = new JLabel("Correo Electrónico:");
        txtCorreoElectronico = new JTextField();
        panelCampos.add(lblCorreoElectronico);
        panelCampos.add(txtCorreoElectronico);

        JLabel lblIdTipoSeguro = new JLabel("ID Tipo de Seguro:");
        txtIdTipoSeguro = new JTextField();
        panelCampos.add(lblIdTipoSeguro);
        panelCampos.add(txtIdTipoSeguro);

        JLabel lblDirectorGeneral = new JLabel("Director General:");
        txtDirectorGeneral = new JTextField();
        panelCampos.add(lblDirectorGeneral);
        panelCampos.add(txtDirectorGeneral);

        JLabel lblJefeDepartamentoSeguros = new JLabel("Jefe Dpto. Seguros:");
        txtJefeDepartamentoSeguros = new JTextField();
        panelCampos.add(lblJefeDepartamentoSeguros);
        panelCampos.add(txtJefeDepartamentoSeguros);

        JLabel lblJefeDepartamentoReclamaciones = new JLabel("Jefe Dpto. Reclamaciones:");
        txtJefeDepartamentoReclamaciones = new JTextField();
        panelCampos.add(lblJefeDepartamentoReclamaciones);
        panelCampos.add(txtJefeDepartamentoReclamaciones);

        // Crea el panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAgregar = new JButton("Agregar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar");
        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);

        // Crea la tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID Agencia");
        modeloTabla.addColumn("Nombre de la Agencia");
        modeloTabla.addColumn("Dirección Postal");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Correo Electrónico");
        modeloTabla.addColumn("ID Tipo de Seguro");
        modeloTabla.addColumn("Director General");
        modeloTabla.addColumn("Jefe Dpto. Seguros");
        modeloTabla.addColumn("Jefe Dpto. Reclamaciones");

        tablaAgenciaSeguro = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaAgenciaSeguro);

        // Agrega los paneles al JFrame
        add(panelCampos, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        // Inicializa el servicio de la tabla
        agenciaSeguroServices = new AgenciaSeguroServices();

        // Agrega los listeners de los botones
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAgenciaSeguro();
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarAgenciaSeguro();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarAgenciaSeguro();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        // Carga la tabla inicialmente
        cargarTabla();

        setVisible(true);
    }

    private void agregarAgenciaSeguro() {
        String nombreAgencia = txtNombreAgencia.getText();
        String direccionPostal = txtDireccionPostal.getText();
        String telefono = txtTelefono.getText();
        String correoElectronico = txtCorreoElectronico.getText();
        int idTipoSeguro = Integer.parseInt(txtIdTipoSeguro.getText());
        String directorGeneral = txtDirectorGeneral.getText();
        String jefeDepartamentoSeguros = txtJefeDepartamentoSeguros.getText();
        String jefeDepartamentoReclamaciones = txtJefeDepartamentoReclamaciones.getText();

        AgenciaSeguro agenciaSeguro = new AgenciaSeguro(0, nombreAgencia, direccionPostal, telefono, correoElectronico, idTipoSeguro, directorGeneral, jefeDepartamentoSeguros, jefeDepartamentoReclamaciones);

        if (agenciaSeguroServices.insertarAgenciaSeguro(agenciaSeguro)) {
            JOptionPane.showMessageDialog(this, "Agencia agregada correctamente");
            limpiarCampos();
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar la agencia");
        }
    }

    private void modificarAgenciaSeguro() {
        int idAgencia = Integer.parseInt(txtIdAgencia.getText());
        String nombreAgencia = txtNombreAgencia.getText();
        String direccionPostal = txtDireccionPostal.getText();
        String telefono = txtTelefono.getText();
        String correoElectronico = txtCorreoElectronico.getText();
        int idTipoSeguro = Integer.parseInt(txtIdTipoSeguro.getText());
        String directorGeneral = txtDirectorGeneral.getText();
        String jefeDepartamentoSeguros = txtJefeDepartamentoSeguros.getText();
        String jefeDepartamentoReclamaciones = txtJefeDepartamentoReclamaciones.getText();

        AgenciaSeguro agenciaSeguro = new AgenciaSeguro(idAgencia, nombreAgencia, direccionPostal, telefono, correoElectronico, idTipoSeguro, directorGeneral, jefeDepartamentoSeguros, jefeDepartamentoReclamaciones);

        if (agenciaSeguroServices.modificarAgenciaSeguro(agenciaSeguro)) {
            JOptionPane.showMessageDialog(this, "Agencia modificada correctamente");
            limpiarCampos();
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar la agencia");
        }
    }

    private void eliminarAgenciaSeguro() {
        int idAgencia = Integer.parseInt(txtIdAgencia.getText());

        if (agenciaSeguroServices.eliminarAgenciaSeguro(idAgencia)) {
            JOptionPane.showMessageDialog(this, "Agencia eliminada correctamente");
            limpiarCampos();
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar la agencia");
        }
    }

    private void limpiarCampos() {
        txtIdAgencia.setText("");
        txtNombreAgencia.setText("");
        txtDireccionPostal.setText("");
        txtTelefono.setText("");
        txtCorreoElectronico.setText("");
        txtIdTipoSeguro.setText("");
        txtDirectorGeneral.setText("");
        txtJefeDepartamentoSeguros.setText("");
        txtJefeDepartamentoReclamaciones.setText("");
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0); // Limpia la tabla antes de cargar
        ArrayList<AgenciaSeguro> agencias = agenciaSeguroServices.consultarAgenciasSeguro();
        for (AgenciaSeguro agencia : agencias) {
            Object[] fila = {agencia.getIdAgencia(), agencia.getNombreAgencia(), agencia.getDireccionPostal(), 
                agencia.getTelefono(), agencia.getCorreoElectronico(), agencia.getIdTipoSeguro(), 
                agencia.getDirectorGeneral(), agencia.getJefeDepartamentoSeguros(), 
                agencia.getJefeDepartamentoReclamaciones()};
            modeloTabla.addRow(fila);
        }
    }
}

