package Modelo;

public class venta {
	private int idVenta;
	private int idUsuario;
	private int cantArt;
	
	public venta(int idVenta, int idUsuario, int cantArt, float monto, String fecha) {
		this.idVenta=idVenta;
		this.idUsuario=idUsuario;
		this.cantArt=cantArt;
		this.monto=monto;
		this.fecha=fecha;
	}
	
	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getCantArt() {
		return cantArt;
	}

	public void setCantArt(int cantArt) {
		this.cantArt = cantArt;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float monto;
	public String fecha;
	
	
	
	
}
