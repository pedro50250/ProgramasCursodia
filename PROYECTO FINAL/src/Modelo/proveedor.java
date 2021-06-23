package Modelo;

public class proveedor {
	private int id_prov;
	private String nom_prov,tel_prov,dir_prov,email_prov;
	
	public proveedor()
	{
		
	}

	public proveedor(int id_prov, String nom_prov, String tel_prov, String dir_prov, String email_prov) {
		this.id_prov = id_prov;
		this.nom_prov = nom_prov;
		this.tel_prov = tel_prov;
		this.dir_prov = dir_prov;
		this.email_prov = email_prov;
	}

	public int getId_prov() {
		return id_prov;
	}

	public void setId_prov(int id_prov) {
		this.id_prov = id_prov;
	}

	public String getNom_prov() {
		return nom_prov;
	}

	public void setNom_prov(String nom_prov) {
		this.nom_prov = nom_prov;
	}

	public String getTel_prov() {
		return tel_prov;
	}

	public void setTel_prov(String tel_prov) {
		this.tel_prov = tel_prov;
	}

	public String getDir_prov() {
		return dir_prov;
	}

	public void setDir_prov(String dir_prov) {
		this.dir_prov = dir_prov;
	}

	public String getEmail_prov() {
		return email_prov;
	}

	public void setEmail_prov(String email_prov) {
		this.email_prov = email_prov;
	}
	
	
	

}
