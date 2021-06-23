package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.table.DefaultTableModel;

import Modelo.ModeloCompras;
import Modelo.ModeloCorte;
import Modelo.ModeloVentas;
import Modelo.compra;
import Vista.Compras;
import Vista.Corte;
import Vista.MenuAdmin;
import Vista.Ventas;
import Modelo.usuario;
import Modelo.venta;

public class ControladorCorte implements ActionListener {
	Corte vista;
	ModeloCorte mod;
	usuario usuario;
	
	
	public ControladorCorte(Corte vista, ModeloCorte mod, usuario usuario) {
		this.vista=vista;
		this.mod=mod;
		this.usuario=usuario;
		
		this.vista.setVisible(true);
		this.vista.setResizable(false);
		this.vista.setLocationRelativeTo(null);
		
		mod.conectar();
		
		
		
		vista.lblTitulo.setText("Corte del Dia: "+mod.fechaDeHoy());
		
		llenarTablaCompras();
		llenarTablaVentas();
		
		vista.txtEgresos.setText(""+mod.Egresos());
		vista.txtIngresos.setText(""+mod.Ingresos());
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		
		vista.txtUtilidades.setText(""+df.format(mod.Utilidades()));
		
		vista.btnSalir.addActionListener(this);
		vista.btnCompras.addActionListener(this);
		vista.btnVentas.addActionListener(this);
		vista.btnCorte.addActionListener(this);
		

		
		
	}
	
	private void llenarTablaCompras() {
		mod.llenarCompras();
		((DefaultTableModel) this.vista.tableCompras.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tableCompras.getModel();
		for (compra c : mod.Compras) {
			String[]fechaHora=c.getFech_com().split(" ");
			String hora=fechaHora[1];
			model.addRow(new Object[] { ""+ c.getId_com(),"" + c.getTot_com(),"" + hora });
		}
	}
	private void llenarTablaVentas() {
		mod.llenarVentas();
		((DefaultTableModel) this.vista.tableVentas.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tableVentas.getModel();
		for (venta v : mod.Ventas) {
			String[]fechaHora= v.getFecha().split(" ");
			String hora= fechaHora[1];
			model.addRow(new Object[] { ""+ v.getIdVenta(),"" + v.getMonto(),"" + hora });
		}
	}


	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vista.btnSalir) {
			vista.dispose();
	    	mod.cerrarConexion();
	    	MenuAdmin vista = new MenuAdmin();
	    	@SuppressWarnings("unused")
			ControladorMenuAdmin con = new ControladorMenuAdmin(vista,this.usuario);
		} else
		
		if(e.getSource()==vista.btnCorte) {
			mod.RealizarCorte(usuario);
		} else
			
		if(e.getSource()==vista.btnVentas) {
			this.vista.dispose();
			Ventas vista= new Ventas();
			ModeloVentas modelo = new ModeloVentas();
			@SuppressWarnings("unused")
			ControladorVentas controlador = new ControladorVentas(vista, modelo ,this.usuario);
			
		}else
			
		if(e.getSource()==vista.btnCompras) {
			this.vista.dispose();
			Compras vista= new Compras();
			ModeloCompras modelo = new ModeloCompras();
			@SuppressWarnings("unused")
			ControladorCompras controlador = new ControladorCompras(vista, modelo, this.usuario);
			
		}
	}
}
