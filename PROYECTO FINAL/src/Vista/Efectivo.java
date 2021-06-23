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
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import java.awt.Color;



public class Efectivo extends JFrame {

	
	private static final long serialVersionUID = -8383603082971633942L;
	public JTable tabla;
	private JPanel panelEfectivo;
	public JButton btnSalir;
	public JButton btnPagar;
	public JTextField txtAPagar, txtCambio;
	private JLabel lblIcono;
	public JSpinner spinBillete20,spinBillete50,spinBillete100,spinBillete200,spinBillete500,
	spinMoneda1,spinMoneda2,spinMoneda5,spinMoneda10;



	@SuppressWarnings("deprecation")
	public Efectivo() {
		try{
		    UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch(Exception e){
		    System.out.println(e);
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/iconoTienda.png")));
		setTitle("Abarrotes Pedro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 520);
		panelEfectivo = new JPanel();
		//panelCaja.setBackground(new Color(255, 51, 51));
		panelEfectivo.setBackground(new Color(173, 216, 230));
		panelEfectivo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelEfectivo);
		panelEfectivo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Resumen de Compra");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(158, 21, 351, 50);
		panelEfectivo.add(lblTitulo);
		
		Image imgSalir = new ImageIcon(Login.class.getResource("/Imagenes/imagenSalir.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	    btnSalir = new JButton("Volver");
	    btnSalir.setToolTipText("Pulsa para salir de Vender");
		btnSalir.setIcon(new ImageIcon(imgSalir));
		btnSalir.setBounds(23, 11, 90, 43);
		panelEfectivo.add(btnSalir);
		
		
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
		panelEfectivo.add(scroll);
		
		
		Image imgPagar = new ImageIcon(Login.class.getResource("/Imagenes/imagenPagar.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		btnPagar = new JButton("PAGAR");
		btnPagar.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnPagar.setBounds(461, 404, 182, 58);
		btnPagar.setIcon(new ImageIcon(imgPagar));
		panelEfectivo.add(btnPagar);
		
		JLabel lblTotal = new JLabel("Por Pagar:");
		lblTotal.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTotal.setBounds(461, 284, 127, 43);
		panelEfectivo.add(lblTotal);
		
		txtAPagar = new JTextField();
		txtAPagar.setText("0.0");
		txtAPagar.setEditable(false);
		txtAPagar.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAPagar.setFont(new Font("Arial Black", Font.PLAIN, 18));
		txtAPagar.setBounds(553, 280, 90, 48);
		panelEfectivo.add(txtAPagar);
		txtAPagar.setColumns(10);
		
		Image imgTienda = new ImageIcon(Login.class.getResource("/Imagenes/imagenTienda.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(imgTienda));
		lblIcono.setBounds(485, 11, 103, 82);
		panelEfectivo.add(lblIcono);
		
		spinBillete20 = new JSpinner();
		spinBillete20.setModel(new javax.swing.SpinnerNumberModel(0, new Integer(0), null, 1));
		spinBillete20.setBounds(141, 280, 69, 29);
		panelEfectivo.add(spinBillete20);
		
		JLabel lblBillete20 = new JLabel("New label");
		lblBillete20.setIcon(new ImageIcon(Efectivo.class.getResource("/imagenes_efectivo/veinte_pesos.jpg")));
		lblBillete20.setBounds(48, 280, 69, 29);
		panelEfectivo.add(lblBillete20);
		
		spinBillete50 = new JSpinner();
		spinBillete50.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinBillete50.setBounds(141, 320, 69, 29);
		panelEfectivo.add(spinBillete50);
		
		JLabel lblBillete50 = new JLabel("New label");
		lblBillete50.setIcon(new ImageIcon(Efectivo.class.getResource("/imagenes_efectivo/cincuenta.jpg")));
		lblBillete50.setBounds(48, 320, 69, 29);
		panelEfectivo.add(lblBillete50);
		
		spinBillete100 = new JSpinner();
		spinBillete100.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinBillete100.setBounds(141, 360, 69, 29);
		panelEfectivo.add(spinBillete100);
		
		JLabel lblBillete100 = new JLabel("New label");
		lblBillete100.setIcon(new ImageIcon(Efectivo.class.getResource("/imagenes_efectivo/100.jpg")));
		lblBillete100.setBounds(48, 360, 69, 29);
		panelEfectivo.add(lblBillete100);
		
		spinBillete200 = new JSpinner();
		spinBillete200.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinBillete200.setBounds(141, 401, 69, 29);
		panelEfectivo.add(spinBillete200);
		
		JLabel lblBillete200 = new JLabel("New label");
		lblBillete200.setIcon(new ImageIcon(Efectivo.class.getResource("/imagenes_efectivo/200.jpg")));
		lblBillete200.setBounds(48, 401, 69, 29);
		panelEfectivo.add(lblBillete200);
		
		spinBillete500 = new JSpinner();
		spinBillete500.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinBillete500.setBounds(141, 441, 69, 29);
		panelEfectivo.add(spinBillete500);
		
		JLabel lblBillete500 = new JLabel("New label");
		lblBillete500.setIcon(new ImageIcon(Efectivo.class.getResource("/imagenes_efectivo/500.jpg")));
		lblBillete500.setBounds(48, 441, 69, 29);
		panelEfectivo.add(lblBillete500);
		
		
		JLabel lblMoneda1 = new JLabel("");
		lblMoneda1.setIcon(new ImageIcon(Efectivo.class.getResource("/imagenes_efectivo/1_PESO.png")));
		lblMoneda1.setBounds(264, 280, 35, 29);
		panelEfectivo.add(lblMoneda1);
		
		spinMoneda1 = new JSpinner();
		spinMoneda1.setModel(new javax.swing.SpinnerNumberModel(0, new Integer(0), null, 1));
		spinMoneda1.setBounds(320, 280, 69, 29);
		panelEfectivo.add(spinMoneda1);
		
		JLabel lblMoneda2 = new JLabel("");
		lblMoneda2.setIcon(new ImageIcon(Efectivo.class.getResource("/imagenes_efectivo/2-Pesos.jpg")));
		lblMoneda2.setBounds(264, 320, 35, 29);
		panelEfectivo.add(lblMoneda2);
		
		spinMoneda2 = new JSpinner();
		spinMoneda2.setModel(new javax.swing.SpinnerNumberModel(0, new Integer(0), null, 1));
		spinMoneda2.setBounds(320, 320, 69, 29);
		panelEfectivo.add(spinMoneda2);
		
		JLabel lblMoneda5 = new JLabel("");
		lblMoneda5.setIcon(new ImageIcon(Efectivo.class.getResource("/imagenes_efectivo/5-Pesos.jpg")));
		lblMoneda5.setBounds(264, 360, 35, 29);
		panelEfectivo.add(lblMoneda5);
		
		spinMoneda5 = new JSpinner();
		spinMoneda5.setModel(new javax.swing.SpinnerNumberModel(0, new Integer(0), null, 1));
		spinMoneda5.setBounds(320, 360, 69, 29);
		panelEfectivo.add(spinMoneda5);
		
		JLabel lblMoneda10 = new JLabel("");
		lblMoneda10.setIcon(new ImageIcon(Efectivo.class.getResource("/imagenes_efectivo/10-Pesos.jpg")));
		lblMoneda10.setBounds(264, 401, 35, 29);
		panelEfectivo.add(lblMoneda10);
		
		spinMoneda10 = new JSpinner();
		spinMoneda10.setModel(new javax.swing.SpinnerNumberModel(0, new Integer(0), null, 1));
		spinMoneda10.setBounds(320, 401, 69, 29);
		panelEfectivo.add(spinMoneda10);
		
		JLabel lblngresa = new JLabel("Ingresa la Cantidad Recibida");
		lblngresa.setFont(new Font("Arial", Font.PLAIN, 14));
		lblngresa.setBounds(48, 253, 341, 19);
		panelEfectivo.add(lblngresa);
		
		JLabel lblCambio = new JLabel("Cambio:");
		lblCambio.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblCambio.setBounds(461, 350, 127, 43);
		panelEfectivo.add(lblCambio);
		
		txtCambio = new JTextField();
		txtCambio.setText("0.0");
		txtCambio.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCambio.setFont(new Font("Arial Black", Font.PLAIN, 18));
		txtCambio.setEditable(false);
		txtCambio.setColumns(10);
		txtCambio.setBounds(553, 345, 90, 48);
		panelEfectivo.add(txtCambio);
		
		
	}
}
