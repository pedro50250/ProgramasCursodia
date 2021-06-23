package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Usuario {
	int id_usu;
	String nom_usu, pas_usu;
	int niv_usu, num_ventas,num_compras;  
	ArrayList<String> usuarios = new ArrayList<String>();
	ArrayList<String> contraseña = new ArrayList<String>();
	ArrayList<Integer> IDUsuario = new ArrayList<Integer>();
	
	
	public boolean buscarUsuario(String usuario, String contraseña) {
		boolean encontrado = false;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuarios");

			while (rs.next()) {
				String nombre_usuario = rs.getString(2);
				String password = rs.getString(3);
				if (usuario.equals(nombre_usuario) && contraseña.equals(password)) {
					encontrado = true;
				}
			}

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
		return encontrado;
	}

	public int buscarNivel(String usuario, String contraseña)
	{
		int nivel=0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuarios");

			while (rs.next()) {
				String nombre_usuario = rs.getString(2);
				String password = rs.getString(3);
				if (usuario.equals(nombre_usuario) && contraseña.equals(password)) {
					nivel = rs.getInt(4);
				}

			}

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
		return nivel;
	}
	public void insertarUsuarioNuevo(String usuario, String contraseña,int niv) {
		boolean buscar = buscarUsuario(usuario, contraseña);
		if (buscar == false) {
			Conexion conexion = new Conexion();
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;

			try {
				int id = cantidadUsuarios() +1;
				cn = conexion.conectar();
				stm = cn.createStatement();
				String query = "INSERT INTO usuarios (id_Usu,nom_Usu,pas_Usu,niv_Usu,num_Ventas,num_Compras)"
						+ " VALUES('"+id+"','" + usuario + "','" + contraseña+ "','"+niv+"','0','0')";
				stm.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");

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
			JOptionPane.showMessageDialog(null, "Ese usuario ya esta registrado");
		}
	}
	public void eliminarUsuario(String usuario,String password)
	{
		boolean buscar = buscarUsuario(usuario, password);
		if (buscar == true) 
		{
			Conexion conexion = new Conexion();
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;

			try {
				int id = buscarID(usuario, password);
				cn = conexion.conectar();
				stm = cn.createStatement();
				String query = "DELETE FROM usuarios WHERE id_Usu='"+id+"'";
				stm.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");

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
			JOptionPane.showMessageDialog(null, "Ese usuario ya esta registrado");
		}
	}
	
	public int cantidadUsuarios() {
		int cant = 0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuarios");
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
	public int buscarID(String usuario, String contraseña) {
		int idUsuario=0;
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuarios");

			while (rs.next()) {
				String nombre_usuario = rs.getString(2);
				String password = rs.getString(3);
				if (usuario.equals(nombre_usuario) && contraseña.equals(password)) {
					idUsuario = rs.getInt(1);
				}
			}

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
		return idUsuario;
	}
	
	public void insertarVenta(int id_Usuario) {

		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			String query = "UPDATE usuarios SET num_Ventas = num_Ventas + 1 WHERE id_Usu='" + id_Usuario+"'";
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
	}
	
	public ArrayList<claseUsuario> extraerUsuarios()
	{
		ArrayList<claseUsuario> usu = new ArrayList<claseUsuario>();
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuarios");

			while (rs.next()) {
				int id = rs.getInt(1);
				String nombre_usuario = rs.getString(2);
				String password = rs.getString(3);
				int niv = rs.getInt(4);
				int ventas = rs.getInt(5);
				int compras = rs.getInt(6);
				usu.add(new claseUsuario(id,niv,compras,ventas,nombre_usuario,password));
			}

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
		return usu;
	}
}

