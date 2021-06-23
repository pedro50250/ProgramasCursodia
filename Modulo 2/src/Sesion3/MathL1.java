package Sesion3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class MathL1 extends JFrame{

	JTextField nombre, pass;
	JButton entrar,salir;
	
	int[]pOrigen = new int[] {100,70};
	int[]lbSize = new int[] {120,30};
	int[]txtSize = new int[] {120,30};
	int[]btnSize = new int[] {120,30};
	int[]margen = new int[] {10,15};
	
	public static void main(String[]args)
	{
		MathL1 m1 = new MathL1();
		m1.crearGUI();
		m1.setSize(460,300);
		m1.setVisible(true);
		
	}
	
	public void crearGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container frame = this.getContentPane();
		frame.setLayout(null);
		this.setTitle("Login");
		
		//Crear los objetos
		JLabel titulo = new JLabel("Admin Login Form");
		JLabel lbnom = new JLabel("EnterName:");
		JLabel lbpass = new JLabel("Enter Password:");
		
		nombre = new JTextField(20);
		pass = new JTextField(20);
		
		entrar = new JButton("Login");
		salir = new JButton("Exit");
		
		//Posicionar Objetos
		int linea = pOrigen[1];
		
		lbnom.setBounds(pOrigen[0],pOrigen[1],lbSize[0],lbSize[1]);
		nombre.setBounds(pOrigen[0]+lbSize[0]+ margen[0], pOrigen[1],txtSize[0],txtSize[1]);
		
		linea += margen[1] + txtSize[1];
		
		lbpass.setBounds(pOrigen[0],linea,lbSize[0],lbSize[1]);
		pass.setBounds(pOrigen[0] + lbSize[0]+ margen[0],linea,txtSize[0],txtSize[1]);
		
		linea += margen[1] + txtSize[1];
		
		entrar.setBounds(pOrigen[0],linea,btnSize[0],btnSize[1]);
		salir.setBounds(pOrigen[0]+btnSize[0]+margen[0],linea,btnSize[0],btnSize[1]);
		
		//Agregar objetos al contenedor
		frame.add(lbnom);
		frame.add(nombre);
		frame.add(lbpass);
		frame.add(pass);
		frame.add(entrar);
		frame.add(salir);
	}
	
}
