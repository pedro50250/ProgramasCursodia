package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import DBManager.Conexion;
import DBManager.Proveedores;

public class ModeloProveedores {
	
	public static Connection conect = null;
	public ArrayList<proveedor> proveedores = new ArrayList<proveedor>();
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
	
	public void leerProveedores()
	{
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		String sql = "SELECT * FROM proveedor";
		if(proveedores!= null)
		{
			proveedores.clear();
		}
		try 
		{
			pstm = conect.prepareStatement(sql);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				proveedores.add(new proveedor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
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
	
	public boolean existeProveedor(String nomProv)
	{
		boolean existe = Proveedores.existeProveedor(conect, nomProv);
		return existe;
	}
	
	public void eliminarProveedor(String nomProv)
	{
	   if(existeProveedor(nomProv))
	   {
		   Proveedores.eliminarProveedor(conect, nomProv);
	   }
	}
	
	public void insertarProveedor(String nomProv,String telProv,String dirProv,String emailProv)
	{
		if(existeProveedor(nomProv)==false)
		   {
			   Proveedores.insertarProveedor(conect, nomProv, telProv, dirProv, emailProv);
		   }
	}
	
	public  boolean esNumero(String cadena){
		try {
			Long.parseLong(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	public proveedor buscarProveedor(String nomProv)
	{
		proveedor prov = new proveedor();
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		boolean existe=false;
		String sql = "SELECT * FROM proveedor";
		try 
		{
			pstm = conect.prepareStatement(sql);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				if(rs.getString("nom_prov").equals(nomProv))
				{
				   existe= true;
				   prov = new proveedor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				}
			}
			if(existe==false)
			{
				prov=null;
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
		return prov;
	}
	
	public void editarProvedor(String nomProv,String tel_prov, String dir_prov, String email_prov)
	{
		if(existeProveedor(nomProv))
		{
			Statement stm = null;
			ResultSet rs = null;
			String sql = "UPDATE proveedor SET tel_prov='"+tel_prov+"',dir_prov='"+dir_prov+"',email_prov='"+email_prov+"' WHERE nom_prov='"+nomProv+"'";
	      	try {
				stm = conect.createStatement();
				stm.executeUpdate(sql);
				System.out.println("Articulo actualizado correctamente");

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (stm != null)
						stm.close();

				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
}
