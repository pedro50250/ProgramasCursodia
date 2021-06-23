package Sesion3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class SubirAFTP {

	public static void main(String[] args)
	{
		FTPClient client = new FTPClient();
		FileInputStream fis = null;
		try
		{
			client.connect("25.81.51.142");
			client.login("DiplomadoJ14B", "Cursodia");
			client.setFileType(FTP.BINARY_FILE_TYPE);
			client.enterLocalPassiveMode();
			//Creando un InputStream del archivo a subir
			String filename = "imagen.jpg";
			File archivo = new File(filename);
			InputStream flujoEntrada = new FileInputStream(archivo);
			//Guardar el archivo en el servidor y salir
			boolean confirmacion= client.storeFile(filename, flujoEntrada);
			if(confirmacion)
			{
				System.out.println("Archivo Subido");
			}
			else
			{
				throw new IllegalStateException("Carga del archivo fallida");
			}
			
			client.logout();
			System.out.println("Archivo Subido correctamente");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(fis!= null) fis.close();
				client.disconnect();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
