package TareaSesion2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class cliente {
	int puertoRemoto = 5432;
	int puertoLocal = 666;
	String ipRemota = "25.81.58.223";
	String nombre = "Andres";
	String nomServer = "";

	public static void main(String[] args) throws Exception {
		cliente cli = new cliente();
		cli.conectar();
		cli.recibirNombre();
		cli.abrirHilo();
		cli.enviarMensajes();

	}

	private void conectar() {
		// TRY QUE MANDA LOS DATOS DEL CLIENTE CONECTADO
		try {

			@SuppressWarnings("resource")
			Socket s = new Socket(ipRemota, puertoRemoto); // CONECTA CON LA IP DEL SERVER Y EL PUERTO
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());// INSTANCIA LA SALIDA DE DATOS

			oos.writeObject(nombre);// ENVIA EL NOMBRE
			oos.close(); // CIERRA EL FLUJO PARA ABRIRLO EN EL WHILE
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void recibirNombre() {
		try {
			ServerSocket ss = new ServerSocket(puertoLocal); // ABRE EL PUERTO
			System.out.println("Esperando Conexion");

			Socket s = ss.accept(); // AL RECIBIR UNA CONEXION LA ACEPTA
			String ip = "" + s.getInetAddress(); // SACA LA IP DEL CLIENTE CONECTADO
			System.out.println("IP CORREGIDA: " + ip.replace("/", ""));

			ObjectInputStream ois = new ObjectInputStream(s.getInputStream()); // LEE EL MENSAJE QUE CONTIENE EL NOMBRE
																				// DEL CLIENTE
			nomServer = (String) ois.readObject(); // SE GUARDA EL NOMBRE
			System.out.println("Se conecto " + nomServer + " desde la IP: " + s.getInetAddress()); // SE IMPRIME
			ss.close();// CIERRA EL SOCKET PARA ABRIRLO AHORA EN EL HILO

		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void enviarMensajes() {
		// WHILE QUE MANTIENE VIVO LA OPCION DE MANDAR MENSAJES
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in); // ABRE EL SCANNER DE TECLADO

			while (true) {
				@SuppressWarnings("resource")
				Socket s = new Socket(ipRemota, puertoRemoto); // VUELVE A CONECTARSE AL SERVER

				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream()); // ABRE EL FLUJO DE DATOS DE
																						// SALIDA

				String nom = sc.nextLine();
				oos.writeObject(nom);
				oos.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private void abrirHilo() {
		serverHilo sh = new serverHilo(this.puertoLocal, this.nomServer);
	}

}
	

