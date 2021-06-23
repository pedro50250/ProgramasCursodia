package interfaces_Administrador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaces_Usuario.Login;
import interfaces_Usuario.Origen;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Menu extends JFrame implements ActionListener{

	private JPanel panelMenu;
	JButton btnVolver;
	JButton btnVender;
	JButton btnVerBoletos;
	JButton btnCortes;
	JButton btnAgregarVuelos;
	JButton btnAgregarDestinos;
	JButton btnAgregarUsuarios;
	JButton btnEliminarUsuarios;
	JButton btnEliminarVuelos;
	JButton btnEliminarDestinos;
	int id_Usuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu()
	{
		
	}
	public Menu(int id_Usuario) {
		try{
		    UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch(Exception e){
		    System.out.println(e);
		}
		this.id_Usuario = id_Usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 475);
		panelMenu = new JPanel();
		//panelMenu.setBackground(Color.CYAN);
		panelMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelMenu);
		panelMenu.setLayout(null);
		
		btnVolver = new JButton("Salir");
		btnVolver.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setBounds(10, 11, 89, 23);
		btnVolver.addActionListener(this);
		panelMenu.add(btnVolver);
		
		JLabel lblAdminstrador = new JLabel("Administrador");
		lblAdminstrador.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblAdminstrador.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminstrador.setBounds(121, 16, 319, 59);
		panelMenu.add(lblAdminstrador);
		
		btnVender = new JButton("Vender");
		btnVender.setBounds(26, 96, 145, 73);
		btnVender.addActionListener(this);
		panelMenu.add(btnVender);
		
		btnVerBoletos = new JButton("Ver Boletos Vendidos");
		btnVerBoletos.setBounds(244, 96, 145, 73);
		btnVerBoletos.addActionListener(this);
		panelMenu.add(btnVerBoletos);
		
		btnCortes = new JButton("Cortes");
		btnCortes.setBounds(460, 96, 145, 73);
		btnCortes.addActionListener(this);
		panelMenu.add(btnCortes);
		
		btnAgregarVuelos = new JButton("Agregar Vuelos");
		btnAgregarVuelos.setBounds(26, 197, 145, 73);
		btnAgregarVuelos.addActionListener(this);
		panelMenu.add(btnAgregarVuelos);
		
		btnAgregarDestinos = new JButton("Agregar Destinos");
		btnAgregarDestinos.setBounds(460, 197, 139, 73);
		btnAgregarDestinos.addActionListener(this);
		panelMenu.add(btnAgregarDestinos);
		
		btnAgregarUsuarios = new JButton("Agregar Usuarios");
		btnAgregarUsuarios.setBounds(26, 306, 145, 73);
		btnAgregarUsuarios.addActionListener(this);
		panelMenu.add(btnAgregarUsuarios);
		
		btnEliminarUsuarios = new JButton("Eliminar Usuarios");
		btnEliminarUsuarios.setBounds(244, 306, 145, 73);
		btnEliminarUsuarios.addActionListener(this);
		panelMenu.add(btnEliminarUsuarios);
		
		btnEliminarVuelos = new JButton("Eliminar Vuelos");
		btnEliminarVuelos.setBounds(244, 197, 145, 70);
		btnEliminarVuelos.addActionListener(this);
		panelMenu.add(btnEliminarVuelos);
		
		btnEliminarDestinos = new JButton("Eliminar Destinos");
		btnEliminarDestinos.setBounds(467, 306, 132, 73);
		btnEliminarDestinos.addActionListener(this);
		panelMenu.add(btnEliminarDestinos);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver)
		{
			dispose();
			Login log = new Login();
			log.setLocationRelativeTo(null);
			log.setVisible(true);
		}
		if(e.getSource()==btnVender)
		{
			this.dispose();
			 Origen ori = new Origen(id_Usuario);
			 ori.setLocationRelativeTo(null);
			 ori.setVisible(true);
		}
		if(e.getSource()==btnVerBoletos)
		{
			dispose();
			VerBoletos ver = new VerBoletos(id_Usuario);
			ver.setLocationRelativeTo(null);
			ver.setVisible(true);
					
		}
		if(e.getSource()==btnAgregarVuelos)
		{
			dispose();
			AgregarVuelos agre = new AgregarVuelos(id_Usuario);
			agre.setLocationRelativeTo(null);
			agre.setVisible(true);
		}
		if(e.getSource()==btnAgregarDestinos)
		{
			dispose();
			AgregarDestinos agre = new AgregarDestinos(id_Usuario);
			agre.setResizable(false);
			agre.setLocationRelativeTo(null);
			agre.setVisible(true);
		}
		if(e.getSource()==btnEliminarDestinos)
		{
			dispose();
			BorrarDestino eli = new BorrarDestino(id_Usuario);
			eli.setResizable(false);
			eli.setLocationRelativeTo(null);
			eli.setVisible(true);
		}
		if(e.getSource()==btnEliminarVuelos)
		{
			dispose();
			BorrarVuelo vue = new BorrarVuelo(id_Usuario);
			vue.setResizable(false);
			vue.setLocationRelativeTo(null);
			vue.setVisible(true);
			
		}
		if(e.getSource()==btnAgregarUsuarios)
		{
			dispose();
			AgregarUsuarios agre = new AgregarUsuarios(id_Usuario);
			agre.setResizable(false);
			agre.setLocationRelativeTo(null);
			agre.setVisible(true);
		}
		if(e.getSource()==btnEliminarUsuarios)
		{
			dispose();
			EliminarUsuarios eli = new EliminarUsuarios(id_Usuario);
			eli.setResizable(false);
			eli.setLocationRelativeTo(null);
			eli.setVisible(true);
		}
		if(e.getSource()==btnCortes)
		{
			dispose();
			Cortes cor = new Cortes(id_Usuario);
			cor.setResizable(false);
			cor.setLocationRelativeTo(null);
			cor.setVisible(true);
		}
		
	}
	
	
}
