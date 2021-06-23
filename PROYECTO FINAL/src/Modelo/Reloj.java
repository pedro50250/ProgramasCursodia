package Modelo;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import Vista.MenuAdmin;

public class Reloj extends Thread 
{
	boolean count=true;
	MenuAdmin vista;
	public  void run()
	{
		while(count)
		{
			String  time =ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
			vista.lblHora.setText(time);
			try 
			{
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(time);
		}
	}
	public Reloj(MenuAdmin vista)
	{
		this.vista = vista;
	}
}
