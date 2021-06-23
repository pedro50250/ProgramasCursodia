package Sesion2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ejemplo extends JFrame implements ActionListener{
	JButton saludar;
	JTextField txtNombre;

	public static void main(String [] args) 
	{
		Ejemplo eje = new Ejemplo();
		eje.crearGUI();
		eje.setSize(300,150);
		eje.setResizable(false);
		eje.setVisible(true);
		eje.setTitle("Login");
	}
	
	private void crearGUI()
	{
		//Especificacion o definicion del contenedor maximo
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container frame =  this.getContentPane();
		frame.setLayout(null);
		
		//Definicion o instanciacion de los objetos
		JLabel lblTitulo = new JLabel("Control de Acceso");
		JLabel lblSaludo = new JLabel("Saludo: ");
		
		txtNombre = new JTextField(15);
		saludar = new JButton("Saludo");
		
		//Modificar comportamiento de los objetos
		saludar.addActionListener(this);
		
		//Agregar la posicion de los objetos
		this.setBounds(800,400,250,250);
		lblTitulo.setBounds(80,10,110,20);
		lblSaludo.setBounds(40,40,50,20);
		txtNombre.setBounds(100,40,70,20);
		saludar.setBounds(80,70,100,20);
	
		//Agregat al contenedor
		frame.add(lblTitulo);
		frame.add(lblSaludo);
		frame.add(txtNombre);
		frame.add(saludar);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==saludar)
		{
			String nombre = txtNombre.getText();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			JOptionPane.showMessageDialog(null, "Hola " + nombre + " Ingresaste a las: " + dtf.format(now));
		}
	}
}
