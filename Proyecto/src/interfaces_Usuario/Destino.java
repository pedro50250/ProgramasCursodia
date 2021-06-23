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

public class Destino extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	JPanel panelCiudades;
	int[] btnSize = new int[] { 580, 80 };
	int[] pOrigen = new int[] { 5, 5 };
	int margen = 15;
	private JTextField txtBuscar;
	String origen;
	public ArrayList<String> nomciudades = new ArrayList<String>();
	public ArrayList<JButton> ciudades = new ArrayList<JButton>();
	private JButton  btnBuscar, btnVolver;
	int indiceBuscado;
	boolean cerrar = false;
	int idUsuario;


	public Destino(String origen,int idUsuario) {
		this.idUsuario = idUsuario;
		this.origen = origen;
		crearPanelDestino();
		this.setResizable(false);
		this.setLocationRelativeTo(null);

	}

	public Destino() {
		// TODO Auto-generated constructor stub
	}

	public void crearPanelDestino() {
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setViewportView(panelPrincipal);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 491);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);

		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnVolver.setBounds(0, 11, 89, 32);
		btnVolver.addActionListener(this);
		panelPrincipal.add(btnVolver);

		JLabel lblEligeCiudad = new JLabel("Eliga una Ciudad de Destino");
		lblEligeCiudad.setForeground(Color.RED);
		lblEligeCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeCiudad.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblEligeCiudad.setBounds(164, 11, 345, 57);
		panelPrincipal.add(lblEligeCiudad);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(36, 113, 610, 282);
		panelPrincipal.add(scrollPane);

		panelCiudades = new JPanel();
		// crearPanelCiudades();
		agregarCiudades();
		panelCiudades.setLayout(null);
		scrollPane.setViewportView(panelCiudades);
		scrollPane.getViewport().setView(panelCiudades);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(471, 82, 86, 20);
		panelPrincipal.add(txtBuscar);
		txtBuscar.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(557, 79, 89, 23);
		btnBuscar.addActionListener(this);
		panelPrincipal.add(btnBuscar);

		JLabel lblfondo = new JLabel("");
		lblfondo.setIcon(new ImageIcon(Destino.class.getResource("/fotos/fondo.jpg")));
		lblfondo.setBounds(0, 0, 646, 441);
		panelPrincipal.add(lblfondo);

	}

	private void agregarCiudades() {
		Ciudad ciu = new Ciudad();
		nomciudades = ciu.extraerCiudades();
		agregarAlPanel();
	}

	private void agregarAlPanel() {

		panelCiudades.setPreferredSize(new Dimension(580, 500));
		for (int i = 0; i < nomciudades.size(); i++) {
			ciudades.add(new JButton("" + nomciudades.get(i)));
		}
		int linea = pOrigen[1];
		for (int i = 0; i < ciudades.size(); i++) {
			if (ciudades.get(i).getText().equals(origen)) {

			} else {
				ciudades.get(i).setBounds(pOrigen[0], linea, btnSize[0], btnSize[1]);
				;
				linea += btnSize[1] + margen;
				int index = i;
				ciudades.get(i).addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						Horarios hor = new Horarios(origen,ciudades.get(index).getText(),idUsuario);
						hor.setVisible(true);
					}
				});
				panelCiudades.add(ciudades.get(i));
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVolver) {
			Origen origen = new Origen(idUsuario);
			dispose();
			origen.setVisible(true);
		}

		if (e.getSource() == btnBuscar) {
			String ciudad_Buscada = txtBuscar.getText();
			boolean encontrada = false;
			for (int i = 0; i < ciudades.size(); i++) {
				if (ciudades.get(i).getText().equals(ciudad_Buscada)) {
					if (ciudad_Buscada.equals(origen)) {

					} else {
						encontrada = true;
						indiceBuscado = i;
					}
				}
			}
			if (encontrada) {
				mostrarBuscado(indiceBuscado);
			} else {
				JOptionPane.showMessageDialog(null, "No pudimos encontrar esa ciudad");
			}
		}

	}

	private void mostrarBuscado(int indice) {
		panelCiudades.removeAll();
		panelCiudades.updateUI();
		ciudades.get(indice).setBounds(pOrigen[0], pOrigen[1], btnSize[0], btnSize[1]);
		panelCiudades.add(ciudades.get(indice));
	}

}
