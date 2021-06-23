package Modelo;

public class detalle_compra {

	private int idCom_detC;
	private int idArt_detC;
	private int cant_detC;
	private float precio;
	
	public detalle_compra(int idCom_detC, int idArt_detC, int cant_detC, float precio) {
		this.idCom_detC=idCom_detC;
		this.idArt_detC=idArt_detC;
		this.cant_detC=cant_detC;
		this.precio=precio;
	}

	public int getIdCom_detC() {
		return idCom_detC;
	}

	public void setIdCom_detC(int idCom_detC) {
		this.idCom_detC = idCom_detC;
	}

	public int getIdArt_detC() {
		return idArt_detC;
	}

	public void setIdArt_detC(int idArt_detC) {
		this.idArt_detC = idArt_detC;
	}

	public int getCant_detC() {
		return cant_detC;
	}

	public void setCant_detC(int cant_detC) {
		this.cant_detC = cant_detC;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
	
}
