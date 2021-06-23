package interfaces_Usuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Boleto;
import clases.Cliente;
import clases.DetalleVentas;
import clases.Horario;
import clases.Usuario;
import clases.Venta;
import clases.Vuelo;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Resumen_PagoTarjeta extends JFrame implements ActionListener {

	private JPanel panelResumen;
	private JTextField txtCantidad_Boletos;
	private JTextField txtCantidad_Pagar;
	private JTextField txtNombre_Cliente;
	private JTextField txtCorreo_Cliente;
	private JTextField txtTelefono_Cliente;
	private JTextField txtNum_Tarjeta;
	private JTextField txtMes_Venc;
	private JTextField txtCodigo_CCV;
	JButton btnPagar ,btnVolver;
	float total;
	int id_vuelo;
	String Origen, Destino;
	int cantNiños, nivNiños,cantAdultos,nivAdultos,cantMayores,nivMayores;
	Resumen_PagoTarjeta resum;
	int Suma;
	String hora;
	int idUsuario;
	//Panel panel;

	/**
	 * Launch the application.
	 */
	public Resumen_PagoTarjeta()
	{
		
	}
	public void Resu(int id_vuelo, String ori, String des, int suma, Resumen_PagoTarjeta resu, int cantNiños, int nivNiños,
			int cantAdultos, int nivAdultos, int cantMayores, int nivMayores,int idUsuario) {
		this.id_vuelo = id_vuelo;
		this.Origen = ori;
		this.Destino = des;
		this.Suma = suma;
		this.resum = resu;
		this.cantNiños = cantNiños;
		this.nivNiños = nivNiños;
		this.cantAdultos = cantAdultos;
		this.nivAdultos = nivAdultos;
		this.cantMayores = cantMayores;
		this.nivMayores = nivMayores;
		this.idUsuario = idUsuario;
		resum.crearGUI();
		resum.setLocationRelativeTo(null);
		resum.setSize(643, 428);
		resum.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public void crearGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 425);
		panelResumen = new JPanel();
		panelResumen.setVisible(true);
		panelResumen.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelResumen);
		panelResumen.setLayout(null);
		
		JLabel lblResumen = new JLabel("Resumen de la Venta");
		lblResumen.setHorizontalAlignment(SwingConstants.CENTER);
		lblResumen.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblResumen.setBounds(92, 11, 472, 66);
		panelResumen.add(lblResumen);
		
		JLabel lblCantidad = new JLabel("Cantidad Boletos");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCantidad.setBounds(314, 76, 135, 24);
		panelResumen.add(lblCantidad);
		
		JLabel lblCant_Pagar = new JLabel("Cantidad Pagar");
		lblCant_Pagar.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCant_Pagar.setBounds(314, 111, 135, 24);
		panelResumen.add(lblCant_Pagar);
		
		txtCantidad_Boletos = new JTextField();
		txtCantidad_Boletos.setBounds(459, 79, 86, 20);
		txtCantidad_Boletos.setText(""+Suma);
		txtCantidad_Boletos.setColumns(10);
		txtCantidad_Boletos.setEditable(false);
		panelResumen.add(txtCantidad_Boletos);
		
		txtCantidad_Pagar = new JTextField();
		txtCantidad_Pagar.setColumns(10);
		txtCantidad_Pagar.setBounds(459, 117, 86, 20);
	    total = calcularTotal(cantNiños,nivNiños,cantAdultos,nivAdultos,cantMayores,nivMayores);
		txtCantidad_Pagar.setEditable(false);
		txtCantidad_Pagar.setText(""+total);
		panelResumen.add(txtCantidad_Pagar);
		
		JLabel lblDatosDelCliente = new JLabel("Datos del Cliente");
		lblDatosDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelCliente.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblDatosDelCliente.setBounds(92, 149, 472, 66);
		panelResumen.add(lblDatosDelCliente);
		
		JLabel lblNombre = new JLabel("Nombre del Cliente");
		lblNombre.setBounds(20, 216, 117, 24);
		panelResumen.add(lblNombre);
		
		txtNombre_Cliente = new JTextField();
		txtNombre_Cliente.setText("");
		txtNombre_Cliente.setBounds(129, 216, 108, 20);
		panelResumen.add(txtNombre_Cliente);
		txtNombre_Cliente.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo del Cliente");
		lblCorreo.setBounds(20, 251, 117, 24);
		panelResumen.add(lblCorreo);
		
		txtCorreo_Cliente = new JTextField();
		txtCorreo_Cliente.setText("");
		txtCorreo_Cliente.setColumns(10);
		txtCorreo_Cliente.setBounds(129, 251, 108, 20);
		panelResumen.add(txtCorreo_Cliente);
		
		JLabel lblTelefono = new JLabel("Telefono del Cliente");
		lblTelefono.setBounds(20, 286, 117, 24);
		panelResumen.add(lblTelefono);
		
		txtTelefono_Cliente = new JTextField();
		txtTelefono_Cliente.setText("");
		txtTelefono_Cliente.setColumns(10);
		txtTelefono_Cliente.setBounds(129, 286, 108, 20);
		panelResumen.add(txtTelefono_Cliente);
		
		JLabel lblTarjeta = new JLabel("Num. Tarjeta");
		lblTarjeta.setBounds(313, 216, 117, 24);
		panelResumen.add(lblTarjeta);
		
		JLabel lblMes = new JLabel("Mes Vencimiento");
		lblMes.setBounds(313, 251, 117, 24);
		panelResumen.add(lblMes);
		
		JLabel lblCodigo = new JLabel("Codigo CCV");
		lblCodigo.setBounds(313, 286, 117, 24);
		panelResumen.add(lblCodigo);
		
		txtNum_Tarjeta = new JTextField();
		txtNum_Tarjeta.setText("");
		txtNum_Tarjeta.setColumns(10);
		txtNum_Tarjeta.setBounds(415, 218, 108, 20);
		panelResumen.add(txtNum_Tarjeta);
		
		txtMes_Venc = new JTextField();
		txtMes_Venc.setText("");
		txtMes_Venc.setColumns(10);
		txtMes_Venc.setBounds(415, 253, 108, 20);
		panelResumen.add(txtMes_Venc);
		
		txtCodigo_CCV = new JTextField();
		txtCodigo_CCV.setText("");
		txtCodigo_CCV.setColumns(10);
		txtCodigo_CCV.setBounds(415, 288, 108, 20);
		panelResumen.add(txtCodigo_CCV);
		
		btnPagar = new JButton("PAGAR");
		btnPagar.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnPagar.setBounds(459, 319, 117, 38);
		btnPagar.addActionListener(this);
		panelResumen.add(btnPagar);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setFont(new Font("Arial", Font.PLAIN, 14));
		lblOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrigen.setBounds(19, 81, 99, 14);
		panelResumen.add(lblOrigen);
		
		JLabel lblCiudad_Ori = new JLabel(":");
		lblCiudad_Ori.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCiudad_Ori.setBounds(128, 81, 99, 14);
		lblCiudad_Ori.setText(Origen);
		panelResumen.add(lblCiudad_Ori);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestino.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDestino.setBounds(20, 111, 99, 14);
		panelResumen.add(lblDestino);
		
		JLabel lblCiudad_Des = new JLabel(":");
		lblCiudad_Des.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCiudad_Des.setBounds(128, 116, 99, 14);
		lblCiudad_Des.setText(Destino);
		panelResumen.add(lblCiudad_Des);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setFont(new Font("Arial", Font.PLAIN, 14));
		lblHora.setBounds(20, 143, 99, 14);
		panelResumen.add(lblHora);
		
		JLabel lblHora_Vuelo = new JLabel(":");
		lblHora_Vuelo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblHora_Vuelo.setBounds(128, 149, 99, 14);
		Horario hor = new Horario();
		hora = hor.extraerHorario(id_vuelo);
		lblHora_Vuelo.setText(hora);
		panelResumen.add(lblHora_Vuelo);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnVolver.setBounds(10, 11, 89, 23);
		btnVolver.addActionListener(this);
		panelResumen.add(btnVolver);
		
		
	}
	public float calcularTotal(int cantNiños,int nivNiños, int cantAdultos, int nivAdultos, int cantMayores, int nivMayores)
	{
		float total=0;
		float total_niños=0;
		float total_adultos=0;
		float total_mayores=0;
		if(nivNiños==1)
		{
			total_niños = cantNiños*(840.54f);
		}
		if(nivNiños==2)
		{
			total_niños = cantNiños*(1120.31f);
		}
		if(nivAdultos==1)
		{
			total_adultos = cantAdultos*(950.70f);
		}
		if(nivAdultos==2)
		{
			total_adultos = cantAdultos*(1300.70f);
		}
		if(nivMayores==1)
		{
			total_mayores = cantMayores*(870.20f);
		}
		if(nivMayores==2)
		{
			total_mayores = cantMayores*(1200.20f);
		}
		total = total_niños + total_adultos + total_mayores;
		
		return total;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnVolver)
		{
			dispose();
			Seleccion_Boletos selec = new Seleccion_Boletos(id_vuelo,Origen,Destino,idUsuario);
		}
		if(e.getSource()==btnPagar)
		{
			try {
				String nombre  = txtNombre_Cliente.getText();
				String correo = txtCorreo_Cliente.getText();
			    long num = Long.parseLong(txtTelefono_Cliente.getText()); 
			    String numero = txtTelefono_Cliente.getText();
				long num_tar = Long.parseLong(txtNum_Tarjeta.getText());
				String tarjeta = txtNum_Tarjeta.getText();
				String mes_tar = txtMes_Venc.getText();
				int num_ccv = Integer.parseInt(txtCodigo_CCV.getText());
				Vuelo vue = new Vuelo();
				vue.restarCapacidadDisponible(id_vuelo, Suma);
				Cliente cli = new Cliente();
				int idCli = cli.insertarCliente(nombre, correo, numero, "tarjeta", tarjeta);
				Boleto bol = new Boleto();
				Calendar fecha = new GregorianCalendar();
				int año = fecha.get(Calendar.YEAR);
				int mes = fecha.get(Calendar.MONTH);
				int dia = fecha.get(Calendar.DAY_OF_MONTH);
				String  fec= "" + año +"-"+mes+"-"+dia;
				int id_boleto = bol.insertarBoleto(idCli, Suma, fec,hora);
				Venta ven = new Venta();
				int idVenta = ven.insertarVenta(id_boleto, id_vuelo, idUsuario, total);
				Usuario usu = new Usuario();
				usu.insertarVenta(idUsuario);
				DetalleVentas detalle = new DetalleVentas();
				detalle.insertarDetalle(idVenta, id_vuelo, Suma, "tarjeta", idUsuario, total);
				JOptionPane.showMessageDialog(null, "Se completo la compra satisfactoriamente " + idUsuario);
				PDf pdf = new PDf(nombre, Origen, Destino, hora, cantNiños, cantAdultos, 
								cantMayores, nivNiños, nivAdultos, nivMayores, total);
				dispose();
				Origen ori = new Origen(idUsuario);
				ori.setLocationRelativeTo(null);
				ori.setResizable(false);
				ori.setVisible(true);
	
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, "Error en la captura de los datos");
				e1.printStackTrace();
			}
		}
		
	}
	
	
	

	
}
