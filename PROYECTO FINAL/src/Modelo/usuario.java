package Modelo;

public class usuario {

	private int idUsuario;
	private String usuario;
	private String contrase�a;
	private int numVentas,numCompras,nivUsuario;
	public usuario()
	{
		
	}
	public usuario(int idUsuario, String usuario, String contrase�a, int numVentas, int numCompras, int nivUsuario) {
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
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
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
