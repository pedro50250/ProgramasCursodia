package Vista;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MenuAdmin extends JFrame {

	private JPanel panelMenu;
	public JButton btnSalir;
	public JButton btnVender;
	public JButton btnArticulos;
	public JButton btnProveedores;
	public JButton btnUsuarios;
	public JButton btnVentas;
	public JButton btnCompras;
	public JButton btnCortes;
	public JButton btnReportes;
	public JButton btnComprar;
	public JLabel lblHora;


	public MenuAdmin() {
		setTitle("Menu de Administrador");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/iconoTienda.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 497);
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(173, 216, 230));
		panelMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Administar Tienda");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(168, 11, 351, 50);
		panelMenu.add(lblTitulo);
		
		Image imgSalir = new ImageIcon(Login.class.getResource("/Imagenes/imagenSalir.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	    btnSalir = new JButton("Salir");
	    btnSalir.setToolTipText("Pulsa para salir de Vender");
		btnSalir.setIcon(new ImageIcon(imgSalir));
		btnSalir.setBounds(10, 11, 90, 43);
		panelMenu.add(btnSalir);
		
		Image imgVender = new ImageIcon(Login.class.getResource("/Imagenes/imagenVender.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnVender = new JButton("Vender");
		btnVender.setFont(new Font("Arial", Font.PLAIN, 18));
		btnVender.setIcon(new ImageIcon(imgVender));
		btnVender.setBounds(50, 100, 160, 90);
		panelMenu.add(btnVender);
		
		Image imgArt = new ImageIcon(Login.class.getResource("/Imagenes/imagenCanasta.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnArticulos = new JButton("Articulos");
		btnArticulos.setFont(new Font("Arial", Font.PLAIN, 18));
		btnArticulos.setIcon(new ImageIcon(imgArt));
		btnArticulos.setBounds(269, 229, 160, 90);
		panelMenu.add(btnArticulos);
		
		btnProveedores = new JButton("Proveedores");
		Image imgProv = new ImageIcon(Login.class.getResource("/Imagenes/imagenProveedores.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnProveedores.setFont(new Font("Arial", Font.PLAIN, 18));
		btnProveedores.setBounds(487, 229, 160, 90);
		btnProveedores.setIcon(new ImageIcon(imgProv));
		panelMenu.add(btnProveedores);
		
		Image imgUsu = new ImageIcon(Login.class.getResource("/Imagenes/imagenUsuarios.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setBounds(50, 229, 160, 90);
		btnUsuarios.setIcon(new ImageIcon(imgUsu));
		btnUsuarios.setFont(new Font("Arial", Font.PLAIN, 18));
		panelMenu.add(btnUsuarios);
		
		Image imgVen = new ImageIcon(Login.class.getResource("/Imagenes/imagenVentas.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnVentas = new JButton("Ventas");
		btnVentas.setBounds(50, 349, 160, 90);
		btnVentas.setIcon(new ImageIcon(imgVen));
		btnVentas.setFont(new Font("Arial", Font.PLAIN, 18));
		panelMenu.add(btnVentas);
		
		Image imgCom = new ImageIcon(Login.class.getResource("/Imagenes/imagenCompras.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnCompras = new JButton("Compras");
		btnCompras.setBounds (269, 349, 160, 90);
		btnCompras.setIcon(new ImageIcon(imgCom));
		btnCompras.setFont(new Font("Arial", Font.PLAIN, 18));
		panelMenu.add(btnCompras);
		
		Image imgCort = new ImageIcon(Login.class.getResource("/Imagenes/imagenCorte.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnCortes = new JButton("Cortes");
		btnCortes.setIcon(new ImageIcon(imgCort));
		btnCortes.setBounds (487, 100, 160, 90);
		btnCortes.setFont(new Font("Arial", Font.PLAIN, 18));
		panelMenu.add(btnCortes);
		
		Image imgRepor = new ImageIcon(Login.class.getResource("/Imagenes/imagenReporte.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnReportes = new JButton("Reportes");
		btnReportes.setBounds(487,349,160,90);
		btnReportes.setIcon(new ImageIcon(imgRepor));
		btnReportes.setFont(new Font("Arial", Font.PLAIN, 18));
		panelMenu.add(btnReportes);
		
		lblHora = new JLabel("New label");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setBounds (487, 11, 175, 27);
		panelMenu.add(lblHora);
		
		
		btnComprar = new JButton("Comprar");
		Image imgComprar = new ImageIcon(Login.class.getResource("/Imagenes/imagenComprar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnComprar.setIcon(new ImageIcon(imgComprar));
		btnComprar.setBounds(269, 100, 160, 90);
		btnComprar.setFont(new Font("Arial", Font.PLAIN, 18));
		panelMenu.add(btnComprar);
	}

}
