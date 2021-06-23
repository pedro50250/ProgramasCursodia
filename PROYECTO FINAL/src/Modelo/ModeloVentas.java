package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import DBManager.Conexion;



public class ModeloVentas {

	/////////////VARIABLES Y ARRAYLIST//////////////
	public static Connection conect = null;
	/////////COPIA DE LA BASE DE DATOS///////////////
	public ArrayList<venta>Ventas= new ArrayList<venta>();
	public ArrayList<detalle_venta>DVentas= new ArrayList<detalle_venta>();
	public ArrayList<detalle_venta>DVentasTabla= new ArrayList<detalle_venta>();
	
	public ArrayList<usuario>Empleados= new ArrayList<usuario>();
	public ArrayList<articulo>Articulos= new ArrayList<articulo>();
	
	String dia, mes, año, fecha; //Comparacion para el filtro "rango"
	
	
	
	///////////METODOS DE CONEXION/////////////////
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

	//////////COPIA DE LA BASE DE DATOS///////////
	public void llenarListas() {
	ListaDVentas();
	ListaEmpleados();
	ListaArticulos();
}
	
	private void ListaDVentas() {
		
		
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		String query = "SELECT * FROM detalle_venta";
		
		try 
		{
			pstm = conect.prepareStatement(query);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				int idVen = rs.getInt("idVen_detV");
				int idArt = rs.getInt("idArt_detV");
				int cantArt = rs.getInt("cant_detV");
				int precio=0;
				
				
				DVentas.add(new detalle_venta(idVen, idArt, cantArt, precio));
				
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

	private void ListaArticulos(){
	
	PreparedStatement pstm=null;
	ResultSet  rs=null;
	String query = "SELECT * FROM articulos";
	try 
	{
		pstm = conect.prepareStatement(query);
		rs = pstm.executeQuery();
						
		while(rs.next())
		{
			int cve = rs.getInt("cve_art");
			String nom = rs.getString("nom_art");
			float pre = rs.getFloat("pre_art");
			int cat = rs.getInt("cat_art");
			
			Articulos.add(new articulo(cve, nom, pre, cat, 0, 0));
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

	private void ListaEmpleados() {
	
	PreparedStatement pstm=null;
	ResultSet  rs=null;
	String query = "SELECT * FROM usuarios";
	try 
	{
		pstm = conect.prepareStatement(query);
		rs = pstm.executeQuery();
						
		while(rs.next())
		{
			int id = rs.getInt("id_usu");
			String nom = rs.getString("nom_usu");
			Empleados.add(new usuario(id, nom, null, 0, 0, 0));
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


	private String Query(String usu, int orden, int rango, int key) {
		///////QUERY BASE////////////////
		String query="SELECT * FROM venta";
		
		
		switch(rango) {
			case 0: query= query +" WHERE DATE(fecha_Venta) BETWEEN '"+año+"-"+mes+"-"+dia+"' AND current_timestamp()";     break;
			case 1: query= query +" WHERE DATE(fecha_Venta) BETWEEN '"+año+"-"+mes+"-01' AND current_timestamp()"; 			break;
			case 2: query= query +" WHERE DATE(fecha_Venta) BETWEEN '"+año+"-01-01' AND current_timestamp()";  				break;
			case 3: break;
			
		}
			
		/////////////////FILTRO USUARIO/////////////////
		if(usu.equals("TODOS")) {
			
		}else {
			if(rango!=3) {
				query=query+" AND";
			}else {
				query=query+" WHERE";
			}
			query=query+" idUsuario_Venta="+idEmpleado(usu);
		}
		
		/////////////FILTRO PRIMARY KEY//////////
		switch(key) {
			case 0: query= query +" ORDER BY idVenta";     		break;
			case 1: query= query +" ORDER BY idUsuario_Venta"; 	break;
			case 2: query= query +" ORDER BY cantArt_Venta";  break;
			case 3: query= query +" ORDER BY monto_Venta";    break;
			case 4: query= query +" ORDER BY fecha_Venta";   break;
		}
		
		////////////////FILTRO ORDEN/////////////
		if(orden==1) {
			query = query +" DESC";
		}
		
		return query;
	}
	
	public void Consulta(String usu, int orden, int rango, int key) {
		Ventas.clear();
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		String query = Query(usu, orden, rango, key);
		try 
		{
			pstm = conect.prepareStatement(query);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				int id = rs.getInt("idVenta");
				int user = rs.getInt("idUsuario_Venta");
				int cant = rs.getInt("cantArt_Venta");
				float tot = rs.getFloat("monto_Venta");
				String fech = rs.getString("fecha_Venta");
				
				Ventas.add(new venta(id, user, cant, tot, fech));
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
	
	
	public void fechaDeHoy() {
		
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
			
		
	}
	
	/////////////COMBOBOX USUARIOS/////////////////
	public String[] comboUsuarios(){
		int i=1;
		String[] emps =new String[Empleados.size()+1];
		emps[0]="TODOS";
		for(usuario u: Empleados) {
			emps[i]=u.getUsuario();
			i++;
		}
		return emps;
		
	}	

	public void llenarTablaDetalle(int idVenta){
		DVentasTabla.clear();
		
		for(detalle_venta v:DVentas) {
			if(v.getIdVenta()==idVenta) {
				DVentasTabla.add(v);
			}
		}
		
	}	
	
	public String nomUsuario(int id) {
		String name="";
		for(usuario u: Empleados) {
			if(u.getIdUsuario()==id) {
				name=u.getUsuario();
			}
		}
		return name;
	}
	
	public String nomArticulo(int id) {
		String name="";
		for(articulo a: Articulos) {
			if(a.getCve_art()==id) {
				name=a.getNom_art();
			}
		}
		return name;
	}
	
	public float preArticulo(int id) {
		float pre=0;
		for(articulo a: Articulos) {
			if(a.getCve_art()==id) {
				pre=a.getPre_art();
			}
		}
		return pre;
	}
	
	private int idEmpleado(String nom) {
		int id=0;
		for(usuario u: Empleados) {
			if(nom.equals(u.getUsuario())) {
				id=u.getIdUsuario();
			}
		}
		return id;
	}
}//cierre de la clase