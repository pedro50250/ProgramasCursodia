package interfaces_Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Ciudad;
import clases.Vuelo;
import clases.claseCiudad;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AgregarDestinos extends JFrame implements ActionListener{

	private JPanel panelDestinos;
	private JTable Tabla;
	private JButton btnVolver;
	DefaultTableModel model;
	ArrayList<claseCiudad> ciudades = new ArrayList<claseCiudad>();
	private JButton btnAgregar;
	private JButton btnBorrar;
	private int id_usuario;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarDestinos frame = new AgregarDestinos(2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AgregarDestinos()
	{
		
	}
	public AgregarDestinos(int id_usuario) {
		this.id_usuario = id_usuario;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 416);
		panelDestinos = new JPanel();
		panelDestinos.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDestinos.setLayout(null);
		setContentPane(panelDestinos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 416, 272);
		panelDestinos.add(scrollPane);
		
		Tabla = new JTable();
		Tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Ciudad", "Ciudad", "Estado","Pais"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class,  String.class,String.class,String.class
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
		panelDestinos.add(btnVolver);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnAgregar.setBounds(120, 13, 100, 21);
		btnAgregar.addActionListener(this);
		panelDestinos.add(btnAgregar);
		agregarFilas();
		
	}

	public void agregarFilas()
	{
		Ciudad ciu = new Ciudad();
		ciudades = ciu.extraerCiudade();
		model = (DefaultTableModel) Tabla.getModel();
		for(int i=0;i<ciudades.size();i++)
		{
			model.addRow(new Object[] {ciudades.get(i).idCiudad,ciudades.get(i).Ciudad,
					ciudades.get(i).Estado,ciudades.get(i).Pais});
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
		if(e.getSource()==btnAgregar)
		{
			try
			{
				String Ciudad = JOptionPane.showInputDialog("Ingresa el nombre de la ciudad");
				String Estado = JOptionPane.showInputDialog("Ingresa el nombre del estado");
				String Pais = JOptionPane.showInputDialog("Ingresa el nombre dle pais");
				Ciudad ciu = new Ciudad();
				ciu.insertarCiudad(Ciudad, Estado, Pais);
				model.setRowCount(0);
				agregarFilas();
				
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Error en la captura de los datso intenta nuevamente");
			}
		}
		
	}

}
