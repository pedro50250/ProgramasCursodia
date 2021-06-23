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
import javax.swing.JComboBox;
import javax.swing.JTextField;

import javax.swing.JSpinner;
import javax.swing.JTable;
import java.awt.Color;


public class Caja extends JFrame {

	
	private static final long serialVersionUID = -8383603082971633942L;
	public JTable tabla;
	private JPanel panelCaja;
	public JButton btnSalir;
	public JButton btnBuscar,btnAgregar;
	public JTextField txtCodigo;
	public JButton btnEliminar;
	public JButton btnPagar;
	public JTextField txtAPagar;
	public JSpinner spinner;
	private JLabel lblIcono;
	@SuppressWarnings("rawtypes")
	public JComboBox comboBox;


	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public Caja() {
		try{
		    UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch(Exception e){
		    System.out.println(e);
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/iconoTienda.png")));
		setTitle("Abarrotes Pedro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 512);
		panelCaja = new JPanel();
		//panelCaja.setBackground(new Color(255, 51, 51));
		panelCaja.setBackground(new Color(173, 216, 230));
		panelCaja.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelCaja);
		panelCaja.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Abarrotes Pedro");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(158, 21, 351, 50);
		panelCaja.add(lblTitulo);
		
		Image imgSalir = new ImageIcon(Login.class.getResource("/Imagenes/imagenSalir.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	    btnSalir = new JButton("Salir");
	    btnSalir.setToolTipText("Pulsa para salir de Vender");
		btnSalir.setIcon(new ImageIcon(imgSalir));
		btnSalir.setBounds(10, 11, 90, 43);
		panelCaja.add(btnSalir);
		
		Image imgBuscar = new ImageIcon(Login.class.getResource("/Imagenes/imagenBuscar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	    btnBuscar = new JButton("Buscar Articulo");
		btnBuscar.setBounds(492, 111, 151, 43);
		btnBuscar.setIcon(new ImageIcon(imgBuscar));
		panelCaja.add(btnBuscar);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCodigo.setBounds(141, 126, 86, 28);
		panelCaja.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Ingresa el codigo:");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCodigo.setBounds(20, 126, 121, 28);
		panelCaja.add(lblCodigo);
		
		JLabel lblNewLabel = new JLabel("Cantidad:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(237, 126, 86, 28);
		panelCaja.add(lblNewLabel);
		
		spinner = new JSpinner();
		spinner.setBounds(302, 126, 42, 28);
		spinner.setModel(new javax.swing.SpinnerNumberModel(0, new Integer(0), null, 1));
		panelCaja.add(spinner);
		
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
		scroll.setBounds(20, 163, 641, 230);
		panelCaja.add(scroll);
		
		Image imgAgregar = new ImageIcon(Login.class.getResource("/Imagenes/imagenAgregar.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnAgregar = new JButton("");
		btnAgregar.setBounds(356, 111, 61, 43);
		btnAgregar.setIcon(new ImageIcon(imgAgregar));
		panelCaja.add(btnAgregar);
		
		Image imgEliminar = new ImageIcon(Login.class.getResource("/Imagenes/imagenEliminar.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(imgEliminar));
		btnEliminar.setBounds(421, 111, 61, 43);
		panelCaja.add(btnEliminar);
		
		Image imgPagar = new ImageIcon(Login.class.getResource("/Imagenes/imagenPagar.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnPagar = new JButton("PAGAR");
		btnPagar.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnPagar.setBounds(461, 404, 182, 58);
		btnPagar.setIcon(new ImageIcon(imgPagar));
		panelCaja.add(btnPagar);
		
		JLabel lblTotal = new JLabel("Total a Pagar:");
		lblTotal.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTotal.setBounds(20, 414, 134, 43);
		panelCaja.add(lblTotal);
		
		txtAPagar = new JTextField();
		txtAPagar.setText("0.0");
		txtAPagar.setEditable(false);
		txtAPagar.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAPagar.setFont(new Font("Arial Black", Font.PLAIN, 18));
		txtAPagar.setBounds(141, 414, 103, 48);
		panelCaja.add(txtAPagar);
		txtAPagar.setColumns(10);
		
		Image imgTienda = new ImageIcon(Login.class.getResource("/Imagenes/imagenTienda.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(imgTienda));
		lblIcono.setBounds(485, 11, 103, 82);
		panelCaja.add(lblIcono);
		
		String [] opciones = {"Elige un Metodo de Pago","Efectivo","Tarjeta"};
		comboBox = new JComboBox(opciones);
		comboBox.setBounds(302, 414, 149, 43);
		panelCaja.add(comboBox);
	}
	

}
