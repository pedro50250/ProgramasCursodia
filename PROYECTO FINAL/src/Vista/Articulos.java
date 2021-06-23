package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Articulos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelArticulos;
	public JButton btnSalir;
	public JButton btnBuscar,btnAgregar,btnEditar;
	public JTable tabla;
	public JButton btnEliminar;
	@SuppressWarnings("rawtypes")
	public JComboBox comboBox;

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Articulos() {
		try{
		    UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch(Exception e){
		    System.out.println(e);
		}
		
		setTitle("Administrar Articulos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 512);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/iconoTienda.png")));
		panelArticulos = new JPanel();
		//panelCaja.setBackground(new Color(255, 51, 51));
		panelArticulos.setBackground(new Color(173, 216, 230));
		panelArticulos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelArticulos);
		panelArticulos.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Administar Articulos");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(158, 21, 351, 50);
		panelArticulos.add(lblTitulo);
		
		Image imgSalir = new ImageIcon(Login.class.getResource("/Imagenes/imagenSalir.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	    btnSalir = new JButton("Salir");
	    btnSalir.setToolTipText("Pulsa para salir de Vender");
		btnSalir.setIcon(new ImageIcon(imgSalir));
		btnSalir.setBounds(10, 11, 90, 43);
		panelArticulos.add(btnSalir);
		
		Image imgBuscar = new ImageIcon(Login.class.getResource("/Imagenes/imagenBuscar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	    btnBuscar = new JButton("Buscar Articulo");
		btnBuscar.setBounds(342, 111, 151, 43);
		btnBuscar.setIcon(new ImageIcon(imgBuscar));
		panelArticulos.add(btnBuscar);
		
		String dataValues[][] = {};
		String[] nombreColumnas = {"Clave articulo","Nombre","Precio","Categoria","id Proveedor","Inventario Disponible"};
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
		scroll.setBounds(20, 163, 739, 299);
		panelArticulos.add(scroll);
		
		Image imgAgregar = new ImageIcon(Login.class.getResource("/Imagenes/imagenAgregar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnAgregar = new JButton("Agregar Articulo");
		btnAgregar.setBounds(20, 111, 151, 43);
		btnAgregar.setIcon(new ImageIcon(imgAgregar));
		panelArticulos.add(btnAgregar);
		
		Image imgEliminar = new ImageIcon(Login.class.getResource("/Imagenes/imagenEliminar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnEliminar = new JButton("Eliminar Articulo");
		btnEliminar.setBounds(181, 111, 151, 43);
		btnEliminar.setIcon(new ImageIcon(imgEliminar));
		panelArticulos.add(btnEliminar);
		
		JLabel lblOrdenar = new JLabel("Ordenar por: ");
		lblOrdenar.setBounds(602, 111, 78, 43);
		panelArticulos.add(lblOrdenar);
		
		String [] opciones = {"Default","Inventario","Categoria","Precio"};
	    comboBox = new JComboBox(opciones);
		comboBox.setBounds(669, 117, 90, 30);
		panelArticulos.add(comboBox);
		
		Image imgUsuarios = new ImageIcon(Login.class.getResource("/Imagenes/imagenCanasta.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(imgUsuarios));
		lblIcono.setBounds(485, 11, 103, 82);
		panelArticulos.add(lblIcono);
		
		Image imgEditar = new ImageIcon(Login.class.getResource("/Imagenes/imagenEditar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(503, 111, 90, 43);
		btnEditar.setIcon(new ImageIcon(imgEditar));
		panelArticulos.add(btnEditar);
	}
}
