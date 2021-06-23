package clases;

public class claseVuelo {

	public int id_vuelo,id_avion,capacidad;
	public String capitan,Origen,Destino,HoraSalida,HoraLlegada;
	public claseVuelo(int id_vuelo, int id_avion, int capacidad, String capitan, String origen, String destino,
			String horaSalida, String horaLlegada) {
		this.id_vuelo = id_vuelo;
		this.id_avion = id_avion;
		this.capacidad = capacidad;
		this.capitan = capitan;
		Origen = origen;
		Destino = destino;
		HoraSalida = horaSalida;
		HoraLlegada = horaLlegada;
	}
	
	
}
