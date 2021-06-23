package Modelo;

public class articulo {

	private int cve_art;
	private String nom_art;
	private float pre_art;
	private int cat_art,idprov_art,inv_art;
	public articulo()
	{
		
	}
	public articulo(int cve_art, String nom_art, float pre_art, int cat_art, int idprov_art, int inv_art) {
		this.cve_art = cve_art;
		this.nom_art = nom_art;
		this.pre_art = pre_art;
		this.cat_art = cat_art;
		this.idprov_art = idprov_art;
		this.inv_art = inv_art;
	}
	
	public int getCve_art() {
		return cve_art;
	}
	public void setCve_art(int cve_art) {
		this.cve_art = cve_art;
	}
	public String getNom_art() {
		return nom_art;
	}
	public void setNom_art(String nom_art) {
		this.nom_art = nom_art;
	}
	public float getPre_art() {
		return pre_art;
	}
	public void setPre_art(float pre_art) {
		this.pre_art = pre_art;
	}
	public int getCat_art() {
		return cat_art;
	}
	public void setCat_art(int cat_art) {
		this.cat_art = cat_art;
	}
	public int getIdprov_art() {
		return idprov_art;
	}
	public void setIdprov_art(int idprov_art) {
		this.idprov_art = idprov_art;
	}
	public int getInv_art() {
		return inv_art;
	}
	public void setInv_art(int inv_art) {
		this.inv_art = inv_art;
	}
	
	
	
}
