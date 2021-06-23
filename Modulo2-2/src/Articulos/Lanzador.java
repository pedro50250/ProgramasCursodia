package Articulos;

public class Lanzador {

	public static void main(String[] args) {
		Vista_Principal vis = new Vista_Principal();
		Modelo mod = new Modelo();
		Controlador con = new Controlador(vis, mod);
		con.Ejecutar();
	}

}
