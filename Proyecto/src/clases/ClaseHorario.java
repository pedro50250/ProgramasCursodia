package clases;

import java.sql.Time;

public class ClaseHorario {

	public int id_vuelo;
	public int id_avion;
	public String nom_cap;
	public int capa;
	public String origenn;
	public String destinoo;
	public Time sale;
	public Time llega;
	
	
	public ClaseHorario() {
	}

	public ClaseHorario(int id_vuelo, int id_avion, String nom_cap, int capa, String origenn, String destinoo, Time sale,
			Time llega) {
		this.id_vuelo = id_vuelo;
		this.id_avion = id_avion;
		this.nom_cap = nom_cap;
		this.capa = capa;
		this.origenn = origenn;
		this.destinoo = destinoo;
		this.sale = sale;
		this.llega = llega;
	}
}
