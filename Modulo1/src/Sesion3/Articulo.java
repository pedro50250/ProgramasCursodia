package Sesion3;

public class Articulo {

	int cve_art;
	String nom_art;
	float pre_art;
	int cat_art;
	public Articulo(int cve_art, String nom_art, float pre_art, int cat_art) {
		this.cve_art = cve_art;
		this.nom_art = nom_art;
		this.pre_art = pre_art;
		this.cat_art = cat_art;
	}
	
	@Override
	public String toString()
	{
		return cve_art + "\t\t" + nom_art + "\t\t" + pre_art + "\t\t" + cat_art;
	}
}
