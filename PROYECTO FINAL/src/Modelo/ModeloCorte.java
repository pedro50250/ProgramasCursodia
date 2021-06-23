package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import DBManager.Conexion;
import DBManager.LibCorte;


public class ModeloCorte {
	public ArrayList<venta>Ventas= new ArrayList<venta>();
	public ArrayList<compra>Compras= new ArrayList<compra>();
	String dia;
	String mes;
	String año;
	String fecha;
	
	
	///////////////CONEXION//////////////////
	public static Connection conect = null;
	
	
	
	public void conectar() 
	{
		conect =Conexion.conectar();
	}
	public void cerrarConexion()
	{
		if(conect!=null)
		{
			Conexion.desconectar(conect);
		}
	}
	
	public String fechaDeHoy() {
		Calendar c = Calendar.getInstance();
		dia = Integer.toString(c.get(Calendar.DATE));
		 if (dia.length()==1) {
			 dia = "0"+dia;
		 }
		mes =Integer.toString(c.get(Calendar.MONTH));
		int mesInt=Integer.parseInt(mes)+1;
		mes=""+mesInt;
		 if (mes.length()==1) {
			 mes = "0"+mes;
		 }
		año = Integer.toString(c.get(Calendar.YEAR));
		fecha=año+"-"+mes+"-"+dia;
		return fecha;
	}
	
	public void llenarVentas() {
		
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		
		String query = "SELECT * FROM venta WHERE DATE(fecha_Venta) ='"+fecha+"'";
		try 
		{
			pstm = conect.prepareStatement(query);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				int idVen = rs.getInt("idVenta");
				int idUsu = rs.getInt("idUsuario_Venta");
				int cantArt = rs.getInt("cantArt_Venta");
				float monto = rs.getFloat("monto_Venta");
				String fecha = rs.getString("fecha_Venta");
				
				Ventas.add(new venta(idVen, idUsu, cantArt, monto, fecha));
				
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
	
	public void llenarCompras() {
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		
		String query = "SELECT * FROM compra WHERE DATE(fech_com) ='"+fecha+"'";
		try 
		{
			pstm = conect.prepareStatement(query);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				int idCom = rs.getInt("id_com");
				int idProv = rs.getInt("idProv_com");
				int idUsu = rs.getInt("idUsu_com");
				float monto = rs.getFloat("tot_com");
				String fecha = rs.getString("fech_com");
				
				
				Compras.add(new compra(idCom,idProv, idUsu, monto, fecha));
				
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
	
	public float Ingresos() {
		float ing=0;
		
		for(venta v: Ventas) {
			ing=ing+v.getMonto();
		}
		return ing;
	}
	
	public float Egresos() {
		float egre=0;
		
		for(compra c: Compras) {
			egre=egre+c.getTot_com();
		}
		return egre;
	}
	
	public float Utilidades() {
		float util=0;
		util=Ingresos()-Egresos();
		return util;
	}
	
	public void RealizarCorte(usuario usu) {
		
		LibCorte.RealizarCorte(conect, fecha, usu.getIdUsuario(),  Ingresos(), Egresos(), Utilidades());
		
	}
	
	
	
	
	
}
