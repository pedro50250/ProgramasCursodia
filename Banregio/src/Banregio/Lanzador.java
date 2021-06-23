package Banregio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Lanzador {
	public static Connection conect = null;

	ArrayList<Prestamos> prestamosCliente = new ArrayList<Prestamos>();
	ArrayList<Listado> Pagos = new ArrayList<Listado>();
	String fecha_Actual= "15-feb-21";
		String Cliente = "00103228";
		float Tasa_IVA = 16f;
		int Dias_A�o_Comercial=360;
	public static void main(String[] args)
	{
		Lanzador lanz = new Lanzador();
		try {
			lanz.leerPrestamos();
			lanz.generarLista();
			lanz.imprimir();
		} catch (ParseException e) {
			
		}
		
	}
	
	public void leerPrestamos()
	{
		if(prestamosCliente!= null)
		{
			prestamosCliente.clear();
		}
		
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		String sql = "SELECT * FROM prestamos";
		try 
		{
			pstm = conect.prepareStatement(sql);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				if(rs.getString(0).equals(Cliente))
				{
					prestamosCliente.add(new Prestamos(rs.getString(0),rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getString(4)));
				}
				prestamosCliente.add(new Prestamos(rs.getString(0),rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getString(4)));
			}
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				
				} catch (SQLException e) 
				{
					e.printStackTrace();
					throw new RuntimeException(e);
				}	
		}
	}
	
	private void generarLista() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<this.prestamosCliente.size();i++)
		{
			Date inicio = sdf.parse(this.prestamosCliente.get(i).getFecha());
			Date fin = sdf.parse(this.fecha_Actual);
			int plazo =(int) ((fin.getTime()-inicio.getTime())/86400000);
			float TasaInteres=0;
			if(plazo==1)
			{
				TasaInteres = 7f;
			}
			if(plazo>=2 && plazo<=7)
			{
				TasaInteres = 6.50f;
			}
			if(plazo>=8 && plazo<=15)
			{
				TasaInteres = 6;
			}
			if(plazo>=16 && plazo<=30)
			{
				TasaInteres = 5.50f;
			}
			if(plazo>=31 && plazo<=360)
			{
				TasaInteres = 5f;
			}
			float interes = (this.prestamosCliente.get(i).getMonto()*plazo*TasaInteres) / this.Dias_A�o_Comercial;
			float iva = interes*this.Tasa_IVA;
			float pago = this.prestamosCliente.get(i).getMonto() + interes + iva;
			Listado lista = new Listado(this.prestamosCliente.get(i).cliente,plazo,TasaInteres,this.prestamosCliente.get(i).Monto,
		interes,iva,pago);
			this.Pagos.add(lista);
		}
	}
	
	private void imprimir()
	{
		Collections.sort(this.Pagos);
		for(Listado pagos: this.Pagos)
		{
			System.out.println("Cliente: " + pagos.getCliente());
			System.out.println("Plazo: " + pagos.getPlazo());
			System.out.println("Tasa Interes: " + pagos.getTaza_interes());
			System.out.println("Monto: " + pagos.Monto);
			System.out.println("Interes: " + pagos.Interes);
			System.out.println("Iva: " + pagos.IVA);
			System.out.println("Pago: " + pagos.Pago);
		}
		
	}

}
