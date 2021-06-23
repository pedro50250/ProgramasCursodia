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

import clases.Boleto;
import clases.Cliente;
import clases.claseBoleto;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VerBoletos extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTable Tabla;
	private JButton btnVolver;
	private JButton btnPorDia;
	private JButton btnRestablecer;
	private JButton btnPorCliente;
	private JButton btnIdCliente;
	int id_Usuario;
	DefaultTableModel model;
	ArrayList<claseBoleto> boletos = new ArrayList<claseBoleto>();
	private JButton btnDetalles;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerBoletos frame = new VerBoletos(2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VerBoletos(int id_Usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 45, 525, 263);
		contentPane.add(scrollPane);
		
		Tabla = new JTable();
		Tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Boleto", "ID Cliente", "Cantidad Boletos","Fecha de Compra","Hora de Vuelo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class,Integer.class, String.class,String.class
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
		
		btnPorDia = new JButton("Ver Por dia");
		btnPorDia.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnPorDia.setBounds(120, 11, 120, 23);
		btnPorDia.addActionListener(this);
		contentPane.add(btnPorDia);
		
		btnRestablecer = new JButton("Restablecer");
		btnRestablecer.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnRestablecer.setBounds(260, 11, 120, 23);
		btnRestablecer.addActionListener(this);
		contentPane.add(btnRestablecer);
		
		btnPorCliente = new JButton("Por Id Cliente");
		btnPorCliente.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnPorCliente.setBounds(390, 11, 140, 23);
		btnPorCliente.addActionListener(this);
		contentPane.add(btnPorCliente);
		
		btnIdCliente = new JButton("Nombre Cliente");
		btnIdCliente.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnIdCliente.setBounds(532, 11, 140, 23);
		btnIdCliente.addActionListener(this);
		contentPane.add(btnIdCliente);
		
		btnDetalles = new JButton("Ver Detalles");
		btnDetalles.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnDetalles.setBounds(571, 78, 103, 44);
		btnDetalles.addActionListener(this);
		contentPane.add(btnDetalles);
		agregarFilas();
		
	}
	
	public void agregarFilas()
	{
		Boleto bol = new Boleto();
		boletos = bol.extraerBoletos();
		model = (DefaultTableModel) Tabla.getModel();
		for(int i=0;i<boletos.size();i++)
		{
			model.addRow(new Object[] {boletos.get(i).idBoleto,boletos.get(i).idCliente,boletos.get(i).CantBoletos,
					boletos.get(i).fecha,boletos.get(i).hora});
		}
		
	}
	
	public void agregarFilasDia(String Dia)
	{
		model.setRowCount(0);
		for(int i=0;i<boletos.size();i++)
		{
			if(boletos.get(i).fecha.equals(Dia))
			{
				model.addRow(new Object[] {boletos.get(i).idBoleto,boletos.get(i).idCliente,boletos.get(i).CantBoletos,
						boletos.get(i).fecha,boletos.get(i).hora});
			}
		}
	}

	public void agregarFilasPorCliente(int id_cliente)
	{
		model.setRowCount(0);
		for(int i=0;i<boletos.size();i++)
		{
			if(boletos.get(i).idCliente==id_cliente)
			{
				model.addRow(new Object[] {boletos.get(i).idBoleto,boletos.get(i).idCliente,boletos.get(i).CantBoletos,
						boletos.get(i).fecha,boletos.get(i).hora});
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver)
		{
			dispose();
			Menu menu = new Menu(id_Usuario);
			menu.setVisible(true);
		}
		if(e.getSource()==btnPorDia)
		{
			String Dia = JOptionPane.showInputDialog("Ingrese la fecha buscada: ");
			boolean encontrada =false;
			for(int i =0;i<boletos.size();i++)
			{
				if(boletos.get(i).fecha.equals(Dia))
				{
					encontrada = true;
				}
			}
			if(encontrada)
			{
				agregarFilasDia(Dia);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No se encontro esa fecha ingresa yyyy-mm-dd");
			}
			
		}
		if(e.getSource()==btnRestablecer)
		{
			model.setRowCount(0);
			agregarFilas();
		}
		
		if (e.getSource() == btnPorCliente) {
			try {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id del cliente: "));
				boolean encontrada = false;
				for (int i = 0; i < boletos.size(); i++) {
					if (boletos.get(i).idCliente == id) {
						encontrada = true;
					}
				}
				if (encontrada) {
					agregarFilasPorCliente(id);
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro ningun cliente con ese id");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error en la captura del id");
			}

		}
		if(e.getSource()== btnIdCliente)
		{
			try
			{
				Cliente cli = new Cliente();
				int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del Cliente a buscar"));
				String nombre = cli.nombreCliente(idCliente);
				JOptionPane.showMessageDialog(null, "El nombre del cliente es: " + nombre);
				
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null, "Error en la captura de los datos");
			}
		}
		if(e.getSource()==btnDetalles)
		{
			dispose();
			VerDetalles detalles = new VerDetalles(id_Usuario);
			detalles.setResizable(false);
			detalles.setLocationRelativeTo(null);
			detalles.setVisible(true);
		}
		
		
	}
	
	
	

}
