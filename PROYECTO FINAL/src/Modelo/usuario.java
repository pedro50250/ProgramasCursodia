package Modelo;

public class usuario {

	private int idUsuario;
	private String usuario;
	private String contraseña;
	private int numVentas,numCompras,nivUsuario;
	public usuario()
	{
		
	}
	public usuario(int idUsuario, String usuario, String contraseña, int numVentas, int numCompras, int nivUsuario) {
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.numVentas = numVentas;
		this.numCompras = numCompras;
		this.nivUsuario = nivUsuario;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public int getNumVentas() {
		return numVentas;
	}
	public void setNumVentas(int numVentas) {
		this.numVentas = numVentas;
	}
	public int getNumCompras() {
		return numCompras;
	}
	public void setNumCompras(int numCompras) {
		this.numCompras = numCompras;
	}
	public int getNivUsuario() {
		return nivUsuario;
	}
	public void setNivUsuario(int nivUsuario) {
		this.nivUsuario = nivUsuario;
	}
	
	
}
