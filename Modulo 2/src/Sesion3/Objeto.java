package Sesion3;

import java.awt.Component;

public class Objeto {
	int posX;
	int posY;
	int ancho;
	int alto;
	Component obj;
	String nombre;
	
	public Objeto(int posX, int posY, int ancho, int alto, Component obj, String nombre) {
		this.posX = posX;
		this.posY = posY;
		this.ancho = ancho;
		this.alto = alto;
		this.obj = obj;
		this.nombre = nombre;
	}
	

}
