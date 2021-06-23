package Controlador;

import java.awt.event.ActionEvent;
import Modelo.usuario;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.ModeloArticulos;
import Modelo.articulo;
import Vista.Articulos;
import Vista.MenuAdmin;

public class ControladorArticulos implements ActionListener {
	
	Articulos vista;
	ModeloArticulos modelo;
	usuario usuario;
	

	
	public ControladorArticulos(Articulos vista, ModeloArticulos modelo,usuario usuario)
	{
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
		this.vista.btnEditar.addActionListener(this);
		this.vista.comboBox.addActionListener(this);
		this.modelo.leerArticulos();
		 rellenarJTable();
		
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.btnAgregar) {
			try
			{
				String nom_art = JOptionPane.showInputDialog("Ingresa el nombre del articulo");
				float pre_art = Float.parseFloat(JOptionPane.showInputDialog("Ingresa el precio del articulo"));
				int cat_art = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de categoria del articulo"));
				int idprov_art = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de proveedor"));
				int inv_art=0;
				if(this.modelo.existeCategoria(cat_art) && this.modelo.existeProveedor(idprov_art))
				{
					this.modelo.agregarArticulo(nom_art, pre_art, cat_art, idprov_art, inv_art);
					 rellenarJTable();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Verifica bien los datos ingresados y el numero de categoria o el numero de proveedor");
				}
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, "Error en la captura de los datos");
			}
		}
		if (e.getSource() == this.vista.btnEliminar) {
			try {
				String nomArt = JOptionPane.showInputDialog("Ingresa el nombre del articulo a borrar");
				if(this.modelo.existeArticulo(nomArt))
				{
					this.modelo.eliminarArticulo(nomArt);
					 rellenarJTable();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El articulo no fue encontrado, ingresa correctamente el nombre");
				}
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, "Error en la captura de lso datos");
			}
			
		}
		if (e.getSource() == this.vista.btnBuscar) {
			try {
				String nomArt = JOptionPane.showInputDialog("Ingresa el nombre del articulo a buscar");
				articulo art = this.modelo.buscarArticulo(nomArt);
				if(art!= null)
				{
					rellenarJTableBuscado( art);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El articulo no fue encontrado, ingresa correctamente el nombre");
				}
			}catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, "Error en la captura de lso datos");
			}
			
		}
		if (e.getSource() == this.vista.comboBox) {
			String opcion = this.vista.comboBox.getSelectedItem().toString();
			if(opcion.equals("Default"))
			{
				rellenarJTable();
			}
			else
			{
				rellenarJTableComboBox(opcion);
			}
			
		}
	    if(e.getSource()==this.vista.btnEditar)
	    {
	    	try
	    	{
	    		String nombreArt = JOptionPane.showInputDialog("Ingrese el nombre del articulo a editar");
	    		if(this.modelo.existeArticulo(nombreArt))
	    		{
	    			float precioArt = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el nuevo precio del articulo: " + nombreArt));
	    			int invArt = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la nueva cantidad de inventario del articulo: "
	    					+ nombreArt));
	    			this.modelo.editarArticulo(nombreArt, precioArt, invArt);
	    			rellenarJTable();
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(null, "Error, ese articulo no existe, verifica correctamente el nombre del articulo");
	    		}
	    		
	    	}
	    	catch(Exception e20)
	    	{
	    		JOptionPane.showMessageDialog(null, "Error en la captura de los datos");
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
		this.modelo.leerArticulos();
		((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
		for (articulo art : this.modelo.articulos) {
			model.addRow(new Object[] { "" + art.getCve_art(), "" + art.getNom_art(), "" + art.getPre_art()
			,"" + art.getCat_art(), "" + art.getIdprov_art(),"" + art.getInv_art()});
		}
	}
	
	private void rellenarJTableBuscado(articulo art)
	{
		((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
			model.addRow(new Object[] { "" + art.getCve_art(), "" + art.getNom_art(), "" + art.getPre_art()
			,"" + art.getCat_art(), "" + art.getIdprov_art(),"" + art.getInv_art()});
	}
	
	private void rellenarJTableComboBox(String opcion) {
		if (opcion.equals("Inventario")) {
			this.modelo.ordenar(opcion);
			((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
			DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
			for (articulo art : this.modelo.inventario) {
				
				model.addRow(new Object[] { "" + art.getCve_art(), "" + art.getNom_art(), "" + art.getPre_art(),
						"" + art.getCat_art(), "" + art.getIdprov_art(),"" + art.getInv_art()});
			}
		} else if (opcion.equals("Categoria")) {
			this.modelo.ordenar(opcion);
			this.modelo.ordenar(opcion);
			((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
			DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
			for (articulo art : this.modelo.categoria) {
				
				model.addRow(new Object[] { "" + art.getCve_art(), "" + art.getNom_art(), "" + art.getPre_art(),
						"" + art.getCat_art(), "" + art.getIdprov_art(),"" + art.getInv_art()});
			}
		}
		else if(opcion.equals("Precio"))
		{
			this.modelo.ordenar(opcion);
			((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
			DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
			for (articulo art : this.modelo.precio) {
				
				model.addRow(new Object[] { "" + art.getCve_art(), "" + art.getNom_art(), "" + art.getPre_art(),
						"" + art.getCat_art(), "" + art.getIdprov_art(),"" + art.getInv_art()});
			}
		}
	}

}
