package Modelo;

public class compra {
/////345 PESOS 
	private int id_com;
	private int idProv_com;
	private int idUsu_com;
	private float tot_com;
	private String fech_com;
	
	public compra(int id_com, int idProv_com, int idUsu_com, float tot_com, String fech_com) {
		this.id_com=id_com;
		this.idProv_com=idProv_com;
		this.idUsu_com=idUsu_com;
		this.tot_com=tot_com;
		this.fech_com=fech_com;
	}

	public int getId_com() {
		return id_com;
	}

	public void setId_com(int id_com) {
		this.id_com = id_com;
	}

	public int getIdProv_com() {
		return idProv_com;
	}

	public void setIdProv_com(int idProv_com) {
		this.idProv_com = idProv_com;
	}

	public int getIdUsu_com() {
		return idUsu_com;
	}

	public void setIdUsu_com(int idUsu_com) {
		this.idUsu_com = idUsu_com;
	}

	public float getTot_com() {
		return tot_com;
	}

	public void setTot_com(float tot_com) {
		this.tot_com = tot_com;
	}

	public String getFech_com() {
		return fech_com;
	}

	public void setFech_com(String fech_com) {
		this.fech_com = fech_com;
	}

}
