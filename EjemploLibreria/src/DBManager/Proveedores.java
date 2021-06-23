package DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Proveedores {
	
	@SuppressWarnings("exports")
	public static  boolean existeProveedor(Connection conect,String nomProv)
	{
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
	public static void eliminarProveedor(Connection conect, String nomProv) {
		if (existeProveedor(conect,nomProv)) {
			Statement stm = null;
			ResultSet rs = null;
			String sql = "DELETE FROM proveedor WHERE nom_prov='" + nomProv + "'";
			
			try {
				stm = conect.createStatement();
				stm.executeUpdate(sql);
				System.out.println("proveedor eliminado correctamente");

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
	public static  int buscarUltimoId(Connection conect)
	{
		int id_prov=0;
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			
			stm = conect.createStatement();
			rs = stm.executeQuery("SELECT * FROM proveedor");
			while (rs.next()) {
				id_prov = rs.getInt(1);
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
		return id_prov;
	}
	
	@SuppressWarnings("exports")
	public static void insertarProveedor(Connection conect,String nom_prov, String tel_prov, String dir_prov, String email_prov)
	{
		if(existeProveedor(conect,nom_prov)==false)
		{
			PreparedStatement pstm = null;
			String query = "INSERT INTO proveedor(id_prov,nom_prov,tel_prov,dir_prov,email_prov) VALUES(?,?,?,?,?)";
			try {
				int id_prov = buscarUltimoId(conect) +1 ;
				pstm = conect.prepareStatement(query);
				pstm.setInt(1, id_prov);
				pstm.setString(2, nom_prov);
				pstm.setString(3, tel_prov);
				pstm.setString(4, dir_prov);
				pstm.setString(5, email_prov);
				pstm.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (pstm != null) {
					try {
						pstm.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	

}
