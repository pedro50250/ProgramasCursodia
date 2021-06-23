package Sesion3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CRUD {

	static Connection con = null;
	String Servidor = "jdbc:mysql://localhost/tiendaa";
	String Usuario ="AdminTienda";
	String Password = "Tienda9023";
	
	public static void main(String[] args) {
		CRUD c = new CRUD();
		c.conectar();
		//c.create2();
		//con = ConexionTienda.conectar();
		c.read();
		c.cerrarConexion();
	}
	
	private void conectar()
	{
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
	}
	
	private void cerrarConexion()
	{
		if(con!=null)
		{
			try {
				con.close();
				System.out.println("Se cerro la conexion");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private void read()
	{
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query ="SELECT * FROM articulos";
		
		try {
			pstm = con.prepareStatement(query);
			rs = pstm.executeQuery();
			
			System.out.println("Clave\t\tNombre\t\tPrecio\t\tCategoria\t\tIdProveedor\t\tInventario");
			while(rs.next())
			{
				System.out.print(rs.getInt("cve_art") +"\t\t");
				System.out.print(rs.getString("nom_art")+"\t\t");
				System.out.print(rs.getFloat("pre_art") +"\t\t");
				System.out.print(rs.getInt("cat_art") +"\t\t");
				System.out.print(rs.getInt("idprov_art") +"\t\t");
				System.out.print(rs.getInt("inv_art") +"\t\t");
				System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
				try {
					if(rs!=null) rs.close();
					if(pstm!= null) pstm.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		}
		
	}
	
	private void create()
	{
		int cve = Integer.parseInt(JOptionPane.showInputDialog("Clave del Articulo"));
		String nom = JOptionPane.showInputDialog("");
		
	}
	
	private void create2()
	{
		PreparedStatement pstm = null;
		String query = "INSERT INTO articulos(cve_art,nom_art,pre_art,cat_art,idprov_art,inv_art) VALUES(?,?,?,?,?,?)";
		int cve = Integer.parseInt(JOptionPane.showInputDialog("Clave del Articulo"));
		String nom = JOptionPane.showInputDialog("Nombre Articulo");
		float pre = Float.parseFloat(JOptionPane.showInputDialog("Precio del articulo"));
		int inv = Integer.parseInt(JOptionPane.showInputDialog("Existencias"));
		int cat = Integer.parseInt(JOptionPane.showInputDialog("Categoria del Articulo"));
		int prov = Integer.parseInt(JOptionPane.showInputDialog("Id proveedor"));
		try
		{
			pstm = con.prepareStatement(query);
			pstm.setInt(1, cve);
			pstm.setString(2, nom);
			pstm.setFloat(3, pre);
			pstm.setInt(4, cat);
			pstm.setInt(5, prov);
			pstm.setInt(6, prov);
			pstm.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstm!=null)
			{
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
