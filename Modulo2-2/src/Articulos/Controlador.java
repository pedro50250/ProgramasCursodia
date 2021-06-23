package Articulos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controlador implements ActionListener {
	Vista_Principal vis;
	ArrayList<Articulo> articulos;
	Modelo mod;

	Controlador(Vista_Principal vis, Modelo mod) {
		this.mod = mod;
		this.vis = vis;
	}

	void Ejecutar() {
		lanzarVista();
		articulos = this.mod.obtenerArrays();
		imprimirTabla();
		this.vis.btnAgregar.addActionListener(this);
		this.vis.btnEditar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== this.vis.btnAgregar)
		{
			try
			{
				int cve = Integer.parseInt(this.vis.txtClave.getText());
			String nom = this.vis.txtNombre.getText();
			float pre = Float.parseFloat(this.vis.txtPrecio.getText());
			int cat = Integer.parseInt(this.vis.txtCategoria.getText());
			boolean existe = this.mod.escribirArchivo(cve, nom, pre, cat);
			if(existe==false)
			{
				articulos = this.mod.obtenerArrays();
				this.vis.model.setRowCount(0);
				imprimirTabla();
			}
			}			
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"Error en la captura de los datos");
			}
		}
		if(e.getSource()==this.vis.btnEditar)
		{
			int cve = Integer.parseInt(this.vis.txtClave.getText());
			String nom = this.vis.txtNombre.getText();
			float pre = Float.parseFloat(this.vis.txtPrecio.getText());
			int cat = Integer.parseInt(this.vis.txtCategoria.getText());
			boolean existe = this.mod.editarArchivo(articulos, cve, nom,pre,cat);
			if(existe==true)
			{
				articulos = this.mod.obtenerArrays();
				this.vis.model.setRowCount(0);
				imprimirTabla();
			}
		}
		
	}

	private void lanzarVista() {
		vis.crearGUI();
		vis.setSize(450, 450);
		vis.setVisible(true);

	}

	private void imprimirTabla() {
		for (int i = 0; i < articulos.size(); i++) {
			this.vis.model.addRow(new Object[] { "" + articulos.get(i).cve_art, articulos.get(i).nom_art,
					"" + articulos.get(i).pre_art, "" + articulos.get(i).cat_art });
		}
	}
}
