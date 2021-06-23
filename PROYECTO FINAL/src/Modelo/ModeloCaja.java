package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DBManager.Conexion;


public class ModeloCaja {

	public static Connection conect = null;
	//ArrayList para tener todos los articulos que hay en la base de datos
	public ArrayList<articulo>articulos = new ArrayList<articulo>(); 
	//ArrayList para tener todos los articulos que se han ido seleccionando y agregando a la tabla
	//public ArrayList<articulo> articulosSelec = new ArrayList<articulo>();
	public ArrayList<articulo> articulosSelec;
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
	//Metodo para leer los articulos de la base de datos y crear un ArrayList con ellos de tipo Articulo
	public void leerArticulos()
	{
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
	
	//Metodo que nos ayuda a verificar si el articulo existe, unicamente se manda como parametro la clave y regresa un true or false
	public boolean existeArticulo(int cve_art)
	{
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
				if(cve_art ==rs.getInt(1))
				{
				   existe= true;
				}
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
		return existe;
		
	}
	
	//Metodo que verifica si existe inventario disponible Y en caso de que no exista el inventario
	//se regresa un false para decir que no existe mas inventario de tal articulo
	public boolean existeInventario(int cve_art,int cantArt)
	{
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
				if(cve_art ==rs.getInt(1))
				{
					if(rs.getInt(6) >= cantArt)
					{
						existe = true;
					}
				}
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
		return existe;
		
	}
	
	//Metodo para buscar el articulo mandando el nombre del articulo a buscar, esto con el fin
	//de que nos regrese la clave del articulo que estamos buscando 
	public int buscarArticulo(String articuloBuscado)
	{
		boolean encontrado=false;
		int cve_art = 0;
		float precio = 0;
		for (articulo art : articulos) {
			if (articuloBuscado.equals(art.getNom_art())) {
				encontrado = true;
				cve_art = art.getCve_art();
				precio = art.getPre_art();
			}
		}
		if (encontrado) {
			if (JOptionPane.showConfirmDialog(null,
					"El precio de: " + articuloBuscado + " es de: " + precio + " deseas agregarlo?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			}
		} else {
			JOptionPane.showMessageDialog(null, "Error, no se encontro ese articulo");
		}
		return cve_art;
	}
	
	
	//Metodo para agregar un articulo al ArrayList de articulos seleccionados
	@SuppressWarnings("unused")
	public void agregarArticulo(int cve_art,int cantArt)
	{
		float precioArt = 0;
		boolean existe = false;
		int indice = 0;
		// Ciclo for para comparar la clave del articulo con los de la BD
		for (articulo art :articulos) {
			if (cve_art == art.getCve_art()) {
				precioArt = art.getPre_art();
				if (this.articulosSelec != null) {
					// Cilo for para verificar si ya hay un articulo del mismo tipo ingresado
					for (int i = 0; i < articulosSelec.size(); i++) {
						if (cve_art == this.articulosSelec.get(i).getCve_art()) {
							existe = true;
							indice = i;
						}
					}

				}
				//Aqui se pregunta si el articulo existe ya en el arraylist esto con el fin de aumentar
				//la cantidad de articulos seleccionados que hay en el arraylist de articulos seleccionados
				if (existe) {
					int cantNueva = this.articulosSelec.get(indice).getInv_art() + cantArt;
					this.articulosSelec.set(indice, new articulo(art.getCve_art(), art.getNom_art(),
							art.getPre_art(), art.getIdprov_art(), art.getCat_art(), cantNueva));
				}
				//Si no hay ningun articulo agregado con esa clave del articulo lo que se hace es agregar el articulo
				//al arraylist de articulos seleccionados
				else {
					if(this.articulosSelec==null)
					{
						this.articulosSelec = new ArrayList<articulo>();
					}
					this.articulosSelec.add(new articulo(art.getCve_art(), art.getNom_art(),
							art.getPre_art(), art.getIdprov_art(), art.getCat_art(), cantArt));
				}

			}
		}
	}
	
	//Metodo con el fin de eliminar un articulo del arraylist de articulos seleccionados
	public String eliminarArticulo(int cve_art,int cantArt)
	{
		String accion="";
		int indice = 0;
		boolean encontrado=false;
		
		//Se hace un ciclo for para verificar si hay un articulo con esa misma clave ya en 
		//el arraylist de los articulos seleccionados
		if(this.articulosSelec != null)
		{
			// Cilo for para verificar si ya hay un articulo del mismo tipo ingresado
			for (int i = 0; i < articulosSelec.size(); i++) {
				if (cve_art == this.articulosSelec.get(i).getCve_art()) {
					encontrado = true;
					indice = i;
				}
		}
		}
		//Si se encontro se le restara al la cantidad agregada anteriormente
		if (encontrado) {
			//Se pregunta si la cantidad de articulos con la misma clave es menor a la que ya
			//se ha agregado anteriormente si es asi solo se resta
			if (cantArt < articulosSelec.get(indice).getInv_art()) {
				int cantFinal = articulosSelec.get(indice).getInv_art() - cantArt;
				articulosSelec.set(indice,
						new articulo(articulosSelec.get(indice).getCve_art(), articulosSelec.get(indice).getNom_art(),
								articulosSelec.get(indice).getPre_art(), articulosSelec.get(indice).getCat_art(),
								articulosSelec.get(indice).getIdprov_art(), cantFinal));
				accion="realizada";
				
			} 
			// Se pregunta su la cantidad a remover de articulos con la misma clave es mayor o igual
			//a la cantidad que ya esta agregada y si es asi se elimina el articulo del arraylist de articulos seleccioandos
			else if (cantArt >= articulosSelec.get(indice).getInv_art()) {
				articulosSelec.remove(indice);
				accion="realizada";
				
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"El articulo no se puede eliminar porque no existe o no esta agregado en la compra");
		}
		return accion;
	}
	
	
	
}
