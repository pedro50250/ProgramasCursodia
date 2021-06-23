package controlTiempo;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

public class Reloj extends Thread 
{
	boolean count=true;
	Consulta co;
	public  void run()
	{
		while(count)
		{
			String  time =ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
			co.hsystem.setText(time);
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
	public Reloj(Consulta co)
	{
		this.co = co;
	}
}
