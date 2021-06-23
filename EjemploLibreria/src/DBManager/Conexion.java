package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	@SuppressWarnings("exports")
	public static Connection conectar() {
		Connection con = null;
		String Servidor = "jdbc:mysql://localhost/tiendaa";
		String Usuario ="AdminTienda";
		String Password = "Tienda9023";
		try {
			con = DriverManager.getConnection(Servidor, Usuario, Password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!= null)
		{
			System.out.println("Conexion Exitosa");
			
		}
		return con;

	}
	
	@SuppressWarnings("exports")
	public static void desconectar(Connection conexion)
	{
		if(conexion!=null)
		{
			try {
				conexion.close();
				System.out.println("Se cerro la conexion");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("Error al cerrar la conexion a la base de datos");
		}
		
	}
	
	
	

}
