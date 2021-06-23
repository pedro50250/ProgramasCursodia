 package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Vuelo {

	ArrayList<Integer> disponibles = new ArrayList<Integer>();

	public int extraerCapacidadDisponible(int id_vuelo) {
		int asientos_disp = 0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM vuelos");
			while (rs.next()) {
				if (id_vuelo == rs.getInt(1)) {
					asientos_disp = rs.getInt(4);
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
		return asientos_disp;
	}

	public void restarCapacidadDisponible(int id_vuelo, int  cantAsientos) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			int capacidad_disp = extraerCapacidadDisponible(id_vuelo);
			int nueva_capacidad = capacidad_disp - cantAsientos;
			String query = "UPDATE vuelos SET capa_vuelo=" + nueva_capacidad + "  WHERE id_vuelo ="+ id_vuelo + "";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Se hizo la transaccion exitosamente");
			//System.out.println("Se realizo");

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
	
	public void insertarVuelo(int id_avion,String nom_capi,String Origen,String Destino,Time horaSalida,Time horaLlegada)
	{
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		int id_vuelo = numVuelo()+1;
		boolean existeAvion = existeAvion(id_avion);
		if (existeAvion) {

			boolean existeCiudadOri = existeCiudad(Origen);
			if (existeCiudadOri) {
				if (Destino.equals(Origen) == false) {
					boolean existeCiudadDes = existeCiudad(Destino);
					if (existeCiudadDes) {
						try {
							int capacidad = capacidadAvion(id_avion);
							cn = conexion.conectar();
							stm = cn.createStatement();
							String query = "INSERT INTO vuelos(id_vuelo,id_avion_vuelo,capi_vuelo,capa_vuelo,ori_vuelo,des_vuelo,horSal_vuelo,"
									+ "horLle_vuelo) VALUES('" + id_vuelo + "','+" + id_avion + "','" + nom_capi + "','"+capacidad+"','"
									+ Origen + "','" + Destino + "'," + "'" + horaSalida + "','" + horaLlegada + "')";
							stm.executeUpdate(query);
							System.out.println("Se registro el vuelo correctamente");

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
					} else {
						JOptionPane.showMessageDialog(null, "La ciudad de Destino no existe en la base de datos");
					}

				} else {
					JOptionPane.showMessageDialog(null, "La ciudad de Origen no puede ser la misma que la de Destino");
				}

			} else {
				JOptionPane.showMessageDialog(null, "No existe esa ciudad en la base de datos");
			}

		} else {
			JOptionPane.showMessageDialog(null, "No existe ese avion en la base de datos");
		}
		
	}
	
	public int numVuelo()
	{
		int num=0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM vuelos");
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
	
	public boolean existeAvion(int id_avion)
	{
		boolean existe = false;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM aviones");
			while (rs.next()) {
				if (id_avion==rs.getInt(1)) {
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
	
	public int capacidadAvion(int id_avion)
	{
		int capa=0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM aviones");
			while (rs.next()) {
				if(id_avion==rs.getInt(1))
				{
					capa=rs.getInt(4);
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
		return capa;
	}
	public ArrayList<claseVuelo> extraerVuelos()
	{
		ArrayList<claseVuelo> vuelos = new ArrayList<claseVuelo>();
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM vuelos");
			while (rs.next()) {
				int id_vuelo = rs.getInt(1);
				int id_avion = rs.getInt(2);
				String nom = rs.getString(3);
				int capacidad = rs.getInt(4);
				String origen = rs.getString(5);
				String destino = rs.getString(6);
				String horaSalida = "" + rs.getString(7);
				String horaLlegada = "" + rs.getString(8);
				vuelos.add(new claseVuelo(id_vuelo, id_avion, capacidad, nom, origen, destino, horaSalida, horaLlegada));
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
		return vuelos;
	}
	
	public void borrarVuelo(int id_vuelo)
	{
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			String query = "DELETE FROM vuelos WHERE id_vuelo='"+id_vuelo+"'";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Se borro el vuelo exitosamente");
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
}
	

