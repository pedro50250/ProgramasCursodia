package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import Modelo.ModeloVentas;
import Modelo.detalle_venta;
import Modelo.usuario;
import Modelo.venta;
import Vista.MenuAdmin;
import Vista.Ventas;

public class ControladorVentas implements ActionListener, MouseListener, KeyListener {
	Ventas vista;
	ModeloVentas mod;
	usuario usuario;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ControladorVentas(Ventas vista, ModeloVentas mod, usuario usuario) {
		this.vista=vista;
		this.mod=mod;
		this.usuario=usuario;
		
		this.vista.setVisible(true);
		this.vista.setResizable(false);
		this.vista.setLocationRelativeTo(null);
		
		this.mod.conectar();
		this.mod.fechaDeHoy();
		this.mod.llenarListas();
		this.vista.cbxUsuario.setModel(new DefaultComboBoxModel(mod.comboUsuarios()));
		llenarTabla();
		
		this.vista.cbxOrden.addActionListener(this);
		this.vista.cbxPrimary.addActionListener(this);
		this.vista.cbxRango.addActionListener(this);
		this.vista.cbxUsuario.addActionListener(this);
		this.vista.table.addMouseListener(this);
		this.vista.table.addKeyListener(this);
		this.vista.btnSalir.addActionListener(this);
		
	}

	private void llenarTabla() {
		mod.Consulta( "TODOS", 0, 0,0);
		((DefaultTableModel) this.vista.table.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.table.getModel();
		for(venta v: mod.Ventas) {
			int idUsu = v.getIdUsuario();
			model.addRow(new Object[] { ""+ v.getIdVenta(),mod.nomUsuario(idUsu),"" + v.getCantArt(), ""+v.getMonto(),""+v.getFecha() });
		}
	}
	
	private void llenarTablaDetalle() {
		((DefaultTableModel) this.vista.tableDetalle.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tableDetalle.getModel();
		for(detalle_venta dv: mod.DVentasTabla) {
			int idArt=dv.getIdArticulo();
			model.addRow(new Object[] { ""+ dv.getIdVenta(), mod.nomArticulo(idArt),"" + dv.getCantidad(),""+mod.preArticulo(idArt) });
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
		if(e.getSource()==vista.cbxUsuario || e.getSource()==vista.cbxOrden || e.getSource()==vista.cbxRango || e.getSource()==vista.cbxPrimary) {
			String nombre= ""+vista.cbxUsuario.getSelectedItem();
			int orden = vista.cbxOrden.getSelectedIndex();
			int rango = vista.cbxRango.getSelectedIndex();
			int key = vista.cbxPrimary.getSelectedIndex();
			
			mod.Consulta( nombre, orden, rango, key);
			
			((DefaultTableModel) this.vista.table.getModel()).setRowCount(0);
			DefaultTableModel model = (DefaultTableModel) this.vista.table.getModel();
			for(venta v: mod.Ventas) {
				int idUsu = v.getIdUsuario();
				model.addRow(new Object[] { ""+ v.getIdVenta(), mod.nomUsuario(idUsu) ,"" + v.getCantArt(), ""+v.getMonto(),""+v.getFecha() });
			}
		} 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int fila = vista.table.rowAtPoint(e.getPoint());
		int idventa = Integer.parseInt((String) vista.table.getValueAt(fila, 0));
		mod.llenarTablaDetalle(idventa);
		
		llenarTablaDetalle();

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_ENTER) {

			int fila=vista.table.getSelectedRow();
			int idventa = Integer.parseInt((String) vista.table.getValueAt(fila, 0));
			mod.llenarTablaDetalle(idventa);
			llenarTablaDetalle();
		} 
		
	}

}
