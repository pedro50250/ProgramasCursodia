package Tarea;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Alumno extends Thread{

	String nombres[] = new String[] {"Alejandro","Amanda","Roman","Antonio","Perla","Julia","Teresa","Silvia","Jorge","Pedro","Juan"
			,"Angel","Mario","Pancho"};
	String miNombre;
	String miTarea;
	int miEdad;
	boolean conectado = true;
	Scanner sc = new Scanner(System.in);
	boolean  tareaActiva = false;
	boolean ocupado = false;
	boolean participo = false;
	long tiemSel=0;
	long inicio = 0;
	long tiempo_preguntado;
	String red="\033[31m";
	
	public void run()
	{
		inicializar();
		while(conectado)
		{
			// se verifica si se esta realizando una tarea
			verificarTarea();
		}
		System.out.println(miNombre + " dice:" + "adios!");
	}
	
	//En este metodo se le asigna un nombre a cada hilo
	private void inicializar()
	{
		Random ran = new Random();
		int sel = ran.nextInt(nombres.length);
		miNombre = nombres[sel];
		System.out.println(miNombre + " a entrado al chat...");
	}
	
	//Se evalua la linea que se envio para tomar acciones
	public void evaluar(String linea,ArrayList<String>tareas)
	{
		//Se crea un array de palabras que estan separadas por un espacio
		String[] palabras = linea.split(" ");
		//Se pregunta si la primer palabra de el array es igual a miNombre
		if(palabras[0].equals(miNombre))
		{
			if(participo==false)
			{
				int indice=0;
			//Si si fue mi nombre se concatenan todas las palabras y evaluamos la oracion que se forma
			String lineaaEvaluar =  palabras[1];
			for(int i =2;i<palabras.length ; i++)
			{
				lineaaEvaluar +=" "+ palabras[i];
			}
			
			//Si la oracion nos pide hacer el resumen
			if(lineaaEvaluar.equals("haz el resumen"))
			{
				//Se busca el indice del resumen dentro del arrayList donde estan todas las tareas
				indice= tareas.indexOf("resumen");
				//Si no se encuentra esa tarea se van a imprimir unicamente las que declaramos y pasamos como parametro
				// a este metodo
				if(indice== -1)
				{
					System.out.println(miNombre + " Dice: no declaraste esa tarea");
					System.out.println("Solamente declaraste: \n");
					for(String tarea: tareas)
					{
						System.out.println(tarea);
					}
					System.out.println();
				}
				else
				{
					//Si no esta ocupado le asignamos la tarea solicitada
					if(ocupado==false)
					{
						miTarea= tareas.get(indice);
						System.out.println(miNombre + " dice: Empezando " + miTarea);
						tareaActiva=true;
						ocupado=true;
						 inicio = System.currentTimeMillis();
					}
					//Si esta ocupado nos dice que esta ocupado
					else
					{
						 tiempo_preguntado = System.currentTimeMillis();
						 double tiempo = (double) ((tiempo_preguntado - inicio)/1000);
						System.out.println(miNombre + " dice: estoy ocupado estoy haciendo: " + miTarea + " me faltan"
								+ ((tiemSel/1000) - tiempo)+ " segundos ");
					}
					
				}
			}
			
			//Si la oracion nos pide hacer la investigacion
			else if(lineaaEvaluar.equals("haz la investigacion"))
			{
				//Se busca el indice de la posicion en donde este la tarea investigacion
				indice = tareas.indexOf("investigacion");
				
				//Si no se encuentra la tarea nos muestra las que declaramos y pasamos como parametro a este metodo
				if(indice== -1)
				{
					System.out.println("Solamente declaraste: \n");
					for(String tarea: tareas)
					{
						System.out.println(tarea);
					}
					System.out.println();
				}
				//Si encuentra la tarea
				else
				{
					//Si no esta ocupado nos dice que empezara con la tarea
					if(ocupado==false)
					{
						miTarea= tareas.get(indice);
						System.out.println(miNombre + " dice: Empezando " + miTarea);
						tareaActiva=true;
						ocupado=true;
						 inicio = System.currentTimeMillis();
					}
					//Si esta ocupado nos dira que esta ocupado
					else
					{
						 tiempo_preguntado = System.currentTimeMillis();
						 double tiempo = (double) ((tiempo_preguntado - inicio)/1000);
						System.out.println(miNombre + " dice: esperate estoy ocupado estoy haciendo: " + miTarea + " me faltan"
								+ ((tiemSel/1000) - tiempo)+ " segundos ");
					}
				}
				
			}
			
			//Si la oracion nos pide busca imagenes
			else if(lineaaEvaluar.equals("busca imagenes"))
			{
				//Se busca el indice de imagenes en el arrayList de tareas que pasamos como parametro
				indice = tareas.indexOf("imagenes");
				//Si no se encuentra la tarea en el arrayList nos muestra unicamente las que si estan declaradas
				if(indice== -1)
				{
					System.out.println("Solamente declaraste: \n");
					for(String tarea: tareas)
					{
						System.out.println(tarea);
					}
					System.out.println();
				}
				//Si se encuentra la tarea
				else
				{
					//Si no esta ocupaso empieza a hacer la tarea
					if(ocupado==false)
					{
						miTarea= tareas.get(indice);
						System.out.println(miNombre + " dice: Empezando " + miTarea);
						tareaActiva=true;
						ocupado=true;
						 inicio = System.currentTimeMillis();
					}
					//Si esta ocupado nos dira que esta ocupado
					else
					{
						 tiempo_preguntado = System.currentTimeMillis();
						 double tiempo = (double) ((tiempo_preguntado - inicio)/1000);
						System.out.println(miNombre + " dice: estoy ocupado estoy haciendo: " + miTarea + " me faltan"
								+ ((tiemSel/1000) - tiempo)+ " segundos ");
					}
				    
				}
			}
			
			//Si la linea nos pide juntar todo 
			else if(lineaaEvaluar.equals("te toco juntar"))
			{
				//Se busca el indice de la tarea en el ArrayList
				indice = tareas.indexOf("juntar");
				//Si no se encuentra la tarea nos mostrara solamente las tareas antes declaradas
				if(indice== -1)
				{
					System.out.println("Solamente declaraste: \n");
					for(String tarea: tareas)
					{
						System.out.println(tarea);
					}
					System.out.println();
				}
				//Si se encuentra
				else
				{
					//Si no esta ocupado empieza la tarea
					if(ocupado==false)
					{
						miTarea= tareas.get(indice);
						System.out.println(miNombre + " dice: Empezando " + miTarea);
						tareaActiva=true;
						ocupado=true;
						 inicio = System.currentTimeMillis();
					}
					//Si esta ocupado nos dira que esta ocupado
					else
					{
						 tiempo_preguntado = System.currentTimeMillis();
						 double tiempo = (double) ((tiempo_preguntado - inicio)/1000);
						System.out.println(miNombre + " dice: estoy ocupado estoy haciendo: " + miTarea + " me faltan"
								+ ((tiemSel/1000) - tiempo)+ " segundos ");
					}
				    
				}
			}
			else if(lineaaEvaluar.equals("como vas?"))
			{
				
					 tiempo_preguntado = System.currentTimeMillis();
					 double tiempo = (double) ((tiempo_preguntado - inicio)/1000);
					System.out.println(miNombre + " dice: estoy ocupado estoy haciendo: " + miTarea + " me faltan"
							+ ((tiemSel/1000) - tiempo)+ " segundos ");
			}
			//Si el comando es distinto al establecido nos dira cuales son los comandos disponibles
		    else
			{
				System.out.println("Ese comando aun no esta establecido, los comandos establecidos son:"
						+ "\n *nombre* haz el resumen"
						+ "\n *nombre* haz la investigacion"
						+ "\n *nombre* busca imagenes"
						+ "\n *nombre* te toco juntar "
						+ "\n *nombre* como vas?");
			}
			
		  }
		 else
		 {
			 if(conectado == false)
			 {
				 System.out.println(miNombre + " ya no se encuentra conectado");
			 }
			 else
			 {
				 System.out.println(miNombre + " dice: Yo ya hice " + miTarea);
				 System.out.println(miNombre + "dice: Ya me voy adios");
				 conectado= false;
			 }
			 
		 }
			
		}
		
		//Si escribes adios y el nombre se desconecta
		if(linea.equals("adios " + miNombre))
		{
			conectado = false;
		    sc.close();
		}
		
		
		
	}
	//Metodo para salir del programa
	public void salir()
	{
		sc.close();
		conectado=false;
	}
	
	//Metodo para verificar si se esta haciendo una tarea
	private void verificarTarea()
	{
		//Si tiene una tarea activa
		if(tareaActiva == true)
		{
			//Si se encuentra ocupado
			if(ocupado==true)
			{
				//Se genera un numero random para el tiempo que se taradara en hacer la tarea
				Random ran = new Random();
				 tiemSel = 45000 +  ran.nextInt(78000);
				         try 
				         {
							Alumno.sleep(tiemSel);
							System.out.println(miNombre + " ya acabe con: " + miTarea + " tarde: " + tiemSel/1000 + "seg");
						
						     tareaActiva=false;
						     ocupado= false;
						     participo=true;
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							System.out.println("Ocurrio un error al hacer la tarea");
							e.printStackTrace();
						}
						
		     }
		}
	  }
	}



