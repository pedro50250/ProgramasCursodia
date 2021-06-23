package Controlador;

import Vista.Articulos;
import Vista.Caja;
import Vista.Comprar;
import Vista.Compras;
import Vista.Corte;
import Vista.Login;
import Vista.MenuAdmin;
import Vista.Proveedores;
import Vista.Usuarios;
import Vista.Ventas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Modelo.Reloj;
import Modelo.ModeloArticulos;
import Modelo.ModeloCaja;
import Modelo.ModeloComprar;
import Modelo.ModeloCompras;
import Modelo.ModeloCorte;
import Modelo.ModeloLogin;
import Modelo.ModeloProveedores;
import Modelo.ModeloUsuarios;
import Modelo.ModeloVentas;
import Modelo.usuario;

public class ControladorMenuAdmin implements ActionListener{

	MenuAdmin vista;
	usuario usuario;
	Reloj clock;
	public ControladorMenuAdmin(MenuAdmin vista, usuario  usuario)
	{
		this.vista = vista;
		this.usuario = usuario;
		this.vista.setVisible(true);
		this.vista.setResizable(false);
		this.vista.setLocationRelativeTo(null);
		this.vista.btnSalir.addActionListener(this);
		this.vista.btnVender.addActionListener(this);
		this.vista.btnArticulos.addActionListener(this);
		this.vista.btnUsuarios.addActionListener(this);
		this.vista.btnProveedores.addActionListener(this);
		this.vista.btnVentas.addActionListener(this);
		this.vista.btnCompras.addActionListener(this);
		this.vista.btnCortes.addActionListener(this);
		this.vista.btnComprar.addActionListener(this);
		clock = new Reloj(vista);
		clock.start();
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.vista.btnSalir)
		{
			if (JOptionPane.showConfirmDialog(null, "Seguro que quieres salir?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				this.vista.dispose();
				Login vista = new Login();
				ModeloLogin modelo = new ModeloLogin();
				ControladorLogin controlador;
				controlador = new ControladorLogin(vista,modelo);
			} else {

			}
		}
		if(e.getSource()==this.vista.btnVender)
		{
			this.vista.dispose();
			Caja vista = new Caja();
			ModeloCaja modelo = new ModeloCaja();
			ControladorCaja controlador = new ControladorCaja(vista,modelo,this.usuario);
		}
		if(e.getSource()==this.vista.btnArticulos)
		{
			this.vista.dispose();
			Articulos vista = new Articulos();
			ModeloArticulos modelo = new ModeloArticulos();
			ControladorArticulos con = new ControladorArticulos(vista,modelo,this.usuario); 
		}
		if(e.getSource()==this.vista.btnUsuarios)
		{
			this.vista.dispose();
			Usuarios vista = new Usuarios();
			ModeloUsuarios modelo = new ModeloUsuarios();
			ControladorUsuarios con = new ControladorUsuarios(vista,modelo,this.usuario);
		}
		if(e.getSource()==this.vista.btnProveedores)
		{
			this.vista.dispose();
			Proveedores vista = new Proveedores();
			ModeloProveedores modelo = new ModeloProveedores();
			ControladorProveedores con = new ControladorProveedores(modelo,vista,this.usuario);
		}else
		if(e.getSource()==this.vista.btnVentas) 
		{
			this.vista.dispose();
			Ventas vista= new Ventas();
			ModeloVentas modelo = new ModeloVentas();
			ControladorVentas controlador = new ControladorVentas(vista, modelo ,this.usuario);
		} else
			
		if(e.getSource()==vista.btnCompras) {
			this.vista.dispose();
			Compras vista= new Compras();
			ModeloCompras modelo = new ModeloCompras();
			ControladorCompras controlador = new ControladorCompras(vista, modelo, this.usuario);
		} else
		
		if(e.getSource()==vista.btnCortes) {
				this.vista.dispose();
				Corte vista = new Corte();
				ModeloCorte modelo = new ModeloCorte();
				ControladorCorte controlador = new ControladorCorte(vista,modelo, this.usuario);
		}else
		if(e.getSource()==vista.btnComprar) {
			this.vista.dispose();
			Comprar vista= new Comprar();
			ModeloComprar modelo = new ModeloComprar();
			ControladorComprar controlador = new ControladorComprar(vista, modelo, this.usuario, null);
			
		}
		
		
	}
	
	
}
