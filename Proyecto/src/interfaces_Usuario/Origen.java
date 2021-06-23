package interfaces_Usuario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Ciudad;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Color;

public class Origen extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	JPanel panelCiudades;
	int[] btnSize = new int[] { 580, 80 };
	int[] pOrigen = new int[] { 5, 5 };
	int margen = 15;
	private JTextField txtBuscar;
	JButton btnSalir, btnBuscar;
	public ArrayList<JButton> ciudades = new ArrayList<JButton>();
	public ArrayList<String> nomCiudades = new ArrayList<String>();
	private JButton btnCerra;
	int indiceBuscado;
	int idUsuario;

	public Origen()
	{
		
	}
	
	public Origen(int idUsuario) {
		this.idUsuario = idUsuario;
		setLocationRelativeTo(null);
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setViewportView(panelPrincipal);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 491);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(204, 204, 204));
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnSalir.setBounds(0, 11, 89, 32);
		btnSalir.addActionListener(this);
		panelPrincipal.add(btnSalir);

		JLabel lblEligeCiudad = new JLabel("Eliga una Ciudad de Origen");
		lblEligeCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeCiudad.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblEligeCiudad.setBounds(164, 11, 345, 57);
		panelPrincipal.add(lblEligeCiudad);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(34, 113, 610, 282);
		panelPrincipal.add(scrollPane);

		panelCiudades = new JPanel();
		// crearPanelCiudades();
		panelCiudades.setLayout(null);
		agregarCiudades();
		scrollPane.setViewportView(panelCiudades);
		scrollPane.getViewport().setView(panelCiudades);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(471, 82, 86, 20);
		panelPrincipal.add(txtBuscar);
		txtBuscar.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(557, 79, 89, 23);
		btnBuscar.addActionListener(this);

		JLabel lbfondo = new JLabel("");
		lbfondo.setIcon(new ImageIcon(Origen.class.getResource("/fotos/fondo1.png")));
		lbfondo.setBounds(0, 0, 646, 452);
		panelPrincipal.add(lbfondo);
		panelPrincipal.add(btnBuscar);

		btnCerra = new JButton("CerrarVentana");
		btnCerra.setBounds(557, 418, 89, 23);
		btnCerra.addActionListener(this);
		panelPrincipal.add(btnCerra);

	}

	

	private void agregarCiudades() {
		/*for (int i = 0; i < 5; i++) {
			nomCiudades.add("Ciudad" + i);
		}*/
		Ciudad ciu = new Ciudad();
		nomCiudades = ciu.extraerCiudades();
		agregarAlPanel();
	}

	private void agregarAlPanel() {
		panelCiudades.setPreferredSize(new Dimension(580, 500));
		for (int i = 0; i < nomCiudades.size(); i++) {
			ciudades.add(new JButton("" + nomCiudades.get(i)));
		}
		int linea = pOrigen[1];
		for (int i = 0; i < ciudades.size(); i++) {

			ciudades.get(i).setBounds(pOrigen[0], linea, btnSize[0], btnSize[1]);
			;
			linea += btnSize[1] + margen;
			int index = i;
			ciudades.get(i).addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Destino des = new Destino(ciudades.get(index).getText(),idUsuario);
					des.setVisible(true);
					dispose();
				}
			});
			panelCiudades.add(ciudades.get(i));
		}
	}

	private void mostrarBuscado(int indice)
	{
		panelCiudades.removeAll();
		panelCiudades.updateUI();
		ciudades.get(indice).setBounds(pOrigen[0], pOrigen[1], btnSize[0], btnSize[1]);
		panelCiudades.add(ciudades.get(indice));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			dispose();
			Login log = new Login();
			log.setResizable(false);
			log.setLocationRelativeTo(null);
			log.setVisible(true);
		}
		
		if(e.getSource() == btnBuscar)
		{
			String ciudad_Buscada = txtBuscar.getText();
			boolean encontrada = false;
			for(int i = 0;i<ciudades.size();i++)
			{
				if(ciudades.get(i).getText().equals(ciudad_Buscada))
				{
					encontrada = true;
					indiceBuscado = i;
				}
			}
			if(encontrada)
			{
				mostrarBuscado(indiceBuscado);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No pudimos encontrar esa ciudad");
			}
		}
		
	}

}
