package interfaces_Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Ciudad;
import clases.Corte;
import clases.claseCorte;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Cortes extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnGenerar;
	private JButton btnBorrar;
	private int id_usuario;
	private JTable Tabla;
	private JButton btnVolver;
	DefaultTableModel model;
	ArrayList<claseCorte> cortes = new ArrayList<claseCorte>();
	private JLabel lblCorte;
	

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cortes frame = new Cortes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	public Cortes(int id_Usuario) {
		this.id_usuario = id_Usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 76, 416, 272);
		contentPane.add(scrollPane);
		
		Tabla = new JTable();
		Tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Corte", "Dinero generado", "Dia Generado","Dia De Venta"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class,  Float.class,String.class,String.class
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
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnGenerar.setBounds(120, 13, 100, 21);
		btnGenerar.addActionListener(this);
		contentPane.add(btnGenerar);
		
		lblCorte = new JLabel("Cortes Generados");
		lblCorte.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblCorte.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorte.setBounds(117, 34, 291, 34);
		contentPane.add(lblCorte);
		agregarFilas();
	}
	
	public void agregarFilas()
	{
		Corte cor = new Corte();
		cortes = cor.verCortes();
		model = (DefaultTableModel) Tabla.getModel();
		for(int i=0;i<cortes.size();i++)
		{
			model.addRow(new Object[] {cortes.get(i).id_corte,cortes.get(i).dinero_corte,cortes.get(i).diaGenerado,
					cortes.get(i).diaVenta});
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
		if(e.getSource()==btnGenerar)
		{
			String dia = JOptionPane.showInputDialog("Ingresa el dia ejemplo(2020:05:29 ");
			Corte cor = new Corte();
			cor.generarCorte(dia);
			model.setRowCount(0);
			agregarFilas();
		}
		
	}

}
