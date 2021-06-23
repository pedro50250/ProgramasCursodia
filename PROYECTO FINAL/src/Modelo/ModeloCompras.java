package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import DBManager.Conexion;



public class ModeloCompras {

	
	///////////////LISTAS PARA GUARDAR LAS CONSULTAS////////////////
	public ArrayList<detalle_compra>DCompras= new ArrayList<detalle_compra>();
	public ArrayList<detalle_compra>DComprasTab= new ArrayList<detalle_compra>();
	public ArrayList<compra>Compras= new ArrayList<compra>();
	
	/////////////VARIABLES Y ARRAYLIST//////////////
	public static Connection conect = null;
	
	
	/////////COPIA DE LA BASE DE DATOS///////////////
	public ArrayList<usuario>Empleados= new ArrayList<usuario>();
	public ArrayList<proveedor>Proveedores= new ArrayList<proveedor>();
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

	////////////LISTAS PARA BUSCAR LAS ID/////////////
	public void llenarListas() {
		ListaEmpleados();
		ListaArticulos();
		ListaProveedores();
		ListaDCompra();
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
	
	private void ListaProveedores() {
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		String query = "SELECT * FROM proveedor";
		try 
		{
			pstm = conect.prepareStatement(query);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				int id = rs.getInt("id_prov");
				String nom = rs.getString("nom_prov");
				
				Proveedores.add(new proveedor(id, nom, null, null, null));
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
	
	private void ListaDCompra() {
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		String query = "SELECT * FROM detalle_compra";
		try 
		{
			pstm = conect.prepareStatement(query);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				int com = rs.getInt("idCom_detC");
				int art = rs.getInt("idArt_detC");
				int cant = rs.getInt("cant_detC");
				
				
				DCompras.add(new detalle_compra(com, art, cant, 0));
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
	
	
	/////PREPARA LA CONSULTA EN BASE A LOS FILLTROS DE LOS COMBOBOX//////
	private String Query(String usu, int orden, int rango, int key) {
		///////QUERY BASE////////////////
		String query="SELECT * FROM compra";
		
		
		switch(rango) {
			case 0: query= query +" WHERE DATE(fech_com) BETWEEN '"+año+"-"+mes+"-"+dia+"' AND current_timestamp()";     break;
			case 1: query= query +" WHERE DATE(fech_com) BETWEEN '"+año+"-"+mes+"-01' AND current_timestamp()"; break;
			case 2: query= query +" WHERE DATE(fech_com) BETWEEN '"+año+"-01-01' AND current_timestamp()";  break;
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
			query=query+" idUsu_com="+idEmpleado(usu);
		}
		
		/////////////FILTRO PRIMARY KEY//////////
		switch(key) {
			case 0: query= query +" ORDER BY id_com";     break;
			case 1: query= query +" ORDER BY idProv_com"; break;
			case 2: query= query +" ORDER BY idUsu_com";  break;
			case 3: query= query +" ORDER BY tot_com";    break;
			case 4: query= query +" ORDER BY fech_com";   break;
		}
		
		////////////////FILTRO ORDEN/////////////
		if(orden==1) {
			query = query +" DESC";
		}
		
		return query;
	}
	
	////////////LLENA EL ARRAYLIST COMPRAS//////////////////////
	public void Consulta(String usu, int orden, int rango, int key) {
		Compras.clear();
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		String query = Query(usu, orden, rango, key);
		try 
		{
			pstm = conect.prepareStatement(query);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				int id = rs.getInt("id_com");
				int prov = rs.getInt("idProv_com");
				int user = rs.getInt("idUsu_com");
				float tot = rs.getFloat("tot_com");
				String fech = rs.getString("fech_com");
				
				Compras.add(new compra(id, prov, user, tot, fech));
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
	
	
	
	
	//////////////////buscadores de ID///////////////
	
	
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


	public void llenarTablaDetalle(int idCompra){
		DComprasTab.clear();
		
		for(detalle_compra v:DCompras) {
			if(v.getIdCom_detC()==idCompra) {
				DComprasTab.add(v);
			}
		}
	}
	
	///////////BUSCADORES DE ID////////////
	public String nomUsuario(int id) {
		String name="";
		for(usuario u: Empleados) {
			if(u.getIdUsuario()==id) {
				name=u.getUsuario();
			}
		}
		return name;
	}
	
	public String nomProveedor(int id) {
		String name="";
		for(proveedor p: Proveedores) {
			if(p.getId_prov()==id) {
				name=p.getNom_prov();
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
