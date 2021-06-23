package Sesion4.HilosHeredados;

import java.util.ArrayList;

public class Lanzador {

	public static void main(String[] args)
	{
		Lanzador I = new Lanzador();
		I.lanzarHilos();
	}

	private void lanzarHilos() {
		ArrayList<Contador> H = new ArrayList<Contador>();
		for(int i=0;i<5;i++)
		{
			Contador C = new Contador(i+1);
			H.add(C);
		}
		for(Contador co : H)
		{
			co.start();
		}
		
	}
}
