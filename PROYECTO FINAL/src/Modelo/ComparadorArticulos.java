package Modelo;

import java.util.Comparator;

public class ComparadorArticulos implements Comparator<articulo> {
	public String opcion;
	@Override
	public int compare(articulo o1, articulo o2) {
if (opcion.equals("Inventario")) {
			
			if (o1.getInv_art() > o2.getInv_art() ) {
				return -1;
			} else if (o1.getInv_art()  > o2.getInv_art() ) {
				return 0;
			} else {
				return 1;
			}
		} else if (opcion.equals("Categoria")) {
			if (o1.getCat_art() > o2.getCat_art()) {
				return -1;
			} else if (o1.getCat_art() > o2.getCat_art()) {
				return 0;
			} else {
				return 1;
			}
		}
		else if (opcion.equals("Precio")) {
			if (o1.getPre_art()> o2.getPre_art()) {
				return -1;
			} else if (o1.getPre_art() > o2.getPre_art()) {
				return 0;
			} else {
				return 1;
			}
		}
		return 0;
	}

}
