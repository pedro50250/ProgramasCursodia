package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.ModeloProveedores;
import Modelo.proveedor;
import Vista.MenuAdmin;
import Vista.Proveedores;
import Modelo.usuario;

public class ControladorProveedores implements ActionListener{

	ModeloProveedores modelo;
	Proveedores vista;
	usuario usuario;
	
	public ControladorProveedores(ModeloProveedores modelo, Proveedores vista, usuario usuario)
	{
		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;
		
		this.usuario = usuario;
		this.modelo.conectar();
		this.vista.setVisible(true);
		this.vista.setResizable(false);
		this.vista.setLocationRelativeTo(null);
		this.vista.btnSalir.addActionListener(this);
		this.vista.btnAgregar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnRestablecer.addActionListener(this);
		this.vista.btnEditar.addActionListener(this);
		 rellenarJTable();
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.vista.btnSalir)
		{
			this.vista.dispose();
	    	this.modelo.cerrarConexion();
	    	MenuAdmin vista = new MenuAdmin();
	    	ControladorMenuAdmin con = new ControladorMenuAdmin(vista,this.usuario);
		}
		if(e.getSource()==this.vista.btnAgregar)
		{
			try
			{
				String nomProv = JOptionPane.showInputDialog("Ingresa el nombre del proveedor");
				if(this.modelo.existeProveedor(nomProv)==false)
				{
					String telefono = JOptionPane.showInputDialog("Ingresa el telefono del proveedor");
					if(this.modelo.esNumero(telefono))
					{
						String direccion = JOptionPane.showInputDialog("Ingresa la direccion del proveedor");
						String email = JOptionPane.showInputDialog("Ingresa el email del proveedor");
						this.modelo.insertarProveedor(nomProv, telefono, direccion, email);
						 rellenarJTable();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error, debes proporcionar un numero valido");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error, ya existe un proveedor con ese nombre");
				}
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, "Error en la captura de los datos");
			}
		}
		if(e.getSource()==this.vista.btnEliminar)
		{
			try
			{
				String nomProv = JOptionPane.showInputDialog("Ingresa el nombre del proveedor");
				if(this.modelo.existeProveedor(nomProv))
				{
					this.modelo.eliminarProveedor(nomProv);
					rellenarJTable();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error, no  existe un proveedor con ese nombre");
				}
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, "Error en la captura de los datos");
			}
		}
		if(e.getSource()==this.vista.btnBuscar)
		{
			try
			{
				String nomProv = JOptionPane.showInputDialog("Ingresa el nombre del proveedor");
				if(this.modelo.existeProveedor(nomProv))
				{
					proveedor prov = this.modelo.buscarProveedor(nomProv);
					rellenarJTable(prov);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error, no  existe un proveedor con ese nombre");
				}
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, "Error en la captura de los datos");
			}
		}
		if(e.getSource()==this.vista.btnRestablecer)
		{
			rellenarJTable();
		}
		if(e.getSource()==this.vista.btnEditar)
		{
			try
			{
				String nomProv = JOptionPane.showInputDialog("Ingresa el nombre del proveedor");
				if(this.modelo.existeProveedor(nomProv))
				{
					String telefono = JOptionPane.showInputDialog("Ingresa el nuevo telefono del proveedor");
					if(this.modelo.esNumero(telefono))
					{
						String direccion = JOptionPane.showInputDialog("Ingresa la nueva direccion del proveedor");
						String email = JOptionPane.showInputDialog("Ingresa el nuevo email del proveedor");
						this.modelo.editarProvedor(nomProv, telefono, direccion, email);
						 rellenarJTable();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Error, debes proporcionar un numero valido");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error, ya existe un proveedor con ese nombre");
				}
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, "Error en la captura de los datos");
			}
		}
		
	}
	
	
	private void rellenarJTable() {
		this.modelo.leerProveedores();
		((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
		for (proveedor prov : this.modelo.proveedores) {
			
			model.addRow(new Object[] { ""+ prov.getId_prov(),"" + prov.getNom_prov(),"" + prov.getTel_prov(),  "" + prov.getDir_prov()
			,"" + prov.getEmail_prov()});
		}
	}
	

	private void rellenarJTable(proveedor prov) {
		((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
			model.addRow(new Object[] { ""+ prov.getId_prov(),"" + prov.getNom_prov(),"" + prov.getTel_prov(),  "" + prov.getDir_prov()
			,"" + prov.getEmail_prov()});
		
	}
	
	
	
	
}
