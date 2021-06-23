package application;

import java.awt.BorderLayout;
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

public class VistaPrincipal_Prototipo extends JFrame {

	private JPanel contentPane;
	private JTextField txtDisplay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal_Prototipo frame = new VistaPrincipal_Prototipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaPrincipal_Prototipo() {
		setFont(new Font("Dialog", Font.PLAIN, 18));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaPrincipal_Prototipo.class.getResource("/images/Ico.PNG")));
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
		txtDisplay.setBounds(41, 44, 548, 120);
		contentPane.add(txtDisplay);
		txtDisplay.setColumns(10);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Arial", Font.PLAIN, 44));
		btn7.setBounds(41, 283, 128, 93);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Arial", Font.PLAIN, 44));
		btn8.setBounds(181, 283, 128, 93);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Arial", Font.PLAIN, 44));
		btn9.setBounds(321, 283, 128, 93);
		contentPane.add(btn9);
		
		JButton btnX = new JButton("X");
		btnX.setFont(new Font("Arial", Font.PLAIN, 44));
		btnX.setBounds(461, 283, 128, 93);
		contentPane.add(btnX);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Arial", Font.PLAIN, 44));
		btn4.setBounds(41, 389, 128, 93);
		contentPane.add(btn4);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Arial", Font.PLAIN, 44));
		btn1.setBounds(41, 495, 128, 93);
		contentPane.add(btn1);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Arial", Font.PLAIN, 44));
		btn5.setBounds(181, 389, 128, 93);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Arial", Font.PLAIN, 44));
		btn6.setBounds(321, 389, 128, 93);
		contentPane.add(btn6);
		
		JButton btnDiv = new JButton("/");
		btnDiv.setFont(new Font("Arial", Font.PLAIN, 44));
		btnDiv.setBounds(461, 389, 128, 93);
		contentPane.add(btnDiv);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Arial", Font.PLAIN, 44));
		btn2.setBounds(181, 495, 128, 93);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Arial", Font.PLAIN, 44));
		btn3.setBounds(321, 495, 128, 93);
		contentPane.add(btn3);
		
		JButton btnSum = new JButton("+");
		btnSum.setFont(new Font("Arial", Font.PLAIN, 44));
		btnSum.setBounds(461, 495, 128, 93);
		contentPane.add(btnSum);
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Arial", Font.PLAIN, 44));
		btn0.setBounds(181, 601, 128, 93);
		contentPane.add(btn0);
		
		JButton btnRes = new JButton("-");
		btnRes.setFont(new Font("Arial", Font.PLAIN, 44));
		btnRes.setBounds(461, 601, 128, 93);
		contentPane.add(btnRes);
		
		JButton btnDot = new JButton(".");
		btnDot.setFont(new Font("Arial", Font.PLAIN, 44));
		btnDot.setBounds(321, 601, 128, 93);
		contentPane.add(btnDot);
		
		JButton btnChSim = new JButton("+/-");
		btnChSim.setFont(new Font("Arial", Font.PLAIN, 44));
		btnChSim.setBounds(41, 601, 128, 93);
		contentPane.add(btnChSim);
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Arial", Font.PLAIN, 44));
		btnC.setBounds(321, 177, 128, 93);
		contentPane.add(btnC);
		
		JButton btnCE = new JButton("CE");
		btnCE.setFont(new Font("Arial", Font.PLAIN, 44));
		btnCE.setBounds(41, 177, 128, 93);
		contentPane.add(btnCE);
		
		JButton btnIgual = new JButton("=");
		btnIgual.setFont(new Font("Arial", Font.PLAIN, 44));
		btnIgual.setBounds(461, 177, 128, 93);
		contentPane.add(btnIgual);
		
		JButton btnDel = new JButton("DEL");
		btnDel.setFont(new Font("Arial", Font.PLAIN, 44));
		btnDel.setBounds(181, 177, 128, 93);
		contentPane.add(btnDel);
	}
}
