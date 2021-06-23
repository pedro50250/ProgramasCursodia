package Servidor;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Timestamp;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;


public class ControladorChat implements ActionListener,KeyListener{
	VistaChat vista;
	ModeloChat modelo;

	
	
	public ControladorChat(VistaChat vista, ModeloChat modelo)
	{
		
		this.vista= vista;
		this.modelo = modelo;
		
		this.vista.setVisible(true);
		this.vista.setResizable(false);
		this.vista.setLocationRelativeTo(null);
		this.vista.btnEnviarMensaje.addActionListener(this);
		this.vista.txtMensaje.addKeyListener(this);
		this.vista.btnOnOff.addActionListener(this);
		
		while(true)
		{
			this.modelo.levantarServer(modelo);
			if(this.modelo.Mensaje==true)
			{
				this.rellenarJTable();
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				String time = timestamp.toString();
				String mensajeRecibido = this.modelo.mensajeNuevo;
				this.appendToPane(time, Color.LIGHT_GRAY);
				this.appendToPane("" + this.modelo.nomUsuario, Color.BLUE);
				this.appendToPane(" "+mensajeRecibido + "\n", Color.GREEN);
				this.modelo.ReproducirSonidoRecibir();
				this.modelo.Mensaje = false;
			}
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.vista.btnEnviarMensaje)
		{
			String mensaje = this.vista.txtMensaje.getText();
			if(mensaje == null || mensaje.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Debes escribir algo para enviar");
			}
			else 
			{
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				String time = timestamp.toString();
				this.modelo.enviarMensajes(mensaje);
				this.appendToPane(time, Color.LIGHT_GRAY);
				this.appendToPane(" Yo:", Color.GREEN);
				this.appendToPane(" "+mensaje + "\n", Color.BLACK);
				this.modelo.ReproducirSonidoEnviar();
				this.vista.txtMensaje.setText("");
			}
		}
		if(e.getSource()==this.vista.btnOnOff)
		{
			if(this.modelo.usuarioConectado==false)
			{
				this.appendToPane("Esperando Conexion \n", Color.RED);
				this.pedirNombre();
				this.metodosServidor();
				this.aņadirUsuarioTabla();
				this.vista.btnOnOff.setForeground(Color.GREEN);
				this.vista.btnOnOff.setBackground(Color.GREEN);
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				String time = timestamp.toString();
				this.appendToPane(time, Color.LIGHT_GRAY);
				this.appendToPane("Conexion Exitosa con: " + this.modelo.nomUsuario + " Se conecto desde la IP: " +this.modelo.ipRemota
						+ "\n", Color.GREEN);
			}
			else
			{
				this.cerrarConexion();
				this.vista.btnOnOff.setForeground(Color.RED);
				this.vista.btnOnOff.setBackground(Color.RED);
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				String time = timestamp.toString();
				this.appendToPane(time, Color.LIGHT_GRAY);
				this.appendToPane(" Conexion Perdida" + "\n", Color.RED);
			}
		}
	
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
	}


	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getSource()==this.vista.txtMensaje)
		{
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				String mensaje = this.vista.txtMensaje.getText();
				if(mensaje == null || mensaje.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Debes escribir algo para enviar");
				}
				else 
				{
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					String time = timestamp.toString();
					this.modelo.enviarMensajes(mensaje);
					this.appendToPane(time, Color.LIGHT_GRAY);
					this.appendToPane(" Yo:", Color.GRAY);
					this.appendToPane(" "+mensaje + "\n", Color.BLACK);
					this.modelo.ReproducirSonidoEnviar();
					this.vista.txtMensaje.setText("");
				}
			}
		}
		
		

	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void metodosServidor()
	{
		this.modelo.levantarServer(this.modelo);
	}
	
	private void aņadirUsuarioTabla()
	{
		
		((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
		model.addRow(new Object[] { "" + this.modelo.nomUsuario});
	}

	private void appendToPane(String msg, Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = this.vista.txtAreaMensajes.getDocument().getLength();
        this.vista.txtAreaMensajes.setCaretPosition(len);
        this.vista.txtAreaMensajes.setCharacterAttributes(aset, false);
        this.vista.txtAreaMensajes.replaceSelection(msg);
    }
	
	private void cerrarConexion()
	{
		this.modelo.cerrarHilo();
		((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
		
	}
	
	private void pedirNombre()
	{
		String nombre = JOptionPane.showInputDialog("Ingrese tu nombre de usuario");
		this.modelo.nombre=nombre;
	}
	
	private void rellenarJTable() {
		((DefaultTableModel) this.vista.tabla.getModel()).setRowCount(0);
		DefaultTableModel model = (DefaultTableModel) this.vista.tabla.getModel();
		for (Cliente cli : this.modelo.clientes) {
			model.addRow(new Object[] { "" + cli.getNomCliente()});
		}
	}
	
	
}
