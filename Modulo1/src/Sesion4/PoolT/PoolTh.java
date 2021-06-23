package Sesion4.PoolT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolTh {

	public static void main(String[] args) {
		System.out.println("Hilos con el Pool Thread");
		Runnable R[] = new Runnable[20];
		for(int i = 0;i<20;i++)
		{
			R[i] = new ContadorP(i+1);
		}
		ExecutorService exe = Executors.newFixedThreadPool(5);
		for(Runnable C:R)
		{
			exe.execute(C);
		}

	}

}
