package Articulos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Vista_Principal extends JFrame {
	public Vista_Principal() {
	}

	JPanel contentPane;
	JTextField txtClave;
	JTextField txtNombre;
	JTextField txtCategoria;
	JTextField txtPrecio;
	JButton btnAgregar;
	JButton btnEditar;
	//JTextArea textArea;
	DefaultTableModel model;
	
	public void crearGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Agregar Articulos");
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(56, 11, 289, 51);
		contentPane.add(lblTitulo);
		
		txtClave = new JTextField();
		txtClave.setBounds(142, 79, 98, 20);
		contentPane.add(txtClave);
		txtClave.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave del Articulo");
		lblClave.setFont(new Font("Arial", Font.BOLD, 12));
		lblClave.setBounds(10, 73, 98, 33);
		contentPane.add(lblClave);
		
		JLabel lblNombre = new JLabel("Nombre del Articulo");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(10, 112, 112, 33);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(142, 118, 98, 20);
		contentPane.add(txtNombre);
		
		JLabel lblCategoria = new JLabel("Categoria del Articulo");
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 12));
		lblCategoria.setBounds(10, 181, 122, 33);
		contentPane.add(lblCategoria);
		
		txtCategoria = new JTextField();
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(142, 181, 98, 20);
		contentPane.add(txtCategoria);
		
		JLabel lblPrecio = new JLabel("Precio del Articulo");
		lblPrecio.setFont(new Font("Arial", Font.BOLD, 12));
		lblPrecio.setBounds(10, 149, 122, 33);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(142, 149, 98, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnAgregar.setBounds(297, 164, 112, 37);
		contentPane.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnEditar.setBounds(297, 117, 112, 36);
		contentPane.add(btnEditar);
		
		/*textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(25, 244, 384, 127);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(25, 244, 384, 127);
		contentPane.add(scroll);*/
		
		model = new DefaultTableModel(); 
		JTable table = new JTable(model); 
		table.setBounds(25, 244, 384, 127);
		JScrollPane scro = new JScrollPane(table);
		scro.setBounds(25, 244, 384, 127);
		// Create a couple of columns 
		model.addColumn("Clave Art"); 
		model.addColumn("Nombre Art"); 
		model.addColumn("Precio Art"); 
		model.addColumn("Cat Art"); 
		contentPane.add(scro);
		
	}
}
