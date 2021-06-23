package clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class Corte {
	public static void main(String []args)
	{
		Corte cor = new Corte();
		ArrayList<claseCorte> cortes = new ArrayList<claseCorte>();
		cor.generarCorte("2020-05-29");
		cortes = cor.verCortes();
		for(int i=0;i<cortes.size();i++)
		{
			System.out.println("id corte" + cortes.get(i).id_corte);
		}
	}
	
	public void generarCorte(String Fecha)
	{
		boolean existe = existeDia(Fecha);
		if(existe==true)
		{
			Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		int id = cantidadCortes() + 1;
		try {
			float dinero = extraerDinero(Fecha);
			cn = conexion.conectar();
			stm = cn.createStatement();
			Calendar fecha = new GregorianCalendar();
			int año = fecha.get(Calendar.YEAR);
			int mes = fecha.get(Calendar.MONTH);
			int dia = fecha.get(Calendar.DAY_OF_MONTH);
			String  fec= "" + año +"-"+mes+"-"+dia;
			Date fech = Date.valueOf(fec);
			String query = "INSERT INTO cortes(id_corte,dinero_corte,dia_generado,dia_Venta) VALUES"
					+ "('"+id+"','"+dinero+"','"+fech+"','"+Fecha+"')";
			stm.executeUpdate(query);
			System.out.println("Se registraro el corte");

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
			JOptionPane.showMessageDialog(null, "No hay ventas en ese dia");
		}
		
	}
	
	public int cantidadCortes() {
		int cant = 0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM cortes");
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
	
	public float extraerDinero(String fecha)
	{
		float dinero=0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM ventas");
			while (rs.next()) {
				String dia = rs.getString(6);
				if(fecha.equals(dia))
				{
					dinero = dinero + rs.getFloat(5);
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
		return dinero;
	}

	public boolean existeDia(String dia) {
		boolean existe = false;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM ventas");
			while (rs.next()) {
				if (dia.equals(rs.getString(6))) {
					existe = true;
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
	public ArrayList<claseCorte> verCortes()
	{
		ArrayList<claseCorte> cortes = new ArrayList<claseCorte>();
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM cortes");
			while (rs.next()) {
				int id_corte = rs.getInt(1);
				float dinero = rs.getFloat(2);
				String dia = rs.getString(3);
				String diaVenta = rs.getString(4);
				cortes.add(new claseCorte(id_corte,dinero,dia,diaVenta));
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
		return cortes;
	}
}
