package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Cliente {

	public int cantidadClientes()
	{
		int cant=0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM clientes");
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
	public int insertarCliente(String nombre,String correo,String telefono,String metodo,String tarjeta) {

		int id_cliente = existeCliente(nombre,correo);
		if(id_cliente==0)
		{
			Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		int cant = cantidadClientes() +1;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			String query = "INSERT INTO clientes(id_clientes,nom_cliente,correo_cliente"
					+ ",numTel_cliente,pago_cliente,tarje_cliente) VALUES('"+cant+"','"+nombre+"','"+correo+"','"+telefono+"','"+
			metodo+"','"+ tarjeta+"')";
			stm.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Se hizo registro exitosamente");
			id_cliente = cant;
			//System.out.println("Se realizo");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
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
		 return id_cliente;
		

	}
	
	public int existeCliente(String nombre, String correo)
	{
		
		int id_cliente =0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM clientes");
			while (rs.next()) {
				if(rs.getString(2).equals(nombre) && rs.getString(3).equals(correo))
				{
					id_cliente = rs.getInt(1);
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
		return id_cliente;
	}
	
	public String nombreCliente(int idCliente)
	{
		String nombre="No existe alguien con ese ID";
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM clientes");
			while (rs.next()) {
				if(idCliente == rs.getInt(1))
				{
					nombre = rs.getString(2);
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
		
		return nombre;
	}
}
