package Ejemplos.src.panels;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class EjemploPanels extends JFrame
{
	JButton btn1, btn2;
	JTextField txt1, txt2;
	JCheckBox chk1, chk2;
	JPanel pn1,pn2;
	
	public static void main(String[] args)
	{
		EjemploPanels ej = new EjemploPanels();
		ej.setSize(800,600);
		ej.crearGUI();
		ej.setVisible(true);
	}
	private void crearGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Ejemplo con Panels");
		Container frame = this.getContentPane();
		frame.setLayout(null);
		
		//Instanciar Objetos
		pn1 = new JPanel(new FlowLayout());
		pn2 = new JPanel(new FlowLayout());
		
		pn1.setBackground(Color.white);
		
		btn1 = new JButton("Boton 1");
		btn2 = new JButton("Boton 2");
		
		txt1 = new JTextField(20);
		txt2 = new JTextField(20);
		
		chk1 = new JCheckBox();
		chk2 = new JCheckBox();
		//Posicionar Objetos
		
		pn1.setBounds(10,20,760,250);
		pn2.setBounds(10,290,760,250);
		
		pn1.add(btn1);
		pn1.add(txt1);
		pn1.add(chk1);
		pn2.add(btn2);
		pn2.add(txt2);
		pn2.add(chk2);
		
		//Modificar Objetos
		Border lineanegra = BorderFactory.createLineBorder(Color.black);
		Border levantado = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		pn1.setBorder(lineanegra);
		pn2.setBorder(levantado);
		
		//TitledBorder Titulo;
		//Titulo = BorderFactory.createTitledBorder("Seccion 1");
		//pn1.setBorder(Titulo);
		
		TitledBorder Titulo2;
		Titulo2 = BorderFactory.createTitledBorder("Panel de control");
		pn2.setBorder(Titulo2);
		
		//Agregar al frame
		frame.add(pn1);
		frame.add(pn2);
	}
}
