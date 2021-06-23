package Modelo;

public class corte {

	
	private int id_cor;
	private String fecha_cor;
	private int idUsu_cor;
	private float ingre_cor;
	private float egre_cor;
	private float util_cor;
	
	public corte(int id_cor, String fecha_cor, int idUsu_cor, float ingre_cor, float egre_cor, float util_cor) {
		this.id_cor=id_cor;
		this.fecha_cor=fecha_cor;
		this.idUsu_cor=idUsu_cor;
		this.ingre_cor=ingre_cor;
		this.egre_cor=egre_cor;
		this.util_cor=util_cor;
		
	}

	public int getId_cor() {
		return id_cor;
	}

	public void setId_cor(int id_cor) {
		this.id_cor = id_cor;
	}

	public String getFecha_cor() {
		return fecha_cor;
	}

	public void setFecha_cor(String fecha_cor) {
		this.fecha_cor = fecha_cor;
	}

	public int getIdUsu_cor() {
		return idUsu_cor;
	}

	public void setIdUsu_cor(int idUsu_cor) {
		this.idUsu_cor = idUsu_cor;
	}

	public float getIngre_cor() {
		return ingre_cor;
	}

	public void setIngre_cor(float ingre_cor) {
		this.ingre_cor = ingre_cor;
	}

	public float getEgre_cor() {
		return egre_cor;
	}

	public void setEgre_cor(float egre_cor) {
		this.egre_cor = egre_cor;
	}

	public float getUtil_cor() {
		return util_cor;
	}

	public void setUtil_cor(float util_cor) {
		this.util_cor = util_cor;
	}
	
	
	
}
