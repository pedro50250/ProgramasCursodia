package interfaces_Usuario;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;

import clases.Vuelo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class Seleccion_Boletos extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	JButton btnPagar,btnVolver;
	ButtonGroup grupoRadio = new ButtonGroup();
	JSpinner boletos_niños;
	JSpinner boletos_adultos;
	JSpinner boletos_mayores;
	JSpinner clase_niños;
	JSpinner clase_adultos;
	JSpinner clase_mayores;
	JRadioButton opcion_efectivo;
	JRadioButton opcion_tarjeta;
	boolean seleccionado = false;
	int id_vuelo;
	String Origen, Destino;
	int suma,idUsuario;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seleccion_Boletos window = new Seleccion_Boletos(1,"Monterrey","Guadalajara",1);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Seleccion_Boletos(int id_vuelo,String origen,String destino,int idUsuario) {
		this.id_vuelo = id_vuelo;
		this.Origen=origen;
		this.Destino = destino;
		this.idUsuario = idUsuario;
		crearGUI();
		//this.setSize(545,418);
		//this.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	private void crearGUI() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(32, 178, 170));
		frame.setBounds(100, 100, 543, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnPagar = new JButton("PAGAR");
		btnPagar.setBounds(385, 306, 103, 40);
		btnPagar.addActionListener(this);
		frame.getContentPane().add(btnPagar);
		
		
		opcion_efectivo = new JRadioButton("EFECTIVO");
		opcion_efectivo.setFont(new Font("Tahoma", Font.BOLD, 13));
		opcion_efectivo.setBackground(new Color(32, 178, 170));
		opcion_efectivo.setBounds(39, 306, 122, 40);
		grupoRadio.add(opcion_efectivo);
		frame.getContentPane().add(opcion_efectivo);
		
		opcion_tarjeta = new JRadioButton("TARJETA");
		opcion_tarjeta.setFont(new Font("Tahoma", Font.BOLD, 13));
		opcion_tarjeta.setBackground(new Color(32, 178, 170));
		opcion_tarjeta.setBounds(187, 306, 122, 40);
		grupoRadio.add(opcion_tarjeta);
		frame.getContentPane().add(opcion_tarjeta);
		
		SpinnerNumberModel model4 = new SpinnerNumberModel(0, 0, 5, 1);
		boletos_niños = new JSpinner(model4);
		((DefaultEditor) boletos_niños.getEditor()).getTextField().setEditable(false);
		boletos_niños.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boletos_niños.setBounds(39, 98, 89, 40);
		frame.getContentPane().add(boletos_niños);
		
		JLabel lblNumBole = new JLabel("NUMERO DE BOLETOS");
		lblNumBole.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumBole.setBounds(39, 43, 167, 46);
		frame.getContentPane().add(lblNumBole);
		
		SpinnerNumberModel model5 = new SpinnerNumberModel(0, 0, 5, 1);
		boletos_adultos = new JSpinner(model5);
		((DefaultEditor) boletos_adultos.getEditor()).getTextField().setEditable(false);
		boletos_adultos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boletos_adultos.setBounds(39, 164, 89, 40);
		frame.getContentPane().add(boletos_adultos);
		
		SpinnerNumberModel model6 = new SpinnerNumberModel(0, 0, 5, 1);
		boletos_mayores = new JSpinner(model6);
		((DefaultEditor) boletos_mayores.getEditor()).getTextField().setEditable(false);
		boletos_mayores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boletos_mayores.setBounds(39, 229, 89, 40);
		frame.getContentPane().add(boletos_mayores);
		
		JLabel lblAdultos = new JLabel("ADULTOS");
		lblAdultos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAdultos.setBounds(212, 169, 80, 27);
		frame.getContentPane().add(lblAdultos);
		
		JLabel lblNios = new JLabel("NI\u00D1OS");
		lblNios.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNios.setBounds(212, 103, 80, 27);
		frame.getContentPane().add(lblNios);
		
		JLabel lblMayores = new JLabel("MAYORES");
		lblMayores.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMayores.setBounds(212, 234, 80, 27);
		frame.getContentPane().add(lblMayores);
		
		JLabel lblNivelDeClase = new JLabel("NIVEL DE CLASE");
		lblNivelDeClase.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNivelDeClase.setBounds(297, 43, 142, 46);
		frame.getContentPane().add(lblNivelDeClase);
		
		SpinnerNumberModel model1 = new SpinnerNumberModel(0, 0, 2, 1);
		clase_niños = new JSpinner(model1);
		((DefaultEditor) clase_niños.getEditor()).getTextField().setEditable(false);
		clase_niños.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clase_niños.setBounds(350, 98, 89, 40);
		frame.getContentPane().add(clase_niños);
		
		SpinnerNumberModel model2 = new SpinnerNumberModel(0, 0, 2, 1);
		clase_adultos = new JSpinner(model2);
		((DefaultEditor) clase_adultos.getEditor()).getTextField().setEditable(false);
		clase_adultos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clase_adultos.setBounds(350, 164, 89, 40);
		frame.getContentPane().add(clase_adultos);
		
		SpinnerNumberModel model3 = new SpinnerNumberModel(0, 0, 2, 1);
		clase_mayores = new JSpinner(model3);
		((DefaultEditor) clase_mayores.getEditor()).getTextField().setEditable(false);
		clase_mayores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clase_mayores.setBounds(350, 229, 89, 40);
		frame.getContentPane().add(clase_mayores);
		
		JLabel lblSeleccie = new JLabel("SELECCIONE SUS BOLETOS");
		lblSeleccie.setBackground(new Color(0, 0, 0));
		lblSeleccie.setForeground(new Color(255, 215, 0));
		lblSeleccie.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblSeleccie.setBounds(123, 11, 234, 32);
		frame.getContentPane().add(lblSeleccie);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(2,2,90,30);
		btnVolver.addActionListener(this);
		frame.add(btnVolver);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnPagar)
		{
			if(opcion_efectivo.isSelected())
			{
				seleccionado=true;
				try {
					boletos_niños.commitEdit();
					boletos_adultos.commitEdit();
					boletos_mayores.commitEdit();
					clase_niños.commitEdit();
					clase_adultos.commitEdit();
					clase_mayores.commitEdit();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int bol_niños = Integer.parseInt(boletos_niños.getValue().toString());
				int bol_adultos = Integer.parseInt(boletos_adultos.getValue().toString());
				int bol_mayores = Integer.parseInt(boletos_mayores.getValue().toString());
				int cla_niños = Integer.parseInt(clase_niños.getValue().toString());
				int cla_adultos = Integer.parseInt(clase_adultos.getValue().toString());
				int cla_mayores = Integer.parseInt(clase_mayores.getValue().toString());
				int suma = bol_niños+ bol_adultos + bol_mayores;
				if(suma==0)
				{
					if (bol_niños < 1 || bol_adultos < 1 || bol_mayores < 1) {
						JOptionPane.showMessageDialog(null, "Debes elegir minimo un boleto");
					}
				}
				else
				{
					if (bol_niños >= 1 && cla_niños == 0 || bol_adultos >= 1 && cla_adultos == 0
							|| bol_mayores >= 1 && cla_mayores == 0) {
						JOptionPane.showMessageDialog(null, "Te falto elegir la clase del boleto ");
					}
					else
					{
						Vuelo vuelo = new Vuelo();
						int asientos_disp = vuelo.extraerCapacidadDisponible(id_vuelo);
						if(suma> asientos_disp)
						{
							JOptionPane.showMessageDialog(null, "No se puede procesar la compra, unicamente hay: " + asientos_disp
									+ " disponibles");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Compra Aceptada quedan: " + asientos_disp + " disponibles");
							vuelo.restarCapacidadDisponible(id_vuelo, suma);
							this.frame.dispose();
							ResumenEfectivo resu = new ResumenEfectivo(id_vuelo,Origen,Destino,suma,bol_niños,cla_niños,bol_adultos,
									cla_adultos,bol_mayores,cla_mayores,idUsuario);
							resu.setLocationRelativeTo(null);
							resu.setResizable(false);
							resu.setVisible(true);
						}
						
					}
				}
			}
			if(opcion_tarjeta.isSelected())
			{
				seleccionado=true;
				try {
					boletos_niños.commitEdit();
					boletos_adultos.commitEdit();
					boletos_mayores.commitEdit();
					clase_niños.commitEdit();
					clase_adultos.commitEdit();
					clase_mayores.commitEdit();
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int bol_niños = Integer.parseInt(boletos_niños.getValue().toString());
				int bol_adultos = Integer.parseInt(boletos_adultos.getValue().toString());
				int bol_mayores = Integer.parseInt(boletos_mayores.getValue().toString());
				int cla_niños = Integer.parseInt(clase_niños.getValue().toString());
				int cla_adultos = Integer.parseInt(clase_adultos.getValue().toString());
				int cla_mayores = Integer.parseInt(clase_mayores.getValue().toString());
				suma=0;
				suma = bol_niños+ bol_adultos + bol_mayores;
				if(suma==0)
				{
					if (bol_niños < 1 || bol_adultos < 1 || bol_mayores < 1) {
						JOptionPane.showMessageDialog(null, "Debes elegir minimo un boleto");
					}
				}
				else
				{
					if (bol_niños >= 1 && cla_niños == 0 || bol_adultos >= 1 && cla_adultos == 0
							|| bol_mayores >= 1 && cla_mayores == 0) {
						JOptionPane.showMessageDialog(null, "Te falto elegir la clase del boleto ");
					}
					else
					{
						Vuelo vuelo = new Vuelo();
						int asientos_disp = vuelo.extraerCapacidadDisponible(id_vuelo);
						if(suma> asientos_disp)
						{
							JOptionPane.showMessageDialog(null, "No se puede procesar la compra, unicamente hay: " + asientos_disp
									+ " disponibles");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Compra Aceptada quedan: " + asientos_disp + " disponibles");
							this.frame.dispose();
							/*Resumen_Tarj tar = new  Resumen_Tarj();
							tar.Resu(id_vuelo,Origen,Destino,suma,tar,bol_niños,cla_niños,bol_adultos,cla_adultos,bol_mayores,cla_mayores);*/
							Resumen_PagoTarjeta resum = new Resumen_PagoTarjeta();
							resum.Resu(id_vuelo,Origen,Destino,suma,resum,bol_niños,cla_niños,bol_adultos,cla_adultos,bol_mayores,cla_mayores,idUsuario);
							
						}
						
					}
					
				}
			}
			if(seleccionado==false)
			{
				JOptionPane.showMessageDialog(null, "Primero debes seleccionar una opcion de pago");
			}
		}
		
		if(e.getSource()==btnVolver)
		{
			this.frame.dispose();
			Horarios hor = new Horarios(Origen,Destino,idUsuario);
			//hor.setVisible(true);
		}
		
	}
}
