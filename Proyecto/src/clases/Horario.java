package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class Horario {

	@Override
	public String toString() {
		return "Hora Salida: "+this.sale+" Hora de Llegada:" + this.llega;
	}

	ArrayList<ClaseHorario> horarios = new ArrayList<>();
	int id_vuelo;
	int id_avion;
	String nom_cap;
	int capa;
	String origenn;
	String destinoo;
	Time sale;
	Time llega;
	
	
	public Horario() {
	}

	public Horario(int id_vuelo, int id_avion, String nom_cap, int capa, String origenn, String destinoo, Time sale,
			Time llega) {
		this.id_vuelo = id_vuelo;
		this.id_avion = id_avion;
		this.nom_cap = nom_cap;
		this.capa = capa;
		this.origenn = origenn;
		this.destinoo = destinoo;
		this.sale = sale;
		this.llega = llega;
	}

	public ArrayList<ClaseHorario> extraerHorarios(String origen,String Destino)
	{
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM vuelos");
			while (rs.next()) {
				if(origen.equals(rs.getString(5))&& Destino.equals(rs.getString(6)))
					{
						int id_vuelo = rs.getInt(1);
						int id_avion = rs.getInt(2);
						String nom_cap = rs.getString(3);
						int capa = rs.getInt(4);
						String origenn = rs.getString(5);
						String destinoo = rs.getString(6);
						String a = rs.getString(7);
						Time sale = Time.valueOf(a);
						String b = rs.getString(8);
						Time llega = Time.valueOf(b);
						ClaseHorario hora = new ClaseHorario(id_vuelo,id_avion,nom_cap,capa,origenn,
								destinoo,sale,llega);
						horarios.add(hora);
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
		return horarios;
	}
	
	public String extraerHorario(int id_vuelo)
	{
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		String hora = "";
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM vuelos");
			while (rs.next()) {
				if(rs.getInt(1) == id_vuelo) {
					String b = rs.getString(7);
					Time llega = Time.valueOf(b);
					hora = "" + llega;
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
		return hora;

	}
}
