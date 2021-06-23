package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Corte extends JFrame {

	private JPanel panel;
	public JTextField txtIngresos;
	public JTextField txtEgresos;
	public JTextField txtUtilidades;
	public JTable tableVentas;
	public JTable tableCompras;
	public JButton btnSalir;
	public JButton btnCorte;
	public JButton btnCompras;
	public JButton btnVentas;
	public JLabel lblTitulo = new JLabel("");

	public Corte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 512);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/iconoTienda.png")));
		setTitle("Corte");
		panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 322, 283);
		panel.add(scrollPane);
		
		tableVentas = new JTable();
		tableVentas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID VENTA", "MONTO", "HORA"
			}
		));
		scrollPane.setViewportView(tableVentas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(342, 110, 322, 283);
		panel.add(scrollPane_1);
		
		tableCompras = new JTable();
		tableCompras.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID COMPRA", "MONTO", "HORA"
			}
		));
		scrollPane_1.setViewportView(tableCompras);
		
		txtIngresos = new JTextField();
		txtIngresos.setBounds(227, 400, 85, 25);
		txtIngresos.setEditable(false);
		txtIngresos.setColumns(10);
		panel.add(txtIngresos);
		
		txtEgresos = new JTextField();
		txtEgresos.setColumns(10);
		txtEgresos.setBounds(227, 431, 85, 25);
		txtEgresos.setEditable(false);
		panel.add(txtEgresos);
		
		txtUtilidades = new JTextField();
		txtUtilidades.setColumns(10);
		txtUtilidades.setBounds(475, 400, 85, 25);
		txtUtilidades.setEditable(false);
		panel.add(txtUtilidades);
		
		Image imgSalir = new ImageIcon(Login.class.getResource("/Imagenes/imagenSalir.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	    btnSalir = new JButton("Volver");
	    btnSalir.setToolTipText("Pulsa para volver al Menu");
		btnSalir.setIcon(new ImageIcon(imgSalir));
		btnSalir.setBounds(10, 11, 107, 43);
		panel.add(btnSalir);
		
		btnVentas = new JButton("Ventas");
		Image imgVen = new ImageIcon(Login.class.getResource("/Imagenes/imagenVender.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnVentas.setIcon(new ImageIcon(imgVen));
		btnVentas.setToolTipText("Pulsa para volver al Menu");
		btnVentas.setBounds(51, 65, 214, 34);
		panel.add(btnVentas);
		
		btnCompras = new JButton("Compras");
		btnCompras.setToolTipText("Pulsa para volver al Menu");
		btnCompras.setBounds(392, 65, 214, 34);
		Image imgCom = new ImageIcon(Login.class.getResource("/Imagenes/imagenComprar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnCompras.setIcon(new ImageIcon(imgCom));
		panel.add(btnCompras);
		
		btnCorte = new JButton("Corte");
		btnCorte.setToolTipText("Pulsa para volver al Menu");
		btnCorte.setBounds(342, 428, 218, 34);
		Image imgCor = new ImageIcon(Login.class.getResource("/Imagenes/imagenCorte.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnCorte.setIcon(new ImageIcon(imgCor));
		panel.add(btnCorte);
		
		
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblTitulo.setBounds(5, 21, 664, 47);
		panel.add(lblTitulo);
		
		JLabel lblUtilidades = new JLabel("UTILIDADES: $");
		lblUtilidades.setHorizontalAlignment(SwingConstants.LEFT);
		lblUtilidades.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUtilidades.setBounds(345, 400, 132, 31);
		panel.add(lblUtilidades);
		
		JLabel lblEgresos = new JLabel("EGRESOS: $");
		lblEgresos.setHorizontalAlignment(SwingConstants.LEFT);
		lblEgresos.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEgresos.setBounds(109, 431, 111, 31);
		panel.add(lblEgresos);
		
		JLabel lblIngresos_1 = new JLabel("INGRESOS: $");
		lblIngresos_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngresos_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblIngresos_1.setBounds(104, 400, 143, 31);
		panel.add(lblIngresos_1);
		
		JLabel lblResumen = new JLabel("RESUMEN:");
		lblResumen.setHorizontalAlignment(SwingConstants.LEFT);
		lblResumen.setFont(new Font("Arial", Font.BOLD, 18));
		lblResumen.setBounds(5, 400, 100, 31);
		panel.add(lblResumen);
	}
}
