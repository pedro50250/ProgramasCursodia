package TareaSesion2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class clienteHilo extends Thread {

	int puertoLocal;
	
	String nomCliente;
	

	public clienteHilo(int puertoLocal, String nomCliente) {
		this.puertoLocal=puertoLocal;
		this.nomCliente=nomCliente;
		Thread hilo = new Thread(this);
		hilo.start();
	}
	
	public void run() {
		System.out.println("Hilo abierto");
		try {
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(puertoLocal);
			while(true) {
				try {
					Socket s=ss.accept();
					ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
					String mensaje = (String) ois.readObject();
					System.out.println(nomCliente+" dice: "+ mensaje);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
