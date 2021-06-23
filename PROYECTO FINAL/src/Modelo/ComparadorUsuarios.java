package Modelo;

import java.util.Comparator;

public class ComparadorUsuarios implements Comparator<usuario> {
public String opcion;
	@Override
	public int compare(usuario o1, usuario o2) {
		if (opcion.equals("Ventas")) {
			
			if (o1.getNumVentas() > o2.getNumVentas()) {
				return -1;
			} else if (o1.getNumVentas() > o2.getNumVentas()) {
				return 0;
			} else {
				return 1;
			}
		} else if (opcion.equals("Compras")) {
			if (o1.getNumCompras() > o2.getNumCompras()) {
				return -1;
			} else if (o1.getNumCompras() > o2.getNumCompras()) {
				return 0;
			} else {
				return 1;
			}
		}
		
		return 0;
	}

}
