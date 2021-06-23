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

import clases.Ciudad;
import clases.claseCiudad;

public class BorrarDestino extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnVolver;
	private JButton btnBorrar;
	DefaultTableModel model;
	ArrayList<claseCiudad> ciudades = new ArrayList<claseCiudad>();
	private JTable Tabla;
	private int id_usuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrarDestino frame = new BorrarDestino();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BorrarDestino()
	{
		
	}
	
	public BorrarDestino(int id_usuario) {
		this.id_usuario= id_usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 416, 272);
		contentPane.add(scrollPane);
		
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
		contentPane.add(btnVolver);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnBorrar.setBounds(120, 13, 100, 21);
		btnBorrar.addActionListener(this);
		contentPane.add(btnBorrar);
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
		if(e.getSource()==btnBorrar)
		{
			try
			{
				String Ciudad = JOptionPane.showInputDialog("Ingresa el nombre de la ciudad");
				Ciudad ciu = new Ciudad();
				ciu.borrarCiudad(Ciudad);
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
