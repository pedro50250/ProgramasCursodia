package Sesion5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class Lector {

	public static void main(String[]args)
	{
		String p= "Files/sumas.txt";
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
					System.out.println("El string leido es" + linea);
					String[] Lactual = linea.split(",");
					int A = Integer.parseInt(Lactual[0]);
					int B = Integer.parseInt(Lactual[1]);
					System.out.println("El rsultado de la linea " + (i+1)+" es igual a "+ (A+B));
					i++;
				}
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
		}
		else
		{
			JOptionPane.showMessageDialog(null, "El archivo no existe");
		}
	}
		
}
