package interfaces_Usuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.ClaseHorario;
import clases.Horario;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;

public class Horarios extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private JPanel panelHorarios;
	int[] rbtnSize = new int[] { 150, 40 };
	int[] btnSize = new int[] { 150, 40 };
	int[] pOrigen = new int[] { 5, 5};
	int[] margen = new int[] {5,15};
	String Origen;
	String Destino;
	JButton btnVolver;
	JButton btnAceptar;
	ArrayList<ClaseHorario> horarios = new ArrayList<>();
	ArrayList<JRadioButton> vuelos = new ArrayList<>();
	ArrayList<JButton> detalle = new ArrayList<>();
	ButtonGroup grupoRadio;
	int idUsuario;
	Time entrada = null;
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Horarios frame = new Horarios();
					Origen = "Monterrey";
					Destino = "Guadalajara";
					frame.verHorarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public Horarios() {};
	
	public Horarios(String Origen,String Destino,int idUsuario)
	{
		this.Origen = Origen;
		this.Destino = Destino;
		this.idUsuario = idUsuario;
		verHorarios();
		this.setSize(578, 477);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	private void verHorarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 467);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 11, 89, 23);
		btnVolver.addActionListener(this);
		contentPane.add(btnVolver);
		
		JLabel lblHorarios = new JLabel("Horarios Disponibles");
		lblHorarios.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblHorarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblHorarios.setBounds(74, 45, 382, 52);
		contentPane.add(lblHorarios);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setFont(new Font("Arial", Font.PLAIN, 14));
		lblOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrigen.setBounds(10, 112, 103, 32);
		contentPane.add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDestino.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestino.setBounds(253, 111, 103, 36);
		contentPane.add(lblDestino);
		
		txtOrigen = new JTextField();
		txtOrigen.setEditable(false);
		txtOrigen.setBounds(119, 112, 103, 32);
		txtOrigen.setText(Origen);
		contentPane.add(txtOrigen);
		txtOrigen.setColumns(10);
		
		txtDestino = new JTextField();
		txtDestino.setEditable(false);
		txtDestino.setBounds(353, 113, 103, 32);
		txtDestino.setText(Destino);
		contentPane.add(txtDestino);
		txtDestino.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(74, 175, 400, 198);
		contentPane.add(scrollPane);
		
		
		panelHorarios = new JPanel();
		panelHorarios.setLayout(null);
		añadirHorarios();
		scrollPane.setViewportView(panelHorarios);
		scrollPane.getViewport().setView(panelHorarios);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnAceptar.setBounds(403, 384, 139, 33);
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar);
		
	}
	
	private void añadirHorarios()
	{
		
		
		Horario hor = new Horario();
		horarios =hor.extraerHorarios(Origen, Destino);
		for(int i=0;i<horarios.size();i++)
		{
			vuelos.add(new JRadioButton(""+horarios.get(i).sale));
			detalle.add(new JButton("Detalles"));		
		}
		crearPanelHorarios();
	}
	
	private void crearPanelHorarios()
	{
		grupoRadio = new ButtonGroup();
		panelHorarios.setPreferredSize(new Dimension(400,500));
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		Time hora = Time.valueOf(hourFormat.format(date));
		int linea = pOrigen[1];
		for(int i =0;i<horarios.size();i++)
		{
			
			if (horarios.get(i).sale.after(hora)) {
				vuelos.get(i).setBounds(pOrigen[0], linea, rbtnSize[0], rbtnSize[1]);
				grupoRadio.add(vuelos.get(i));
				panelHorarios.add(vuelos.get(i));
				detalle.get(i).setBounds(pOrigen[0] + rbtnSize[0] + margen[0], linea, btnSize[0], btnSize[1]);
				int indice = i;
				detalle.get(i).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Id Vuelo: " + horarios.get(indice).id_vuelo
								+ "\nId Avion: " + horarios.get(indice).id_avion + "\nCapitan del Vuelo: "
								+ horarios.get(indice).nom_cap + "\nCapacidad del Vuelo: " + horarios.get(indice).capa
								+ "\nCiudad Origen: " + horarios.get(indice).origenn + "\nCiudad Destino: "
								+ horarios.get(indice).destinoo + "\nHorario Salida: " + horarios.get(indice).sale
								+ "\nHorario Llegada: " + horarios.get(indice).llega);
					}
				});
				panelHorarios.add(detalle.get(i));
				linea += rbtnSize[1] + margen[1];
			}

		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver)
		{
			Destino des = new Destino(Origen,idUsuario);
			des.setVisible(true);
			dispose();
		}
		if(e.getSource()==btnAceptar)
		{
			boolean seleccionado = false;
			for(int i = 0;i<horarios.size();i++)
			{
				if( vuelos.get(i).isSelected() )
				{
					seleccionado=true;
					this.dispose();
					Seleccion_Boletos sele = new Seleccion_Boletos(horarios.get(i).id_vuelo,Origen,Destino,idUsuario);
					//sele.setVisible(true);
					
				}
			}
			if(seleccionado==false)
			{
				JOptionPane.showMessageDialog(null, "Debes elegir un horario  primero");
			}
			
		}
		
	}
}
