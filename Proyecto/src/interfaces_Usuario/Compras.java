package interfaces_Usuario;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class Compras extends JFrame {

	private JPanel panel;
	public JTable table;
	public JTable tableDetalle;
	public JButton btnSalir;
	
	@SuppressWarnings("rawtypes")
	public JComboBox cbxPrimary = new JComboBox();
	@SuppressWarnings("rawtypes")
	public JComboBox cbxOrden = new JComboBox();
	@SuppressWarnings("rawtypes")
	public JComboBox cbxUsuario = new JComboBox();
	@SuppressWarnings("rawtypes")
	public JComboBox cbxRango = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compras frame = new Compras();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Compras() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 593);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/iconoTienda.png")));
		setTitle("Historial de Compras");
		panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Historial de Compras");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblNewLabel.setBounds(5, 21, 664, 47);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 128, 664, 268);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID COMPRA", "PROVEEDOR", "USUARIO", "MONTO", "FECHA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(5, 418, 664, 125);
		panel.add(scrollPane_1);
		
		tableDetalle = new JTable();
		tableDetalle.setFont(new Font("Arial", Font.PLAIN, 14));
		tableDetalle.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID COMPRA", "ID ARTICULO", "CANTIDAD", "PRECIO UNITARIO"
			}
		));
		scrollPane_1.setViewportView(tableDetalle);
		
		JLabel lblOrdenarPor = new JLabel("Ordenar por:");
		lblOrdenarPor.setFont(new Font("Arial", Font.PLAIN, 15));
		lblOrdenarPor.setBounds(5, 94, 88, 23);
		panel.add(lblOrdenarPor);
		
		
		cbxPrimary.setFont(new Font("Arial", Font.PLAIN, 11));
		cbxPrimary.setModel(new DefaultComboBoxModel(new String[] {"ID COMPRA", "PROVEEDOR", "USUARIO", "MONTO", "FECHA"}));
		cbxPrimary.setBounds(93, 97, 99, 20);
		panel.add(cbxPrimary);
		
		JLabel lblOrden = new JLabel("Orden:");
		lblOrden.setFont(new Font("Arial", Font.PLAIN, 15));
		lblOrden.setBounds(210, 94, 45, 23);
		panel.add(lblOrden);
		
		
		cbxOrden.setFont(new Font("Arial", Font.PLAIN, 11));
		cbxOrden.setModel(new DefaultComboBoxModel(new String[] {"ASCENDENTE", "DESCENDENTE"}));
		cbxOrden.setBounds(257, 97, 120, 20);
		panel.add(cbxOrden);
		
		JLabel lblPendiente = new JLabel("Usuario:");
		lblPendiente.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPendiente.setBounds(387, 94, 59, 23);
		panel.add(lblPendiente);
		
		
		cbxUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		cbxUsuario.setBounds(445, 97, 88, 20);
		panel.add(cbxUsuario);
		
		JLabel lblRango = new JLabel("Rango:");
		lblRango.setFont(new Font("Arial", Font.PLAIN, 15));
		lblRango.setBounds(543, 94, 47, 23);
		panel.add(lblRango);
		
		
		cbxRango.setFont(new Font("Arial", Font.PLAIN, 11));
		cbxRango.setModel(new DefaultComboBoxModel(new String[] {"DIA", "MES", "A\u00D1O"}));
		cbxRango.setBounds(592, 97, 77, 20);
		panel.add(cbxRango);
		
		Image imgSalir = new ImageIcon(Login.class.getResource("/Imagenes/imagenSalir.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	    btnSalir = new JButton("Volver");
	    btnSalir.setToolTipText("Pulsa para salir de Vender");
		btnSalir.setIcon(new ImageIcon(imgSalir));
		btnSalir.setBounds(10, 11, 107, 43);
		panel.add(btnSalir);
		
	}

}
