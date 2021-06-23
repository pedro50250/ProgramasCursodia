package Sesion5;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class ImprimirArchivo {
	public static void main(String[] args) {

		String p = "Files/texto.txt";
		Path ruta = Paths.get(p);
		try {
			
			Writer writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(p),"utf-8"));
			String linea = JOptionPane.showInputDialog("Escribir: ");
			writer.write(linea);
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
