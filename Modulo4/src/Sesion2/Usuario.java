package Sesion2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Usuario implements Runnable {

	String nombre ="Pedro";
	boolean conectado= true;
	int puertoLocal;
	int puertoRemoto=777;
	String ip;
	Socket s = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	
	public void run() {
		try {
			inicializar();
		} catch (IOException e1) {
		}
		while(conectado) {
			
			try {
				Thread.sleep(1000);
				System.out.println("Esperando");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void inicializar() throws IOException {
		System.out.println(nombre+" ha entrado al chat");
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(this.puertoRemoto);
		while (true) {
			try {
				// el ServerSocket me da el Socket
				s = ss.accept();
				// informacion en la consola
				System.out.println("Se conectaron desde la IP: " + s.getInetAddress());
				// enmascaro la entrada y salida de bytes
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
			}
			catch(Exception e)
			{
				
			}
		}
	}

}