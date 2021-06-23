package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.ModeloUsuarios;
import Modelo.usuario;
import Vista.MenuAdmin;
import Vista.Usuarios;

public class ControladorUsuarios implements ActionListener {

	Usuarios vista;
	ModeloUsuarios modelo;
	usuario usuario;

	public ControladorUsuarios(Usuarios vista, ModeloUsuarios modelo,usuario usuario) {
		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;
		this.vista.setVisible(true);
		this.vista.setResizable(false);
		this.vista.setLocationRelativeTo(null);
		this.modelo.conectar();
		this.vista.btnAgregar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnSalir.addActionListener(this);
		this.vista.comboBox.addActionListener(this);
		this.modelo.leerUsuarios();
		this.rellenarJTable();

	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.btnAgregar) {
			try {
				String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre de Usuario");
				String password = JOptionPane.showInputDialog("Ingrese la contraseña");
				int nivel = Integer.parseInt(JOptionPane
						.showInputDialog("Ingrese el nivel de usuario (1 o 2) : 1.-Vendedor  2.-Administrador"));
				if (this.modelo.existeUsuario(nombreUsuario, password)) {
					JOptionPane.showMessageDialog(null, "Ya existe un usuario con esas credenciales");
				} else {
					this.modelo.agregarUsuario(nombreUsuario, password, nivel);
					JOptionPane.showMessageDialog(null, "Se agrego correctamente.");
					this.rellenarJTable();
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error en la captura de los datos!");
			}
		}
		if (e.getSource() == this.vista.btnEliminar) {
			try {
				String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre de Usuario");
				String password = JOptionPane.showInputDialog("Ingrese la contraseña");
				if (this.modelo.existeUsuario(nombreUsuario, password)) {
					this.modelo.eliminarUsuario(nombreUsuario, password);
					JOptionPane.showMessageDialog(null, "Se elimino correctamente.");
					this.rellenarJTable();
				} else {
					JOptionPane.showMessageDialog(null, "No existe un usuario con esas credenciales");
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error en la captura de los datos!");
			}
		}
		if (e.getSource() == this.vista.btnBuscar) {
			try {
				String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre de Usuario");
				usuario usuario = this.modelo.buscarUsuario(nombreUsuario);
				if (usuario != null) {
					rellenarJTableBuscado(usuario);
				} else {
					JOptionPane.showMessageDialog(null, "No existe un usuario con ese nombre");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error en la captura de los datos!");
			}
		}
		if (e.getSource() == this.vista.comboBox) {
			String opcion = this.vista.comboBox.getSelectedItem().toString();
			if (opcion.equals("Default")) {
				rellenarJTable();
			} else if (opcion.equals("Vendedores")) {
				rellenarJTableVendedores();
			} else if (opcion.equals("Administradores")) {
				rellenarJTableAdministradores();
			} else if (opcion.equals("Ventas") || opcion.equals("Compras")) {
				rellenarJTableVenOCom(opcion);
			}
		}
		 if(e.getSource()==this.vista.btnSalir)
		    {
		    	this.vista.dispose();
		    	this.modelo.cerrarConexion();
		    	MenuAdmin vista = new MenuAdmin();
		    	ControladorMenuAdmin con = new ControladorMenuAdmin(vista,this.usuario);
		    }

	}

	private void rellenarJTable() {
		this.modelo.leerUsuarios();
		((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
		String nivel;
		for (usuario usu : this.modelo.usuarios) {
			if (usu.getNivUsuario() == 1) {
				nivel = "Vendedor";
			} else {
				nivel = "Administador";
			}
			model.addRow(new Object[] { "" + usu.getIdUsuario(), "" + usu.getUsuario(), "" + usu.getContraseña(),
					"" + usu.getNumVentas(), "" + usu.getNumCompras(), nivel });
		}
	}

	private void rellenarJTableBuscado(usuario usu) {
		((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
		String nivel;
		if (usu.getNivUsuario() == 1) {
			nivel = "Vendedor";
		} else {
			nivel = "Administador";
		}
		model.addRow(new Object[] { "" + usu.getIdUsuario(), "" + usu.getUsuario(), "" + usu.getContraseña(),
				"" + usu.getNumVentas(), "" + usu.getNumCompras(), nivel });

	}

	private void rellenarJTableVendedores() {
		this.modelo.buscarVendedores();
		((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
		String nivel;
		for (usuario usu : this.modelo.vendedores) {
			if (usu.getNivUsuario() == 1) {
				nivel = "Vendedor";
			} else {
				nivel = "Administador";
			}
			model.addRow(new Object[] { "" + usu.getIdUsuario(), "" + usu.getUsuario(), "" + usu.getContraseña(),
					"" + usu.getNumVentas(), "" + usu.getNumCompras(), nivel });
		}
	}

	private void rellenarJTableAdministradores() {
		this.modelo.buscarAdministradores();
		((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
		String nivel;
		for (usuario usu : this.modelo.administradores) {
			if (usu.getNivUsuario() == 1) {
				nivel = "Vendedor";
			} else {
				nivel = "Administador";
			}
			model.addRow(new Object[] { "" + usu.getIdUsuario(), "" + usu.getUsuario(), "" + usu.getContraseña(),
					"" + usu.getNumVentas(), "" + usu.getNumCompras(), nivel });
		}
	}

	private void rellenarJTableVenOCom(String opcion) {
		if (opcion.equals("Ventas")) {
			this.modelo.ordenar(opcion);
			((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
			DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
			String nivel;
			for (usuario usu : this.modelo.numVentas) {
				if (usu.getNivUsuario() == 1) {
					nivel = "Vendedor";
				} else {
					nivel = "Administador";
				}
				model.addRow(new Object[] { "" + usu.getIdUsuario(), "" + usu.getUsuario(), "" + usu.getContraseña(),
						"" + usu.getNumVentas(), "" + usu.getNumCompras(), nivel });
			}
		} else if (opcion.equals("Compras")) {
			this.modelo.ordenar(opcion);
			((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
			DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
			String nivel;
			for (usuario usu : this.modelo.numCompras) {
				if (usu.getNivUsuario() == 1) {
					nivel = "Vendedor";
				} else {
					nivel = "Administador";
				}
				model.addRow(new Object[] { "" + usu.getIdUsuario(), "" + usu.getUsuario(), "" + usu.getContraseña(),
						"" + usu.getNumVentas(), "" + usu.getNumCompras(), nivel });
			}
		}
	}
}
