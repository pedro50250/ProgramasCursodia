package Sesion3;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class VistaChat extends JFrame {

	private JPanel panelChat;
	public JTextField txtMensaje;
	public JTable tabla;
	public JButton btnEnviarMensaje;
	public JButton btnOnOff;
	public JTextPane txtAreaMensajes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaChat frame = new VistaChat();
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
	public VistaChat() {
		
		try{
		    UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
		} catch(Exception e){
		    System.out.println(e);
		}
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 600);
		panelChat = new JPanel();
		panelChat.setBackground(new Color(173, 216, 230));
		panelChat.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelChat);
		panelChat.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Chat ");
		lblTitulo.setBackground(Color.LIGHT_GRAY);
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setToolTipText("Estas dentro del mejor chat que puede existir\r\n");
		lblTitulo.setBounds(138, 21, 192, 66);
		panelChat.add(lblTitulo);
		
		txtAreaMensajes = new JTextPane();
		txtAreaMensajes.setBounds(21, 98, 389, 249);
		//panelChat.add(txtAreaMensajes);
		JScrollPane scroll = new JScrollPane(txtAreaMensajes);
		scroll.setBounds(21, 98, 478, 374);
		panelChat.add(scroll);
		
		txtMensaje = new JTextField();
		txtMensaje.setBounds(21, 508, 478, 42);
		panelChat.add(txtMensaje);
		txtMensaje.setColumns(10);
		
		JLabel lblMensaje = new JLabel("Escribe tu Mensaje:");
		lblMensaje.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblMensaje.setBounds(21, 483, 148, 14);
		panelChat.add(lblMensaje);
		
		btnEnviarMensaje = new JButton("Enviar");
		btnEnviarMensaje.setBounds(523, 508, 111, 42);
		panelChat.add(btnEnviarMensaje);
		
		String dataValues[][] = {};
		String[] nombreColumnas = {"Conectados"};
		DefaultTableModel dtm= new DefaultTableModel(dataValues, nombreColumnas)
		{
			private static final long serialVersionUID = -8918525348329721933L;

			@Override
		    public boolean isCellEditable(int row, int column)
		    {
		       //all cells false
		       return false;
		    }
		};
		tabla = new JTable(dtm);
		JScrollPane scrol = new JScrollPane(tabla);
		scrol.setBounds(523, 99, 111, 374);
		panelChat.add(scrol);
		
		Image imgUsuarios = new ImageIcon(VistaChat.class.getResource("/imagenes/imagenUsuario.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(imgUsuarios));
		lblIcono.setBounds(298, 0, 111, 87);
		panelChat.add(lblIcono);
		
		btnOnOff = new JButton("On/Off");
		btnOnOff.setForeground(Color.RED);
		btnOnOff.setBackground(Color.RED);
		btnOnOff.setBounds(21, 21, 107, 56);
		panelChat.add(btnOnOff);
	}
}
