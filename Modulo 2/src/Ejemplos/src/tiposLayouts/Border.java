package Ejemplos.src.tiposLayouts;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Border extends JFrame implements ActionListener
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
		Border sn = new Border();
		sn.crearGUI();
		sn.setSize(250,250);
		//sn.setResizable(false);
		sn.setVisible(true);
	}
	private void crearGUI()
	{
		JLabel num1, num2, res, titulo;
		// Definir Frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container frame = this.getContentPane();
		this.setTitle("Suma de 2 numeros");
		this.setBounds(200,200,250,250);
		// fin definir frame
		//Instaciar objetos
		//Instanciar etiquetas
			titulo = new JLabel("Suma de 2 numeros");
			titulo.setHorizontalAlignment(JLabel.CENTER); 
			num1 = new JLabel("Valor 1:");
			num1.setHorizontalAlignment(JLabel.CENTER); // Centrar Label
			num2 = new JLabel("Valor 2:");
			//num2.setHorizontalAlignment(JLabel.CENTER);
			res = new JLabel("Resultado:");
			res.setHorizontalAlignment(JLabel.CENTER);
		//Instaciar textfields
			v1 = new JTextField(15);
			v2 = new JTextField(15);
			r = new JTextField(15);
			r.setEditable(false);
		//Instanciar Botones
			sumar = new JButton("Sumar");
			sumar.setPreferredSize(new Dimension(50,50));
			sumar.addActionListener(this);
			borrar = new JButton("Borrar");
			borrar.addActionListener(this);
		//Introducir objetos al frame
			frame.add(titulo, BorderLayout.PAGE_START);
			frame.add(num1, BorderLayout.LINE_START);
			frame.add(v1, BorderLayout.CENTER);
			frame.add(num2, BorderLayout.LINE_END);
			frame.add(v2, BorderLayout.LINE_END);
			frame.add(sumar, BorderLayout.AFTER_LINE_ENDS);
			frame.add(res, BorderLayout.AFTER_LINE_ENDS);
			frame.add(r, BorderLayout.AFTER_LINE_ENDS);
			frame.add(borrar, BorderLayout.PAGE_END);
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
