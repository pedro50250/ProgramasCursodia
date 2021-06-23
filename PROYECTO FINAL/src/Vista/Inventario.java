package Vista;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class Inventario extends JFrame {

	private JPanel Panel;
	public JTable table;
	@SuppressWarnings("rawtypes")
	public JComboBox cbxExistencias;
	@SuppressWarnings("rawtypes")
	public JComboBox cbxProveedor;
	
	public JButton btnElegirProv;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Inventario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 458, 512);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/iconoTienda.png")));
		setTitle("Inventario");
		Panel = new JPanel();
		Panel.setBackground(new Color(173, 216, 230));
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);
		Panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 422, 296);
		Panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOMBRE", "PRECIO", "CATEGORIA", "PROVEEDOR", "STOCK"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(22);
		table.getColumnModel().getColumn(2).setPreferredWidth(48);
		table.getColumnModel().getColumn(3).setPreferredWidth(69);
		table.getColumnModel().getColumn(4).setPreferredWidth(71);
		table.getColumnModel().getColumn(5).setPreferredWidth(43);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		cbxExistencias = new JComboBox();
		cbxExistencias.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Existencias", "Agotados"}));
		cbxExistencias.setFont(new Font("Arial", Font.PLAIN, 15));
		cbxExistencias.setBounds(10, 77, 100, 25);
		Panel.add(cbxExistencias);
		
		cbxProveedor = new JComboBox();
		cbxProveedor.setModel(new DefaultComboBoxModel(new String[] {"Todos"}));
		cbxProveedor.setFont(new Font("Arial", Font.PLAIN, 15));
		cbxProveedor.setBounds(120, 77, 100, 25);
		Panel.add(cbxProveedor);
		
		btnElegirProv = new JButton("Agregar al Carrito");
		btnElegirProv.setFont(new Font("Arial", Font.PLAIN, 15));
		btnElegirProv.setBounds(230, 77, 202, 25);
		Panel.add(btnElegirProv);
		
		JLabel lblNewLabel = new JLabel("Articulos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 52, 100, 20);
		Panel.add(lblNewLabel);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblProveedor.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProveedor.setBounds(120, 52, 100, 20);
		Panel.add(lblProveedor);
		
		JLabel lblComprarAlProveedor = new JLabel("Articulo Seleccionado");
		lblComprarAlProveedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblComprarAlProveedor.setFont(new Font("Arial", Font.PLAIN, 15));
		lblComprarAlProveedor.setBounds(230, 52, 202, 20);
		Panel.add(lblComprarAlProveedor);
		
		JLabel lblNewLabel_1 = new JLabel("Inventario");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(10, 11, 422, 40);
		Panel.add(lblNewLabel_1);
		
		
	}
}
