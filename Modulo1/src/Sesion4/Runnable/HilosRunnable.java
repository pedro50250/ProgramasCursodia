package Sesion4.Runnable;

public class HilosRunnable implements Runnable {

	int ID;
	public static void main(String[]args)
	{
		System.out.println("Hilos con Runnale");
		Runnable R[] = new Runnable[3];
		for(int i = 0;i<3;i++)
		{
			R[i]= new HilosRunnable(i+1);
		}
		for(Runnable n : R)
		{
			new Thread(n).start();
		}
	}
	
	public void run()
	{
		for(int i=1;i<=200;i++)
		{
			System.out.println("Hilo: " + ID + " Conteo: " + i);
		}
	}
	
	public HilosRunnable(int ID)
	{
		this.ID = ID;
	}
}
