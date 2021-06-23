package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame {

	 
	private static final long serialVersionUID = 3936948070247387244L;
	JPanel panelLogin;
	public JTextField txtUsuario;
	public JPasswordField txtPassword;
	public JButton btnIngresar;
	
	public Login() {
		try{
		    UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch(Exception e){
		    System.out.println(e);
		}
		setResizable(false);
		setTitle("Ingresar a Tienda");
		setForeground(new Color(64, 224, 208));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/iconoTienda.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 382);
		panelLogin = new JPanel();
		panelLogin.setBackground(new Color(144, 238, 144));
		panelLogin.setForeground(new Color(255, 255, 255));
		panelLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelLogin);
		panelLogin.setLayout(null);
				
		JLabel lblTitulo = new JLabel("Abarrotes Pedro");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(42, 35, 299, 107);
		panelLogin.add(lblTitulo);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(230, 230, 250));
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setText("Usuario");
		txtUsuario.setToolTipText("Ingresa tu Usuario");
		txtUsuario.setBounds(114, 153, 210, 44);
		panelLogin.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(new Color(230, 230, 250));
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		txtPassword.setToolTipText("Inresa la contrase\u00F1a");
		txtPassword.setBounds(114, 208, 210, 44);
		txtPassword.setText("●●●●●●●●●●");
		panelLogin.add(txtPassword);
		
		Image imgTienda = new ImageIcon(Login.class.getResource("/Imagenes/bolsaCompras.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		JLabel lblImagenBolsa = new JLabel("");
		lblImagenBolsa.setIcon(new ImageIcon(imgTienda));
		lblImagenBolsa.setBounds(311, 23, 105, 105);
		panelLogin.add(lblImagenBolsa);
		
		
		Image imgEntrar = new ImageIcon(Login.class.getResource("/Imagenes/iconoEntrar.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		btnIngresar = new JButton("Entrar");
		btnIngresar.setToolTipText("Pulsa para Ingresar");
		btnIngresar.setForeground(Color.BLACK);
		btnIngresar.setBackground(Color.LIGHT_GRAY);
		btnIngresar.setIcon(new ImageIcon(imgEntrar));
		btnIngresar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnIngresar.setBounds(114, 273, 210, 59);
		panelLogin.add(btnIngresar);
		
		Image imgUsuario = new ImageIcon(Login.class.getResource("/Imagenes/imagenUsuario.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		Image imgContraseña = new ImageIcon(Login.class.getResource("/Imagenes/imagenContraseña.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		
		JLabel lblImagenUsuario = new JLabel("");
		lblImagenUsuario.setBounds(52, 153, 52, 44);
		lblImagenUsuario.setIcon(new ImageIcon(imgUsuario));
		panelLogin.add(lblImagenUsuario);
		
		JLabel lblImagenContraseña = new JLabel("");
		lblImagenContraseña.setBounds(52, 208, 52, 44);
		lblImagenContraseña.setIcon(new ImageIcon(imgContraseña));
		panelLogin.add(lblImagenContraseña);
		
		
	}
}
