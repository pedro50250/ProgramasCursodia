package DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

public class CompraArticulos {

	@SuppressWarnings("exports")
	public static int insertarCompra(Connection conect, int idProv, int idUsuario,float total)
	{
		 Date date = new Date();  
         Timestamp ts=new Timestamp(date.getTime());  
         int idCompra = ultimoId(conect) +1;
         
         PreparedStatement pstm = null;
			String query = "INSERT INTO compra(id_com, idProv_com, idUsu_com, tot_com, fech_com) VALUES(?,?,?,?,?)";
			try {
				pstm = conect.prepareStatement(query);
				pstm.setInt(1, idCompra);
				pstm.setInt(2, idProv);
				pstm.setInt(3, idUsuario);
				pstm.setFloat(4, total);
				pstm.setTimestamp(5, ts);
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
			return idCompra;
	}
	
	
	
	private static int ultimoId(Connection conect)
	{
		int idCompra=0;
		Statement stm = null;
		ResultSet rs = null;
		try {
			
			stm = conect.createStatement();
			rs = stm.executeQuery("SELECT * FROM compra");
			while (rs.next()) {
				idCompra = rs.getInt(1);
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
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return idCompra;
	}
	
	@SuppressWarnings("exports")
	public static void actualizarUsuario(Connection conect,int Idusuario)
	{
		Statement stm = null;
		try {
			stm = conect.createStatement();
			String query = "UPDATE usuarios SET numCom_usu = numCom_usu + 1 WHERE id_usu='" + Idusuario+"'";
			stm.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(stm != null)
			{
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@SuppressWarnings("exports")
	public static void actualizarArticulo(Connection conect,int cve_art,int cantArt)
	{
		Statement stm = null;
		try {
			stm = conect.createStatement();
			String query = "UPDATE articulos SET inv_art = inv_art + '"+cantArt+"' WHERE cve_art='"+cve_art+"'";
			stm.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(stm != null)
			{
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

	@SuppressWarnings("exports")
	public static void insertarDetalleVenta(int idCompra,Connection conect,int cve_art,int inv_art)
	{
		PreparedStatement pstm = null;
		String query = "INSERT INTO detalle_compra(idCom_detC, idArt_detC, cant_detC) VALUES(?,?,?)";
		try {
				pstm = conect.prepareStatement(query);
				pstm.setInt(1, idCompra);
				pstm.setInt(2, cve_art);
				pstm.setInt(3, inv_art);
				pstm.execute();
				actualizarArticulo(conect,cve_art, inv_art);
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
}
