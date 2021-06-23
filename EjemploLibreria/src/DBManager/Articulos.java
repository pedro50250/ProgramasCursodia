package DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Articulos {

	@SuppressWarnings("exports")
	public static  boolean existeArticulo(Connection conect,String nomArt)
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
				if(rs.getString("nom_art").equals(nomArt))
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
	
	@SuppressWarnings("exports")
	public static void eliminarArticulo(Connection conect, String nomArt) {
		if (existeArticulo(conect,nomArt)) {
			Statement stm = null;
			ResultSet rs = null;
			String sql = "DELETE FROM articulos WHERE nom_art='" + nomArt + "'";
			
			try {
				stm = conect.createStatement();
				stm.executeUpdate(sql);
				System.out.println("articulo eliminado correctamente");

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
	
	@SuppressWarnings("exports")
	public static void agregarArticulo(Connection conect, String nomArt, float pre_art, int cat_art,int idprov_art, int invArt) {
		if (existeArticulo(conect, nomArt)==false && verificarCategoria(conect,cat_art)==true && verificarProveedor(conect,idprov_art)==true)
		{
			PreparedStatement pstm = null;
			String query = "INSERT INTO articulos(cve_art,nom_art,pre_art,cat_art,idprov_art,inv_art) VALUES(?,?,?,?,?,?)";
			try {
				int cve_art = buscarUltimaClave(conect) +1 ;
				pstm = conect.prepareStatement(query);
				pstm.setInt(1, cve_art);
				pstm.setString(2, nomArt);
				pstm.setFloat(3, pre_art);
				pstm.setInt(4, cat_art);
				pstm.setInt(5, idprov_art);
				pstm.setInt(6, invArt);
				pstm.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (pstm != null) {
					try {
						pstm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		else
		{
			System.out.println("Existe un articulo con el mismo nombre o no es posible agregar debido a su categoria o proveedor");
		}
	}
	
	@SuppressWarnings("exports")
	public static  int buscarUltimaClave(Connection conect)
	{
		int cve_art=0;
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			
			stm = conect.createStatement();
			rs = stm.executeQuery("SELECT * FROM articulos");
			while (rs.next()) {
				cve_art = rs.getInt(1);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cve_art;
	}
	
	@SuppressWarnings("exports")
	public static boolean verificarCategoria(Connection conect ,int cat)
	{
		boolean posible = false;
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			
			stm = conect.createStatement();
			rs = stm.executeQuery("SELECT * FROM categoria");
			while (rs.next()) {
				if(cat== rs.getInt("id_cat"))
				{
					posible = true;
				}
			}
		}

		catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return posible;
	}
	
	@SuppressWarnings("exports")
	public static boolean verificarProveedor(Connection conect ,int idProv)
	{
		boolean posible = false;
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			
			stm = conect.createStatement();
			rs = stm.executeQuery("SELECT * FROM proveedor");
			while (rs.next()) {
				if(idProv== rs.getInt("id_prov"))
				{
					posible = true;
				}
			}
		}

		catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stm != null) {
					stm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return posible;
	}
	
	@SuppressWarnings("exports")
	public static void editarArticulo(Connection conect,String nom_art,float pre_art, int inv_art)
	{
		if(existeArticulo(conect,nom_art))
		{
			
			Statement stm = null;
			ResultSet rs = null;
			String sql = "UPDATE articulos SET pre_art='"+pre_art+"',inv_art='"+inv_art+"' WHERE nom_art='"+nom_art+"'";
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
		else
		{
			System.out.println("No existe un articulo con ese nombre");
		}
	}
	
	

}


