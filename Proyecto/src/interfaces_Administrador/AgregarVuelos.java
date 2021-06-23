package interfaces_Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Vuelo;
import clases.claseVuelo;

import javax.swing.JButton;

public class AgregarVuelos extends JFrame implements ActionListener{

	private JPanel panelVuelos;
	JTable Tabla;
	private JButton btnVolver;
	private JButton btnRestablecer;
	private JButton btnPorCiudad;
	private JButton btnPorHorario;
	private JButton btnPorCapitan;
	public int id_Usuario;
	DefaultTableModel model;
	ArrayList<claseVuelo> vuelos = new ArrayList<claseVuelo>();
	private JButton btnPorAvion;
	private JButton btnAgregar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarVuelos frame = new AgregarVuelos(2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AgregarVuelos()
	{
		
	}
	public AgregarVuelos(int id_usuario) {
		this.id_Usuario = id_usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 443);
		panelVuelos = new JPanel();
		panelVuelos.setLayout(null);
		panelVuelos.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelVuelos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 659, 292);
		panelVuelos.add(scrollPane);
		
		Tabla = new JTable();
		Tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Vuelo", "ID Avion", "Capitan Vuelo","Capacidad Vuelo","Origen","Destino","Horario Salida","Hora Llegada"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class,String.class,Integer.class, String.class,String.class,String.class,String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(Tabla);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 11, 89, 23);
		btnVolver.addActionListener(this);
		panelVuelos.add(btnVolver);
		
		btnRestablecer = new JButton("Restablecer");
		btnRestablecer.setBounds(112, 11, 89, 23);
		btnRestablecer.addActionListener(this);
		panelVuelos.add(btnRestablecer);
		
		btnPorCiudad = new JButton("Por Ciudad");
		btnPorCiudad.setBounds(214, 11, 89, 23);
		btnPorCiudad.addActionListener(this);
		panelVuelos.add(btnPorCiudad);
		
		btnPorHorario = new JButton("Por Horario");
		btnPorHorario.setBounds(313, 11, 89, 23);
		btnPorHorario.addActionListener(this);
		panelVuelos.add(btnPorHorario);
		
		btnPorCapitan = new JButton("Por Capitan");
		btnPorCapitan.setBounds(412, 11, 89, 23);
		btnPorCapitan.addActionListener(this);
		panelVuelos.add(btnPorCapitan);
		
		btnPorAvion = new JButton("Por Avion");
		btnPorAvion.setBounds(511, 11, 89, 23);
		btnPorAvion.addActionListener(this);
		panelVuelos.add(btnPorAvion);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(615, 11, 89, 23);
		btnAgregar.addActionListener(this);
		panelVuelos.add(btnAgregar);
		
		agregarFilas();
	}
	
	public void agregarFilas()
	{
		Vuelo vue = new Vuelo();
		vuelos = vue.extraerVuelos();
		model = (DefaultTableModel) Tabla.getModel();
		for(int i=0;i<vuelos.size();i++)
		{
			model.addRow(new Object[] {vuelos.get(i).id_vuelo,vuelos.get(i).id_avion,vuelos.get(i).capitan,vuelos.get(i).capacidad
					,vuelos.get(i).Origen,vuelos.get(i).Destino,vuelos.get(i).HoraSalida,vuelos.get(i).HoraLlegada});
		}
	}
	public void agregarFilasCiudad(String Ciudad)
	{
		model.setRowCount(0);
		for(int i=0;i<vuelos.size();i++)
		{
			if(vuelos.get(i).Origen.equals(Ciudad))
			{
				model.addRow(new Object[] {vuelos.get(i).id_vuelo,vuelos.get(i).id_avion,vuelos.get(i).capitan,vuelos.get(i).capacidad
						,vuelos.get(i).Origen,vuelos.get(i).Destino,vuelos.get(i).HoraSalida,vuelos.get(i).HoraLlegada});
			}
		}
	}
	
	public void agregarFilasHorario(String Horario)
	{
		model.setRowCount(0);
		for(int i=0;i<vuelos.size();i++)
		{
			if(vuelos.get(i).HoraSalida.equals(Horario))
			{
				model.addRow(new Object[] {vuelos.get(i).id_vuelo,vuelos.get(i).id_avion,vuelos.get(i).capitan,vuelos.get(i).capacidad
						,vuelos.get(i).Origen,vuelos.get(i).Destino,vuelos.get(i).HoraSalida,vuelos.get(i).HoraLlegada});
			}
		}
	}
	
	public void agregarFilasCapitan(String Capitan)
	{
		model.setRowCount(0);
		for(int i=0;i<vuelos.size();i++)
		{
			if(vuelos.get(i).capitan.equals(Capitan))
			{
				model.addRow(new Object[] {vuelos.get(i).id_vuelo,vuelos.get(i).id_avion,vuelos.get(i).capitan,vuelos.get(i).capacidad
						,vuelos.get(i).Origen,vuelos.get(i).Destino,vuelos.get(i).HoraSalida,vuelos.get(i).HoraLlegada});
			}
		}
	}
	
	public void agregarFilasAvion(int id)
	{
		model.setRowCount(0);
		for(int i=0;i<vuelos.size();i++)
		{
			if(vuelos.get(i).id_avion==id)
			{
				model.addRow(new Object[] {vuelos.get(i).id_vuelo,vuelos.get(i).id_avion,vuelos.get(i).capitan,vuelos.get(i).capacidad
						,vuelos.get(i).Origen,vuelos.get(i).Destino,vuelos.get(i).HoraSalida,vuelos.get(i).HoraLlegada});
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver)
		{
			dispose();
			Menu menu = new Menu(id_Usuario);
			menu.setLocationRelativeTo(null);
			menu.setVisible(true);
		}
		if(e.getSource()==btnRestablecer)
		{
			model.setRowCount(0);
			agregarFilas();
		}
		if(e.getSource()==btnPorCiudad)
		{
			String Ciudad = JOptionPane.showInputDialog("Ingrese la Ciudad: ");
			boolean encontrada =false;
			for(int i =0;i<vuelos.size();i++)
			{
				if(vuelos.get(i).Origen.equals(Ciudad))
				{
					encontrada = true;
				}
			}
			if(encontrada)
			{
				agregarFilasCiudad(Ciudad);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No se encontro esa Ciudad");
			}
		}
		if(e.getSource()==btnPorHorario)
		{
			String Horario = JOptionPane.showInputDialog("Ingrese el Horario: ");
			boolean encontrada =false;
			for(int i =0;i<vuelos.size();i++)
			{
				if(vuelos.get(i).HoraSalida.equals(Horario))
				{
					encontrada = true;
				}
			}
			if(encontrada)
			{
				agregarFilasHorario(Horario);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No se encontro ningun vuelo con ese Horario intenta 00:00:00");
			}
		}
		if(e.getSource()==btnPorCapitan)
		{
			String Capitan = JOptionPane.showInputDialog("Ingrese el Capitan: ");
			boolean encontrada =false;
			for(int i =0;i<vuelos.size();i++)
			{
				if(vuelos.get(i).capitan.equals(Capitan))
				{
					encontrada = true;
				}
			}
			if(encontrada)
			{
				agregarFilasCapitan(Capitan);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No se encontro ningun vuelo con ese Capitan");
			}
		}
		if(e.getSource()==btnPorAvion)
		{
			try {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id del avion: "));
				boolean encontrada = false;
				for (int i = 0; i < vuelos.size(); i++) {
					if (vuelos.get(i).id_avion == id) {
						encontrada = true;
					}
				}
				if (encontrada) {
					agregarFilasAvion(id);
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro ningun avion con ese id");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error en la captura dl id avion");
			}
		}
		if(e.getSource()==btnAgregar)
		{
			try {
				int id_avion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del avion: "));
				String nomCapitan = JOptionPane.showInputDialog("Ingresa el nombre del capitan: ");
				String Origen = JOptionPane.showInputDialog("Ciudad Origen:");
				String Destino = JOptionPane.showInputDialog("Ingresa Ciudad Destino");
				String horaSali = JOptionPane.showInputDialog("Hora de salida (hh:mm:ss): ");
				Time horaSalida = Time.valueOf(horaSali);
				String horaLle = JOptionPane.showInputDialog("Hora de llegada (hh:mm:ss): ");
				Time horaLlegada = Time.valueOf(horaLle);
				Vuelo vue = new Vuelo();
				vue.insertarVuelo(id_avion, nomCapitan, Origen, Destino, horaSalida, horaLlegada);
				model.setRowCount(0);
				agregarFilas();
				
			}
			catch(Exception e3)
			{
				JOptionPane.showMessageDialog(null, "Ocurrio un error en la captura de los datos del vuelo");
			}
		}
		
	}

}
