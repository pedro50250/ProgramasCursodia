package interfaces_Usuario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import interfaces_Administrador.Menu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class Login extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField jPassClave;
	private JButton btnIngresar;
	private JLabel lbFotoFondo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		try{
		    UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch(Exception e){
		    System.out.println(e);
		}
		setTitle("Login");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 239);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbLogin = new JLabel("LOGIN");
		lbLogin.setForeground(Color.BLACK);
		lbLogin.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lbLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbLogin.setBackground(new Color(255, 0, 0));
		lbLogin.setBounds(43, 21, 140, 46);
		contentPane.add(lbLogin);
		
		JLabel lbUsuario = new JLabel("Usuario");
		lbUsuario.setForeground(Color.RED);
		lbUsuario.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbUsuario.setBounds(43, 92, 66, 24);
		contentPane.add(lbUsuario);
		
		JLabel lbConstraseña = new JLabel("Contrase\u00F1a");
		lbConstraseña.setForeground(Color.RED);
		lbConstraseña.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbConstraseña.setBounds(43, 138, 83, 24);
		contentPane.add(lbConstraseña);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(Color.LIGHT_GRAY);
		txtUsuario.setBounds(157, 95, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		jPassClave = new JPasswordField();
		jPassClave.setBackground(Color.LIGHT_GRAY);
		jPassClave.setBounds(157, 149, 86, 20);
		contentPane.add(jPassClave);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBackground(Color.BLUE);
		btnIngresar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnIngresar.setBounds(314, 107, 95, 41);
		contentPane.add(btnIngresar);
		
		lbFotoFondo = new JLabel("");
		lbFotoFondo.setIcon(new ImageIcon(Login.class.getResource("/fotos/avion-despegando-aeropuerto_37416-2.jpg")));
		lbFotoFondo.setBounds(0, 0, 420, 212);
		contentPane.add(lbFotoFondo);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String usuario = txtUsuario.getText();
		char [] clave = jPassClave.getPassword();
		String contraseña = new String(clave);
		Usuario usu = new Usuario();
		boolean encontrado = usu.buscarUsuario(usuario, contraseña);
		if(encontrado==true)
			{
			  int nivel = usu.buscarNivel(usuario, contraseña);
			  System.out.println(nivel);
			  if(nivel==1)
			  {
				  JOptionPane.showMessageDialog(null, "Bienvenido: " + usuario + "!!" );
				  dispose();
				  int idUsuario = usu.buscarID(usuario, contraseña);
				  Origen ori = new Origen(idUsuario);
				  ori.setResizable(false);
				  ori.setLocationRelativeTo(null);
				  ori.setVisible(true);
			  }
			  if(nivel==2)
			  {
				  JOptionPane.showMessageDialog(null, "Bienvenido: " + usuario + "!!" );
				  dispose();
				  int idUsuario = usu.buscarID(usuario, contraseña);
				  Menu menu = new Menu(idUsuario);
				  menu.setResizable(false);
				  menu.setLocationRelativeTo(null);
				  menu.setVisible(true);  
			  }
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Credenciales Incorrectas","ERROR",JOptionPane.ERROR_MESSAGE);
			}
				
	}
}
