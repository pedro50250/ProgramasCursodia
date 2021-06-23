package Modelo;

import java.util.Comparator;

public class ComparadorVentas implements Comparator<venta> {
	public String opcion;
	@Override
	public int compare(venta o1, venta o2) {
		
		if(opcion.equals("USUARIO")) {
		
			if(o1.getIdUsuario() > o2.getIdUsuario()) {
				return -1;
			} else if(o1.getIdUsuario() > o2.getIdUsuario()) {
				return 0;
			} else {
				return 1;
			}
	
		}else
		
		
		return 0;
	}

}
