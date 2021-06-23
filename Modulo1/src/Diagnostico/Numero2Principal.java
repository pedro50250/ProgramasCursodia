package Diagnostico;

import java.util.ArrayList;
import java.util.Scanner;

import Tarea.Alumno;

public class Numero2Principal {
	ArrayList<Numero2>listaHilos = new ArrayList<Numero2>();
	
	public static void main(String[]args)
	{
		Numero2Principal num = new Numero2Principal();
		num.entrar();
		num.menu();
	}
	
	private void entrar()
	{
		for(int i=0;i<4;i++)
		{
			listaHilos.add(new Numero2());
		}
		for(Numero2 a: listaHilos)
		{
			a.start();
		}
	}
	
	private void menu()
	{
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		while(!salir)
		{
			System.out.println("Elija una opcion: \n"
					+ "1. Reloj(Hora Actual) \n"
					+ "2. Cronometro \n"
					+ "3. Contador inverso \n"
					+ "4. Recordatorio \n"
					+ "5. Salir");
			int opcion = Integer.parseInt(sc.nextLine());
			switch(opcion)
			{
			
			case 1: 
				listaHilos.get(0).evaluar("1");
				break;
			case 2: 
				listaHilos.get(1).evaluar("2");
				break;
			case 3: 
				listaHilos.get(2).evaluar("3");
				break;
			case 4: 
				listaHilos.get(3).evaluar("4");
				break;
			case 5: 
				salir= true;
				break;
			default:
				System.out.println("opcion inexistente");
			}
		}
	}
}
