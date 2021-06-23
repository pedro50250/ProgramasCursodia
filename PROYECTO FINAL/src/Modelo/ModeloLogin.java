package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import clases.usuario;

import DBManager.Conexion;

public class ModeloLogin {

	public static Connection conect = null;
	ArrayList<usuario> usuarios = new ArrayList<usuario>();
	
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
	
	public void leerUsuarios()
	{
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		String sql = "SELECT * FROM usuarios";
		try 
		{
			pstm = conect.prepareStatement(sql);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				usuarios.add(new usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
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
	
	public boolean existeUsuario(String usuario, String password)
	{
		boolean existe=false;
		for(usuario usu: usuarios)
		{
			if(usu.getUsuario().equals(usuario) && usu.getContraseña().equals(password))
			{
				existe = true;
			}
		}
		return existe;
	}
	
	
	public usuario buscarUsuario(String usuario, String password)
	{
		usuario usua = new usuario();
		boolean encontrado=false;
		for(usuario usu: usuarios)
		{
			if(usu.getUsuario().equals(usuario) && usu.getContraseña().equals(password))
			{
				usua = new usuario(usu.getIdUsuario(),usu.getUsuario(),usu.getContraseña(),usu.getNumVentas(),
						usu.getNumCompras(),usu.getNivUsuario());
				encontrado = true;
			}
			
		}
		if(encontrado==false)
		{
			usua= null;
		}
		return usua;
	}
	
}
