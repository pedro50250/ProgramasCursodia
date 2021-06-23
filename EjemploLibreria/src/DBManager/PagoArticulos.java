package DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;




public class PagoArticulos {

	@SuppressWarnings("exports")
	public static int insertarVenta(Connection conect,int idUsuario,int cantidadArticulos,float total)
	{
		 Date date = new Date();  
         Timestamp ts=new Timestamp(date.getTime());  
         int idVenta = ultimoId(conect) +1;
         
         PreparedStatement pstm = null;
			String query = "INSERT INTO venta(idVenta,idUsuario_venta,cantArt_venta,monto_venta,fecha_venta) VALUES(?,?,?,?,?)";
			try {
				pstm = conect.prepareStatement(query);
				pstm.setInt(1, idVenta);
				pstm.setInt(2, idUsuario);
				pstm.setInt(3, cantidadArticulos);
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
			return idVenta;
	}
	
	
	
	private static int ultimoId(Connection conect)
	{
		int idVenta=0;
		Statement stm = null;
		ResultSet rs = null;
		try {
			
			stm = conect.createStatement();
			rs = stm.executeQuery("SELECT * FROM venta");
			while (rs.next()) {
				idVenta = rs.getInt(1);
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
		return idVenta;
	}
	
	@SuppressWarnings("exports")
	public static void actualizarUsuario(Connection conect,int Idusuario)
	{
		Statement stm = null;
		try {
			stm = conect.createStatement();
			String query = "UPDATE usuarios SET numVen_usu = numVen_usu + 1 WHERE id_usu='" + Idusuario+"'";
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
			String query = "UPDATE articulos SET inv_art = inv_art - '"+cantArt+"' WHERE cve_art='"+cve_art+"'";
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
	public static void insertarDetalleVenta(int idVenta,Connection conect,int cve_art,int inv_art)
	{
		PreparedStatement pstm = null;
		String query = "INSERT INTO detalle_venta(idVen_detV,idArt_detV,cant_detV) VALUES(?,?,?)";
		try {
				pstm = conect.prepareStatement(query);
				pstm.setInt(1, idVenta);
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
