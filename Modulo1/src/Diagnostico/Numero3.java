package Diagnostico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class Numero3 {
	int numPorCarpeta;

	public static void main(String[]args)
	{
		Numero3 num3 = new Numero3();
		num3.buscarCarpeta();
	}
	private void buscarCarpeta()
	{
		boolean salir=false;
		String nombre;
		Scanner sc = new Scanner(System.in);
		while(!salir)
		{
			System.out.println("Ingrese el nombre o ruta de acceso de la carpeta  a la cual quiere entrar: ");
			buscarArchivo();
			System.out.println("Desea salir?" + "1. Si   2.No");
			System.out.print("Opcion: ");
			int opcion = Integer.parseInt(sc.nextLine());
			if(opcion==1)
			{
				salir = true;
			}
			numPorCarpeta=0;
	   }
    }

	private void buscarArchivo()
	{
		
		Scanner sc = new Scanner(System.in);
		File archivoSeleccionado;
		JFileChooser seleccionarArchivo = new JFileChooser(System.getProperty("user.dir"));;
	    seleccionarArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    seleccionarArchivo.showOpenDialog(null);
	    archivoSeleccionado = seleccionarArchivo.getSelectedFile();
		String nombreCarpeta =seleccionarArchivo.getName(archivoSeleccionado);
		File carpeta = new File(nombreCarpeta);
		if(carpeta.exists())
		{
			String[] listado = carpeta.list();
			File[]archivos = carpeta.listFiles();
			if (listado == null || listado.length == 0) {
				System.out.println("No hay elementos dentro de la carpeta " + nombreCarpeta);
			}
			else 
			{
				System.out.print("Ingrese la palabra que quiere buscar en los archivos: ");
				String palabraBuscada = sc.nextLine();
				for (int i = 0; i < archivos.length; i++) {
			     	System.out.println("Archivo: " + archivos[i].getName() );
			     	buscarPalabras(nombreCarpeta,archivos[i].getName(),palabraBuscada);
			     	System.out.println();
				}
				System.out.println("El numero final de veces encontradas en esta capeta fue de: " +numPorCarpeta);
			}
		}
		else
		{
			System.out.println("Esa carpeta no existe");
		}
		
	}
	
	private void buscarPalabras(String nombreCarpeta ,String nombreArchivo,String palabra)
	{
		ArrayList<Integer> lineas = new ArrayList<Integer>();
		ArrayList<Integer> veces = new ArrayList<Integer>();
		String p= nombreCarpeta +"/" + nombreArchivo;
		Path ruta = Paths.get(p);
		
		if(Files.exists(ruta))
		{
			try
			{
				
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(p),"utf-8"));
				String linea= null;
				int i=0;
				while((linea = br.readLine())!=null)
				{
					String[] Palabra_Actual = linea.split(" ");
					for(int j=0; j<Palabra_Actual.length ; j++)
					{
						if(Palabra_Actual[j].equals(palabra))
						{
							veces.add(j);
							if(lineas.contains(i))
							{
								
							}
							else
							{
								lineas.add(i);
							}
						}
					}
					i++;
				}
				System.out.println("La palabra" + palabra + " se encontro en este archivo: " + veces.size() +" veces en las lineas: ");
				for( i=0; i<lineas.size();i++)
				{
					System.out.print(lineas.get(i) + ", ");
				}
				System.out.println();
				br.close();
			}
			catch(UnsupportedEncodingException | FileNotFoundException e ) {
				e.printStackTrace();
			}
			catch(NumberFormatException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			numPorCarpeta = numPorCarpeta + veces.size();
		}
		else
		{
			System.out.println("El archivo no existe");
			//JOptionPane.showMessageDialog(null, "El archivo no existe");
		}
	}
} 
