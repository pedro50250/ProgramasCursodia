package interfaces_Usuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import clases.Boleto;
import clases.Cliente;
import clases.DetalleVentas;
import clases.Horario;
import clases.Usuario;
import clases.Venta;
import clases.Vuelo;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.beans.PropertyChangeEvent;

public class ResumenEfectivo extends JFrame implements ActionListener,SpinnerModel
{

	private JPanel panelResumen;
	float total,totalPagado;
	int id_vuelo;
	String Origen, Destino;
	int cantNiños, nivNiños,cantAdultos,nivAdultos,cantMayores,nivMayores;
	int Suma;
	String hora;
	int idUsuario;
	private JTextField txtCantidad_Boletos;
	private JTextField txtCantidad_Pagar;
	private JTextField txtNombre_Cliente;
	private JTextField txtCorreo_Cliente;
	private JTextField txtTelefono_Cliente;
	JButton  btnVolver;
	private JTextField txtPagado;
	JButton btnPagar;
	JSpinner spinBillete20,spinBillete50,spinBillete100,spinBillete200,spinBillete500,spinBillete1000,
	spinMoneda1,spinMoneda2,spinMoneda5,spinMoneda10;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResumenEfectivo frame = new ResumenEfectivo(1,"Monterrey","Guadalajara",5,1,1,3,1,1,1,1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ResumenEfectivo()
	{
		
	}
	public ResumenEfectivo(int id_vuelo, String ori, String des, int suma, int cantNiños, int nivNiños,
			int cantAdultos, int nivAdultos, int cantMayores, int nivMayores,int idUsuario) {
		this.id_vuelo = id_vuelo;
		this.Origen = ori;
		this.Destino = des;
		this.Suma = suma;
		this.cantNiños = cantNiños;
		this.nivNiños = nivNiños;
		this.cantAdultos = cantAdultos;
		this.nivAdultos = nivAdultos;
		this.cantMayores = cantMayores;
		this.nivMayores = nivMayores;
		this.idUsuario = idUsuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 616);
		panelResumen = new JPanel();
		panelResumen.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelResumen.setLayout(null);
		setContentPane(panelResumen);
		
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
		txtCantidad_Boletos.setColumns(10);
		txtCantidad_Boletos.setEditable(false);
		txtCantidad_Boletos.setText(""+Suma);
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
		lblCorreo.setBounds(247, 216, 117, 24);
		panelResumen.add(lblCorreo);
		
		txtCorreo_Cliente = new JTextField();
		txtCorreo_Cliente.setText("");
		txtCorreo_Cliente.setColumns(10);
		txtCorreo_Cliente.setBounds(351, 218, 108, 20);
		panelResumen.add(txtCorreo_Cliente);
		
		JLabel lblTelefono = new JLabel("Telefono del Cliente");
		lblTelefono.setBounds(469, 216, 117, 24);
		panelResumen.add(lblTelefono);
		
		txtTelefono_Cliente = new JTextField();
		txtTelefono_Cliente.setText("");
		txtTelefono_Cliente.setColumns(10);
		txtTelefono_Cliente.setBounds(571, 218, 108, 20);
		panelResumen.add(txtTelefono_Cliente);
		
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
		
		JLabel lblEfectivoRecibido = new JLabel("Efectivo Recibido");
		lblEfectivoRecibido.setHorizontalAlignment(SwingConstants.CENTER);
		lblEfectivoRecibido.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblEfectivoRecibido.setBounds(105, 250, 472, 66);
		panelResumen.add(lblEfectivoRecibido);
		
		ChangeListener listener = new ChangeListener() {
			  public void stateChanged(ChangeEvent e) {
					int billete20 = 20 * Integer.parseInt(spinBillete20.getModel().getValue().toString());
					int billete50 = 50 * Integer.parseInt(spinBillete50.getModel().getValue().toString());
					int billete100 = 100 * Integer.parseInt(spinBillete100.getModel().getValue().toString());
					int billete200 = 200 * Integer.parseInt(spinBillete200.getModel().getValue().toString());
					int billete500 = 500 * Integer.parseInt(spinBillete500.getModel().getValue().toString());
					int billete1000 = 1000 * Integer.parseInt(spinBillete1000.getModel().getValue().toString());
					int moneda1 = 1 * Integer.parseInt(spinMoneda1.getModel().getValue().toString());
					int moneda2 = 2 *Integer.parseInt(spinMoneda2.getModel().getValue().toString());
					int moneda5 = 5* Integer.parseInt(spinMoneda5.getModel().getValue().toString());
					int moneda10 = 10* Integer.parseInt(spinMoneda10.getModel().getValue().toString());
					totalPagado = billete20 + billete50 + billete100 + billete200 + billete500 + billete1000 + moneda1
							+moneda2+moneda5+moneda10;
					txtPagado.setText(""+totalPagado);
			  }
			};
			
		spinBillete20 = new JSpinner();
		spinBillete20.setModel(new javax.swing.SpinnerNumberModel(0, new Integer(0), null, 1));
		spinBillete20.setBounds(131, 327, 69, 29);
		spinBillete20.addChangeListener(listener);
		panelResumen.add(spinBillete20);
		
		spinBillete50 = new JSpinner();
		spinBillete50.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinBillete50.setBounds(131, 367, 69, 29);
		spinBillete50.addChangeListener(listener);
		panelResumen.add(spinBillete50);
		
		spinBillete100 = new JSpinner();
		spinBillete100.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinBillete100.setBounds(131, 407, 69, 29);
		spinBillete100.addChangeListener(listener);
		panelResumen.add(spinBillete100);
		
		spinBillete200 = new JSpinner();
		spinBillete200.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinBillete200.setBounds(131, 447, 69, 29);
		spinBillete200.addChangeListener(listener);
		panelResumen.add(spinBillete200);
		
		spinBillete500 = new JSpinner();
		spinBillete500.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinBillete500.setBounds(131, 487, 69, 29);
		spinBillete500.addChangeListener(listener);
		panelResumen.add(spinBillete500);
		
		spinBillete1000 = new JSpinner();
		spinBillete1000.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinBillete1000.setBounds(131, 527, 69, 29);
		spinBillete1000.addChangeListener(listener);
		panelResumen.add(spinBillete1000);
		
		spinMoneda1 = new JSpinner();
		spinMoneda1.setBounds(346, 327, 69, 29);
		spinMoneda1.addChangeListener(listener);
		panelResumen.add(spinMoneda1);
		
		spinMoneda2 = new JSpinner();
		spinMoneda2.setBounds(346, 367, 69, 29);
		spinMoneda2.addChangeListener(listener);
		panelResumen.add(spinMoneda2);
		
		spinMoneda5 = new JSpinner();
		spinMoneda5.setBounds(346, 407, 69, 29);
		spinMoneda5.addChangeListener(listener);
		panelResumen.add(spinMoneda5);
		
		spinMoneda10 = new JSpinner();
		spinMoneda10.setBounds(346, 447, 69, 29);
		spinMoneda10.addChangeListener(listener);
		panelResumen.add(spinMoneda10);
			
		JLabel lblBillete20 = new JLabel("New label");
		lblBillete20.setIcon(new ImageIcon(ResumenEfectivo.class.getResource("/imagenes_efectivo/veinte_pesos.jpg")));
		lblBillete20.setBounds(49, 327, 69, 29);
		panelResumen.add(lblBillete20);
		
		JLabel lblBillete50 = new JLabel("New label");
		lblBillete50.setIcon(new ImageIcon(ResumenEfectivo.class.getResource("/imagenes_efectivo/cincuenta.jpg")));
		lblBillete50.setBounds(49, 367, 69, 29);
		panelResumen.add(lblBillete50);
		
		JLabel lblBillete100 = new JLabel("New label");
		lblBillete100.setIcon(new ImageIcon(ResumenEfectivo.class.getResource("/imagenes_efectivo/100.jpg")));
		lblBillete100.setBounds(49, 407, 69, 29);
		panelResumen.add(lblBillete100);
		
		JLabel lblBillete200 = new JLabel("New label");
		lblBillete200.setIcon(new ImageIcon(ResumenEfectivo.class.getResource("/imagenes_efectivo/200.jpg")));
		lblBillete200.setBounds(49, 447, 69, 29);
		panelResumen.add(lblBillete200);
		
		JLabel lblBillete500 = new JLabel("New label");
		lblBillete500.setIcon(new ImageIcon(ResumenEfectivo.class.getResource("/imagenes_efectivo/500.jpg")));
		lblBillete500.setBounds(49, 487, 69, 29);
		panelResumen.add(lblBillete500);
		
		JLabel lblBillete1000 = new JLabel("New label");
		lblBillete1000.setIcon(new ImageIcon(ResumenEfectivo.class.getResource("/imagenes_efectivo/1000.jpg")));
		lblBillete1000.setBounds(49, 527, 69, 29);
		panelResumen.add(lblBillete1000);
		
		JLabel lblMoneda1 = new JLabel("");
		lblMoneda1.setIcon(new ImageIcon(ResumenEfectivo.class.getResource("/imagenes_efectivo/1_PESO.png")));
		lblMoneda1.setBounds(301, 327, 35, 29);
		panelResumen.add(lblMoneda1);
		
		JLabel lblMoneda2 = new JLabel("");
		lblMoneda2.setIcon(new ImageIcon(ResumenEfectivo.class.getResource("/imagenes_efectivo/2-Pesos.jpg")));
		lblMoneda2.setBounds(301, 367, 35, 29);
		panelResumen.add(lblMoneda2);
		
		JLabel lblMoneda5 = new JLabel("");
		lblMoneda5.setIcon(new ImageIcon(ResumenEfectivo.class.getResource("/imagenes_efectivo/5-Pesos.jpg")));
		lblMoneda5.setBounds(301, 407, 35, 29);
		panelResumen.add(lblMoneda5);
		
		JLabel lblMoneda10 = new JLabel("");
		lblMoneda10.setIcon(new ImageIcon(ResumenEfectivo.class.getResource("/imagenes_efectivo/10-Pesos.jpg")));
		lblMoneda10.setBounds(301, 447, 35, 29);
		panelResumen.add(lblMoneda10);
		
		btnPagar = new JButton("Pagar");
		btnPagar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnPagar.setBounds(465, 386, 177, 50);
		btnPagar.addActionListener(this);
		panelResumen.add(btnPagar);
		
		JLabel lblPagado = new JLabel("Pagado:");
		lblPagado.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPagado.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagado.setBounds(261, 506, 86, 29);
		panelResumen.add(lblPagado);
		
		txtPagado = new JTextField();
		txtPagado.setEditable(false);
		txtPagado.setBounds(346, 506, 86, 29);
		panelResumen.add(txtPagado);
		txtPagado.setColumns(10);
		
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
			if(total<=totalPagado)
			{
				float cambio = totalPagado - total;
				JOptionPane.showMessageDialog(null, "El cambio es de: " + cambio);
				try {
					String nombre  = txtNombre_Cliente.getText();
					String correo = txtCorreo_Cliente.getText();
				    long num = Long.parseLong(txtTelefono_Cliente.getText()); 
				    String numero = txtTelefono_Cliente.getText();
					Vuelo vue = new Vuelo();
					vue.restarCapacidadDisponible(id_vuelo, Suma);
					Cliente cli = new Cliente();
					int idCli = cli.insertarCliente(nombre, correo, numero, "efectivo", "0");
					Boleto bol = new Boleto();
					Calendar fecha = new GregorianCalendar();
					int año = fecha.get(Calendar.YEAR);
					int mes = fecha.get(Calendar.MONTH);
					int dia = fecha.get(Calendar.DAY_OF_MONTH);
					String  fech= "" + año +"-"+mes+"-"+dia;
					int id_boleto = bol.insertarBoleto(idCli, Suma, fech,hora);
					Venta ven = new Venta();
					int idVenta = ven.insertarVenta(id_boleto, id_vuelo, idUsuario, total);
					Usuario usu = new Usuario();
					usu.insertarVenta(idUsuario);
					DetalleVentas detalle = new DetalleVentas();
					detalle.insertarDetalle(idVenta, id_vuelo, Suma, "efectivo", idUsuario, total);
					JOptionPane.showMessageDialog(null, "Se completo la compra satisfactoriamente " + idUsuario);
					PDf pdf = new PDf(nombre, Origen, Destino, hora, cantNiños, cantAdultos, 
									cantMayores, nivNiños, nivAdultos, nivMayores, total);
					dispose();
					Origen ori = new Origen(idUsuario);
					ori.setVisible(true);
		
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, "Error en la captura de los datos");
					e1.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Aun falta dinero");
			}
		}
		
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getNextValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPreviousValue() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void removeChangeListener(ChangeListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addChangeListener(ChangeListener l) {
		// TODO Auto-generated method stub
		
	}
}
