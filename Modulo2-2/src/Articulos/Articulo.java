package Articulos;

public class Articulo implements Comparable<Articulo>{

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
	public String toString() {
		return "" + this.cve_art + "          " + this.nom_art + "          " + this.pre_art + "          "
				+ this.cat_art + "\n";
	}

	@Override
	public int compareTo(Articulo o) {
		if(o.getCve_art()>cve_art)
		{
			return -1;
		}
		else if(o.getCve_art()<cve_art)
		{
			return 1;
		}
		return 0;
	}

	int getCve_art() {
		return cve_art;
	}

	void setCve_art(int cve_art) {
		this.cve_art = cve_art;
	}

	String getNom_art() {
		return nom_art;
	}

	void setNom_art(String nom_art) {
		this.nom_art = nom_art;
	}

	float getPre_art() {
		return pre_art;
	}

	void setPre_art(float pre_art) {
		this.pre_art = pre_art;
	}

	int getCat_art() {
		return cat_art;
	}

	void setCat_art(int cat_art) {
		this.cat_art = cat_art;
	}
};