package clases;

public class claseDetalles {

	public int idDetalle,idVenta,idVuelo,CantBol,idUsuario;
	public String metodo;
	public float total;
	public claseDetalles(int idDetalle, int idVenta, int idVuelo, int cantBol,  String metodo,int idUsuario,
			float total) {
		this.idDetalle = idDetalle;
		this.idVenta = idVenta;
		this.idVuelo = idVuelo;
		this.CantBol = cantBol;
		this.idUsuario = idUsuario;
		this.metodo = metodo;
		this.total = total;
	}
	
	
}
