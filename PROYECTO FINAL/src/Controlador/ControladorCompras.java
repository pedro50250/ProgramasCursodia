package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import Modelo.ModeloCompras;
import Modelo.compra;
import Modelo.detalle_compra;
import Modelo.usuario;
import Vista.Compras;
import Vista.MenuAdmin;

public class ControladorCompras implements ActionListener, MouseListener, KeyListener {
	Compras vista;
	ModeloCompras mod;
	usuario usuario;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ControladorCompras(Compras vista, ModeloCompras mod, usuario usuario) {
		this.vista=vista;
		this.mod=mod;
		this.usuario=usuario;
		
		this.vista.setVisible(true);
		this.vista.setResizable(false);
		this.vista.setLocationRelativeTo(null);
		
		mod.conectar();
		mod.fechaDeHoy();
		mod.llenarListas();
		vista.cbxUsuario.setModel(new DefaultComboBoxModel(mod.comboUsuarios()));
		llenarTabla();
	
		vista.cbxOrden.addActionListener(this);
		vista.cbxPrimary.addActionListener(this);
		vista.cbxRango.addActionListener(this);
		vista.cbxUsuario.addActionListener(this);
		vista.table.addMouseListener(this);
		vista.table.addKeyListener(this);
		vista.btnSalir.addActionListener(this);
		
	}
	
	private void llenarTabla() {
		mod.Consulta( "TODOS", 0, 0,0);
		((DefaultTableModel) this.vista.table.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.table.getModel();
		for(compra c: mod.Compras) {
			int idUsu = c.getIdUsu_com();
			int idProv = c.getIdProv_com();
			model.addRow(new Object[] { ""+ c.getId_com(), mod.nomProveedor(idProv) , mod.nomUsuario(idUsu), ""+c.getTot_com(),""+c.getFech_com() });
		}
	}
	
	private void llenarTablaDetalle() {
		((DefaultTableModel) this.vista.tableDetalle.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tableDetalle.getModel();
		for(detalle_compra dc: mod.DComprasTab) {
			int idArt =dc.getIdArt_detC();
			model.addRow(new Object[] { ""+ dc.getIdCom_detC(), mod.nomArticulo(idArt) ,"" + dc.getCant_detC(),""+mod.preArticulo(idArt)});
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
			for(compra c: mod.Compras) {
				int idUsu = c.getIdUsu_com();
				int idProv = c.getIdProv_com();
				model.addRow(new Object[] { ""+ c.getId_com(), mod.nomProveedor(idProv), mod.nomUsuario(idUsu), ""+c.getTot_com(),""+c.getFech_com() });
			}
		} 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int fila=vista.table.getSelectedRow();
		
		int idCompra = Integer.parseInt((String) vista.table.getValueAt(fila, 0));
        
		mod.llenarTablaDetalle(idCompra);

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
			int idCompra = Integer.parseInt((String) vista.table.getValueAt(fila, 0));
			mod.llenarTablaDetalle(idCompra);
			llenarTablaDetalle();
		} 
	}

}
