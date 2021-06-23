package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import Modelo.ModeloCaja;
import Modelo.ModeloComprar;
import Modelo.ModeloEfectivo;
import Modelo.articulo;
import Vista.Caja;
import Vista.Comprar;
import Vista.Efectivo;
import Modelo.usuario;

public class ControladorEfectivo implements ActionListener, ChangeListener {

	Efectivo vista;
	ModeloEfectivo modelo;
	usuario usuario;
	String procedencia;
	ArrayList<articulo> articulos;
	
	
	public ControladorEfectivo(Efectivo vista, ModeloEfectivo modelo,usuario usuario,ArrayList<articulo> articulos, String pro)
	{
		this.vista= vista;
		this.modelo = modelo;
		this.usuario = usuario;
		this.procedencia=pro;
		this.articulos=articulos;
		this.modelo.recibirArticulos(articulos);
		this.modelo.conectar();
		this.vista.setVisible(true);
		this.vista.setResizable(false);
		this.vista.setLocationRelativeTo(null);
		this.vista.btnSalir.addActionListener(this);
		this.vista.spinBillete20.addChangeListener(this);
		this.vista.spinBillete50.addChangeListener(this);
		this.vista.spinBillete100.addChangeListener(this);
		this.vista.spinBillete200.addChangeListener(this);
		this.vista.spinBillete500.addChangeListener(this);
		this.vista.spinMoneda1.addChangeListener(this);
		this.vista.spinMoneda2.addChangeListener(this);
		this.vista.spinMoneda5.addChangeListener(this);
		this.vista.spinMoneda10.addChangeListener(this);
		this.vista.btnPagar.addActionListener(this);
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


	@Override
	public void stateChanged(ChangeEvent e) {
		int billete20 = 20 * Integer.parseInt(this.vista.spinBillete20.getModel().getValue().toString());
		int billete50 = 50 * Integer.parseInt(this.vista.spinBillete50.getModel().getValue().toString());
		int billete100 = 100 * Integer.parseInt(this.vista.spinBillete100.getModel().getValue().toString());
		int billete200 = 200 * Integer.parseInt(this.vista.spinBillete200.getModel().getValue().toString());
		int billete500 = 500 * Integer.parseInt(this.vista.spinBillete500.getModel().getValue().toString());
		int moneda1 = 1 * Integer.parseInt(this.vista.spinMoneda1.getModel().getValue().toString());
		int moneda2 = 2 *Integer.parseInt(this.vista.spinMoneda2.getModel().getValue().toString());
		int moneda5 = 5* Integer.parseInt(this.vista.spinMoneda5.getModel().getValue().toString());
		int moneda10 = 10* Integer.parseInt(this.vista.spinMoneda10.getModel().getValue().toString());
		int recibido = billete20 + billete50 + billete100 + billete200 + billete500 + moneda1
				+moneda2+moneda5+moneda10;
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		this.vista.txtAPagar.setText("" + df.format(this.modelo.total - recibido));
		float pagado = Float.parseFloat(this.vista.txtAPagar.getText());
		if(pagado <=0)
		{
			this.vista.txtCambio.setText("" + df.format((this.modelo.total - recibido)*(-1)));
			this.vista.txtAPagar.setText("" + df.format(0f));
		}
		else if(pagado >=0)
		{
			this.vista.txtCambio.setText("" + df.format(0f));
		}
		
	}


	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==this.vista.btnSalir)
	    {
			if(procedencia.equals("COMPRA")) {
				Comprar vista = new Comprar();
				ModeloComprar mod = new ModeloComprar();
				ControladorComprar ctrl = new ControladorComprar(vista, mod, usuario, articulos);
				
			}else {
				this.vista.dispose();
				Caja vista = new Caja();
				ModeloCaja modelo = new ModeloCaja();
				ControladorCaja con = new ControladorCaja( vista, modelo, usuario);
			}
	    }
		if(e.getSource()==this.vista.btnPagar)
		{
			float pagado = Float.parseFloat(this.vista.txtCambio.getText());
			float recibido = Float.parseFloat(this.vista.txtAPagar.getText());
			if(recibido <=0)
			{
				JOptionPane.showMessageDialog(null, "Se procesa la compra, cambio: " + pagado);
				if(procedencia.equals("COMPRA")) {
					this.modelo.insertarCompra(usuario);
				}else {
					this.modelo.insertarVenta(usuario);
				}
				this.vista.dispose();
				this.modelo.cerrarConexion();
				if(usuario.getIdUsuario()==1) {
					Caja vista = new Caja();
			    	ModeloCaja modelo = new ModeloCaja();
			    	ControladorCaja con = new ControladorCaja( vista, modelo, usuario);
				}else {
					if(procedencia.equals("COMPRA")) {
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
			else
			{
				JOptionPane.showMessageDialog(null, "Falta dinero");
			}
			
		}
		
		
	}
}
