package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import DBManager.Articulos;
import DBManager.Conexion;

public class ModeloArticulos {
	public static Connection conect = null;
	public ArrayList<articulo> articulos = new ArrayList<articulo>();
	public ArrayList<articulo> inventario = new ArrayList<articulo>();
	public ArrayList<articulo> categoria = new ArrayList<articulo>();
	public ArrayList<articulo> precio = new ArrayList<articulo>();
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
	
	public void leerArticulos()
	{
		if(articulos!= null)
		{
			articulos.clear();
		}
		
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		String sql = "SELECT * FROM articulos";
		try 
		{
			pstm = conect.prepareStatement(sql);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				articulos.add(new articulo(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
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
	
	public void agregarArticulo(String nomArt, float pre_art, int cat_art,int idprov_art, int invArt)
	{
		Articulos.agregarArticulo(conect, nomArt, pre_art, cat_art, idprov_art, invArt);
	}
	
	public void eliminarArticulo(String nomArt)
	{
		Articulos.eliminarArticulo(conect, nomArt);
	}
	
	public articulo buscarArticulo(String nom_art)
	{
		articulo art = new articulo();
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		boolean existe=false;
		String sql = "SELECT * FROM articulos";
		try 
		{
			pstm = conect.prepareStatement(sql);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				if(rs.getString("nom_art").equals(nom_art))
				{
				  art = new articulo(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
				  existe=true;
				}
			}
			if(existe==false)
			{
				art=null;
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
		return art;
	}
	
	public boolean existeCategoria(int cat)
	{
		boolean existe = Articulos.verificarCategoria(conect, cat);
		return existe;
	}
	
	public boolean existeProveedor(int prov)
	{
		boolean existe = Articulos.verificarProveedor(conect, prov);
		return existe;
	}
	
	public boolean existeArticulo(String nomArt)
	{
		boolean existe =Articulos.existeArticulo(conect, nomArt);
		return existe;
	}
	
	public void ordenar(String opcion) {
		if (opcion.equals("Inventario")) {
			this.leerArticulos();
			inventario = articulos;
			ComparadorArticulos compa = new ComparadorArticulos();
			compa.opcion = opcion;
			Collections.sort(inventario, compa);
			
		} else if (opcion.equals("Categoria")) {
			this.leerArticulos();
			categoria = articulos;
			ComparadorArticulos compa = new ComparadorArticulos();
			compa.opcion = opcion;
			Collections.sort(categoria, compa);
		}
		else if (opcion.equals("Precio")) {
			this.leerArticulos();
			precio = articulos;
			ComparadorArticulos compa = new ComparadorArticulos();
			compa.opcion = opcion;
			Collections.sort(precio, compa);
		}

	}

	public void editarArticulo(String nom_art,float pre_art, int inv_art)
	{
		Articulos.editarArticulo( conect, nom_art, pre_art,  inv_art);
	}
	

}
