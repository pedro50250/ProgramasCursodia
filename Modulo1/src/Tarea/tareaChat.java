package Tarea;

import java.util.ArrayList;
import java.util.Scanner;


 public class tareaChat  {
	ArrayList<Alumno>listaChat = new ArrayList<Alumno>();
	Scanner sc = new Scanner(System.in);
	String miNombre = null;
	boolean enlinea= true;
	ArrayList <String> opciones = new ArrayList<String>();
	ArrayList <String> tareas = new ArrayList<String>();
	String op[];
	String red="\033[31m";
	
	public static void main(String[] args) {

		tareaChat uc = new tareaChat();
		uc.opcionesDefinidas();
		uc.declararTareas();
		uc.entrar();
		uc.Chat();
	}
	
	public void entrar()
	{
		System.out.println("Entrando al chat de Equipo");
		System.out.println("Con que nombre desa entrar?");
		miNombre = sc.nextLine();
		for(int i=0;i<2;i++)
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
			String linea = sc.nextLine();
			evaluar(linea);
		}
	}
	
	private void evaluar(String linea)
	{
		String palabras[]= linea.split(" ");
		if(linea.equals("terminamos"))
		{
			sc.close();
			System.out.println("Saliendo del chat universitario");
			enlinea=false;
		}
		if(palabras[0].equals("adios"))
		{
			for(Alumno a: listaChat)
			{
				if(a.miNombre.equals(palabras[1]))
				{
					sc.close();
					a.salir();
				}
			}
		}
		else
		{
			System.out.println(miNombre + " dice: " + linea);
			for(Alumno a: listaChat)
			{
			   a.evaluar(linea,tareas);
			}
		}
	}
	
	public void declararTareas()
	{
		boolean salir = false;
		while(!salir)
		{
			try {
				
					String tarea=null;
					System.out.println("Tareas disponibles para agregar al trabajo: ");
					for(String op : opciones)
					{
						System.out.println("-"+op);
					}
					System.out.print("Cual deseas agregar? ");
					tarea = sc.nextLine();
					if(opciones.contains(tarea))
					{
						tareas.add(tarea);
						System.out.println("Se agrego la tarea");
						int indice = opciones.indexOf(tarea);
					    opciones.remove(indice);
					}
					else
					{
						System.out.println("Aun no existe esa opcion de tarea");
					}
					
					
					if(opciones.isEmpty())
					{
						salir=true;
						System.out.println("YA NO HAY MAS TAREAS QUE AGREGAR");
					}
					else
					{
						System.out.println("Terminaste de agregar tareas? \n 1.Si \n 2.No");
						System.out.print("Opcion: ");
						int opcion = Integer.parseInt(sc.nextLine());
						if(opcion== 1)
						{
							salir=true;
						}
					}
			   }
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Tareas declaradas \n");
		for(String tareas: tareas)
		{
			System.out.println("-" + tareas);
		}
		System.out.println();
	}

	public void opcionesDefinidas()
	{
		op = new String[] {"resumen","investigacion","imagenes","juntar"};
		for(int i=0;i<op.length;i++)
		{
			opciones.add(op[i]);
		}
	}
}
