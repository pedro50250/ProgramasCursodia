package DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class LibCorte {
	
	public static void RealizarCorte(@SuppressWarnings("exports") Connection conect, String fecha, int idUsuario, float Ingresos, float Egresos, float Utilidades)
	{
		PreparedStatement pstm=null;
		String query="INSERT INTO corte (idUsu_cor, ingre_cor, egre_cor, util_cor) VALUES (?,?,?,?)";
		
		
		if(CorteRealizado(conect, fecha)) {
			JOptionPane.showMessageDialog(null, "El corte ya se ha realizado");
		}
		else {
		
			try {
				pstm= conect.prepareStatement(query);
				pstm.setInt(1, idUsuario);
				pstm.setFloat(2, Ingresos);
				pstm.setFloat(3, Egresos);
				pstm.setFloat(4, Utilidades);
			
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Se ha realizado correctamente el corte");
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Hubo un error al realizar el corte");
			}
			finally {
				try {
					if(pstm!=null)  pstm.close();
					
				} catch (SQLException e) {			
				e.printStackTrace();
				}
			}
		}
	}
	
	private static boolean CorteRealizado(Connection conect, String fecha) {
		PreparedStatement pstm =null;
		String query = "SELECT * FROM corte WHERE DATE(fecha_cor) ='"+fecha+"'";
		ResultSet  rs=null;
		
		try {
			pstm=conect.prepareStatement(query);
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
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
}
