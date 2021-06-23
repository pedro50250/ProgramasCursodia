package Sesion4;

import java.util.Random;

public class Alumno extends Thread{

	String nombres[] = new String[] {"Alejandro","Amanda","Roman","Antonio","Perla","Julia","Teresa","Silvia","Jorge"};
	String miNombre;
	String facultades[] = new String[] {"FIME","FACPyA","Leyes","Arqui","FOD","Fisico Mate"};
	String miFacultad;
	int miEdad;
	boolean conectado = true;
	public void run()
	{
		inicializar();
		while(conectado)
		{
			
		}
		System.out.println(miNombre + " dice:" + "adios!");
	}
	
	private void inicializar()
	{
		Random ran = new Random();
		int sel = ran.nextInt(nombres.length);
		miNombre = nombres[sel];
		sel =  ran.nextInt(facultades.length);
		miFacultad = facultades[sel];
		miEdad = 18 + ran.nextInt(4);
		System.out.println(miNombre + " a entrado al chat...");
	}
	
	public void evaluar(String linea)
	{
		String[] palabras = linea.split(" ");
		if(palabras[palabras.length-1].equals(miNombre + "?"))
		{
			String lineaaEvaluar = palabras[0];
			for(int i =1;i<palabras.length-1 ; i++)
			{
				lineaaEvaluar +=" "+ palabras[i];
			}
			if(lineaaEvaluar.equals("cuantos años tienes"))
			{
				System.out.println(miNombre + " dice " + miEdad + " y tu?");
			}
			else if(lineaaEvaluar.equals("de que facu eres"))
			{
				System.out.println(miNombre + " dice " + miFacultad + " y tu?");
			}
		}
		if(linea.equals("adios " + miNombre))
		{
			conectado = false;
		}
	}
	
	public void salir()
	{
		conectado = false;
	}
	
}
