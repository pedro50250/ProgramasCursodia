package Modelo;

public class detalle_venta {
	private int idVenta;
	private int idArticulo;
	private int cantidad;
	private float precio;
	
	public detalle_venta(int idVenta, int idArticulo, int cantidad, float precio) {
		this.idVenta=idVenta;
		this.idArticulo=idArticulo;
		this.cantidad=cantidad;
		this.precio=precio;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
