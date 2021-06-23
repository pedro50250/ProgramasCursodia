package Banregio;

public class Prestamos {
	String cliente;
	int id;
	String fecha;
	float Monto;
	String Estado;
	
	public Prestamos()
	{
		
	}
	public Prestamos(String cliente, int id, String fecha, float monto, String estado) {
		super();
		this.cliente = cliente;
		this.id = id;
		this.fecha = fecha;
		Monto = monto;
		Estado = estado;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public float getMonto() {
		return Monto;
	}
	public void setMonto(float monto) {
		Monto = monto;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	
	

}
