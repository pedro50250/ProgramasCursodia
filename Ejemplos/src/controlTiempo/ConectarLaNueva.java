package controlTiempo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConectarLaNueva 
{

	public static Connection conect = null;
	ArrayList<Clientes> CDB = new ArrayList<Clientes>();
	ArrayList<Facturas> FDB = new ArrayList<Facturas>();
	
	void Conectar()
	{
		
		String servidor="jdbc:mysql://localhost/lanueva";
		String usuarioDB = "root";
		String passwordDB= "";
		try 
		{
			conect = DriverManager.getConnection(servidor,usuarioDB,passwordDB);
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (conect != null)
		{
			System.out.println("Conexion exitosa!");
		}
	}
	void leerClientes()
	{
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		String sql = "SELECT * FROM clientes";
		try 
		{
			pstm = conect.prepareStatement(sql);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				CDB.add(new Clientes(rs.getInt("id_cli"),rs.getString("nom_cli"),rs.getString("tel_cli")));
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
	void leerFacturas()
	{
		PreparedStatement pstm=null;
		ResultSet  rs=null;
		String sql = "SELECT * FROM factura";
		try 
		{
			pstm = conect.prepareStatement(sql);
			rs = pstm.executeQuery();
							
			while(rs.next())
			{
				int id_fac = rs.getInt("id_fac");
				int idcli_fac = rs.getInt("idcli_fac");
				float mon_fac = rs.getFloat("mon_fac"); 
				Date fec_fac = rs.getDate("fec_fac");
				Facturas f = new Facturas(id_fac,idcli_fac,mon_fac,fec_fac);
				FDB.add(f);
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
	void CerrarConexion()
	{
		if(conect!=null)
		{
			try 
			{
				conect.close();
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
