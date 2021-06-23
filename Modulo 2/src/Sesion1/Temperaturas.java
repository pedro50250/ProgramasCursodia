package Sesion1;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Temperaturas extends JFrame implements ActionListener{
	JButton calcular,borrar;
	JTextField txtC, txtK, txtF;
	boolean activo1 = true,activo2=true,activo3=true;
	int activos =3;
	int mensaje=1;

	public static void main(String[]args)
	{
		Temperaturas tem = new Temperaturas();
		tem.crearGUI();
		tem.setSize(400,300);
		tem.setResizable(false);
		tem.setVisible(true);
		tem.setTitle("Temperaturas");
	}
	
	private void crearGUI()
	{
		//Especificacion o definicion del contenedor maximo
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container frame = this.getContentPane();
		frame.setLayout(null);
		
		//Definicion o instanciacion de los objetos
		JLabel labt = new JLabel("Programa para calcular grados");
		JLabel labc = new JLabel("Ingresa los grados Celcius:");
		JLabel labk = new JLabel("Grados en Kelvin:");
		JLabel labf = new JLabel("Grados en Fahrenheit:");
		
		txtC = new JTextField(20);
		txtK = new JTextField(20);
		txtF = new JTextField(20);
		
		calcular = new JButton("Calcular");
		borrar = new JButton("Borrar");
		
		//Establecer Medidad
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = pantalla.height;
	    int width = pantalla.width;
	    this.setBounds((width/2)-200,(height/2)-150,0,0);
	    
		labt.setBounds(105, 11, 192, 19);
		labc.setBounds(23, 58, 157, 26);
		labk.setBounds(23, 115, 147, 26);
		labf.setBounds(23, 169, 175, 26);
		txtC.setBounds(208, 60, 127, 23);
		txtK.setBounds(208, 115, 127, 23);
		txtF.setBounds(208, 172, 127, 23);
		calcular.setBounds(92, 216, 89, 23);
		borrar.setBounds(218, 216, 89, 23);
		
		
		
		
		//Añadir al contenedor
		frame.add(labt);
		frame.add(labc);
		frame.add(txtC);
		frame.add(labk);
		frame.add(txtK);
		frame.add(labf);
		frame.add(txtF);
		frame.add(calcular);
		frame.add(borrar);
		
		//Modificar comportamiento de los objetos
		txtF.setEditable(true);
		txtK.setEditable(true);
		txtC.setEditable(true);
		calcular.addActionListener(this);
		borrar.addActionListener(this);
		txtF.setToolTipText("Escriba la temperatura en Fahrenheit");
		txtK.setToolTipText("Escriba la temperatura en Kelvin");
		txtC.setToolTipText("Escriba la temperatura en Celcius");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==calcular)
		{
			try 
			{
				
			
		    if(txtC.getText().isEmpty())
			{
				activos--;
				activo1=false;
			}
			if(txtF.getText().isEmpty())
			{
				activo3=false;
				activos--;
			}
			if(txtK.getText().isEmpty())
			{
				activo2=false;
				activos--;
			}
			int activo = activos;
			if(activo==1)
			{
			    if(activo1== true)
			    {
			    	double centigrados = Double.parseDouble(txtC.getText());
			    	double far = (centigrados * 1.8d) +32d;
					double kel = centigrados + 273.15d;
					txtF.setText("" + far);
					txtK.setText(""+ kel);
			    }
			    if(activo2== true)
			    {
				    double kel = Double.parseDouble(txtK.getText());
			    	 double far = (kel - 273.15d)*1.8d + 32d;
					 double  centigrados = kel - 273.15d;
					 txtF.setText("" + far);
					 txtC.setText(""+ centigrados);
			    }
			    if(activo3==true)
			    {
			    	double far = Double.parseDouble(txtF.getText());
			    	double centigrados = (far-32d) * (5d/9d);
			    	double kel = (far-32d) * (5d/9d) + 273.15d;
			    	txtC.setText("" + centigrados);
					txtK.setText(""+ kel);
			    }
			    txtF.setEditable(false);
				txtK.setEditable(false);
				txtC.setEditable(false);
				activo1=true;
				activo2=true;
				activo3=true;
				activos=3;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Error solamente un campo puede contener valores numericos");
				activos=3;
				activo1=true;
				activo2=true;
				activo3=true;
				activos=3;
			}	
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Error en el proceso de captura de datos, unicamente valores numericos");
				activo1=true;
				activo2=true;
				activo3=true;
				activos=3;
			}
		}
		else if(e.getSource()==borrar)
		{
			txtC.setText("");
			txtF.setText("");
			txtK.setText("");
			txtF.setEditable(true);
			txtK.setEditable(true);
			txtC.setEditable(true);
	   }
	}
	
}
