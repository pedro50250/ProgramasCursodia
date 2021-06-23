package application;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;

public class VistaPrincipal extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Version 1.0  23/05/2020
	 * Ejemplo Modelo-Vista-Controlador
	 * Creado por: Dr. Carlos Adrian Perez Cortez
	 * Para: Cursodia Diplomado Java 14
	 */
	private JPanel contentPane;
	JTextField txtDisplay;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
	btnMult, btnSum, btnDiv, btnRes, btnDot, btnChSim, btnCE, btnC, btnIgual, btnDel;
	boolean finish = false;

	/**
	 * Launch the application.
	 */
	public void lanzarVista()
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					crearGUI();
					setVisible(true);
					setResizable(false);
					finish = true;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void crearGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaPrincipal.class.getResource("/images/Ico.PNG")));
		UIManager.put("TextField.inactiveBackground",Color.white);
		setTitle("Xtreme Gaming Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 786);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDisplay = new JTextField();
		txtDisplay.setEditable(false);
		txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDisplay.setFont(new Font("Arial Narrow", Font.BOLD, 84));
		txtDisplay.setBounds(41, 44, 544, 120);
		contentPane.add(txtDisplay);
		txtDisplay.setColumns(10);
		
		btn7 = new JButton("7");
		btn7.setFont(new Font("Arial", Font.PLAIN, 44));
		btn7.setBounds(41, 283, 128, 93);
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		btn8.setFont(new Font("Arial", Font.PLAIN, 44));
		btn8.setBounds(181, 283, 128, 93);
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.setFont(new Font("Arial", Font.PLAIN, 44));
		btn9.setBounds(321, 283, 128, 93);
		contentPane.add(btn9);
		
		btnMult = new JButton("X");
		btnMult.setFont(new Font("Arial", Font.PLAIN, 44));
		btnMult.setBounds(461, 283, 128, 93);
		contentPane.add(btnMult);
		
		btn4 = new JButton("4");
		btn4.setFont(new Font("Arial", Font.PLAIN, 44));
		btn4.setBounds(41, 389, 128, 93);
		contentPane.add(btn4);
		
		btn1 = new JButton("1");
		btn1.setFont(new Font("Arial", Font.PLAIN, 44));
		btn1.setBounds(41, 495, 128, 93);
		contentPane.add(btn1);
		
		btn5 = new JButton("5");
		btn5.setFont(new Font("Arial", Font.PLAIN, 44));
		btn5.setBounds(181, 389, 128, 93);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.setFont(new Font("Arial", Font.PLAIN, 44));
		btn6.setBounds(321, 389, 128, 93);
		contentPane.add(btn6);
		
		btnDiv = new JButton("/");
		btnDiv.setFont(new Font("Arial", Font.PLAIN, 44));
		btnDiv.setBounds(461, 389, 128, 93);
		contentPane.add(btnDiv);
		
		btn2 = new JButton("2");
		btn2.setFont(new Font("Arial", Font.PLAIN, 44));
		btn2.setBounds(181, 495, 128, 93);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.setFont(new Font("Arial", Font.PLAIN, 44));
		btn3.setBounds(321, 495, 128, 93);
		contentPane.add(btn3);
		
		btnSum = new JButton("+");
		btnSum.setFont(new Font("Arial", Font.PLAIN, 44));
		btnSum.setBounds(461, 495, 128, 93);
		contentPane.add(btnSum);
		
		btn0 = new JButton("0");
		btn0.setFont(new Font("Arial", Font.PLAIN, 44));
		btn0.setBounds(181, 601, 128, 93);
		contentPane.add(btn0);
		
		btnRes = new JButton("-");
		btnRes.setFont(new Font("Arial", Font.PLAIN, 44));
		btnRes.setBounds(461, 601, 128, 93);
		contentPane.add(btnRes);
		
		btnDot = new JButton(".");
		btnDot.setFont(new Font("Arial", Font.PLAIN, 44));
		btnDot.setBounds(321, 601, 128, 93);
		contentPane.add(btnDot);
		
		btnChSim = new JButton("+/-");
		btnChSim.setFont(new Font("Arial", Font.PLAIN, 44));
		btnChSim.setBounds(41, 601, 128, 93);
		contentPane.add(btnChSim);
		
		btnC = new JButton("C");
		btnC.setFont(new Font("Arial", Font.PLAIN, 44));
		btnC.setBounds(321, 177, 128, 93);
		contentPane.add(btnC);
		
		btnCE = new JButton("CE");
		btnCE.setFont(new Font("Arial", Font.PLAIN, 44));
		btnCE.setBounds(41, 177, 128, 93);
		contentPane.add(btnCE);
		
		btnIgual = new JButton("=");
		btnIgual.setFont(new Font("Arial", Font.PLAIN, 44));
		btnIgual.setBounds(457, 177, 128, 93);
		contentPane.add(btnIgual);
		
		btnDel = new JButton("DEL");
		btnDel.setFont(new Font("Arial", Font.PLAIN, 44));
		btnDel.setBounds(181, 177, 128, 93);
		contentPane.add(btnDel);
	}
}
