package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import Modelo.ModeloCaja;
import Modelo.ModeloLogin;
import Modelo.usuario;
import Vista.Caja;
import Vista.Login;
import Vista.MenuAdmin; 

public class ControladorLogin implements ActionListener,MouseListener,KeyListener {
	
	Vista.Login vista;
	Modelo.ModeloLogin modelo;
	
	public ControladorLogin(Login vista, ModeloLogin modelo)
	{
		this.vista = vista;
		this.modelo = modelo;
		this.vista.setVisible(true);
		this.vista.setResizable(false);
		this.vista.setLocationRelativeTo(null);
		this.modelo.conectar();
		this.modelo.leerUsuarios();
		this.vista.txtUsuario.addMouseListener(this);
		this.vista.txtUsuario.addKeyListener(this);
		this.vista.txtPassword.addMouseListener(this);
		this.vista.txtPassword.addKeyListener(this);
		this.vista.btnIngresar.addActionListener(this);
	}


	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.vista.btnIngresar)
		{
			String usuario="";
			String password="";
			int nivUsuario=0,idUsuario=0;
			try
			{
				usuario = this.vista.txtUsuario.getText();
				password = this.vista.txtPassword.getText();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Error en la captura de los datos");
			}
			
			if(this.modelo.existeUsuario(usuario, password))
			{
				usuario usu = this.modelo.buscarUsuario(usuario, password);
				if(usu.getNivUsuario()==1)
				{
					JOptionPane.showMessageDialog(null, "　Bienvenido " + usuario + " a Vender!!" );
					this.modelo.cerrarConexion();
					this.vista.dispose();
					//LanzadorCaja caja = new LanzadorCaja(idUsuario);
					Caja vista = new Caja();
					ModeloCaja modelo = new ModeloCaja();
					ControladorCaja controlador = new ControladorCaja(vista,modelo,usu);
					
				}
				else if(usu.getNivUsuario()==2)
				{
				
					JOptionPane.showMessageDialog(null, "　Bienvenido " + usuario + " a Administar el negocio!!");
					this.modelo.cerrarConexion();
					this.vista.dispose();
					MenuAdmin vista = new MenuAdmin();
					ControladorMenuAdmin con = new ControladorMenuAdmin(vista,usu);
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error en las credenciales, intenta nuevamente");
			}			
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==this.vista.txtUsuario)
		{
			this.vista.txtUsuario.setText("");
		}
		if(e.getSource()==this.vista.txtPassword)
		{
			this.vista.txtPassword.setText("");
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public void keyPressed(KeyEvent e) {
		 if(e.getKeyCode()==KeyEvent.VK_ENTER){
			 String usuario="";
				String password="";
				int nivUsuario=0,idUsuario=0;
				try
				{
					usuario = this.vista.txtUsuario.getText();
					password = this.vista.txtPassword.getText();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Error en la captura de los datos");
				}
				
				if(this.modelo.existeUsuario(usuario, password))
				{
					usuario usu = this.modelo.buscarUsuario(usuario, password);
					if(usu.getNivUsuario()==1)
					{
						JOptionPane.showMessageDialog(null, "　Bienvenido " + usuario + " a Vender!!" );
						this.modelo.cerrarConexion();
						this.vista.dispose();
						//LanzadorCaja caja = new LanzadorCaja(idUsuario);
						Caja vista = new Caja();
						ModeloCaja modelo = new ModeloCaja();
						ControladorCaja controlador = new ControladorCaja(vista,modelo,usu);
						
					}
					else if(usu.getNivUsuario()==2)
					{
						JOptionPane.showMessageDialog(null, "　Bienvenido " + usuario + " a Administar el negocio!!");
						this.modelo.cerrarConexion();
						this.vista.dispose();
						MenuAdmin vista = new MenuAdmin();
						ControladorMenuAdmin con = new ControladorMenuAdmin(vista,usu);
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error en las credenciales, intenta nuevamente");
				}			
         }
         if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
             System.exit(0);
         }
		
	}

	

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	
}
