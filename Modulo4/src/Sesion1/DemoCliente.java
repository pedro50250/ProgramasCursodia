package Sesion1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DemoCliente {

	public static void main(String[] args) throws Exception {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Socket s = null;
		try {
			// instancio el server con la IP y el PORT
			s = new Socket("25.81.54.154", 5432);
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			// envio un nombre
			oos.writeObject("Pedro");
			// recibo la respuesta (el saludo personalizado)
			String ret = (String) ois.readObject();
			// muestro la respuesta que envio el server
			System.out.println(ret);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ois != null) ois.close();
			if (oos != null) oos.close();
			if (s != null) s.close();
		}
	}
}
