package interfaces_Usuario;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PDf extends JFrame  implements Printable{
	private JTextField txtNombre;
	private JTextField txtCantidadNiños;
	private JTextField txtCantidadAdulto;
	private JTextField txtCantidadMayores;
	private JTextField txtClaseNiño;
	private JTextField txtClaseAdulto;
	private JTextField txtClaseMayores;
	private JTextField txtPagado;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private JTextField txtHora;
	String nombre, POrigen, PDestino, Hora;
	int CantidadNiños, CantidadAdulto, CantidadMayores, ClaseNiño, ClaseAdulto, ClaseMayores;
	float Total;
	public JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PDf frame = new PDf("Pedro Alarcon", "Monterrey", "Guadalajara", "10:40", 1, 2, 
							1, 1, 2, 1, 10045.2f);
					//frame.setSize(550,450);
					frame.setSize(600,600);
					frame.setResizable(false);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PDf(String nombre, String origen, String destino, String hora, int cantidadNiños, int cantidadAdulto,
			int cantidadMayores, int claseNiño, int claseAdulto, int claseMayores, float total) {
		this.nombre = nombre;
		POrigen = origen;
		PDestino = destino;
		Hora = hora;
		CantidadNiños = cantidadNiños;
		CantidadAdulto = cantidadAdulto;
		CantidadMayores = cantidadMayores;
		ClaseNiño = claseNiño;
		ClaseAdulto = claseAdulto;
		ClaseMayores = claseMayores;
		this.Total = total;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setLayout(null);
		setContentPane(panel);
		//panel.setBounds(100, 100, 450, 300);
		panel.setBounds(100, 100, 600, 600);
		panel.setVisible(false);
	
		JLabel lblNewLabel = new JLabel("Aerolinea");
		lblNewLabel.setBounds(120, 24, 315, 59);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 41));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre del Responsable:");
		lblNewLabel_1.setBounds(0, 109, 181, 17);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Cantidad Boletos Ni\u00F1o:");
		lblNewLabel_1_1.setBounds(0, 137, 160, 17);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Cantidad Boletos Adulto:");
		lblNewLabel_1_1_1.setBounds(0, 166, 173, 17);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Cantidad Boletos Mayores:");
		lblNewLabel_1_1_2.setBounds(0, 197, 188, 17);
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_1_1_2);

		txtNombre = new JTextField();
		txtNombre.setBounds(184, 105, 147, 20);
		txtNombre.setText(this.nombre);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtCantidadNiños = new JTextField();
		txtCantidadNiños.setBounds(199, 136, 86, 20);
		txtCantidadNiños.setColumns(10);
		txtCantidadNiños.setText(""+this.CantidadNiños);
		panel.add(txtCantidadNiños);

		txtCantidadAdulto = new JTextField();
		txtCantidadAdulto.setBounds(199, 165, 86, 20);
		txtCantidadAdulto.setColumns(10);
		txtCantidadAdulto.setText(""+this.CantidadAdulto);
		panel.add(txtCantidadAdulto);

		txtCantidadMayores = new JTextField();
		txtCantidadMayores.setBounds(198, 196, 86, 20);
		txtCantidadMayores.setColumns(10);
		txtCantidadMayores.setText(""+this.CantidadMayores);
		panel.add(txtCantidadMayores);

		JLabel lblClase_1 = new JLabel("Clase:");
		lblClase_1.setBounds(334, 137, 43, 17);
		lblClase_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblClase_1);

		JLabel lblClase_2 = new JLabel("Clase:");
		lblClase_2.setBounds(334, 166, 43, 17);
		lblClase_2.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblClase_2);

		JLabel lblClase_3 = new JLabel("Clase:");
		lblClase_3.setBounds(334, 199, 43, 17);
		lblClase_3.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblClase_3);

		txtClaseNiño = new JTextField();
		txtClaseNiño.setBounds(387, 136, 86, 20);
		panel.add(txtClaseNiño);
		if(ClaseNiño==1)
		{
			txtClaseNiño.setText("Turista");
		}
		else if(ClaseNiño==2)
		{
			txtClaseNiño.setText("Primera");
		}
		txtClaseNiño.setColumns(10);

		txtClaseAdulto = new JTextField();
		txtClaseAdulto.setBounds(387, 165, 86, 20);
		txtClaseAdulto.setColumns(10);
		if(ClaseAdulto==1)
		{
			txtClaseAdulto.setText("Turista");
		}
		else if(ClaseAdulto==2)
		{
			txtClaseAdulto.setText("Primera");
		}
		panel.add(txtClaseAdulto);

		txtClaseMayores = new JTextField();
		txtClaseMayores.setBounds(387, 196, 86, 20);
		txtClaseMayores.setColumns(10);
		if(ClaseMayores==1)
		{
			txtClaseMayores.setText("Turista");
		}
		else if(ClaseMayores==2)
		{
			txtClaseMayores.setText("Primera");
		}
		panel.add(txtClaseMayores);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(287, 243, 194, 160);
		lblNewLabel_2.setIcon(new ImageIcon(PDf.class.getResource("/fotos/codigoQR.png")));
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Total Pagado:");
		lblNewLabel_3.setBounds(40, 342, 94, 17);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_3);

		txtPagado = new JTextField();
		txtPagado.setBounds(144, 341, 86, 20);
		txtPagado.setText(""+this.Total);
		panel.add(txtPagado);
		txtPagado.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Origen:");
		lblNewLabel_4.setBounds(46, 286, 52, 17);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("Destino:");
		lblNewLabel_4_1.setBounds(46, 314, 58, 17);
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_4_1);

		txtOrigen = new JTextField();
		txtOrigen.setBounds(120, 285, 86, 20);
		txtOrigen.setText(POrigen);
		panel.add(txtOrigen);
		txtOrigen.setColumns(10);

		txtDestino = new JTextField();
		txtDestino.setBounds(120, 313, 86, 20);
		txtDestino.setColumns(10);
		txtDestino.setText(PDestino);
		panel.add(txtDestino);

		JLabel lblNewLabel_4_1_1 = new JLabel("Hora:");
		lblNewLabel_4_1_1.setBounds(46, 258, 37, 17);
		lblNewLabel_4_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_4_1_1);

		txtHora = new JTextField();
		txtHora.setBounds(120, 257, 86, 20);
		txtHora.setColumns(10);
		txtHora.setText(""+this.Hora);
		panel.add(txtHora);
		Imprimir();
	}
	
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex == 0) {
			Graphics2D g2d = (Graphics2D) graphics;
			g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
			panel.printAll(graphics);
			return PAGE_EXISTS;
		} else
			return NO_SUCH_PAGE;
	}

	private void Imprimir() {
		PrinterJob printerJob = PrinterJob.getPrinterJob();
		printerJob.setPrintable(this);
		if (printerJob.printDialog()) {
			try {
				printerJob.print();
			} catch (PrinterException ex) {

			}
		} else {
			JOptionPane.showMessageDialog(null, "La impresion se canceló");
		}
	}

}
