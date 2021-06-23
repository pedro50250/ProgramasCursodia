package Sesion1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		Socket s = null;
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(5678);
		while (true) {
			try {
				// el ServerSocket me da el Socket
				s = ss.accept();
				// informacion en la consola
				System.out.println("Se conectaron desde la IP: " + s.getInetAddress());
				// enmascaro la entrada y salida de bytes
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
		//////////////////////////////////////////////////////////////////////////////////////////////////////
				
				
				// LEO EL MENSAJE QUE MANDO EL CLIENTE EN OIS
				int num1 = (int) ois.readObject();
				int num2 = (int) ois.readObject();
				// SE PREPARA LA RESPUESTA
				int fac1=1;
				for(int i=1;i<=num1;i++) {
					fac1=fac1*i;
				}

				int fac2=1;
				for(int i=1;i<=num2;i++) {
					fac2=fac2*i;
				}
				
				System.out.println("Factorial 1: "+fac1);
				System.out.println("Factorial 2: "+fac2);
				
				//eSE ENVIA LA RESPUESTA
				oos.writeObject(fac1);
				oos.writeObject(fac2);
				System.out.println("Factoriales enviados...");
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (oos != null) oos.close();
				if (ois != null) ois.close();
				if (s != null)   s.close();
				
				System.out.println("Conexion cerrada!\n");
			}
		}
	}
}
