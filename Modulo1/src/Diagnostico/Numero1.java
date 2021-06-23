package Diagnostico;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class Numero1 {

	public static void main(String[]args)
	{
		Numero1 listas = new Numero1();
		listas.elegirCarpeta();

	}
	
	private void elegirCarpeta()
	{
		boolean salir=false;
		String nombre;
		Scanner sc = new Scanner(System.in);
		while(!salir)
		{
			System.out.println("Seleccione la carpeta a la cual quiere entrar: ");
			mostrarContenido();
			System.out.println("Desea salir?" + "1. Si   2.No");
			System.out.print("Opcion: ");
			int opcion = Integer.parseInt(sc.nextLine());
			if(opcion==1)
			{
				salir = true;
			}
			
		}
	}
	
	private void mostrarContenido()
	{
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
				System.out.println("No hay elementos dentro de la carpeta actual");
			}
			else 
			{
				for (int i = 0; i < archivos.length; i++) {
			     	System.out.println("nombre: " + archivos[i].getName() + " tamaño: " + archivos[i].length() + " bytes");
				}
			}
		}
		else
		{
			System.out.println("Esa carpeta no existe");
		}
		
	}
}
