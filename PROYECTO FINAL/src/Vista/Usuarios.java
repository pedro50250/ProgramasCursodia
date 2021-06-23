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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;


@SuppressWarnings("serial")
public class Usuarios extends JFrame {

	private JPanel paneUsuarios;
	public JButton btnSalir;
	public JButton btnBuscar,btnAgregar;
	public JTable tabla;
	public JButton btnEliminar;
	@SuppressWarnings("rawtypes")
	public JComboBox comboBox;

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Usuarios() {
		try{
		    UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch(Exception e){
		    System.out.println(e);
		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/iconoTienda.png")));
		setTitle("Administrar Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 512);
		paneUsuarios = new JPanel();
		//panelCaja.setBackground(new Color(255, 51, 51));
		paneUsuarios.setBackground(new Color(173, 216, 230));
		paneUsuarios.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(paneUsuarios);
		paneUsuarios.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Administar Usuarios");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(158, 21, 351, 50);
		paneUsuarios.add(lblTitulo);
		
		Image imgSalir = new ImageIcon(Login.class.getResource("/Imagenes/imagenSalir.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	    btnSalir = new JButton("Salir");
	    btnSalir.setToolTipText("Pulsa para salir de Vender");
		btnSalir.setIcon(new ImageIcon(imgSalir));
		btnSalir.setBounds(10, 11, 90, 43);
		paneUsuarios.add(btnSalir);
		
		Image imgBuscar = new ImageIcon(Login.class.getResource("/Imagenes/imagenBuscar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	    btnBuscar = new JButton("Buscar Usuario");
		btnBuscar.setBounds(342, 111, 151, 43);
		btnBuscar.setIcon(new ImageIcon(imgBuscar));
		paneUsuarios.add(btnBuscar);
		
		String dataValues[][] = {};
		String[] nombreColumnas = {"ID Usuario","Nombre","Password","Num. Ventas","Num. Compras","Nivel Usuario"};
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
		paneUsuarios.add(scroll);
		
		Image imgAgregar = new ImageIcon(Login.class.getResource("/Imagenes/agregarUsuario.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnAgregar = new JButton("Agregar Usuario");
		btnAgregar.setBounds(20, 111, 151, 43);
		btnAgregar.setIcon(new ImageIcon(imgAgregar));
		paneUsuarios.add(btnAgregar);
		
		Image imgEliminar = new ImageIcon(Login.class.getResource("/Imagenes/eliminarUsuario.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		btnEliminar = new JButton("Eliminar Usuario");
		btnEliminar.setBounds(181, 111, 151, 43);
		btnEliminar.setIcon(new ImageIcon(imgEliminar));
		paneUsuarios.add(btnEliminar);
		
		JLabel lblOrdenar = new JLabel("Ordenar por: ");
		lblOrdenar.setBounds(501, 111, 78, 43);
		paneUsuarios.add(lblOrdenar);
		
		String [] opciones = {"Default","Ventas","Compras","Vendedores","Administradores"};
	    comboBox = new JComboBox(opciones);
		comboBox.setBounds(571, 117, 90, 30);
		paneUsuarios.add(comboBox);
		
		Image imgUsuarios = new ImageIcon(Login.class.getResource("/Imagenes/ImagenUsuarios.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(imgUsuarios));
		lblIcono.setBounds(485, 11, 103, 82);
		paneUsuarios.add(lblIcono);
	}
}
