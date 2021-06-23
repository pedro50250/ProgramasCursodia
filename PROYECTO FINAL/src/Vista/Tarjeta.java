package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;


import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;



public class Tarjeta extends JFrame {

	
	private static final long serialVersionUID = -8383603082971633942L;
	public JTable tabla;
	private JPanel panelTarjeta;
	public JButton btnSalir;
	public JButton btnPagar;
	private JLabel lblIcono;
	public JTextField txtNumTarjeta;
	public JTextField txtVencimiento;
	public JTextField txtCCV,txtAPagar;



	public Tarjeta() {
		try{
		    UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch(Exception e){
		    System.out.println(e);
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/iconoTienda.png")));
		setTitle("Abarrotes Pedro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 520);
		panelTarjeta = new JPanel();
		//panelCaja.setBackground(new Color(255, 51, 51));
		panelTarjeta.setBackground(new Color(173, 216, 230));
		panelTarjeta.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelTarjeta);
		panelTarjeta.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Resumen de Compra");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(158, 21, 351, 50);
		panelTarjeta.add(lblTitulo);
		
		Image imgSalir = new ImageIcon(Login.class.getResource("/Imagenes/imagenSalir.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	    btnSalir = new JButton("Volver");
	    btnSalir.setToolTipText("Pulsa para salir de Vender");
		btnSalir.setIcon(new ImageIcon(imgSalir));
		btnSalir.setBounds(23, 11, 90, 43);
		panelTarjeta.add(btnSalir);
		
		
		String dataValues[][] = {};
		String[] nombreColumnas = {"ID Articulo","Nombre","Precio","Cantidad"};
		DefaultTableModel dtm= new DefaultTableModel(dataValues, nombreColumnas)
		{
		    /**
			 * 
			 */
			private static final long serialVersionUID = -8918525348329721933L;

			@Override
		    public boolean isCellEditable(int row, int column)
		    {
		       //all cells false
		       return false;
		    }
		};
		tabla = new JTable(dtm);
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(23, 94, 641, 148);
		panelTarjeta.add(scroll);
		
		
		Image imgPagar = new ImageIcon(Login.class.getResource("/Imagenes/imagenPagar.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnPagar = new JButton("PAGAR");
		btnPagar.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnPagar.setBounds(461, 368, 182, 90);
		btnPagar.setIcon(new ImageIcon(imgPagar));
		panelTarjeta.add(btnPagar);
		
		Image imgTienda = new ImageIcon(Login.class.getResource("/Imagenes/imagenTienda.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(imgTienda));
		lblIcono.setBounds(485, 11, 103, 82);
		panelTarjeta.add(lblIcono);
		
		JLabel lblngresa = new JLabel("Ingresa los datos de la Tarjeta");
		lblngresa.setFont(new Font("Arial Black", Font.PLAIN, 19));
		lblngresa.setBounds(23, 253, 341, 43);
		panelTarjeta.add(lblngresa);
		
		JLabel lblNumTar = new JLabel("Num. de Tarjeta");
		lblNumTar.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNumTar.setBounds(23, 321, 138, 34);
		panelTarjeta.add(lblNumTar);
		
		txtNumTarjeta = new JTextField();
		txtNumTarjeta.setBounds(158, 324, 163, 33);
		panelTarjeta.add(txtNumTarjeta);
		txtNumTarjeta.setColumns(10);
		
		JLabel lblVenc = new JLabel("Mes / A\u00F1o Venc.");
		lblVenc.setFont(new Font("Arial", Font.PLAIN, 18));
		lblVenc.setBounds(23, 372, 138, 34);
		panelTarjeta.add(lblVenc);
		
		txtVencimiento = new JTextField();
		txtVencimiento.setColumns(10);
		txtVencimiento.setBounds(158, 375, 163, 33);
		panelTarjeta.add(txtVencimiento);
		
		JLabel lblCCV = new JLabel("Num. CCV");
		lblCCV.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCCV.setBounds(23, 428, 138, 34);
		panelTarjeta.add(lblCCV);
		
		txtCCV = new JTextField();
		txtCCV.setColumns(10);
		txtCCV.setBounds(158, 425, 62, 33);
		panelTarjeta.add(txtCCV);
		
		JLabel lblTotal = new JLabel("Por Pagar:");
		lblTotal.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTotal.setBounds(461, 299, 127, 43);
		panelTarjeta.add(lblTotal);
		
		txtAPagar = new JTextField();
		txtAPagar.setText("0.0");
		txtAPagar.setEditable(false);
		txtAPagar.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAPagar.setFont(new Font("Arial Black", Font.PLAIN, 18));
		txtAPagar.setBounds(553, 282, 90, 48);
		panelTarjeta.add(txtAPagar);
		txtAPagar.setColumns(10);
		
		
	}
}
