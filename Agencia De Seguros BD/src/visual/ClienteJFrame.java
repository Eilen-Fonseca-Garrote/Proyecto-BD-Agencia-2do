package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import services.ClienteServices;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class ClienteJFrame extends JFrame {

	private JTextField txtIdCliente;
	private JTextField txtSexo;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextField txtDireccionPostal;
	private JTextField txtTelefono;
	private JTextField txtCorreoElectronico;
	private JTextField txtPais;

	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnLimpiar;

	private JTable tablaCliente;
	private DefaultTableModel modeloTabla;

	private ClienteServices clienteServices;

	public ClienteJFrame() {
		super("Gestión de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 400);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Panel de Campos
		JPanel panelCampos = new JPanel(new GridLayout(9, 2, 10, 10));
		panelCampos.setBorder(BorderFactory
				.createTitledBorder("Datos del Cliente"));

		JLabel lblIdCliente = new JLabel("ID Cliente:");
		txtIdCliente = new JTextField();
		txtIdCliente.setEditable(false); // ID no editable
		panelCampos.add(lblIdCliente);
		panelCampos.add(txtIdCliente);

		JLabel lblSexo = new JLabel("Sexo:");
		txtSexo = new JTextField();
		panelCampos.add(lblSexo);
		panelCampos.add(txtSexo);

		JLabel lblNombre = new JLabel("Nombre:");
		txtNombre = new JTextField();
		panelCampos.add(lblNombre);
		panelCampos.add(txtNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		txtApellidos = new JTextField();
		panelCampos.add(lblApellidos);
		panelCampos.add(txtApellidos);

		JLabel lblEdad = new JLabel("Edad:");
		txtEdad = new JTextField();
		panelCampos.add(lblEdad);
		panelCampos.add(txtEdad);

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

		JLabel lblPais = new JLabel("País:");
		txtPais = new JTextField();
		panelCampos.add(lblPais);
		panelCampos.add(txtPais);

		// Panel de Botones
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnAgregar = new JButton("Agregar");
		btnModificar = new JButton("Modificar");
		btnEliminar = new JButton("Eliminar");
		btnLimpiar = new JButton("Limpiar");
		panelBotones.add(btnAgregar);
		panelBotones.add(btnModificar);
		panelBotones.add(btnEliminar);
		panelBotones.add(btnLimpiar);

		// Panel de la Tabla
		JPanel panelTabla = new JPanel(new BorderLayout());
		modeloTabla = new DefaultTableModel();
		modeloTabla.addColumn("ID Cliente");
		modeloTabla.addColumn("Sexo");
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Apellidos");
		modeloTabla.addColumn("Edad");
		modeloTabla.addColumn("Dirección Postal");
		modeloTabla.addColumn("Teléfono");
		modeloTabla.addColumn("Correo Electrónico");
		modeloTabla.addColumn("País");
		tablaCliente = new JTable(modeloTabla);
		JScrollPane scrollPane = new JScrollPane(tablaCliente);
		panelTabla.add(scrollPane, BorderLayout.CENTER);

		// Agrega los paneles al JFrame
		add(panelCampos, BorderLayout.NORTH); // Panel de campos arriba
		add(panelBotones, BorderLayout.CENTER); // Panel de botones en el centro
		add(panelTabla, BorderLayout.SOUTH); // Panel de la tabla abajo

		// Inicializa el servicio de la tabla
		clienteServices = new ClienteServices();

		// Agrega los listeners de los botones
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarCliente();
			}
		});

		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modificarCliente();
			}
		});

		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarCliente();
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

	private void agregarCliente() {
		char sexo = txtSexo.getText().charAt(0);
		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		int edad = Integer.parseInt(txtEdad.getText());
		String direccionPostal = txtDireccionPostal.getText();
		String telefono = txtTelefono.getText();
		String correoElectronico = txtCorreoElectronico.getText();
		String pais = txtPais.getText();

		Cliente cliente = new Cliente(0, sexo, nombre, apellidos, edad,
				direccionPostal, telefono, correoElectronico, pais);

		if (clienteServices.insertarCliente(cliente)) {
			JOptionPane.showMessageDialog(this,
					"Cliente agregado correctamente");
			limpiarCampos();
			cargarTabla();
		} else {
			JOptionPane.showMessageDialog(this, "Error al agregar el cliente");
		}
	}

	private void modificarCliente() {
		String idCliente = txtIdCliente.getText();
		char sexo = txtSexo.getText().charAt(0);
		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		int edad = Integer.parseInt(txtEdad.getText());
		String direccionPostal = txtDireccionPostal.getText();
		String telefono = txtTelefono.getText();
		String correoElectronico = txtCorreoElectronico.getText();
		String pais = txtPais.getText();

		Cliente cliente = new Cliente(idCliente, sexo, nombre, apellidos, edad,
				direccionPostal, telefono, correoElectronico, pais);

		if (clienteServices.modificarCliente(cliente)) {
			JOptionPane.showMessageDialog(this,
					"Cliente modificado correctamente");
			limpiarCampos();
			cargarTabla();
		} else {
			JOptionPane
					.showMessageDialog(this, "Error al modificar el cliente");
		}
	}

	private void eliminarCliente() {
		String idCliente = txtIdCliente.getText();

		if (clienteServices.eliminarCliente(idCliente)) {
			JOptionPane.showMessageDialog(this,
					"Cliente eliminado correctamente");
			limpiarCampos();
			cargarTabla();
		} else {
			JOptionPane.showMessageDialog(this, "Error al eliminar el cliente");
		}
	}

	private void limpiarCampos() {
		txtIdCliente.setText("");
		txtSexo.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtEdad.setText("");
		txtDireccionPostal.setText("");
		txtTelefono.setText("");
		txtCorreoElectronico.setText("");
		txtPais.setText("");
	}

	private void cargarTabla() {
		modeloTabla.setRowCount(0); // Limpia la tabla antes de cargar
		ArrayList<Cliente> clientes = clienteServices.consultarClientes();
		for (Cliente cliente : clientes) {
			Object[] fila = { cliente.getId(), cliente.getSexo(),
					cliente.getNombre(), cliente.getApellidos(),
					cliente.getEdad(), cliente.getDireccionPostal(),
					cliente.getTelefono(), cliente.getCorreoElectronico(),
					cliente.getPais() };
			modeloTabla.addRow(fila);
		}
	}
}
