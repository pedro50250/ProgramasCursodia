package Diagnostico;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

public class Numero2 extends Thread {

	boolean activo = true;
	boolean ocupado = false;
	long inicioo = 0;
	long fin;
	boolean contandoCronometro = false;
	long numero_inv;
	boolean contando_inv = false;
	long numero_actual;
	boolean recordatorio_activo = false;
	String nom_recor;
	 LocalTime finn;
	 LocalTime inicio;
	
	public void run()
	{
		while(activo)
		{
			if(contando_inv==true)
			{
				contadorInv();
			}
			if(recordatorio_activo==true)
			{
				recordatorio();
			}
			
		}
	}
	
	public void evaluar(String linea)
	{
		Scanner sc = new Scanner(System.in);
			if(linea.equals("1"))
			{
				Date date = new Date();
				DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
				System.out.println("Hora: "+hourFormat.format(date));
				
			}
			if(linea.equals("2"))
			{
				if(contandoCronometro == false)
				{
					System.out.println("Iniciando el cronometro, vuelve a seleccionar la opcion cronometro cuando quieras parar");
				    inicioo = System.currentTimeMillis();
				    contandoCronometro=true;
				}
				else
				{
					fin = System.currentTimeMillis();
					double tiempo = (double) ((fin - inicioo)/1000);
					System.out.println("El cronometro estuvo un total de: " + tiempo);
					contandoCronometro = false;
				}
			}
			if(linea.equals("3"))
			{
				if(contando_inv==false)
				{
					System.out.println("Contandor inverso");
					System.out.print("Desde que numero quieres iniciar a contar hasta el 0? ");
					numero_inv = Integer.parseInt(sc.nextLine());
					contando_inv= true;
				}
				else
				{
					System.out.println("Va en el numero: " + numero_actual);
				}
				
			}
			//no esta al 100 esta funcion
			if(linea.equals("4"))
			{
				if(recordatorio_activo==false)
				{
					Date date = new Date();
					System.out.print("Que nombre le quieres poner al recordatorio?");
					nom_recor = sc.nextLine();
					try  {
			            System.out.print("Ingrese la fecha de ingreso: ");
			            System.out.print("Ingrese la hora del recordatorio ejemplo 12:05 ");
			             finn  = LocalTime.parse(sc.next());
						 inicio = LocalTime.now();
			        } catch(DateTimeParseException e) {
			            System.out.println("Fecha de ingreso o salida inválida");
			        }
					recordatorio_activo = true;
				}
				else
				{
					System.out.println("Ya se establecio un recordatorio hasta: " + finn);
				}
			}
		
		
		
	}
	
	private void contadorInv()
	{
		for(long i=numero_inv;i>0 ;i=i-1)
		{
			numero_actual = i;
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al momento del sleep");
				e.printStackTrace();
			}
		}
		System.out.println("SE TERMINO EL CONTADOR INVERSO!!");
		contando_inv = false;
	}
	
	private void recordatorio()
	{
		int minutes = (int) ChronoUnit.MINUTES.between(inicio, finn);
		if(minutes==0)
		{
			System.out.println(nom_recor + "ESTA PASANDOOOOOOOOO");
			recordatorio_activo = false;
		}
		
	}
}
