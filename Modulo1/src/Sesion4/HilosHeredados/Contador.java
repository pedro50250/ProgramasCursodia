package Sesion4.HilosHeredados;

public class Contador extends Thread {
	int ID;
	public void run() // Desde aqui empiez a ejecutarse el hilo
	{
		for(int i=1;i<=200;i++)
		{
			System.out.println("Soy el hilo " + ID +" y voy en el: " + i);
			
		}
	}
	
	public Contador(int ID)
	{
		this.ID = ID;
	}
}
