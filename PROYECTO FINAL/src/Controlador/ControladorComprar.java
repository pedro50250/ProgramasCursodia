package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.articulo;

//import clases.articulo;
import Modelo.usuario;
import Modelo.ModeloComprar;
import Modelo.ModeloEfectivo;
import Modelo.ModeloInventario;
import Modelo.ModeloTarjeta;
import Vista.Comprar;
import Vista.Efectivo;
import Vista.Inventario;
import Vista.MenuAdmin;
import Vista.Tarjeta; 

public class ControladorComprar implements ActionListener,KeyListener, MouseListener{

	Comprar vista;
	ModeloComprar modelo;
	usuario usuario;
	
	Inventario vistaInv;
	ModeloInventario modInv;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ControladorComprar(Comprar vista, ModeloComprar modelo, usuario usuario, ArrayList<articulo> lista) {
		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;
		this.modelo.articulosSelec=lista;
		
		vistaInv = new Inventario();
		modInv= new ModeloInventario();
		
		this.vista.setVisible(true);
		this.vista.setResizable(false);
		this.vista.setLocationRelativeTo(null);
		this.modelo.conectar();
		this.modelo.leerArticulos();
		
		this.vista.btnSalir.addActionListener(this);
		this.vista.btnInventario.addActionListener(this);
		this.vista.btnAgregar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnPagar.addActionListener(this);
		
		
		modInv.conectar();
		modInv.llenarListas();
		
		vistaInv.cbxProveedor.setModel(new DefaultComboBoxModel(modInv.comboProveedores()));
		modInv.llenarFiltros("Todos",0);
		llenarTablaInv();
		
		vistaInv.cbxExistencias.addActionListener(this);
		vistaInv.cbxProveedor.addActionListener(this);
		vistaInv.btnElegirProv.addActionListener(this);
		this.vista.tabla.addMouseListener(this);
		
		this.vista.txtCodigo.addKeyListener(this);
		
		if(this.modelo.articulosSelec!=null) {
			rellenarJTable();
		}
		

	}
	
	private void llenarTablaInv() {
		((DefaultTableModel) this.vistaInv.table.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vistaInv.table.getModel();
		for(articulo a: modInv.InventarioTabla) {
			model.addRow(new Object[] { ""+ a.getCve_art(),"" +a.getNom_art(),"" + a.getPre_art(), ""+a.getCat_art(),""+a.getIdprov_art(),""+a.getInv_art() });
		}
	}


	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.vista.btnSalir) {
			if (JOptionPane.showConfirmDialog(null, "Seguro que quieres salir?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				this.vista.dispose();
				this.modelo.cerrarConexion();
				
					vista.dispose();
					vistaInv.dispose();
			    	modelo.cerrarConexion();
			    	MenuAdmin vista = new MenuAdmin();
			    	ControladorMenuAdmin con = new ControladorMenuAdmin(vista,this.usuario);
				
			} else {

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
				int cantArt = Integer.parseInt(this.vista.spinner.getModel().getValue().toString());
				if (cantArt != 0) {
						this.modelo.agregarArticulo(cve_art, cantArt);
						rellenarJTable();
				}
				else {
					JOptionPane.showMessageDialog(null,"Cuantos articulos desea comprar?");
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
				if(this.modelo.DiferenteProveedor()==false) {
					if(!opcion.equals("Elige un Metodo de Pago"))
					{
						this.vista.dispose();
						this.modelo.cerrarConexion();
						if(opcion.equals("Efectivo"))
						{
							Efectivo vista = new Efectivo();
							ModeloEfectivo modelo = new ModeloEfectivo();
							ControladorEfectivo con = new ControladorEfectivo(vista, modelo, usuario, this.modelo.articulosSelec, "COMPRA");
							vistaInv.dispose();
						}else 
							if(opcion.equals("Tarjeta"))
							{
								Tarjeta vista = new Tarjeta();
								ModeloTarjeta modelo = new ModeloTarjeta();
								ControladorTarjeta con = new ControladorTarjeta(modelo, vista, this.usuario, this.modelo.articulosSelec, "COMPRA");
								vistaInv.dispose();
							}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Debes eligir un Metodo de Pago");
					}
				}else {
					JOptionPane.showMessageDialog(null, "No puedes hacer una misma compra a varios proveedores");
					
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error, debes agregar primero articulos antes de ir a pagar");
			}
			
		}else
		if(e.getSource()==vista.btnInventario) {
			
			vistaInv.setVisible(true);
			vistaInv.setResizable(false);
			vistaInv.setLocationRelativeTo(null);
			
			llenarTablaInv();
		}else
		if(e.getSource()==vistaInv.cbxProveedor || e.getSource()==vistaInv.cbxExistencias) {
			String prov = ""+vistaInv.cbxProveedor.getSelectedItem();
			int exis = vistaInv.cbxExistencias.getSelectedIndex();
			modInv.llenarFiltros(prov, exis);
			llenarTablaInv();
		}else
		if(e.getSource()==vistaInv.btnElegirProv) {
			int fila=vistaInv.table.getSelectedRow();
			int idArt = Integer.parseInt((String) vistaInv.table.getValueAt(fila, 0));
			System.out.println(idArt);
			if(idArt==-1) {
				JOptionPane.showMessageDialog(null, "Selecciona un articulo");
			}else {
				vista.txtCodigo.setText(""+idArt);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			int fila = vista.tabla.rowAtPoint(e.getPoint());
			int idArt = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0));
			
			if(idArt!=-1) {
				vista.txtCodigo.setText(""+idArt);
			}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
