package Sesion3;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class descargarURL {

	public static void main(String[] args) {
		
		//String url = "http://www.cursodia.com.mx/CursodiaSite/cursos/img2/Java12.jpg";
		String url = "https://upload.wikimedia.org/wikipedia/commons/e/ea/Logo_Grupo_Imagen_Multimedia.2016.png";
		try
		{
			downloadUsingNIO(url, "descargas/Java12.png");
			//downloadUsingStream(url, "descargas/Java12.png");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private static void downloadUsingStream(String urlStr, String file) throws IOException
	{
		URL url = new URL(urlStr);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fos = new FileOutputStream(file);
		byte [] buffer = new byte[1024];
		int count =0;
		while((count = bis.read(buffer,0,1024))!= -1)
		{
			fos.write(buffer,0,count);
		}
		System.out.println("Se descrago correctamente");
		fos.close();
		bis.close();
	}
	
	public static void downloadUsingNIO(String urlStr, String file) throws IOException
	{
		URL url = new URL(urlStr);
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(file);
		System.out.println("Se descargo corectamente");
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
	}

}
