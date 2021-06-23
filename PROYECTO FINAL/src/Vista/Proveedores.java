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


import javax.swing.JComboBox;


@SuppressWarnings("serial")
public class Proveedores extends JFrame {

	private JPanel panelProveedores;
	public JButton btnSalir;
	public JButton btnBuscar,btnAgregar;
	public JTable tabla;
	public JButton btnEliminar;
	JLabel lblNewLabel;
	public JButton btnEditar, btnRestablecer;
	@SuppressWarnings("rawtypes")
	JComboBox comboBox;

	public Proveedores() {
		setTitle("Administrar Proveedores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/iconoTienda.png")));
		setBounds(100, 100, 797, 512);
		panelProveedores = new JPanel();
		//panelCaja.setBackground(new Color(255, 51, 51));
		panelProveedores.setBackground(new Color(173, 216, 230));
		panelProveedores.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelProveedores);
		panelProveedores.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Administar Proveedores");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(158, 21, 351, 50);
		panelProveedores.add(lblTitulo);
		
		Image imgSalir = new ImageIcon(Login.class.getResource("/Imagenes/imagenSalir.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	    btnSalir = new JButton("Volver");
	    btnSalir.setToolTipText("Pulsa para volver al Menu");
		btnSalir.setIcon(new ImageIcon(imgSalir));
		btnSalir.setBounds(10, 11, 107, 43);
		panelProveedores.add(btnSalir);
		
		Image imgBuscar = new ImageIcon(Login.class.getResource("/Imagenes/imagenBuscar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	    btnBuscar = new JButton("Buscar Proveedor");
		btnBuscar.setBounds(378, 111, 167, 43);
		btnBuscar.setIcon(new ImageIcon(imgBuscar));
		panelProveedores.add(btnBuscar);
		
		String dataValues[][] = {};
		String[] nombreColumnas = {"ID Proveedor","Nombre","Telefono","Direccion","Email"};
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
		scroll.setBounds(20, 163, 751, 299);
		panelProveedores.add(scroll);
		
		Image imgAgrega = new ImageIcon(Login.class.getResource("/Imagenes/imagenAgrega.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnAgregar = new JButton("Agregar Proveedor");
		btnAgregar.setBounds(20, 111, 167, 43);
		btnAgregar.setIcon(new ImageIcon(imgAgrega));
		panelProveedores.add(btnAgregar);
		
		Image imgElimina = new ImageIcon(Login.class.getResource("/Imagenes/imagenElimina.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnEliminar = new JButton("Eliminar Proveedor");
		btnEliminar.setBounds(197, 111, 167, 43);
		btnEliminar.setIcon(new ImageIcon(imgElimina));
		panelProveedores.add(btnEliminar);
		
		Image imgEditar = new ImageIcon(Login.class.getResource("/Imagenes/imagenEditar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnEditar = new JButton("Editar ");
		btnEditar.setBounds(555, 111, 107, 43);
		btnEditar.setIcon(new ImageIcon(imgEditar));
		panelProveedores.add(btnEditar);
		
		btnRestablecer = new JButton("Restablecer");
		btnRestablecer.setBounds(672, 111, 107, 43);
		panelProveedores.add(btnRestablecer);
	}
}

