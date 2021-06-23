package clases;

public class claseUsuario {

	public int id_usuario,niv_usuario,numCompras,numVentas;
	public String nombre, password;
	public claseUsuario(int id_usuario, int niv_usuario, int numCompras, int numVentas, String nombre,
			String password) {
		this.id_usuario = id_usuario;
		this.niv_usuario = niv_usuario;
		this.numCompras = numCompras;
		this.numVentas = numVentas;
		this.nombre = nombre;
		this.password = password;
	}
	
}
