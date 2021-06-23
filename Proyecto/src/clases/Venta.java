package clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Venta {

	public int insertarVenta(int id_boleto,int idVuelo,int idUsuario, float total) {
		
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		int cant = cantidadVentas() + 1;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			Calendar fecha = new GregorianCalendar();
			int año = fecha.get(Calendar.YEAR);
			int mes = fecha.get(Calendar.MONTH);
			int dia = fecha.get(Calendar.DAY_OF_MONTH);
			String  fec= "" + año +"-"+mes+"-"+dia;
			Date fech = Date.valueOf(fec);
			String query = "INSERT INTO ventas(id_ventas,idBoleto_Venta,idVuelo_venta,idUsuario_venta,"
					+ "precioTot_venta,fecha_venta) VALUES('" + cant + "','" + id_boleto + "','" + idVuelo +"','" +idUsuario
					+ "','" + total+ "','"+fech+"')";
			stm.executeUpdate(query);
			System.out.println("Se regitro la venta correctamente");

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
		return cant;
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
			rs = stm.executeQuery("SELECT * FROM ventas");
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
