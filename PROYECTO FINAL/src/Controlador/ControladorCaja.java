package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.articulo;

//import clases.articulo;
import Modelo.usuario;
import Modelo.ModeloCaja;
import Modelo.ModeloEfectivo;
import Modelo.ModeloLogin;
import Modelo.ModeloTarjeta;
import Vista.Caja;
import Vista.Efectivo;
import Vista.Login;
import Vista.MenuAdmin;
import Vista.Tarjeta; 

public class ControladorCaja implements ActionListener,KeyListener{

	Caja vista;
	ModeloCaja modelo;
	usuario usuario;
	public ControladorCaja(Caja vista, ModeloCaja modelo, usuario usuario) {
		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;
		this.vista.setVisible(true);
		this.vista.setResizable(false);
		this.vista.setLocationRelativeTo(null);
		this.modelo.conectar();
		this.modelo.leerArticulos();

		this.vista.btnSalir.addActionListener(this);
		this.vista.btnBuscar.addActionListener(this);
		this.vista.btnAgregar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnPagar.addActionListener(this);
		
		this.vista.txtCodigo.addKeyListener(this);

	}


	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.btnSalir) {
			if (JOptionPane.showConfirmDialog(null, "Seguro que quieres salir?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				this.vista.dispose();
				this.modelo.cerrarConexion();
				
				if(usuario.getIdUsuario()==1) {
					Login vista = new Login();
					ModeloLogin modelo = new ModeloLogin();
					ControladorLogin controlador;
					controlador = new ControladorLogin(vista,modelo);
				}else {
					vista.dispose();
			    	modelo.cerrarConexion();
			    	MenuAdmin vista = new MenuAdmin();
			    	ControladorMenuAdmin con = new ControladorMenuAdmin(vista,this.usuario);
				}
			} else {

			}
		}
		if (e.getSource() == this.vista.btnBuscar) {
			boolean error = true;
			String articuloBuscado = null;
			try {
				articuloBuscado = JOptionPane.showInputDialog("Ingrese el nombre del articulo");
				error = false;
			} catch (Exception e3) {
				JOptionPane.showMessageDialog(null, "Error en la captura del nombre del articulo");
			}
			if (error == false) {
				int cve_art = this.modelo.buscarArticulo(articuloBuscado);
				if (cve_art != 0) {
					this.vista.txtCodigo.setText("" + cve_art);
				} else {
					this.vista.txtCodigo.setText("");
				}
			}
		}
		if (e.getSource() == this.vista.btnAgregar)
		{
			boolean error = true;
			int cve_art = 0;

			try {
				cve_art = Integer.parseInt(this.vista.txtCodigo.getText());
				error = false;
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"Error en la captura del id, recuerda insertar solamente valores positivos enteros");
			}
			if (error == false) {
				if (this.modelo.existeArticulo(cve_art)) {
					int cantArt = Integer.parseInt(this.vista.spinner.getModel().getValue().toString());
					if (cantArt != 0) {
						if (this.modelo.existeInventario(cve_art, cantArt)) {
							this.modelo.agregarArticulo(cve_art, cantArt);
							rellenarJTable();
						} else {
							JOptionPane.showMessageDialog(null,
									"No es posible agregar el articulo porque no existe mas inventario");
						}
					}
				}
			}
		}
		
		if (e.getSource() == this.vista.btnEliminar) {
			boolean error = true;
			int cve_art = 0,cantArt=0;
			
			try {
				cve_art = Integer.parseInt(this.vista.txtCodigo.getText());
				cantArt = Integer.parseInt(this.vista.spinner.getModel().getValue().toString());
				error = false;
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"Error en la captura del id, recuerda insertar solamente valores positivos enteros");
			}
			if (error == false) {
				String accion = this.modelo.eliminarArticulo(cve_art, cantArt);
				if(accion.equals("realizada"))
				{
					rellenarJTable();
				}
			}
		}
		if(e.getSource()==this.vista.btnPagar)
		{
			String opcion = this.vista.comboBox.getSelectedItem().toString();
			if(this.modelo.articulosSelec != null)
			{
				if(!opcion.equals("Elige un Metodo de Pago"))
			{
				this.vista.dispose();
				this.modelo.cerrarConexion();
				if(opcion.equals("Efectivo"))
				{
					Efectivo vista = new Efectivo();
					ModeloEfectivo modelo = new ModeloEfectivo();
					ControladorEfectivo con = new ControladorEfectivo(vista, modelo, usuario, this.modelo.articulosSelec, "VENTA");
				}
				else if(opcion.equals("Tarjeta"))
				{
					Tarjeta vista = new Tarjeta();
					ModeloTarjeta modelo = new ModeloTarjeta();
					ControladorTarjeta con = new ControladorTarjeta(modelo,vista,this.usuario,this.modelo.articulosSelec, "VENTA");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Debes eligir un Metodo de Pago");
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error, debes agregar primero articulos antes de ir a pagar");
			}
			
		}
		

	}
	
	//metofo para rellenar la tabla con los articulos que se han ido agregando
	private void rellenarJTable() {
		float total = 0;
		//Se setea el numero de filas a 0 para agregar la actualizada
		((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
		//Ciclo for para recorrer todo el arraylist de articulos seleccionados que esta en el modelo
		//y agregarlos a la tabla, ademas se va calculando el total ya que en cada vuelta se le suma al total
		for (articulo art : this.modelo.articulosSelec) {
			model.addRow(new Object[] { "" + art.getCve_art(),"" + art.getNom_art(), "" + art.getPre_art(), "" + art.getInv_art() });
			total = total + (art.getPre_art() * art.getInv_art());
		}
		//Se muestra la cantidad a pagar en la vista con un formato
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		this.vista.txtAPagar.setText("" + df.format(total));
		this.vista.spinner.getModel().setValue(0);
		this.vista.txtCodigo.setText("");
	}


	@Override
	public void keyTyped(KeyEvent e) {
		char caracter = e.getKeyChar();
	      // Verificar si la tecla pulsada no es un digito
	      if(((caracter < '0') ||
	         (caracter > '9')) &&
	         (caracter != '\b' /*corresponde a BACK_SPACE*/))
	      {
	         e.consume();  // ignorar el evento de teclado
	      }
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
