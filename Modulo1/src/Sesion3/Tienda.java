package Sesion3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tienda {

	ArrayList<Articulo> articulos = new ArrayList<Articulo>();
	
	public static void main(String[] args)
	{
		Tienda t1 = new Tienda();
		t1.leerArticulos();
		t1.menu();
	}

	
	private void menu()
	{
		Scanner sc = new Scanner(System.in);
		boolean salir= false;
		while(!salir)
		{
			System.out.println("Eliga una opcion: \n" + "1. Agregar otro Articulo \n"
					+ "2. Mostrar Articulos \n "
					+ "3. Borrar Articulo \n "
					+ "4. Actualizar Articulo \n"
					+ "5. Salir");
			System.out.print("Opcion: ");
			int opcion = Integer.parseInt(sc.nextLine());
			switch(opcion)
			{
			
			case 1: leerArticulos();
					break;
			
			case 2: imprimirArticulos();
					break;
			
			case 3: borrarArticulo();
					break;
					
			case 4: editarArticulo();
					break;
					
			case 5: salir = true;
					break;
			}
		}
	}
	
	
	private void leerArticulos()
	{
		boolean nuevo = true;
		Scanner sc = new Scanner(System.in);
		do
		{
			try {
				System.out.print("Clave de producto: ");
			int cve = Integer.parseInt(sc.nextLine());
			System.out.print("Nombre del producto: ");
			String nom = sc.nextLine();
			System.out.print("Precio del producto: ");
			float precio = Float.parseFloat(sc.nextLine());
			System.out.print("Indique la categoria: ");
			int cat = Integer.parseInt(sc.nextLine());
			articulos.add( new Articulo(cve,nom,precio,cat)); 
			}
			catch(Exception e)
			{
				System.out.println("ERROR al ingresar los datos del articulo,"
						+ "recuerda de poner los valores correctamente");
				e.printStackTrace();
			}
			finally {
				System.out.println("Agregar nuevo articulo? 1. Si  2.No");
			int opcion = Integer.parseInt(sc.nextLine());
			if(opcion==1)
			{
				nuevo = true;
			}
			else
			{
				nuevo= false;
			}
			
			}
		}
		while(nuevo);
			
	}
	
	private void imprimirArticulos()
	{
		System.out.println("Clave \t\t Nombre \t\t Precio \t\t Categoria ");
		for(Articulo a : articulos)
		{
			System.out.println(a);
		}
	}
	
	private void borrarArticulo()
	{
		Scanner sc = new Scanner(System.in);
		imprimirArticulos();
		try {
			System.out.print("Indique la clave del producto a borrar: ");
			int art_borrar = Integer.parseInt(sc.nextLine());
			int i=0;
			int indice=0;
			for(Articulo a : articulos)
			{
				if(a.cve_art == art_borrar)
				{
					indice = i;
				}
				i++;
			}
			articulos.remove(indice);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la captura del elemento a borrar,"
					+ " verificar si existe en la lista y solo escribir valores numericos enteros");
			e.printStackTrace();
		}
	}
	
	private void editarArticulo()
	{
		Scanner sc = new Scanner(System.in);
		imprimirArticulos();
		System.out.print("Indique la clave del producto a editar: ");
		int art_editar = Integer.parseInt(sc.nextLine());
		int i=0;
		for(Articulo a : articulos)
		{
			if(a.cve_art == art_editar)
			{
				try
				{
					System.out.print("Clave de producto: ");
					int cve = Integer.parseInt(sc.nextLine());
					System.out.print("Nombre del producto: ");
					String nom = sc.nextLine();
					System.out.print("Precio del producto: ");
					float precio = Float.parseFloat(sc.nextLine());
					System.out.print("Indique la categoria: ");
					int cat = Integer.parseInt(sc.nextLine());
					Articulo nuevo = new Articulo(cve,nom,precio,cat);
					articulos.set(i, nuevo);
				}
				catch(Exception e)
				{
					System.out.println("ERROR al ingresar los datos del articulo,"
						+ "recuerda de poner los valores correctamente");
					e.printStackTrace();
				}
				
			}
			i++;
		}
		
	}
}
