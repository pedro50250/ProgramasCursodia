package Servidor;

public class Cliente {

	private String ipAddress;
	private String nomCliente;
	private int puertoRemoto;
	private HiloCliente hilo;
	

	public Cliente(String ipAddress, String nomCliente,int puertoRemoto) {
		this.ipAddress = ipAddress;
		this.nomCliente = nomCliente;
		this.puertoRemoto = puertoRemoto;
	}
	
	public int getPuertoRemoto() {
		return puertoRemoto;
	}

	public void setPuertoRemoto(int puertoRemoto) {
		this.puertoRemoto = puertoRemoto;
	}
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public HiloCliente getHilo() {
		return hilo;
	}

	public void setHilo(HiloCliente hilo) {
		this.hilo = hilo;
	}
	
	
	
	
	
}
