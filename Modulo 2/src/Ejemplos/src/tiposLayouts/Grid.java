package Ejemplos.src.tiposLayouts;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Grid extends JFrame implements ActionListener
{
	JTextField v1, v2, r;
	JButton sumar, borrar;
	/**
	 * 
	 * 0.1
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) 
	{	
		Grid sn = new Grid();
		sn.crearGUI();
		sn.setSize(250,250);
		sn.setResizable(false);
		sn.setVisible(true);
	}
	private void crearGUI()
	{
		JLabel num1, num2, res;
		// Definir Frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container frame = this.getContentPane();
		frame.setLayout(new GridLayout(5,2));
		this.setTitle("Suma de 2 numeros");
		this.setBounds(200,200,250,250);
		// fin definir frame
		//Instaciar objetos
		//Instanciar etiquetas
			num1 = new JLabel("Valor 1:");
			num1.setHorizontalAlignment(JLabel.CENTER); // Centrar Label
			num2 = new JLabel("Valor 2:");
			num2.setHorizontalAlignment(JLabel.CENTER);
			res = new JLabel("Resultado:");
			res.setHorizontalAlignment(JLabel.CENTER);
		//Instaciar textfields
			v1 = new JTextField(15);
			v1.setHorizontalAlignment(JTextField.CENTER);
			v2 = new JTextField(15);
			v2.setHorizontalAlignment(JTextField.CENTER);
			r = new JTextField(15);
			r.setHorizontalAlignment(JTextField.CENTER);
			r.setEditable(false);
		//Instanciar Botones
			sumar = new JButton("Sumar");
			sumar.addActionListener(this);
			borrar = new JButton("Borrar");
			borrar.addActionListener(this);
		//Introducir objetos al frame
			frame.add(num1);
			frame.add(v1);
			frame.add(num2);
			frame.add(v2);
			frame.add(res);
			frame.add(r);
			frame.add(new JLabel(""));
			frame.add(sumar);
			frame.add(new JLabel(""));
			frame.add(borrar);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource()== sumar)
		{
			r.setText(""+(Integer.parseInt(v1.getText())+Integer.parseInt(v2.getText())));
		}
		if(arg0.getSource()==borrar)
		{
			v1.setText("");
			v2.setText("");
			r.setText("");
		}
	}

}
