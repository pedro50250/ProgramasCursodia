package clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Boleto {

	
	public int insertarBoleto(int id_cliente,int cantBol,String fecha, String horaVuelo) {
		int id =0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		int cant = cantidadBoletos() + 1;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			Date fec= Date.valueOf(fecha);
			String query = "INSERT INTO boletos(id_boleto,idCliente_boleto,cant_boleto,fech_boleto,"
					+ "horaVue_boleto) VALUES('" + cant + "','" + id_cliente + "','" + cantBol +"','" +fec
					+ "','" + horaVuelo+ "')";
			stm.executeUpdate(query);
			id= cant;
			System.out.println("Se registraron los boletos");

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
		return id;
	}

	public int cantidadBoletos() {
		int cant = 0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM boletos");
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
	
	public ArrayList<claseBoleto> extraerBoletos()
	{
		ArrayList<claseBoleto> boletos= new ArrayList<claseBoleto>();
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM boletos");
			while (rs.next()) {
				int id_boleto = rs.getInt(1);
				int id_cliente = rs.getInt(2);
				int cantidad = rs.getInt(3);
				String fecha = "" + rs.getDate(4);
				String hora = "" + rs.getString(5);
				claseBoleto bol = new claseBoleto(id_boleto, id_cliente, cantidad, fecha, hora);
				boletos.add(bol);
				
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
		return boletos;
	}
}
