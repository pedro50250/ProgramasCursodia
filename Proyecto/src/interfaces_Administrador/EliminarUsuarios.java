package interfaces_Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Usuario;
import clases.claseUsuario;

public class EliminarUsuarios extends JFrame implements ActionListener{

	ArrayList<claseUsuario> usuarios = new ArrayList<claseUsuario>();
	private JPanel contentPane;
	private JTable Tabla;
	private JButton btnVolver;
	DefaultTableModel model;
	private JButton btnEliminar;
	private int id_usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarUsuarios frame = new EliminarUsuarios(2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EliminarUsuarios(int id_Usuario) {
		this.id_usuario = id_Usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 653, 320);
		contentPane.add(scrollPane);
		
		Tabla = new JTable();
		Tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Usuario", "Nombre Usuario", "Contraseña","Nivel Usuario","Numero de Ventas","Numero de compras"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class,  String.class,String.class,Integer.class,Integer.class,Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(Tabla);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnVolver.setBounds(10, 11, 89, 23);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnEliminar.setBounds(120, 13, 100, 21);
		btnEliminar.addActionListener(this);
		contentPane.add(btnEliminar);
		
		agregarFilas();
		
	}
	
	public void agregarFilas()
	{
		Usuario usu = new Usuario();
		usuarios = usu.extraerUsuarios();
		model = (DefaultTableModel) Tabla.getModel();
		for(int i=0;i<usuarios.size();i++)
		{
			model.addRow(new Object[] {usuarios.get(i).id_usuario,usuarios.get(i).nombre,usuarios.get(i).password,
					usuarios.get(i).niv_usuario,usuarios.get(i).numVentas,usuarios.get(i).numCompras});
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver)
		{
			dispose();
			Menu menu = new Menu(id_usuario);
			menu.setLocationRelativeTo(null);
			menu.setVisible(true);
		}
		if(e.getSource()==btnEliminar)
		{
			try
			{
				String nombre = JOptionPane.showInputDialog("Ingrese el nombre de usuario");
			String pass = JOptionPane.showInputDialog("Ingrese la contraseña");
			//int niv = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel de usuario"));
			Usuario usu = new Usuario();
			usu.eliminarUsuario(nombre, pass);
			model.setRowCount(0);
			agregarFilas();
			}
			catch(Exception er)
			{
				JOptionPane.showInputDialog("Ocurrio un error en la captura de los datos");
			}
			
		}
		
	}


}
