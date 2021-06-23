package application;

public class Lanzador 
{
	/* Version 1.0  23/05/2020
	 * Ejemplo Modelo-Vista-Controlador
	 * Creado por: Dr. Carlos Adrian Perez Cortez
	 * Para: Cursodia Diplomado Java 14
	 */
	public static void main(String[] args) 
	{
		VistaPrincipal vp = new VistaPrincipal();
		Modelos mod = new Modelos();
		Controlador con = new Controlador(mod, vp);
	}
	
}

