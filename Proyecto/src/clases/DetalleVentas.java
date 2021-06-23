package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DetalleVentas {

	
	public void insertarDetalle(int idVenta,int idVuelo,int CantBol,String metodo,int idUsuario, float total) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		int cant = cantidadVentas() + 1;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			String query = "INSERT INTO detalleventas(id_detalleVenta,idVen_dven,idVue_dven,cant_dven,fdp_dven"
					+ ",id_Usuario,total_dven) VALUES('"+cant+"','"+idVenta +"','"+idVuelo+"','"+CantBol +"','"+ metodo +"','"+idUsuario
					+"','"+total+"')";
			stm.executeUpdate(query);
			System.out.println("Se regitro el detalle correctamente");

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

	
	public ArrayList<claseDetalles> extraerDetalles()
	{
		ArrayList<claseDetalles> detalles = new ArrayList<claseDetalles>();
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM detalleventas");
			while (rs.next()) {
				int idDetalle = rs.getInt(1);
				int idVenta = rs.getInt(2);
				int idVuelo = rs.getInt(3);
				int cant = rs.getInt(4);
				String metodo = rs.getString(5);
				int idUsuario = rs.getInt(6);
				float precio = rs.getFloat(7);
				detalles.add(new claseDetalles(idDetalle,idVenta,idVuelo,cant,metodo,idUsuario,precio));
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
		return detalles;
	}
	
	public int cantidadVentas() {
		int cant = 0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM detalleventas");
			while (rs.next()) {
				cant = rs.getInt(1);
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
		return cant;
	}
}
