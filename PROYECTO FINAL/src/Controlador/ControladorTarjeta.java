package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.RoundingMode;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.ModeloCaja;
import Modelo.ModeloComprar;
import Modelo.ModeloTarjeta;
import Modelo.articulo;
import Vista.Caja;
import Vista.Comprar;
import Vista.Tarjeta;
import Modelo.usuario;

public class ControladorTarjeta implements ActionListener, KeyListener {

	ModeloTarjeta modelo;
	Tarjeta vista;
	usuario usuario;
	String proce;
	
	public ControladorTarjeta(ModeloTarjeta modelo,Tarjeta vista, usuario usuario,ArrayList<articulo> articulos, String proce)
	{
		this.vista= vista;
		this.modelo = modelo;
		this.usuario = usuario;
		this.proce=proce;
		this.modelo.recibirArticulos(articulos);
		this.modelo.conectar();
		this.vista.setVisible(true);
		this.vista.setResizable(false);
		this.vista.setLocationRelativeTo(null);
		
		this.vista.btnSalir.addActionListener(this);
		this.vista.btnPagar.addActionListener(this);
		this.vista.txtNumTarjeta.addKeyListener(this);
		this.vista.txtVencimiento.addKeyListener(this);
		this.vista.txtCCV.addKeyListener(this);
		rellenarJTable();
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		this.vista.txtAPagar.setText("" + df.format(this.modelo.total));
		
	}
	private void rellenarJTable() {
		((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
		for (articulo art : this.modelo.articulos) {
			model.addRow(new Object[] { "" + art.getCve_art(), "" + art.getNom_art(), "" + art.getPre_art()
			,"" + art.getInv_art()});
		}
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.vista.btnSalir)
	    {
	    	this.vista.dispose();
	    	Caja vista = new Caja();
	    	ModeloCaja modelo = new ModeloCaja();
	    	ControladorCaja con = new ControladorCaja( vista, modelo, usuario);
	    }
		if (e.getSource() == this.vista.btnPagar) {
			if (this.vista.txtNumTarjeta.getText().length() != 16) {
				JOptionPane.showMessageDialog(null, "Ingrese correctamente los 16 digitos de la tarjeta");
			} else {
				if (this.vista.txtVencimiento == null) {
					JOptionPane.showMessageDialog(null, "Ingrese la el mes y año de vencimiento");
				} else {
					if (this.vista.txtCCV.getText().length() != 3) {
						JOptionPane.showMessageDialog(null, "Ingrese los 3 digitos del codigo CCV");
					} else {
						if(proce.equals("COMPRA")) {
							this.modelo.insertarCompra(usuario);
						}else {
							this.modelo.insertarVenta(usuario);
						}
						
						JOptionPane.showMessageDialog(null, "Venta realizada");
						this.vista.dispose();
						this.modelo.cerrarConexion();

						if (usuario.getIdUsuario() == 1) {
							
							Caja vista = new Caja();
							ModeloCaja modelo = new ModeloCaja();
							ControladorCaja con = new ControladorCaja(vista, modelo, usuario);
						} else {
							if(proce.equals("COMPRA")) {
								Comprar vista= new Comprar();
								ModeloComprar mod = new ModeloComprar();
								ControladorComprar ctrl = new ControladorComprar(vista, mod, usuario, null);
							}else {
								Caja vista = new Caja();
						    	ModeloCaja modelo = new ModeloCaja();
						    	ControladorCaja con = new ControladorCaja( vista, modelo, usuario);
							}	
						}
					}
				}

			}
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		char caracter = e.getKeyChar();
		// Verificar si la tecla pulsada no es un digito
		if(e.getSource()==this.vista.txtNumTarjeta || e.getSource() == this.vista.txtCCV)
		{
			if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
			e.consume(); // ignorar el evento de teclado
		}
		}
		
		if (e.getSource() == this.vista.txtNumTarjeta) {
			if (this.vista.txtNumTarjeta.getText().length() == 16) {
				e.consume();
			}
		} 
		else if (this.vista.txtCCV.getText().length() == 3) 
		{
				e.consume();
		}
		else if(e.getSource() == this.vista.txtVencimiento)
		{
			if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' || caracter != '/' /* corresponde a BACK_SPACE */)) {
				e.consume(); // ignorar el evento de teclado
			}
			else if(this.vista.txtVencimiento.getText().length() ==7)
			{
				e.consume();
			}
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
