package controlTiempo;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


public class Consulta extends JFrame implements ActionListener 
{
	JTable tabla;
	JButton recordatorio;
	JTextField rec;
	JComboBox clientes, facturas;
	ConectarLaNueva con;
	JTextField hsystem;
	Reloj clock;
	JDatePickerImpl datePicker;
	
	public static void main(String[] args) 
	{
		Consulta C = new Consulta();
		C.con = new ConectarLaNueva();
		C.con.Conectar();
		C.con.leerClientes();
		C.con.leerFacturas();
		C.setSize(800,550);
		C.crearGUI();
		C.setVisible(true);
		C.clock = new Reloj(C);
		C.clock.start();
	}

	private void crearGUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Consulta Facturas");
		Container frame = this.getContentPane();
		frame.setLayout(new FlowLayout());
		
		JLabel cli = new JLabel("Cliente:");
		clientes = new JComboBox(getClientName());
		clientes.addActionListener(this);
		JLabel fac = new JLabel("Facturas:");
		facturas = new JComboBox();
		JLabel recorda = new JLabel("Recordatorio:");
		rec = new JTextField(20);
		//recordatorio = new JButton("Recordatorio");
		//------------------------------------------------------------------------------------------------------------
		String dataValues[][] = {{"","" ,""},{"Hola","Pao","Como estas"}};
		String[] nombreColumnas = {"#","Monto","Fecha"};
		DefaultTableModel dtm= new DefaultTableModel(dataValues, nombreColumnas)
		{
		    @Override
		    public boolean isCellEditable(int row, int column)
		    {
		       //all cells false
		       return false;
		    }
		};
		tabla = new JTable(dtm);
		JScrollPane scroll = new JScrollPane(tabla);
		//------------------------------------------------------------------------------------------------------------
		hsystem = new JTextField(20);
		hsystem.setEditable(false);
		//------------------------------------------------------------------------------------------------------------
        UtilDateModel model = new UtilDateModel();

        Properties p = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
//------------------------------------------------------------------------------------------------------------
		
        recordatorio = new JButton("Consultar");
        recordatorio.addActionListener(this);
        frame.add(cli);
		frame.add(clientes);
		frame.add(fac);
		frame.add(facturas);
		frame.add(recorda);
		frame.add(rec);
		frame.add(recordatorio);
		frame.add(scroll);
		frame.add(hsystem);
		frame.add(datePicker);
		frame.add(recordatorio);
	}
	
	private String[] getClientName()
	{
		ArrayList<String> names = new ArrayList<String>();
		for(Clientes c:con.CDB)
		{
			names.add(c.nom_cli);
		}
		String[] arr = names.toArray(new String[names.size()]);
		return arr;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource()==clientes)
		{
			facturas.removeAllItems();
			int id=0;
			for(Clientes c:con.CDB)
			{
				if(c.nom_cli.equals(clientes.getSelectedItem()))
				{
					id = c.id_cli;
				}
			}
			for(Facturas f:con.FDB)
			{
				if(f.idcli_fac == id)
				{
					facturas.addItem(""+f.id_fac);
				}
			}
			rellenarJTable(id);
		}
		if(arg0.getSource()==recordatorio)
		{
			
			String datechoosed = datePicker.getJFormattedTextField().getText();
	
			String datenow = ""+LocalDate.now();
			//System.out.println(datechoosed);
			//System.out.println(datenow);
			try 
			{
				java.util.Date UtilDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(datechoosed);
				java.util.Date UtilDate2 = new SimpleDateFormat("yyyy-MM-dd").parse(datenow);
				Date d1 = new java.sql.Date(UtilDate1.getTime());
				Date d2 = new java.sql.Date(UtilDate2.getTime());
				//System.out.println(""+d1+" "+d2);
				
				long dif = d1.getTime() - d2.getTime();
				System.out.println(dif);
				float dias = ((((dif/1000)/60)/60)/24);
				JOptionPane.showMessageDialog(null,"falta "+dias+" dias para la cita");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		}
	}
	private void rellenarJTable(int id)
	{
		((DefaultTableModel) tabla.getModel()).setRowCount(0);
		 DefaultTableModel model = (DefaultTableModel) tabla.getModel();
		 for(Facturas F:con.FDB)
		 {
			 if(F.idcli_fac == id)
			 {
				 model.addRow(new Object[]{""+F.id_fac,""+F.mon_fac,""+F.fec_fac});
			 }
		 }  
	}
}