package prueba;

public class articulo {

	public int cve_art;
	public String nom_art;
	public float pre_art;
	public int cat_art,inv_art;
	public float total_art;
	public articulo()
	{
		
	}
	public articulo(int cve_art, String nom_art,  int cat_art,float pre_art, int inv_art,float total_art) {
		this.cve_art = cve_art;
		this.nom_art = nom_art;
		this.pre_art = pre_art;
		this.cat_art = cat_art;
		this.inv_art = inv_art;
		this.total_art = total_art;
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
	public int getInv_art() {
		return inv_art;
	}
	public void setInv_art(int inv_art) {
		this.inv_art = inv_art;
	}
	public float getTotal_art() {
		return total_art;
	}
	public void setTotal_art(float total_art) {
		this.total_art = total_art;
	}
	
	
}
