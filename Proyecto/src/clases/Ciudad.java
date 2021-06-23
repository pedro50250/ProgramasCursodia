package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ciudad {

	public ArrayList<String> ciudades = new ArrayList<String>();
	
	public ArrayList<String> extraerCiudades()
	{
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM ciudades");
			while (rs.next()) {
				String ciudad = rs.getString(2);
				ciudades.add(ciudad);
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
		return ciudades;
	}
	
	public boolean existeCiudad(String Ciudad)
	{
		boolean existe=false;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM ciudades");
			while (rs.next()) {
				if(Ciudad.equals(rs.getString(2)))
				{
					existe=true;
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
		return existe;
	}
	
	public void insertarCiudad(String Ciudad,String Estado, String Pais) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		boolean existe = existeCiudad(Ciudad);
		if (existe == false) {
			try {
				int num_ciudad = numCiudad() +1;
				cn = conexion.conectar();
				stm = cn.createStatement();

				String query = "INSERT INTO ciudades(id_ciudad,nom_ciudad,nom_estado,nom_pais)"
						+ " VALUES('+"+num_ciudad+"','"+Ciudad+"','"+Estado+"','"+Pais+"')";
				stm.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Se Registro la ciudad Correctamente");

			} catch (SQLException e) {
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
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Esa ciudad ya esta Registrada");
		}
		

	}

	public ArrayList<claseCiudad> extraerCiudade()
	{
		ArrayList<claseCiudad> ciudades = new ArrayList<claseCiudad>();
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM ciudades");
			while (rs.next()) {
				int id_ciudad = rs.getInt(1);
				String ciudad = rs.getString(2);
				String estado = rs.getString(3);
				String pais = rs.getString(4);
				ciudades.add(new claseCiudad(id_ciudad,ciudad,estado,pais));
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
		return ciudades;
	}
	public int numCiudad()
	{
		int num=0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM ciudades");
			while (rs.next()) {
				num= rs.getInt(1);
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
		return num;
	}
	
	public void borrarCiudad(String Ciudad)
	{
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		boolean existe = existeCiudad(Ciudad);
		if (existe == true) {
			try {
				cn = conexion.conectar();
				stm = cn.createStatement();
				String query = "DELETE FROM ciudades WHERE nom_ciudad='"+Ciudad+"'";
				stm.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Se Borro la ciudad Correctamente");

			} catch (SQLException e) {
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
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Esa ciudad no esta Registrada");
		}
	}
}
