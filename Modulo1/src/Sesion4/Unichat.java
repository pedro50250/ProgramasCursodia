package Sesion4;

import java.util.ArrayList;
import java.util.Scanner;

public class Unichat {

	ArrayList<Alumno>listaChat = new ArrayList<Alumno>();
	Scanner sc = new Scanner(System.in);
	String miNombre = null;
	boolean enlinea= true;
	
	public static void main(String[] args) {

		Unichat uc = new Unichat();
		uc.entrar();
		uc.Chat();
	}
	
	public void entrar()
	{
		System.out.println("Entrando al chat universitario");
		System.out.println("Con que nombre desa entrar?");
		miNombre = sc.nextLine();
		
		for(int i=0;i<3;i++)
		{
			listaChat.add(new Alumno());
		}
		for(Alumno a: listaChat)
		{
			a.start();
		}
	}
	
	private void Chat()
	{
		while(enlinea)
		{
			System.out.print("Escribe algo: ");
			String linea = sc.nextLine();
			evaluar(linea);
		}
	}
	
	private void evaluar(String linea)
	{
		String palabras[]= linea.split(" ");
		if(linea.equals("exit"))
		{
			System.out.println("Saliendo del chat universitario");
			enlinea=false;
		}
		if(palabras[0].equals("adios"))
		{
			for(Alumno a: listaChat)
			{
				if(a.miNombre.equals(palabras[1]))
				{
					a.salir();
				}
			}
		}
		else
		{
			System.out.println(miNombre + " dice " + linea);
			for(Alumno a: listaChat)
			{
				a.evaluar(linea);
			}
		}
		
	}

}
