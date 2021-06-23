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

import clases.Boleto;
import clases.DetalleVentas;
import clases.claseDetalles;

public class VerDetalles extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable Tabla;
	DefaultTableModel model;
	private JButton btnVolver;
	private int id_Usuario;
	ArrayList<claseDetalles> detalles = new ArrayList<claseDetalles>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerDetalles frame = new VerDetalles(1);
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
	public VerDetalles(int idUsuario) {
		this.id_Usuario = idUsuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 45, 587, 282);
		contentPane.add(scrollPane);
		
		Tabla = new JTable();
		Tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Detalle", "ID Venta", "Id Vuelo","Cantidad Boletos","Forma de pago","ID Usuario que vendio","Monto"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class,Integer.class, Integer.class,String.class,Integer.class,Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(Tabla);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnVolver.setBounds(10, 11, 89, 23);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
		
		agregarFilas();
	}

	public void agregarFilas()
	{
		DetalleVentas detalle = new DetalleVentas();
		detalles = detalle.extraerDetalles();
		model = (DefaultTableModel) Tabla.getModel();
		for(int i=0;i<detalles.size();i++)
		{
			model.addRow(new Object[] {detalles.get(i).idDetalle,detalles.get(i).idVenta,detalles.get(i).idVuelo,
					detalles.get(i).CantBol,detalles.get(i).metodo,detalles.get(i).idUsuario,detalles.get(i).total});
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver)
		{
			dispose();
			VerBoletos ver = new VerBoletos(id_Usuario);
			ver.setLocationRelativeTo(null);
			ver.setVisible(true);
		
		}
	}
}
