package DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Usuarios {
	
	
	
	@SuppressWarnings("exports")
	public static  boolean existeUsuario(Connection conect,String nomUsuario,String password)
	{
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		boolean existe=false;
		String sql = "SELECT * FROM usuarios";
		try 
		{
			pstm = conect.prepareStatement(sql);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				if(nomUsuario.equals(rs.getString("nom_usu")) && password.equals(rs.getString("pass_usu")) ||nomUsuario.equals(rs.getString("nom_usu")))
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
	public static void eliminarUsuario(Connection conect, String nomUsuario, String password) {
		if (existeUsuario(conect, nomUsuario, password)) {
			Statement stm = null;
			ResultSet rs = null;
			String sql = "DELETE FROM usuarios WHERE nom_usu='" + nomUsuario + "'";
			
			try {
				stm = conect.createStatement();
				stm.executeUpdate(sql);
				System.out.println("Usuario eliminado correctamente");

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
	public static void agregarUsuario(Connection conect, String nomUsuario, String password, int nivUsuario) {
		if (existeUsuario(conect, nomUsuario, password)==false) {
			PreparedStatement pstm = null;
			String query = "INSERT INTO usuarios(id_usu,nom_usu,pass_usu,numVen_usu,numCom_usu,niv_usu) VALUES(?,?,?,?,?,?)";
			try {
				int idUsuario = buscarUltimoID(conect) +1 ;
				pstm = conect.prepareStatement(query);
				pstm.setInt(1, idUsuario);
				pstm.setString(2, nomUsuario);
				pstm.setString(3, password);
				pstm.setInt(4, 0);
				pstm.setInt(5, 0);
				pstm.setInt(6, nivUsuario);
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
			System.out.println("Existe un usuario con las mismas credenciales");
		}
	}
	
	@SuppressWarnings("exports")
	public static  int buscarUltimoID(Connection conect)
	{
		int idUsuario=0;
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			
			stm = conect.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuarios");
			while (rs.next()) {
				idUsuario = rs.getInt(1);
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
		return idUsuario;
	}

}
