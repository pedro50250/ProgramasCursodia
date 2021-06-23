package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import DBManager.Conexion;
import DBManager.Usuarios;

public class ModeloUsuarios {
	public ArrayList<usuario> usuarios = new ArrayList<usuario>();
	public ArrayList<usuario> vendedores = new ArrayList<usuario>();
	public ArrayList<usuario> administradores = new ArrayList<usuario>();
	public ArrayList<usuario> numVentas = new ArrayList<usuario>();
	public ArrayList<usuario> numCompras = new ArrayList<usuario>();
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
	
	public void leerUsuarios()
	{
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		String sql = "SELECT * FROM usuarios";
		if(usuarios!= null)
		{
			usuarios.clear();
		}
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
	
	public void eliminarUsuario(String nomUsuario, String password) 
	{
		Usuarios.eliminarUsuario(conect, nomUsuario, password);
	}
	
	public void agregarUsuario(String nomUsuario, String password, int nivUsuario) 
	{
		Usuarios.agregarUsuario(conect, nomUsuario, password, nivUsuario);
	}
	
	public boolean existeUsuario(String nomUsuario, String password)
	{
		boolean existe = Usuarios.existeUsuario(conect, nomUsuario, password);
		return existe;
	}
	
	public usuario buscarUsuario(String nomUsuario)
	{
		usuario usu = new usuario();
		boolean existe= false;
		for(usuario usuario : usuarios)
		{
			if(usuario.getUsuario().equals(nomUsuario))
			{
				usu = new usuario(usuario.getIdUsuario(),usuario.getUsuario(),usuario.getContraseña(),usuario.getNumVentas(),
						usuario.getNumCompras(),usuario.getNivUsuario());
				existe=true;
			}
		}
		if(existe== false)
		{
			usu = null;
		}
	    return usu;
	}
	
	public void  buscarVendedores()
	{
		this.leerUsuarios();
		if(vendedores!= null)
		{
			vendedores.clear();
		}
		for(usuario usu: usuarios)
		{
			if(usu.getNivUsuario()==1)
			{
				vendedores.add(usu);
			}
		}
	}
	
	public void buscarAdministradores()
	{
		this.leerUsuarios();
		if(administradores!=null)
		{
			administradores.clear();
		}
		for(usuario usu: usuarios)
		{
			if(usu.getNivUsuario()==2)
			{
				this.administradores.add(usu);
			}
		}
	}
	
	public void ordenar(String opcion) {
		if (opcion.equals("Ventas")) {
			this.leerUsuarios();
			numVentas = usuarios;
			ComparadorUsuarios compa = new ComparadorUsuarios();
			compa.opcion = opcion;
			
			Collections.sort(numVentas, compa);
			
		} else if (opcion.equals("Compras")) {
			this.leerUsuarios();
			numCompras = usuarios;
			ComparadorUsuarios compa = new ComparadorUsuarios();
			compa.opcion = opcion;
			Collections.sort(numCompras, compa);
		}

	}
}
