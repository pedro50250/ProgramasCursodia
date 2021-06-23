package clases;

public class claseBoleto {

	public int idBoleto;
	public int idCliente;
	public int CantBoletos;
	public String fecha;
	public String hora;
	public claseBoleto(int idBoleto, int idCliente, int cantBoletos, String fecha, String hora) {
		this.idBoleto = idBoleto;
		this.idCliente = idCliente;
		CantBoletos = cantBoletos;
		this.fecha = fecha;
		this.hora = hora;
	}

}
