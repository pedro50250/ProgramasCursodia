package Sesion3;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MathL2 extends JFrame{

	Container frame = this.getContentPane();
	ArrayList<ArrayList<Objeto>> GUI = new ArrayList<ArrayList<Objeto>>();
	int[] pOrigen = new int[]{50,70};
	int[] lbSize = new int[]{300,30};
	int[] txtSize = new int[]{300,30};
	int[] margen = new int[]{20,5};
	
	public static void main(String[]args)
	{
		MathL2 m2 = new MathL2();
		m2.crearGUI();
		m2.setSize(770,405);
		m2.setResizable(false);
		m2.setVisible(true);
	}
	
	private void crearGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(null);
		this.setTitle("Formulario");
		
	}
	
	private ArrayList<Objeto> linea1()
	{
		Objeto linea = new Objeto(0,0,lbSize[0],lbSize[1],new JLabel(""),"label");
		
		return null;
		
	}
}
